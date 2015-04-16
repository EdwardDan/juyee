<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    //保存操作
    function saveBack(status) {
        //提交表单
        saveAjaxData("${ctx}/projectBidCheck/confirm.do?status=" + status, 'formBack', null, null);

    }
    function isCheckBack(obj) {
        if (obj.checked) {
            $(obj).parent().find("#needBack").val(1);
        } else {
            $(obj).parent().find("#needBack").val(0);
        }
    }
</script>
<form id="formBack">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <input type="hidden" value="${bean.id}" name="id" id="id"/>
                <td class="form_label_right">报建编号：</td>
                <td class="form_content">&nbsp;
                    ${bean.bjbh}
                </td>
                <td class="form_label_right">标段号：</td>
                <td class="form_content">&nbsp;
                    ${bean.bdh}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">项目名称：</td>
                <td class="form_content" colspan="3">&nbsp;
                    ${bean.projectName}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content" colspan="3">&nbsp;
                    ${bean.buildUnit}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设地点：</td>
                <td class="form_content" colspan="3">&nbsp;
                    ${bean.buildAddress}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">购买标书截至时间：</td>
                <td class="form_content">&nbsp;
                    <fmt:formatDate value="${bean.signLastDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td class="form_label_right">投标保证金截止日期：</td>
                <td class="form_content">
                    <fmt:formatDate value="${bean.signDate}" pattern="yyyy-MM-dd"/>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">招标代理单位：</td>
                <td class="form_content" colspan="3">&nbsp;
                    ${bean.signProxyUnit}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">联系人：</td>
                <td class="form_content">&nbsp;
                    ${bean.linkPerson}
                </td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">&nbsp;
                    ${bean.linkTel}
                </td>
            </tr>
        </table>
        <div class="div_space"></div>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_header" align="center">
                <td width="4%" nowrap class="form_border">序号</td>
                <td width="30%" nowrap class="form_border">购买标书单位</td>
                <td width="10%" nowrap class="form_border">联系人</td>
                <td width="13%" nowrap class="form_border">联系电话</td>
                <td width="13%" nowrap class="form_border">购买标书时间</td>
                <td width="10%" nowrap class="form_border">缴纳金额（元）</td>
                <td width="10%" nowrap class="form_border">是否已缴纳</td>
                <td width="10%" nowrap class="form_border">需要退还单位</td>
            </tr>

            <c:forEach items="${bean.projectBidSignDepts}" var="item" varStatus="status">
                <tr <c:choose>
                    <c:when test="${status.index % 2==0}">class="tr_light" </c:when>
                    <c:otherwise>class="tr_dark" </c:otherwise>
                </c:choose>>
                    <td nowrap class="form_border">${status.index+1}</td>
                    <td nowrap class="form_content"> ${item.signUnit} </td>
                    <td class="form_border" nowrap> ${item.linkPerson}</td>
                    <td class="form_border" nowrap>${item.linkTel} </td>
                    <td class="form_border" nowrap><fmt:formatDate value="${item.signDate}"
                                                                   pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td nowrap class="form_border">${item.payAccount}</td>
                    <td nowrap class="form_border">
                        <input type="checkbox"
                               <c:if test="${item.isAfford==1}">checked="checked" </c:if> disabled/>
                    </td>
                    <td nowrap class="form_border">
                        <input type="checkbox" value="1" onclick="isCheckBack(this)"
                               <c:if test="${item.needBack==1}">checked="checked" </c:if> />
                        <input type="hidden" value="${item.needBack}" name="needBack" id="needBack"/>
                        <input type="hidden" value="${item.id}" name="deptIds" id="deptIds" hidden="hidden"/>
                    </td>
                </tr>
            </c:forEach>
            <tr class="tr_button">
                <td colspan="8" align="center" class="form_border">
                    <input type="button" value="提交" class="button_confirm" onclick="saveBack(1)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm" onclick="saveBack(0)">&nbsp;
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form>