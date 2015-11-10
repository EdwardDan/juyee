<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"year", rule:"validate[required,custom[integer],maxSize[4]"},            
            //{name:"bjbh", rule:"validate[required,maxSize[50]]"},            
            //{name:"projectName", rule:"validate[required,maxSize[200]]"},            
            //{name:"buildName", rule:"validate[required,maxSize[200]]"},            
            //{name:"hYear", rule:"validate[required,custom[integer],maxSize[4]"},            
            //{name:"hNum", rule:"validate[required,custom[integer],maxSize[4]"},            
            //{name:"applyPerson", rule:"validate[required,maxSize[50]]"},            
            //{name:"applyMatter", rule:"validate[required,maxSize[200]]"},            
            //{name:"applyNum", rule:"validate[required,maxSize[50]]"},            
            //{name:"materialPerson", rule:"validate[required,maxSize[200]]"},            
            //{name:"materialPersonPhone", rule:"validate[required,maxSize[50]]"},            
            //{name:"materialPersonAddress", rule:"validate[required,maxSize[200]]"},            
            //{name:"receivePerson", rule:"validate[required,maxSize[200]]"},            
            //{name:"receivePersonPhone", rule:"validate[required,maxSize[50]]"},            
            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},            
            //{name:"csOpinion", rule:"validate[required,maxSize[1000]]"},            
            //{name:"fhOpinion", rule:"validate[required,maxSize[1000]]"},            
            //{name:"shOpinion", rule:"validate[required,maxSize[1000]]"},            
            //{name:"fgldOpinion", rule:"validate[required,maxSize[1000]]"},            
            //{name:"zxldOpinion", rule:"validate[required,maxSize[1000]]"},                    
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/sgPermit/saveAudit.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="status"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 20%;" nowrap>报建编号：</td>
                <td class="form_content" style="width: 80%;">${bean.bjbh}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">项目名称：</td>
                <td class="form_content">${bean.projectName}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content">${bean.buildName}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_content" colspan="2">
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                    沪交管收字（${bean.hjgYear}）第&nbsp;${bean.hjgNum}&nbsp;号
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请人：</td>
                <td class="form_content">${bean.applyPerson}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">申请事项：</td>
                <td class="form_content">${bean.applyMatter}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请号：</td>
                <td class="form_content">${bean.applyNum}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                        <tr class="tr_header">
                            <td style="width: 5%;">序号</td>
                            <td style="width: 50%;">申请材料名称</td>
                            <td style="width: 20%;">材料齐全情况</td>
                            <td style="width: 8%;">份数</td>
                            <td style="width: 15%;">附件</td>
                        </tr>
                        <c:forEach items="${list}" var="map">
                            <c:set value="upLoad${map.no}" var="upLoadNo"/>
                            <tr class="tr_dark">
                                <td>${map.no}</td>
                                <td style="text-align: left;">${map.materialName}</td>
                                <td>
                                    有<input type="radio" name="isFull${map.no}" value="1"
                                            <c:if test="${map.isFull=='true'}">checked="checked"</c:if> disabled="true">
                                    无<input type="radio" name="isFull${map.no}" value="0"
                                            <c:if test="${map.isFull=='false'}">checked="checked"</c:if> disabled="true">
                                </td>
                                <td>${map.num}</td>
                                <td>${map[upLoadNo]}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">材料提交人：</td>
                <td class="form_content">${bean.materialPerson}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">材料提交人联系电话：</td>
                <td class="form_content">${bean.materialPersonPhone}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">材料提交人联系地址：</td>
                <td class="form_content">${bean.materialPersonAddress}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">收件人：</td>
                <td class="form_content">${bean.receivePerson}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">收件人联系电话：</td>
                <td class="form_content">${bean.receivePersonPhone}</td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">

                </td>
            </tr>
            <c:if test="${(bean.status==STATUS_SUBMIT)&&canCsAudit}">
                <tr class="tr_dark">
                    <td class="form_label_right">初审意见：</td>
                    <td class="form_content">
                        <form:textarea path="csOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${(bean.status==STATUS_CS_PASS)&&canFhAudit}">
            <tr class="tr_light">
                <td class="form_label_right">复核意见：</td>
                <td class="form_content">
                    <form:textarea path="fhOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                </td>
            </tr>
            </c:if>
            <tr class="tr_dark">
                <td class="form_label_right">审核意见：</td>
                <td class="form_content">
                    <form:textarea path="shOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">分管领导审核意见：</td>
                <td class="form_content">
                    <form:textarea path="fgldOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">中心领导审核意见：</td>
                <td class="form_content">
                    <form:textarea path="zxldOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="2" style="text-align: center;">
                    <input type="button" value="审核通过" class="button_normal_long" onclick="save(this)">&nbsp;
                    <input type="button" value="审核退回" class="button_normal_long" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>