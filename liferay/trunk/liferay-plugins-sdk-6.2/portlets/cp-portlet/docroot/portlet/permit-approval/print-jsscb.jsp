<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style media=print type="text/css">
    .noprint{visibility:hidden}
</style>
<html>
<head>
<link rel=themeData href="建管中心模板.files/themedata.thmx">
<link rel=colorSchemeMapping href="建管中心模板.files/colorschememapping.xml">
<style>
    <!--
        /* Font Definitions */
    @font-face
    {font-family:宋体;
        panose-1:2 1 6 0 3 1 1 1 1 1;
        mso-font-alt:SimSun;
        mso-font-charset:134;
        mso-generic-font-family:auto;
        mso-font-pitch:variable;
        mso-font-signature:3 680460288 22 0 262145 0;}
    @font-face
    {font-family:黑体;
        panose-1:2 1 6 9 6 1 1 1 1 1;
        mso-font-alt:SimHei;
        mso-font-charset:134;
        mso-generic-font-family:modern;
        mso-font-pitch:fixed;
        mso-font-signature:-2147482945 953122042 22 0 262145 0;}
    @font-face
    {font-family:"Cambria Math";
        panose-1:2 4 5 3 5 4 6 3 2 4;
        mso-font-charset:1;
        mso-generic-font-family:roman;
        mso-font-format:other;
        mso-font-pitch:variable;
        mso-font-signature:0 0 0 0 0 0;}
    @font-face
    {font-family:Calibri;
        panose-1:2 15 5 2 2 2 4 3 2 4;
        mso-font-charset:0;
        mso-generic-font-family:swiss;
        mso-font-pitch:variable;
        mso-font-signature:-536870145 1073786111 1 0 415 0;}
    @font-face
    {font-family:"\@黑体";
        panose-1:2 1 6 9 6 1 1 1 1 1;
        mso-font-charset:134;
        mso-generic-font-family:modern;
        mso-font-pitch:fixed;
        mso-font-signature:-2147482945 953122042 22 0 262145 0;}
    @font-face
    {font-family:"\@宋体";
        panose-1:2 1 6 0 3 1 1 1 1 1;
        mso-font-charset:134;
        mso-generic-font-family:auto;
        mso-font-pitch:variable;
        mso-font-signature:3 680460288 22 0 262145 0;}
        /* Style Definitions */
    p.MsoNormal, li.MsoNormal, div.MsoNormal
    {mso-style-unhide:no;
        mso-style-qformat:yes;
        mso-style-parent:"";
        margin:0cm;
        margin-bottom:.0001pt;
        text-align:justify;
        text-justify:inter-ideograph;
        mso-pagination:none;
        font-size:10.5pt;
        mso-bidi-font-size:11.0pt;
        font-family:"Calibri","sans-serif";
        mso-fareast-font-family:宋体;
        mso-bidi-font-family:"Times New Roman";
        mso-font-kerning:1.0pt;}
    p.MsoHeader, li.MsoHeader, div.MsoHeader
    {mso-style-noshow:yes;
        mso-style-priority:99;
        mso-style-link:"页眉 Char";
        margin:0cm;
        margin-bottom:.0001pt;
        text-align:center;
        mso-pagination:none;
        tab-stops:center 207.65pt right 415.3pt;
        layout-grid-mode:char;
        border:none;
        mso-border-bottom-alt:solid windowtext .75pt;
        padding:0cm;
        mso-padding-alt:0cm 0cm 1.0pt 0cm;
        font-size:9.0pt;
        font-family:"Calibri","sans-serif";
        mso-ascii-font-family:Calibri;
        mso-ascii-theme-font:minor-latin;
        mso-fareast-font-family:宋体;
        mso-fareast-theme-font:minor-fareast;
        mso-hansi-font-family:Calibri;
        mso-hansi-theme-font:minor-latin;
        mso-bidi-font-family:"Times New Roman";
        mso-bidi-theme-font:minor-bidi;
        mso-font-kerning:1.0pt;}
    p.MsoFooter, li.MsoFooter, div.MsoFooter
    {mso-style-noshow:yes;
        mso-style-priority:99;
        mso-style-link:"页脚 Char";
        margin:0cm;
        margin-bottom:.0001pt;
        mso-pagination:none;
        tab-stops:center 207.65pt right 415.3pt;
        layout-grid-mode:char;
        font-size:9.0pt;
        font-family:"Calibri","sans-serif";
        mso-fareast-font-family:宋体;
        mso-bidi-font-family:"Times New Roman";
        mso-font-kerning:1.0pt;}
    p.MsoNoSpacing, li.MsoNoSpacing, div.MsoNoSpacing
    {mso-style-unhide:no;
        mso-style-qformat:yes;
        mso-style-parent:"";
        margin:0cm;
        margin-bottom:.0001pt;
        text-align:justify;
        text-justify:inter-ideograph;
        mso-pagination:none;
        font-size:10.5pt;
        mso-bidi-font-size:11.0pt;
        font-family:"Calibri","sans-serif";
        mso-fareast-font-family:宋体;
        mso-bidi-font-family:"Times New Roman";
        mso-font-kerning:1.0pt;}
    span.Char
    {mso-style-name:"页眉 Char";
        mso-style-noshow:yes;
        mso-style-priority:99;
        mso-style-unhide:no;
        mso-style-locked:yes;
        mso-style-link:页眉;
        mso-ansi-font-size:9.0pt;
        mso-bidi-font-size:9.0pt;}
    span.Char0
    {mso-style-name:"页脚 Char";
        mso-style-noshow:yes;
        mso-style-priority:99;
        mso-style-unhide:no;
        mso-style-locked:yes;
        mso-style-link:页脚;
        mso-ansi-font-size:9.0pt;
        mso-bidi-font-size:9.0pt;}
    .MsoChpDefault
    {mso-style-type:export-only;
        mso-default-props:yes;
        mso-bidi-font-family:"Times New Roman";
        mso-bidi-theme-font:minor-bidi;}
        /* Page Definitions */
    @page
    {mso-page-border-surround-header:no;
        mso-page-border-surround-footer:no;
        mso-footnote-separator:url("建管中心模板.files/header.htm") fs;
        mso-footnote-continuation-separator:url("建管中心模板.files/header.htm") fcs;
        mso-endnote-separator:url("建管中心模板.files/header.htm") es;
        mso-endnote-continuation-separator:url("建管中心模板.files/header.htm") ecs;}
    @page Section1
    {size:595.3pt 841.9pt;
        margin:72.0pt 90.0pt 72.0pt 90.0pt;
        mso-header-margin:42.55pt;
        mso-footer-margin:49.6pt;
        mso-paper-source:0;
        layout-grid:15.6pt;}
    div.Section1
    {page:Section1;}
    -->
</style>
</head>

<body lang=ZH-CN style='tab-interval:21.0pt;text-justify-trim:punctuation'>

<div class=Section1 style='layout-grid:15.6pt'>

<p class=MsoNormal align=left style='margin-top:0cm;margin-right:-21.0pt;
margin-bottom:0cm;margin-left:-21.0pt;margin-bottom:.0001pt;mso-para-margin-top:
0cm;mso-para-margin-right:-2.0gd;mso-para-margin-bottom:0cm;mso-para-margin-left:
-2.0gd;mso-para-margin-bottom:.0001pt;text-align:left;text-indent:144.0pt;
mso-char-indent-count:9.0;mso-line-height-alt:12.0pt'><span style='font-size:
16.0pt;font-family:黑体'>交通建管中心技术审查表<span lang=EN-US><o:p></o:p></span></span></p>

<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0
       style='border-collapse:collapse;border:none;mso-border-alt:solid black .5pt;
 mso-yfti-tbllook:1184;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:
 .5pt solid black;mso-border-insidev:.5pt solid black'>
<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
    <td width=149 valign=top style='width:111.8pt;border:solid black 1.0pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>项目名称</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=447 colspan=3 valign=top style='width:335.5pt;border:solid black 1.0pt;
  border-left:none;mso-border-left-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;${bean.projectName}</o:p></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:1'>
    <td width=149 valign=top style='width:111.8pt;border:solid black 1.0pt;
  border-top:none;mso-border-top-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>建设单位</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=447 colspan=3 valign=top style='width:335.5pt;border-top:none;
  border-left:none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;${bean.buildName}</o:p></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:2'>
    <td width=149 valign=top style='width:111.8pt;border:solid black 1.0pt;
  border-top:none;mso-border-top-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>审核类别</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=149 valign=top style='width:111.8pt;border-top:none;border-left:
  none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;${bean.projectType.name}</o:p></span></p>
    </td>
    <td width=149 valign=top style='width:111.85pt;border-top:none;border-left:
  none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>审核时效</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=149 valign=top style='width:111.85pt;border-top:none;border-left:
  none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;8&nbsp;天</o:p></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:3'>
    <td width=149 valign=top style='width:111.8pt;border:solid black 1.0pt;
  border-top:none;mso-border-top-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>受理人员</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=447 colspan=3 valign=top style='width:335.5pt;border-top:none;
  border-left:none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p><sys:toHtml>${bean.csOpinion}</sys:toHtml></o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>${bean.csUser}</o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>日期</span><span
                lang=EN-US style='font-size:12.0pt'><span
                style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span> <span
                style='font-size:12.0pt;font-family:宋体;mso-ascii-font-family:Calibri;
  mso-hansi-font-family:Calibri'><fmt:formatDate value="${bean.csDate}" pattern="yyyy年MM月dd日"/></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:4'>
    <td width=149 valign=top style='width:111.8pt;border:solid black 1.0pt;
  border-top:none;mso-border-top-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>复核人员</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=447 colspan=3 valign=top style='width:335.5pt;border-top:none;
  border-left:none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p><sys:toHtml>${bean.fhOpinion}</sys:toHtml></o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>${bean.fhUser}</o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>日期</span><span
                lang=EN-US style='font-size:12.0pt'><span
                style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span> <span
                style='font-size:12.0pt;font-family:宋体;mso-ascii-font-family:Calibri;
  mso-hansi-font-family:Calibri'><fmt:formatDate value="${bean.fhDate}" pattern="yyyy年MM月dd日"/></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:5'>
    <td width=149 valign=top style='width:111.8pt;border:solid black 1.0pt;
  border-top:none;mso-border-top-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>审核人员</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=447 colspan=3 valign=top style='width:335.5pt;border-top:none;
  border-left:none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p><sys:toHtml>${bean.shOpinion}</sys:toHtml></o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>${bean.shUser}</o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>日期</span><span
                lang=EN-US style='font-size:12.0pt'><span
                style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span> <span
                style='font-size:12.0pt;font-family:宋体;mso-ascii-font-family:Calibri;
  mso-hansi-font-family:Calibri'><fmt:formatDate value="${bean.shDate}" pattern="yyyy年MM月dd日"/></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:6'>
    <td width=149 valign=top style='width:111.8pt;border:solid black 1.0pt;
  border-top:none;mso-border-top-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>分管领导</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=447 colspan=3 valign=top style='width:335.5pt;border-top:none;
  border-left:none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p><sys:toHtml>${bean.fgldOpinion}</sys:toHtml></o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>${bean.fgldUser}</o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>日期</span><span
                lang=EN-US style='font-size:12.0pt'><span
                style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span> <span
                style='font-size:12.0pt;font-family:宋体;mso-ascii-font-family:Calibri;
  mso-hansi-font-family:Calibri'><fmt:formatDate value="${bean.fgldDate}" pattern="yyyy年MM月dd日"/></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:7;mso-yfti-lastrow:yes'>
    <td width=149 valign=top style='width:111.8pt;border:solid black 1.0pt;
  border-top:none;mso-border-top-alt:solid black .5pt;mso-border-alt:solid black .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>中心领导</span><span
                lang=EN-US style='font-size:12.0pt'><o:p></o:p></span></p>
    </td>
    <td width=447 colspan=3 valign=top style='width:335.5pt;border-top:none;
  border-left:none;border-bottom:solid black 1.0pt;border-right:solid black 1.0pt;
  mso-border-top-alt:solid black .5pt;mso-border-left-alt:solid black .5pt;
  mso-border-alt:solid black .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p><sys:toHtml>${bean.zxldOpinion}</sys:toHtml></o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>${bean.zxldUser}</o:p></span></p>
        <p class=MsoNoSpacing><span lang=EN-US style='font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>
        <p class=MsoNoSpacing><span style='font-size:12.0pt;font-family:宋体;
  mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>日期</span><span
                lang=EN-US style='font-size:12.0pt'><span
                style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span> <span
                style='font-size:12.0pt;font-family:宋体;mso-ascii-font-family:Calibri;
  mso-hansi-font-family:Calibri'><fmt:formatDate value="${bean.zxldDate}" pattern="yyyy年MM月dd日"/></span></p>
    </td>
</tr>
</table>

<p class=MsoNormal align=left style='margin-top:0cm;margin-right:-21.0pt;
margin-bottom:0cm;margin-left:-21.0pt;margin-bottom:.0001pt;mso-para-margin-top:
0cm;mso-para-margin-right:-2.0gd;mso-para-margin-bottom:0cm;mso-para-margin-left:
-2.0gd;mso-para-margin-bottom:.0001pt;text-align:left;text-indent:28.0pt;
mso-char-indent-count:2.0;mso-line-height-alt:12.0pt'><span style='font-size:
14.0pt;font-family:宋体;mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri'>注：本表一式三份，市交委留存一份，交管中心留存一份，归档材料中留存一份；</span><span
        lang=EN-US style='font-size:14.0pt'><o:p></o:p></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

</div>
	<div class="div_space"></div>
	<div align="center">
		<input type="button" class="noprint" onclick="window.print()" value="打印" />
		<input type="button" class="noprint" value="返回" onclick="history.go(-1)">
	</div>
</body>
</html>


