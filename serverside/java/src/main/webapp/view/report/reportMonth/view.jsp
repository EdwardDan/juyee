<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <br>
        <tr>
            <td colspan="2">
                <span class="net_form_title">虹口区建筑业管理署综合报表</span>
                <br><br>
            </td>
        </tr>
        <tr class="tr_light">
            <td align="left">
                &nbsp;上报部门：${bean.reportDeptDefine.deptName}
            </td>
            <td align="right">
                报表时间：${reportTime}&nbsp;
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1">
                    <tr class="tr_header">
                        <td nawrap width="10%"></td>
                        <td nawrap width="30%" colspan="2">项目</td>
                        <td nawrap width="10%">本月</td>
                        <td nawrap width="10%">累计</td>
                        <td nawrap width="10%">环比</td>
                        <td nawrap width="10%">同比</td>
                        <td nawrap width="10%">备注</td>
                    </tr>

                    <c:forEach items="${list}" var="item1" varStatus="level1">
                        <c:forEach items="${item1.item.reportStructures}" var="item2" varStatus="level2">
                            <c:if test="${fn:length(item2.reportStructures)>0}">
                                <c:forEach items="${item2.reportStructures}" var="item3" varStatus="level3">
                                    <tr
                                            <c:if test="${level3.index%2==0}">class="tr_dark"</c:if>
                                            <c:if test="${level3.index%2==1}">class="tr_light"</c:if>
                                            >
                                        <c:if test="${level2.index==0 && level3.index==0}">
                                            <td rowspan="${item1.size}">
                                                <strong>${item1.name}</strong>
                                            </td>
                                        </c:if>
                                        <c:if test="${level3.index==0}">
                                            <td rowspan="${fn:length(item2.reportStructures)}">
                                                <strong>${item2.name}</strong></td>
                                        </c:if>
                                        <td align="left">
                                            &nbsp;${item3.name}
                                            <c:if test="${not empty item3.measureUnit}">(${item3.measureUnit.name})</c:if>
                                        </td>
                                        <td>
                                            <c:set var="monthValue" value="monthValue${item3.id}"/>
                                                ${item1[monthValue]}
                                        </td>
                                        <td>
                                            <c:set var="accuValue" value="accuValue${item3.id}"/>
                                            <c:if test="${item3.isSumAccu}">
                                                ${item1[accuValue]}
                                            </c:if>
                                            <c:if test="${!item3.isSumAccu}">
                                                /
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:set var="percentHb" value="percentHb${item3.id}"/>
                                                ${item1[percentHb]}
                                        </td>
                                        <td>
                                            <c:set var="percentTb" value="percentTb${item3.id}"/>
                                                ${item1[percentTb]}
                                        </td>
                                        <td>
                                            <c:set var="description" value="description${item3.id}"/>
                                            <sys:toHtml>${item1[description]}</sys:toHtml>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${fn:length(item2.reportStructures)==0}">
                                <tr
                                        <c:if test="${level2.index%2==0}">class="tr_dark"</c:if>
                                        <c:if test="${level2.index%2==1}">class="tr_light"</c:if>
                                        >
                                    <c:if test="${level2.index==0}">
                                        <td rowspan="${item1.size}">
                                            <strong>${item1.name}</strong>
                                        </td>
                                    </c:if>
                                    <td colspan="2" align="left">
                                        &nbsp;${item2.name}
                                        <c:if test="${not empty item2.measureUnit}">(${item2.measureUnit.name})</c:if>
                                    </td>
                                    <td>
                                        <c:set var="monthValue" value="monthValue${item2.id}"/>
                                            ${item1[monthValue]}
                                    </td>
                                    <td>
                                        <c:set var="accuValue" value="accuValue${item2.id}"/>
                                        <c:if test="${item2.isSumAccu}">
                                            ${item1[accuValue]}
                                        </c:if>
                                        <c:if test="${!item2.isSumAccu}">
                                            /
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:set var="percentHb" value="percentHb${item2.id}"/>
                                            ${item1[percentHb]}
                                    </td>
                                    <td>
                                        <c:set var="percentTb" value="percentTb${item2.id}"/>
                                            ${item1[percentTb]}
                                    </td>
                                    <td>
                                        <c:set var="description" value="description${item2.id}"/>
                                        <sys:toHtml>${item1[description]}</sys:toHtml>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" width="20%">
                填表人：
            </td>
            <td class="form_content">
                ${bean.reportPerson}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_border" align="left" colspan="2">
                &nbsp;填表说明：1、统计周期为当月26日至次月25日。
            </td>
        </tr>
        <tr class="tr_button" align="center">
            <td class="form_border" align="center" colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>