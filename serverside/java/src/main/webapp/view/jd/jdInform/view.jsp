<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        //加载项目信息
        loadProjectInfoByCode(null,"${bean.bjbh}",null,false,true);
    });

    function printExcelFR() {
        printFR("JdInform", "id=${bean.id}");
    }
</script>
<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr>
    <td colspan="2">
        <fieldset class="form_fieldset">
            <legend class="form_legend">项目概况</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="20%" nowrap>报建编号：</td>
                    <td class="form_content" width="30%" nowrap>
                        ${bean.bjbh}
                    </td>
                    <td class="form_label_right" width="20%" nowrap>项目名称：</td>
                    <td class="form_content" width="30%" nowrap>
                        <span id="projectName"></span>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>项目分类：</td>
                    <td class="form_content" nowrap>
                        <span id="projectType"></span>
                    </td>
                    <td class="form_label_right" nowrap>工程地点：</td>
                    <td class="form_content" nowrap>
                        <span id="buildAddress"></span>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>建筑面积：</td>
                    <td class="form_content" nowrap>
                        <span id="totalAreaDesc"></span>
                    </td>
                    <td class="form_label_right" nowrap>单体数量：</td>
                    <td class="form_content" nowrap>
                        <span id="dtsl"></span>
                    </td>
                </tr>
                <tr class="tr_dark">

                    <td class="form_label_right" nowrap>工程造价：</td>
                    <td class="form_content" nowrap colspan="3">
                        <span id="totalInvestmentDesc"></span>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>建设单位：</td>
                    <td class="form_content" nowrap>
                        <span id="jsdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="jsdwLxr"></span>&nbsp;&nbsp;<span id="jsdwTel"></span>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>施工单位：</td>
                    <td class="form_content" nowrap>
                        <span id="sgdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="sgdwLxr"></span>&nbsp;&nbsp;<span id="sgdwTel"></span>

                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>勘察单位：</td>
                    <td class="form_content" nowrap>
                        <span id="kcdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="kcdwLxr"></span>&nbsp;&nbsp;<span id="kcdwTel"></span>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>设计单位：</td>
                    <td class="form_content" nowrap>
                        <span id="sjdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="sjdwLxr"></span>&nbsp;&nbsp;<span id="sjdwTel"></span>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>监理单位：</td>
                    <td class="form_content" nowrap>
                        <span id="jldwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="jldwLxr"></span>&nbsp;&nbsp;<span id="jldwTel"></span>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>施工总包：</td>
                    <td class="form_content" nowrap>
                        <span id="sgzbdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="sgzbdwLxr"></span>&nbsp;&nbsp;<span id="sgzbdwTel"></span>
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr>
    <td colspan="2" class="form_fieldset_space">&nbsp;</td>
</tr>
<tr>
    <td>
        <fieldset class="form_fieldset">
            <legend class="form_legend">质量监督告知书</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap width="20%">监督联系人：</td>
                    <td class="form_content" nowrap width="30%">
                        ${bean.lxr}
                    </td>

                    <td class="form_label_right" nowrap width="20%">联系电话：</td>
                    <td class="form_content" nowrap width="30%">
                        ${bean.tel}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>邮政编码：</td>
                    <td class="form_content" nowrap>
                        ${bean.zipCode}
                    </td>

                    <td class="form_label_right" nowrap>联系地址：</td>
                    <td class="form_content" nowrap>
                        ${bean.address}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>传真号码：</td>
                    <td class="form_content" nowrap>
                        ${bean.fax}
                    </td>
                    <td class="form_label_right" nowrap>施工许可证发放日期：</td>
                    <td class="form_content" nowrap>
                        ${bean.sgxkDate}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>备注：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.description}</sys:toHtml>
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr>
    <td colspan="2" class="form_fieldset_space">&nbsp;</td>
</tr>
<c:if test="${not empty bean.auditTime}">
    <tr>
        <td>
            <fieldset class="form_fieldset">
                <legend class="form_legend">科长审核</legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_dark">
                        <td class="form_label_right" width="20%">科长审核意见：</td>
                        <td class="form_content">&nbsp;
                            <sys:toHtml>${bean.auditOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right">科长审核时间：</td>
                        <td class="form_content">&nbsp;
                            <fmt:formatDate value="${bean.auditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
</c:if>
<tr>
    <td colspan="2" class="form_fieldset_space">&nbsp;</td>
</tr>
<c:if test="${not empty bean.fgAuditTime}">
    <tr>
        <td>
            <fieldset class="form_fieldset">
                <legend class="form_legend">分管领导审核</legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_dark">
                        <td class="form_label_right" width="21%">分管领导审核意见：</td>
                        <td class="form_content">&nbsp;
                            <sys:toHtml>${bean.fgOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right">分管领导审核时间：</td>
                        <td class="form_content">&nbsp;
                            <fmt:formatDate value="${bean.fgAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
</c:if>
<tr class="tr_button">
    <td class="form_border" align="center" colspan="4">
        <c:if test="${bean.status==STATUS_PASS}">
            <input type="button" class="button_all" value="打印" onclick="printExcelFR();"/>
        </c:if>
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
</table>
</div>


