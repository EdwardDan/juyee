<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>虹口区建设工程综合系统</title>

    <script type="text/javascript">
        var metaTab_default = "${defCode}";
        var meta_default = "${attributeType}";
        var express_default = "${expression}";
        if (metaTab_default !== "") {
//                initRadio("metaType", meta_default);
            var met = document.getElementsByName("metaType");
            for (var i = 0; i < met.length; i++) {
                if (met[i].value == meta_default) {
                    met[i].checked = true;
                }
            }
            document.getElementById("defCode").value = metaTab_default;
            document.getElementById("attributeType").value = meta_default;
            if (meta_default == "express") {
                document.getElementById("expression").value = express_default;
            } else {
                document.getElementById("expression").readOnly = true;
            }
        }

        function formCheck(form) {
            //表单验证
            if (!Validator.Validate(form)) return false;
            //增加其他判断
            return true;
        }

        //tab跳转
        function tabFuc(currentObj) {
            for (var i = 0; i < document.getElementsByName("btn_tab").length; i++) {
                var obj = document.getElementsByName("btn_tab")[i];
                if (obj.id == currentObj.id) {
                    obj.className = "button_all";
                } else {
                    obj.className = "button_cancel";
                }
            }
            document.getElementById("defCode").value = currentObj.id;
            document.getElementsByName("attributeType").value = "";
            refershPage();
        }

        //刷新数据
        function doClick() {
            for (var i = 0; i < document.getElementsByName("metaType").length; i++) {
                var check_obj = document.getElementsByName("metaType")[i];
                if (check_obj.checked) {
                    document.getElementById("attributeType").value = check_obj.value;
                    break;
                }
            }

            refershPage();
        }

        function refershPage() {
            var attributeType = document.getElementById("attributeType").value;
            if (attributeType != "express") {
                document.getElementById("expression").value = "";
            }
//            document.bean.action = "extAttr.do";
//            document.bean.submit();
            var formId = "bean";
            var id = document.getElementById("beanid").value;
            loadAjaxData("check", "${ctx}/bpmProjectGroup/extAttrCheck.do?id=" + id + "&defCode=&attributeType=" + attributeType + "&expression=");
        }
        function setExtAttr() {
            var id = document.getElementById("beanid").value;
            var url = "?id=" + id;
            openWindow("项目组属性设置", "${ctx}/bpmProjectGroup/setExtAttr.do" + url, true, 800, 500);
        }
        function save(btn) {
            var formId = "bean";
            saveAjaxData("${ctx}/bpmProjectGroup/saveExtAttr.do", formId);
        }
    </script>
</head>

<body>
<%--<form:form commandName="bean" method="post" name="bean" action="saveExtAttr.html" onsubmit="return formCheck(this);">--%>
<%--<form method="post" name="bean" action="saveExtAttr.do" onsubmit="return formCheck(this);">--%>
<form:form commandName="bean" id="bean" method="post">
    <form:hidden path="id" id="beanid"/>
    <%--<input type="hidden" name="id" id="beanid" value="${bean.id}"/>--%>
    <table border="0" align="center" cellpadding="0" cellspacing="0" width="100%">
        <tr style="height:30px;" >
            <td  >
                <!-- tab area begin -->
                <table border="0" cellpadding="0" cellspacing="0" width="100%"  >
                    <tr  class="button_tab_big_bg">
                        <td height="25" nowrap>
                            &nbsp;
                            <c:forEach var="attr" items="${attrs}" varStatus="status">
                                <input type="button" name="btn_tab" id="${attr.code}" value="${attr.name}"
                                <c:choose>
                                <c:when test="${attr.code==defCode}">
                                       class="button_all"
                                </c:when>
                                <c:otherwise>
                                       class="button_all"
                                </c:otherwise>
                                </c:choose>
                                       onclick="tabFuc(this)">
                            </c:forEach>
                                <%--<input type="button" name="btn_tab" id="bbb" value="合同类型" class="button_tab_big"--%>
                                <%--onclick="tabFuc(this)">--%>
                        </td>
                        <td width="50" nowrap>
                            <input type="button" name="btn_set" value="设置" class="button_confirm"
                                   onclick="setExtAttr();">&nbsp;&nbsp;
                        </td>
                    </tr>
                </table>
                <!-- tab area end -->
            </td>
        </tr>
        <tr>
            <td class="tr_title" colspan="3" height="30px" valign="top" style="margin-top: 0px">
                <!-- title begin -->
                项目组扩展属性设置
                <!-- title begin -->
            </td>
        </tr>
        <tr>
            <c:if test="${defCode!=null}">
                <td valign="top">
                    <!-- main content begin -->
                    <table border="0" cellpadding="0" cellspacing="0" width="100%" valign="top"
                           height="30%">
                        <tr>
                            <td class="tr_light">
                                <input type="hidden" name="defCode" value="${defCode}" id="defCode">
                                <input type="hidden" name="attributeType" id="attributeType"
                                       value="${attributeType}">
                                &nbsp;&nbsp;<input type="radio" name="metaType" value="all"
                                                   onclick="doClick()">全部
                                &nbsp;&nbsp;<input type="radio" name="metaType" value="none"
                                                   onclick="doClick()">全否
                                &nbsp;&nbsp;<input type="radio" name="metaType" value="values"
                                                   onclick="doClick()">具体值
                                &nbsp;&nbsp;<input type="radio" name="metaType" value="express"
                                                   onclick="doClick()">表达式
                                <input type="text" name="expression" value="" id="expression">
                                <input type="button" name="refersh" value="刷新"
                                       onclick="refershPage();" class="button_normal">
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                <table border="0" align="center" cellpadding="0" cellspacing="0"
                                       class="table_frame" width="100%">
                                    <tr>

                                        <td valign="top">
                                            <!-- main content begin -->
                                            <div id="check">
                                                <table width="100%" border="0"
                                                       cellpadding="0" cellspacing="1"
                                                       bordercolor="#FFFFFF"
                                                       id="table_list">
                                                    <tr class="tr_header" align="center">
                                                        <td width="10%">序号</td>
                                                        <td width="40%">${defName}</td>
                                                        <td width="40%">选择</td>
                                                    </tr>
                                                    <c:forEach var="bean"
                                                               items="${extAttrItems}"
                                                               varStatus="status">
                                                        <c:choose>
                                                            <c:when test="${status.count%2==0}">
                                                                <tr class="tr_light" >
                                                            </c:when>
                                                            <c:otherwise>
                                                                <tr class="tr_dark">
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <td align="center">${status.count}&nbsp;</td>
                                                        <td align="center">${bean.value}&nbsp;</td>
                                                        <td align="center">
                                                            <c:choose>
                                                                <%--<c:when test="${attributeType=='all'}">--%>
                                                                <%--<input id="itemId"--%>
                                                                <%--name="itemId"--%>
                                                                <%--value="${bean.id}"--%>
                                                                <%--type="checkbox"--%>
                                                                <%--checked="true"--%>
                                                                <%--disabled="true"> &nbsp;--%>
                                                                <%--</c:when>--%>
                                                                <c:when test="${attributeType=='values'}">
                                                                    <c:if test="${bean.isChecked=='true'}">

                                                                        <input id="itemId"
                                                                               name="itemId"
                                                                               value="${bean.id}"
                                                                               type="checkbox"
                                                                               checked="true"> &nbsp;
                                                                    </c:if>
                                                                    <c:if test="${bean.isChecked=='false'}">
                                                                        <input id="itemId"
                                                                               name="itemId"
                                                                               value="${bean.id}"
                                                                               type="checkbox"> &nbsp;
                                                                    </c:if>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input id="itemId"
                                                                           name="itemId"
                                                                           value="${bean.id}"
                                                                           type="checkbox"
                                                                           checked="true"
                                                                           disabled="true"> &nbsp;
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                    </tr>
                                    <tr>
                                        <td align="center" colspan="3" class="tr_button">
                                            <input type="button" value="确定"
                                                   class="button_confirm" onclick="save(this)">
                                            <input type="reset" value="关闭" class="button_cancel"
                                                   onclick="closeWindow()">
                                        </td>
                                    </tr>
                                </table>
                            </td>

                        </tr>
                    </table>
                    <!-- main content end -->
                </td>
            </c:if>
            <td class="middle_right" nowrap></td>
        </tr>
    </table>


    <%--</form>--%>
</form:form>
</body>
</html>