<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function printExcelFR() {
        printFR("WorkerTalkForm", "id=${bean.id}");
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right">工程名称：</td>
            <td class="form_content">&nbsp;
                ${bean.projectName}                    </td>
            <td class="form_label_right">号：</td>
            <td class="form_content">&nbsp;
                ${bean.formCode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">谈话单位1：</td>
            <td class="form_content">&nbsp;
                ${bean.unitName1}                    </td>
            <td class="form_label_right">谈话单位2：</td>
            <td class="form_content">&nbsp;
                ${bean.unitName2}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">谈话事由：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.content}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">谈话时间：</td>
            <td class="form_content" colspan="3">&nbsp;
                <fmt:formatDate value="${bean.talkTime}" pattern="yyyy年MM月dd日 HH时"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">签发时间：</td>
            <td class="form_content" colspan="3">&nbsp;
                <fmt:formatDate value="${bean.signDate}" pattern="yyyy-MM-dd"/>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">签发人：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.signPerson}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">内部谈话人：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.talkPerson}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">携带材料：</td>
            <td class="form_content" colspan="3"style="padding-left: 45px">&nbsp;
                <sys:checkbox name="materialIds" colNum="2" code="${WORKER_TALK_FORM_LISTS}" showType="view"
                              checkedNames="${bean.materialIds}" isSaveName="true"
                              inputType="checkbox"></sys:checkbox>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" colspan="4" style="text-align: center">
                <input type="button" class="button_all" value="打印" onclick="printExcelFR();"/>
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>