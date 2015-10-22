package com.justonetech.biz.controller.query;

import com.justonetech.biz.daoservice.ProjExtendService;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.domain.ProjExtend;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.MathHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目总汇总
 * User: gq
 * Date: 15-9-6
 * Time: 上午10:43
 */
@Controller
public class ProjectQuerySumController {

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjExtendService projExtendService;

    final private static String NUM_1 = "1";
    final private static String NUM_2 = "2";
    final private static String NUM_3 = "3";
    final private static String NUM_4 = "4";
    final private static String NUM_5 = "5";
    final private static String NUM_6 = "6";
    final private static String NUM_7 = "7";
    final private static String NUM_8 = "8";

    /**
     * 入口页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        //是否重大--isMajor
        SysCodeDetail ss = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_PROPERTY, NUM_1);//市属
        SysCodeDetail qs = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_PROPERTY, NUM_1);//区属

        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_CATEGORY, NUM_1);//公路
        SysCodeDetail gjjcss = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_CATEGORY, NUM_2);//公交基础设施
        SysCodeDetail csdl = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_CATEGORY, NUM_3);//城市道路
        SysCodeDetail gd = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_CATEGORY, NUM_4);//轨道
        SysCodeDetail nh = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_CATEGORY, NUM_5);//内河
        SysCodeDetail gk = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_CATEGORY, NUM_6);//港口
        SysCodeDetail jc = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_CATEGORY, NUM_7);//机场
        SysCodeDetail tl = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_CATEGORY, NUM_8);//铁路
        SysCodeDetail ptdl = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_DBSX, Constants.PROJ_INFO_DBSX_2);//配套道路
        SysCodeDetail ptgj = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_DBSX, Constants.PROJ_INFO_DBSX_3);//配套公交
        //项目状态
        SysCodeDetail status1 = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_STAGE, NUM_1);//未开工
        SysCodeDetail status2 = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_STAGE, NUM_2);//在建
        SysCodeDetail status3 = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_STAGE, NUM_3);//已完工

        String hql = "from ProjInfo where stage.id=? order by no asc";
        List<ProjInfo> wkgList = projInfoService.findByQuery(hql, status1.getId()); //未开工
        List<ProjInfo> zjList = projInfoService.findByQuery(hql, status2.getId()); //在建
        List<ProjInfo> ywgList = projInfoService.findByQuery(hql, status3.getId()); //已完工
        model.addAttribute("ywg_size", ywgList.size());
        model.addAttribute("zj_ykg_size", zjList.size());
        model.addAttribute("ykg_size", ywgList.size() + zjList.size());
        model.addAttribute("wkg_size", wkgList.size());
        model.addAttribute("zj_size", wkgList.size() + zjList.size() + ywgList.size());

        Map<String, Object> map = new HashMap<String, Object>();
        //完工项目
        //城市道路
        Integer ywg_szdlSsZdNum = 0;
        Integer ywg_szdlSsFzdNum = 0;
        Integer ywg_szdlSsXj = 0;
        Integer ywg_szdlQsNum = 0;
        Double ywg_szdlCost = 0.0;
        //公交基础设施
        Integer ywg_gjjcssSsNum = 0;
        Integer ywg_gjjcssQsdNum = 0;
        Double ywg_gjjcssCost = 0.0;
        //轨道
        Integer ywg_gdSsZdNum = 0;
        Integer ywg_gdSsFzdNum = 0;
        Integer ywg_gdSsXj = 0;
        Double ywg_gdCost = 0.0;
        //内河
        Integer ywg_nhSsZdNum = 0;
        Integer ywg_nhSsFzdNum = 0;
        Integer ywg_nhSsXj = 0;
        Double ywg_nhCost = 0.0;
        //港口
        Integer ywg_gkSsZdNum = 0;
        Integer ywg_gkSsFzdNum = 0;
        Integer ywg_gkSsXj = 0;
        Double ywg_gkCost = 0.0;
        //航空
        Integer ywg_hkSsZdNum = 0;
        Integer ywg_hkSsFzdNum = 0;
        Integer ywg_hkSsXj = 0;
        Double ywg_hkCost = 0.0;
        //铁路（市属）
        Integer ywg_tlNum = 0;
        Double ywg_tlCost = 0.0;
        //大居配套（道路）
        Integer ywg_djptDlNum = 0;
        Double ywg_djptDlCost = 0.0;
        //大居配套（公交）
        Integer ywg_djptGjNum = 0;
        Double ywg_djptGjCost = 0.0;
        for (ProjInfo project : ywgList) {
            Boolean isMajor = project.getIsMajor();
            SysCodeDetail property = project.getProperty();
            SysCodeDetail category = project.getCategory();
            String packageAttr = project.getPackageAttr();
            List<ProjExtend> extendList = projExtendService.findByProperty("project.id", project.getId());
            Double gctx = 0.0;
            if (null != extendList && extendList.size() > 0) {
                ProjExtend extend = extendList.iterator().next();
                Double gctxGkpfTotal = extend.getGctxGkpfTotal();//工可批复总投资（亿元）
                Double gctxCspfTotal = extend.getGctxCspfTotal();//初设批复总投资（亿元）
                if (null != gctxGkpfTotal) {
                    gctx += gctxGkpfTotal;
                }
                if (null != gctxCspfTotal) {
                    gctx += gctxCspfTotal;
                }
            }
            if (null != category) {
                if (category.getId().equals(csdl.getId())) {  //城市道路
                    if (property.getId().equals(ss.getId())) {
                        if (isMajor) {
                            ywg_szdlSsZdNum++;
                        } else {
                            ywg_szdlSsFzdNum++;
                        }
                    } else {
                        ywg_szdlQsNum++;
                        ywg_szdlCost += gctx;
                    }
                } else if (category.getId().equals(gjjcss.getId())) {  //公交基础设施
                    if (property.getId().equals(ss.getId())) {
                        ywg_gjjcssSsNum++;
                    } else {
                        ywg_gjjcssQsdNum++;
                    }
                    ywg_gjjcssCost += gctx;
                }
            }
            if (property.getId().equals(gd.getId())) {  //轨道
                if (property.getId().equals(ss.getId())) {
                    if (isMajor) {
                        ywg_gdSsZdNum++;
                    } else {
                        ywg_gdSsFzdNum++;
                    }
                }
                ywg_gdCost += gctx;
            } else if (property.getId().equals(nh.getId())) { //内河
                if (property.getId().equals(ss.getId())) {
                    if (isMajor) {
                        ywg_nhSsZdNum++;
                    } else {
                        ywg_nhSsFzdNum++;
                    }
                }
                ywg_nhCost += gctx;
            } else if (property.getId().equals(gk.getId())) { //港口
                if (property.getId().equals(ss.getId())) {
                    if (isMajor) {
                        ywg_gkSsZdNum++;
                    } else {
                        ywg_gkSsFzdNum++;
                    }
                }
                ywg_gkCost += gctx;
            } else if (property.getId().equals(jc.getId())) { //航空
                if (property.getId().equals(ss.getId())) {
                    if (isMajor) {
                        ywg_hkSsZdNum++;
                    } else {
                        ywg_hkSsFzdNum++;
                    }
                }
                ywg_hkCost += gctx;
            } else if (property.getId().equals(tl.getId())) { //铁路（市属）
                if (property.getId().equals(ss.getId())) {
                    ywg_tlNum++;
                    ywg_tlCost += gctx;
                }
            }
            if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptdl.getName())) { //大居配套（道路）
                ywg_djptDlNum++;
                ywg_djptDlCost += gctx;
            }
            if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptgj.getName())) { //大居配套（公交）
                ywg_djptGjNum++;
                ywg_djptGjCost += gctx;
            }
        }
        //城市道路
        ywg_szdlSsXj = ywg_szdlSsZdNum + ywg_szdlSsFzdNum;
        map.put("ywg_szdl_ss_zd", ywg_szdlSsZdNum);
        map.put("ywg_szdl_ss_fzd", ywg_szdlSsFzdNum);
        map.put("ywg_szdl_ss_xj", ywg_szdlSsXj);
        map.put("ywg_szdl_qs", ywg_szdlQsNum);
        map.put("ywg_szdl_cost", MathHelper.formatDouble(ywg_szdlCost, 4));
        //公交基础设施
        map.put("ywg_gjjcss_ss", ywg_gjjcssSsNum);
        map.put("ywg_gjjcss_qs", ywg_gjjcssQsdNum);
        map.put("ywg_gjjcss_cost", MathHelper.formatDouble(ywg_gjjcssCost, 4));
        //轨道
        ywg_gdSsXj = ywg_gdSsZdNum + ywg_gdSsFzdNum;
        map.put("ywg_gd_ss_zd", ywg_gdSsZdNum);
        map.put("ywg_gd_ss_fzd", ywg_gdSsZdNum);
        map.put("ywg_gd_ss_xj", ywg_gdSsXj);
        map.put("ywg_gd_ss_cost", MathHelper.formatDouble(ywg_gdCost, 4));
        //内河
        ywg_nhSsXj = ywg_nhSsZdNum + ywg_nhSsFzdNum;
        map.put("ywg_nh_ss_zd", ywg_nhSsZdNum);
        map.put("ywg_nh_ss_fzd", ywg_nhSsZdNum);
        map.put("ywg_nh_ss_xj", ywg_nhSsXj);
        map.put("ywg_nh_ss_cost", MathHelper.formatDouble(ywg_nhCost, 4));
        //港口
        ywg_gkSsXj = ywg_gkSsZdNum + ywg_gkSsFzdNum;
        map.put("ywg_gk_ss_zd", ywg_gkSsZdNum);
        map.put("ywg_gk_ss_fzd", ywg_gkSsZdNum);
        map.put("ywg_gk_ss_xj", ywg_gkSsXj);
        map.put("ywg_gk_ss_cost", MathHelper.formatDouble(ywg_gkCost, 4));
        //航空
        ywg_hkSsXj = ywg_hkSsZdNum + ywg_hkSsFzdNum;
        map.put("ywg_hk_ss_zd", ywg_hkSsZdNum);
        map.put("ywg_hk_ss_fzd", ywg_hkSsZdNum);
        map.put("ywg_hk_ss_xj", ywg_hkSsXj);
        map.put("ywg_hk_ss_cost", MathHelper.formatDouble(ywg_hkCost, 4));
        //铁路（市属）
        map.put("ywg_tl", ywg_tlNum);
        map.put("ywg_tl_cost", MathHelper.formatDouble(ywg_tlCost, 4));
        //大居配套（道路）
        map.put("ywg_ptdl", ywg_djptDlNum);
        map.put("ywg_ptdl_cost", MathHelper.formatDouble(ywg_djptDlCost, 4));
        //大居配套（公交）
        map.put("ywg_ptgj", ywg_djptGjNum);
        map.put("ywg_ptgj_cost", MathHelper.formatDouble(ywg_djptGjCost, 4));
        //在建项目
        //城市道路
        Integer zj_szdlSsZdNum = 0;
        Integer zj_szdlSsFzdNum = 0;
        Integer zj_szdlSsXj = 0;
        Integer zj_szdlQsNum = 0;
        Double zj_szdlCost = 0.0;
        //公交基础设施
        Integer zj_gjjcssSsNum = 0;
        Integer zj_gjjcssQsdNum = 0;
        Double zj_gjjcssCost = 0.0;
        //轨道
        Integer zj_gdSsZdNum = 0;
        Integer zj_gdSsFzdNum = 0;
        Integer zj_gdSsXj = 0;
        Double zj_gdCost = 0.0;
        //内河
        Integer zj_nhSsZdNum = 0;
        Integer zj_nhSsFzdNum = 0;
        Integer zj_nhSsXj = 0;
        Double zj_nhCost = 0.0;
        //港口
        Integer zj_gkSsZdNum = 0;
        Integer zj_gkSsFzdNum = 0;
        Integer zj_gkSsXj = 0;
        Double zj_gkCost = 0.0;
        //航空
        Integer zj_hkSsZdNum = 0;
        Integer zj_hkSsFzdNum = 0;
        Integer zj_hkSsXj = 0;
        Double zj_hkCost = 0.0;
        //铁路（市属）
        Integer zj_tlNum = 0;
        Double zj_tlCost = 0.0;
        //大居配套（道路）
        Integer zj_djptDlNum = 0;
        Double zj_djptDlCost = 0.0;
        //大居配套（公交）
        Integer zj_djptGjNum = 0;
        Double zj_djptGjCost = 0.0;
        for (ProjInfo project : zjList) {
            Boolean isMajor = project.getIsMajor();
            SysCodeDetail property = project.getProperty();
            SysCodeDetail category = project.getCategory();
            String packageAttr = project.getPackageAttr();
            List<ProjExtend> extendList = projExtendService.findByProperty("project.id", project.getId());
            Double gctx = 0.0;
            if (null != extendList && extendList.size() > 0) {
                ProjExtend extend = extendList.iterator().next();
                Double gctxGkpfTotal = extend.getGctxGkpfTotal();//工可批复总投资（亿元）
                Double gctxCspfTotal = extend.getGctxCspfTotal();//初设批复总投资（亿元）
                if (null != gctxGkpfTotal) {
                    gctx += gctxGkpfTotal;
                }
                if (null != gctxCspfTotal) {
                    gctx += gctxCspfTotal;
                }
            }
            if (null != category) {
                if (category.getId().equals(csdl.getId())) {  //城市道路
                    if (property.getId().equals(ss.getId())) {
                        if (isMajor) {
                            zj_szdlSsZdNum++;
                        } else {
                            zj_szdlSsFzdNum++;
                        }
                    } else {
                        zj_szdlQsNum++;
                        zj_szdlCost += gctx;
                    }
                } else if (category.getId().equals(gjjcss.getId())) {  //公交基础设施
                    if (property.getId().equals(ss.getId())) {
                        zj_gjjcssSsNum++;
                    } else {
                        zj_gjjcssQsdNum++;
                    }
                    zj_gjjcssCost += gctx;
                }
            }
            if (property.getId().equals(gd.getId())) {  //轨道
                if (property.getId().equals(ss.getId())) {
                    if (isMajor) {
                        zj_gdSsZdNum++;
                    } else {
                        zj_gdSsFzdNum++;
                    }
                }
                zj_gdCost += gctx;
            } else if (property.getId().equals(nh.getId())) { //内河
                if (property.getId().equals(ss.getId())) {
                    if (isMajor) {
                        zj_nhSsZdNum++;
                    } else {
                        zj_nhSsFzdNum++;
                    }
                }
                zj_nhCost += gctx;
            } else if (property.getId().equals(gk.getId())) { //港口
                if (property.getId().equals(ss.getId())) {
                    if (isMajor) {
                        zj_gkSsZdNum++;
                    } else {
                        zj_gkSsFzdNum++;
                    }
                }
                zj_gkCost += gctx;
            } else if (property.getId().equals(jc.getId())) { //航空
                if (property.getId().equals(ss.getId())) {
                    if (isMajor) {
                        zj_hkSsZdNum++;
                    } else {
                        zj_hkSsFzdNum++;
                    }
                }
                zj_hkCost += gctx;
            } else if (property.getId().equals(tl.getId())) { //铁路（市属）
                if (property.getId().equals(ss.getId())) {
                    zj_tlNum++;
                }
                zj_tlCost += gctx;
            }
            if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptdl.getName())) { //大居配套（道路）
                zj_djptDlNum++;
                zj_djptDlCost += gctx;
            }
            if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptgj.getName())) { //大居配套（公交）
                zj_djptGjNum++;
                zj_djptGjCost += gctx;
            }
        }
        //城市道路
        zj_szdlSsXj = zj_szdlSsZdNum + zj_szdlSsFzdNum;
        map.put("zj_szdl_ss_zd", zj_szdlSsZdNum);
        map.put("zj_szdl_ss_fzd", zj_szdlSsFzdNum);
        map.put("zj_szdl_ss_xj", zj_szdlSsXj);
        map.put("zj_szdl_qs", zj_szdlQsNum);
        map.put("zj_szdl_cost", MathHelper.formatDouble(zj_szdlCost, 4));
        //公交基础设施
        map.put("zj_gjjcss_ss", zj_gjjcssSsNum);
        map.put("zj_gjjcss_qs", zj_gjjcssQsdNum);
        map.put("zj_gjjcss_cost", MathHelper.formatDouble(zj_gjjcssCost, 4));
        //轨道
        zj_gdSsXj = zj_gdSsZdNum + zj_gdSsFzdNum;
        map.put("zj_gd_ss_zd", zj_gdSsZdNum);
        map.put("zj_gd_ss_fzd", zj_gdSsZdNum);
        map.put("zj_gd_ss_xj", zj_gdSsXj);
        map.put("zj_gd_ss_cost", MathHelper.formatDouble(zj_gdCost, 4));
        //内河
        zj_nhSsXj = zj_nhSsZdNum + zj_nhSsFzdNum;
        map.put("zj_nh_ss_zd", zj_nhSsZdNum);
        map.put("zj_nh_ss_fzd", zj_nhSsZdNum);
        map.put("zj_nh_ss_xj", zj_nhSsXj);
        map.put("zj_nh_ss_cost", MathHelper.formatDouble(zj_nhCost, 4));
        //港口
        zj_gkSsXj = zj_gkSsZdNum + zj_gkSsFzdNum;
        map.put("zj_gk_ss_zd", zj_gkSsZdNum);
        map.put("zj_gk_ss_fzd", zj_gkSsZdNum);
        map.put("zj_gk_ss_xj", zj_gkSsXj);
        map.put("zj_gk_ss_cost", MathHelper.formatDouble(zj_gkCost, 4));
        //航空
        zj_hkSsXj = zj_hkSsZdNum + zj_hkSsFzdNum;
        map.put("zj_hk_ss_zd", zj_hkSsZdNum);
        map.put("zj_hk_ss_fzd", zj_hkSsZdNum);
        map.put("zj_hk_ss_xj", zj_hkSsXj);
        map.put("zj_hk_ss_cost", MathHelper.formatDouble(zj_hkCost, 4));
        //铁路（市属）
        map.put("zj_tl", zj_tlNum);
        map.put("zj_tl_cost", MathHelper.formatDouble(zj_tlCost, 4));
        //大居配套（道路）
        map.put("zj_ptdl", zj_djptDlNum);
        map.put("zj_ptdl_cost", MathHelper.formatDouble(zj_djptDlCost, 4));
        //大居配套（公交）
        map.put("zj_ptgj", zj_djptGjNum);
        map.put("zj_ptgj_cost", MathHelper.formatDouble(zj_djptGjCost, 4));

        //已开工项目小计
        //城市道路
        map.put("ykg_szdl_ss_zd", ywg_szdlSsZdNum + zj_szdlSsZdNum);
        map.put("ykg_szdl_ss_fzd", ywg_szdlSsFzdNum + zj_szdlSsFzdNum);
        map.put("ykg_szdl_ss_xj", ywg_szdlSsXj + zj_szdlSsXj);
        map.put("ykg_szdl_qs", ywg_szdlQsNum + zj_szdlQsNum);
        map.put("ykg_szdl_cost", MathHelper.formatDouble(ywg_szdlCost + zj_szdlCost, 4));
        //公交基础设施
        map.put("ykg_gjjcss_ss", ywg_gjjcssSsNum + zj_gjjcssSsNum);
        map.put("ykg_gjjcss_qs", ywg_gjjcssQsdNum + zj_gjjcssQsdNum);
        map.put("ykg_gjjcss_cost", MathHelper.formatDouble(ywg_gjjcssCost + zj_gjjcssCost, 4));
        //轨道
        map.put("ykg_gd_ss_zd", ywg_gdSsZdNum + zj_gdSsZdNum);
        map.put("ykg_gd_ss_fzd", ywg_gdSsFzdNum + zj_gdSsFzdNum);
        map.put("ykg_gd_ss_xj", ywg_gdSsXj + zj_gdSsXj);
        map.put("ykg_gd_ss_cost", MathHelper.formatDouble(ywg_gdCost + zj_gdCost, 4));
        //内河
        map.put("ykg_nh_ss_zd", ywg_nhSsZdNum + zj_nhSsZdNum);
        map.put("ykg_nh_ss_fzd", ywg_nhSsFzdNum + zj_nhSsFzdNum);
        map.put("ykg_nh_ss_xj", ywg_nhSsXj + zj_nhSsXj);
        map.put("ykg_nh_ss_cost", MathHelper.formatDouble(ywg_nhCost + zj_nhCost, 4));
        //港口
        map.put("ykg_gk_ss_zd", ywg_gkSsZdNum + zj_gkSsZdNum);
        map.put("ykg_gk_ss_fzd", ywg_gkSsFzdNum + zj_gkSsFzdNum);
        map.put("ykg_gk_ss_xj", ywg_gkSsXj + zj_gkSsXj);
        map.put("ykg_gk_ss_cost", MathHelper.formatDouble(ywg_gkCost + zj_gkCost, 4));
        //航空
        map.put("ykg_hk_ss_zd", ywg_hkSsZdNum + zj_hkSsZdNum);
        map.put("ykg_hk_ss_fzd", ywg_hkSsFzdNum + zj_hkSsFzdNum);
        map.put("ykg_hk_ss_xj", ywg_hkSsXj + zj_hkSsXj);
        map.put("ykg_hk_ss_cost", MathHelper.formatDouble(ywg_hkCost + zj_hkCost, 4));
        //铁路（市属）
        map.put("ykg_tl", ywg_tlNum + zj_tlNum);
        map.put("ykg_tl_cost", MathHelper.formatDouble(ywg_tlCost + zj_tlCost, 4));
        //大居配套（道路）
        map.put("ykg_ptdl", ywg_djptDlNum + zj_djptDlNum);
        map.put("ykg_ptdl_cost", MathHelper.formatDouble(ywg_djptDlCost + zj_djptDlCost, 4));
        //大居配套（公交）
        map.put("ykg_ptgj", ywg_djptGjNum + zj_djptGjNum);
        map.put("ykg_ptgj_cost", MathHelper.formatDouble(ywg_djptGjCost + zj_djptGjCost, 4));

        //未开工项目
        SysCodeDetail wwc = sysCodeManager.getCodeDetailByCode("ProjState", "wwc");
        SysCodeDetail ywc = sysCodeManager.getCodeDetailByCode("ProjState", "ywc");
        //项目建议书未批
        //城市道路
        Integer xmjyswp_xmNum = 0;
        Integer xmjyswp_szdlSsZdNum = 0;
        Integer xmjyswp_szdlSsFzdNum = 0;
        Integer xmjyswp_szdlSsXj = 0;
        Integer xmjyswp_szdlQsNum = 0;
        Double xmjyswp_szdlCost = 0.0;
        //公交基础设施
        Integer xmjyswp_gjjcssSsNum = 0;
        Integer xmjyswp_gjjcssQsdNum = 0;
        Double xmjyswp_gjjcssCost = 0.0;
        //轨道
        Integer xmjyswp_gdSsZdNum = 0;
        Integer xmjyswp_gdSsFzdNum = 0;
        Integer xmjyswp_gdSsXj = 0;
        Double xmjyswp_gdCost = 0.0;
        //内河
        Integer xmjyswp_nhSsZdNum = 0;
        Integer xmjyswp_nhSsFzdNum = 0;
        Integer xmjyswp_nhSsXj = 0;
        Double xmjyswp_nhCost = 0.0;
        //港口
        Integer xmjyswp_gkSsZdNum = 0;
        Integer xmjyswp_gkSsFzdNum = 0;
        Integer xmjyswp_gkSsXj = 0;
        Double xmjyswp_gkCost = 0.0;
        //航空
        Integer xmjyswp_hkSsZdNum = 0;
        Integer xmjyswp_hkSsFzdNum = 0;
        Integer xmjyswp_hkSsXj = 0;
        Double xmjyswp_hkCost = 0.0;
        //铁路（市属）
        Integer xmjyswp_tlNum = 0;
        Double xmjyswp_tlCost = 0.0;
        //大居配套（道路）
        Integer xmjyswp_djptDlNum = 0;
        Double xmjyswp_djptDlCost = 0.0;
        //大居配套（公交）
        Integer xmjyswp_djptGjNum = 0;
        Double xmjyswp_djptGjCost = 0.0;
        //工可未批复
        Integer gkwpf_xmNum = 0;
        Integer gkwpf_szdlSsZdNum = 0;
        Integer gkwpf_szdlSsFzdNum = 0;
        Integer gkwpf_szdlSsXj = 0;
        Integer gkwpf_szdlQsNum = 0;
        Double gkwpf_szdlCost = 0.0;
        //公交基础设施
        Integer gkwpf_gjjcssSsNum = 0;
        Integer gkwpf_gjjcssQsdNum = 0;
        Double gkwpf_gjjcssCost = 0.0;
        //轨道
        Integer gkwpf_gdSsZdNum = 0;
        Integer gkwpf_gdSsFzdNum = 0;
        Integer gkwpf_gdSsXj = 0;
        Double gkwpf_gdCost = 0.0;
        //内河
        Integer gkwpf_nhSsZdNum = 0;
        Integer gkwpf_nhSsFzdNum = 0;
        Integer gkwpf_nhSsXj = 0;
        Double gkwpf_nhCost = 0.0;
        //港口
        Integer gkwpf_gkSsZdNum = 0;
        Integer gkwpf_gkSsFzdNum = 0;
        Integer gkwpf_gkSsXj = 0;
        Double gkwpf_gkCost = 0.0;
        //航空
        Integer gkwpf_hkSsZdNum = 0;
        Integer gkwpf_hkSsFzdNum = 0;
        Integer gkwpf_hkSsXj = 0;
        Double gkwpf_hkCost = 0.0;
        //铁路（市属）
        Integer gkwpf_tlNum = 0;
        Double gkwpf_tlCost = 0.0;
        //大居配套（道路）
        Integer gkwpf_djptDlNum = 0;
        Double gkwpf_djptDlCost = 0.0;
        //大居配套（公交）
        Integer gkwpf_djptGjNum = 0;
        Double gkwpf_djptGjCost = 0.0;
        //工可己批初设未批复
        Integer gkypcswp_xmNum = 0;
        Integer gkypcswp_szdlSsZdNum = 0;
        Integer gkypcswp_szdlSsFzdNum = 0;
        Integer gkypcswp_szdlSsXj = 0;
        Integer gkypcswp_szdlQsNum = 0;
        Double gkypcswp_szdlCost = 0.0;
        //公交基础设施
        Integer gkypcswp_gjjcssSsNum = 0;
        Integer gkypcswp_gjjcssQsdNum = 0;
        Double gkypcswp_gjjcssCost = 0.0;
        //轨道
        Integer gkypcswp_gdSsZdNum = 0;
        Integer gkypcswp_gdSsFzdNum = 0;
        Integer gkypcswp_gdSsXj = 0;
        Double gkypcswp_gdCost = 0.0;
        //内河
        Integer gkypcswp_nhSsZdNum = 0;
        Integer gkypcswp_nhSsFzdNum = 0;
        Integer gkypcswp_nhSsXj = 0;
        Double gkypcswp_nhCost = 0.0;
        //港口
        Integer gkypcswp_gkSsZdNum = 0;
        Integer gkypcswp_gkSsFzdNum = 0;
        Integer gkypcswp_gkSsXj = 0;
        Double gkypcswp_gkCost = 0.0;
        //航空
        Integer gkypcswp_hkSsZdNum = 0;
        Integer gkypcswp_hkSsFzdNum = 0;
        Integer gkypcswp_hkSsXj = 0;
        Double gkypcswp_hkCost = 0.0;
        //铁路（市属）
        Integer gkypcswp_tlNum = 0;
        Double gkypcswp_tlCost = 0.0;
        //大居配套（道路）
        Integer gkypcswp_djptDlNum = 0;
        Double gkypcswp_djptDlCost = 0.0;
        //大居配套（公交）
        Integer gkypcswp_djptGjNum = 0;
        Double gkypcswp_djptGjCost = 0.0;
        //初设已批未开工
        Integer csypwkg_xmNum = 0;
        Integer csypwkg_szdlSsZdNum = 0;
        Integer csypwkg_szdlSsFzdNum = 0;
        Integer csypwkg_szdlSsXj = 0;
        Integer csypwkg_szdlQsNum = 0;
        Double csypwkg_szdlCost = 0.0;
        //公交基础设施
        Integer csypwkg_gjjcssSsNum = 0;
        Integer csypwkg_gjjcssQsdNum = 0;
        Double csypwkg_gjjcssCost = 0.0;
        //轨道
        Integer csypwkg_gdSsZdNum = 0;
        Integer csypwkg_gdSsFzdNum = 0;
        Integer csypwkg_gdSsXj = 0;
        Double csypwkg_gdCost = 0.0;
        //内河
        Integer csypwkg_nhSsZdNum = 0;
        Integer csypwkg_nhSsFzdNum = 0;
        Integer csypwkg_nhSsXj = 0;
        Double csypwkg_nhCost = 0.0;
        //港口
        Integer csypwkg_gkSsZdNum = 0;
        Integer csypwkg_gkSsFzdNum = 0;
        Integer csypwkg_gkSsXj = 0;
        Double csypwkg_gkCost = 0.0;
        //航空
        Integer csypwkg_hkSsZdNum = 0;
        Integer csypwkg_hkSsFzdNum = 0;
        Integer csypwkg_hkSsXj = 0;
        Double csypwkg_hkCost = 0.0;
        //铁路（市属）
        Integer csypwkg_tlNum = 0;
        Double csypwkg_tlCost = 0.0;
        //大居配套（道路）
        Integer csypwkg_djptDlNum = 0;
        Double csypwkg_djptDlCost = 0.0;
        //大居配套（公交）
        Integer csypwkg_djptGjNum = 0;
        Double csypwkg_djptGjCost = 0.0;
        for (ProjInfo project : wkgList) {
            Boolean isMajor = project.getIsMajor();
            SysCodeDetail property = project.getProperty();
            SysCodeDetail category = project.getCategory();
            String packageAttr = project.getPackageAttr();
            List<ProjExtend> extendList = projExtendService.findByProperty("project.id", project.getId());
            Double gctx = 0.0;
            if (null != extendList && extendList.size() > 0) {
                ProjExtend extend = extendList.iterator().next();
                Double gctxGkpfTotal = extend.getGctxGkpfTotal();//工可批复总投资（亿元）
                Double gctxCspfTotal = extend.getGctxCspfTotal();//初设批复总投资（亿元）
                if (null != gctxGkpfTotal) {
                    gctx += gctxGkpfTotal;
                }
                if (null != gctxCspfTotal) {
                    gctx += gctxCspfTotal;
                }
                SysCodeDetail planXmjys = extend.getPlanXmjys();//项目建议书
                SysCodeDetail planGk = extend.getPlanGk();//工可
                SysCodeDetail planCbsj = extend.getPlanCbsj();//初步设计
                if (null != planXmjys && planXmjys.getId().equals(wwc.getId())) {  //项目建议书未批
                    xmjyswp_xmNum++;
                    if (null != category) {
                        if (category.getId().equals(csdl.getId())) {  //城市道路
                            if (property.getId().equals(ss.getId())) {
                                if (isMajor) {
                                    xmjyswp_szdlSsZdNum++;
                                } else {
                                    xmjyswp_szdlSsFzdNum++;
                                }
                            } else {
                                xmjyswp_szdlQsNum++;
                                xmjyswp_szdlCost += gctx;
                            }
                        } else if (category.getId().equals(gjjcss.getId())) {  //公交基础设施
                            if (property.getId().equals(ss.getId())) {
                                xmjyswp_gjjcssSsNum++;
                            } else {
                                xmjyswp_gjjcssQsdNum++;
                            }
                            xmjyswp_gjjcssCost += gctx;
                        }
                    }
                    if (property.getId().equals(gd.getId())) {  //轨道
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                xmjyswp_gdSsZdNum++;
                            } else {
                                xmjyswp_gdSsFzdNum++;
                            }
                        }
                        xmjyswp_gdCost += gctx;
                    } else if (property.getId().equals(nh.getId())) { //内河
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                xmjyswp_nhSsZdNum++;
                            } else {
                                xmjyswp_nhSsFzdNum++;
                            }
                        }
                        xmjyswp_nhCost += gctx;
                    } else if (property.getId().equals(gk.getId())) { //港口
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                xmjyswp_gkSsZdNum++;
                            } else {
                                xmjyswp_gkSsFzdNum++;
                            }
                        }
                        xmjyswp_gkCost += gctx;
                    } else if (property.getId().equals(jc.getId())) { //航空
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                xmjyswp_hkSsZdNum++;
                            } else {
                                xmjyswp_hkSsFzdNum++;
                            }
                        }
                        xmjyswp_hkCost += gctx;
                    } else if (property.getId().equals(tl.getId())) { //铁路（市属）
                        if (property.getId().equals(ss.getId())) {
                            xmjyswp_tlNum++;
                        }
                        xmjyswp_tlCost += gctx;
                    }
                    if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptdl.getName())) { //大居配套（道路）
                        xmjyswp_djptDlNum++;
                        xmjyswp_djptDlCost += gctx;
                    }
                    if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptgj.getName())) { //大居配套（公交）
                        xmjyswp_djptGjNum++;
                        xmjyswp_djptGjCost += gctx;
                    }
                }
                if (null != planGk && planGk.getId().equals(wwc.getId())) { //工可未批复
                    gkwpf_xmNum++;
                    if (null != category) {
                        if (category.getId().equals(csdl.getId())) {  //城市道路
                            if (property.getId().equals(ss.getId())) {
                                if (isMajor) {
                                    gkwpf_szdlSsZdNum++;
                                } else {
                                    gkwpf_szdlSsFzdNum++;
                                }
                            } else {
                                gkwpf_szdlQsNum++;
                                gkwpf_szdlCost += gctx;
                            }
                        } else if (category.getId().equals(gjjcss.getId())) {  //公交基础设施
                            if (property.getId().equals(ss.getId())) {
                                gkwpf_gjjcssSsNum++;
                            } else {
                                gkwpf_gjjcssQsdNum++;
                            }
                            gkwpf_gjjcssCost += gctx;
                        }
                    }
                    if (property.getId().equals(gd.getId())) {  //轨道
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                gkwpf_gdSsZdNum++;
                            } else {
                                gkwpf_gdSsFzdNum++;
                            }
                        }
                        gkwpf_gdCost += gctx;
                    } else if (property.getId().equals(nh.getId())) { //内河
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                gkwpf_nhSsZdNum++;
                            } else {
                                gkwpf_nhSsFzdNum++;
                            }
                        }
                        gkwpf_nhCost += gctx;
                    } else if (property.getId().equals(gk.getId())) { //港口
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                gkwpf_gkSsZdNum++;
                            } else {
                                gkwpf_gkSsFzdNum++;
                            }
                        }
                        gkwpf_gkCost += gctx;
                    } else if (property.getId().equals(jc.getId())) { //航空
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                gkwpf_hkSsZdNum++;
                            } else {
                                gkwpf_hkSsFzdNum++;
                            }
                        }
                        gkwpf_hkCost += gctx;
                    } else if (property.getId().equals(tl.getId())) { //铁路（市属）
                        if (property.getId().equals(ss.getId())) {
                            gkwpf_tlNum++;
                        }
                        gkwpf_tlCost += gctx;
                    }
                    if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptdl.getName())) { //大居配套（道路）
                        gkwpf_djptDlNum++;
                        gkwpf_djptDlCost += gctx;
                    }
                    if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptgj.getName())) { //大居配套（公交）
                        gkwpf_djptGjNum++;
                        gkwpf_djptGjCost += gctx;
                    }
                }
                if ((null != planGk && planGk.getId().equals(ywc.getId())) && (null != planCbsj && planCbsj.getId().equals(wwc.getId()))) {//工可己批初设未批复
                    gkypcswp_xmNum++;
                    if (null != category) {
                        if (category.getId().equals(csdl.getId())) {  //城市道路
                            if (property.getId().equals(ss.getId())) {
                                if (isMajor) {
                                    gkypcswp_szdlSsZdNum++;
                                } else {
                                    gkypcswp_szdlSsFzdNum++;
                                }
                            } else {
                                gkypcswp_szdlQsNum++;
                                gkypcswp_szdlCost += gctx;
                            }
                        } else if (category.getId().equals(gjjcss.getId())) {  //公交基础设施
                            if (property.getId().equals(ss.getId())) {
                                gkypcswp_gjjcssSsNum++;
                            } else {
                                gkypcswp_gjjcssQsdNum++;
                            }
                            gkypcswp_gjjcssCost += gctx;
                        }
                    }
                    if (property.getId().equals(gd.getId())) {  //轨道
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                gkypcswp_gdSsZdNum++;
                            } else {
                                gkypcswp_gdSsFzdNum++;
                            }
                        }
                        gkypcswp_gdCost += gctx;
                    } else if (property.getId().equals(nh.getId())) { //内河
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                gkypcswp_nhSsZdNum++;
                            } else {
                                gkypcswp_nhSsFzdNum++;
                            }
                        }
                        gkypcswp_nhCost += gctx;
                    } else if (property.getId().equals(gk.getId())) { //港口
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                gkypcswp_gkSsZdNum++;
                            } else {
                                gkypcswp_gkSsFzdNum++;
                            }
                        }
                        gkypcswp_gkCost += gctx;
                    } else if (property.getId().equals(jc.getId())) { //航空
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                gkypcswp_hkSsZdNum++;
                            } else {
                                gkypcswp_hkSsFzdNum++;
                            }
                        }
                        gkypcswp_hkCost += gctx;
                    } else if (property.getId().equals(tl.getId())) { //铁路（市属）
                        if (property.getId().equals(ss.getId())) {
                            gkypcswp_tlNum++;
                        }
                        gkypcswp_tlCost += gctx;
                    }
                    if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptdl.getName())) { //大居配套（道路）
                        gkypcswp_djptDlNum++;
                        gkypcswp_djptDlCost += gctx;
                    }
                    if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptgj.getName())) { //大居配套（公交）
                        gkypcswp_djptGjNum++;
                        gkypcswp_djptGjCost += gctx;
                    }
                }
                if ((null != planCbsj && planCbsj.getId().equals(ywc.getId()) && (project.getStage().getId().equals(status1.getId())))) {//初设已批未开工
                    csypwkg_xmNum++;
                    if (null != category) {
                        if (category.getId().equals(csdl.getId())) {  //城市道路
                            if (property.getId().equals(ss.getId())) {
                                if (isMajor) {
                                    csypwkg_szdlSsZdNum++;
                                } else {
                                    csypwkg_szdlSsFzdNum++;
                                }
                            } else {
                                csypwkg_szdlQsNum++;
                                csypwkg_szdlCost += gctx;
                            }
                        } else if (category.getId().equals(gjjcss.getId())) {  //公交基础设施
                            if (property.getId().equals(ss.getId())) {
                                csypwkg_gjjcssSsNum++;
                            } else {
                                csypwkg_gjjcssQsdNum++;
                            }
                            csypwkg_gjjcssCost += gctx;
                        }
                    }
                    if (property.getId().equals(gd.getId())) {  //轨道
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                csypwkg_gdSsZdNum++;
                            } else {
                                csypwkg_gdSsFzdNum++;
                            }
                        }
                        csypwkg_gdCost += gctx;
                    } else if (property.getId().equals(nh.getId())) { //内河
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                csypwkg_nhSsZdNum++;
                            } else {
                                csypwkg_nhSsFzdNum++;
                            }
                        }
                        csypwkg_nhCost += gctx;
                    } else if (property.getId().equals(gk.getId())) { //港口
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                csypwkg_gkSsZdNum++;
                            } else {
                                csypwkg_gkSsFzdNum++;
                            }
                        }
                        csypwkg_gkCost += gctx;
                    } else if (property.getId().equals(jc.getId())) { //航空
                        if (property.getId().equals(ss.getId())) {
                            if (isMajor) {
                                csypwkg_hkSsZdNum++;
                            } else {
                                csypwkg_hkSsFzdNum++;
                            }
                        }
                        csypwkg_hkCost += gctx;
                    } else if (property.getId().equals(tl.getId())) { //铁路（市属）
                        if (property.getId().equals(ss.getId())) {
                            csypwkg_tlNum++;
                        }
                        csypwkg_tlCost += gctx;
                    }
                    if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptdl.getName())) { //大居配套（道路）
                        csypwkg_djptDlNum++;
                        csypwkg_djptDlCost += gctx;
                    }
                    if (!StringHelper.isEmpty(packageAttr) && packageAttr.equals(ptgj.getName())) { //大居配套（公交）
                        csypwkg_djptGjNum++;
                        csypwkg_djptGjCost += gctx;
                    }
                }
            }
        }
        //项目建议书未批
        //城市道路
        xmjyswp_szdlSsXj = xmjyswp_szdlSsZdNum + xmjyswp_szdlSsFzdNum;
        map.put("xmjyswp_szdl_xmnum", xmjyswp_xmNum);
        map.put("xmjyswp_szdl_ss_zd", xmjyswp_szdlSsZdNum);
        map.put("xmjyswp_szdl_ss_fzd", xmjyswp_szdlSsFzdNum);
        map.put("xmjyswp_szdl_ss_xj", xmjyswp_szdlSsXj);
        map.put("xmjyswp_szdl_qs", xmjyswp_szdlQsNum);
        map.put("xmjyswp_szdl_cost", MathHelper.formatDouble(xmjyswp_szdlCost, 4));
        //公交基础设施
        map.put("xmjyswp_gjjcss_ss", xmjyswp_gjjcssSsNum);
        map.put("xmjyswp_gjjcss_qs", xmjyswp_gjjcssQsdNum);
        map.put("xmjyswp_gjjcss_cost", MathHelper.formatDouble(xmjyswp_gjjcssCost, 4));
        //轨道
        xmjyswp_gdSsXj = xmjyswp_gdSsZdNum + xmjyswp_gdSsFzdNum;
        map.put("xmjyswp_gd_ss_zd", xmjyswp_gdSsZdNum);
        map.put("xmjyswp_gd_ss_fzd", xmjyswp_gdSsZdNum);
        map.put("xmjyswp_gd_ss_xj", xmjyswp_gdSsXj);
        map.put("xmjyswp_gd_ss_cost", MathHelper.formatDouble(xmjyswp_gdCost, 4));
        //内河
        xmjyswp_nhSsXj = xmjyswp_nhSsZdNum + xmjyswp_nhSsFzdNum;
        map.put("xmjyswp_nh_ss_zd", xmjyswp_nhSsZdNum);
        map.put("xmjyswp_nh_ss_fzd", xmjyswp_nhSsZdNum);
        map.put("xmjyswp_nh_ss_xj", xmjyswp_nhSsXj);
        map.put("xmjyswp_nh_ss_cost", MathHelper.formatDouble(xmjyswp_nhCost, 4));
        //港口
        xmjyswp_gkSsXj = xmjyswp_gkSsZdNum + xmjyswp_gkSsFzdNum;
        map.put("xmjyswp_gk_ss_zd", xmjyswp_gkSsZdNum);
        map.put("xmjyswp_gk_ss_fzd", xmjyswp_gkSsZdNum);
        map.put("xmjyswp_gk_ss_xj", xmjyswp_gkSsXj);
        map.put("xmjyswp_gk_ss_cost", MathHelper.formatDouble(xmjyswp_gkCost, 4));
        //航空
        xmjyswp_hkSsXj = xmjyswp_hkSsZdNum + xmjyswp_hkSsFzdNum;
        map.put("xmjyswp_hk_ss_zd", xmjyswp_hkSsZdNum);
        map.put("xmjyswp_hk_ss_fzd", xmjyswp_hkSsZdNum);
        map.put("xmjyswp_hk_ss_xj", xmjyswp_hkSsXj);
        map.put("xmjyswp_hk_ss_cost", MathHelper.formatDouble(xmjyswp_hkCost, 4));
        //铁路（市属）
        map.put("xmjyswp_tl", xmjyswp_tlNum);
        map.put("xmjyswp_tl_cost", MathHelper.formatDouble(xmjyswp_tlCost, 4));
        //大居配套（道路）
        map.put("xmjyswp_ptdl", xmjyswp_djptDlNum);
        map.put("xmjyswp_ptdl_cost", MathHelper.formatDouble(xmjyswp_djptDlCost, 4));
        //大居配套（公交）
        map.put("xmjyswp_ptgj", xmjyswp_djptGjNum);
        map.put("xmjyswp_ptgj_cost", MathHelper.formatDouble(xmjyswp_djptGjCost, 4));

        //工可未批复
        //城市道路
        gkwpf_szdlSsXj = gkwpf_szdlSsZdNum + gkwpf_szdlSsFzdNum;
        map.put("gkwpf_szdl_xmnum", gkwpf_xmNum);
        map.put("gkwpf_szdl_ss_zd", gkwpf_szdlSsZdNum);
        map.put("gkwpf_szdl_ss_fzd", gkwpf_szdlSsFzdNum);
        map.put("gkwpf_szdl_ss_xj", gkwpf_szdlSsXj);
        map.put("gkwpf_szdl_qs", gkwpf_szdlQsNum);
        map.put("gkwpf_szdl_cost", MathHelper.formatDouble(gkwpf_szdlCost, 4));
        //公交基础设施
        map.put("gkwpf_gjjcss_ss", gkwpf_gjjcssSsNum);
        map.put("gkwpf_gjjcss_qs", gkwpf_gjjcssQsdNum);
        map.put("gkwpf_gjjcss_cost", MathHelper.formatDouble(gkwpf_gjjcssCost, 4));
        //轨道
        gkwpf_gdSsXj = gkwpf_gdSsZdNum + gkwpf_gdSsFzdNum;
        map.put("gkwpf_gd_ss_zd", gkwpf_gdSsZdNum);
        map.put("gkwpf_gd_ss_fzd", gkwpf_gdSsZdNum);
        map.put("gkwpf_gd_ss_xj", gkwpf_gdSsXj);
        map.put("gkwpf_gd_ss_cost", MathHelper.formatDouble(gkwpf_gdCost, 4));
        //内河
        gkwpf_nhSsXj = gkwpf_nhSsZdNum + gkwpf_nhSsFzdNum;
        map.put("gkwpf_nh_ss_zd", gkwpf_nhSsZdNum);
        map.put("gkwpf_nh_ss_fzd", gkwpf_nhSsZdNum);
        map.put("gkwpf_nh_ss_xj", gkwpf_nhSsXj);
        map.put("gkwpf_nh_ss_cost", MathHelper.formatDouble(gkwpf_nhCost, 4));
        //港口
        gkwpf_gkSsXj = gkwpf_gkSsZdNum + gkwpf_gkSsFzdNum;
        map.put("gkwpf_gk_ss_zd", gkwpf_gkSsZdNum);
        map.put("gkwpf_gk_ss_fzd", gkwpf_gkSsZdNum);
        map.put("gkwpf_gk_ss_xj", gkwpf_gkSsXj);
        map.put("gkwpf_gk_ss_cost", MathHelper.formatDouble(gkwpf_gkCost, 4));
        //航空
        gkwpf_hkSsXj = gkwpf_hkSsZdNum + gkwpf_hkSsFzdNum;
        map.put("gkwpf_hk_ss_zd", gkwpf_hkSsZdNum);
        map.put("gkwpf_hk_ss_fzd", gkwpf_hkSsZdNum);
        map.put("gkwpf_hk_ss_xj", gkwpf_hkSsXj);
        map.put("gkwpf_hk_ss_cost", MathHelper.formatDouble(gkwpf_hkCost, 4));
        //铁路（市属）
        map.put("gkwpf_tl", gkwpf_tlNum);
        map.put("gkwpf_tl_cost", MathHelper.formatDouble(gkwpf_tlCost, 4));
        //大居配套（道路）
        map.put("gkwpf_ptdl", gkwpf_djptDlNum);
        map.put("gkwpf_ptdl_cost", MathHelper.formatDouble(gkwpf_djptDlCost, 4));
        //大居配套（公交）
        map.put("gkwpf_ptgj", gkwpf_djptGjNum);
        map.put("gkwpf_ptgj_cost", MathHelper.formatDouble(gkwpf_djptGjCost, 4));

        //工可已批初设未批
        //城市道路
        gkypcswp_szdlSsXj = gkypcswp_szdlSsZdNum + gkypcswp_szdlSsFzdNum;
        map.put("gkypcswp_szdl_xmnum", gkypcswp_xmNum);
        map.put("gkypcswp_szdl_ss_zd", gkypcswp_szdlSsZdNum);
        map.put("gkypcswp_szdl_ss_fzd", gkypcswp_szdlSsFzdNum);
        map.put("gkypcswp_szdl_ss_xj", gkypcswp_szdlSsXj);
        map.put("gkypcswp_szdl_qs", gkypcswp_szdlQsNum);
        map.put("gkypcswp_szdl_cost", MathHelper.formatDouble(gkypcswp_szdlCost, 4));
        //公交基础设施
        map.put("gkypcswp_gjjcss_ss", gkypcswp_gjjcssSsNum);
        map.put("gkypcswp_gjjcss_qs", gkypcswp_gjjcssQsdNum);
        map.put("gkypcswp_gjjcss_cost", MathHelper.formatDouble(gkypcswp_gjjcssCost, 4));
        //轨道
        gkypcswp_gdSsXj = gkypcswp_gdSsZdNum + gkypcswp_gdSsFzdNum;
        map.put("gkypcswp_gd_ss_zd", gkypcswp_gdSsZdNum);
        map.put("gkypcswp_gd_ss_fzd", gkypcswp_gdSsZdNum);
        map.put("gkypcswp_gd_ss_xj", gkypcswp_gdSsXj);
        map.put("gkypcswp_gd_ss_cost", MathHelper.formatDouble(gkypcswp_gdCost, 4));
        //内河
        gkypcswp_nhSsXj = gkypcswp_nhSsZdNum + gkypcswp_nhSsFzdNum;
        map.put("gkypcswp_nh_ss_zd", gkypcswp_nhSsZdNum);
        map.put("gkypcswp_nh_ss_fzd", gkypcswp_nhSsZdNum);
        map.put("gkypcswp_nh_ss_xj", gkypcswp_nhSsXj);
        map.put("gkypcswp_nh_ss_cost", MathHelper.formatDouble(gkypcswp_nhCost, 4));
        //港口
        gkypcswp_gkSsXj = gkypcswp_gkSsZdNum + gkypcswp_gkSsFzdNum;
        map.put("gkypcswp_gk_ss_zd", gkypcswp_gkSsZdNum);
        map.put("gkypcswp_gk_ss_fzd", gkypcswp_gkSsZdNum);
        map.put("gkypcswp_gk_ss_xj", gkypcswp_gkSsXj);
        map.put("gkypcswp_gk_ss_cost", MathHelper.formatDouble(gkypcswp_gkCost, 4));
        //航空
        gkypcswp_hkSsXj = gkypcswp_hkSsZdNum + gkypcswp_hkSsFzdNum;
        map.put("gkypcswp_hk_ss_zd", gkypcswp_hkSsZdNum);
        map.put("gkypcswp_hk_ss_fzd", gkypcswp_hkSsZdNum);
        map.put("gkypcswp_hk_ss_xj", gkypcswp_hkSsXj);
        map.put("gkypcswp_hk_ss_cost", MathHelper.formatDouble(gkypcswp_hkCost, 4));
        //铁路（市属）
        map.put("gkypcswp_tl", gkypcswp_tlNum);
        map.put("gkypcswp_tl_cost", MathHelper.formatDouble(gkypcswp_tlCost, 4));
        //大居配套（道路）
        map.put("gkypcswp_ptdl", gkypcswp_djptDlNum);
        map.put("gkypcswp_ptdl_cost", MathHelper.formatDouble(gkypcswp_djptDlCost, 4));
        //大居配套（公交）
        map.put("gkypcswp_ptgj", gkypcswp_djptGjNum);
        map.put("gkypcswp_ptgj_cost", MathHelper.formatDouble(gkypcswp_djptGjCost, 4));

        //初设已批未开工
        //城市道路
        csypwkg_szdlSsXj = csypwkg_szdlSsZdNum + csypwkg_szdlSsFzdNum;
        map.put("csypwkg_szdl_xmnum", csypwkg_xmNum);
        map.put("csypwkg_szdl_ss_zd", csypwkg_szdlSsZdNum);
        map.put("csypwkg_szdl_ss_fzd", csypwkg_szdlSsFzdNum);
        map.put("csypwkg_szdl_ss_xj", csypwkg_szdlSsXj);
        map.put("csypwkg_szdl_qs", csypwkg_szdlQsNum);
        map.put("csypwkg_szdl_cost", MathHelper.formatDouble(csypwkg_szdlCost, 4));
        //公交基础设施
        map.put("csypwkg_gjjcss_ss", csypwkg_gjjcssSsNum);
        map.put("csypwkg_gjjcss_qs", csypwkg_gjjcssQsdNum);
        map.put("csypwkg_gjjcss_cost", MathHelper.formatDouble(csypwkg_gjjcssCost, 4));
        //轨道
        csypwkg_gdSsXj = csypwkg_gdSsZdNum + csypwkg_gdSsFzdNum;
        map.put("csypwkg_gd_ss_zd", csypwkg_gdSsZdNum);
        map.put("csypwkg_gd_ss_fzd", csypwkg_gdSsZdNum);
        map.put("csypwkg_gd_ss_xj", csypwkg_gdSsXj);
        map.put("csypwkg_gd_ss_cost", MathHelper.formatDouble(csypwkg_gdCost, 4));
        //内河
        csypwkg_nhSsXj = csypwkg_nhSsZdNum + csypwkg_nhSsFzdNum;
        map.put("csypwkg_nh_ss_zd", csypwkg_nhSsZdNum);
        map.put("csypwkg_nh_ss_fzd", csypwkg_nhSsZdNum);
        map.put("csypwkg_nh_ss_xj", csypwkg_nhSsXj);
        map.put("csypwkg_nh_ss_cost", MathHelper.formatDouble(csypwkg_nhCost, 4));
        //港口
        csypwkg_gkSsXj = csypwkg_gkSsZdNum + csypwkg_gkSsFzdNum;
        map.put("csypwkg_gk_ss_zd", csypwkg_gkSsZdNum);
        map.put("csypwkg_gk_ss_fzd", csypwkg_gkSsZdNum);
        map.put("csypwkg_gk_ss_xj", csypwkg_gkSsXj);
        map.put("csypwkg_gk_ss_cost", MathHelper.formatDouble(csypwkg_gkCost, 4));
        //航空
        csypwkg_hkSsXj = csypwkg_hkSsZdNum + csypwkg_hkSsFzdNum;
        map.put("csypwkg_hk_ss_zd", csypwkg_hkSsZdNum);
        map.put("csypwkg_hk_ss_fzd", csypwkg_hkSsZdNum);
        map.put("csypwkg_hk_ss_xj", csypwkg_hkSsXj);
        map.put("csypwkg_hk_ss_cost", MathHelper.formatDouble(csypwkg_hkCost, 4));
        //铁路（市属）
        map.put("csypwkg_tl", csypwkg_tlNum);
        map.put("csypwkg_tl_cost", MathHelper.formatDouble(csypwkg_tlCost, 4));
        //大居配套（道路）
        map.put("csypwkg_ptdl", csypwkg_djptDlNum);
        map.put("csypwkg_ptdl_cost", MathHelper.formatDouble(csypwkg_djptDlCost, 4));
        //大居配套（公交）
        map.put("csypwkg_ptgj", csypwkg_djptGjNum);
        map.put("csypwkg_ptgj_cost", MathHelper.formatDouble(csypwkg_djptGjCost, 4));

        //未开工项目小计
        //城市道路
        map.put("wkg_szdl_ss_zd", xmjyswp_szdlSsZdNum + gkwpf_szdlSsZdNum + gkypcswp_szdlSsZdNum + csypwkg_szdlSsZdNum);
        map.put("wkg_szdl_ss_fzd", xmjyswp_szdlSsFzdNum + gkwpf_szdlSsFzdNum + gkypcswp_szdlSsFzdNum + csypwkg_szdlSsFzdNum);
        map.put("wkg_szdl_ss_xj", xmjyswp_szdlSsXj + gkwpf_szdlSsXj + gkypcswp_szdlSsXj + csypwkg_szdlSsXj);
        map.put("wkg_szdl_qs", xmjyswp_szdlQsNum + gkwpf_szdlQsNum + gkypcswp_szdlQsNum + csypwkg_szdlQsNum);
        map.put("wkg_szdl_cost", MathHelper.formatDouble(xmjyswp_szdlCost + gkwpf_szdlCost + gkypcswp_szdlCost + csypwkg_szdlCost, 4));
        //公交基础设施
        map.put("wkg_gjjcss_ss", xmjyswp_gjjcssSsNum + gkwpf_gjjcssSsNum + gkypcswp_gjjcssSsNum + csypwkg_gjjcssSsNum);
        map.put("wkg_gjjcss_qs", xmjyswp_gjjcssQsdNum + gkwpf_gjjcssQsdNum + gkypcswp_gjjcssQsdNum + csypwkg_gjjcssQsdNum);
        map.put("wkg_gjjcss_cost", MathHelper.formatDouble(xmjyswp_gjjcssCost + gkwpf_gjjcssCost + gkypcswp_gjjcssCost + csypwkg_gjjcssCost, 4));
        //轨道
        map.put("wkg_gd_ss_zd", xmjyswp_gdSsZdNum + gkwpf_gdSsZdNum + gkypcswp_gdSsZdNum + csypwkg_gdSsZdNum);
        map.put("wkg_gd_ss_fzd", xmjyswp_gdSsFzdNum + gkwpf_gdSsFzdNum + gkypcswp_gdSsFzdNum + csypwkg_gdSsFzdNum);
        map.put("wkg_gd_ss_xj", xmjyswp_gdSsXj + gkwpf_gdSsXj + gkypcswp_gdSsXj + csypwkg_gdSsXj);
        map.put("wkg_gd_ss_cost", MathHelper.formatDouble(xmjyswp_gdCost + gkwpf_gdCost + gkypcswp_gdCost + csypwkg_gdCost, 4));
        //内河
        map.put("wkg_nh_ss_zd", xmjyswp_nhSsZdNum + gkwpf_nhSsZdNum + gkypcswp_nhSsZdNum + csypwkg_nhSsZdNum);
        map.put("wkg_nh_ss_fzd", xmjyswp_nhSsFzdNum + gkwpf_nhSsFzdNum + gkypcswp_nhSsFzdNum + csypwkg_nhSsFzdNum);
        map.put("wkg_nh_ss_xj", xmjyswp_nhSsXj + gkwpf_nhSsXj + gkypcswp_nhSsXj + csypwkg_nhSsXj);
        map.put("wkg_nh_ss_cost", MathHelper.formatDouble(xmjyswp_nhCost + gkwpf_nhCost + gkypcswp_nhCost + csypwkg_nhCost, 4));
        //港口
        map.put("wkg_gk_ss_zd", xmjyswp_gkSsZdNum + gkwpf_gkSsZdNum + gkypcswp_gkSsZdNum + csypwkg_gkSsZdNum);
        map.put("wkg_gk_ss_fzd", xmjyswp_gkSsFzdNum + gkwpf_gkSsFzdNum + gkypcswp_gkSsFzdNum + csypwkg_gkSsFzdNum);
        map.put("wkg_gk_ss_xj", xmjyswp_gkSsXj + gkwpf_gkSsXj + gkypcswp_gkSsXj + csypwkg_gkSsXj);
        map.put("wkg_gk_ss_cost", MathHelper.formatDouble(xmjyswp_gkCost + gkwpf_gkCost + gkypcswp_gkCost + csypwkg_gkCost, 4));
        //航空
        map.put("wkg_hk_ss_zd", xmjyswp_hkSsZdNum + gkwpf_hkSsZdNum + gkypcswp_hkSsZdNum + csypwkg_hkSsZdNum);
        map.put("wkg_hk_ss_fzd", xmjyswp_hkSsFzdNum + gkwpf_hkSsFzdNum + gkypcswp_hkSsFzdNum + csypwkg_hkSsFzdNum);
        map.put("wkg_hk_ss_xj", xmjyswp_hkSsXj + gkwpf_hkSsXj + gkypcswp_hkSsXj + csypwkg_hkSsXj);
        map.put("wkg_hk_ss_cost", MathHelper.formatDouble(xmjyswp_hkCost + gkwpf_hkCost + gkypcswp_hkCost + csypwkg_hkCost, 4));
        //铁路（市属）
        map.put("wkg_tl", xmjyswp_tlNum + gkwpf_tlNum + gkypcswp_tlNum + csypwkg_tlNum);
        map.put("wkg_tl_cost", MathHelper.formatDouble(xmjyswp_tlCost + gkwpf_tlCost + gkypcswp_tlCost + csypwkg_tlCost, 4));
        //大居配套（道路）
        map.put("wkg_ptdl", xmjyswp_djptDlNum + gkwpf_djptDlNum + gkypcswp_djptDlNum + csypwkg_djptDlNum);
        map.put("wkg_ptdl_cost", MathHelper.formatDouble(xmjyswp_djptDlCost + gkwpf_djptDlCost + gkypcswp_djptDlCost + csypwkg_djptDlCost, 4));
        //大居配套（公交）
        map.put("wkg_ptgj", xmjyswp_djptGjNum + gkwpf_djptGjNum + gkypcswp_djptGjNum + csypwkg_djptGjNum);
        map.put("wkg_ptgj_cost", MathHelper.formatDouble(xmjyswp_djptGjCost + gkwpf_djptGjCost + gkypcswp_djptGjCost + csypwkg_djptGjCost, 4));

        //项目总计
        //城市道路
        map.put("szdl_ss_zd", ywg_szdlSsZdNum + zj_szdlSsZdNum + xmjyswp_szdlSsZdNum + gkwpf_szdlSsZdNum + gkypcswp_szdlSsZdNum + csypwkg_szdlSsZdNum);
        map.put("szdl_ss_fzd", ywg_szdlSsFzdNum + zj_szdlSsFzdNum + xmjyswp_szdlSsFzdNum + gkwpf_szdlSsFzdNum + gkypcswp_szdlSsFzdNum + csypwkg_szdlSsFzdNum);
        map.put("szdl_ss_xj", ywg_szdlSsXj + zj_szdlSsXj + xmjyswp_szdlSsXj + gkwpf_szdlSsXj + gkypcswp_szdlSsXj + csypwkg_szdlSsXj);
        map.put("szdl_qs", ywg_szdlQsNum + zj_szdlQsNum + xmjyswp_szdlQsNum + gkwpf_szdlQsNum + gkypcswp_szdlQsNum + csypwkg_szdlQsNum);
        map.put("szdl_cost", MathHelper.formatDouble(ywg_szdlCost + zj_szdlCost + xmjyswp_szdlCost + gkwpf_szdlCost + gkypcswp_szdlCost + csypwkg_szdlCost, 4));
        //公交基础设施
        map.put("gjjcss_ss", ywg_gjjcssSsNum + zj_gjjcssSsNum + xmjyswp_gjjcssSsNum + gkwpf_gjjcssSsNum + gkypcswp_gjjcssSsNum + csypwkg_gjjcssSsNum);
        map.put("gjjcss_qs", ywg_gjjcssQsdNum + zj_gjjcssQsdNum + xmjyswp_gjjcssQsdNum + gkwpf_gjjcssQsdNum + gkypcswp_gjjcssQsdNum + csypwkg_gjjcssQsdNum);
        map.put("gjjcss_cost", MathHelper.formatDouble(ywg_gjjcssCost + zj_gjjcssCost + xmjyswp_gjjcssCost + gkwpf_gjjcssCost + gkypcswp_gjjcssCost + csypwkg_gjjcssCost, 4));
        //轨道
        map.put("gd_ss_zd", ywg_gdSsZdNum + zj_gdSsZdNum + xmjyswp_gdSsZdNum + gkwpf_gdSsZdNum + gkypcswp_gdSsZdNum + csypwkg_gdSsZdNum);
        map.put("gd_ss_fzd", ywg_gdSsFzdNum + zj_gdSsFzdNum + xmjyswp_gdSsFzdNum + gkwpf_gdSsFzdNum + gkypcswp_gdSsFzdNum + csypwkg_gdSsFzdNum);
        map.put("gd_ss_xj", ywg_gdSsXj + zj_gdSsXj + xmjyswp_gdSsXj + gkwpf_gdSsXj + gkypcswp_gdSsXj + csypwkg_gdSsXj);
        map.put("gd_ss_cost", MathHelper.formatDouble(ywg_gdCost + zj_gdCost + xmjyswp_gdCost + gkwpf_gdCost + gkypcswp_gdCost + csypwkg_gdCost, 4));
        //内河
        map.put("nh_ss_zd", ywg_nhSsZdNum + zj_nhSsZdNum + xmjyswp_nhSsZdNum + gkwpf_nhSsZdNum + gkypcswp_nhSsZdNum + csypwkg_nhSsZdNum);
        map.put("nh_ss_fzd", ywg_nhSsFzdNum + zj_nhSsFzdNum + xmjyswp_nhSsFzdNum + gkwpf_nhSsFzdNum + gkypcswp_nhSsFzdNum + csypwkg_nhSsFzdNum);
        map.put("nh_ss_xj", ywg_nhSsXj + zj_nhSsXj + xmjyswp_nhSsXj + gkwpf_nhSsXj + gkypcswp_nhSsXj + csypwkg_nhSsXj);
        map.put("nh_ss_cost", MathHelper.formatDouble(ywg_nhCost + zj_nhCost + xmjyswp_nhCost + gkwpf_nhCost + gkypcswp_nhCost + csypwkg_nhCost, 4));
        //港口
        map.put("gk_ss_zd", ywg_gkSsZdNum + zj_gkSsZdNum + xmjyswp_gkSsZdNum + gkwpf_gkSsZdNum + gkypcswp_gkSsZdNum + csypwkg_gkSsZdNum);
        map.put("gk_ss_fzd", ywg_gkSsFzdNum + zj_gkSsFzdNum + xmjyswp_gkSsFzdNum + gkwpf_gkSsFzdNum + gkypcswp_gkSsFzdNum + csypwkg_gkSsFzdNum);
        map.put("gk_ss_xj", ywg_gkSsXj + zj_gkSsXj + xmjyswp_gkSsXj + gkwpf_gkSsXj + gkypcswp_gkSsXj + csypwkg_gkSsXj);
        map.put("gk_ss_cost", MathHelper.formatDouble(ywg_gkCost + zj_gkCost + xmjyswp_gkCost + gkwpf_gkCost + gkypcswp_gkCost + csypwkg_gkCost, 4));
        //航空
        map.put("hk_ss_zd", ywg_hkSsZdNum + zj_hkSsZdNum + xmjyswp_hkSsZdNum + gkwpf_hkSsZdNum + gkypcswp_hkSsZdNum + csypwkg_hkSsZdNum);
        map.put("hk_ss_fzd", ywg_hkSsFzdNum + zj_hkSsFzdNum + xmjyswp_hkSsFzdNum + gkwpf_hkSsFzdNum + gkypcswp_hkSsFzdNum + csypwkg_hkSsFzdNum);
        map.put("hk_ss_xj", ywg_hkSsXj + zj_hkSsXj + xmjyswp_hkSsXj + gkwpf_hkSsXj + gkypcswp_hkSsXj + csypwkg_hkSsXj);
        map.put("hk_ss_cost", MathHelper.formatDouble(ywg_hkCost + zj_hkCost + xmjyswp_hkCost + gkwpf_hkCost + gkypcswp_hkCost + csypwkg_hkCost, 4));
        //铁路（市属）
        map.put("tl", ywg_tlNum + zj_tlNum + xmjyswp_tlNum + gkwpf_tlNum + gkypcswp_tlNum + csypwkg_tlNum);
        map.put("tl_cost", MathHelper.formatDouble(ywg_tlCost + zj_tlCost + xmjyswp_tlCost + gkwpf_tlCost + gkypcswp_tlCost + csypwkg_tlCost, 4));
        //大居配套（道路）
        map.put("ptdl", ywg_djptDlNum + zj_djptDlNum + xmjyswp_djptDlNum + gkwpf_djptDlNum + gkypcswp_djptDlNum + csypwkg_djptDlNum);
        map.put("ptdl_cost", MathHelper.formatDouble(ywg_djptDlCost + zj_djptDlCost + xmjyswp_djptDlCost + gkwpf_djptDlCost + gkypcswp_djptDlCost + csypwkg_djptDlCost, 4));
        //大居配套（公交）
        map.put("ptgj", ywg_djptGjNum + zj_djptGjNum + xmjyswp_djptGjNum + gkwpf_djptGjNum + gkypcswp_djptGjNum + csypwkg_djptGjNum);
        map.put("ptgj_cost", MathHelper.formatDouble(ywg_djptGjCost + zj_djptGjCost + xmjyswp_djptGjCost + gkwpf_djptGjCost + gkypcswp_djptGjCost + csypwkg_djptGjCost, 4));

        model.addAttribute("map", map);

        return "view/query/projectQuerySum/init";
    }
}
