<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printExcelFR() {
        printFR("workerComplain", "id=${bean.id}");
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" nowrap>报建编号：</td>
                <td class="form_content" nowrap colspan="3">
                  ${bean.bjbh}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>来访日期：</td>
                <td class="form_content">
                        ${bean.visitDate}
                </td>
                <td class="form_label_right" nowrap>编号：</td>
                <td class="form_content">
                        ${bean.code}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>来访者姓名：</td>
                <td class="form_content">
                        ${bean.personName}
                </td>
                <td class="form_label_right" nowrap>来访人数：</td>
                <td class="form_content">
                        ${bean.personCount}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>来访者住址：</td>
                <td class="form_content">
                        ${bean.personAddress}
                </td>
                <td class="form_label_right" nowrap>身份证号码：</td>
                <td class="form_content">
                        ${bean.personIdcard}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>来访者联系电话：</td>
                <td class="form_content">
                        ${bean.personTel}
                </td>
                <td class="form_label_right" nowrap>欠款人：</td>
                <td class="form_content">
                        ${bean.debtPerson}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>项目名称：</td>
                <td class="form_content">
                        ${bean.projectName}
                </td>
                <td class="form_label_right" nowrap>项目地点：</td>
                <td class="form_content">   ${bean.projectAddress}
                </td>

            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>建设单位名称：</td>
                <td class="form_content">    ${bean.jsDept}
                </td>
                <td class="form_border" nowrap>建设单位负责人： ${bean.jsDeptLxr}
                </td>
                <td class="form_content">
                    建设单位联系电话： ${bean.jsDeptTel}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>总包单位名称：</td>
                <td class="form_content">   ${bean.zbDept}
                </td>
                <td class="form_border" nowrap>总包单位负责人： ${bean.zbDeptLxr}
                </td>
                <td class="form_content">
                    总包单位联系电话：  ${bean.zbDeptTel}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>项目经理：
                </td>
                <td class="form_content">     ${bean.manager}

                </td>
                <td class="form_label_right" nowrap>项目经理电话：
                </td>
                <td class="form_content">   ${bean.managerTel}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>分包单位名称：</td>
                <td class="form_content">    ${bean.fbDept}

                </td>
                <td class="form_border" nowrap>分包单位负责人： ${bean.fbDeptLxr}
                </td>
                <td class="form_content">
                    分包单位联系电话： ${bean.fbDeptTel}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>涉及工资款：</td>
                <td class="form_content">   ${bean.debtMoney}

                </td>
                <td class="form_label_right" nowrap>涉及民工人数：</td>
                <td class="form_content">   ${bean.debtPersons}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>款项类型：</td>
                <td class="form_content" colspan="3">  ${bean.moneyType}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>拖欠凭证：</td>
                <td class="form_content" colspan="3">   ${bean.debtCert}
            </tr>
            </td>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>投诉内容：</td>
                <td class="form_content" colspan="3" >   ${bean.content}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" nowrap>处理情况：</td>
                <td class="form_content" colspan="3">    ${bean.dealOpinion}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>处理日期：</td>
                <td class="form_content">      ${bean.dealDate}
                </td>
                <td class="form_label_right" nowrap>经办人：</td>
                <td class="form_content">   ${bean.dealJbr}
                </td>
            </tr>

            <tr class="tr_button">
                <td align="center" colspan="4">
                    <input type="button" class="button_all" value="打印" onclick="printExcelFR();"/>
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>