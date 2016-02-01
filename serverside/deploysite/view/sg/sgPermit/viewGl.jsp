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
    function printView4() {
        window.open("${ctx}/sgPermit/printView4.do?id=${bean.id}", "补正材料通知书", "status=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width=800,hight=600;");
    }
    function printExcel1() {
        window.open("${ctx}/sgPermit/printExcel1.do?id=${bean.id}");
    }
    function printExcel2() {
        window.open("${ctx}/sgPermit/printExcel2.do?id=${bean.id}");
    }
</script>
<div class="form_div">
    <fieldset class="form_fieldset" style="width: 96%;">
        <legend>申请信息</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" nowrap>项目性质：</td>
                <td class="form_content" colspan="3">${bean.propertyType.name}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>报建编号：</td>
                <td class="form_content">${bean.bjbh}</td>
                <td class="form_label_right" nowrap>业务编号：</td>
                <td class="form_content">${bean.bizCode}</td>
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
                               <c:if test="${fn:contains(bean.buildLbIds, item.id)}">checked</c:if>
                               disabled>${item.name}&nbsp;
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
                <td class="form_label_right" nowrap>中标价格（万元）：</td>
                <td class="form_content">${bean.zbPrice}</td>
                <td class="form_label_right" nowrap>项目投资估算（万元）：</td>
                <td class="form_content">${bean.projectPlanCost}</td>
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
            <tr class="tr_light">
                <td class="form_label_right">现场开工情况：</td>
                <td class="form_content" colspan="3">${bean.startWorkCon}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">施工单位：</td>
                <td class="form_content" colspan="3">${bean.sgUnitName}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">监理单位：</td>
                <td class="form_content" colspan="3">${bean.jlUnitName}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">设计单位：</td>
                <td class="form_content" colspan="3">${bean.sjUnitName}</td>
            </tr>
            <tr>
                <td colspan="4">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                        <tr class="tr_header">
                            <td style="width: 5%;">序号</td>
                            <td style="width: 50%;">申请材料名称</td>
                            <td style="width: 8%;">应交份数</td>
                            <td style="width: 8%;">实交份数</td>
                            <td style="width: 15%;">附件</td>
                        </tr>
                        <c:forEach items="${applyList}" var="map">
                            <c:set value="upLoad${map.no}" var="upLoadNo"/>
                            <tr class="tr_dark">
                                <td style="text-align: center;">${map.no}</td>
                                <td style="text-align: left;">${map.materialName}</td>
                                <td style="text-align: center;">${map.yjNum}</td>
                                <td style="text-align: center;">${map.sjNum}</td>
                                <td style="text-align: center;">${map[upLoadNo]}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">提交时间：</td>
                <td class="form_content" colspan="3">
                    <fmt:formatDate value="${bean.submitDate}" pattern="yyyy-MM-dd HH:mm"/>
                </td>
            </tr>
        </table>
    </fieldset>
    <c:if test="${!isReg}">
    <div class="div_space"></div>
    <c:if test="${bean.status == STATUS_SLZX_PASS||bean.status==STATUS_CS_PASS||bean.status==STATUS_FH_PASS||bean.status==STATUS_SH_PASS||bean.status==STATUS_FGLD_PASS||bean.status==STATUS_ZXLD_PASS||bean.status==STATUS_WLD_PASS}">
        <fieldset class="form_fieldset" style="width: 96%;">
            <legend>受理初审</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" nowrap style="width: 20%;">受理编号：</td>
                    <td class="form_content" style="width: 80%;">${bean.acceptCode}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">沪交管收字</td>
                    <td class="form_content">
                        （${bean.hjgYear}）第&nbsp;${bean.hjgNum}&nbsp;号
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">申请人：</td>
                    <td class="form_content">${bean.applyPerson}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">申请事项：</td>
                    <td class="form_content">${bean.applyMatter}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">申请号：</td>
                    <td class="form_content">${bean.applyNum}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">材料提交人：</td>
                    <td class="form_content">${bean.materialPerson}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">材料提交人联系电话：</td>
                    <td class="form_content">${bean.materialPersonPhone}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">材料提交人联系地址：</td>
                    <td class="form_content">${bean.materialPersonAddress}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">收件人：</td>
                    <td class="form_content">${bean.receivePerson}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">收件人联系电话：</td>
                    <td class="form_content">${bean.receivePersonPhone}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">受理意见：</td>
                    <td class="form_content">
                        <sys:toHtml>${bean.acceptOpinion}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">受理时间：</td>
                    <td class="form_content">
                        <fmt:formatDate value="${bean.acceptDate}" pattern="yyyy-MM-dd HH:mm"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </c:if>
    <div class="div_space"></div>
    <c:if test="${bean.status==STATUS_CS_PASS||bean.status==STATUS_FH_PASS||bean.status==STATUS_SH_PASS||bean.status==STATUS_FGLD_PASS||bean.status==STATUS_ZXLD_PASS||bean.status==STATUS_WLD_PASS}">
        <fieldset class="form_fieldset" style="width: 96%;">
            <legend>审核信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr>
                    <td colspan="4">
                        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                            <tr class="tr_header">
                                <td style="width: 5%;">序号</td>
                                <td style="width: 25%;">提交材料名称</td>
                                <c:if test="${!isGreen}">
                                    <td style="width: 40%;">审核要求</td>
                                </c:if>
                                <c:if test="${isGreen}">
                                    <td style="width: 40%;">绿色审核要求</td>
                                </c:if>
                                <td style="width: 8%;">初审意见</td>
                                <td style="width: 8%;">复核意见</td>
                                <td style="width: 8%;">审核意见</td>
                            </tr>
                            <c:forEach items="${submitList}" var="map">
                                <tr class="tr_dark">
                                    <td style="text-align: center;">${map.no}</td>
                                    <td style="text-align: left;">${map.materialName}</td>
                                    <c:if test="${!isGreen}">
                                        <td style="text-align: left;">${map.auditReq}</td>
                                    </c:if>
                                    <c:if test="${isGreen}">
                                        <td style="text-align: left;">${map.auditReqGreen}</td>
                                    </c:if>
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
                <c:if test="${(bean.status==STATUS_CS_PASS)}">
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_CS_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">初审意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">初审时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                        <tr class="tr_dark">
                            <td class="form_label_right" style="width: 20%;">初审意见：</td>
                            <td class="form_content" style="width: 80%;">
                                <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 15%;">初审时间：</td>
                            <td class="form_content">
                                <fmt:formatDate value="${bean.csDate}" pattern="yyyy-MM-dd HH:mm"/>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>

                <c:if test="${(bean.status==STATUS_FH_PASS)}">
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_CS_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">初审意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">初审时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">初审意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">初审时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.csDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_FH_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">复核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">复核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">复核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">复核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.fhDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                </c:if>

                <c:if test="${(bean.status==STATUS_SH_PASS)}">
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_CS_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">初审意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">初审时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">初审意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">初审时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.csDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_FH_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">复核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">复核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">复核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">复核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.fhDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_SH_PASS||item.status==STATUS_SH_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.shDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                </c:if>

                <c:if test="${(bean.status==STATUS_FGLD_PASS)}">
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_CS_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">初审意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">初审时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">初审意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">初审时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.csDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_FH_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">复核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">复核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">复核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">复核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.fhDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_SH_PASS||item.status==STATUS_SH_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.shDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_FGLD_PASS||item.status==STATUS_FGLD_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">分管领导审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">分管领导审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">分管领导审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">分管领导审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.fgldDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                </c:if>

                <c:if test="${(bean.status==STATUS_ZXLD_PASS)}">
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_CS_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">初审意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">初审时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">初审意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">初审时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.csDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_FH_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">复核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">复核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">复核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">复核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.fhDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>

                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_SH_PASS||item.status==STATUS_SH_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.shDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_FGLD_PASS||item.status==STATUS_FGLD_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">分管领导审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">分管领导审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">分管领导审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">分管领导审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.fgldDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>

                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_ZXLD_PASS||item.status==STATUS_ZXLD_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">中心领导审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">中心领导审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">中心领导审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.zxldOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">中心领导审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.zxldDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                </c:if>

                <c:if test="${(bean.status==STATUS_WLD_PASS)}">
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_CS_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">初审意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">初审时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">初审意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">初审时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.csDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_FH_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">复核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">复核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">复核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">复核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.fhDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>

                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_SH_PASS||item.status==STATUS_SH_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.shDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_FGLD_PASS||item.status==STATUS_FGLD_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">分管领导审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">分管领导审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">分管领导审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">分管领导审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.fgldDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>

                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${(item.status==STATUS_ZXLD_PASS||item.status==STATUS_ZXLD_BACK) && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">中心领导审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">中心领导审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">中心领导审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.zxldOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">中心领导审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.zxldDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>

                    <c:forEach items="${historyOpinions}" var="item">
                        <c:if test="${item.status==STATUS_WLD_PASS && item.projectType.id==bean.projectType.id}">
                            <tr class="tr_dark">
                                <td class="form_label_right" style="width: 20%;">委领导审核意见：</td>
                                <td class="form_content" style="width: 80%;">
                                    <sys:toHtml>${item.opinion}</sys:toHtml>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" style="width: 15%;">委领导审核时间：</td>
                                <td class="form_content">
                                    <fmt:formatDate value="${item.auditDate}" pattern="yyyy-MM-dd HH:mm"/>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr class="tr_dark">
                        <td class="form_label_right" style="width: 20%;">委领导审核意见：</td>
                        <td class="form_content" style="width: 80%;">
                            <sys:toHtml>${bean.wldOpinion}</sys:toHtml>
                        </td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">委领导审核时间：</td>
                        <td class="form_content">
                            <fmt:formatDate value="${bean.wldDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                </c:if>
            </table>
        </fieldset>
    </c:if>
    </c:if>
    <div style="text-align: center;" class="tr_button">
        <c:if test="${!isReg}">
            <c:if test="${not empty bean.acceptDate||not empty bean.csDate||not empty bean.fhDate||not empty bean.shDate||not empty bean.fgldDate||not empty bean.zxldDate||not empty bean.wldDate}">
                <input type="button" value="收件凭证" class="button_normal_long" onclick="printView1()">
            </c:if>
            <c:if test="${not empty bean.shDate||not empty bean.fgldDate||not empty bean.zxldDate||not empty bean.wldDate}">
                <input type="button" value="受理通知书" class="button_normal_long" onclick="printView2()">
                <input type="button" value="不予受理决定书" class="button_normal_longer" onclick="printView3()">
                <input type="button" value="补正材料" class="button_normal_long" onclick="printView4()">
            </c:if>
            <c:if test="${bean.status == STATUS_ZXLD_PASS||bean.status == STATUS_WLD_PASS}">
                <input type="button" value="技术审查表" class="button_normal_long" onclick="printView()">
                <c:if test="${!isGreen}">
                    <input type="button" value="施工许可" class="button_normal_long" onclick="printExcel1()">
                </c:if>
                <c:if test="${isGreen}">
                    <input type="button" value="施工许可（绿色）" class="button_normal_longer" onclick="printExcel2()">
                </c:if>
            </c:if>
        </c:if>
        <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
    </div>
    <div class="div_space"></div>
</div>

