<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    //无iframe方式
    $(function () {
        $('#tabsChild').tabs({
            border:false
        });
    });
</script>

<div id="tabsChild" class="easyui-tabs1">
    <div title="项目概况" closable="false" cache="false"  href="${ctx}/projectQuery/viewProject.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>
    <div title="建设程序" closable="false" cache="false"  href="${ctx}/projectQuery/viewBuild.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>
    <div title="承发包" closable="false" cache="false"  href="${ctx}/projectQuery/viewCfb.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>
    <div title="施工分包" closable="false" cache="false"  href="${ctx}/projectQuery/viewSgfb.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>
    <div title="单位工程" closable="false" cache="false"  href="${ctx}/projectQuery/viewUnit.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>
    <%--<div title="管理人员" closable="false" cache="false"  href="${ctx}/projectQuery/viewPerson.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>--%>
    <div title="监管情况" closable="false" cache="false"  href="${ctx}/projectQuery/viewMonitor.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>
    <div title="行政处罚" closable="false" cache="false"  href="${ctx}/projectQuery/viewPunish.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>
    <%--<div title="现场视频" closable="false" cache="false"  href="${ctx}/projectQuery/viewVideo.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>--%>
    <%--<div title="企业上报" closable="false" cache="false"  href="${ctx}/projectQuery/viewCompany.do?bjbh=${bjbh}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}"></div>--%>
</div>