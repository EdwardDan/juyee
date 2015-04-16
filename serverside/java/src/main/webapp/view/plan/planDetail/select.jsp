<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function jumpUrl() {
        var jdRecord = $("#jdRecord").val();
        var split = jdRecord.split("_");
        var msg = split[0];
        var code = split[1];
        if (msg == '1') {
            openWindow("添加首次监督记录", "${ctx}/jdRecordFirst/add.do?planDetailId=${planDetailId}&jdTaskCode=${jdTaskCode}&jdcode=" + code, true, 900, 500, "tab1");
        } else if (msg == '2') {
            openWindow("添加过程${name}监督记录", "${ctx}/jdRecordQuality/add.do?planDetailId=${planDetailId}&jdTaskCode=${jdTaskCode}", true, 900, 500, "tab2");
        } else if (msg == '3') {
            if (code == 'safe') {
                openWindow("添加现场踏勘监督记录", "${ctx}/jdRecordComplete/add.do?planDetailId=${planDetailId}&jdTaskCode=${jdTaskCode}&jdcode=" + code, true, 900, 500, "tab3");
            } else if (code == 'quality') {
                openWindow("添加竣工验收监督记录", "${ctx}/jdRecordComplete/add.do?planDetailId=${planDetailId}&jdTaskCode=${jdTaskCode}&jdcode=" + code, true, 900, 500, "tab3");
            }
        }
    }
</script>
<form:form commandName="bean">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr height="50">
                <td></td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">监督记录：</td>
                <td class="form_content">
                    <select id="jdRecord" name="jdRecord">
                        <option value="1_${typeCode}">首次监督</option>
                        <option value="2_${typeCode}">过程${name}监督</option>
                        <c:choose>
                            <c:when test="${typeCode == 'quality'}">
                                <option value="3_${typeCode}">竣工验收监督</option>
                            </c:when>
                            <c:otherwise>
                                <option value="3_${typeCode}">现场踏勘监督</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </td>
            </tr>
            <tr class="tr_button" align="center">
                <td class="form_border" colspan="2">
                    <input type="button" value="填报" class="button_all" onclick="jumpUrl()">
                </td>
            </tr>
        </table>
    </div>
</form:form>