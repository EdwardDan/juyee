<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div" align="center">
    <div align="center" class="tr_dark">
        <div class="div_space"></div>
        <fieldset class="form_fieldset">
            <legend class="form_legend">项目立项</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" style="width:10%" nowrap="true">立项文件：</td>
                    <td class="form_content" style="width:20%">&nbsp;${bean.lxFile}</td>
                    <td class="form_label_right" style="width:10%" nowrap="true">立项级别：</td>
                    <td class="form_content" style="width:20%">&nbsp;${bean.lxLevel}</td>
                    <td class="form_label_right" style="width:10%" nowrap="true">批准机关：</td>
                    <td class="form_content" style="width:20%">&nbsp;${bean.approvalUnit}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap="true">立项文号：</td>
                    <td class="form_content">&nbsp;${bean.lxFileCode}</td>
                    <td class="form_label_right" nowrap="true">立项分类：</td>
                    <td class="form_content">&nbsp;${bean.lxClass}</td>
                    <td class="form_label_right" nowrap="true">批准时间：</td>
                    <td class="form_content">&nbsp;<fmt:formatDate value="${bean.approvalDate}" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap="true">总投资(万元)：</td>
                    <td class="form_content">&nbsp;<fmt:formatNumber value="${bean.totalInvestment}"
                                                                     pattern="#,###.####"/></td>
                    <td class="form_label_right" nowrap="true">设备投资(万元)：</td>
                    <td class="form_content" colspan="3">&nbsp;<fmt:formatNumber value="${bean.devInvestment}"
                                                                                 pattern="#,###.####"/></td>
                </tr>
            </table>
        </fieldset>
        <div class="div_space"></div>
        <fieldset class="form_fieldset">
            <legend class="form_legend">项目报建</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" style="width:10%" nowrap="true">报建编号：</td>
                    <td class="form_content" style="width:20%">&nbsp;${bean.bjbh}</td>
                    <td class="form_label_right" style="width:10%" nowrap="true">报建日期：</td>
                    <td class="form_content" style="width:20%">&nbsp;<fmt:formatDate value="${bean.bjDate}" pattern="yyyy-MM-dd"/></td>
                    <td class="form_label_right" style="width:10%" nowrap="true">项目分类：</td>
                    <td class="form_content" style="width:20%">&nbsp;${bean.projectType}</td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap="true">建筑面积㎡：</td>
                    <td class="form_content">&nbsp;<fmt:formatNumber value="${bean.totalArea}"
                                                                     pattern="#,###.####"/></td>
                    <td class="form_label_right" nowrap="true">建设规模：</td>
                    <td class="form_content" colspan="3">&nbsp;${bean.buildScale}</td>
                </tr>
            </table>
        </fieldset>
        <div class="div_space"></div>
        <fieldset class="form_fieldset">
            <legend class="form_legend">施工许可</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_header">
                    <td class="form_border" width="5%">序号</td>
                    <td class="form_border" width="30%">施工单位</td>
                    <td class="form_border" width="15%">许可证号</td>
                    <td class="form_border" width="15%">发证机关</td>
                    <td class="form_border" width="15%">发证日期</td>
                </tr>
                <c:forEach items="${list}" var="item" varStatus="status">
                    <tr class="tr_light">
                        <td class="form_border">&nbsp;${status.index+1}</td>
                        <td class="form_border">&nbsp;${item.sgZbUnit}</td>
                        <td class="form_border">&nbsp;${item.id.bjbh}${item.id.bdh}</td>
                        <td class="form_border">&nbsp;</td>
                        <td class="form_border">&nbsp;<fmt:formatDate value="${item.issueDatetime}" pattern="yyyy-MM-dd"/></td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
        <div class="div_space"></div>

        <div class="tr_button">
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </div>
    </div>
</div>