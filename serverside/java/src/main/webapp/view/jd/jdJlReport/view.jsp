<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        //加载项目信息
        loadProjectInfoByCode(null,"${bean.bjbh}",null,false,true);
    });
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td colspan="2">
                <fieldset class="form_fieldset">
                    <legend class="form_legend">工程信息</legend>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">项目名称：</td>
                            <td class="form_content" width="35%">
                                <span id="projectName"></span>
                            </td>
                            <td class="form_label_right" width="15%">报建编号：</td>
                            <td class="form_content" width="35%">
                                <span id="bjbh"></span>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">工程地点：</td>
                            <td class="form_content">
                                <span id="buildAddress"></span>
                            </td>
                            <td class="form_label_right">项目分类：</td>
                            <td class="form_content">
                                <span id="projectType"></span>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" nowrap>工程造价：</td>
                            <td class="form_content">
                                <span id="totalInvestmentDesc"></span>
                            </td>
                            <td class="form_label_right" nowrap>施工许可证发放日期：</td>
                            <td class="form_content">
                                <span id="approvalDate"></span>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">建筑面积：</td>
                            <td class="form_content">
                                <span id="totalAreaDesc"></span>
                            </td>
                            <td class="form_label_right">单体数量：</td>
                            <td class="form_content">
                                <span id="dtsl"></span>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">建设单位：</td>
                            <td class="form_content">
                                <span id="jsdwmc"></span>
                            </td>
                            <td class="form_label_right">联系人：</td>
                            <td class="form_content">
                                <span id="jsdwLxr"></span>&nbsp;&nbsp;<span id="jsdwTel"></span>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">监理单位：</td>
                            <td class="form_content">
                                <span id="jldwmc"></span>
                            </td>
                            <td class="form_label_right">联系人：</td>
                            <td class="form_content">
                                <span id="jldwLxr"></span>&nbsp;&nbsp;<span id="jldwTel"></span>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
        <c:forEach items="${mapList}" var="item"  varStatus="index">
            <tr>
                <td colspan="2" class="form_fieldset_space">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2">
                    <fieldset class="form_fieldset">
                        <legend class="form_legend">监理报告</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">提交日期：</td>
                                <td class="form_content" width="35%">
                                    <fmt:formatDate value="${item.reportDate}" pattern="yyyy-MM-dd"/>
                                </td>
                                <td class="form_label_right" width="15%">报告类型：</td>
                                <td class="form_content"  width="35%">
                                        ${item.reportTypeDesc}
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">备注：</td>
                                <td class="form_content" colspan="3">
                                    <sys:toHtml>${item.description}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">附件：</td>
                                <td class="form_content" colspan="3">
                                        ${item.docButton}
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
        </c:forEach>
        <tr class="tr_button">
            <td class="form_border">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>