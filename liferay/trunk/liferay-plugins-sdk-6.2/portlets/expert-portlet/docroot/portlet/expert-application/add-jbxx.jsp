<%@page import="com.justonetech.expert.service.ExpertLocalServiceUtil"%>
<%@page import="com.justonetech.expert.model.Expert"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveJbxxURL" name="saveJbxx">
</portlet:actionURL>
<%
	long expertId = ParamUtil.getLong(request, "expertId");
	Expert expert = null;
	if(expertId!=0){
		expert = ExpertLocalServiceUtil.getExpert(expertId);
		String csny = expert.getSfzh().substring(6,12);
		String csn = csny.substring(0, 4);
		String csy = csny.substring(4,6);
		request.setAttribute("expert", expert);
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
			<td class="bg-white" width="30%"><aui:input name="xb" label="" value="${expert.xb}"
					cssClass="span6">
					<aui:validator name="required" />
				</aui:input></td>
		</tr>
		<tr>
			<td class="text-right">身份证号</td>
			<td class="bg-white" colspan="3"><aui:input name="sfzh" value="${expert.sfzh}"
					id="sfzh" label="" cssClass="span6" onblur="toCsny()">
					<aui:validator name="required"/>
				</aui:input></td>
		</tr>
		<tr>
			<td class="text-right">出生年月</td>
			<td class="bg-white" colspan="3"><aui:input name="cs" id="csn"
					label="" cssClass="span3" readonly="true" value="${csn}"></aui:input>年<aui:input
					name="csy" id="csy" label="" cssClass="span3" readonly="true" value="${csy}"></aui:input>月</td>
		</tr>
		<tr>
			<td class="text-right">工作单位</td>
			<td class="bg-white"><aui:input name="gzdw" label="" value="${expert.gzdw}"
					cssClass="span6">
					<aui:validator name="required" />
				</aui:input></td>
			<td class="text-right">电子邮箱</td>
			<td class="bg-white"><aui:input name="dzyx" label="" value="${expert.dzyx}"
					cssClass="span6"></aui:input></td>
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
			<td class="bg-white"><aui:input id="sjhm" name="sjhm" label="" value="${expert.sjhm}"
					cssClass="span6">
					<aui:validator name="required" />
				</aui:input></td>
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
		<aui:button type="submit" onClick="return checkInputMobilesNormal();" />
		<aui:button value="返回" href="${viewURL}" />
	</div>
</aui:form>
<script>
	function checkInputMobilesNormal() {
		var mobiles = $("#<portlet:namespace/>sjhm").val();

		var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
		if (mobiles != null && mobiles != "") {
			if (mobiles.indexOf(",") == -1) {
				if (!reg.test(mobiles)) {
					alert('“' + mobiles + '”是无效的手机号码！');
					return false;
					/* focusInput($("#<portlet:namespace />sjhm")); */
				}
			} else {
				var arr = mobiles.split(",");
				var length = arr.length;
				for (var i = 0; i < length; i++) {
					if (!reg.test(arr[i])) {
						alert('“' + arr[i] + '”是无效的手机号码！');
						return false;
						/* focusInput($("#<portlet:namespace />sjhm")); */
					}
				}
			}
		}
		if (mobiles == "") {
			alert('手机号不能为空！');
			return false;
			/* focusInput($("#<portlet:namespace />sjhm")); */
		}
	}
	function toCsny() {
		var sfzh = $("#<portlet:namespace />sfzh").val();
		var csn = sfzh.substr(6, 4);
		var csy = sfzh.substr(10, 2);
		$("#<portlet:namespace />csn").val(csn);
		$("#<portlet:namespace />csy").val(csy);
	}
</script>