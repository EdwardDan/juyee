<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<html>
<head>
    <title>监督任务书excel导入</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        //预览
        function doImport(btn) {
            var form = document.uploadForm;
            var filename =  form.file.value;
            var suffix = filename.substring(filename.lastIndexOf("."),filename.length).toLowerCase();
            if (suffix!=".xls"&&suffix!=".xlsx") {
                alert("请先选择Excel文件！");

            } else {
                if(!confirm("确定要导入吗？")){
                    return;
                }
                form.submit();
                btn.value = "请稍候";
                btn.disabled = true;
            }
        }
    </script>
</head>

<body style="background-color:#e0ebf2;">
<div class="form_div">
    <form name="uploadForm" method="post" action="${ctx}/excelJdTasksOld/excelSave.do" enctype="multipart/form-data" class="">


        <table cellpadding="0" cellspacing="0" style="width: 100%;" align="center" >
            <tr class="tr_light" >
                <td class="form_label_right" style="height: 200px">选择excel文件:</td>
                <td class="form_content">
                    <input type="file" name="file" class="input_text_long">
                </td>
            </tr>
            <tr class="tr_dark" >
                <td class="form_label_right" style="height: 50px">下载模板:</td>
                <td class="form_content">
                    <a href="${ctx}/view/syn/excelJdTasksOld/jdrws.xlsx" target="_blank"><font color="blue">下载Excel模板>></font></a>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label">&nbsp;</td>
                <td class="form_content">
                    <input type="button" class="button_confirm" value="导入"
                           id="submit_button"
                           onclick="doImport(this)">&nbsp;
                    <input type="button" class="button_cancel" value="关闭" onclick="window.close()">
                </td>
                </td>
            </tr>

            <c:if test="${importResult!=null}">
            <tr class="tr_dark">
                <td class="form_content" colspan="2" style="padding-left: 200px">
                    =============导入开始=============
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_content" colspan="2" style="padding-left: 200px">
                    开始导入监督任务书。。。
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_content" colspan="2" style="padding-left: 200px">
                    监督任务书导入结束。
                </td>
            </tr>
            <c:if test="${importResult.excelJdTaskStatue == 0}">
                <tr class="tr_light">
                    <td class="form_content" style="color: red;padding-left: 200px" colspan="2">
                        错误：监督任务书编号,流转编号或者生成日期格式错误，无法导入。 <br>
                    </td>
                </tr>
            </c:if>
            <tr class="tr_light">
                <td class="form_content" colspan="2" style="padding-left: 200px">
                    共读取1条监督任务书，插入${importResult.excelJdTasksAddNum}条，更新${importResult.excelJdTasksUpdateNum}条，失败${importResult.excelJdTasksErrorNum}条。
                </td>
            </tr>
            <c:if test="${importResult.excelJdTaskStatue != 0}">
                <tr class="tr_dark">
                    <td class="form_content" colspan="2" style="padding-left: 200px">
                        开始导入单位工程。。。
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_content" colspan="2" style="padding-left: 200px">
                        单位工程导入结束。
                    </td>
                </tr>
                <c:forEach items="${errNos}" var="errNo">
                    <tr class="tr_light">
                        <td class="form_content" style="color: red;padding-left: 200px" colspan="2">
                            错误：第${errNo}条单位工程编码缺失，该条信息导入失败。
                        </td>
                    </tr>
                </c:forEach>
                <tr class="tr_dark">
                    <td class="form_content" colspan="2" style="padding-left: 200px">
                        共读取${importResult.excelJdDwgcNum}条单位工程信息，插入${importResult.excelJdDwgcAddNum}条，失败${importResult.errorNum}条。
                    </td>
                </tr>
            </c:if>
            <tr class="tr_light">
                <td class="form_content" colspan="2" style="padding-left: 200px">
                    =============导入结束=============
                </td>
            </tr>
            </c:if>
        </table>
    </form>
</div>
</body>
</html>