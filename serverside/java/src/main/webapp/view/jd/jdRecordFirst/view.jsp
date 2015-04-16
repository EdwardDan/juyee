<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
 <script type="text/javascript">
        $(function () {
//            getWeek('jdDatetime','week');
            loadAjaxData("quality_check_behavior", "${ctx}/jdRecordQuestion/getRecordList.do?formTypeCode=${JD_RECORD_FIRST_CHECK_TYPE}&questionTypeCode=${JD_RECORD_FIRST_CHECK_NORMAL}&formId=${bean.id}&pageStyle=view");
        });
        function print() {
            printFR("jdRecordFirst", encodeURI("id=${bean.id}&xingqi=${weekCn}"));
        }
 </script>
    <div class="form_div">
    <div align="center" class="tr_dark">
        <div class="div_space"></div>
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">基本信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">监督任务书编号：</td>
                    <td class="form_content" width="35%">&nbsp;
                     ${bean.jdTaskCode}</td>
                    <td class="form_label_right"  width="15%">报建编号：</td>
                    <td class="form_content"  width="35%" nowrap> &nbsp;
                              ${bean.bjbh}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">工程名称：</td>
                    <td class="form_content"nowrap>&nbsp;
                             ${bean.projectName}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监督记录编号：</td>
                    <td class="form_content">&nbsp;
                             ${bean.code}</td>
                    </td>
                    <td class="form_label_right">天气：</td>
                    <td class="form_content">&nbsp;
                             ${bean.weather}</td>

                </tr>

                <tr class="tr_dark">
                    <td class="form_label_right">监督日期：&nbsp;</td>
                    <td class="form_content" nowrap>
                        <fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>
                        <input type="hidden" name="jdDatetime" id="jdDatetime" value="${bean.jdDatetime}"/>
                     </td>

                    <td class="form_label_right">星期：</td>
                    <td class="form_content">
                        &nbsp;${weekCn}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监督负责人：</td>
                    <td class="form_content">&nbsp;
                           ${bean.jdManagerName}</td>
                     <td class="form_label_right">参加监督人员：</td>
                    <td class="form_content">&nbsp;
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
        <div class="div_space"></div>
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">参建单位参加抽查人员</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" width="15%">建设单位：</td>
                    <td class="form_content">&nbsp;
                          ${bean.jsDept}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">勘察单位：</td>
                    <td class="form_content">&nbsp;
                          ${bean.kcDept}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">设计单位：</td>
                    <td class="form_content">&nbsp;
                          ${bean.sjDept}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">施工单位：</td>
                    <td class="form_content">&nbsp;
                          ${bean.sgDept}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">监理单位：</td>
                    <td class="form_content">&nbsp;
                          ${bean.jlDept}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">检测单位：</td>
                    <td class="form_content">&nbsp;
                         ${bean.jcDept}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">监督机构：</td>
                    <td class="form_content">${jdDeptNameNew}</td>
                </tr>
                <tr class="tr_light">
                <td class="form_label_right"nowrap style="width: 80px">告知情况：</td>
                <td class="form_content">&nbsp;
                        ${bean.notifyContent} </td>
            </tr>
            </table>
        </fieldset>
        <div class="div_space"></div>
        <fieldset style="width: 90%;margin:0px auto">
            <legend class="form_legend">监督详情</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right"nowrap width="15%">抽查对象内容：</td>
                <td class="form_content">&nbsp;
                        ${bean.inspectionContent}</td>
            </tr>
                <tr>
                    <td colspan="2">
                        <div id="quality_check_behavior"></div>
                    </td>
                </tr>
            </table>


            <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right"nowrap width="15%">总处理意见：</td>
                <td class="form_content">&nbsp;
                     ${bean.dealOpinion}</td>
            </tr>
            <tr>
                <td class="form_label_right"nowrap width="15%">备注：</td>
                <td class="form_content">
                    ${bean.description}</td>
            </tr>
            </table>
        </fieldset>
        <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_button">
            <td colspan="2">
                <input type="button" value="打印" class="button_all" onclick="print()">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
        </table>

    </div>
</div>
