<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">工程名称：</td>
                    <td class="form_content" width="45%" nowrap>&nbsp;
                        ${data.projectName}
                    </td>
                    <td class="form_label_right" width="15%">报建编号：</td>
                    <td class="form_content" width="25%">&nbsp;
                        ${data.bjbh}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">工程地点：</td>
                    <td class="form_content">&nbsp;
                        ${data.projectAdd}
                    </td>
                    <td class="form_label_right">项目类型：</td>
                    <td class="form_content">&nbsp;
                        ${data.reportType}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">单位工程名称：</td>
                    <td class="form_content">&nbsp;
                        ${bean.dwgcName}
                    </td>
                    <td class="form_label_right">单位工程编号：</td>
                    <td class="form_content">&nbsp;
                        ${bean.customCode}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">工程造价：</td>
                    <td class="form_content">&nbsp;
                        ${bean.dwgcMoney}
                    </td>
                    <td class="form_label_right">建筑面积：</td>
                    <td class="form_content">&nbsp;
                        ${bean.dwgcArea}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监报日期：</td>
                    <td class="form_content" colspan="3">&nbsp;
                        ${data.jdDatetime}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设单位：</td>
                    <td class="form_content" colspan="3">&nbsp;
                        ${data.jsUnitName}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">施工单位：</td>
                    <td class="form_content" colspan="3">&nbsp;
                        ${data.sgzbUnitName}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">勘察单位：</td>
                    <td class="form_content" colspan="3">&nbsp;
                        ${data.kcUnitName}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">设计单位：</td>
                    <td class="form_content" colspan="3">&nbsp;
                        ${data.sjUnitName}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">监理单位：</td>
                    <td class="form_content" colspan="3">&nbsp;
                        ${data.jlUnitName}
                    </td>
                </tr>
            </table>
        </tr>
        <tr class="tr_button">
            <td class="form_td_line" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>