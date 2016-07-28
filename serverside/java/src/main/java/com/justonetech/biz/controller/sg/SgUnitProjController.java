package com.justonetech.biz.controller.sg;

import com.justonetech.biz.daoservice.SgPermitService;
import com.justonetech.biz.daoservice.SgUnitProjService;
import com.justonetech.biz.domain.SgPermit;
import com.justonetech.biz.domain.SgUnitProj;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
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
 * note:单位工程列表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SgUnitProjController extends BaseCRUDActionController<SgUnitProj> {
    private Logger logger = LoggerFactory.getLogger(SgUnitProjController.class);

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SgUnitProjService sgUnitProjService;

    @Autowired
    private SgPermitService sgPermitService;

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, String id) {
        SgPermit sgPermit = new SgPermit();
        if (!StringHelper.isEmpty(id)) {
            sgPermit = sgPermitService.get(Long.valueOf(id));
        }
        model.addAttribute("bean", sgPermit);
        model.addAttribute("SGDWGCLX", Constants.SGDWGCLX);

        return "view/sg/sgUnitProj/input";
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
        SgPermit sgPermit = new SgPermit();
        if (null != id) {
//        if (!StringHelper.isEmpty(id)) {
            sgPermit = sgPermitService.get(id);
        }
        model.addAttribute("bean", sgPermit);

        return "view/sg/sgUnitProj/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SgPermit entity, HttpServletRequest request) throws Exception {
        try {
            SgPermit target;
            if (entity.getId() != null) {
                target = sgPermitService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{

                });
            } else {
                target = entity;
            }
            sgPermitService.save(target);
            //先删除，在保存
            Set<SgUnitProj> sgUnitProjs = target.getSgUnitProjs();
            List<SgUnitProj> deleteList = new ArrayList<SgUnitProj>();
            if (null != sgUnitProjs && sgUnitProjs.size() > 0) {
                for (SgUnitProj sgUnitProj : sgUnitProjs) {
                    deleteList.add(sgUnitProj);
                }
            }
            sgUnitProjService.batchDelete(deleteList, deleteList.size());
            //获取页面数据
            String[] nums = request.getParameterValues("num");
            String[] unitProjCodes = request.getParameterValues("unitProjCode");
            String[] unitProjNames = request.getParameterValues("unitProjName");
//            String[] unitProjTypes = request.getParameterValues("unitProjType");
            String[] projectIndexs = request.getParameterValues("projectIndex");
            //保存数据
            List<SgUnitProj> saveList = new ArrayList<SgUnitProj>();
            if (null != nums && nums.length > 0) {
                for (String num : nums) {
                    SgUnitProj sgUnitProj = new SgUnitProj();
                    int no = Integer.parseInt(num) - 1;
                    sgUnitProj.setSgPermit(target);
//                    if (null != unitProjTypes) {
//                        if (!StringHelper.isEmpty(unitProjTypes[no])) {
//                            SysCodeDetail type = sysCodeManager.getCodeListById(Long.valueOf(unitProjTypes[no]));
//                            sgUnitProj.setUnitProjType(type);
//                        }
//                    }
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
            sgUnitProjService.batchSave(saveList, saveList.size());

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

}