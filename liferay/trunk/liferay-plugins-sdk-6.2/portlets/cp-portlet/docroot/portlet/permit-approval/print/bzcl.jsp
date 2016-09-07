<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style media=print type="text/css">
.noprint {
	visibility: hidden
}
</style>
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
				style='font-size: 12.0pt; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>编号：</span><span
				lang=EN-US style='font-size: 12.0pt'><o:p></o:p></span>
		</p>

		<p class=MsoNormal align=left
			style='text-align: left; line-height: 150%'>
			<span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>（申请人姓名或者名称）：</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;${bean.applyPerson}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>经审查，你（单位）于</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;&nbsp; </span><span
					style='mso-spacerun: yes'>&nbsp;<fmt:formatDate
							value="${bean.submitDate}" pattern="yyyy" />&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>年</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;&nbsp; </span><span
					style='mso-spacerun: yes'>&nbsp;<fmt:formatDate
							value="${bean.submitDate}" pattern="MM" />&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>月</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp; </span><span
					style='mso-spacerun: yes'>&nbsp;<fmt:formatDate
							value="${bean.submitDate}" pattern="dd" />&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>日提交</span><u><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;${bean.applyMatter}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span></span></u><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>施工许可证申请，经初步审核，以下几项材料（不齐全或不符合法定形式），请你（单位）在收到本通知后</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'>20</span><span
				style='font-size: 12.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: "Times New Roman"; mso-hansi-font-family: "Times New Roman"'>个工作日内补正如下材料，再行申请。</span><span
				lang=EN-US style='font-size: 12.0pt; line-height: 150%'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 12.0pt'><o:p>&nbsp;</o:p></span>
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
	<div class="div_space"></div>
	<div align="center">
		<input type="button" class="noprint" onclick="window.print()" value="打印" />
		<input type="button" class="noprint" value="返回" onclick="history.go(-1)">
	</div>

</body>
</html>


