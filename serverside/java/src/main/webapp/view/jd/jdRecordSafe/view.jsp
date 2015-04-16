<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    $(function () {
        //页面验证初始化
        getWeek('jdDatetime', 'week');
        loadAjaxData("safeCheck", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_SAFE_CHECK_TYPE}&questionTypeCode=${JD_RECORD_SAFE_CHECK_BEHAVIOR}&formId=${bean.id}&pageStyle=view");
        loadAjaxData("safeConstr", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_SAFE_CHECK_TYPE}&questionTypeCode=${JD_RECORD_SAFE_CHECK_FACILITY}&formId=${bean.id}&pageStyle=view");
    });
    function printExcelFR() {
        printFR("JdRecordSafe", "id=${bean.id}");
    }
</script>


<div class="form_div">
    <div class="div_space"></div>
    <fieldset class="form_fieldset">
        <input type="hidden" name="status" id="status" value="${bean.status}"/>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" width="20%">监督任务书编号：</td>
                <td class="form_content"  width="30%" nowrap="true">
                    ${bean.jdTaskCode}
                </td>
            <%--</tr>--%>
            <%--<tr class="tr_dark">--%>
                <%--<td class="form_label" colspan="1">流转编号：</td>--%>
                <%--<td class="form_content" colspan="3">--%>
                    <%--${bean.flowCode}--%>
                <%--</td>--%>
                <td class="form_label_right" width="20%">报建编号：</td>
                <td class="form_content" width="30%" >
                    ${bean.bjbh}
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right" >工程名称：</td>
                <td class="form_content" colspan="3">
                    ${bean.projectName}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" >监督记录编号：</td>
                <td class="form_content" >
                    ${bean.code}
                </td>
                <td class="form_label_right" >天气：</td>
                <td class="form_content">
                    ${bean.weather}
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right" >监督日期：</td>
                <td class="form_content" nowrap >
                    <fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>
                    <input type="hidden" name="jdDatetime" id="jdDatetime" value="${bean.jdDatetime}"/>
                </td>

                <td class="form_label_right" >星期：</td>
                <td class="form_content">
                    <div id="week">
                        &nbsp;</div>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right" >监督负责人：</td>
                <td class="form_content" >
                    ${bean.jdManagerName}
                </td>
                <td class="form_label_right" >参加监督人员：</td>
                <td class="form_content" >
                    ${bean.attendPersons}
                </td>
            </tr>
            <tr class="tr_light" style="display: none;">
                <td class="form_label_right">单位工程：</td>
                <td class="form_content" colspan="3">&nbsp;
                    ${bean.dwgc.dwgcName}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">附件：</td>
                <td class="form_content" colspan="3">
                    ${docButton}
                </td>
            </tr>
        </table>
    </fieldset>
    <div class="div_space"></div>
    <fieldset class="form_fieldset">
        <legend class="form_legend">参建单位参加抽查人员</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">

            <tr class="tr_light">
                <td class="form_label" colspan="1">建设单位：</td>
                <td class="form_content" colspan="3">
                    ${bean.jsDept}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">勘察单位：</td>
                <td class="form_content">
                    ${bean.kcDept}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">设计单位：</td>
                <td class="form_content">
                    ${bean.sjDept}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">施工单位：</td>
                <td class="form_content">
                    ${bean.sgDept}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">监理单位：</td>
                <td class="form_content">
                    ${bean.jlDept}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">检测单位：</td>
                <td class="form_content">
                    ${bean.jcDept}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">监督机构：</td>
                <td class="form_content">
                    ${jdjg}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">施工进度：</td>
                <td class="form_content" nowrap>
                    <sys:checkbox name="scheduleItems" colNum="0" code="PollingRecordStage" showType="view"
                                  checkedNames="${bean.scheduleItems}" isSaveName="true"
                                  inputType="checkbox"></sys:checkbox>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="form_fieldset">
        <legend class="form_legend">安全行为检查</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label" nowrap style="width: 80px">抽查对象内容：</td>
                <td class="form_content">
                    ${bean.inspectionContent}
                </td>
            </tr>
        </table>
        <div id="safeCheck"></div>
    </fieldset>
    <fieldset class="form_fieldset">
        <legend class="form_legend">安全设施检查</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label" nowrap style="width: 80px">抽查对象内容：</td>
                <td class="form_content">
                    ${bean.inspectionPosition}
                </td>
            </tr>
        </table>
        <div id="safeConstr"></div>
    </fieldset>
    <div class="div_space"></div>
    <fieldset class="form_fieldset">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label" style="width: 80px" nowrap>总处理意见：</td>
                <td class="form_content">
                    ${bean.dealOpinion}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label" style="width: 80px" nowrap>备注：</td>
                <td class="form_content">
                    ${bean.description}
                </td>
            </tr>
        </table>
    </fieldset>


    <div class="div_space"></div>
    <tr class="tr_button">
        <td class="form_label"></td>
        <td class="form_content">
            <input type="button" class="button_all" value="打印" onclick="printExcelFR();"/>
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
    </table>
</div>