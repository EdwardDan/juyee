<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    //tab序号，注意：由于要回写，这里序号只能写死
    var tabNo = "${tabNo}";

    $(function() {
        changeDiv($("#defaultGrp")[0], 2);
    });

    //tab按钮切换，显示切换
    function changeDiv(obj, no) {
        $(".button_normal_special").each(function () {
            $(this).attr("class", "button_normal");
        });
        $(obj).attr("class", "button_normal_special");

        $(".divTabSel1").each(function () {
            $(this).attr("class", "divTabSel2");
        });
        $("#sel" + no).attr("class", "divTabSel1");
    }

    //全选/反选
    function checkAll(obj, no,bizId) {
        var c = obj.checked;
        var checkId = "check" + no+"_";
        if(bizId != ""){
            checkId += bizId;
        }
        $("input[name='"+checkId+"']").each(function () {
            $(this).attr("checked", c==true ? c : false);
        });
    }

    //获取选中id
    function doSelectTab(btn) {
        var no = getNo();
        var type = $("#sel" + no).attr("title");
        var ids = "";
        var names = "";
        $(".user_"+type).each(function () {
            if ($(this).attr("checked")) {
                ids += "," + $(this).val();
                names += "," + $(this).attr("title");
            }
        });
        if (ids != "") {
            ids = ids.substr(1);
        }
        if (names != "") {
            names = names.substr(1);
        }
//        alert(ids+"|"+names);
        var tabDoc = document.getElementById(tabNo).contentWindow.document;
        tabDoc.getElementById("${objId}").value = ids;
        tabDoc.getElementById("${objName}").value = names;
        closeWindow(null);
    }

    //获取选中序号
    function getNo() {
        var no = 1;
        for (var i = 1; i <= 4; i++) {
            if ($("#sel" + i).attr("class") == "divTabSel1") {
                no = i;
                break;
            }
        }
        return no;
    }
</script>
<style type="text/css">
    .divTabSel1 {
        display: inline;
    }

    .divTabSel2 {
        display: none;
    }
</style>

<div class="form_div" align="center">
    <!-- tab按钮，选择按钮 begin -->
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
        <tr class="tr_title">
            <td width="60%" align="left">&nbsp;
                <input type="button" class="button_normal_special" value="全部" onclick="changeDiv(this,1)">
                <input type="button" id="defaultGrp" class="button_normal" value="科室" onclick="changeDiv(this,2)">
                <input type="button" class="button_normal" value="组" onclick="changeDiv(this,3)">
                <%--<input type="button" class="button_normal_long" value="外部用户" onclick="changeDiv(this,4)">--%>
            </td>
            <td width="40%" align="right">
                <input type="button" class="button_confirm" value="确定" onclick="doSelectTab(this)">
                <input type="button" class="button_cancel" value="取消" onclick="closeWindow(null)">&nbsp;
            </td>
        </tr>
    </table>
    <!-- tab按钮，选择按钮 end -->

    <!-- 系统用户 begin -->
    <div id="sel1" class="divTabSel1" title="user">
        <table width="100%" cellpadding="0" cellspacing="0" border="0">
            <tr class="tr_header">
                <td class="form_td_line" width="5%">
                    <input type="checkbox" id="checkAll1" onclick="checkAll(this,1,'')" value="1"/>
                </td>
                <td class="form_td_line" width="20%">用户名</td>
                <td class="form_td_line" width="15%">姓名</td>
                <td class="form_td_line" width="15%">电话</td>
                <td class="form_td_line" width="30%">科室</td>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="status">
                <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>"
                    align="center">
                    <td class="form_td_line"><input type="checkbox" name="check1_" value="${user.id}" class="user_user" title="${user.displayName}"/></td>
                    <td class="form_td_line">${user.loginName}</td>
                    <td class="form_td_line">${user.displayName}</td>
                    <td class="form_td_line">${user.person.mobile}</td>
                    <td class="form_td_line">${user.person.deptName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <!-- 系统用户 end -->

    <!-- 科室用户 begin -->
    <div id="sel2" class="divTabSel2" title="dept">
        <table width="100%" cellpadding="0" cellspacing="0" border="0">
            <c:forEach items="${depts}" var="dept" varStatus="status1">
                <tr class="tr_dark">
                    <td class="form_td_line" width="30%" align="left">
                        <input type="checkbox" id="checkAll2_${dept.dept.id}" onclick="checkAll(this,2,'${dept.dept.id}')" value="1"/>${dept.dept.name}
                    </td>
                    <td class="form_td_line" width="20%">用户名</td>
                    <td class="form_td_line" width="20%">姓名</td>
                    <td class="form_td_line" width="30%">电话</td>
                </tr>
                <c:forEach items="${dept.userList}" var="user" varStatus="status2">
                    <tr class="tr_light"
                        align="center">
                        <td class="form_td_line"><input type="checkbox" name="check2_${dept.dept.id}" value="${user.id}" class="user_dept" title="${user.displayName}"/></td>
                        <td class="form_td_line">${user.loginName}</td>
                        <td class="form_td_line">${user.displayName}</td>
                        <td class="form_td_line">${user.person.mobile}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
    <!-- 科室用户 end -->

    <!-- 组用户 begin -->
    <div id="sel3" class="divTabSel2" title="group">
        <table width="100%" cellpadding="0" cellspacing="0" border="0">
            <c:forEach items="${groups}" var="group" varStatus="status1">
                <tr class="tr_dark">
                    <td class="form_td_line" width="30%" align="left">
                        <input type="checkbox" id="checkAll3_${group.group.id}" onclick="checkAll(this,3,'${group.group.id}')" value="1"/>${group.group.name}
                    </td>
                    <td class="form_td_line" width="20%">用户名</td>
                    <td class="form_td_line" width="20%">姓名</td>
                    <td class="form_td_line" width="30%">电话</td>
                </tr>
                <c:forEach items="${group.userList}" var="user" varStatus="status2">
                    <tr class="tr_light"
                        align="center">
                        <td class="form_td_line"><input type="checkbox" name="check3_${group.group.id}" value="${user.id}" class="user_group" title="${user.displayName}"/></td>
                        <td class="form_td_line">${user.loginName}</td>
                        <td class="form_td_line">${user.displayName}</td>
                        <td class="form_td_line">${user.person.mobile}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
    <!-- 组用户 end -->

    <!-- 外部用户 begin -->
    <div id="sel4" class="divTabSel2" title="regPerson">
        <table width="100%" cellpadding="0" cellspacing="0" border="0">
            <tr class="tr_header">
                <td class="form_td_line" width="5%">
                    <input type="checkbox" id="checkAll4" onclick="checkAll(this,4,'')" value="1"/>
                </td>
                <td class="form_td_line" width="10%">单位类型</td>
                <td class="form_td_line" width="20%">单位名称</td>
                <td class="form_td_line" width="10%">用户名</td>
                <td class="form_td_line" width="10%">姓名</td>
            </tr>
            <c:forEach items="${regs}" var="reg" varStatus="status">
                <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>"
                    align="center">
                    <td class="form_td_line"><input type="checkbox" name="check4_" value="${reg.id}" class="user_regPerson" title="${reg.displayName}"/></td>
                    <td class="form_td_line">${reg.regPerson.regType.name}</td>
                    <td class="form_td_line">${reg.regPerson.unitName}</td>
                    <td class="form_td_line">${reg.loginName}</td>
                    <td class="form_td_line">${reg.displayName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <!-- 外部用户 end -->
</div>
