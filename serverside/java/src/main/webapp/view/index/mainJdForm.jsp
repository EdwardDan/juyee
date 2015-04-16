<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    //按月跳转
    function changeDailyMonth(act) {
        loadAjaxData("mainJdFormDivId", "${ctx}/mainPage/mainJdForm.do?curdate=${curdate}&query=" + act);
    }
</script>

<table width="240" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center" height="50" style="background-image: url('${themePath}/index_new/rili_top.png');background-repeat: no-repeat;">
            <table border="0" width="240" cellpadding="0" cellspacing="0" style="padding-top: 15px">
                <tr>
                    <td width="20">
                        <img src="${themePath}/index_new/rili_arrow_left.png" border="0" style="cursor: pointer" onclick="changeDailyMonth('prev')" title="上一月"/>
                    </td>
                    <td width="200" align="center" style="color: white;font-weight: bold;">${title}</td>
                    <td width="20">
                        <img src="${themePath}/index_new/rili_arrow_right.png" border="0" style="cursor: pointer" onclick="changeDailyMonth('next')" title="下一月"/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" height="180" style="background-image: url('${themePath}/index_new/rili_m_bg.png');background-repeat: repeat-y;">
            <!--begin-->
            <table cellpadding="0" cellspacing="0" width="220" border="0" style="padding-left: 20px">
                <tr valign="middle">
                    <td align="center"><b>每月工作统计</b></td>
                </tr>
                <tr valign="middle">
                    <td class="ggltext" align="left"><img src="${themePath}/index/dit.png" border="0" align="absmiddle"/>&nbsp;&nbsp;
                        <a href="javascript:void(0)" onclick="loadMainPage('${ctx}/jdStopOrder/init.do?code=quality&curDate=${curDate}','开具整改单');" title="点击查看"> 开具整改单<b>${reformNum}</b> 张</a>
                    </td>
                </tr>
                <tr valign="middle">
                    <td class="ggltext" align="left"><img src="${themePath}/index/dit.png" border="0" align="absmiddle"/>&nbsp;&nbsp;
                         <a href="javascript:void(0)" onclick="loadMainPage('${ctx}/jdStopOrder/init.do?code=quality','开具局部暂缓指令单');" title="点击查看">开具局部暂缓指令单<b>${suspendNum}</b> 张</a>
                    </td>
                </tr>
                <tr valign="middle">
                     <td class="ggltext" align="left"><img src="${themePath}/index/dit.png" border="0" align="absmiddle"/>&nbsp;&nbsp;
                        <a href="javascript:void(0)" onclick="loadMainPage('${ctx}/jdStopOrder/init.do?code=quality','开具停工指令单');" title="点击查看">开具停工指令单<b>${stopNum}</b> 张</a>
                     </td>
                </tr>
                <tr valign="middle">
                    <td class="ggltext" align="left"><img src="${themePath}/index/dit.png" border="0" align="absmiddle"/>&nbsp;&nbsp;
                        <a href="javascript:void(0)" onclick="loadMainPage('${ctx}/shareBidInfo/grid.do?curDate=${curdate}','发放中标通知书');" title="点击查看"> 发放中标通知书 <b>${cfbNum}</b> 张</a>
                    </td>
                </tr>
                <tr valign="middle">
                    <td class="ggltext" align="left"><img src="${themePath}/index/dit.png" border="0" align="absmiddle"/>&nbsp;&nbsp;
                        <a href="javascript:void(0)" onclick="loadMainPage('${ctx}/shareSgPermit/grid.do?curDate=${curdate}','发放施工许可');" title="点击查看"> 发放施工许可 <b>${sgpermitNum}</b> 张</a>
                     </td>
                </tr>
                <tr valign="middle">
                    <td class="ggltext" align="left"><img src="${themePath}/index/dit.png" border="0" align="absmiddle"/>&nbsp;&nbsp;
                        <a href="javascript:void(0)" onclick="loadMainPage('${ctx}/shareUnitQualify/grid.do?curDate=${curdate}','企业资质审批');" title="点击查看"> 企业资质审批 <b>${unitqualifyNum}</b> 张</a>
                    </td>
                </tr>
            </table>
            <!--end-->
        </td>
    </tr>
    <tr>
        <td align="center" height="10" style="background-image: url('${themePath}/index_new/rili_bottom.png');background-repeat: no-repeat;"></td>
    </tr>
</table>