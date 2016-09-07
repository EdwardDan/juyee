<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<style type="text/css">
tr {
	text-align: center;
}

tr.head  td {
	background-color: #63B8FF;
	text-align: center;
	font-size: 16px;
	color: white;
	font-family: "宋体";
	font-weight: bold;
}

tr.body td.title {
	width: 20%;
}

tr.body td.content {
	width: 30%;
	text-align: left;
}
</style>
<%
	String bjbh = ParamUtil.getString(request, "bjbh");
	Long permitId = ParamUtil.getLong(request, "permitId");
	ProjectProfile projectProfile = null;
	Project project = null;
	if (permitId != 0) {
		projectProfile = ProjectProfileLocalServiceUtil
				.getProjectProfile(permitId);
		request.setAttribute("projectProfile", projectProfile);
		String startDate = "";
		String endDate = "";
		if (null != projectProfile.getJhkg()&&null != projectProfile.getJhjg()) {
			startDate = DateUtil.getDate(projectProfile.getJhkg(), defaultDateFormatPattern, locale,
					timeZone);
			endDate = DateUtil.getDate(projectProfile.getJhjg(), defaultDateFormatPattern, locale, timeZone);
			request.setAttribute("jhkg", startDate);
			request.setAttribute("jhjg", endDate);
		}
	} else {
		if (Validator.isNotNull(bjbh)) {
			project = ProjectLocalServiceUtil.getProject(bjbh);
			request.setAttribute("project", project);
		}
	}
	Dictionary jsgclbDic = DictionaryLocalServiceUtil.findByCode("jsgclb");
	List<Dictionary> jsgclbs = jsgclbDic != null ? DictionaryLocalServiceUtil.findByParentId(
			jsgclbDic.getDictionaryId(), -1, -1) : null;
			request.setAttribute("jsgclbs",jsgclbs);
%>
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveProjectProfileURL" name="saveProjectProfile">
	<portlet:param name="redirectURL" value="${editPermitURL }"/>
</portlet:actionURL>
<aui:model-context bean="${projectProfile}"
	model="<%=ProjectProfile.class%>" />
<aui:form action="${saveProjectProfileURL}">
	<aui:input name="permitId" type="hidden" value="<%=permitId%>" />
	<aui:input name="bjbh" type="hidden" value="<%=bjbh%>" />
	<aui:input name="bdh" type="hidden" value="${bdh }" />
	<aui:input name="sqbz" type="hidden" value="2" />
	<table border="1" width="100%">
	<tr class="body">
			<td class="title">项目类型</td>
			<td class="content"><aui:select name="xmlx" label="" 
					type="select" style="width:50%">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"xmlx");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>
				</td>
			<td class="title">立项级别</td>
			<td class="content"><aui:input name="lxjb" label="" type="text"
					style="width:50%" value="${project.lxjb }">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">项目性质</td>
			<td class="content" colspan="3"><aui:select name="xmxz" label=""
					type="select" style="width:18.7%">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"xmxz");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select></td>
		</tr>
		<tr class="body">
			<td class="title">业务编码</td>
			<td class="content" colspan="3"><aui:input name="ywbm" label="" type="text"
					style="width:50%" value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设单位名称</td>
			<td class="content" colspan="3"><aui:input name="jsdwmc"
					label="" type="text" style="width:50%" value="${project.jsdw}"
					readonly="true">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设单位性质</td>
			<td class="content" colspan="3"><aui:input name="jsdwxz"
					label="" type="text" style="width:50%" value="${project.jsdwxz}"
					readonly="true">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设单位地址</td>
			<td class="content" colspan="3"><aui:input name="jsdwdz"
					label="" type="text" style="width:50%" value="${project.jsdwdz}"
					readonly="true">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">工程名称</td>
			<td class="content" colspan="3"><aui:input name="gcmc" label=""
					type="text" style="width:60%" value="${project.xmmc}">
				</aui:input>(本次申请施工许可名称)</td>
		</tr>
		<tr class="body">
			<td class="title">建设地点</td>
			<td class="content" colspan="3"><aui:input name="jsdd" label=""
					type="text" style="width:50%" value="${project.jsdd}">
				</aui:input>(请按建设工程规划许可证填写本次申请施工许可的建设地点)</td>
		</tr>
		<tr class="body">
			<td class="title">建设地点所属区县</td>
			<td class="content" colspan="3">
			<aui:select name="jsddssqx" label="" showEmptyOption="true"
					type="select" style="width:70px">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"qx");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>
			</td>
		</tr>
		<tr class="body">
			<td class="title">建设工程类别</td>
			<td class="content" colspan="3">
			<c:forEach items="${jsgclbs}" var="jsgclb"
								varStatus="sortNo">
								<aui:input name="jsgclb" type="checkbox" id="jsgclb${sortNo.index}"
									value="${jsgclb.dictionaryId}"
									checked="${fn:contains(projectProfile.jsgclb,jsgclb.dictionaryId)}"
									label="${jsgclb. name}" inlineField="true" />
								<c:if test="${sortNo.index>0 && (sortNo.index+1) % 9 == 0}">
									<br>
								</c:if>
							</c:forEach>
			</td>
		</tr>
		<tr class="body">
			<td class="title">建设工程属性</td>
			<td class="content" colspan="3">
			<aui:select name="jsgcsx" label=""
					type="select" style="width:70px">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"jsgcsx");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>
			</td>
		</tr>
		<tr class="body">
			<td class="title">建设工程规模</td>
			<td class="content" colspan="3"><aui:input name="jsgcgm"
					label="" type="text" style="width:50%" value="${project.jsgm}">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">国有资金比重%</td>
			<td class="content" colspan="3"><aui:input name="gyzjbz" label="" type="text"
					style="width:50%" value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">房屋建筑面积(㎡)</td>
			<td class="content" colspan="3"><aui:input name="fwjzmj"
					label="" type="text" style="width:18.7%" value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">合同价格(万元)</td>
			<td class="content"><aui:input name="htjg" label="" type="text"
					style="width:50%" value="${contract.ztz}">
				</aui:input></td>
			<td class="title">合同工期(日历天)</td>
			<td class="content"><aui:input name="htgq" label="" type="text"
					style="width:50%" value="">
				</aui:input></td>
		</tr>
			<tr class="body">
			<td class="title">中标价格(万元)</td>
			<td class="content"><aui:input name="zbjg" label="" type="text"
					style="width:50%" value="">
				</aui:input></td>
			<td class="title">项目投资估算(万元)</td>
			<td class="content"><aui:input name="xmtzgs" label="" type="text"
					style="width:50%" value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">法定代表人</td>
			<td class="content"><aui:input name="fddbr" label="" type="text"
					style="width:50%" value="${project.jsdwfr }" readonly="true">
				</aui:input></td>
			<td class="title">建设单位联系电话</td>
			<td class="content"><aui:input name="jsdwlxdh" label=""
					type="text" style="width:50%" value="${project.jsdwdh}">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设单位联系人</td>
			<td class="content"><aui:input name="jsdwlxr" label=""
					type="text" style="width:50%" value="${project.jsdwlxr}">
				</aui:input></td>
			<td class="title">联系人手机号</td>
			<td class="content">
					<aui:input name="jsdwsjh" label=""  type="text"
						style="width:50%" value="">
					</aui:input>
			</td>
		</tr>
		<tr class="body">
			<td class="title">建设用地批准文件或房地产产权证编号</td>
			<td class="content" colspan="3"><aui:input
					name="jsydpzwjhfdccqzbh" label="" type="text" style="width:50%"
					value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">建设工程规划许可证编号</td>
			<td class="content" colspan="3"><aui:input name="jsgcghxkzbh"
					label="" type="text" style="width:50%" value="">
				</aui:input></td>
		</tr>
		<tr class="body">
			<td class="title">现场开工情况</td>
			<td class="content" colspan="3"><aui:select name="xckgqk" label=""
					type="select" style="width:80px">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"xckgqk");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select></td>
		</tr>
		<tr class="body">
			<td class="title">计划开工</td>
			<td class="content"><input type="text" class="Wdate" id="jhkg"
					name="<portlet:namespace/>jhkg" value="${jhkg}" 
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'jhkg\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
			required="required"/></td>
			<td class="title">计划竣工</td>
			<td class="content"><input type="text" class="Wdate" id="jhjg"
					name="<portlet:namespace/>jhjg" value="${jhjg}" 
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\'jhjg\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
			required="required"/></td>
		</tr>
	<tr class="body">
			<td class="content" colspan="4"><c:choose>
					<c:when test="${projectProfile.sfzftzl }">
						<aui:input name="sfzftzl" id="sfzftzl" label="是否政府投资类"
							type="checkbox" checked="true" onchange="showYzzpl(this)">
						</aui:input>
					</c:when>
					<c:otherwise>
						<aui:input name="sfzftzl" id="sfzftzl" label="是否政府投资类"
							type="checkbox" checked="false" onchange="showYzzpl(this)">
						</aui:input>
					</c:otherwise>
				</c:choose></td>
		</tr>
		<c:choose>
			<c:when test="${projectProfile.sfzftzl }">
				<tr class="body" id="yzzpl">
			</c:when>
			<c:otherwise>
				<tr class="body" id="yzzpl" style="display: none">
			</c:otherwise>
		</c:choose>
		<td colspan="4">
			<table style="width: 99%;">
				<tr class="body">
					<td class="title" rowspan="4">预制装配率</td>
					<td class="content" colspan="2">单跨跨径100米以下桥梁工程承台顶面以上构件</td>
					<td class="content"><aui:row><aui:input name="yzzpl1" label="" inlineField="true"
							type="text" style="width:30px" value="">
						</aui:input>%</aui:row></td>
				</tr>
				<tr class="body">
					<td class="content" colspan="2">隧道工程盾构段</td>
					<td class="content"><aui:row><aui:input name="yzzpl2" label="" inlineField="true"
							type="text" style="width:30px" value="">
						</aui:input>%</aui:row></td>
				</tr>
				<tr class="body">
					<td class="content" colspan="2">轨道交通工程地下过街通道</td>
					<td class="content"><aui:row><aui:input name="yzzpl3" label="" inlineField="true"
							type="text" style="width:30px" value="">
						</aui:input>%</aui:row></td>
				</tr>
				<tr class="body">
					<td class="content" colspan="2">水运工程（港口）桩顶面以上构件</td>
					<td class="content"><aui:row><aui:input name="yzzpl4" label="" inlineField="true"
							type="text" style="width:30px" value="">
						</aui:input>%</aui:row></td>
				</tr>
			</table>
		</td>
		</tr>
		<tr class="body">
			<td class="title" colspan="4">注:信息保存后，请进入参见单位和项目负责人信息页面，填写参建单位和项目负责人信息</td>
		</tr>
		<tr class="body">
			<td class="title" colspan="4"><aui:button type="submit" /> <aui:button
					value="返回" href="${viewURL}" /></td>
		</tr>
	</table>

</aui:form>

<script>

function showYzzpl(obj) {	
    if (obj.checked) {
        $("#sfzftzl").val("true");
        document.getElementById("yzzpl").style.display = "";
    } else {
        $("#sfzftzl").val("false");
        document.getElementById("yzzpl").style.display = "none";
    }
}
</script>