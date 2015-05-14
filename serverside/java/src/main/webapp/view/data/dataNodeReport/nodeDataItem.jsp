<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .td_normal{
        height: 20px;
        background-color: white;
    }
</style>
<script type="text/javascript">
    changeFlag ==false;
    $(document).ready(function(){
        //文本框值改变即触发
        $("input[type='text']").change(function(){
            changeFlag=true;   //全局变量控制页面跳转时提示未保存的数据
            this.title=this.value;//改变内容时，动态修改title
        });
        //文本域改变即触发
        $("textarea").change(function(){
            changeFlag=true;
            this.title=this.value;
        });
    });
</script>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" width="99%">
    <tr class="tr_header">
        <td nowrap colspan="3" width="12%">形象进度</td>
        <c:forEach items="${steps}" var="step">
            <td nowrap colspan="2"width="17%" >${step.name}&nbsp;</td>
        </c:forEach>
    </tr>
    <c:forEach items="${firstNodes}" var="firstNode">
   <c:if test="${firstNode.totalLevel==2}">
       <c:forEach items="${firstNode.projNodes}" var="secondNode"  varStatus="status">
            <tr class="td_normal" align="center">
                <c:if test="${status.index ==0}">
                    <td rowspan="${firstNode.totalChildCount}" <c:if test="${firstNode.totalLevel<3}">colspan="${firstNode.totalLevel}" </c:if> nowrap>${firstNode.name}</td>
                </c:if>
                <td <c:if test="${secondNode.totalChildCount>0}"> rowspan="${secondNode.totalChildCount}"</c:if> nowrap>${secondNode.name}&nbsp;</td>
              <c:forEach items="${steps}" var="step">
                  <c:set var="dataKey" value="${secondNode.id}_${step.id}" />
                <c:if test="${status.index%2==0}">
                    <td width="8%"><input type="text" name="${secondNode.id}_${step.id}" id="${secondNode.id}_${step.id}" value="${dataMap[dataKey].content}"  title="${dataMap[dataKey].content}" class="input_number"></td>
                    <td rowspan="2" width="8%"> <textarea  class="input_textarea" style="width:80px;height:46px" name="${firstNode.id}_${step.id}_problem" id="${firstNode.id}_${step.id}_problem" title="${dataMap[dataKey].problem}">${dataMap[dataKey].problem}</textarea></td>
                </c:if>
                <c:if test="${status.index%2==1}">
                    <td><input type="text" name="${secondNode.id}_${step.id}" id="${secondNode.id}_${step.id}" value="${dataMap[dataKey].content}" title="${dataMap[dataKey].content}" class="input_number"></td>
                </c:if>
       </c:forEach>
            </tr>
       </c:forEach>
   </c:if>
        <c:if test="${firstNode.totalLevel==3}">
            <c:forEach items="${firstNode.projNodes}" var="secondNode" varStatus="secondStatus">
            <c:forEach items="${secondNode.projNodes}" var="thirdNode"  varStatus="thirdStatus">
                <tr class="td_normal"  align="center">
                    <c:if test="${secondStatus.index ==0&&thirdStatus.index ==0}">
                        <td rowspan="${firstNode.totalChildCount}" <c:if test="${firstNode.totalLevel<3}">colspan="${firstNode.totalLevel}" </c:if> nowrap>${firstNode.name}</td>
                    </c:if>
                    <c:if test="${thirdStatus.index ==0}">
                        <td <c:if test="${secondNode.totalChildCount>0}"> rowspan="${secondNode.totalChildCount}"</c:if> nowrap>${secondNode.name}&nbsp;</td>
                    </c:if>
                    <td  nowrap>${thirdNode.name}&nbsp;</td>
                    <c:forEach items="${steps}" var="step">
                        <c:set var="dataKey" value="${thirdNode.id}_${step.id}"/>
                        <c:if test="${thirdStatus.index==0&&secondStatus.index ==0}">
                            <td width="8%"><input type="text"  name="${thirdNode.id}_${step.id}" id="${thirdNode.id}_${step.id}" value="${dataMap[dataKey].content}" title="${dataMap[dataKey].content}" class="input_number"></td>
                            <td rowspan="${firstNode.totalChildCount}" width="8%"> <textarea  class="input_textarea" style="width:80px;height:140px" name="${firstNode.id}_${step.id}_problem" id="${firstNode.id}_${step.id}_problem" title="${dataMap[dataKey].problem}">${dataMap[dataKey].problem}</textarea></td>
                        </c:if>
                        <c:if test="${thirdStatus.index!=0||secondStatus.index !=0}">
                            <td width="8%"><input type="text" name="${thirdNode.id}_${step.id}" id="${thirdNode.id}_${step.id}" value="${dataMap[dataKey].content}" title="${dataMap[dataKey].content}" class="input_number"></td>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
        </c:forEach>
        </c:if>
    </c:forEach>
</table>