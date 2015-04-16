<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function viewDept(deptName){
        openNewWindow("viewDept","资质详情","${ctx}/unitQualify/view.do?id=0&deptName="+encodeURI(deptName), false,900, 525);
    }
    function viewPerson(cardNo){
        if(cardNo==""){
            alert("无法查询此人员资质！");
            return;
        }
        openNewWindow("viewPerson","资质详情","${ctx}/personQualify/view.do?id=0&cardNo="+encodeURI(cardNo), false,800, 500);
    }
</script>
<div class="form_div" align="center">
    <div align="center" class="tr_dark">
        <div class="div_space"></div>
        <fieldset class="form_fieldset">
            <legend class="form_legend">勘察</legend>
            <c:if test="${fn:length(kcList)==0}">暂无数据</c:if>
            <c:forEach items="${kcList}" var="item">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_over">
                        <td class="form_label_right" nowrap="true">承包单位：</td>
                        <td class="form_content">&nbsp;<a href="javascript:void(0)" onclick="viewDept('${item.CB_UNIT}')"><font color="blue">${item.CB_UNIT}</font></a></td>
                        <td class="form_label_right" nowrap="true">立项级别：</td>
                        <td class="form_content" colspan="3">&nbsp;${item.ZB_TYPE}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right" nowrap="true">中标价格（万元）：</td>
                        <td class="form_content">&nbsp;<fmt:formatNumber value="${item.KC_FEE}"
                                                                         pattern="#,###.####"/></td>
                        <td class="form_label_right" nowrap="true">中标日期：</td>
                        <td class="form_content" colspan="3">&nbsp;<fmt:formatDate value="${item.BID_DATE}"
                                                                                   pattern="yyyy-MM-dd"/></td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" nowrap="true">合同签订日期：</td>
                        <td class="form_content">&nbsp;</td>
                        <td class="form_label_right" nowrap="true">合同有效期：</td>
                        <td class="form_content" colspan="3">&nbsp;</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" width="10%" nowrap="true">项目负责人：</td>
                        <td class="form_content" width="30%">&nbsp;<a href="javascript:void(0)" onclick="viewPerson('${item.PRO_HEADER_CARD}')">${item.PRO_HEADER}</a></td>
                        <td class="form_label_right" width="10%" nowrap="true">身份证号：</td>
                        <td class="form_content" width="20%">&nbsp;${item.PRO_HEADER_CARD}</td>
                        <td class="form_label_right" width="10%" nowrap="true">手机号码：</td>
                        <td class="form_content" width="15%">&nbsp;${item.PRO_HEADER_PHONE}</td>
                    </tr>
                    <tr>
                        <td colspan="6" class="form_border"></td>
                    </tr>
                </table>
            </c:forEach>
        </fieldset>
        <div class="div_space"></div>

        <fieldset class="form_fieldset">
            <legend class="form_legend">设计</legend>
            <c:if test="${fn:length(sjList)==0}">暂无数据</c:if>
            <c:forEach items="${sjList}" var="item">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_over">
                        <td class="form_label_right" nowrap="true">承包单位：</td>
                        <td class="form_content">&nbsp;<a href="javascript:void(0)" onclick="viewDept('${item.CB_UNIT}')">${item.CB_UNIT}</a></td>
                        <td class="form_label_right" nowrap="true">立项级别：</td>
                        <td class="form_content" colspan="3">&nbsp;${item.ZB_TYPE}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right" nowrap="true">中标价格（万元）：</td>
                        <td class="form_content">&nbsp;<fmt:formatNumber value="${item.SJ_FEE}"
                                                                         pattern="#,###.####"/></td>
                        <td class="form_label_right" nowrap="true">中标日期：</td>
                        <td class="form_content" colspan="3">&nbsp;<fmt:formatDate value="${item.BID_DATE}"
                                                                                   pattern="yyyy-MM-dd"/></td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" nowrap="true">合同签订日期：</td>
                        <td class="form_content">&nbsp;</td>
                        <td class="form_label_right" nowrap="true">合同有效期：</td>
                        <td class="form_content" colspan="3">&nbsp;</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" width="10%" nowrap="true">项目负责人：</td>
                        <td class="form_content" width="30%">&nbsp;<a href="javascript:void(0)" onclick="viewPerson('${item.PRO_HEADER_CARD}')">${item.PRO_HEADER}</a></td>
                        <td class="form_label_right" width="10%" nowrap="true">身份证号：</td>
                        <td class="form_content" width="20%">&nbsp;${item.PRO_HEADER_CARD}</td>
                        <td class="form_label_right" width="10%" nowrap="true">手机号码：</td>
                        <td class="form_content" width="15%">&nbsp;${item.PRO_HEADER_PHONE}</td>
                    </tr>
                    <tr>
                        <td colspan="6" class="form_border"></td>
                    </tr>
                </table>
            </c:forEach>
        </fieldset>
        <div class="div_space"></div>

        <fieldset class="form_fieldset">
            <legend class="form_legend">施工监理</legend>
            <c:if test="${fn:length(jlList)==0}">暂无数据</c:if>
            <c:forEach items="${jlList}" var="item">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_over">
                        <td class="form_label_right" nowrap="true">承包单位：</td>
                        <td class="form_content">&nbsp;<a href="javascript:void(0)" onclick="viewDept('${item.CB_UNIT}')">${item.CB_UNIT}</a></td>
                        <td class="form_label_right" nowrap="true">立项级别：</td>
                        <td class="form_content" colspan="3">&nbsp;${item.ZB_TYPE}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right" nowrap="true">中标价格（万元）：</td>
                        <td class="form_content">&nbsp;<fmt:formatNumber value="${item.JL_FEE}"
                                                                         pattern="#,###.####"/></td>
                        <td class="form_label_right" nowrap="true">中标日期：</td>
                        <td class="form_content" colspan="3">&nbsp;<fmt:formatDate value="${item.BID_DATE}"
                                                                                   pattern="yyyy-MM-dd"/></td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" nowrap="true">合同签订日期：</td>
                        <td class="form_content">&nbsp;</td>
                        <td class="form_label_right" nowrap="true">合同有效期：</td>
                        <td class="form_content" colspan="3">&nbsp;</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" width="10%" nowrap="true">项目负责人：</td>
                        <td class="form_content" width="30%">&nbsp;<a href="javascript:void(0)" onclick="viewPerson('${item.PRO_HEADER_CARD}')">${item.PRO_HEADER}</a></td>
                        <td class="form_label_right" width="10%" nowrap="true">身份证号：</td>
                        <td class="form_content" width="20%">&nbsp;${item.PRO_HEADER_CARD}</td>
                        <td class="form_label_right" width="10%" nowrap="true">手机号码：</td>
                        <td class="form_content" width="15%">&nbsp;${item.PRO_HEADER_PHONE}</td>
                    </tr>
                    <tr>
                        <td colspan="6" class="form_border"></td>
                    </tr>
                </table>
            </c:forEach>
        </fieldset>
        <div class="div_space"></div>

        <fieldset class="form_fieldset">
            <legend class="form_legend">施工</legend>
            <c:if test="${fn:length(sgList)==0}">暂无数据</c:if>
            <c:forEach items="${sgList}" var="item">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_over">
                        <td class="form_label_right" nowrap="true">承包单位：</td>
                        <td class="form_content">&nbsp;<a href="javascript:void(0)" onclick="viewDept('${item.CB_UNIT}')">${item.CB_UNIT}</a></td>
                        <td class="form_label_right" nowrap="true">立项级别：</td>
                        <td class="form_content" colspan="3">&nbsp;${item.ZB_TYPE}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right" nowrap="true">中标价格（万元）：</td>
                        <td class="form_content">&nbsp;<fmt:formatNumber value="${item.SG_FEE}"
                                                                         pattern="#,###.####"/></td>
                        <td class="form_label_right" nowrap="true">中标日期：</td>
                        <td class="form_content" colspan="3">&nbsp;<fmt:formatDate value="${item.BID_DATE}"
                                                                                   pattern="yyyy-MM-dd"/></td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" nowrap="true">合同签订日期：</td>
                        <td class="form_content">&nbsp;</td>
                        <td class="form_label_right" nowrap="true">合同有效期：</td>
                        <td class="form_content" colspan="3">&nbsp;</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right" nowrap="true">开工日期：</td>
                        <td class="form_content">&nbsp;</td>
                        <td class="form_label_right" nowrap="true">竣工日期：</td>
                        <td class="form_content" colspan="3">&nbsp;</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" width="10%" nowrap="true">项目负责人：</td>
                        <td class="form_content" width="30%">&nbsp;<a href="javascript:void(0)" onclick="viewPerson('${item.PRO_HEADER_CARD}')">${item.PRO_HEADER}</a></td>
                        <td class="form_label_right" width="10%" nowrap="true">身份证号：</td>
                        <td class="form_content" width="20%">&nbsp;${item.PRO_HEADER_CARD}</td>
                        <td class="form_label_right" width="10%" nowrap="true">手机号码：</td>
                        <td class="form_content" width="15%">&nbsp;${item.PRO_HEADER_PHONE}</td>
                    </tr>
                    <tr>
                        <td colspan="6" class="form_border"></td>
                    </tr>
                </table>
            </c:forEach>
        </fieldset>
        <div class="div_space"></div>

        <div class="tr_button">
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </div>
    </div>
</div>