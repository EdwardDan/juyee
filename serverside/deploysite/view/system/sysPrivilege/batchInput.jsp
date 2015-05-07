<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";

    //保存操作
    function save(btn) {
        //加入其他业务判断
        var ss = $(":checkbox");
        var check = false;
        for(var i=0;i<ss.length;i++){
            if(ss[i].checked){
                check = true;
                break;
            }
        }

        if (!check) {
            showInfoMsg('请选择要添加的按钮权限！');
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/sysPrivilege/batchInputSave.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="parent" value="${bean.parent.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">添加【${bean.parent.name}】的按钮权限:</td>
                <td class="form_content">
                    <input type="checkbox" name="batchType" value="edit"/> 编辑 <br>
                    <input type="checkbox" name="batchType" value="audit"/> 审核 <br>
                    <input type="checkbox" name="batchType" value="view"/> 查看
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>