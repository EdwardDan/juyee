<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style media=print type="text/css">
.noprint {
	visibility: hidden
}
</style>
<html >
<head>
<title>上海市${title}项目申请材料收件凭证</title>
<style>
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
	mso-footnote-separator: url("1.files/header.htm") fs;
	mso-footnote-continuation-separator: url("1.files/header.htm") fcs;
	mso-endnote-separator: url("1.files/header.htm") es;
	mso-endnote-continuation-separator: url("1.files/header.htm") ecs;
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
</style>
</head>

<body lang=ZH-CN
	style='tab-interval: 21.0pt; text-justify-trim: punctuation'>

	<div class=Section1>

		<p class=MsoNormal align=center style='text-align: center'>
			<b><span
				style='font-size: 16.0pt; font-family: 宋体; mso-bidi-font-family: 宋体'>上海市${title}项目申请材料收件凭证<span
					lang=EN-US><o:p></o:p></span></span></b>
		</p>

		<p class=MsoNormal align=center style='text-align: center'>
			<b><span lang=EN-US
				style='font-size: 14.0pt; font-family: 宋体; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'><o:p>&nbsp;</o:p></span></b>
		</p>

		<p class=MsoNormal align=center style='text-align: center'>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>沪交管收字（</span><span
				lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;${bean.hjgYear} </span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>）第（</span><span
				lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;${bean.hjgNum} </span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>）号</span><span
				lang=EN-US style='font-size: 14.0pt; mso-bidi-font-family: 宋体'><o:p></o:p></span>
		</p>
		<p class=MsoNormal align=center style='text-align: center'>
			<span lang=EN-US
				style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal style='line-height: 150%'>
			<span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>申请人：</span><u><span
				lang=EN-US style='font-size: 14.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;${bean.applyPerson}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span></span></u><span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>申请号</span><span
				style='font-size: 14.0pt; line-height: 150%'> <span
				lang=EN-US>:<u><span style='mso-spacerun: yes'>&nbsp;${bean.applyNum}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</span></u></span></span><span lang=EN-US
				style='font-size: 14.0pt; line-height: 150%; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
		</p>

		<p class=MsoNormal style='line-height: 150%'>
			<span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>申请事项：</span><u><span
				lang=EN-US style='font-size: 14.0pt; line-height: 150%'><span
					style='mso-spacerun: yes'>&nbsp;${bean.applyMatter}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</span><span style='mso-spacerun: yes'>&nbsp;</span><span
					style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span></u><span
				lang=EN-US
				style='font-size: 14.0pt; line-height: 150%; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
		</p>

		<p class=MsoNormal style='line-height: 150%'>
			<span
				style='font-size: 14.0pt; line-height: 150%; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>今收到以下材料：</span><span
				lang=EN-US
				style='font-size: 14.0pt; line-height: 150%; mso-bidi-font-family: 宋体'><o:p></o:p></span>
		</p>

		<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0
			width=650
			style='width: 550pt; border-collapse: collapse; border: none; mso-border-alt: solid windowtext .5pt; mso-yfti-tbllook: 160; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt; mso-border-insideh: .5pt solid windowtext; mso-border-insidev: .5pt solid windowtext'>
			<tr style='mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
				<td width=40
					style='width: 33.75pt; border: solid windowtext 1.0pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=NoSpacing align=center style='text-align: center'>
						<span
							style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>序号</span><span
							lang=EN-US
							style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
					</p>
				</td>
				<td width=450
					style='width: 350pt; border: solid windowtext 1.0pt; border-left: none; mso-border-left-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=NoSpacing align=center style='text-align: center'>
						<span
							style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>申请材料名称</span><span
							lang=EN-US
							style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
					</p>
				</td>
				<td width=40
					style='width: 40.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-left-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=NoSpacing align=center style='text-align: center'>
						<span
							style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>应交<br>份数
						</span><span lang=EN-US
							style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
					</p>
				</td>
				<td width=40
					style='width: 40.0pt; border: solid windowtext 1.0pt; border-left: none; mso-border-left-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=NoSpacing align=center style='text-align: center'>
						<span
							style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>实交<br>份数
						</span><span lang=EN-US
							style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
					</p>
				</td>
				<td width=50
					style='width: 50pt; border: solid windowtext 1.0pt; border-left: none; mso-border-left-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=NoSpacing align=center style='text-align: center'>
						<span
							style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>备</span><span
							lang=EN-US style='font-size: 14.0pt'><span
							style='mso-spacerun: yes'>&nbsp;&nbsp; </span></span><span
							style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>注</span><span
							lang=EN-US
							style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p></o:p></span>
					</p>
				</td>
			</tr>
			<c:forEach items="${applyList}" var="item" varStatus="status">
				<tr style='mso-yfti-irow:${status.index+1}'>
					<td width=45 valign=top
						style='width: 33.75pt; border: solid windowtext 1.0pt; border-top: none; mso-border-top-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
						<p class=NoSpacing align=center style='text-align: center'>
							<span lang=EN-US style='font-size: 14.0pt'>${item.no}<o:p></o:p></span>
						</p>
					</td>
					<td width=442 valign=top
						style='width: 331.65pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-top-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
						<p class=NoSpacing>
							<span
								style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-bidi-font-family: 宋体'>${item.materialName}</span>
							<span lang=EN-US style='font-size: 14.0pt'><o:p></o:p></span>
						</p>
					</td>
					<td width=60 valign=top
						style='width: 45.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-top-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
						<p class=NoSpacing align=center style='text-align: center'>
							<span lang=EN-US style='font-size: 14.0pt'>${item.yjNum}<o:p></o:p></span>
						</p>
					</td>
					<td width=60 valign=top
						style='width: 45.0pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-top-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
						<p class=NoSpacing align=center style='text-align: center'>
							<span lang=EN-US style='font-size: 14.0pt'>${item.sjNum}<o:p></o:p></span>
						</p>
					</td>
					<td width=33 valign=top
						style='width: 24.9pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; mso-border-top-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-alt: solid windowtext .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
						<p class=NoSpacing>
							<span lang=EN-US
								style='font-size: 14.0pt; mso-bidi-font-family: "Times New Roman"'><o:p>&nbsp;</o:p></span>
						</p>
					</td>
				</tr>
			</c:forEach>

		</table>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 14.0pt'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal>
			<b style='mso-bidi-font-weight: normal'><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>注：收到本凭证后，可于十五个工作日后向收件机关征询申请材料审查结果。</span></b><b
				style='mso-bidi-font-weight: normal'><span lang=EN-US
				style='font-size: 14.0pt'><o:p></o:p></span></b>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 14.0pt'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>材料联系人：${bean.materialPerson}</span><span
				lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>收件人：${bean.receivePerson}</span><span
				lang=EN-US style='font-size: 14.0pt'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>联系电话：${bean.materialPersonPhone}</span><span
				lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span><span style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>联系电话：${bean.receivePersonPhone}</span><span
				lang=EN-US style='font-size: 14.0pt'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>联系地址：${bean.materialPersonAddress}</span><span
				lang=EN-US style='font-size: 14.0pt'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 14.0pt'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal align=right style='text-align: right'>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>收件机关（专用印章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
				lang=EN-US style='font-size: 14.0pt'><o:p></o:p></span>
		</p>

		<p class=MsoNormal align=right
			style='text-align: right; word-break: break-all'>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>年</span><span
				lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>月</span><span
				lang=EN-US style='font-size: 14.0pt'><span
				style='mso-spacerun: yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span></span><span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
				lang=EN-US style='font-size: 14.0pt'><o:p></o:p></span>
		</p>

		<p class=MsoNormal>
			<span lang=EN-US style='font-size: 14.0pt'><o:p>&nbsp;</o:p></span>
		</p>

		<p class=MsoNormal>
			<span
				style='font-size: 14.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>（本凭证一式两份，一份交申请人，一份留存。）</span><span
				lang=EN-US style='font-size: 14.0pt'><o:p></o:p></span>
		</p>
	</div>
	<div class="div_space"></div>
<br>
	<div align="center">
		<input type="button" class="noprint" onclick="window.print()" value="打印" />
		<input type="button" class="noprint" value="返回" onclick="history.go(-1)">
	</div>
</body>
</html>

