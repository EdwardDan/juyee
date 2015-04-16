<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .td_line_font{
        font-size: 13px;
        /*font-weight: bold;*/
        text-align: left;
        height: 45px;
    }
</style>
<script type="text/javascript">
    function viewCompanyDetail(code){
        var bjbh = "${bjbh}";
        var link = "";
        if(code == "wxysb"){
            link = "${ctx}/platDangersource/grid.do?bjbh="+bjbh;
        }else if(code == "terysb"){
            link = "${ctx}/platSpecialWorker/grid.do?bjbh="+bjbh;
        }else if(code == "aqsczc"){
            link = "${ctx}/platSgFile/grid.do?code=aqsczc&bjbh="+bjbh;
        }else if(code == "sgaqys"){
            link = "${ctx}/platSgFile/grid.do?code=sgaqys&bjbh="+bjbh;
        }
        if(link != ""){
            openNewWindow("viewCompany","企业上报情况",link,false,1000,500);
        }
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td width="30%">&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr class="tr_light">
            <td>&nbsp;</td>
            <td class="td_line_font"><a href="javascript:void(0)" onclick="viewCompanyDetail('wxysb')" class="page_link">* 危险源上报</a></td>
        </tr>
        <tr class="tr_light">
            <td>&nbsp;</td>
            <td class="td_line_font"><a href="javascript:void(0)" onclick="viewCompanyDetail('terysb')" class="page_link">* 特种作业人员上报</a></td>
        </tr>
        <tr class="tr_light">
            <td>&nbsp;</td>
            <td class="td_line_font"><a href="javascript:void(0)" onclick="viewCompanyDetail('aqsczc')" class="page_link">* 企业安全生产自查情况</a></td>
        </tr>
        <tr class="tr_light">
            <td>&nbsp;</td>
            <td class="td_line_font"><a href="javascript:void(0)" onclick="viewCompanyDetail('sgaqys')" class="page_link">* 施工安全因素指标填报</a></td>
        </tr>
        <tr class="tr_light">
            <td>&nbsp;</td>
            <td class="td_line_font">&nbsp;</td>
        </tr>
        <tr class="tr_button">
            <td class="form_td_line" align="center" colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>