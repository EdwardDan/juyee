<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    function printView() {
        window.open("${ctx}/sgPermit/printView.do?id=${bean.id}", "交通建管中心技术审查表", "status=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width=800,hight=600;");
    }
    function printView1() {
        window.open("${ctx}/sgPermit/printView1.do?id=${bean.id}", "市政基础设施项目申请材料收件凭证", "status=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width=800,hight=600;");
    }
    function printView2() {
        window.open("${ctx}/sgPermit/printView2.do?id=${bean.id}", "受理通知书", "status=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width=800,hight=600;");
    }
    function printView3() {
        window.open("${ctx}/sgPermit/printView3.do?id=${bean.id}", "不予受理决定书", "status=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width=800,hight=600;");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" nowrap>报建编号：</td>
            <td class="form_content">${bean.bjbh}</td>
            <td class="form_label_right" nowrap>受理编号：</td>
            <td class="form_content">${bean.acceptCode}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">项目名称：</td>
            <td class="form_content" colspan="3">${bean.projectName}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">建设单位：</td>
            <td class="form_content" colspan="3">${bean.buildName}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%;">建设单位性质：</td>
            <td class="form_content" style="width: 30%;">${bean.buildUnitType}</td>
            <td class="form_label_right" style="width: 15%;">建设单位地址：</td>
            <td class="form_content" style="width: 35%;">${bean.buildUnitAddress}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">建设地点：</td>
            <td class="form_content" colspan="3">${bean.buildSite}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">建设工程类别：</td>
            <td class="form_content" colspan="3">
                <c:forEach items="${lbs}" var="item">
                    <input type="checkbox" name="buildLbId" value="${item.id}"
                           <c:if test="${fn:contains(bean.buildLbIds, item.id)}">checked</c:if> disabled>${item.name}&nbsp;
                </c:forEach>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">建设工程属性：</td>
            <td class="form_content" colspan="3">
                <c:forEach items="${sxs}" var="item">
                    <input type="radio" name="buildSx" value="${item.id}"
                           <c:if test="${bean.buildSx.id == item.id}">checked</c:if> disabled>${item.name}&nbsp;
                </c:forEach>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">建设工程规模：</td>
            <td class="form_content" colspan="3">${bean.buildProjSize}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">合同价格（万元）：</td>
            <td class="form_content">${bean.contractPrice}</td>
            <td class="form_label_right">合同工期（日历天）：</td>
            <td class="form_content">${bean.contractPeriod}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">中标价格（万元）：</td>
            <td class="form_content" colspan="3">${bean.zbPrice}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">开工日期：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.contractBeginDate}" pattern="yyyy-MM-dd"/>
            </td>
            <td class="form_label_right">完工日期：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.contractEndDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">法定代表人：</td>
            <td class="form_content">${bean.fr}</td>
            <td class="form_label_right">建设单位联系电话：</td>
            <td class="form_content">${bean.buildUnitPhone}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">建设单位联系人：</td>
            <td class="form_content">${bean.buildUnitPerson}</td>
            <td class="form_label_right">手机号：</td>
            <td class="form_content">${bean.buildUnitMobile}</td>
        </tr>
        <%--<tr class="tr_light">--%>
        <%--<td class="form_label_right">建设用地批准文件编号：</td>--%>
        <%--<td class="form_content" colspan="3">${bean.buildFileCode}</td>--%>
        <%--</tr>--%>
        <%--<tr class="tr_dark">--%>
        <%--<td class="form_label_right">建设工程规划许可证编号：</td>--%>
        <%--<td class="form_content" colspan="3">${bean.buildXkzCode}</td>--%>
        <%--</tr>--%>
        <tr class="tr_light">
            <td class="form_label_right">现场开工情况：</td>
            <td class="form_content" colspan="3">${bean.startWorkCon}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">沪交管收字</td>
            <td class="form_content" colspan="3">
                （${bean.hjgYear}）第&nbsp;${bean.hjgNum}&nbsp;号
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">申请人：</td>
            <td class="form_content" colspan="3">${bean.applyPerson}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">申请事项：</td>
            <td class="form_content" colspan="3">${bean.applyMatter}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">申请号：</td>
            <td class="form_content" colspan="3">${bean.applyNum}</td>
        </tr>
        <tr>
            <td colspan="4">
                <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                    <tr class="tr_header">
                        <td style="width: 5%;">序号</td>
                        <td style="width: 50%;">申请材料名称</td>
                        <%--<td style="width: 20%;">材料齐全情况</td>--%>
                        <%--<td style="width: 8%;">份数</td>--%>
                        <td style="width: 8%;">应交份数</td>
                        <td style="width: 8%;">实交份数</td>
                        <td style="width: 15%;">附件</td>
                    </tr>
                    <c:forEach items="${applyList}" var="map">
                        <c:set value="upLoad${map.no}" var="upLoadNo"/>
                        <tr class="tr_dark">
                            <td style="text-align: center;">${map.no}</td>
                            <td style="text-align: left;">${map.materialName}</td>
                                <%--<td style="text-align: center;">--%>
                                <%--有<input type="radio" name="isFull${map.no}" value="1" disabled="true"--%>
                                <%--<c:if test="${map.isFull=='true'}">checked="checked"</c:if>>--%>
                                <%--无<input type="radio" name="isFull${map.no}" value="0" disabled="true"--%>
                                <%--<c:if test="${map.isFull=='false'}">checked="checked"</c:if>>--%>
                                <%--</td>--%>
                                <%--<td style="text-align: center;">${map.num}</td>--%>
                            <td style="text-align: center;">${map.yjNum}</td>
                            <td style="text-align: center;">${map.sjNum}</td>
                            <td style="text-align: center;">${map[upLoadNo]}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">材料提交人：</td>
            <td class="form_content" colspan="3">${bean.materialPerson}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">材料提交人联系电话：</td>
            <td class="form_content" colspan="3">${bean.materialPersonPhone}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">材料提交人联系地址：</td>
            <td class="form_content" colspan="3">${bean.materialPersonAddress}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">收件人：</td>
            <td class="form_content" colspan="3">${bean.receivePerson}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">收件人联系电话：</td>
            <td class="form_content" colspan="3">${bean.receivePersonPhone}</td>
        </tr>
        <c:if test="${bean.status==STATUS_CS_PASS||bean.status==STATUS_FH_PASS||bean.status==STATUS_SH_PASS||bean.status==STATUS_FGLD_PASS||bean.status==STATUS_ZXLD_PASS}">
            <tr>
                <td colspan="4">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                        <tr class="tr_header">
                            <td style="width: 5%;">序号</td>
                            <td style="width: 25%;">提交材料名称</td>
                            <td style="width: 40%;">审核要求</td>
                            <td style="width: 8%;">初审意见</td>
                            <td style="width: 8%;">复核意见</td>
                            <td style="width: 8%;">审核意见</td>
                        </tr>
                        <c:forEach items="${submitList}" var="map">
                            <tr class="tr_dark">
                                <td style="text-align: center;">${map.no}</td>
                                <td style="text-align: left;">${map.materialName}</td>
                                <td style="text-align: left;">${map.auditReq}</td>
                                <td style="text-align: center;">
                                    <c:if test="${map.isCsOpinion=='true'}">符合</c:if>
                                    <c:if test="${map.isCsOpinion=='false'}">不符合</c:if>
                                </td>
                                <td style="text-align: center;">
                                    <c:if test="${map.isFhOpinion=='true'}">符合</c:if>
                                    <c:if test="${map.isFhOpinion=='false'}">不符合</c:if>
                                </td>
                                <td style="text-align: center;">
                                    <c:if test="${map.isShOpinion=='true'}">符合</c:if>
                                    <c:if test="${map.isShOpinion=='false'}">不符合</c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </c:if>
        <c:if test="${(bean.status==STATUS_CS_PASS)}">
            <tr class="tr_dark">
                <td class="form_label_right">初审意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                </td>
            </tr>
        </c:if>

        <c:if test="${(bean.status==STATUS_FH_PASS)}">
            <tr class="tr_dark">
                <td class="form_label_right">初审意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">复核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                </td>
            </tr>
        </c:if>

        <c:if test="${(bean.status==STATUS_SH_PASS)}">
            <tr class="tr_dark">
                <td class="form_label_right">初审意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">复核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">审核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                </td>
            </tr>
        </c:if>

        <c:if test="${(bean.status==STATUS_FGLD_PASS)}">
            <tr class="tr_dark">
                <td class="form_label_right">初审意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">复核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">审核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">分管领导审核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                </td>
            </tr>
        </c:if>

        <c:if test="${(bean.status==STATUS_ZXLD_PASS)}">
            <tr class="tr_dark">
                <td class="form_label_right">初审意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">复核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">审核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">分管领导审核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">中心领导审核意见：</td>
                <td class="form_content" colspan="3">
                    <sys:toHtml>${bean.zxldOpinion}</sys:toHtml>
                </td>
            </tr>
        </c:if>

        <c:if test="${(bean.status==STATUS_WLD_PASS)}">
            <tr class="tr_dark">
                <td class="form_label_right">初审意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">复核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">审核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">分管领导审核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">中心领导审核意见：</td>
                <td class="form_content" colspan="3">>
                    <sys:toHtml>${bean.zxldOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">委领导审核意见：</td>
                <td class="form_content" colspan="3">
                    <sys:toHtml>${bean.wldOpinion}</sys:toHtml>
                </td>
            </tr>
        </c:if>

        <tr class="tr_button">
            <td class="form_content" colspan="4" style="text-align: center;">
                <input type="button" value="打印审查表" class="button_normal_long" onclick="printView()">
                <input type="button" value="打印收件凭证" class="button_normal_longer" onclick="printView1()">
                <input type="button" value="打印受理" class="button_normal_long" onclick="printView2()">
                <input type="button" value="打印决定书" class="button_normal_long" onclick="printView3()">
                <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
            </td>
        </tr>
    </table>
</div>
