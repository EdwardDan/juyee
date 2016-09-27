<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<style media=print type="text/css">
.noprint {
	visibility: hidden
}
</style>
<%
	Long permitId = ParamUtil.getLong(request, "permitId");
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	request.setAttribute("permit", permit);
	User me=PortalUtil.getUser(request);
	
	String bjbhInit = permit.getBjbh();
	//根据报建编号获取报建项目信息
	Project projectInit = ProjectLocalServiceUtil.getProject(bjbhInit);
	String lxjbInit = projectInit.getLxjb();
	String qxLxjbInit = "区县级机关或区县级单位";
	String comment="";
		Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
		List<Integer> logTypes = new ArrayList<Integer>();
		logTypes.add(WorkflowLog.TASK_COMPLETION);
		if(WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.cp.permit.model.Permit", permit.getPermitId())){
		List<WorkflowLog> workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(company.getCompanyId(), WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.cp.permit.model.Permit", permit.getPermitId()).getWorkflowInstanceId(), logTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
		if(lxjbInit.equals(qxLxjbInit)){
			for(int i=0;i<workflowLogs.size();i++){
				 if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state41")){
				   if(workflowLogs.get(i).getState().equals("quxianshenpi")){comment=workflowLogs.get(i).getComment();
				   }
				}
			}
		}else{
			for(int i=0;i<workflowLogs.size();i++){
				 if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state40")){
				   if(workflowLogs.get(i).getState().equals("shenhe")){comment=workflowLogs.get(i).getComment();
				   }
				}
			}
		}
		
		   }
		if(comment.indexOf("&")>0){
			comment=comment.substring(comment.indexOf("&")+1);//因为意见和评论合并，故在此处划分
		}
%>
<OBJECT id="WebBrowser1" height=0 width=0
	classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 name=wb></OBJECT>
<html>
<head>
<title>补正材料通知书</title>
</head>
<body lang=ZH-CN
	style='tab-interval: 21.0pt; text-justify-trim: punctuation'>

	<div class=Section1 style='layout-grid: 15.6pt'>

		<p class=MsoNormal align=center style='text-align: center'>
			<b style='mso-bidi-font-weight: normal'><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>补正材料通知书</span></b><b
				style='mso-bidi-font-weight: normal'><span lang=EN-US
				style='font-size: 14.0pt'><o:p></o:p></span></b>
		</p>

		<p class=MsoNormal align=right style='text-align: right'>
			<span
				style='font-size: 12.0pt; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>编号：${permit.slbh}</span><span
				lang=EN-US style='font-size: 12.0pt'><o:p></o:p></span>
		</p>

		<p class=MsoNormal align=left
			style='text-align: left; line-height: 150%'>
			<span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>（申请人姓名或者名称）：</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;${permit.sqr}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>经审查，你（单位）于</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;&nbsp; </span><span
					style='mso-spacerun: yes'>&nbsp;<fmt:formatDate
							value="${permit.createDate}" pattern="yyyy" />&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>年</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;&nbsp; </span><span
					style='mso-spacerun: yes'>&nbsp;<fmt:formatDate
							value="${permit.createDate}" pattern="MM" />&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>月</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp; </span><span
					style='mso-spacerun: yes'>&nbsp;<fmt:formatDate
							value="${permit.createDate}" pattern="dd" />&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>日提交</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;${permit.sqsx}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>施工许可证申请，经初步审核，以下几项材料（不齐全或不符合法定形式），请你（单位）在收到本通知后</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'>20</span><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>个工作日内补正如下材料，再行申请。</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><o:p></o:p></span>
		</p>
		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 12.0pt'><o:p><%= comment%></o:p></span>
		</p>

		<p class=MsoNormal style='line-height: 150%'>
			<span lang=EN-US style='font-size: 12.0pt; line-height: 150%'></span><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'><sys:toHtml>${bean.bzBackMaterial}</sys:toHtml></span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 12.0pt'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal align=right
			style='text-align: right; line-height: 150%'>
			<span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>上海市交通建设工程管理中心</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><o:p></o:p></span>
		</p>

		<p class=MsoNormal align=right
			style='text-align: right; line-height: 150%; word-break: break-all'>
			<span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>年</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp; </span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;</span><span
				style='mso-spacerun: yes'>&nbsp;</span></span><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>月</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp; </span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;</span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;</span></span><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>日</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><o:p></o:p></span>
		</p>

		<p class=MsoNormal style='line-height: 150%'>
			<span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>办理人签名：</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>联系电话：</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><o:p></o:p></span>
		</p>

		<p class=MsoNormal style='line-height: 150%'>
			<span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>申请人签名：</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>联系电话：</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 12.0pt'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 12.0pt'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal>
			<span
				style='font-size: 12.0pt; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>本文书一式两份，一份交申请单位（人），一份留受理部门。</span><span
				lang=EN-US style='font-size: 12.0pt'><o:p></o:p></span>
		</p>

	</div>
		<div align="center">
		<input type="button" class="noprint" value="打印预览" onclick="printPreivew()" id="printPreivew" style="display: none"/> 
		<input type="button" class="noprint" onclick="window.print()" value="打印" />
	</div>
</body>
</html>
<script>
	function printPreivew() {
		document.getElementById("WebBrowser1").execWB(7, 1);
	}
	$(document).ready(
			function() {
				var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
				var isIE11 = (/Trident\/7\./).test(navigator.userAgent);
				var isIE = userAgent.indexOf("compatible") > -1
						&& userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
				if (isIE||isIE11) {
					document.getElementById("printPreivew").style.display="";
				}
			})
</script>

