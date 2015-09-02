<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"code", rule:"validate[required,maxSize[100]]"},
            //{name:"fileCode", rule:"validate[required,maxSize[100]]"},
            //{name:"title", rule:"validate[required,maxSize[250]]"},
            //{name:"sourceDept", rule:"validate[required,maxSize[250]]"},
            //{name:"receiveDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"deptName", rule:"validate[required,maxSize[100]]"},
            //{name:"writtenDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"limitDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"fs", rule:"validate[required,custom[integer],maxSize[6]"},
            //{name:"ys", rule:"validate[required,custom[integer],maxSize[6]"},
            //{name:"startDeptId", rule:"validate[required,custom[integer],maxSize[10]"},
            //{name:"dealPersons", rule:"validate[required,maxSize[200]]"},
            //{name:"dealDepts", rule:"validate[required,maxSize[200]]"},
            //{name:"createTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[7]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(operationId,btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/oaReceive/save.do?operationId="+operationId, formId);
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
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="node" id="node" value="${node.id}">
    <input type="hidden" name="step" id="step" value="${bean.step.id}">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table" style="border-collapse: collapse">
            <tr >
                <td class="head_title form_border" colspan="6">上海市路政局收文登记单</td>
            </tr>
            <tr class="tr_light">
                <td class="form_content" colspan="5">&nbsp;&nbsp;文件类型：${bean.type.name}</td>
                <td class="form_label" align="right"><%--收文编号：--%>沪路政收（${bean.year}）${bean.orderNo}号&nbsp;&nbsp;</td>

            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文文号：</td>
                <td class="td_border" align="left" colspan="3">&nbsp;${bean.fileCode}</td>
                <td class="td_border" align="right">办理时限：</td>
                <td class="td_border" align="left">&nbsp;<fmt:formatDate value="${bean.limitDate}" pattern="yyyy-MM-dd"/> </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">标题：</td>
                <td class="td_border" align="left" colspan="5">&nbsp;${bean.title} </td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文单位：</td>
                <td class="td_border" align="left" colspan="3">&nbsp;${bean.sourceDept}</td>
                <td class="td_border" align="right">份数：</td>
                <td class="td_border" align="left">&nbsp;${bean.fs} </td>
            </tr>

            <tr class="tr_light">
                <td class="td_border" align="right"  width="10%">登记日期：</td>
                <td class="td_border" align="left" width="23%">&nbsp;<fmt:formatDate value="${bean.receiveDate}" pattern="yyyy-MM-dd"/> </td>
                <td class="td_border" align="right" width="10%">成文日期：</td>
                <td class="td_border" align="left" width="23%">&nbsp;<fmt:formatDate value="${bean.writtenDate}" pattern="yyyy-MM-dd"/> </td>
                <td class="td_border" align="right" width="10%">页数：</td>
                <td class="td_border" align="left" width="24%">&nbsp;${bean.ys} </td>
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
               </c:forEach>${uploadButton}
               </td>
           </tr>
            <tr class="tr_dark">
                <td class="td_border" align="center" colspan="6"> &nbsp;  &nbsp; &nbsp;处理人：
                    <select name="ccUsers" id="ccUsers" size="3" multiple style="width:200px"
                            class="input_light">
                        <c:forEach var="sysUser" items="${sysUserHM}">
                            <option value="${sysUser.key}">${sysUser.value}</option>
                        </c:forEach>
                    </select>
                    <img src="${themePath}/workflow/user.gif" alt="请选择处理人" border="0"
                         style="cursor:pointer"
                         onclick="multiSelectSysUser('ccUsers','dealPersons','dealPersonsNames')">
                    <img src="${themePath}/workflow/file_delete.gif" width="16"
                         height="16" border="0" alt="移除选中人员" align="absbottom"
                         onClick="removeMultiSelectOpt('ccUsers','dealPersons','dealPersonsNames')">
                    <input type="hidden" name="dealPersons" id="dealPersons"
                           value="${bean.dealPersons}">
                    <input type="hidden" name="dealPersonsNames" id="dealPersonsNames">

                &nbsp;  &nbsp;&nbsp;&nbsp;
                处理部门：
                    <select name="ccDepts" id="ccDepts" size="3" multiple style="width:200px"
                            class="input_light">
                        <c:forEach var="sysDept" items="${sysDeptHM}">
                            <option value="${sysDept.key}">${sysDept.value}</option>
                        </c:forEach>
                    </select>
                    <img src="${themePath}/workflow/dept.gif" alt="请选择处理部门" border="0"
                         style="cursor:pointer"
                         onclick="multiSelectSysDeptOwner('ccDepts','dealDepts','dealDeptsNames')">
                    <img src="${themePath}/workflow/file_delete.gif" width="16"
                         height="16" border="0" alt="移除选中部门" align="absbottom"
                         onClick="removeMultiSelectOpt('ccDepts','dealDepts','dealDeptsNames')">
                    <input type="hidden" name="dealDepts" id="dealDepts"
                           value="${bean.dealDepts}">
                    <input type="hidden" name="dealDeptsNames" id="dealDeptsNames">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">批办：</td>
                <td class="td_border" align="left" colspan="5">
                    <form:textarea path="dealContent" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td  align="center" colspan="6">
                    <c:forEach items="${operations}" var="operation" >
                        <input type="button" value="${operation.name}" class="button_normal_longer"
                               onclick="save('${operation.id}',this.value)">&nbsp;
                    </c:forEach>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>