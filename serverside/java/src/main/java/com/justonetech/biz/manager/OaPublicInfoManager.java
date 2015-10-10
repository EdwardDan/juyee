package com.justonetech.biz.manager;

import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.ImageUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.OaPublicInfoService;
import com.justonetech.biz.domain.DocDocumentAttach;
import com.justonetech.biz.domain.OaPublicInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.utils.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公告信息发布
 * User: Chen Junping
 * Date: 12-4-11
 */
@Service
public class OaPublicInfoManager {
    //是否仅显示置顶记录（0非置顶、1置顶、2全部）
    public final int IS_SHOW_TOP_FALSE = 0;
    public final int IS_SHOW_TOP_TRUE = 1;
    public final int IS_SHOW_TOP_ALL = 2;

    //图片类型
    public final String PIC_TYPE = "gif|jpg|png|bmp|tif";

    @Autowired
    private OaPublicInfoService oaPublicInfoService;

    @Autowired
    private DocumentManager documentManager;

    /**
     * 获取公告信息发布记录
     *
     * @param infoRange 发布范围：内部、外部
     * @param infoType  发布类型：公告、法规等
     * @param showCount 显示最多记录数
     * @return list
     */
    public List<OaPublicInfo> getPublicList(String infoRange, String infoType, int showCount) {
        return getPublicList(infoRange, infoType, showCount, IS_SHOW_TOP_ALL, false);
    }

    /**
     * @param infoRange .
     * @param infoType  .
     * @param showCount .
     * @param isShowTop 是否仅显示置顶记录（0非置顶、1置顶、2全部）
     * @param isNeedPic 是否必须有图片
     * @return .
     */
    public List<OaPublicInfo> getPublicList(String infoRange, String infoType, int showCount, int isShowTop, Boolean isNeedPic) {
        String hql = "from OaPublicInfo where (accessRange.code='{0}' or accessRange.code='{1}') and type.code='{2}' and isValid={3} and isPublic={4}";
//        if (isShowTop == IS_SHOW_TOP_TRUE || isShowTop == IS_SHOW_TOP_FALSE) {
//            hql += " and isTop={5}";
//        }
        hql += " order by isTop desc,reportDate desc,id desc";
        hql = FormatUtils.format(hql, infoRange, Constants.OA_PUBLIC_INFO_RANGE_ALL, infoType, Constants.FLAG_TRUE, Constants.FLAG_TRUE);
//        hql = FormatUtils.format(hql, infoRange, Constants.OA_PUBLIC_INFO_RANGE_ALL, infoType, Constants.FLAG_TRUE, Constants.FLAG_TRUE, String.valueOf(isShowTop));
        List<OaPublicInfo> list = oaPublicInfoService.findByQuery(hql);
        if (list.size() > showCount && showCount > 0) {
            return list.subList(0, showCount);
        } else {
            return list;
        }
    }

    /**
     * 置顶新闻 --如无置顶记录则取最新的一条记录
     *
     * @param infoType .
     * @return .
     */
    public Map<String, Object> getTopNews(String infoType) {
        Map<String, Object> news = new HashMap<String, Object>();

        if (StringHelper.isEmpty(infoType)) infoType = Constants.OA_PUBLIC_INFO_TYPE_BULLETIN;
        List<OaPublicInfo> oaPublicInfoList = getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, infoType, 1);
        if (oaPublicInfoList.size() > 0) {
            OaPublicInfo oa = oaPublicInfoList.iterator().next();
            news.put("id", oa.getId());
            news.put("contents", oa.getContent().replaceAll("<[a-zA-Z]+[1-9]?[^><]*>", "").replaceAll("</[a-zA-Z]+[1-9]?>", ""));
        }
        return news;
    }

    /**
     * 更新访问次数
     *
     * @param oaPublicInfo .
     */
    public void updateVisitTimes(OaPublicInfo oaPublicInfo) {
        oaPublicInfo.setVisitTimes(JspHelper.getLong(oaPublicInfo.getVisitTimes()) + 1);
        oaPublicInfoService.save(oaPublicInfo);
    }

    /**
     * 保存为缩略图,专用于公共信息发布
     */
    public String saveandgetThumbnailPath(HttpServletRequest request, OaPublicInfo target) {
        String userfiles = "/userfiles/image/";
        String ctx = request.getRealPath("");
        String imgpath = "";
        if (!FileUtils.exist(ctx + userfiles)) {//userfiles/image文件夹没有则新建
            FileUtils.mkDirs(ctx + userfiles);
        }
        long name = Calendar.getInstance().getTimeInMillis();
        String thumbnailPath = ctx + "/userfiles/image/" + target.getId() + "_" + name + ".jpg";
        String thumbnailPathtoSave = "/userfiles/image/" + target.getId() + "_" + name + ".jpg";
        //先将原缩略图删除
        if (target.getThumbnail() != null) {
            File f = new File(ctx + target.getThumbnail());
            FileUtils.removeDir(f);
        }
        //如果是展示图片
        if (target.getIconImage() != null) {
            Set<DocDocumentAttach> attachs = target.getIconImage().getDocDocumentAttachs();
            for (DocDocumentAttach attach : attachs) {
                imgpath = documentManager.getDocPath(attach.getDocument().getCategory(), "") + File.separator + attach.getSaveFileName();
                break;
            }
            if (FileUtils.exist(imgpath)) {
                //展示图片存在则压缩,由页面定宽高166*116
                ImageUtils.getThumbImage(imgpath, thumbnailPath, 166, 116, 1f);
                return thumbnailPathtoSave;
            } else {
                //图片不存在则取blob中
                return saveFromBlob(request, target, thumbnailPath, thumbnailPathtoSave);
            }
        } else {//不是展示图片则取blob中
            return saveFromBlob(request, target, thumbnailPath, thumbnailPathtoSave);
        }
    }

    /**
     * 保存为缩略图,取blob中数据
     */
    public String saveFromBlob(HttpServletRequest request, OaPublicInfo target, String thumbnailPath, String thumbnailPathtoSave) {
        String ctx = request.getRealPath("");
        Pattern p1 = Pattern.compile("src=\"(.+?).(" + PIC_TYPE + ")\"");//判断是不是gif或jpg等
        Pattern p2 = Pattern.compile("src=\"(.+?)\"");//取出src后面内容
        Matcher matcher = p1.matcher(target.getContent());
        String contextPath = request.getContextPath();
        if (matcher.find()) {//后缀名判断
            Matcher match = p2.matcher(target.getContent());
            if (match.find()) {//取第一个src内容
                String path = match.group(1);
                //注意：图片保存时将context也保存了，所以要去掉，否则找不到图片
                String picPath = path;
                if (!StringHelper.isEmpty(picPath) && !StringHelper.isEmpty(contextPath)) {
                    picPath = StringHelper.findAndReplace(picPath, contextPath + "/", "/");
                }
                if (FileUtils.exsistOnlyUrl(picPath)) {//如果是http图片则先保存再缩略图
//                    long name = Calendar.getInstance().getTimeInMillis();
//                    String filePath = "c:\\" + name + "\\";//临时保存的地址
                    String filePath = request.getRealPath("") + "/userfiles/temp/";//临时保存的地址

                    File delPath = new File(filePath);
                    try {
                        org.apache.commons.io.FileUtils.forceMkdir(delPath);
                    } catch (IOException e) {
                        System.err.println(e);
                        System.err.println("error:不能创建临时目录temp！");
                    }
//                    delPath.mkdir();
                    String fileName = FilenameUtils.normalize(filePath + target.getId() + ".jpg");
                    File file = new File(fileName);

//                    FileUtils.getUrlFile(picPath, fileName);//吧http图片保存到临时目录
                    try {
                        org.apache.commons.io.FileUtils.copyURLToFile(new URL(picPath), file, 10000, 10000);//连接10秒钟超时，读取10秒钟超时。
                    } catch (IOException e) {
                        System.err.println(e);
                        System.err.println("error:根据URL获取图片失败！");
                    }
                    ImageUtils.getThumbImage(fileName, thumbnailPath, 236, 188, 1f);//保存为jpg宽高由页面决定236*188
                    org.apache.commons.io.FileUtils.deleteQuietly(file);//删除临时目录
//                    FileUtils.removeDir(delPath);//删除临时目录
                } else {
                    if (FileUtils.exist(ctx + picPath)) {//如果不是http图片,是上传的图片
                        ImageUtils.getThumbImage(ctx + picPath, thumbnailPath, 236, 188, 1f);//保存为jpg宽高由页面决定236*188
                    } else {
                        return null;
                    }
                }
                return thumbnailPathtoSave;
            } else {
                return null;
            }
        }
        return null;
    }
}