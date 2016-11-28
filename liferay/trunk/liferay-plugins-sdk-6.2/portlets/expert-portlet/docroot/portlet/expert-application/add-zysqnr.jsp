<%@page import="com.justonetech.expert.model.Zysqlb"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<portlet:resourceURL var="fetchZysResourceURL" />
<%
	Zysqlb zysqlb = (Zysqlb)request.getAttribute("zysqlb");
	long expertId = ParamUtil.getLong(request, "expertId");
	request.setAttribute("expertId",expertId);
%>
<c:set var="backUrl"
	value="${addExpertUrl}&${renderResponse.namespace}expertId=${expertId}"></c:set>
<aui:model-context bean="${zysqlb}" model="<%=Zysqlb.class %>" />
<liferay-ui:header title='${empty zysqlb?"添加":"编辑"}专业申请'
	backURL="${backUrl}" />
<portlet:actionURL var="saveZysqlbURL" name="saveZysqlb">
	<portlet:param name="redirect" value="${backUrl}" />
</portlet:actionURL>
<aui:form action="${saveZysqlbURL}">
	<aui:input name="expertId" type="hidden" value="${expertId}" />
	<aui:input name="zysqlbId" type="hidden" />
	<aui:input name="zt" type="hidden" value="1" />
	<table class="table table-bordered" width="100%">
		<tr>
			<td class="text-left" width="10%">选择申请事项</td>
			<td class="bg-white" width="90%"><aui:select name="sx" label=""
					type="select" style="width:20%"
					onChange='<%= renderResponse.getNamespace() + "fetchZys();"%>'>
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode("sqsx");
																				if (null != dictionary) {
																					List<Dictionary> dictionaries = DictionaryLocalServiceUtil.findByParentId(
																							dictionary.getDictionaryId(), -1, -1);
																					for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
																				}
					%>
				</aui:select></td>
		</tr>
		<tr>
			<td class="text-left">选择专业类别</td>
			<td class="bg-white">
				<div id="<portlet:namespace />zyInput">
					<%
						if(null==zysqlb){
														Dictionary dic = DictionaryLocalServiceUtil.findByCode("jssc");
														if (null != dic) {
															List<Dictionary> jssc = DictionaryLocalServiceUtil
																	.findByParentId( dic.getDictionaryId(), -1, -1);
															request.setAttribute("jssc", jssc);
														}
					%>
					<c:forEach items="${jssc}" var="jssc" varStatus="sortNo">
						<input name="<portlet:namespace/>zy" type="checkbox"
							id="jssc${sortNo.index}" value="${jssc.dictionaryId}"
							inlineField="true">${jssc. name}</input><br>
					</c:forEach>
					<%
						}
												else{ 
														Dictionary dic = DictionaryLocalServiceUtil.getDictionary(Long.parseLong(zysqlb.getSx()));
														if (null != dic) {
															List<Dictionary> lb = DictionaryLocalServiceUtil
																	.findByParentId( dic.getDictionaryId(), -1, -1);
															request.setAttribute("lb", lb);
														}
					%>
					<c:forEach items="${lb}" var="lb" varStatus="sortNo">
						<c:choose>
							<c:when test="${fn:contains(zysqlb.zy,lb.name)}">
								<input name="<portlet:namespace/>zy" type="checkbox"
									id="lb${sortNo.index}" value="${lb.dictionaryId}"
									checked="checked" inlineField="true">${lb. name}</input>
							</c:when>
							<c:otherwise>
								<input name="<portlet:namespace/>zy" type="checkbox"
									id="lb${sortNo.index}" value="${lb.dictionaryId}"
									inlineField="true">${lb. name}</input>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<%
						}
					%>
				</div>
			</td>
		</tr>
	</table>
	<div style="text-align: center">
		<aui:button type="submit" value="提交" onClick="return checkBoxs()" />
		<aui:button type="cancel" value="取消" href="${backUrl}" />
	</div>
</aui:form>
<aui:script use="aui-io-request,aui-node">
Liferay.provide(
	    window,
	    '<portlet:namespace />fetchZys',
	    function() {
	        var A = AUI();
	        var fetchZysURL = '<%= fetchZysResourceURL.toString() %>';
	        var sourceElement = A.one("#<portlet:namespace />sx");
	        var targetElement = A.one("#<portlet:namespace />zyInput");
	        A.io.request (
	            fetchZysURL, {
	            	   data: {
	                        <portlet:namespace />subject: sourceElement.val()
	                    },
	            dataType: 'json',
	            on: {
	                    failure: function() {
	                        alert("Ajax failed! There was some error at the server");
	                    },
	                    
	                    success: function(event, id, obj) {
	                      var topicsArray = this.get('responseData');
	                      targetElement.html("");
	                        for (var j=0; j < topicsArray.length; j++) {
	                        	 var zyCheckBox="<"+"input name='<portlet:namespace/>zy' type='checkbox' value='"+topicsArray[j].id +"' "+" inlineField='true' " +" > " + topicsArray[j].name +"</input>&nbsp;&nbsp;&nbsp;";
	                        	targetElement.append(zyCheckBox);
	                        } 
	                    }
	                }
	            }
	        ); 
	    }
	);
</aui:script>
	

<script>
function checkBoxs(){
	var checkArry = document.getElementsByName("<portlet:namespace/>zy");
	var flag = false;
    for (var i = 0; i < checkArry.length; i++) { 
        if(checkArry[i].checked == true){
            //选中的操作
            flag =true;
        }
    }
    if (flag==true){
    	return true;
    }else{
    	alert("请至少选择一个！");
    	return false;
    }
	
}
</script>