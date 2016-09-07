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
<title>受理通知书</title>
<style>
<!-- /* Font Definitions */
@font-face {
	font-family: 宋体;
	panose-1: 2 1 6 0 3 1 1 1 1 1;
	mso-font-alt: SimSun;
	mso-font-charset: 134;
	mso-generic-font-family: auto;
	mso-font-pitch: variable;
	mso-font-signature: 3 680460288 22 0 262145 0;
}

@font-face {
	font-family: Calibri;
	panose-1: 2 15 5 2 2 2 4 3 2 4;
	mso-font-charset: 0;
	mso-generic-font-family: swiss;
	mso-font-pitch: variable;
	mso-font-signature: -536870145 1073786111 1 0 415 0;
}

@font-face {
	font-family: "\@宋体";
	panose-1: 2 1 6 0 3 1 1 1 1 1;
	mso-font-charset: 134;
	mso-generic-font-family: auto;
	mso-font-pitch: variable;
	mso-font-signature: 3 680460288 22 0 262145 0;
}
/* Style Definitions */
p.MsoNormal, li.MsoNormal, div.MsoNormal {
	mso-style-parent: "";
	margin: 0cm;
	margin-bottom: .0001pt;
	text-align: justify;
	text-justify: inter-ideograph;
	mso-pagination: none;
	font-size: 10.5pt;
	font-family: Calibri;
	mso-fareast-font-family: 宋体;
	mso-bidi-font-family: Calibri;
	mso-font-kerning: 1.0pt;
}

p.MsoHeader, li.MsoHeader, div.MsoHeader {
	mso-style-link: " Char Char1";
	margin: 0cm;
	margin-bottom: .0001pt;
	text-align: center;
	mso-pagination: none;
	tab-stops: center 207.65pt right 415.3pt;
	layout-grid-mode: char;
	border: none;
	mso-border-bottom-alt: solid windowtext .75pt;
	padding: 0cm;
	mso-padding-alt: 0cm 0cm 1.0pt 0cm;
	font-size: 9.0pt;
	font-family: Calibri;
	mso-fareast-font-family: 宋体;
	mso-bidi-font-family: Calibri;
	mso-font-kerning: 1.0pt;
}

p.MsoFooter, li.MsoFooter, div.MsoFooter {
	mso-style-link: " Char Char";
	margin: 0cm;
	margin-bottom: .0001pt;
	mso-pagination: none;
	tab-stops: center 207.65pt right 415.3pt;
	layout-grid-mode: char;
	font-size: 9.0pt;
	font-family: Calibri;
	mso-fareast-font-family: 宋体;
	mso-bidi-font-family: Calibri;
	mso-font-kerning: 1.0pt;
}

span.CharChar1 {
	mso-style-name: " Char Char1";
	mso-style-locked: yes;
	mso-style-link: 页眉;
	mso-ansi-font-size: 9.0pt;
	mso-bidi-font-size: 9.0pt;
}

span.CharChar {
	mso-style-name: " Char Char";
	mso-style-locked: yes;
	mso-style-link: 页脚;
	mso-ansi-font-size: 9.0pt;
	mso-bidi-font-size: 9.0pt;
}

p.NoSpacing, li.NoSpacing, div.NoSpacing {
	mso-style-name: "No Spacing";
	mso-style-parent: "";
	margin: 0cm;
	margin-bottom: .0001pt;
	text-align: justify;
	text-justify: inter-ideograph;
	mso-pagination: none;
	font-size: 10.5pt;
	font-family: Calibri;
	mso-fareast-font-family: 宋体;
	mso-bidi-font-family: Calibri;
	mso-font-kerning: 1.0pt;
}
/* Page Definitions */
@page {
	mso-page-border-surround-header: no;
	mso-page-border-surround-footer: no;
	mso-footnote-separator: url("4.files/header.htm") fs;
	mso-footnote-continuation-separator: url("4.files/header.htm") fcs;
	mso-endnote-separator: url("4.files/header.htm") es;
	mso-endnote-continuation-separator: url("4.files/header.htm") ecs;
}

@page Section1 {
	size: 21.0cm 842.0pt;
	mso-page-orientation: landscape;
	margin: 79.4pt 68.05pt 79.4pt 68.05pt;
	mso-header-margin: 42.55pt;
	mso-footer-margin: 49.6pt;
	mso-paper-source: 0;
}

div.Section1 {
	page: Section1;
}
-->
</style>
<!--[if gte mso 10]>
  <style>
    /* Style Definitions */
    table.MsoNormalTable
    {mso-style-name:普通表格;
      mso-tstyle-rowband-size:0;
      mso-tstyle-colband-size:0;
      mso-style-noshow:yes;
      mso-style-parent:"";
      mso-padding-alt:0cm 5.4pt 0cm 5.4pt;
      mso-para-margin:0cm;
      mso-para-margin-bottom:.0001pt;
      mso-pagination:widow-orphan;
      font-size:10.0pt;
      font-family:Calibri;
      mso-ansi-language:#0400;
      mso-fareast-language:#0400;
      mso-bidi-language:#0400;}
  </style>
  <![endif]-->
<!--[if gte mso 9]><xml>
  <o:shapedefaults v:ext="edit" spidmax="2050"/>
</xml><![endif]-->
<!--[if gte mso 9]><xml>
  <o:shapelayout v:ext="edit">
    <o:idmap v:ext="edit" data="1"/>
  </o:shapelayout></xml><![endif]-->
</head>

<body lang=ZH-CN
	style='tab-interval: 21.0pt; text-justify-trim: punctuation'>

	<div class=Section1>

		<p class=MsoNormal align=center style='text-align: center'>
			<b><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>受理通知书</span></b><span
				lang=EN-US style='font-size: 14.0pt'><o:p></o:p></span>
		</p>

		<p class=MsoNormal align=right style='text-align: right'>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>编号：</span><span
				lang=EN-US
				style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US
				style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal style='line-height: 150%'>
			<span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>（申请人名称）：</span><u><span
				lang=EN-US style='font-size: 14.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;${bean.applyPerson}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<o:p></o:p></span></u>
		</p>

		<p class=MsoNormal style='text-indent: 27.0pt; line-height: 150%'>
			<span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>经审查，你（单位）于</span><u><span
				lang=EN-US style='font-size: 14.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;&nbsp; </span><span
					style='mso-spacerun: yes'>&nbsp;<fmt:formatDate
							value="${bean.submitDate}" pattern="yyyy" />&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;</span></span></u><span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>年</span><u><span
				style='font-size: 14.0pt; line-height: 150%'> <span
					lang=EN-US><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;</span><span
						style='mso-spacerun: yes'>&nbsp;<fmt:formatDate
								value="${bean.submitDate}" pattern="MM" />&nbsp;&nbsp;&nbsp;
					</span></span></span></u><span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>月</span><u><span
				lang=EN-US style='font-size: 14.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp; </span><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;<fmt:formatDate
							value="${bean.submitDate}" pattern="dd" />&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>日通过书面方式提出</span><u><span
				lang=EN-US style='font-size: 14.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;${bean.applyMatter}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span></u><span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>申请，经审查，你（单位）的申请材料符合规定，本机关予以受理。</span><span
				lang=EN-US
				style='font-size: 14.0pt; line-height: 150%; mso-bidi-font-family: 宋体'><o:p></o:p></span>
		</p>

		<p class=MsoNormal style='line-height: 150%'>
			<span lang=EN-US
				style='font-size: 14.0pt; line-height: 150%; mso-bidi-font-family: 宋体'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal style='line-height: 150%'>
			<span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>本机关对你（单位）的申请，将在</span><span
				lang=EN-US
				style='font-size: 14.0pt; line-height: 150%; mso-bidi-font-family: 宋体'>15</span><span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>个工作日内作出书面答复。</span><span
				lang=EN-US
				style='font-size: 14.0pt; line-height: 150%; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US
				style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal align=right style='text-align: right'>
			<span lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>上海市交通建设工程管理中心</span><span
				lang=EN-US
				style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
		</p>

		<p class=MsoNormal align=right style='text-align: right'>
			<span lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>年</span><span
				style='font-size: 14.0pt'> <span lang=EN-US><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;</span></span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>月</span><span
				lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp; </span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;</span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>日</span><span
				lang=EN-US
				style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp; </span>
			<o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>申请人签名：</span><span
				lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>联系电话：</span><span
				lang=EN-US
				style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span>
			<o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>本文书一式三份，一份交申请人，两份留受理部门。</span><span
				lang=EN-US
				style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
		</p>

	</div>
	<div class="div_space"></div>
	<div align="center">
		<input type="button" class="noprint" onclick="window.print()" value="打印" />
		<input type="button" class="noprint" value="返回" onclick="history.go(-1)">
	</div>

</body>
</html>
