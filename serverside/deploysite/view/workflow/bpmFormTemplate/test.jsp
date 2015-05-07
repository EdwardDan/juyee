<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
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
</head>

<body>
<form:form commandName="bean" method="post" name="bean" action="testSave.dol" onsubmit="return formCheck(this);" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <input type="hidden" value='${gridParam}'>
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="table_frame">
        <tr>
            <td class="top_left" nowrap></td>
            <td class="top_bg">
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
                                <tr class="td_dark">
                                    <td align="right" width="40%">选择par：</td>
                                    <td>
                                        <input type="file" name="visioPar" class="input_text" style="width:215px"/>
                                    </td>
                                </tr>
                                <tr class="tr_button">
                                    <td colspan="2" nowrap>
                                        <input name="button_save" type="submit" class="button_all" value="测试">
                                        <input name="button_reset" type="reset" class="button_reset" value="重写">
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
        <tr>
            <td class="bottom_left"></td>
            <td class="bottom_bg"></td>
            <td class="bottom_right"></td>
        </tr>
    </table>
</form:form>
</body>
</html>