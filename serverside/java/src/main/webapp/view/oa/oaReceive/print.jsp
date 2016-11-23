<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style media=print type="text/css">
    .noprint{visibility:hidden}
</style>
<html>
<head>
    <meta http-equiv=Content-Type content="text/html; charset=gb2312">
    <meta name=Generator content="Microsoft Word 15 (filtered)">
    <style>
        <!--
        /* Font Definitions */
        @font-face
        {font-family:宋体;
            panose-1:2 1 6 0 3 1 1 1 1 1;}
        @font-face
        {font-family:"Cambria Math";
            panose-1:2 4 5 3 5 4 6 3 2 4;}
        @font-face
        {font-family:Calibri;
            panose-1:2 15 5 2 2 2 4 3 2 4;}
        @font-face
        {font-family:华文中宋;
            panose-1:2 1 6 0 4 1 1 1 1 1;}
        @font-face
        {font-family:仿宋_GB2312;}
        @font-face
        {font-family:"\@宋体";
            panose-1:2 1 6 0 3 1 1 1 1 1;}
        @font-face
        {font-family:"\@华文中宋";
            panose-1:2 1 6 0 4 1 1 1 1 1;}
        @font-face
        {font-family:"\@仿宋_GB2312";}
        /* Style Definitions */
        p.MsoNormal, li.MsoNormal, div.MsoNormal
        {margin:0cm;
            margin-bottom:.0001pt;
            text-align:justify;
            text-justify:inter-ideograph;
            font-size:10.5pt;
            font-family:"Calibri",sans-serif;}
        p.MsoHeader, li.MsoHeader, div.MsoHeader
        {mso-style-link:"页眉 Char";
            margin:0cm;
            margin-bottom:.0001pt;
            text-align:center;
            layout-grid-mode:char;
            border:none;
            padding:0cm;
            font-size:9.0pt;
            font-family:"Calibri",sans-serif;}
        p.MsoFooter, li.MsoFooter, div.MsoFooter
        {mso-style-link:"页脚 Char";
            margin:0cm;
            margin-bottom:.0001pt;
            layout-grid-mode:char;
            font-size:9.0pt;
            font-family:"Calibri",sans-serif;}
        span.Char
        {mso-style-name:"页眉 Char";
            mso-style-link:页眉;}
        span.Char0
        {mso-style-name:"页脚 Char";
            mso-style-link:页脚;}
        .MsoChpDefault
        {font-family:"Calibri",sans-serif;}
        /* Page Definitions */
        @page WordSection1
        {size:595.3pt 841.9pt;
            margin:72.0pt 90.0pt 72.0pt 90.0pt;
            layout-grid:15.6pt;}
        div.WordSection1
        {page:WordSection1;}
        -->
    </style>

</head>

<body lang=ZH-CN style='text-justify-trim:punctuation;left: 500px'>

<div class=WordSection1 style='layout-grid:15.6pt'>

    <p class=MsoNormal align=center style='margin-bottom:7.8pt;text-align:center'><span
            style='font-size:18.0pt;font-family:华文中宋'>上海市交通建设工程管理中心文件处理单</span></p>

    <p class=MsoNormal style='margin-right:11.3pt;word-break:break-all'><span
            style='font-size:14.0pt;font-family:仿宋_GB2312'>收文编号<span lang=EN-US>:</span>${bean.code}<span lang=EN-US>&nbsp;&nbsp;
&nbsp;</span>收文日期：${receiveTime}<span lang=EN-US>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></p>

    <table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 width=568
           style='width:426.1pt;border-collapse:collapse;border:none'>
        <tr style='height:46.35pt'>
            <td width=95 colspan=2 style='width:71.0pt;border:solid windowtext 1.0pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:46.35pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>来文单位</span></p>
            </td>
            <td width=249 colspan=2 style='width:186.4pt;border:solid windowtext 1.0pt;
  border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:46.35pt'>
                <p class=MsoNormal><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>${bean.sourceDept}</span></p>
            </td>
            <td width=120 colspan=2 style='width:90.0pt;border:solid windowtext 1.0pt;
  border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:46.35pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>文件日期</span></p>
            </td>
            <td width=105 colspan=2 style='width:78.7pt;border:solid windowtext 1.0pt;
  border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:46.35pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>${bean.year}</span></p>
            </td>
        </tr>
        <tr style='height:45.5pt'>
            <td width=95 colspan=2 style='width:71.0pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:45.5pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>文件字号</span></p>
            </td>
            <td width=249 colspan=2 style='width:186.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:45.5pt'>
                <p class=MsoNormal><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>${bean.fileCode}</span></p>
            </td>
            <td width=60 style='width:45.0pt;border-top:none;border-left:none;border-bottom:
  solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;
  height:45.5pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>密级</span></p>
            </td>
            <td width=60 style='width:45.0pt;border-top:none;border-left:none;border-bottom:
  solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;
  height:45.5pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>${bean.secret.name}</span></p>
            </td>
            <td width=60 style='width:45.0pt;border-top:none;border-left:none;border-bottom:
  solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;
  height:45.5pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>份数</span></p>
            </td>
            <td width=45 style='width:33.7pt;border-top:none;border-left:none;border-bottom:
  solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;
  height:45.5pt'>
                <p class=MsoNormal align=center style='text-align:center'><span lang=EN-US
                                                                                style='font-size:12.0pt;font-family:仿宋_GB2312'>${bean.fs}</span></p>
            </td>
        </tr>
        <tr style='height:52.75pt'>
            <td width=95 colspan=2 style='width:71.0pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:52.75pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>文件标题</span></p>
            </td>
            <td width=473 colspan=6 style='width:355.1pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:52.75pt'>
                <p class=MsoNormal><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>${bean.title}</span></p>
            </td>
        </tr>
        <tr>
            <td width=568 colspan=8 valign=top style='width:426.1pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0cm 5.4pt 0cm 5.4pt'>
                <p class=MsoNormal><span style='font-size:14.0pt;font-family:仿宋_GB2312'>拟办意见：</span></p>
                <p class=MsoNormal style='text-indent:27.75pt'><span lang=EN-US
                                                                     style='font-size:12.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
                <p class=MsoNormal style='text-indent:27.75pt'><span lang=EN-US
                                                                     style='font-size:12.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
                <p class=MsoNormal style='text-indent:27.75pt'><span lang=EN-US
                                                                     style='font-size:12.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
                <p class=MsoNormal><span lang=EN-US style='font-size:14.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
            </td>
        </tr>
        <tr>
            <td width=568 colspan=8 valign=top style='width:426.1pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0cm 5.4pt 0cm 5.4pt'>
                <p class=MsoNormal><span style='font-size:14.0pt;font-family:仿宋_GB2312'>领导阅批：</span></p>
                <p class=MsoNormal><span lang=EN-US style='font-size:14.0pt;font-family:仿宋_GB2312'>&nbsp;&nbsp;
  </span></p>
                <p class=MsoNormal><span lang=EN-US style='font-size:14.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
                <p class=MsoNormal><span lang=EN-US style='font-size:14.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
            </td>
        </tr>
        <tr>
            <td width=568 colspan=8 valign=top style='width:426.1pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0cm 5.4pt 0cm 5.4pt'>
                <p class=MsoNormal><span style='font-size:14.0pt;font-family:仿宋_GB2312'>处理结果：</span></p>
                <p class=MsoNormal><span lang=EN-US style='font-size:14.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
                <p class=MsoNormal><span lang=EN-US style='font-size:14.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
                <p class=MsoNormal><span lang=EN-US style='font-size:14.0pt;font-family:仿宋_GB2312'>&nbsp;</span></p>
            </td>
        </tr>
        <tr>
            <td width=83 valign=top style='width:62.1pt;border:solid windowtext 1.0pt;
  border-top:none;padding:15px 5.4pt 15px 5.4pt'>
                <p class=MsoNormal align=center style='text-align:center'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>备注</span></p>
            </td>
            <td width=151 colspan=2 style='width:4.0cm;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:15px 5.4pt 0 5.4pt;>
                <p class=MsoNormal align=left style='text-align:center'><span
                style='font-size:14.0pt;font-family:仿宋_GB2312'>督办:&nbsp;是□</span></p>
            </td>
            <td width=334 colspan=5 style='width:250.6pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
                <p class=MsoNormal align=left style='text-align:left;text-indent:12.0pt'><span
                        style='font-size:14.0pt;font-family:仿宋_GB2312'>时间：</span></p>
            </td>
        </tr>
        <tr height=0>
            <td width=83 style='border:none'></td>
            <td width=12 style='border:none'></td>
            <td width=139 style='border:none'></td>
            <td width=109 style='border:none'></td>
            <td width=60 style='border:none'></td>
            <td width=60 style='border:none'></td>
            <td width=60 style='border:none'></td>
            <td width=45 style='border:none'></td>
        </tr>
    </table>

    <p class=MsoNormal><span lang=EN-US>&nbsp;</span></p>

</div>
<div style="text-align: center">
    <input class="noprint" type="button" value="打印" onclick="window.print()" >
</div>
</body>

</html>
