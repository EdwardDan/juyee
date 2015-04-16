package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yujun
 * Date: 12-9-12
 * Time: 上午9:14
 */
@Service
public class AndroidCommonManager {

    private Logger logger = LoggerFactory.getLogger(AndroidCommonManager.class);

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private DocDocumentAttachService docDocumentAttachService;

//    @Autowired
//    PollingRecordDetailService pollingRecordDetailService;
//
//    @Autowired
//    private PollingRecordService pollingRecordService;

    @Autowired
    private PollingUnlawfulProjectService pollingUnlawfulProjectService;

    @Autowired
    DocumentManager documentManager;

    //需要上传巡查监查图片的标识
    public static final String MARK_XC = "XC";
    //需要上传复查图片的标识
    public static final String MARK_FC = "FC";
    //需要上传移交图片的标识
    public static final String MARK_YJ = "YJ";
    //需要上传六无工地图片的标识
    public static final String MARK_SIXNO = "SIXNO";

    /**
     * 上传巡查监督图片
     */
    public void uploadPollingRecordDetailPhoto(Long id, HttpServletRequest request) throws Exception {
//        PollingRecordDetail pollingRecordDetail = pollingRecordDetailService.get(id);
//        DocDocument document = pollingRecordDetail.getPhotoDoc();
//        DocCategory category = documentManager.findCategoryByBizCode(PollingRecordDetail.class.getSimpleName());
//        if (document == null) {
//            document = documentManager
//                    .createNewDocument(documentManager.getDefaultXmlConfig(), category);
//            docDocumentService.save(document);
//            pollingRecordDetail.setPhotoDoc(document);
////            PollingRecord pollingRecord = CollectionUtils.getFirstEle(pollingRecordService.findByProperty("uuid", pollingRecordDetail.getUuid()));
////            pollingRecord.setRecordDoc(document);
//            pollingRecordDetailService.save(pollingRecordDetail);
//        }
//        // 上传图片
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        Iterator it = multipartRequest.getFileNames();
//        while (it.hasNext()) {
//            String name = (String) it.next();
//            List<MultipartFile> multipartFiles = multipartRequest.getFiles(name);
//            for (MultipartFile multipartFile : multipartFiles) {
//                DocDocumentAttach documentAttach = new DocDocumentAttach();
//                documentAttach.setDocument(document);
//
//                String docPath = documentManager.getDocPath(category, null);
//                documentManager.uploadSave(multipartFile, docPath, documentAttach);
//                docDocumentAttachService.save(documentAttach);
//            }
//        }
    } /**
     * 上传六无工地图片
     */
    public void uploadPollingUnlawfulProjectPhoto(Long id, HttpServletRequest request) throws Exception {
        PollingUnlawfulProject pollingUnlawfulProject = pollingUnlawfulProjectService.get(id);
        DocDocument document = pollingUnlawfulProject.getProjectDoc();
        DocCategory category = documentManager.findCategoryByBizCode(PollingUnlawfulProject.class.getSimpleName());
        if (document == null) {
            document = documentManager
                    .createNewDocument(documentManager.getDefaultXmlConfig(), category);
            docDocumentService.save(document);
            pollingUnlawfulProject.setProjectDoc(document);
            pollingUnlawfulProjectService.save(pollingUnlawfulProject);
        }
        // 上传图片
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator it = multipartRequest.getFileNames();
        while (it.hasNext()) {
            String name = (String) it.next();
            List<MultipartFile> multipartFiles = multipartRequest.getFiles(name);
            for (MultipartFile multipartFile : multipartFiles) {
                DocDocumentAttach documentAttach = new DocDocumentAttach();
                documentAttach.setDocument(document);
                String docPath = documentManager.getDocPath(category, null);
                documentManager.uploadSave(multipartFile, docPath, documentAttach);
                docDocumentAttachService.save(documentAttach);
            }
        }
    }

    public void uploadPhoto(String mark, Long id, HttpServletRequest request) throws Exception {
        if (MARK_XC.equals(mark)) {
            uploadPollingRecordDetailPhoto(id, request);
        } else if (MARK_FC.equals(mark)) {

        } else if (MARK_YJ.equals(mark)) {

        } else if (MARK_SIXNO.equals(mark)) {
            uploadPollingUnlawfulProjectPhoto(id, request);
        }
    }

}
