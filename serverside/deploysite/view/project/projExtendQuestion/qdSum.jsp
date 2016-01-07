<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function loadProjectData(flag) {
        if (flag == "all") {
            $("#projectName").val("");
            $("#jsDept").val("");
            $("#year").val("${currentYear}");
            $("#propertyId").val("");
            $("#isMajor").val("");
            $("#qdYear").val("");
            $("#qdMonth").val("");
            $("#categoryId").val("");
            $("#areaId").val("");
            $("#stageId").val("");
        }
        $("#qdType").val("${qdType}");
        $("#flag").val("${flag}");
        $("#msg").val("${msg}");
        var str = getCondStr();
        setButton(true);
        loadAjaxDataCallback("qdDataDiv", "${ctx}/projExtendQuestion/qdSumData.do?" + str, resetButton);
    }
    function resetButton() {
        setButton(false);
    }
    function setButton(flag) {
        document.getElementById("btnQueryThis").disabled = flag;
        document.getElementById("btnQueryAll").disabled = flag;
    }

    //导出
    function printProjectData(btn) {
        var str = getCondStr();
        window.open("${ctx}/projExtendQuestion/printExcel.do?" + str);
    }

    function getCondStr() {
        var s = "projectName=" + $("#projectName").val();
        s += "&jsDept=" + $("#jsDept").val();
        s += "&year=" + $("#year").val();
        s += "&propertyId=" + $("#propertyId").val();
        s += "&isMajor=" + $("#isMajor").val();
        s += "&qdYear=" + $("#qdYear").val();
        s += "&qdMonth=" + $("#qdMonth").val();
        s += "&categoryId=" + $("#categoryId").val();
        s += "&areaId=" + $("#areaId").val();
        s += "&stageId=" + $("#stageId").val();
        s += "&qdType=" + $("#qdType").val();
        s += "&flag=" + $("#flag").val();
        s += "&msg=" + $("#msg").val();
        return s;
    }

    //初始化
    $(function () {
        loadProjectData('');
    });
</script>
<div class="form_div">
    <input type="hidden" name="qdType" id="qdType" value="">
    <input type="hidden" name="flag" id="flag" value="">
    <input type="hidden" name="msg" id="msg" value="">
    <table cellpadding="1" cellspacing="1" border="0" class="form_table">
        <tr class="tr_light">
            <td align="right" width="70" nowrap>&nbsp;&nbsp;项目名称：</td>
            <td align="left" nowrap>
                <input type="text" name="projectName" id="projectName" class="input_text"/>
            </td>
            <td align="right" width="70" nowrap>年份：</td>
            <td align="left" nowrap>
                <select name="year" id="year" class="form_select" style="width: 100px;">${yearOptions}</select>
            </td>
            <td align="right" width="70" nowrap>管理属性：</td>
            <td align="left" nowrap>
                <sys:code code="${PROJ_INFO_PROPERTY}" name="propertyId" id="propertyId" type="select"
                          sysCodeDetailId="" style="width:90px;" isAlowedNull="true"/>
                &nbsp;&nbsp;
                是否重大：
                <select name="isMajor" id="isMajor" class="form_select" style="width: 90px;">
                    <option value="">请选择</option>
                    <option value="1">重大</option>
                    <option value="0">非重大</option>
                </select>
                &nbsp;&nbsp;填报年月：
                <select name="qdYear" id="qdYear" class="form_select" style="width: 65px;">
                    <option value="">请选择</option>
                    ${yearOptions}
                </select>
                <select name="qdMonth" id="qdMonth" class="form_select" style="width: 65px;">
                    <option value="">请选择</option>
                    ${monthOptions}
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" nowrap>&nbsp;&nbsp;建设单位：</td>
            <td align="left" nowrap>
                <input type="text" name="jsDept" id="jsDept" class="input_text"/>
            </td>
            <td align="right" width="70" nowrap>项目类型：</td>
            <td align="left" nowrap>
                <sys:code code="${PROJ_INFO_CATEGORY}" name="categoryId" id="categoryId" type="select"
                          sysCodeDetailId="" style="width:100px" isAlowedNull="true"/>
            </td>
            <td align="right" width="70" nowrap>区县：</td>
            <td align="left" nowrap>
                <select name="areaId" id="areaId" class="form_select" style="width: 90px;">
                    <option value="0">上海市</option>
                    <c:forEach var="area" items="${areaList}">
                        <option value="${area.id}">${area.name}</option>
                    </c:forEach>
                </select>
                &nbsp;&nbsp;
                项目状态：
                <select name="stageId" id="stageId" class="form_select" style="width: 90px;">
                    <option value="">请选择</option>
                    <c:forEach var="stage" items="${stageList}">
                        <option value="${area.id}">${stage.name}</option>
                    </c:forEach>
                </select>&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="查询" id="btnQueryThis" class="button_all" onclick="loadProjectData(null)"/>
                <input type="button" value="显示全部" id="btnQueryAll" class="button_normal_long"
                       onclick="loadProjectData('all')"/>
                &nbsp;&nbsp;
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td id="qdDataDiv">
                &nbsp;
            </td>
        </tr>
        <tr>
            <td style="height: 30px;"></td>
        </tr>
    </table>
</div>
