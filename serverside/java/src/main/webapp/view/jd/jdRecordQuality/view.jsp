<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/view/jd/jdRecordQuestion/commonJs.jsp" %>
<div class="form_div">
<script type="text/javascript">
    $(function () {
        getWeek('jdDatetime', 'week');
        /*初始化quality_check_behavior*/
        loadAjaxData("quality_check_behavior", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_QUALITY_CHECK_TYPE}&questionTypeCode=${JD_RECORD_QUALITY_CHECK_BEHAVIOR}&formId=${bean.id}&pageStyle=view");
        /*初始化quality_check_entity*/
        loadAjaxData("quality_check_entity", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_QUALITY_CHECK_TYPE}&questionTypeCode=${JD_RECORD_QUALITY_CHECK_ENTITY}&formId=${bean.id}&pageStyle=view");
    })
    function print() {
        printFR("jdRecordQuality", encodeURI("id=${bean.id}"));
    };
</script>
<table class="form_table" cellpadding="0" cellspacing="0">
    <tr class="tr_dark">
        <td colspan="2">
            <fieldset style="width: 90%;margin:0px auto">
                <legend class="form_legend">
                    基本信息
                </legend>
                <table class="form_table" cellpadding="0" cellspacing="0">
                    <tr class="tr_light">
                        <td class="form_label_right" width="15%">监督记录编号：</td>
                        <td class="form_content" width="35%">
                            ${bean.jdTaskCode}
                        </td>
                    <%--</tr>--%>

                    <%--<tr class="tr_dark">--%>
                        <%--<td class="form_label_right" style="width: 15%">流转编号：</td>--%>
                        <%--<td class="form_content" style="width: 35%">${bean.flowCode}</td>--%>
                        <td class="form_label_right" style="width: 15%">报建编号：</td>
                        <td class="form_content" style="width: 35%">${bean.bjbh}</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right">工程名称：</td>
                        <td class="form_content">${bean.projectName}</td>
                        <td class="form_label_right">天气：</td>
                        <td class="form_content">${bean.weather}</td>
                    </tr>

                    <tr class="tr_dark">
                        <td class="form_label_right">监督日期：</td>
                        <td class="form_content" nowrap="true">
                            <fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>
                            <input type="hidden" name="jdDatetime" id="jdDatetime" value="${bean.jdDatetime}"/>
                        <td class="form_label_right">星期：</td>
                        <td class="form_content">
                            <div id="week">&nbsp;</div>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right">监督负责人：</td>
                        <td class="form_content">
                            ${bean.jdManagerName}</td>
                        <td class="form_label_right">参加监督人员：</td>
                        <td class="form_content">
                            ${bean.attendPersons}</td>
                    </tr>
                    <tr>
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
        </td>
    </tr>
    <tr class="tr_dark">
        <td colspan="2">
            <fieldset style="width: 90%;margin:0px auto">
                <legend class="form_legend">
                    参建单位参加抽查人员
                </legend>
                <table class="form_table" cellpadding="0" cellspacing="0">
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%">建设单位：</td>
                        <td class="form_content">${bean.jsDept}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right">勘察单位：</td>
                        <td class="form_content">${bean.kcDept}</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right">设计单位：</td>
                        <td class="form_content">${bean.sjDept}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right">施工单位：</td>
                        <td class="form_content">${bean.sgDept}</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right">监理单位：</td>
                        <td class="form_content">${bean.jlDept}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right">检测单位：</td>
                        <td class="form_content">${bean.jcDept}</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right">监督机构：</td>
                        <td class="form_content">${jdDept}</td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
    <tr class="tr_dark">
        <td colspan="2">
            <fieldset style="width: 90%;margin:0px auto">

                <table class="form_table" cellpadding="0" cellspacing="0">
                    <tr class="tr_dark">
                        <td class="form_label" style="width: 80px">施工进度：</td>
                        <td class="form_content">
                            <%--${bean.scheduleItems" cssClass="input_textarea"--%>
                            <%--cssStyle="width: 100%"></form:textarea>--%>
                            <sys:checkbox name="scheduleItems" colNum="0" code="PollingRecordStage" showType="view"
                                          checkedNames="${bean.scheduleItems}" isSaveName="true"
                                          inputType="checkbox"></sys:checkbox>
                        </td>
                    </tr>

                    <tr>
                        <td class="form_label" style="width: 80px">监理对工程质<br>量状况的报告</td>
                        <td class="form_content">
                            ${bean.notifyContent}
                        </td>
                    </tr>

                </table>
            </fieldset>
        </td>
    </tr>
    <tr class="tr_dark">
        <td colspan="2">
            <fieldset style="width: 90%;margin:0px auto">
                <legend class="form_legend">质量行为抽查记录</legend>
                <table class="form_table" cellpadding="0" cellspacing="0">
                    <tr class="tr_dark">
                        <td class="form_label" style="width: 80px">抽查<br>对象<br>内容</td>
                        <td class="form_content">
                            ${bean.inspectionContent}
                        </td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="2">
                            <div id="quality_check_behavior"></div>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
    <tr class="tr_dark">
        <td colspan="2">
            <fieldset style="width: 90%;margin:0px auto">
                <legend class="form_legend"> 实体质量抽查记录</legend>
                <table class="form_table" cellpadding="0" cellspacing="0">
                    <tr class="tr_dark">
                        <td class="form_label" style="width: 80px">抽查内容<br>和部位
                        </td>
                        <td class="form_content">
                            ${bean.inspectionPosition}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="quality_check_entity"></div>
                        </td>
                    </tr>
                </table>

            </fieldset>
        </td>
    </tr>
    <tr class="tr_dark">
        <td colspan="2">
            <fieldset style="width: 90%;margin:0px auto">

                <table class="form_table" cellpadding="0" cellspacing="0">
                    <tr class="tr_dark">
                        <td style="width: 80px" class="form_label">监督抽测：</td>
                        <td class="form_content">
                            ${bean.jdInspection}
                        </td>
                    </tr>
                    <tr class="tr_dark">
                        <td style="width: 80px" class="form_label">总处理意见：</td>
                        <td class="form_content">
                            ${bean.dealOpinion}
                        </td>
                    </tr>
                    <tr class="tr_dark">
                        <td style="width: 80px" class="form_label">备注：</td>
                        <td class="form_content">
                            ${bean.description}
                        </td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
    <tr class="tr_button">
        <td colspan="2">
            <input type="button" value="打印" class="button_all" onclick="print()">
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
</table>

</div>
