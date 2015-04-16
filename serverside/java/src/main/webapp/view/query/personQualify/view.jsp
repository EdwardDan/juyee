<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_title">
            <td colspan="6" align="left">
                &nbsp;企业信息
            </td>
        </tr>
        <tr class="tr_light">
            <td width="10%" class="form_td_line" nowrap align="right">单位名称：</td>
            <td width="25%" class="form_content">&nbsp;${unit.unitName}</td>
            <td width="10%" class="form_td_line" nowrap align="right">机构代码证：</td>
            <td width="20%" class="form_content">&nbsp;${unit.orgCode}</td>
            <td width="10%" class="form_td_line" nowrap align="right">经济类型：</td>
            <td width="25%" class="form_content">&nbsp;${unit.unitEcoName}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_td_line" nowrap align="right">注册所在地：</td>
            <td class="form_content">&nbsp;${unit.regCityName}</td>
            <td class="form_td_line" nowrap align="right">隶属省市：</td>
            <td class="form_content">&nbsp;${unit.belogProvince}</td>
            <td class="form_td_line" nowrap align="right">注册地址：</td>
            <td class="form_content">&nbsp;${unit.regAddress}</td>
        </tr>
        <tr>
            <td colspan="6" class="form_td_line" height="0">&nbsp;</td>
        </tr>
    </table>
    <div class="div_space"></div>

    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_title">
            <td colspan="6" align="left">
                &nbsp;证书信息
            </td>
        </tr>
        <tr class="tr_light">
            <td width="10%" class="form_td_line" nowrap align="right">姓名：</td>
            <td width="25%" class="form_content">&nbsp;${bean.personName}</td>
            <td width="10%" class="form_td_line" nowrap align="right">性别：</td>
            <td width="20%" class="form_content">&nbsp;${bean.personSex}</td>
            <td width="10%" class="form_td_line" nowrap align="right">身份证：</td>
            <td width="25%" class="form_content">&nbsp;${bean.cardNo}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_td_line" nowrap align="right">证书名称：</td>
            <td class="form_content">&nbsp;${bean.qualifyTypeDesc}</td>
            <td class="form_td_line" nowrap align="right">证书编号：</td>
            <td class="form_content">&nbsp;${bean.regQualifyCode}</td>
            <td class="form_td_line" nowrap align="right">有效期：</td>
            <td class="form_content">&nbsp;${bean.validDate}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_td_line" nowrap align="right">证书等级：</td>
            <td class="form_content">&nbsp;${bean.qualifyLevelDesc}</td>
            <td class="form_td_line" nowrap align="right">证书状态：</td>
            <td class="form_content">&nbsp;${bean.qualifyStatusDesc}</td>
            <td class="form_td_line" nowrap align="right">&nbsp;</td>
            <td class="form_content">&nbsp;</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_td_line" nowrap align="right">监理专业：</td>
            <td class="form_content">&nbsp;${bean.jlSpecialityTypeDesc1}</td>
            <td class="form_td_line" nowrap align="right">建筑专业：</td>
            <td class="form_content">&nbsp;${bean.jzSpecialityTypeDesc}</td>
            <td class="form_td_line" nowrap align="right">&nbsp;</td>
            <td class="form_content">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="6" class="form_td_line" height="0"></td>
        </tr>
    </table>

    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_button">
            <td class="form_td_line" align="center">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>