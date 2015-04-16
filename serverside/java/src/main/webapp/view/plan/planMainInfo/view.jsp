<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        loadProjectDatas();
    });
    function loadProjectDatas() {
        var param = "<flowCode></flowCode><group></group><date></date>";
        var url = "${ctx}/planDetail/getDetailList.do?id=${bean.id}&param=" + param + "&isEdit=${isEdit}";
        loadAjaxData("flowList", url);
    }
</script>
<div class="no_scrollbar">
    <div class="form_div">
        <div align="center" class="tr_dark">
            <div class="div_space"></div>
            <fieldset class="form_fieldset">
                <legend class="form_legend">计划基本信息</legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_light">
                        <td class="form_label">计划编号：</td>
                        <td class="form_content">
                            &nbsp;${bean.planCode}
                        </td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label">计划名称：</td>
                        <td class="form_content">
                            &nbsp;${bean.planName}
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label">计划描述：</td>
                        <td class="form_content">
                            &nbsp;<sys:toHtml>${bean.planDesc}</sys:toHtml>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <div class="div_space"></div>
            <fieldset class="form_fieldset">
                <legend class="form_legend">计划详情</legend>
                <div class="form_table" id="flowList"></div>
            </fieldset>
            <div class="div_space"></div>
            <fieldset class="form_fieldset">
                <legend class="form_legend">审核信息</legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_light">
                        <td class="form_label_right" width="10%" nowrap>审核人：</td>
                        <td class="form_content" width="20%" nowrap>
                            &nbsp;${bean.checkUserName}
                        </td>
                        <td class="form_label_right" width="10%" nowrap>审核日期：</td>
                        <td class="form_content" width="20%" nowrap>
                            &nbsp;<fmt:formatDate value="${bean.checkDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td class="form_label_right" width="10%" nowrap>审核意见：</td>
                        <td class="form_content" width="20%" nowrap>
                            &nbsp;${bean.checkOpinion.name}
                        </td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right">审核备注：</td>
                        <td class="form_content" colspan="5">
                            &nbsp;<sys:toHtml>${bean.checkMemo}</sys:toHtml>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
        <div class="div_space"></div>

        <div class="tr_button">
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </div>
    </div>
</div>