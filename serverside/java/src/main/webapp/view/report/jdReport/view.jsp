<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    function printExcelFR(){
        var typeCode = "${bean.reportType.code}";
        if(typeCode == ""){
            showErrorMsg("无法打印，请先设置报告类型！");
        }else{
            printFR("jdReport_"+typeCode,"id=${bean.id}");
        }
    }
</script>

<div class="form_div" align="center">
<div align="center" class="tr_dark">
<div class="div_space"></div>
<fieldset class="form_fieldset">
    <legend class="form_legend">工程情况</legend>

    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right">监督任务书编号：</td>
            <td class="form_content">
                &nbsp;${bean.jdTaskCode}
            </td>
            <td class="form_label_right">报告类型：</td>
            <td class="form_content">
                &nbsp;${bean.reportType.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">工程名称：</td>
            <td class="form_content">
                &nbsp;${bean.projectName}
            </td>
            <td class="form_label_right">工程造价：</td>
            <td class="form_content">
                &nbsp;${content.gczj}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">建筑面积：</td>
            <td class="form_content">
                &nbsp;${content.jzmj}
            </td>
            <td class="form_label_right">工程类型：</td>
            <td class="form_content">
                &nbsp;${content.gclx}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">开工时间：</td>
            <td class="form_content">
                &nbsp;${content.kgsj}
            </td>
            <td class="form_label_right">竣工验收时间：</td>
            <td class="form_content">
                &nbsp;${content.jgyssj}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">建设单位名称：</td>
            <td class="form_content">
                &nbsp;${bean.buildUnit}
            </td>
            <td class="form_label_right">项目负责人：</td>
            <td class="form_content">
                &nbsp;${content.jsdw_fzr}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">勘察单位名称：</td>
            <td class="form_content">
                &nbsp;${content.kcdwmc}
            </td>
            <td class="form_label_right">项目负责人：</td>
            <td class="form_content">
                &nbsp;${content.kcdw_fzr}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">设计单位名称：</td>
            <td class="form_content">
                &nbsp;${content.sjdwmc}
            </td>
            <td class="form_label_right">项目负责人：</td>
            <td class="form_content">
                &nbsp;${content.sjdw_fzr}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">施工单位名称：</td>
            <td class="form_content">
                &nbsp;${content.sgdwmc}
            </td>
            <td class="form_label_right">项目经理：</td>
            <td class="form_content">
                &nbsp;${content.sgdw_fzr}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">监理单位名称：</td>
            <td class="form_content">
                &nbsp;${content.jldwmc}
            </td>
            <td class="form_label_right">项目负责人：</td>
            <td class="form_content">
                &nbsp;${content.jldw_fzr}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">审图单位名称：</td>
            <td class="form_content">
                &nbsp;${content.stdwmc}
            </td>
            <td class="form_label_right">&nbsp;</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" width="15%" nowrap="true">检测单位名称：</td>
            <td class="form_content" width="35%">
                &nbsp;${content.jcdwmc}
            </td>
            <td class="form_label_right" width="15%" nowrap="true">节能检测单位名称：</td>
            <td class="form_content" width="35%">
                &nbsp;${content.jnjcdwmc}
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">质量监督申报</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_content" colspan="2" width="55%">&nbsp;监督申报时间：&nbsp;${content.zljd_sbrq}</td>
            <td class="form_content" colspan="2" width="45%">&nbsp;报建编号：&nbsp;${content.bjbh}</td>
        </tr>
        <tr>
            <td colspan="4">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_header" align="center">
                        <td width="30%" class="form_border">&nbsp;</td>
                        <td width="25%" class="form_border">姓名</td>
                        <td width="25%" class="form_border">专业</td>
                        <td width="25%" class="form_border">监督证编号</td>
                    </tr>
                    <tr class="tr_light" align="center">
                        <td class="form_border">监督部门负责人</td>
                        <td class="form_border" align="center">&nbsp;${content.zljd_bmfzr_xm}</td>
                        <td class="form_border">&nbsp;${content.zljd_bmfzr_zy}</td>
                        <td class="form_border">&nbsp;${content.zljd_bmfzr_bh}</td>
                    </tr>
                    <tr class="tr_dark" align="center">
                        <td class="form_border">质量监督工程师</td>
                        <td class="form_border">&nbsp;${content.zljd_gcs_xm}</td>
                        <td class="form_border">&nbsp;${content.zljd_gcs_zy}</td>
                        <td class="form_border">&nbsp;${content.zljd_gcs_bh}</td>
                    </tr>
                    <tr class="tr_light" align="center">
                        <td class="form_border" rowspan="3">质量监督人员</td>
                        <td class="form_border">&nbsp;${content.zljd_ry1_xm}</td>
                        <td class="form_border">&nbsp;${content.zljd_ry1_zy}</td>
                        <td class="form_border">&nbsp;${content.zljd_ry1_bh}</td>
                    </tr>
                    <tr class="tr_light" align="center">
                        <td class="form_border">&nbsp;${content.zljd_ry2_xm}</td>
                        <td class="form_border">&nbsp;${content.zljd_ry2_zy}</td>
                        <td class="form_border">&nbsp;${content.zljd_ry2_bh}</td>
                    </tr>
                    <tr class="tr_light" align="center">
                        <td class="form_border">&nbsp;${content.zljd_ry3_xm}</td>
                        <td class="form_border">&nbsp;${content.zljd_ry3_zy}</td>
                        <td class="form_border">&nbsp;${content.zljd_ry3_bh}</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">工程报监、开工前质量监督情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="15%" nowrap="true">首次交底会议时间：</td>
            <td class="form_content" width="35%">
                &nbsp;${content.kgq_scjdhy_rq}
            </td>
            <td class="form_label_right" width="15%" nowrap="true">节能监督首次时间：</td>
            <td class="form_content" width="35%">
                &nbsp;${content.kgq_jnjdsc_rq}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                &nbsp;<sys:toHtml>${content.kgq_sm}</sys:toHtml>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">施工过程中质量监督检查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_content" colspan="4">&nbsp;&nbsp;抽查次数：
                &nbsp;${content.gcz_cccs}，
                &nbsp;&nbsp;&nbsp;涉及
                    ${content.gcz_ccbw_desc}
                &nbsp;&nbsp;&nbsp;等部位结构，未见违反工程建设标准强制性条文要求的问题存在。
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_content" colspan="4">&nbsp;&nbsp;抄送我站的分部质量验收证明包括：
                <span style="color:teal;font-weight:bold;">
                        ${content.gcz_fbyszm_desc}
                </span>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_content" colspan="4">
                &nbsp;&nbsp;签发《建设工程局部暂停施工整改指令单》：
                &nbsp;${content.gcz_zgzld}
                份，
                &nbsp;&nbsp;&nbsp;签发《建设工程质量问题整改通知》
                &nbsp;${content.gcz_zgtz}
                份
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                &nbsp;<sys:toHtml>${content.gcz_sm}</sys:toHtml>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">桩基、基础、主体、节能部位质量检测抽查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                &nbsp;<sys:toHtml>${content.zjbw_sm}</sys:toHtml>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">节能保温工程质量监督检查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_content" colspan="3">&nbsp;&nbsp;节能形式</td>
        </tr>
        <tr class="tr_dark" style="color:green">
            <td class="form_content" colspan="3">&nbsp;&nbsp;1) 墙体保温系统<input type="checkbox" name="jnbwgc_xt_lx"
                                                                             value="无" <c:if test="${fn:indexOf(content.jnbwgc_xt_lx,'无')>=0||content.jnbwgc_xt_lx ==null}">checked</c:if>/><font color="red">无</font></td>
        </tr>
        <tr class="tr_dark" style="color:red">
            <td class="form_content" width="15%" nowrap="true">&nbsp;&nbsp;<input type="checkbox" name="jnbwgc_xt_lx"
                                                                                  value="外墙外保温" <c:if test="${fn:indexOf(content.jnbwgc_xt_lx,'外墙外保温')>=0}">checked</c:if>/>外墙外保温
            </td>
            <td class="form_content" width="85%" colspan="2">
                    ${content.jnbwgc_xt_wqwbw_desc}
            </td>
        </tr>
        <tr class="tr_dark" style="color:red">
            <td class="form_content">&nbsp;&nbsp;<input type="checkbox" name="jnbwgc_xt_lx" value="外墙内保温" <c:if test="${fn:indexOf(content.jnbwgc_xt_lx,'外墙内保温')>=0}">checked</c:if>/>外墙内保温</td>
            <td class="form_content" colspan="2">
                    ${content.jnbwgc_xt_wqnbw_desc}
            </td>
        </tr>
        <tr class="tr_dark" style="color:red">
            <td class="form_content">&nbsp;&nbsp;<input type="checkbox" name="jnbwgc_xt_lx" value="墙体自保温" <c:if test="${fn:indexOf(content.jnbwgc_xt_lx,'墙体自保温')>=0}">checked</c:if>/>墙体自保温</td>
            <td class="form_content" colspan="2">
                    ${content.jnbwgc_xt_qtzbw_desc}
            </td>
        </tr>
        <tr class="tr_dark" style="color:green">
            <td class="form_content">&nbsp;&nbsp;2) 屋面保温</td>
            <td class="form_content" colspan="2">
                    ${content.jnbwgc_wmbw_desc}
            </td>
        </tr>
        <tr class="tr_dark" style="color:green">
            <td class="form_content">&nbsp;&nbsp;3) 门窗保温</td>
            <td class="form_content" colspan="2">
                    ${content.jnbwgc_mcbw_desc}
            </td>
        </tr>
        <tr class="tr_dark" style="color:green">
            <td class="form_content">&nbsp;&nbsp;4) 其他节能</td>
            <td class="form_content" colspan="2">
                &nbsp;${content.jnbwgc_qtjn_qt}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_border">抽查次数</td>
            <td class="form_content" colspan="2">
                &nbsp;${content.jnbwgc_cccs}
                次，
                &nbsp;&nbsp;&nbsp;签发《建设工程质量问题整改通知》
                &nbsp;${content.jnbwgc_zgs}
                份
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">其他应说明的情况：</td>
            <td class="form_content" colspan="2">
                &nbsp;<sys:toHtml>${content.jnbwgc_sm}</sys:toHtml>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">工程建设参与各方执行国家强制性标注，质量行为及质量责任制履行情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                &nbsp;<sys:toHtml>${content.zlxw_sm}</sys:toHtml>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">工程竣工质量、技术资料抽查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                &nbsp;<sys:toHtml>${content.jszlcc_sm}</sys:toHtml>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">竣工质量检测、试验抽查情况</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%" nowrap="true">已通过室内环境质量检测：</td>
            <td class="form_content" colspan="3">
                &nbsp;${content.syccqk_hjjc}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">抽查建筑物的围护结构：</td>
            <td class="form_content" colspan="3">
                    ${content.syccqk_whjg_desc}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                &nbsp;<sys:toHtml>${content.syccqk_sm}</sys:toHtml>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">对工程遗留质量缺陷的监督意见</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">其他应说明的情况：</td>
            <td class="form_content" colspan="3">
                &nbsp;<sys:toHtml>${content.zlqx_sm}</sys:toHtml>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<fieldset class="form_fieldset">
    <legend class="form_legend">监督报告信息</legend>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="15%" nowrap="true">监督报告编制日期：</td>
            <td class="form_content" width="35%">
                &nbsp;${bean.reportDate}
            </td>
            <td class="form_label_right" width="15%" nowrap="true">监督报告编制人：</td>
            <td class="form_content" width="35%">
                &nbsp;${bean.reportPerson}
            </td>
        </tr>
        <tr>
            <td colspan="2" class="form_border"></td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>

<div class="tr_button">
    <input type="button" class="button_all" value="打印" onclick="printExcelFR();"/>
    <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
</div>
</div>
</div>