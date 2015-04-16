<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_header">
        <td width="7%" nowrap class="form_border">序号</td>
        <%--<td width="9%" nowrap class="form_border">流转编号</td>--%>
        <td width="9%" nowrap class="form_border">报建编号</td>
        <td width="9%" nowrap class="form_border">监督任务编号</td>
        <td width="9%" nowrap class="form_border">报监日期</td>
        <td width="30%" nowrap class="form_border">项目名称</td>
        <td width="9%" nowrap class="form_border">监督人员</td>
        <td width="9%" nowrap class="form_border">计划完成日期</td>
        <td width="9%" nowrap class="form_border">最后监督时间</td>
        <c:if test="${isEdit||isAudit}">
            <td width="5%" nowrap class="form_border">操作</td>
        </c:if>
    </tr>
    <c:forEach items="${list}" var="item" varStatus="status">
        <tr
                <c:choose>
                    <c:when test="${status.index % 2==0}">class="tr_light" </c:when>
                    <c:otherwise>class="tr_dark" </c:otherwise>
                </c:choose>>
            <input type="hidden" name="jdTaskCode" value="${item.task.jdTaskCode}"/>
            <td nowrap class="form_border">${status.index+1}</td>
            <%--<td nowrap class="form_border"><a href="javascript:void(0)" title="查看项目信息"--%>
                                              <%--onclick="viewProjectInfo('查看项目信息',null,null,'${item.task.jdTaskCode}',false,true);"--%>
                                              <%--class="page_link">${item.task.jdTaskCode}</a></td>--%>
            <td nowrap class="form_border">${item.task.bjbh}</td>
            <td class="form_content" nowrap>${item.task.jdTaskCode}</td>
            <td class="form_content" nowrap><fmt:formatDate value="${item.task.jdDatetime}" pattern="yyyy-MM-dd"/></td>
            <td class="form_content">${item.task.projectName}</td>
            <c:choose>
                <c:when test="${isEdit||isAudit}">
                    <td nowrap class="form_border">
                        <input type="text" name ="jdManagerName_${item.task.jdTaskCode}" id ="jdManagerName_${item.task.jdTaskCode}"   value="${item['jdManagerName']}"
                               class="input_text" style="width: 80px" readonly="true"/>
                        <input type="hidden" name="jdManager_${item.task.jdTaskCode}" id= "jdManager_${item.task.jdTaskCode}" value="${item['jdManager']}"/>
                        <input type="button" value=" " class="button_select"
                               onclick="multiSelectSysUser('','jdManager_${item.task.jdTaskCode}','jdManagerName_${item.task.jdTaskCode}');" title="点击选择人员">
                        <%--<select name="workGroup_${item.task.jdTaskCode}">--%>
                            <%--<c:forEach items="${item.groupList}" var="group">--%>
                                <%--<option value="${group.id}"--%>
                                        <%--<c:if test="${group.id==item.groupId}">selected</c:if>>${group.name}</option>--%>
                            <%--</c:forEach>--%>
                        <%--</select>--%>
                    </td>
                    <td nowrap class="form_border">
                        <input type="text" name="completeDate_${item.task.jdTaskCode}"
                               id="completeDate_${item.task.jdTaskCode}"
                               class="input_date" style="width: 76px"
                               value="<fmt:formatDate value="${item.detail.planEndTime}" pattern="yyyy-MM-dd"/>"
                               onClick="calendar('completeDate_${item.task.jdTaskCode}')" readonly="true"/>


                        <input type="hidden" name="v_selectCause_${item.task.jdTaskCode}"
                               id="v_selectCause_${item.task.jdTaskCode}" style="width: 76px"
                               value="${item.detail.selectCause}"/>
                        <input type="hidden" name="v_causeOther_${item.task.jdTaskCode}"
                               id="v_causeOther_${item.task.jdTaskCode}" style="width: 76px"
                               value="${item.detail.selectCauseOther}"/>

                    </td>
                    <td align="left" nowrap class="form_border">
                        &nbsp;<fmt:formatDate value="${item.planEndTimeLast}" pattern="yyyy-MM-dd"/>
                        <c:if test="${not empty item.detail.selectCause}">
                            <img src="${ctx}/skin/default/jquery/zTreeStyle/img/diy/pencil.png" id="2opImage"
                                 title="原因：${item.detail.selectCause}。 ${item.detail.selectCauseOther}"/>
                        </c:if>
                    </td>
                    <td class="form_content"><input type="button" value=" " class="button_select_remove"
                                                    onclick="parent.doRemove(this,'${item.detail.id}')" title="移除"></td>
                </c:when>
                <c:otherwise>
                    <td nowrap class="form_border">
                        &nbsp;${item['jdManagerName']}
                        <input type="hidden" name="workGroup_${item.task.jdTaskCode}" value="${item.detail.group.id}"/>
                    </td>
                    <td nowrap class="form_border">
                        &nbsp;<fmt:formatDate value="${item.detail.planEndTime}" pattern="yyyy-MM-dd"/>
                        <input type="hidden" name="completeDate_${item.task.jdTaskCode}"
                               value="<fmt:formatDate value="${item.detail.planEndTime}" pattern="yyyy-MM-dd"/>"/>

                        <input type="hidden" name="v_selectCause_${item.task.jdTaskCode}"
                               style="width: 76px" value="${item.detail.selectCause}"/>
                        <input type="hidden" name="v_causeOther_${item.task.jdTaskCode}"
                               style="width: 76px" value="${item.detail.selectCauseOther}"/>

                    </td>
                    <td  align="left" nowrap class="form_border">
                        &nbsp;<fmt:formatDate value="${item.planEndTimeLast}" pattern="yyyy-MM-dd"/>
                        <c:if test="${not empty item.detail.selectCause}">
                            <img src="${ctx}/skin/default/jquery/zTreeStyle/img/diy/pencil.png" id="2opImage"
                                 title="原因：${item.detail.selectCause}。 ${item.detail.selectCauseOther}"/>
                        </c:if>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>