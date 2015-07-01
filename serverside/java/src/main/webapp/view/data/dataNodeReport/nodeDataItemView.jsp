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
        <td nowrap colspan="3" width="50%">形象进度</td>
        <td nowrap colspan="2"width="50%" align="center">推进情况&nbsp;</td>
    </tr>
    <c:forEach items="${firstNodes}" var="firstNode">
        <c:if test="${firstNode.totalLevel==2}">
            <c:forEach items="${firstNode.projNodes}" var="secondNode"  varStatus="status">
                <tr class="td_normal" align="center">
                    <c:if test="${status.index ==0}">
                        <td rowspan="${firstNode.totalChildCount}" <c:if test="${firstNode.totalLevel<3}">colspan="${firstNode.totalLevel}" </c:if> nowrap>${firstNode.name}</td>
                    </c:if>
                    <td <c:if test="${secondNode.totalChildCount>0}"> rowspan="${secondNode.totalChildCount}"</c:if> nowrap>${secondNode.name}&nbsp;</td>
                    <c:set var="dataKey" value="${secondNode.id}" />
                    <c:if test="${status.index%2==0}">
                        <td width="20%" align="left">${dataMap[dataKey].content}</td>
                        <td rowspan="2" width="20%" align="left"><sys:toHtml> ${dataMap[dataKey].problem}</sys:toHtml></td>
                    </c:if>
                    <c:if test="${status.index%2==1}">
                        <td width="20%" align="left">${dataMap[dataKey].content}</td>
                    </c:if>
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
                        <c:set var="dataKey" value="${thirdNode.id}"/>
                        <td width="8%" colspan="2" align="left">${dataMap[dataKey].content}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </c:if>
    </c:forEach>
</table>