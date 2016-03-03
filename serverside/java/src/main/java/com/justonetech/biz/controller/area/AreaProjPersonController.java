package com.justonetech.biz.controller.area;

import com.justonetech.biz.daoservice.AreaProjPersonService;
import com.justonetech.biz.daoservice.AreaSgPermitService;
import com.justonetech.biz.domain.AreaProjPerson;
import com.justonetech.biz.domain.AreaSgPermit;
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
 * note:区县合同项目负责人信息
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class AreaProjPersonController extends BaseCRUDActionController<AreaProjPerson> {
    private Logger logger = LoggerFactory.getLogger(AreaProjPersonController.class);

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private AreaProjPersonService areaProjPersonService;

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
        model.addAttribute("SGDWLX", Constants.SGDWLX);

        return "view/area/areaProjPerson/input";
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

        return "view/area/areaProjPerson/view";
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
            Set<AreaProjPerson> projPersons = target.getAreaProjPersons();
            List<AreaProjPerson> deleteList = new ArrayList<AreaProjPerson>();
            if (null != projPersons && projPersons.size() > 0) {
                for (AreaProjPerson person : projPersons) {
                    deleteList.add(person);
                }
            }
            areaProjPersonService.batchDelete(deleteList, deleteList.size());
            //获取页面的数据
            String[] nums = request.getParameterValues("num");
            String[] contractCodes = request.getParameterValues("contractCode");
            String[] unitTypes = request.getParameterValues("unitType");
            String[] unitNames = request.getParameterValues("unitName");
            String[] unitMainPersons = request.getParameterValues("unitMainPerson");
            String[] unitIdCards = request.getParameterValues("unitIdCard");
            String[] unitPhones = request.getParameterValues("unitPhone");
            //保存数据
            List<AreaProjPerson> saveList = new ArrayList<AreaProjPerson>();
            if (null != nums && nums.length > 0) {
                for (String num : nums) {
                    int no = Integer.parseInt(num) - 1;
                    AreaProjPerson person = new AreaProjPerson();
                    person.setSgPermit(target);
                    if (null != unitTypes) {
                        if (!StringHelper.isEmpty(unitTypes[no])) {
                            SysCodeDetail type = sysCodeManager.getCodeListById(Long.valueOf(unitTypes[no]));
                            person.setUnitType(type);
                        }
                    }
                    person.setNum(Integer.valueOf(num));
                    if (!StringHelper.isEmpty(contractCodes[no])) {
                        person.setContractCode(contractCodes[no]);
                    }
                    if (!StringHelper.isEmpty(unitNames[no])) {
                        person.setUnitName(unitNames[no]);
                    }
                    if (!StringHelper.isEmpty(unitMainPersons[no])) {
                        person.setUnitMainPerson(unitMainPersons[no]);
                    }
                    if (!StringHelper.isEmpty(unitIdCards[no])) {
                        person.setUnitIdCard(unitIdCards[no]);
                    }
                    if (!StringHelper.isEmpty(unitPhones[no])) {
                        person.setUnitPhone(unitPhones[no]);
                    }
                    saveList.add(person);
                }
            }
            areaProjPersonService.batchSave(saveList, saveList.size());

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

}
