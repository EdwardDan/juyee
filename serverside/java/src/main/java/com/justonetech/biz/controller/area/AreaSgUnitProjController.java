package com.justonetech.biz.controller.area;

import com.justonetech.biz.daoservice.AreaSgPermitService;
import com.justonetech.biz.daoservice.AreaSgUnitProjService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.AreaSgPermit;
import com.justonetech.biz.domain.AreaSgUnitProj;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * note:区县单位工程列表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class AreaSgUnitProjController extends BaseCRUDActionController<AreaSgUnitProj> {
    private Logger logger = LoggerFactory.getLogger(AreaSgUnitProjController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private AreaSgUnitProjService areaSgUnitProjService;

    @Autowired
    private AreaSgPermitService areaSgPermitService;

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, String id) {
        AreaSgPermit sgPermit = new AreaSgPermit();
        if (!StringHelper.isEmpty(id)) {
            sgPermit = areaSgPermitService.get(Long.valueOf(id));
        }
        model.addAttribute("bean", sgPermit);
        model.addAttribute("SGDWGCLX", Constants.SGDWGCLX);

        return "view/area/areaSgUnitProj/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String id) {
        AreaSgPermit sgPermit = new AreaSgPermit();
        if (!StringHelper.isEmpty(id)) {
            sgPermit = areaSgPermitService.get(Long.valueOf(id));
        }
        model.addAttribute("bean", sgPermit);

        return "view/area/areaSgUnitProj/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") AreaSgPermit entity, HttpServletRequest request) throws Exception {
        try {
            AreaSgPermit target;
            if (entity.getId() != null) {
                target = areaSgPermitService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{

                });
            } else {
                target = entity;
            }
            areaSgPermitService.save(target);
            //先删除，在保存
            Set<AreaSgUnitProj> sgUnitProjs = target.getAreaSgUnitProjs();
            List<AreaSgUnitProj> deleteList = new ArrayList<AreaSgUnitProj>();
            if (null != sgUnitProjs && sgUnitProjs.size() > 0) {
                for (AreaSgUnitProj sgUnitProj : sgUnitProjs) {
                    deleteList.add(sgUnitProj);
                }
            }
            areaSgUnitProjService.batchDelete(deleteList, deleteList.size());
            //获取页面数据
            String[] nums = request.getParameterValues("num");
            String[] unitProjCodes = request.getParameterValues("unitProjCode");
            String[] unitProjNames = request.getParameterValues("unitProjName");
            String[] unitProjTypes = request.getParameterValues("unitProjType");
            String[] projectIndexs = request.getParameterValues("projectIndex");
            //保存数据
            List<AreaSgUnitProj> saveList = new ArrayList<AreaSgUnitProj>();
            if (null != nums && nums.length > 0) {
                for (String num : nums) {
                    AreaSgUnitProj sgUnitProj = new AreaSgUnitProj();
                    int no = Integer.parseInt(num) - 1;
                    sgUnitProj.setSgPermit(target);
                    if (null != unitProjTypes) {
                        if (!StringHelper.isEmpty(unitProjTypes[no])) {
                            SysCodeDetail type = sysCodeManager.getCodeListById(Long.valueOf(unitProjTypes[no]));
                            sgUnitProj.setUnitProjType(type);
                        }
                    }
                    sgUnitProj.setNum(Integer.valueOf(num));
                    if (!StringHelper.isEmpty(unitProjCodes[no])) {
                        sgUnitProj.setUnitProjCode(unitProjCodes[no]);
                    }
                    if (!StringHelper.isEmpty(unitProjNames[no])) {
                        sgUnitProj.setUnitProjName(unitProjNames[no]);
                    }
                    if (!StringHelper.isEmpty(projectIndexs[no])) {
                        sgUnitProj.setProjectIndex(projectIndexs[no]);
                    }
                    saveList.add(sgUnitProj);
                }
            }
            areaSgUnitProjService.batchSave(saveList, saveList.size());

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }
}
