package com.justonetech.biz.domain.bean.jdReport;

/**
 * 监督报告内容
 * User: Chen Junping
 * Date: 12-5-17
 */
public class JdReportContent {
    private String code;    //编号
    private String buildUnit;  //建设单位名称
    private String dwgcmc;  //单位工程名称
    private String zljddw;  //质量监督单位

    private String projectName;    //工程名称
    private String gczj;     //工程造价
    private String jzmj;    //建筑面积
    private String gclx;    //工程类型
    private String kgsj;    //开工时间
    private String jgyssj;    //竣工验收时间

    private String jsdw_fzr;    //建设单位项目负责人
    private String kcdwmc;    //勘察单位名称
    private String kcdw_fzr;    //勘察单位项目负责人
    private String sjdwmc;    //设计单位名称
    private String sjdw_fzr;    //设计单位项目负责人
    private String sgdwmc;    //施工单位名称
    private String sgdw_fzr;    //施工单位项目负责人
    private String jldwmc;    //监理单位名称
    private String jldw_fzr;    //监理单位项目负责人
    private String stdwmc;    //审图单位名称
    private String jcdwmc;    //检测单位名称
    private String jnjcdwmc;    //节能检测单位名称

    private String zljd_sbrq;    //质量监督申报时间
    private String bjbh;    //报建编号

    private String zljd_bmfzr_xm;    //监督部门负责人姓名
    private String zljd_bmfzr_zy;    //监督部门负责人专业
    private String zljd_bmfzr_bh;    //监督部门负责人监督证编号

    private String zljd_gcs_xm;    //质量监督工程师姓名
    private String zljd_gcs_zy;    //质量监督工程师专业
    private String zljd_gcs_bh;    //质量监督工程师监督证编号

    private String zljd_ry1_xm;    //质量监督人员1姓名
    private String zljd_ry1_zy;    //质量监督人员1专业
    private String zljd_ry1_bh;    //质量监督人员1监督证编号
    private String zljd_ry2_xm;    //质量监督人员2姓名
    private String zljd_ry2_zy;    //质量监督人员2专业
    private String zljd_ry2_bh;    //质量监督人员2监督证编号
    private String zljd_ry3_xm;    //质量监督人员3姓名
    private String zljd_ry3_zy;    //质量监督人员3专业
    private String zljd_ry3_bh;    //质量监督人员3监督证编号

    private String kgq_scjdhy_rq;    //工程报监、开工前质量监督情况—首次交底会议时间
    private String kgq_jnjdsc_rq;    //工程报监、开工前质量监督情况—节能监督首次时间
    private String kgq_sm;    //工程报监、开工前质量监督情况—其他情况说明

    private String gcz_cccs;    //施工过程中质量监督检查情况—抽查次数
    private String gcz_ccbw;          //施工过程中质量监督检查情况—抽查部位
    private String gcz_ccbw_desc;    //施工过程中质量监督检查情况—抽查部位_输出显示
    private String gcz_fbyszm;          //施工过程中质量监督检查情况—分部验收证明
    private String gcz_fbyszm_desc;    //施工过程中质量监督检查情况—分部验收证明_输出显示
    private String gcz_zgzld;    //施工过程中质量监督检查情况—整改指令单份数
    private String gcz_zgtz;    //施工过程中质量监督检查情况—整改通知份数
    private String gcz_sm;    //施工过程中质量监督检查情况—其他情况说明

    private String zjbw_bt;    //基础桩基部位质量检测抽查情况—标题
    private String zjbw_sm;    //基础桩基部位质量检测抽查情况—其他情况说明


    private String jnbwgc_xt_lx;    //节能保温工程监督检查情况—墙体保温系统类型（无、外墙外保温、外墙内保温、墙体自保温）
    private String jnbwgc_xt_wqwbw_xx;    //节能保温工程监督检查情况—墙体保温系统—外墙外保温_选项
    private String jnbwgc_xt_wqwbw_qt;    //节能保温工程监督检查情况—墙体保温系统—外墙外保温_其他
    private String jnbwgc_xt_wqwbw_desc;    //节能保温工程监督检查情况—墙体保温系统—外墙外保温_输出显示

    private String jnbwgc_xt_wqnbw_xx;    //节能保温工程监督检查情况—墙体保温系统—外墙内保温_选项
    private String jnbwgc_xt_wqnbw_qt;    //节能保温工程监督检查情况—墙体保温系统—外墙内保温_其他
    private String jnbwgc_xt_wqnbw_desc;    //节能保温工程监督检查情况—墙体保温系统—外墙内保温_输出显示

    private String jnbwgc_xt_qtzbw_xx;    //节能保温工程监督检查情况—墙体保温系统—墙体自保温_选项
    private String jnbwgc_xt_qtzbw_qt;    //节能保温工程监督检查情况—墙体保温系统—墙体自保温_其他
    private String jnbwgc_xt_qtzbw_desc;    //节能保温工程监督检查情况—墙体保温系统—墙体自保温_输出显示

    private String jnbwgc_wmbw_lx;    //节能保温工程监督检查情况—屋面保温_选项
    private String jnbwgc_wmbw_qt;    //节能保温工程监督检查情况—屋面保温_其他
    private String jnbwgc_wmbw_desc;    //节能保温工程监督检查情况—屋面保温_输出显示

    private String jnbwgc_mcbw_lx;    //节能保温工程监督检查情况—门窗保温_选项
    private String jnbwgc_mcbw_qt;    //节能保温工程监督检查情况—门窗保温_其他
    private String jnbwgc_mcbw_desc;    //节能保温工程监督检查情况—门窗保温_输出显示

    private String jnbwgc_qtjn_qt;    //节能保温工程监督检查情况—其他节能
    private String jnbwgc_cccs;    //节能保温工程监督检查情况—抽查次数
    private String jnbwgc_zgs;    //节能保温工程监督检查情况—签发整改通知数
    private String jnbwgc_sm;    //节能保温工程监督检查情况—其他情况说明

    private String zlxw_sm;    //质量行为及质量责任制履行情况—其他情况说明

    private String jszlcc_sm;    //工程竣工质量、技术资料抽查情况—其他情况说明

    private String syccqk_hjjc;    //竣工质量检测、试验抽查情况—已通过室内环境质量检测
    private String syccqk_whjg;    //竣工质量检测、试验抽查情况—围护结构
    private String syccqk_whjg_desc;    //竣工质量检测、试验抽查情况—围护结构_输出显示
    private String syccqk_sm;    //竣工质量检测、试验抽查情况—其他情况说明

    private String zlqx_sm;    //对工程遗留质量缺陷的监督意见—其他情况说明

    private String reportDate;    //监督报告编制日期
    private String flowCode;    //流转编号
    private String file_name;    //单位工程明细表文件名称
    private String category;    //报告格式类型(有节能)

    /******************************* 核查表 begin ***********************************/
//    private String audit1_opinion;    //审核1_意见
//    private String audit1_person;    //审核1_人员
//    private String audit1_date;    //审核1_日期
//
//    private String audit2_opinion;    //审核2_意见
//    private String audit2_person;    //审核2_人员
//    private String audit2_date;    //审核2_日期
//
//    private String audit3_opinion;    //审核3_意见
//    private String audit3_person;    //审核3_人员
//    private String audit3_date;    //审核3_日期
//
//    private String audit4_opinion;    //审核4_意见
//    private String audit4_person;    //审核4_人员
//    private String audit4_date;    //审核4_日期
//
//    private String audit5_opinion;    //审核5_意见
//    private String audit5_person;    //审核5_人员
//    private String audit5_date;    //审核5_日期
//
//    private String audit6_opinion;    //审核6_意见
//    private String audit6_person;    //审核6_人员
//    private String audit6_date;    //审核6_日期
//
//    private String audit7_opinion;    //审核7_意见
//    private String audit7_person;    //审核7_人员
//    private String audit7_date;    //审核7_日期
//
//    private String audit8_opinion;    //审核8_意见
//    private String audit8_person;    //审核8_人员
//    private String audit8_date;    //审核8_日期
//
//    private String audit_person;    //签发人
//    private String audit_date;      //签发_日期
    /******************************* 核查表 end ***********************************/

    /******************************* checkbox begin ***********************************/
    public static final String CHECKBOX_gcz_ccbw = "桩基,基础,主体,节能,电梯,路基,结构层,下部结构,管道,中间";  //施工过程中质量监督检查情况—抽查部位
//    public static final String CHECKBOX_gcz_fbyszm = "桩基/中间,基础/路基,主体/结构层,节能/下部,电梯/管线";  //抄送我站的分部质量验收证明包括
    public static final String CHECKBOX_gcz_fbyszm = CHECKBOX_gcz_ccbw;  //抄送我站的分部质量验收证明包括
    public static final String CHECKBOX_jnbwgc_xt_wqwbw_xx = "EPS,XPS,胶粉聚苯颗粒,保温砂浆,其他";       //外墙外保温
    public static final String CHECKBOX_jnbwgc_xt_wqnbw_xx = "砂加气保温块,EPS,胶粉聚苯颗粒,其他";       //外墙内保温
    public static final String CHECKBOX_jnbwgc_xt_qtzbw_xx = "砂加气保温块,其他";       //墙体自保温
    public static final String CHECKBOX_jnbwgc_wmbw_lx = "XPS,其他";       //屋面保温
    public static final String CHECKBOX_jnbwgc_mcbw_lx = "节能门窗检测，中空玻璃类型";       //门窗保温
    public static final String CHECKBOX_syccqk_whjg = "墙体,屋面,门窗,玻璃,幕墙";       //抽查建筑物的围护结构
//    public static final String CHECKBOX_FILTER = "gcz_ccbw,gcz_fbyszm,jnbwgc_xt_wqwbw_xx,jnbwgc_xt_wqnbw_xx,jnbwgc_xt_qtzbw_xx,jnbwgc_wmbw_lx,jnbwgc_mcbw_lx,syccqk_whjg"; //获取页面复选项数据时需特殊处理
    public static final String CHECKBOX_FILTER = "jnbwgc_xt_lx,gcz_ccbw,gcz_fbyszm,jnbwgc_xt_wqwbw_xx,jnbwgc_xt_wqnbw_xx,jnbwgc_xt_qtzbw_xx,jnbwgc_wmbw_lx,jnbwgc_mcbw_lx,syccqk_whjg"; //获取页面复选项数据时需特殊处理
    /******************************* checkbox end ***********************************/

    public JdReportContent() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }

    public String getDwgcmc() {
        return dwgcmc;
    }

    public void setDwgcmc(String dwgcmc) {
        this.dwgcmc = dwgcmc;
    }

    public String getZljddw() {
        return zljddw;
    }

    public void setZljddw(String zljddw) {
        this.zljddw = zljddw;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGczj() {
        return gczj;
    }

    public void setGczj(String gczj) {
        this.gczj = gczj;
    }

    public String getJzmj() {
        return jzmj;
    }

    public void setJzmj(String jzmj) {
        this.jzmj = jzmj;
    }

    public String getGclx() {
        return gclx;
    }

    public void setGclx(String gclx) {
        this.gclx = gclx;
    }

    public String getKgsj() {
        return kgsj;
    }

    public void setKgsj(String kgsj) {
        this.kgsj = kgsj;
    }

    public String getJgyssj() {
        return jgyssj;
    }

    public void setJgyssj(String jgyssj) {
        this.jgyssj = jgyssj;
    }

    public String getJsdw_fzr() {
        return jsdw_fzr;
    }

    public void setJsdw_fzr(String jsdw_fzr) {
        this.jsdw_fzr = jsdw_fzr;
    }

    public String getKcdwmc() {
        return kcdwmc;
    }

    public void setKcdwmc(String kcdwmc) {
        this.kcdwmc = kcdwmc;
    }

    public String getKcdw_fzr() {
        return kcdw_fzr;
    }

    public void setKcdw_fzr(String kcdw_fzr) {
        this.kcdw_fzr = kcdw_fzr;
    }

    public String getSjdwmc() {
        return sjdwmc;
    }

    public void setSjdwmc(String sjdwmc) {
        this.sjdwmc = sjdwmc;
    }

    public String getSjdw_fzr() {
        return sjdw_fzr;
    }

    public void setSjdw_fzr(String sjdw_fzr) {
        this.sjdw_fzr = sjdw_fzr;
    }

    public String getSgdwmc() {
        return sgdwmc;
    }

    public void setSgdwmc(String sgdwmc) {
        this.sgdwmc = sgdwmc;
    }

    public String getSgdw_fzr() {
        return sgdw_fzr;
    }

    public void setSgdw_fzr(String sgdw_fzr) {
        this.sgdw_fzr = sgdw_fzr;
    }

    public String getJldwmc() {
        return jldwmc;
    }

    public void setJldwmc(String jldwmc) {
        this.jldwmc = jldwmc;
    }

    public String getJldw_fzr() {
        return jldw_fzr;
    }

    public void setJldw_fzr(String jldw_fzr) {
        this.jldw_fzr = jldw_fzr;
    }

    public String getStdwmc() {
        return stdwmc;
    }

    public void setStdwmc(String stdwmc) {
        this.stdwmc = stdwmc;
    }

    public String getJcdwmc() {
        return jcdwmc;
    }

    public void setJcdwmc(String jcdwmc) {
        this.jcdwmc = jcdwmc;
    }

    public String getJnjcdwmc() {
        return jnjcdwmc;
    }

    public void setJnjcdwmc(String jnjcdwmc) {
        this.jnjcdwmc = jnjcdwmc;
    }

    public String getZljd_sbrq() {
        return zljd_sbrq;
    }

    public void setZljd_sbrq(String zljd_sbrq) {
        this.zljd_sbrq = zljd_sbrq;
    }

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public String getZljd_bmfzr_xm() {
        return zljd_bmfzr_xm;
    }

    public void setZljd_bmfzr_xm(String zljd_bmfzr_xm) {
        this.zljd_bmfzr_xm = zljd_bmfzr_xm;
    }

    public String getZljd_bmfzr_zy() {
        return zljd_bmfzr_zy;
    }

    public void setZljd_bmfzr_zy(String zljd_bmfzr_zy) {
        this.zljd_bmfzr_zy = zljd_bmfzr_zy;
    }

    public String getZljd_bmfzr_bh() {
        return zljd_bmfzr_bh;
    }

    public void setZljd_bmfzr_bh(String zljd_bmfzr_bh) {
        this.zljd_bmfzr_bh = zljd_bmfzr_bh;
    }

    public String getZljd_gcs_xm() {
        return zljd_gcs_xm;
    }

    public void setZljd_gcs_xm(String zljd_gcs_xm) {
        this.zljd_gcs_xm = zljd_gcs_xm;
    }

    public String getZljd_gcs_zy() {
        return zljd_gcs_zy;
    }

    public void setZljd_gcs_zy(String zljd_gcs_zy) {
        this.zljd_gcs_zy = zljd_gcs_zy;
    }

    public String getZljd_gcs_bh() {
        return zljd_gcs_bh;
    }

    public void setZljd_gcs_bh(String zljd_gcs_bh) {
        this.zljd_gcs_bh = zljd_gcs_bh;
    }

    public String getZljd_ry1_xm() {
        return zljd_ry1_xm;
    }

    public void setZljd_ry1_xm(String zljd_ry1_xm) {
        this.zljd_ry1_xm = zljd_ry1_xm;
    }

    public String getZljd_ry1_zy() {
        return zljd_ry1_zy;
    }

    public void setZljd_ry1_zy(String zljd_ry1_zy) {
        this.zljd_ry1_zy = zljd_ry1_zy;
    }

    public String getZljd_ry1_bh() {
        return zljd_ry1_bh;
    }

    public void setZljd_ry1_bh(String zljd_ry1_bh) {
        this.zljd_ry1_bh = zljd_ry1_bh;
    }

    public String getZljd_ry2_xm() {
        return zljd_ry2_xm;
    }

    public void setZljd_ry2_xm(String zljd_ry2_xm) {
        this.zljd_ry2_xm = zljd_ry2_xm;
    }

    public String getZljd_ry2_zy() {
        return zljd_ry2_zy;
    }

    public void setZljd_ry2_zy(String zljd_ry2_zy) {
        this.zljd_ry2_zy = zljd_ry2_zy;
    }

    public String getZljd_ry2_bh() {
        return zljd_ry2_bh;
    }

    public void setZljd_ry2_bh(String zljd_ry2_bh) {
        this.zljd_ry2_bh = zljd_ry2_bh;
    }

    public String getZljd_ry3_xm() {
        return zljd_ry3_xm;
    }

    public void setZljd_ry3_xm(String zljd_ry3_xm) {
        this.zljd_ry3_xm = zljd_ry3_xm;
    }

    public String getZljd_ry3_zy() {
        return zljd_ry3_zy;
    }

    public void setZljd_ry3_zy(String zljd_ry3_zy) {
        this.zljd_ry3_zy = zljd_ry3_zy;
    }

    public String getZljd_ry3_bh() {
        return zljd_ry3_bh;
    }

    public void setZljd_ry3_bh(String zljd_ry3_bh) {
        this.zljd_ry3_bh = zljd_ry3_bh;
    }

    public String getKgq_scjdhy_rq() {
        return kgq_scjdhy_rq;
    }

    public void setKgq_scjdhy_rq(String kgq_scjdhy_rq) {
        this.kgq_scjdhy_rq = kgq_scjdhy_rq;
    }

    public String getKgq_jnjdsc_rq() {
        return kgq_jnjdsc_rq;
    }

    public void setKgq_jnjdsc_rq(String kgq_jnjdsc_rq) {
        this.kgq_jnjdsc_rq = kgq_jnjdsc_rq;
    }

    public String getKgq_sm() {
        return kgq_sm;
    }

    public void setKgq_sm(String kgq_sm) {
        this.kgq_sm = kgq_sm;
    }

    public String getGcz_cccs() {
        return gcz_cccs;
    }

    public void setGcz_cccs(String gcz_cccs) {
        this.gcz_cccs = gcz_cccs;
    }

    public String getGcz_ccbw() {
        return gcz_ccbw;
    }

    public void setGcz_ccbw(String gcz_ccbw) {
        this.gcz_ccbw = gcz_ccbw;
    }

    public String getGcz_ccbw_desc() {
        return gcz_ccbw_desc;
    }

    public void setGcz_ccbw_desc(String gcz_ccbw_desc) {
        this.gcz_ccbw_desc = gcz_ccbw_desc;
    }

    public String getGcz_fbyszm() {
        return gcz_fbyszm;
    }

    public void setGcz_fbyszm(String gcz_fbyszm) {
        this.gcz_fbyszm = gcz_fbyszm;
    }

    public String getGcz_fbyszm_desc() {
        return gcz_fbyszm_desc;
    }

    public void setGcz_fbyszm_desc(String gcz_fbyszm_desc) {
        this.gcz_fbyszm_desc = gcz_fbyszm_desc;
    }

    public String getGcz_zgzld() {
        return gcz_zgzld;
    }

    public void setGcz_zgzld(String gcz_zgzld) {
        this.gcz_zgzld = gcz_zgzld;
    }

    public String getGcz_zgtz() {
        return gcz_zgtz;
    }

    public void setGcz_zgtz(String gcz_zgtz) {
        this.gcz_zgtz = gcz_zgtz;
    }

    public String getGcz_sm() {
        return gcz_sm;
    }

    public void setGcz_sm(String gcz_sm) {
        this.gcz_sm = gcz_sm;
    }

    public String getZjbw_bt() {
        return zjbw_bt;
    }

    public void setZjbw_bt(String zjbw_bt) {
        this.zjbw_bt = zjbw_bt;
    }

    public String getZjbw_sm() {
        return zjbw_sm;
    }

    public void setZjbw_sm(String zjbw_sm) {
        this.zjbw_sm = zjbw_sm;
    }

    public String getJnbwgc_xt_lx() {
        return jnbwgc_xt_lx;
    }

    public void setJnbwgc_xt_lx(String jnbwgc_xt_lx) {
        this.jnbwgc_xt_lx = jnbwgc_xt_lx;
    }

    public String getJnbwgc_xt_wqwbw_xx() {
        return jnbwgc_xt_wqwbw_xx;
    }

    public void setJnbwgc_xt_wqwbw_xx(String jnbwgc_xt_wqwbw_xx) {
        this.jnbwgc_xt_wqwbw_xx = jnbwgc_xt_wqwbw_xx;
    }

    public String getJnbwgc_xt_wqwbw_qt() {
        return jnbwgc_xt_wqwbw_qt;
    }

    public void setJnbwgc_xt_wqwbw_qt(String jnbwgc_xt_wqwbw_qt) {
        this.jnbwgc_xt_wqwbw_qt = jnbwgc_xt_wqwbw_qt;
    }

    public String getJnbwgc_xt_wqwbw_desc() {
        return jnbwgc_xt_wqwbw_desc;
    }

    public void setJnbwgc_xt_wqwbw_desc(String jnbwgc_xt_wqwbw_desc) {
        this.jnbwgc_xt_wqwbw_desc = jnbwgc_xt_wqwbw_desc;
    }

    public String getJnbwgc_xt_wqnbw_xx() {
        return jnbwgc_xt_wqnbw_xx;
    }

    public void setJnbwgc_xt_wqnbw_xx(String jnbwgc_xt_wqnbw_xx) {
        this.jnbwgc_xt_wqnbw_xx = jnbwgc_xt_wqnbw_xx;
    }

    public String getJnbwgc_xt_wqnbw_qt() {
        return jnbwgc_xt_wqnbw_qt;
    }

    public void setJnbwgc_xt_wqnbw_qt(String jnbwgc_xt_wqnbw_qt) {
        this.jnbwgc_xt_wqnbw_qt = jnbwgc_xt_wqnbw_qt;
    }

    public String getJnbwgc_xt_wqnbw_desc() {
        return jnbwgc_xt_wqnbw_desc;
    }

    public void setJnbwgc_xt_wqnbw_desc(String jnbwgc_xt_wqnbw_desc) {
        this.jnbwgc_xt_wqnbw_desc = jnbwgc_xt_wqnbw_desc;
    }

    public String getJnbwgc_xt_qtzbw_xx() {
        return jnbwgc_xt_qtzbw_xx;
    }

    public void setJnbwgc_xt_qtzbw_xx(String jnbwgc_xt_qtzbw_xx) {
        this.jnbwgc_xt_qtzbw_xx = jnbwgc_xt_qtzbw_xx;
    }

    public String getJnbwgc_xt_qtzbw_qt() {
        return jnbwgc_xt_qtzbw_qt;
    }

    public void setJnbwgc_xt_qtzbw_qt(String jnbwgc_xt_qtzbw_qt) {
        this.jnbwgc_xt_qtzbw_qt = jnbwgc_xt_qtzbw_qt;
    }

    public String getJnbwgc_xt_qtzbw_desc() {
        return jnbwgc_xt_qtzbw_desc;
    }

    public void setJnbwgc_xt_qtzbw_desc(String jnbwgc_xt_qtzbw_desc) {
        this.jnbwgc_xt_qtzbw_desc = jnbwgc_xt_qtzbw_desc;
    }

    public String getJnbwgc_wmbw_lx() {
        return jnbwgc_wmbw_lx;
    }

    public void setJnbwgc_wmbw_lx(String jnbwgc_wmbw_lx) {
        this.jnbwgc_wmbw_lx = jnbwgc_wmbw_lx;
    }

    public String getJnbwgc_wmbw_qt() {
        return jnbwgc_wmbw_qt;
    }

    public void setJnbwgc_wmbw_qt(String jnbwgc_wmbw_qt) {
        this.jnbwgc_wmbw_qt = jnbwgc_wmbw_qt;
    }

    public String getJnbwgc_wmbw_desc() {
        return jnbwgc_wmbw_desc;
    }

    public void setJnbwgc_wmbw_desc(String jnbwgc_wmbw_desc) {
        this.jnbwgc_wmbw_desc = jnbwgc_wmbw_desc;
    }

    public String getJnbwgc_mcbw_lx() {
        return jnbwgc_mcbw_lx;
    }

    public void setJnbwgc_mcbw_lx(String jnbwgc_mcbw_lx) {
        this.jnbwgc_mcbw_lx = jnbwgc_mcbw_lx;
    }

    public String getJnbwgc_mcbw_qt() {
        return jnbwgc_mcbw_qt;
    }

    public void setJnbwgc_mcbw_qt(String jnbwgc_mcbw_qt) {
        this.jnbwgc_mcbw_qt = jnbwgc_mcbw_qt;
    }

    public String getJnbwgc_mcbw_desc() {
        return jnbwgc_mcbw_desc;
    }

    public void setJnbwgc_mcbw_desc(String jnbwgc_mcbw_desc) {
        this.jnbwgc_mcbw_desc = jnbwgc_mcbw_desc;
    }

    public String getJnbwgc_qtjn_qt() {
        return jnbwgc_qtjn_qt;
    }

    public void setJnbwgc_qtjn_qt(String jnbwgc_qtjn_qt) {
        this.jnbwgc_qtjn_qt = jnbwgc_qtjn_qt;
    }

    public String getJnbwgc_cccs() {
        return jnbwgc_cccs;
    }

    public void setJnbwgc_cccs(String jnbwgc_cccs) {
        this.jnbwgc_cccs = jnbwgc_cccs;
    }

    public String getJnbwgc_zgs() {
        return jnbwgc_zgs;
    }

    public void setJnbwgc_zgs(String jnbwgc_zgs) {
        this.jnbwgc_zgs = jnbwgc_zgs;
    }

    public String getJnbwgc_sm() {
        return jnbwgc_sm;
    }

    public void setJnbwgc_sm(String jnbwgc_sm) {
        this.jnbwgc_sm = jnbwgc_sm;
    }

    public String getZlxw_sm() {
        return zlxw_sm;
    }

    public void setZlxw_sm(String zlxw_sm) {
        this.zlxw_sm = zlxw_sm;
    }

    public String getJszlcc_sm() {
        return jszlcc_sm;
    }

    public void setJszlcc_sm(String jszlcc_sm) {
        this.jszlcc_sm = jszlcc_sm;
    }

    public String getSyccqk_hjjc() {
        return syccqk_hjjc;
    }

    public void setSyccqk_hjjc(String syccqk_hjjc) {
        this.syccqk_hjjc = syccqk_hjjc;
    }

    public String getSyccqk_whjg() {
        return syccqk_whjg;
    }

    public void setSyccqk_whjg(String syccqk_whjg) {
        this.syccqk_whjg = syccqk_whjg;
    }

    public String getSyccqk_whjg_desc() {
        return syccqk_whjg_desc;
    }

    public void setSyccqk_whjg_desc(String syccqk_whjg_desc) {
        this.syccqk_whjg_desc = syccqk_whjg_desc;
    }

    public String getSyccqk_sm() {
        return syccqk_sm;
    }

    public void setSyccqk_sm(String syccqk_sm) {
        this.syccqk_sm = syccqk_sm;
    }

    public String getZlqx_sm() {
        return zlqx_sm;
    }

    public void setZlqx_sm(String zlqx_sm) {
        this.zlqx_sm = zlqx_sm;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
