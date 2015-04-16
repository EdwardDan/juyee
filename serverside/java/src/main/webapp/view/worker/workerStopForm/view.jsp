<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function doPrint() {
        printFR("WorkerStopForm", "id=${bean.id}");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="15%">工程名称：</td>
            <td class="form_content" width="45%">${bean.projectName}</td>
            <td class="form_label_right" width="5%">字：</td>
            <td class="form_content">${bean.formFont}</td>
            <td class="form_label_right" width="5%">号：</td>
            <td class="form_content"> ${bean.formCode}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">责任主体：</td>
            <td class="form_content" colspan="5">${bean.unitName}</td>
        </tr>
        <tr>
            <td colspan="6" align="center">
                <br>
                <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1"
                       style="width: 90%;">
                    <tr class="tr_header">
                        <td width="40%">存在问题</td>
                        <td width="60%">违反法律、法规、强制性标准、规范、标准、<br>规范性文件的名称</td>
                    </tr>
                    <tr class="tr_dark">
                        <td>未取得施工许可证擅自施工。</td>
                        <td align="left">
                            □《上海市建筑市场管理条例》第三十一条第三款；<br>
                            □《建筑工程施工许可管理办法》第三条第一款。
                        </td>
                    </tr>
                </table>
                <br>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">停工时间：</td>
            <td class="form_content" colspan="5">
                <fmt:formatDate value="${bean.stopTime}" pattern="yyyy-MM-dd HH:mm"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">签发日期：</td>
            <td class="form_content" colspan="5">
                <fmt:formatDate value="${bean.signDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">检查人员：</td>
            <td class="form_content" colspan="5">${bean.checkPerson}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">签发人：</td>
            <td class="form_content" colspan="5">${bean.signPerson}</td>
        </tr>

        <tr class="tr_button">
            <td class="form_border" colspan="6" align="center">
                <input type="button" value="打印" class="button_all" onclick="doPrint()">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>