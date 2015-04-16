package com.justonetech.biz.manager;

import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.DocCategoryService;
import com.justonetech.biz.daoservice.DocDocumentAttachService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.DocCategory;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.DocDocumentAttach;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * User: Chen Junping
 * Date: 12-3-22
 */
@Service
public class DocumentManager {
    private Logger logger = LoggerFactory.getLogger(DocumentManager.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocCategoryService docCategoryService;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private DocDocumentAttachService docDocumentAttachService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private ConfigManager configManager;

    private static final String TEMP_PATH = "temp";

    //上传按钮
    private final String UPLOAD_BUTTON = "<input type='button' value='附件' class='button_select' onclick=\"uploadDoc('{0}',$('#bizCode{5}'),$('#docId{5}'),'{3}','{4}')\"/>" +
            "<input type='hidden' name='docId{5}' id='docId{5}' value='{2}'/>" +
            "<input type='hidden' name='bizCode{5}' id='bizCode{5}' value='{1}'/>";

    //下载按钮
    private final String DOWNLOAD_BUTTON = "<input type='button' value='下载' class='button_doc' onclick=\"downloadDoc('{0}')\" title='{1}'/>";
    private final String DOWNLOADFILE_BUTTON = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"downloadDoc('{0}')\">{1}</a><br/>";

    /**
     * 获取业务文档
     *
     * @param bizCode .
     * @return .
     */
    public DocCategory findCategoryByBizCode(String bizCode) {
        List<DocCategory> list = docCategoryService.findByQuery("from DocCategory where bizCode ='" + bizCode + "'");
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 获取附件存储路径
     *
     * @param docCategory
     * @param secondDir
     * @return
     */
    public String getDocPath(DocCategory docCategory, String secondDir) {
        String path = configManager.getFilePath() + docCategory.getPath();
        if (!StringHelper.isEmpty(secondDir)) {
            path += File.separator + secondDir;
        }
        return path;
    }

    /**
     * 获取文件存放的临时路径
     *
     * @return
     */
    public String getTempPath() {
        return configManager.getFilePath() + TEMP_PATH;
    }

    /**
     * 获取上传附件按钮
     *
     * @param xmlConfig 默认配置
     * @param bizCode   文档业务编码
     * @param document  文档对象
     * @param userId    当前用户id--可不传
     * @param secondDir 子目录
     * @return string
     */
    public String getUploadButton(String xmlConfig, String bizCode, DocDocument document, Long userId, String secondDir) {
        return getUploadButtonForMulti(xmlConfig, bizCode, document, userId, secondDir, "");
    }

    public String getUploadButtonForMulti(String xmlConfig, String bizCode, DocDocument document, Long userId, String secondDir, String suffix) {
        String button = "未设置文档目录";
        Long docId = null;
        if (document != null) {
            docId = document.getId();
        }
        if (docId != null) {
            button = FormatUtils.format(UPLOAD_BUTTON, "", bizCode, JspHelper.getString(docId), JspHelper.getString(userId), secondDir, suffix);
        } else {
            DocCategory category = findCategoryByBizCode(bizCode);
            if (category != null) {
                button = FormatUtils.format(UPLOAD_BUTTON, xmlConfig, bizCode, JspHelper.getString(docId), JspHelper.getString(userId), secondDir, suffix);
            }
        }
        return button;
    }

    /**
     * 获取下载附件按钮
     *
     * @param document
     * @return
     */
    public String getDownloadButton(DocDocument document) {
        String button = "";
        if (document == null) {
            return button;
        }
        Set<DocDocumentAttach> attachs = document.getDocDocumentAttachs();
        for (DocDocumentAttach attach : attachs) {
            button += FormatUtils.format(DOWNLOAD_BUTTON, String.valueOf(attach.getId()), attach.getFileName());
        }
        return button;
    }

    public String getDownloadButton(Long docId) {
        return getDownloadButton(getDocDocument(docId));
    }

    /**
     * 获取下载附件文件名显示
     *
     * @param document
     * @return
     */
    public String getDownloadFile(DocDocument document) {
        String button = "";
        if (document == null) {
            return button;
        }
        Set<DocDocumentAttach> attachs = document.getDocDocumentAttachs();
        for (DocDocumentAttach attach : attachs) {
            button += FormatUtils.format(DOWNLOADFILE_BUTTON, String.valueOf(attach.getId()), attach.getFileName());
        }
        return button;
    }


    /**
     * 获取文档对象
     *
     * @param docId
     * @return
     */
    public DocDocument getDocDocument(Long docId) {
        if (docId != null) {
            return docDocumentService.get(docId);
        }
        return null;
    }

    /**
     * 点击文档图标时自动创建文档记录
     *
     * @param xmlConfig
     * @param category
     * @return
     */
    public DocDocument createNewDocument(String xmlConfig, DocCategory category) {
        DocDocument document = new DocDocument();
        //获取文件目录
        document.setCategory(category);
        setDocByXmlConfig(xmlConfig, document);
        return document;
    }

    /**
     * 附件上传保存页面
     *
     * @param request .
     * @throws java.io.IOException .
     */
    public void uploadSave(HttpServletRequest request, String path, DocDocumentAttach attach) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        uploadSave(multipartRequest, path, attach, "file");
    }

    /**
     * 附件上传保存页面
     *
     * @param multipartRequest .
     * @throws java.io.IOException .
     */
    public void uploadSave(MultipartHttpServletRequest multipartRequest, String path, DocDocumentAttach attach, String name) throws Exception {
        CommonsMultipartFile multipartFile = (CommonsMultipartFile)
                multipartRequest.getFile(name);
        uploadSave(multipartFile, path, attach);

    }

    /**
     * 附件上传保存页面
     *
     * @param multipartFile 因为html5可能出现一个文件域上传多个文件 .
     * @throws java.io.IOException .
     */
    public void uploadSave(MultipartFile multipartFile, String path, DocDocumentAttach attach) throws Exception {
        String originalFileName = multipartFile.getOriginalFilename();

        //临时目录
        String dir = getTempPath();
        if (StringUtils.isNotEmpty(path)) {
            dir = path;
        }

        //todo 根据后缀过滤上传文件
        String fileext = FileUtils.getFileExt(originalFileName);
        if (!FileUtils.checkFileExt(originalFileName)) {
            throw new Exception("上传失败，文件后缀名不合法");
        }

        String fileName = null;
        String fullPathName = null;

        if (!StringHelper.isEmpty(originalFileName)) {
            //保存文件的名字为在上传的文件名字后面加上当前的时间毫秒数
            fileName = FileUtils.getFileWithoutExt(originalFileName) + "_" +
                    String.valueOf(System.currentTimeMillis()) + "." + fileext;
            fullPathName = dir + File.separator + fileName;
            File file = new File(fullPathName);
            if (!file.exists()) {
                file.mkdirs();
            }
            multipartFile.transferTo(file);
        }
        if (attach != null) {
            attach.setFileName(originalFileName);
            attach.setSaveFileName(fileName);
            attach.setFileSize(JspHelper.getDouble(multipartFile.getSize()));
        }
    }

    public String getPathByBizCode(String bizCode, String secondDir) {
        return configManager.getFilePath() + getRelatedPathByBizCode(bizCode, secondDir);
    }

    public String getRelatedPathByBizCode(String bizCode, String secondDir) {
        DocCategory category = findCategoryByBizCode(bizCode);
        return getRelatePathByCategory(category, secondDir);
    }

    public String getRelatePathByCategory(DocCategory category, String secondDir) {
        String path = TEMP_PATH;
        if (category != null) {
            path = category.getPath();
            if (!StringHelper.isEmpty(secondDir)) {
                path += File.separator + secondDir;
            }
        }
        return path;
    }

    /**
     * 附件信息
     *
     * @param attach
     * @param request
     * @param bizCode
     * @param secondDir
     * @return
     */
    public Map getAttachInfo(DocDocumentAttach attach, HttpServletRequest request, String bizCode, String secondDir) {
        String ctx = request.getContextPath();
        if (ctx.equals("/")) {
            ctx = "";
        }
        String tailHref = "&bizCode=" + bizCode + "&secondDir=" + secondDir;
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("attachmentId", attach.getId());
        info.put("name", attach.getFileName());
        info.put("size", attach.getFileSize());
        info.put("updateDate", attach.getUpdateDate() != null ? attach.getUpdateDate().toString() : "");
        info.put("createUser", attach.getCreateUser());

        if (FileUtils.isPicture(attach.getSaveFileName())) {
            String path = getRelatedPathByBizCode(bizCode, secondDir);
            String prevUrl = ctx + "/docCommon/displayPhoto.do?picturePath=" + path + "&pictureFileName=" + attach.getSaveFileName();
            info.put("thumbnail_url", prevUrl);
            info.put("url", prevUrl);
        } else {
            info.put("url", ctx + "/docCommon/downloadByAttachmentId.do?attachmentId=" + attach.getId() + tailHref);
        }
        info.put("delete_url", ctx + "/docCommon/delAttach.do?attachId=" + attach.getId() + tailHref);
        info.put("delete_type", "DELETE");
        return info;
    }

    public List<Map> getAttachInfoByDoc(DocDocument doc, HttpServletRequest request, String bizCode, String secondDir) {
        Set<DocDocumentAttach> attaches = doc.getDocDocumentAttachs();
        List<Map> attachsInfo = new ArrayList<Map>();
        for (DocDocumentAttach attach : attaches) {
            attachsInfo.add(getAttachInfo(attach, request, bizCode, secondDir));
        }
        return attachsInfo;
    }

    /**
     * 默认文档配置
     *
     * @return
     */
    public String getDefaultXmlConfig() {
        String deptId = "";
        String personName = "";
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            SysPerson person = sysUser.getPerson();
            if (person != null) {
                if (person.getDept() != null) {
                    deptId = String.valueOf(person.getDept().getId());
                }
            }
            personName = sysUser.getDisplayName();
        }
        String xmlconfig = "<code></code>" +    //编号
                "<name></name>" +                            //标题
                "<sourceDept>" + deptId + "</sourceDept>" +    //单位
                "<author>" + personName + "</author>" +    //作者
                "<keywords></keywords>" +                                 //关键字
                "<abstractcontent></abstractcontent>" +             //摘要
                "<description></description>" +                         //备注
                "<formatid></formatid>";        //文档格式

        try {
            xmlconfig = URLEncoder.encode(xmlconfig, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new RuntimeException(e.getMessage());
        }
        return xmlconfig;
    }

    /**
     * 删除附件
     *
     * @param id
     * @param bizCode
     * @param secondDir
     */
    public void delAttach(Long id, String bizCode, String secondDir) {
        if (id == null) {
            return;
        }
        DocDocumentAttach documentAttach = docDocumentAttachService.get(id);

        //最后再统一删除附件对应的实际文件是因为如果先删除物理文件，那么在删除数据库中对应的附件记录的时候出一场，物理文件将无法恢复
        File file = new File(getPathByBizCode(bizCode, secondDir) + File.separator + documentAttach.getSaveFileName());
        file.delete();
        docDocumentAttachService.delete(documentAttach);
    }

    /**
     * 删除文档及附件
     *
     * @param docId
     * @param secondDir
     */
    public void removeAllDoc(Long docId, String secondDir) {
        if (docId != null) {
            DocDocument doc = docDocumentService.get(docId);
            Set<DocDocumentAttach> attachs = doc.getDocDocumentAttachs();
            String docPath = getDocPath(doc.getCategory(), secondDir);
            for (DocDocumentAttach attach : attachs) {
                File file = new File(docPath + File.separator + attach.getSaveFileName());
                if (file.exists()) {
                    file.delete();
                }
                docDocumentAttachService.delete(attach);
            }
            docDocumentService.delete(doc);
        }
    }

    public void setDocByXmlConfig(String xmlconfig, DocDocument document) {
        if (StringUtils.isEmpty(xmlconfig)) {
            return;
        }

        try {
            xmlconfig = URLDecoder.decode(xmlconfig, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Long deptId = JspHelper.getLong(StringHelper.getElementValue(xmlconfig, "sourceDept"));
        if (deptId > 0) {
            document.setDept(sysDeptService.get(deptId));
        }
        document.setName(StringHelper.getElementValue(xmlconfig, "name"));

        document.setAuthor(StringHelper.getElementValue(xmlconfig, "author"));
        document.setKeywords(StringHelper.getElementValue(xmlconfig, "keywords"));
        document.setAbstractContent(StringHelper.getElementValue(xmlconfig, "abstractContent"));
        document.setDescription(StringHelper.getElementValue(xmlconfig, "description"));
    }

    /**
     * 将业务数据更新到文档挂接表中
     */
    public void updateDocumentByBizData(DocDocument docDocument, String code, String title, String author, String keyWords, String abstractContent, String description) {
        //todo 需补充
        docDocument.setCode(code);
        docDocument.setName(title);
        docDocument.setKeywords(keyWords);
        docDocument.setAbstractContent(abstractContent);
        docDocument.setDescription(description);
        docDocument.setAuthor(author);
        docDocumentService.save(docDocument);
    }

    public void updateDocumentByBizData(DocDocument docDocument, String code, String title) {
        updateDocumentByBizData(docDocument, code, title, null, null, null, null);
    }
}
