<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.getApplyMaterials(-1, -1);
	request.setAttribute("applyMaterials", applyMaterials);
	int num = 1;
%>

<aui:form>
	<table style="width: 98%" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th width="5%" class="text-center">序号</th>
				<th width="30%" class="text-center">材料提交名称</th>
				<th width="35%" class="text-center">审核要求</th>
				<th width="10%" class="text-center">初审意见</th>
				<th width="10%" class="text-center">复核意见</th>
				<th width="10%" class="text-center">审核意见</th>
			</tr>
		</thead>
		<tbody id="applyMaterials">
			<c:if test="${!empty applyMaterials}">
				<c:forEach items="<%=applyMaterials%>" var="applyMaterial">
					<tr>
						<td class="text-center"><%=String.valueOf(num)%></td>
						<td class="text-left">${applyMaterial.clmc}</td>
						<td class="text-left">${applyMaterial.shyq}</td>
						<td><aui:select name="csyj" label="" cssClass="span11">
								<aui:option>符合</aui:option>
								<aui:option>不符合</aui:option>
							</aui:select></td>
						<td><aui:select name="fhyj" label="" cssClass="span11">
								<aui:option>符合</aui:option>
								<aui:option>不符合</aui:option>
							</aui:select></td>
						<td><aui:select name="shyj" label="" cssClass="span11">
								<aui:option>符合</aui:option>
								<aui:option>不符合</aui:option>
							</aui:select></td>
					</tr>
					<%
						num++;
					%>
				</c:forEach>
			</c:if>
		</tbody>

	</table>

	<div class="text-center">
		审核意见：
		<textarea rows="3" name="shyj" style="width: 70%; margin-bottom: 15px; margin-top: 15px"></textarea>
	</div>
	<div class="text-center">
		<div class="btn-group">
			<aui:button name="pass" value="审核通过" cssClass="btn btn-primary" />
		</div>
		<div class="btn-group">
			<aui:button name="close" value="审核退回" cssClass="btn btn-danger" onClick="shth()" />
		</div>
		<div class="btn-group">
			<aui:button name="close" value="补正退回" cssClass="btn btn-danger" />
		</div>
		<div class="btn-group">
			<aui:button name="close" value="内部退回" cssClass="btn btn-danger" />
		</div>
		<div class="btn-group">
			<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}" />
		</div>
	</div>
</aui:form>
<portlet:renderURL var="shthURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath }/approval-current-city/sh-shth.jsp" />
</portlet:renderURL>
<aui:script>
	function shth() {
		/* AUI().use('aui-modal','aui-dialog-iframe-deprecated','io-plugin-deprecated'
		,function(A) {
		var url = '${shthURL}';
		    var modal = new A.Modal(
		      {
		        bodyContent: '正文件',
		        centered: true,
		        headerContent: '<h3>退回选择页面</h3>',
		        modal: false,
		        destroyOnHide: true,
		        render: '#modal',
		        width: 750,
		        height:600,
		        toolbars:{
		        footer:[
		              {
		                 label: '取消',
		                 on: {
		                   click: function() {
		                     modal.hide();
		                   }
		                 }
		               },
		               {
		                 label: '确定',
		                 on: {
		                   click: function() {
		                     alert('点击了确定，可以在这里调用其他函数');
		                   }
		                 },
		                primary: true
		               }         ]
		        }
		      }
		    ).plug(
		       A.Plugin.DialogIframe,
		        {
		        uri: url,
		        }
		       )
		.render();
		}); */
	}
	Liferay.provide(window, 'shth', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600,
				toolbars : {
					footer : [ {
						label : '取消',
						on : {
							click : function() {
								dialog.destroy();
							}
						}
					}, {
						label : '确定',
						on : {
							click : function() {
								alert('点击了确定，可以在这里调用其他函数');
							}
						},
						primary : true
					} ]
				}
			},
			id : 'popup',
			title : '审批',
			uri : '${shthURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);

	
</aui:script>