package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaPetitionService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaPetition;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import jxl.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * note:信访管理
 * author: Stanley
 * create date: 2015-06-18
 * modify date: 2015-06-19
 */
@Controller
public class OaPetitionController extends BaseCRUDActionController<OaPetition> {
    private Logger logger = LoggerFactory.getLogger(OaPetitionController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private OperationMsgManager operationMsgManager;

    @Autowired
    private OaPetitionService oaPetitionService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_PETITION_EDIT));
        return "view/oa/oaPetition/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaPetition order by receiveDate desc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaPetitionService.findByPage(pageModel, query);
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        return modify(model, null);
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        OaPetition oaPetition = id != null ? oaPetitionService.get(id) : new OaPetition();
        model.addAttribute("status", Constants.OA_PETITION_STATUS);
        model.addAttribute("source", Constants.OA_PETITION_SOURCE);
        model.addAttribute("type", Constants.OA_PETITION_TYPE);
        model.addAttribute("uploadButtonDocument", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), OaPetition.class.getSimpleName(), oaPetition.getDoc(), sysUserManager.getSysUser().getId(), null, "Document"));
        model.addAttribute("bean", oaPetition);
        return "view/oa/oaPetition/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        model.addAttribute("downloadButtonDocument", documentManager.getDownloadButton(oaPetitionService.get(id).getDoc()));
        return modify(model, id).replace("input", "view");
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaPetition entity, HttpServletRequest request) throws Exception {
        try {
            OaPetition target;
            if (entity.getId() != null) {
                target = oaPetitionService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "person",
                        "tel",
                        "receiveDate",
                        "address",
                        "jbrName",
                        "endDate",
                        "content",
                        "dealResult",
                        "description"
                });
            } else {
                target = entity;
            }
            target.setStatus(sysCodeManager.getCodeListById(JspHelper.getLong(request.getParameter("status"))));
            target.setSource(sysCodeManager.getCodeListById(JspHelper.getLong(request.getParameter("source"))));
            target.setType(sysCodeManager.getCodeListById(JspHelper.getLong(request.getParameter("type"))));
            target.setStatusDesc(target.getStatus().getName());
            target.setSourceDesc(target.getSource().getName());
            target.setTypeDesc(target.getType().getName());
            if (StringHelper.isNotEmpty(request.getParameter("jbrId"))) {
                target.setJbrUser(sysUserService.get(JspHelper.getLong(request.getParameter("jbrId"))));
            }
            if (StringHelper.isNotEmpty(request.getParameter("docIdDocument"))) {
                logger.debug("request.getParameter(\"docIdDocument\") -----------> " + request.getParameter("docIdDocument"));
                target.setDoc(documentManager.getDocDocument(JspHelper.getLong(request.getParameter("docIdDocument"))));
                if (target.getDoc() != null) {
                    logger.debug("__________");
                    documentManager.updateDocumentByBizData(target.getDoc(), null, JspHelper.getString(target.getDoc().getName()));
                    logger.debug("@@@@@@@@@@@@@");
                }
            }
            oaPetitionService.save(target);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        oaPetitionService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

//    /**
//     * 获取excel文件上载列、对应表、映射refmap、映射refsql、唯一标识列列表信息
//     *
//     * @param model
//     * @param request
//     * @param response
//     * @return
//     */
//    @RequestMapping
//    public String excelOverview(Model model, HttpServletRequest request, HttpServletResponse response) {
//        try {
//            ExcelData excelData = new ExcelData(Workbook.getWorkbook(((MultipartHttpServletRequest) request).getFile("file").getInputStream()).getSheet(0));
//            model.addAttribute("excelData", excelData);
//            model.addAttribute("excelLoadHandler", JspHelper.getString(request.getParameter("excelLoadHandler")));
//            model.addAttribute("fileName", JspHelper.getString(request.getParameter("fileName")));
//        } catch (Exception e) {
//            e.printStackTrace();
//            super.processException(response, e);
//            sendFailureJSON(response, "解析Excel文件失败！请检查数据！");
//            return null;
//        }
//        return "common/excelOverview";
//    }
//
//    /**
//     * excel文件(支持测试模式)导入
//     *
//     * @param model
//     * @param request
//     * @param response
////     * @param excelData
//     * @return
//     */
//    @RequestMapping
//    public String excelLoad(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session/*, @ModelAttribute("excelData") ExcelData excelData*/) {
//        ExcelData xlsData1 = (ExcelData) request.getAttribute("excelData1");
//        ExcelData xlsData2 = (ExcelData) session.getAttribute("excelData2");
////        logger.debug("excelData  is null  ? constructed by default constructor ? " + (excelData == null));
//        logger.debug("xlsData1  is null  ? constructed by default constructor ? " + (xlsData1 == null));
//        logger.debug("xlsData2  is null  ? constructed by default constructor ? " + (xlsData2 == null));
//        if (xlsData1 != null) {
//            logger.debug(xlsData1.toString());
//            logger.debug("xlsData1   getData getTableMapping  " + xlsData1.getData().getColumns().toString() + "\t" + xlsData1.getTableMapping().getSrcColumns().toString());
//        }
//        if (xlsData2 != null) {
//            logger.debug(xlsData2.toString());
//            logger.debug("xlsData2   getData getTableMapping  " + xlsData2.getData().getColumns().toString() + "\t" + xlsData2.getTableMapping().getSrcColumns().toString());
//        }
//        ExcelData excelData = xlsData2;
//        String loadMode = JspHelper.getString(request.getParameter("loadMode"));
//        String ckmode = JspHelper.getString(request.getParameter("ckmode"));
//        logger.debug("loadMode  ckmode   ----->  " + loadMode + "\t" + ckmode);
//        boolean isTestMode = true, doInsert = false, doUpdate = false;
//        if (!StringHelper.equals(loadMode, "test")) {
//            isTestMode = false;
//        }
//        if (ckmode.contains("ckinsert")) {
//            doInsert = true;
//        }
//        if (ckmode.contains("ckupdate")) {
//            doUpdate = true;
//        }
//        Importer excelImporter = new Importer();
//        try {
//            excelImporter.setDataSource(DBUtil.getDataSource("", "192.168.1.86", 1522, "db11g", "jtjs_test", "jtjs_test"));
//            logger.debug("getData getTableMapping  " + excelData.getData() + "\t" + excelData.getTableMapping());
//            excelImporter.setData(excelData.getData());
//            excelImporter.setTableMapping(excelData.getTableMapping());
//            try {
//                excelImporter.doImport(doInsert, doUpdate, isTestMode);
//                model.addAttribute("xlLoadingResultInfo", excelImporter.getXlLoadingResultInfo());
//            } catch (Exception e) {
//                e.printStackTrace();
//                super.processException(response, e);
//                sendFailureJSON(response, "装载Excel文件失败！请检查数据！");
//                return null;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            super.processException(response, e);
//            sendFailureJSON(response, "装载Excel文件失败！请检查数据！");
//            return null;
//        }
//        logger.debug("isTestmode        @@@@@@@@@@@@  " + isTestMode);
//        if (isTestMode) {
//            model.addAttribute("ckmode", ckmode);
//            model.addAttribute("excelLoadHandler", JspHelper.getString(request.getParameter("excelLoadHandler")));
//            model.addAttribute("excelData", excelData);
////            sendSuccessJSON(response, "检查完毕！");
//            return "common/excelLoader";
//        }
////        sendSuccessJSON(response, "成功导入Excel文件！");
//        return operationMsgManager.successCloseMsg(model, "view/oa/oaPetition/grid", "成功导入Excel文件！");
//    }

//    /**
//     * 测试
//     * 【I】Excel文件转实体类(Bean | POJO)
//     * 【II】Excel文件转数据库对应表数据（类sql loader）目前支持Oracle
//     *
//     * @param request
//     * @param model
//     * @return
//     */
//    @RequestMapping
//    public String importExl2Entity(HttpServletRequest request, Model model) {
//        try {
//            LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
//            List<String> cnColNames = Arrays.asList(new String[]{"受理编号", "信访来源", "信访人", "收信日期", "创建时间", "经办人对象", "来源代码", "文档对象"});
//            List<String> enColNames = Arrays.asList(new String[]{"code", "sourceDesc", "person", "receiveDate", "createTime", "jbrUser", "source", "doc"});
//            for (int i = 0; i < cnColNames.size(); i++) {
//                fieldMap.put(cnColNames.get(i), enColNames.get(i));
//            }
//            LinkedHashMap<String, Class<? extends Serializable>> fieldAsPojoClassMap = new LinkedHashMap<String, java.lang.Class<? extends Serializable>>();
//            fieldAsPojoClassMap.put("jbrUser", SysUser.class);
//            fieldAsPojoClassMap.put("source", SysCodeDetail.class);
//            fieldAsPojoClassMap.put("doc", DocDocument.class);
////            List<OaPetition> oaPetitions = excelLoaderManager.excelToList(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\OaPetition_.xls")), OaPetition.class, fieldMap, fieldAsPojoClassMap);
//            List<OaPetition> oaPetitions = excelLoaderManager.excelToList(((MultipartHttpServletRequest) request).getFile("file").getInputStream(), OaPetition.class, fieldMap, fieldAsPojoClassMap);
//            logger.debug("Congrats !!!!!  You just imported and converted the excel of  " + oaPetitions.size() + " rows to Entity List oaPetitions successfully!!!!!!!!!!!!!!!!!!!!!!");
//            if (!oaPetitions.isEmpty()) {
//                for (OaPetition oaPetition : oaPetitions) {
//                    logger.debug("oaPetition == null ? " + (oaPetition == null) + "\t" + "oaPetition.getJbrUser()   getSource() getDoc()  == null ? " + (oaPetition.getJbrUser() == null) + "\t" + (oaPetition.getSource() == null) + "\t" + (oaPetition.getDoc() == null));
//                    if (oaPetition.getJbrUser() != null) {
//                        logger.debug("oaPetition.getJbrUser().getDisplayName()      >>>>>>>>>  " + oaPetition.getJbrUser().getDisplayName());
//                    }
//                    if (oaPetition.getSource() != null) {
//                        logger.debug("oaPetition.getSource().getName()      >>>>>>>>>  " + oaPetition.getSource().getName());
//                    }
//                    if (oaPetition.getDoc() != null) {
//                        logger.debug("oaPetition.getDoc().getName()      >>>>>>>>>  " + oaPetition.getDoc().getName());
//                    }
//                }
//            }
//            logger.debug("excel imported results in  " + excelLoaderManager.getXlLoadingResultInfo());
//            logger.debug("try the other way to resolve the excel data !!!!!!!");
//            LinkedHashMap<String, Class<?>> fieldTypeMap = new LinkedHashMap<String, Class<?>>();
//            String[] columnNames = StringHelper.stringToStringArray("id,code,status_id,status_desc,person,receive_date,jbr_user_id,jbr_name,content,update_time", ",");
//            Class[] columnClazzs = new Class[]{Long.class, String.class, Long.class, String.class, String.class, java.sql.Date.class, Long.class, String.class, String.class, java.sql.Timestamp.class};
//            logger.debug("columnNames length == columnClazzs length ? " + (columnNames.length == columnClazzs.length));
//            for (int i = 0; i < columnNames.length; i++) {
//                logger.debug("columnName    columnClazz     ----------->  " + columnNames[i] + "\t" + columnClazzs[i].getSimpleName());
//                fieldTypeMap.put(columnNames[i], columnClazzs[i]);
//            }
//            excelLoaderManager.excelToDBDataRough(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\OaPetition2_.xls")), "oa_petition", fieldTypeMap);
////            excelLoaderManager.excelToDBDataRough(multipartFile.getInputStream(), "oa_petition", fieldTypeMap);
//            logger.debug("excel imported in the other way results in ********************** " + excelLoaderManager.getXlLoadingResultInfo());
//            model.addAttribute("xlLoadingResultInfo", excelLoaderManager.getXlLoadingResultInfo());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "common/excelLoader";
//    }
}
