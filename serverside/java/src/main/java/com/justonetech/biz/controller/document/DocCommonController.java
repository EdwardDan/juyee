package com.justonetech.biz.controller.document;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.DocCategoryService;
import com.justonetech.biz.daoservice.DocDocumentAttachService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.DocCategory;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.DocDocumentAttach;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.FileUtils;
import flexjson.JSONSerializer;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * User: Chen Junping
 * Date: 12-3-22
 */
@Controller
public class DocCommonController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(DocCommonController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocDocumentAttachService docDocumentAttachService;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private DocCategoryService docCategoryService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private ConfigManager configManager;

    /**
     * 简单附件上传显示页面--必须使用框架页面，否则提交会弹出新页面
     *
     * @param model .
     * @returnn .
     */
    @RequestMapping
    public void init(@RequestParam(required = false) String filterFileExt, Model model) {
        if (filterFileExt == null) {
            filterFileExt = "";
        }
        model.addAttribute("filterFileExt", filterFileExt);
    }

    /**
     * 简单附件上传显示页面
     *
     * @param model .
     * @returnn .
     */
    @RequestMapping
    public String upload(@RequestParam(required = false) String filterFileExt, Model model) {
        if (filterFileExt == null) {
            filterFileExt = "";
        }
        model.addAttribute("filterFileExt", filterFileExt);
        model.addAttribute("selectName", filterFileExt.indexOf("jpg") >= 0 ? "图片" : "附件");

        return "view/document/common/upload";
    }

    /**
     * 简单附件上传保存页面
     *
     * @param request .
     * @param model   .
     * @return .
     * @throws java.io.IOException .
     */
    @RequestMapping
    public void uploadSave(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        CommonsMultipartFile multipartFile = (CommonsMultipartFile)
                multipartRequest.getFile("file");
        String originalFileName = multipartFile.getOriginalFilename();

        //临时目录
        String dir = documentManager.getTempPath();


        //todo 根据后缀过滤上传文件
        String fileext = FileUtils.getFileExt(originalFileName);
        if(!FileUtils.checkFileExt(originalFileName)){
             sendErrorJSON(response,"上传失败，文件后缀名不合法");
        }else{
            String fileName = null;
            if (!StringHelper.isEmpty(originalFileName)) {
                //保存文件的名字为在上传的文件名字后面加上当前的时间毫秒数
                fileName = FileUtils.getFileWithoutExt(originalFileName) + "_" +
                        String.valueOf(System.currentTimeMillis()) + "." + fileext;
                File file = new File(dir + File.separator + fileName);
                if (!file.exists()) {
                    file.mkdirs();
                }
                multipartFile.transferTo(file);
            }
            sendSuccessJSON(response, "上传成功");
        }
    }

    /**
     * 上传页面
     *
     * @param request   .
     * @param response  .
     * @param xmlConfig .
     * @param bizCode   .
     * @param docId     .
     * @param secondDir .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String add(HttpServletRequest request, HttpServletResponse response,
                      String xmlConfig, String bizCode, Long docId, String secondDir, Model model) {
        model.addAttribute("xmlConfig", xmlConfig);
        model.addAttribute("bizCode", bizCode);
        if (docId != null && bizCode == null) {
            model.addAttribute("bizCode", docDocumentService.get(docId).getCategory().getBizCode());
        }
        model.addAttribute("docId", docId);
        model.addAttribute("secondDir", secondDir);
        model.addAttribute("canEdit", true);
        return "view/document/common/fileUpload";
    }

    /**
     * 查看页面
     *
     * @param request   。
     * @param response  。
     * @param xmlConfig 。
     * @param bizCode   。
     * @param docId     。
     * @param secondDir 。
     * @param model     。
     * @return 。
     */
    @RequestMapping
    public String view(HttpServletRequest request, HttpServletResponse response,
                       String xmlConfig, String bizCode, Long docId, String secondDir, Model model) {
        model.addAttribute("xmlConfig", xmlConfig);
        model.addAttribute("bizCode", bizCode);
        if (docId != null && bizCode == null) {
            model.addAttribute("bizCode", docDocumentService.get(docId).getCategory().getBizCode());
        }
        model.addAttribute("docId", docId);
        model.addAttribute("secondDir", secondDir);
        model.addAttribute("canEdit", false);
        return "view/document/common/fileUpload";
    }

    /**
     * 文件上传
     *
     * @param request   .
     * @param response  .
     * @param xmlConfig .
     * @param bizCode   .
     * @param docId
     * @param secondDir .
     * @param model     .
     * @throws IOException .
     */
    @RequestMapping
    public void uploadFile(HttpServletRequest request, HttpServletResponse response,
                           String xmlConfig, String bizCode, Long docId, String secondDir, Model model) throws Exception {
        DocDocumentAttach documentAttach = new DocDocumentAttach();
        if (docId != null) {
            documentAttach.setDocument(docDocumentService.get(docId));
        }

        String docPath = documentManager.getDocPath(documentManager.findCategoryByBizCode(bizCode), secondDir);
        documentManager.uploadSave(request, docPath, documentAttach);
        docDocumentAttachService.save(documentAttach);

        documentManager.getAttachInfo(documentAttach, request, bizCode, secondDir);

        sendJSON(response, "[" + new JSONSerializer().serialize(documentManager.getAttachInfo(documentAttach, request, bizCode, secondDir)) + "]");
    }

    /**
     * 获取附件列表
     *
     * @param request .           .
     * @param model   .            .
     * @throws java.io.IOException .  .
     */
    @RequestMapping
    public void getAttachFileList(Long docId, HttpServletResponse response, HttpServletRequest request,
                                  String bizCode, String secondDir, Model model) throws IOException {
        if (docId != null) {
            DocDocument docDocument = docDocumentService.get(docId);
            sendJSON(response, new JSONSerializer().serialize(documentManager.getAttachInfoByDoc(docDocument, request, docDocument.getCategory().getBizCode(), secondDir)));
        }
    }

    /**
     * 附件下载
     *
     * @param attachmentId .
     * @param request      .
     * @param response     .
     * @throws Exception .
     */
    @RequestMapping
    public void downloadByAttachmentId(@RequestParam Long attachmentId,
                                       String bizCode, String secondDir, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocDocumentAttach docDocumentAttach = docDocumentAttachService.get(attachmentId);

        DocCategory docCategory = docDocumentAttach.getDocument().getCategory();
        //获得附件存放的目录
        String dir = documentManager.getRelatePathByCategory(docCategory, secondDir);

        String saveFileName = docDocumentAttach.getSaveFileName();

//        PrintWriter writer;
        download(dir, saveFileName, docDocumentAttach.getFileName(), request, response);
    }

    /**
     * 下载页面
     *
     * @param attachFileDir    .
     * @param attachFileName   .
     * @param originalFileName .
     * @param request          .
     * @param response         .
     * @throws Exception .
     */
    @RequestMapping
    public void download(@RequestParam String attachFileDir, @RequestParam String attachFileName, String originalFileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        //获得附件存放的目录
        String path = configManager.getFilePath() + attachFileDir + File.separator;
        File file = new File(path + attachFileName);
        if (!file.exists()) {
            //必须设置编码否则返回的提示是乱码
            response.setContentType("text/html; charset=UTF-8");

            PrintWriter writer = response.getWriter();
            writer.print("<script language='JavaScript'>alert('");
            writer.print("对不起，本文件不存在!");
            writer.println("');</script>");
            return;
        }
        FileUtils.downloadSection(request, response, path + attachFileName, originalFileName, false);
    }



    /**
     * 显示上传图片
     *
     * @param request
     * @param response
     * @param picturePath
     * @param pictureFileName
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping
    public String displayPhoto(HttpServletRequest request, HttpServletResponse response, @RequestParam String picturePath, @RequestParam String pictureFileName, Model model) throws IOException {
        response.setContentType("image/*");

        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(pictureFileName.getBytes(), "ISO8859-1") + "\"");
        OutputStream outputStream = response.getOutputStream();
        //图片存放的路径，如果是已经保存在数据库中的话，那么通过
        if (StringHelper.isEmpty(pictureFileName)) {
            pictureFileName = "default.gif";
        }
        if(!StringHelper.isEmpty(picturePath)){
            if (picturePath.startsWith("/") || picturePath.startsWith("\\")) {
                picturePath = picturePath.substring(1);
            }
        }
        String path = configManager.getFilePath() + picturePath + File.separator + pictureFileName;

        InputStream inputStream;
        if (FileUtils.exist(path)) {
            inputStream = new FileInputStream(path);
            IOUtils.copy(inputStream, outputStream);
        } else {
            path = request.getSession().getServletContext().getRealPath("") + File.separator + "" + File.separator + Constants.SYS_NOPICTURE_PIC;
            inputStream = new FileInputStream(path);
            IOUtils.copy(inputStream, outputStream);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
        return null;
    }

    /**
     * 删除附件
     *
     * @param response  .
     * @param attachId  .
     * @param bizCode   .
     * @param secondDir .
     */
    @RequestMapping
    public void delAttach(HttpServletResponse response, Long attachId, String bizCode, String secondDir) {
        documentManager.delAttach(attachId, bizCode, secondDir);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param docId    .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long docId) throws Exception {
        if (docId != null) {
            DocDocument document = docDocumentService.get(docId);
            List<String> list = new ArrayList<String>();
            Set<DocDocumentAttach> set = document.getDocDocumentAttachs();
            if (set.size() > 0) {
                //todo need column:second dir
                String realPath = documentManager.getDocPath(document.getCategory(), "") + File.separator;
                for (DocDocumentAttach attach : set) {
                    list.add(JspHelper.getString(attach.getSaveFileName()));
                    docDocumentAttachService.delete(attach.getId());
                }
                String filePath = "";
                for (String fileName : list) {
                    filePath = realPath + fileName;
                    File file = new File(filePath);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                list = null;
            }

            docDocumentService.delete(docId);
        }
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 创建文档
     *
     * @param response  .
     * @param xmlConfig .
     * @param bizCode   .
     * @param docId     .
     * @param secondDir .
     */
    @RequestMapping
    public void getDocument(HttpServletResponse response, String xmlConfig, String bizCode, Long docId, String secondDir) {
        DocCategory category = documentManager.findCategoryByBizCode(bizCode);
        DocDocument document = documentManager.createNewDocument(xmlConfig, category);
        docDocumentService.save(document);
        sendJSON(response, JspHelper.getString(document.getId()));
    }

    /**
     * 删除文档，如果附件为空
     *
     * @param response .
     * @param docId    .
     */
    @RequestMapping
    public void getDelIsNull(HttpServletResponse response, Long docId) {
        if (docId != null) {
            DocDocument document = docDocumentService.get(docId);
            if (document.getDocDocumentAttachs().size() == 0) {
                try {
                    docDocumentService.delete(docId);
                    sendIsSuccessJSON(response, true);
                } catch (Exception e) {
                    System.out.println(e.getCause().getMessage() + ": 已关联记录");
                    sendIsSuccessJSON(response, false);
                }
                return;
            }
        }
        sendIsSuccessJSON(response, false);
    }

}
