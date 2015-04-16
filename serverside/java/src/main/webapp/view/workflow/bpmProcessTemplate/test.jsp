<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<html>
<head>

        <%@include file="/common/header.jsp" %>
   
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>虹口系统</title>


    <script type="text/javascript">
        function formCheck(form) {
            //表单验证
            if (!Validator.Validate(form)) return false;

            //增加其他判断
            if(document.bean.visioPar.value == ""){
                alert("请选择一个流程par文件！");
                return false;
            }
            return true;
        }
    </script>
    <base target="_self">
</head>

<body>
<form:form commandName="bean" method="post" name="bean" action="${ctx}/bpmProcessTemplate/testSave.do" onsubmit="return formCheck(this);" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <input type="hidden" value='${gridParam}'>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td class="top_left" nowrap></td>
            <td class="tr_light">
                <!-- title begin -->
                流程模板测试
                <!-- title begin -->
            </td>
            <td class="top_right" nowrap></td>
        </tr>
        <tr>
            <td colspan="3">
                <table border="0" align="center" cellpadding="0" cellspacing="0" width="100%">
                    <tr>
                        <td class="middle_left" nowrap></td>
                        <td height="50" valign="top">
                            <!-- main content begin -->
                            <table width="100%" border="0" cellpadding="0" cellspacing="1" bordercolor="#FFFFFF" id="table_list">
                                <tr class="tr_dark">
                                    <td align="right" width="40%">选择par：</td>
                                    <td align="left">
                                        <input type="file" name="visioPar" class="input_text" style="width:215px"/>
                                    </td>
                                </tr>
                                <tr class="tr_button">
                                    <td colspan="2" nowrap align="center">
                                        <input name="button_save" type="submit" class="button_all" value="测试">
                                        <input name="button_reset" type="reset" class="button_cancel" value="重写">
                                    </td>
                                </tr>
                            </table>
                            <!-- main content end -->
                        </td>
                        <td class="middle_right" nowrap></td>
                    </tr>
                </table>
            </td>
        </tr>
     
    </table>
</form:form>
</body>
</html>