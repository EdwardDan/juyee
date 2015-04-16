<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>

<form:form commandName="bean">
<form:hidden path="id"/>
<div class="form_div" align="center">
    <div class="tr_header" style="font-size: 25px"><b>建设工程竣工验收综合执法核查表</b></div>

    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light" align="center">
            <td width="20%" colspan="2" class="form_border">工程名称：</td>
            <td width="30%" class="form_content">${bean.projectName}&nbsp;</td>
            <td width="20%" class="form_border">施工单位：</td>
            <td width="30%" class="form_content">${content.sgdwmc}&nbsp;</td>
        </tr>
        <tr class="tr_dark" align="center">
            <td colspan="2" class="form_border">建设单位：</td>
            <td class="form_content">${bean.buildUnit}&nbsp;</td>
            <td class="form_border">监理单位：</td>
            <td class="form_content">${content.jldwmc}&nbsp;</td>
        </tr>
        <tr class="tr_light" align="center">
            <td colspan="2" class="form_border">勘察单位：</td>
            <td class="form_content">${content.kcdwmc}&nbsp;</td>
            <td class="form_border">设计单位：</td>
            <td class="form_content">${content.sjdwmc}&nbsp;</td>
        </tr>
        <tr class="tr_dark" align="center">
            <td colspan="2" class="form_border">检测单位：</td>
            <td class="form_content">${content.jcdwmc}&nbsp;</td>
            <td class="form_border">审图单位：</td>
            <td class="form_content">${content.stdwmc}&nbsp;</td>
        </tr>
        <tr class="tr_light">
            <td width="10%" class="form_border">1</td>
            <td colspan="4" class="form_border">
                <table border="0" width="100%">
                    <tr class="tr_light">
                        <td colspan="2" width="40%">　　　　　本工程发生质量事故及结案情况</td>
                        <td width="27%">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="3"> 　　　　　(　　)同意竣工验收　　　(　　)暂不同意竣工验收</td>
                        <td>核查人：</td>
                    </tr>
                    <tr class="tr_light">
                        <td colspan="3">&nbsp;</td>
                        <td>　　　　　　年　　　　月　　　　日</td>
                    </tr>

                </table>
            </td>
        </tr>
        <tr class="tr_light" align="center">
            <td width="10%" class="form_border">2</td>
            <td colspan="4" class="form_border">
                <table border="0" width="100%">
                    <tr class="tr_light">
                        <td colspan="2" width="40%">　　　　　本工程发生质量事故及结案情况</td>
                        <td width="27%">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="3"> 　　　　　(　　)同意竣工验收　　　(　　)暂不同意竣工验收</td>
                        <td>核查人：</td>
                    </tr>
                    <tr class="tr_light">
                        <td colspan="3">&nbsp;</td>
                        <td>　　　　　　年　　　　月　　　　日</td>
                    </tr>

                </table>
            </td>
        </tr>
        <tr class="tr_light" align="center">
            <td width="10%" class="form_border">3</td>
            <td colspan="4" class="form_border">
                <table border="0" width="100%">
                    <tr class="tr_light">
                        <td colspan="2" width="40%">　　　　　本工程发生质量事故及结案情况</td>
                        <td width="27%">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="3"> 　　　　　(　　)同意竣工验收　　　(　　)暂不同意竣工验收</td>
                        <td>核查人：</td>
                    </tr>
                    <tr class="tr_light">
                        <td colspan="3">&nbsp;</td>
                        <td>　　　　　　年　　　　月　　　　日</td>
                    </tr>

                </table>
            </td>
        </tr>
        <tr class="tr_light" align="center">
            <td width="10%" class="form_border">4</td>
            <td colspan="4" class="form_border">
                <table border="0" width="100%">
                    <tr class="tr_light">
                        <td colspan="2" width="40%">　　　　　本工程发生质量事故及结案情况</td>
                        <td width="27%">&nbsp;</td>
                        <td></td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="3"> 　　　　　(　　)同意竣工验收　　　(　　)暂不同意竣工验收</td>
                        <td>核查人：</td>
                    </tr>
                    <tr class="tr_light">
                        <td colspan="3">&nbsp;</td>
                        <td>　　　　　　年　　　　月　　　　日</td>
                    </tr>

                </table>
            </td>
        </tr>
        <tr class="tr_light" align="center">
            <td width="10%" class="form_border">5</td>
            <td colspan="4" class="form_border">
                <table border="0" width="100%">
                    <tr class="tr_light">
                        <td colspan="2" width="40%">　　　　　本工程发生质量事故及结案情况</td>
                        <td width="27%">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="3"> 　　　　　(　　)同意竣工验收　　　(　　)暂不同意竣工验收</td>
                        <td>核查人：</td>
                    </tr>
                    <tr class="tr_light">
                        <td colspan="3">&nbsp;</td>
                        <td>　　　　　　年　　　　月　　　　日</td>
                    </tr>

                </table>
            </td>
        </tr>
        <tr class="tr_light" align="center">
            <td width="10%" class="form_border">6</td>
            <td colspan="4" class="form_border">
                <table border="0" width="100%">
                    <tr class="tr_light">
                        <td colspan="2" width="40%">　　　　　本工程发生质量事故及结案情况</td>
                        <td width="27%">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="3"> 　　　　　(　　)同意竣工验收　　　(　　)暂不同意竣工验收</td>
                        <td>核查人：</td>
                    </tr>
                    <tr class="tr_light">
                        <td colspan="3">&nbsp;</td>
                        <td>　　　　　　年　　　　月　　　　日</td>
                    </tr>

                </table>
            </td>
        </tr>
        <tr class="tr_light" align="center">
            <td width="10%" class="form_border">7</td>
            <td colspan="4" class="form_border">
                <table border="0" width="100%">
                    <tr class="tr_light">
                        <td colspan="2" width="40%">　　　　　本工程发生质量事故及结案情况</td>
                        <td width="27%">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="3"> 　　　　　(　　)同意竣工验收　　　(　　)暂不同意竣工验收</td>
                        <td>核查人：</td>
                    </tr>
                    <tr class="tr_light">
                        <td colspan="3">&nbsp;</td>
                        <td>　　　　　　年　　　　月　　　　日</td>
                    </tr>

                </table>
            </td>
        </tr>
        <tr class="tr_light" align="center">
            <td width="10%" class="form_border">8</td>
            <td colspan="4" class="form_border">
                <table border="0" width="100%">
                    <tr class="tr_light">
                        <td colspan="2" width="40%">　　　　　本工程发生质量事故及结案情况</td>
                        <td width="27%">&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr class="tr_dark">
                        <td colspan="3"> 　　　　　(　　)同意竣工验收　　　(　　)暂不同意竣工验收</td>
                        <td>核查人：</td>
                    </tr>
                    <tr class="tr_light">
                        <td colspan="3">&nbsp;</td>
                        <td>　　　　　　年　　　　月　　　　日</td>
                    </tr>

                </table>
            </td>
        </tr>
    </table>
</div>
<div class="form_div" align="center">
    <table cellpadding="0" cellspacing="0" class="form_table" align="left">
        <tr class="tr_dark">
            <td colspan="3" class="form_border">&nbsp;</td>
        </tr>
        <tr class="tr_dark">
            <td align="left" width="50%">　　　　上海市松江区建设工程安全质量监督站</td>
            <td align="right"> 签发人：______________站长</td>
            <td width="7%">&nbsp;</td>
        </tr>
        <tr class="tr_light">
            <td colspan="2" align="right">年　　　　月　　　　日</td>
            <td>&nbsp;</td>
        </tr>
        <tr class="tr_button">
            <td colspan="3">
                <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
            </td>
        </tr>
    </table>
</div>

</form:form>