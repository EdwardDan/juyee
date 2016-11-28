<%@page import="com.justonetech.expert.service.ExpertLocalServiceUtil"%>
<%@page import="com.justonetech.expert.model.Expert"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />
<portlet:actionURL var="saveJbxxURL" name="saveJbxx">
	<portlet:param name="redirectURL" value="${addExpertUrl}"/>
</portlet:actionURL>
<%
	long userId = user.getUserId();
	List<Expert> experts = ExpertLocalServiceUtil.getExperts(userId, -1, -1);
	long expertId = 0l;
	if(experts.size()>0){
			expertId = experts.get(0).getExpertId();
			String csny = experts.get(0).getSfzh().substring(6,12);
			String csn = csny.substring(0, 4);
			String csy = csny.substring(4,6);
			request.setAttribute("expert", experts.get(0));
			request.setAttribute("csn", csn);
			request.setAttribute("csy", csy);
	}
	
%>
<aui:form action="${saveJbxxURL}">
	<aui:input name="expertId" type="hidden" value="<%=expertId%>" />
	<table class="table table-bordered" width="100%">
		<tr>
			<td class="text-right" width="20%">姓名</td>
			<td class="bg-white" width="30%"><aui:input name="xm" label="" value="${expert.xm}"
					cssClass="span6">
					<aui:validator name="required" />
				</aui:input></td>
			<td class="text-right" width="20%">性别</td>
			<td class="bg-white" width="30%">
				<aui:select name="xb" label="" cssClass="span6"> 
					<aui:option value="男" selected="${expert.xb eq '男'}">男</aui:option>
					<aui:option value="女" selected="${expert.xb eq '女'}">女</aui:option>
				</aui:select>
			</td>
		</tr>
		<tr>
			<td class="text-right">身份证号</td>
			<td class="bg-white" colspan="3"><aui:input id="sfzh" name="sfzh" value="${expert.sfzh}"
					label="" cssClass="span6" onChange="toCsny()">
					<aui:validator name="required"/>
					<aui:validator name="custom" errorMessage="请输入有效的身份证号。">
						function(val){
							var regSfzh = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
							if (regSfzh.test(val) == false) {
					            return false;
					        }else{
					        	return true;
					        }
						}
					</aui:validator>
				</aui:input></td>
		</tr>
		<tr>
			<td class="text-right">出生年月</td>
			<td class="bg-white" colspan="3" style="white-space:nowrap;"><input name="cs" id="csn"
					label="" readonly="true" value="${csn}"/>年<input
					name="csy" id="csy"  readonly="true" value="${csy}"/>月</td>
		</tr>
		<tr>
			<td class="text-right">工作单位</td>
			<td class="bg-white"><aui:input name="gzdw" label="" value="${expert.gzdw}"
					cssClass="span6">
					<aui:validator name="required" />
				</aui:input></td>
			<td class="text-right">电子邮箱</td>
			<td class="bg-white">
				<aui:input id="dzyx" name="dzyx" label="" value="${expert.dzyx}" cssClass="span6">
					<aui:validator name="email"/>
				</aui:input></td>
		</tr>
		<tr>
			<td class="text-right">通信地址</td>
			<td class="bg-white"><aui:input name="txdz" label="" value="${expert.txdz}"
					cssClass="span6"></aui:input></td>
			<td class="text-right">邮政编码</td>
			<td class="bg-white"><aui:input name="yzbm" label="" value="${expert.yzbm}"
					cssClass="span6"></aui:input></td>
		</tr>
		<tr>
			<td class="text-right">现任职务</td>
			<td class="bg-white"><aui:input name="xrzw" label="" value="${expert.xrzw}"
					cssClass="span6"></aui:input></td>
			<td class="text-right">职称</td>
			<td class="bg-white"><aui:input name="zc" label="" value="${expert.zc}"
					cssClass="span6">
					<aui:validator name="required" />
				</aui:input></td>
		</tr>
		<tr>
			<td class="text-right">执业资格</td>
			<td class="bg-white"><aui:input name="zyzg" label="" value="${expert.zyzg}"
					cssClass="span6">
					<aui:validator name="required" />
				</aui:input></td>
			<td class="text-right">从事专业</td>
			<td class="bg-white"><aui:input name="cszy" label="" value="${expert.cszy}"
					cssClass="span6"></aui:input></td>
		</tr>
		<tr>
			<td class="text-right">专业工作年限</td>
			<td class="bg-white"><aui:input name="zygznx" label="" value="${expert.zygznx}"
					cssClass="span6"></aui:input></td>
			<td class="text-right">手机号码</td>
			<td class="bg-white">
				<aui:input id="sjhm" name="sjhm" label="" value="${expert.sjhm}" cssClass="span6">
					<aui:validator name="required" />
					<aui:validator name="custom" errorMessage="请输入有效的手机号码。">
						function(val){
							var regSjhm = /^1[3|4|5|7|8][0-9]\d{8}$/;
							if (regSjhm.test(val) == false) {
					            return false;
					        }else{
					        	return true;
					        }
						}
					</aui:validator>
				</aui:input>
			</td>
		</tr>
		<tr>
			<td class="text-right">联系电话</td>
			<td class="bg-white"><aui:input name="lxdh" label="" value="${expert.lxdh}"
					cssClass="span6"></aui:input></td>
			<td class="text-right">传真</td>
			<td class="bg-white"><aui:input name="cz" label="" value="${expert.cz}"
					cssClass="span6"></aui:input></td>
		</tr>
	</table>
	<div style="text-align: center">
		<aui:button type="submit"/>
		<aui:button value="返回" href="${viewURL}" />
	</div>
</aui:form>
<script>	
	function toCsny(){
		var sfzh = document.getElementById("<portlet:namespace/>sfzh").value;
		var csn = sfzh.substr(6, 4);
		var csy = sfzh.substr(10, 2);
		document.getElementById("csn").value = csn;
		document.getElementById("csy").value = csy;
	}
</script>