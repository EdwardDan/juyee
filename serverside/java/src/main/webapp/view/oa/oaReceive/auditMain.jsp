<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
   var formId = "bean";
    function doAudit(id) {
        openNewWindow("new","收文管理审核", "${ctx}/oaReceive/audit.do?id=" + id, true,600,400);
    }
</script>
<style type="text/css">
    .td_border {
        /*border: 1px solid;*/
        border-top-width: 1px;
        border-bottom-width: 1px;
        border-left-width: 1px;
        border-right-width: 1px;
        border-top-style: solid;
        border-bottom-style: solid;
        border-left-style: solid;
        border-right-style: solid;
        border-top-color: #333;
        border-bottom-color: #333;
        border-left-color: #333;
        border-right-color: #333;
    }
    .form_div_left{
        width: 100%;
        text-align: left;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table" style="border-collapse: collapse">
           <c:if test="${type=='auditMain'}">
               <tr class="tr_title form_border" >
                <td  colspan="6" align="right">
                    <input type="button" value="审核" class="button_confirm" onclick="doAudit('${bean.id}')">&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
           </c:if>
            <tr >
                <td class="head_title form_border" style="font-weight: bold;" colspan="6">上海市交通建设工程管理中心文件处理单</td>
            </tr>
            <tr class="tr_light">
                <td class="form_content" colspan="5">&nbsp;&nbsp;文件类型：&nbsp;${bean.type.name}</td>
                <td class="form_label" align="right">${bean.code}&nbsp;&nbsp;</td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文文号：</td>
                <td class="td_border" align="left" colspan="3">&nbsp;${bean.fileCode}
                </td>
                <td class="td_border" align="right">办理时限：</td>
                <td class="td_border" align="left">&nbsp;<fmt:formatDate value="${bean.limitDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">标题：</td>
                <td class="td_border" align="left" colspan="5">&nbsp;${bean.title}</td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文单位：</td>
                <td class="td_border" align="left" colspan="3">&nbsp;${bean.sourceDept}</td>
                <td class="td_border" align="right">份数：</td>
                <td class="td_border" align="left">&nbsp;${bean.fs}</td>
            </tr>

            <tr class="tr_light">
                <td class="td_border" align="right"  width="10%">登记日期：</td>
                <td class="td_border" align="left" width="23%">&nbsp; <fmt:formatDate value="${bean.receiveDate}" pattern="yyyy-MM-dd"/> </td>
                <td class="td_border" align="right" width="10%">成文日期：</td>
                <td class="td_border" align="left" width="23%">&nbsp;<fmt:formatDate value="${bean.writtenDate}" pattern="yyyy-MM-dd"/></td>
                <td class="td_border" align="right" width="10%">页数：</td>
                <td class="td_border" align="left" width="24%">&nbsp; ${bean.ys}</td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">提供部门：</td>
                <td class="td_border" align="left" colspan="3">&nbsp;${bean.deptName}</td>
                <td class="td_border" align="right">密级：</td>
                <td class="td_border" align="left">&nbsp;${bean.secret.name}</td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">紧急程度：</td>
                <td class="td_border" align="left">&nbsp;${bean.urgent.name}</td>
                <td class="td_border" align="right">公文种类：</td>
                <td class="td_border" align="left">&nbsp;${bean.fileType.name}</td>
                <td class="td_border" align="right">牵头部门：</td>
                <td class="td_border" align="left">&nbsp;${bean.startDept}</td>
            </tr>
            <tr  class="tr_light">
                <td class="td_border" align="right">附件：</td>
                <td class="td_border" align="left" colspan="5">
                    &nbsp;<c:forEach items="${docAttachs}" var="docName">&nbsp;${docName.fileName}&nbsp;
                    </c:forEach>${documentFile}
                </td>
            </tr>

            <c:forEach items="${stepList}" var="step">
                <c:set var="key" value="${step.id}"/>
                <c:if test="${step.code=='bgsnb'}"><tr class="tr_light">
                    <td class="td_border" align="right">批办：</td>
                    <td class="td_border" align="left" colspan="5"> <div class="form_div_left" style="min-height: 50px">
                        &nbsp;<sys:toHtml>${bean.dealContent}</sys:toHtml>
                    </div>
                        <c:forEach items="${stepNodes[key]}" var="node">
                            <div style="width: 50%;float: left;text-align: left"> &nbsp;${node.dealResult}</div><div style="float: right;width: 50%;text-align: right;" >${node.dealDept.name}&nbsp;${node.dealUser}&nbsp;&nbsp;<fmt:formatDate value="${node.completeTime}" pattern="yyyy-MM-dd HH:mm"/>&nbsp;</div>
                        </c:forEach></td>
                </tr></c:if>
                <c:if test="${step.code!='bgsnb'}"><tr class="tr_light">
                    <td class="td_border" align="right" nowrap >${step.name}：</td>
                    <td class="td_border" align="left" colspan="5">
                        <div class="form_div_left" style="min-height: 80px">
                        <c:forEach items="${stepNodes[key]}" var="node">
                          <div style="width: 50%;float: left;text-align: left"> &nbsp;${node.dealResult}</div><div style="float: right;width: 50%;text-align: right;" >${node.dealDept.name}&nbsp;${node.dealUser}&nbsp;&nbsp;<fmt:formatDate value="${node.completeTime}" pattern="yyyy-MM-dd HH:mm"/>&nbsp;</div>
                        </c:forEach>
                    </div></td>
                </tr></c:if>
            </c:forEach>
            <tr class="tr_button">
                <td class="form_border" align="center" colspan="6">
                    <c:if test="${type=='view'}"> &nbsp;是否打印日志:&nbsp;<input type="checkbox" value="1" name="isPrintNode" id="isPrintNode">
                        <input type="button" value="打印" class="button_confirm" onclick=""></c:if>
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>