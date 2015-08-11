<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<br>

<table border="1" cellpadding="0" cellspacing="0" class="table_thin_line_center" style="width: 70%;">
    <tr class="tr_header">
        <td colspan="7">
            ${year}年${month}月项目推进主要证照完成情况汇总
        </td>
    </tr>
    <tr class="tr_title">
        <td style="width: 5%;">序号</td>
        <td style="width: 20%;">证照名称</td>
        <td style="width: 10%;">总计划数</td>
        <td style="width: 10%;">年度计划数</td>
        <td style="width: 10%;">当月完成数</td>
        <td style="width: 10%;">累计完成数</td>
        <td style="width: 10%;">占年度计划百分率</td>
    </tr>
    <tr class="tr_dark" style="font-weight: bold;">
        <td>一</td>
        <td>选址意见书</td>
        <td>${totalPlanXZ}</td>
        <td>${yearPlanXZ}</td>
        <td>${monthPlanXZ}</td>
        <td>${accPlanXZ}</td>
        <td>${perXZ}%</td>
    </tr>
    <c:forEach items="${categorys}" var="category" varStatus="status">
        <c:set var="totalPSOpinions" value="total_${PSOpinions}_${category.code}"/>
        <c:set var="yearPSOpinions" value="year_${PSOpinions}_${category.code}"/>
        <c:set var="monthPSOpinions" value="month_${PSOpinions}_${category.code}"/>
        <c:set var="accPSOpinions" value="acc_${PSOpinions}_${category.code}"/>
        <c:set var="perPSOpinions" value="per_${PSOpinions}_${category.code}"/>
        <tr class="tr_dark">
            <td>1.${status.index+1}</td>
            <td>${category.name}</td>
            <td>${map[totalPSOpinions]}<c:if test="${empty map[totalPSOpinions]}">0</c:if></td>
            <td>${map[yearPSOpinions]}<c:if test="${empty map[yearPSOpinions]}">0</c:if></td>
            <td>${map[monthPSOpinions]}<c:if test="${empty map[monthPSOpinions]}">0</c:if></td>
            <td>${map[accPSOpinions]}<c:if test="${empty map[accPSOpinions]}">0</c:if></td>
            <td>${map[perPSOpinions]}<c:if test="${empty map[accPSOpinions]}">0</c:if>%</td>
        </tr>
    </c:forEach>
    <tr class="tr_dark" style="font-weight: bold;">
        <td>二</td>
        <td>工可批复</td>
        <td>${totalPlanGK}</td>
        <td>${yearPlanGK}</td>
        <td>${monthPlanGK}</td>
        <td>${accPlanGK}</td>
        <td>${perGK}%</td>
    </tr>
    <c:forEach items="${categorys}" var="category" varStatus="status">
        <c:set var="totalReply4Workers" value="total_${Reply4Workers}_${category.code}"/>
        <c:set var="yearReply4Workers" value="year_${Reply4Workers}_${category.code}"/>
        <c:set var="monthReply4Workers" value="month_${Reply4Workers}_${category.code}"/>
        <c:set var="accReply4Workers" value="acc_${Reply4Workers}_${category.code}"/>
        <c:set var="perReply4Workers" value="per_${Reply4Workers}_${category.code}"/>
        <tr class="tr_dark">
            <td>2.${status.index+1}</td>
            <td>${category.name}</td>
            <td>${map[totalReply4Workers]}<c:if test="${empty map[totalReply4Workers]}">0</c:if></td>
            <td>${map[yearReply4Workers]}<c:if test="${empty map[yearReply4Workers]}">0</c:if></td>
            <td>${map[monthReply4Workers]}<c:if test="${empty map[monthReply4Workers]}">0</c:if></td>
            <td>${map[accReply4Workers]}<c:if test="${empty map[accReply4Workers]}">0</c:if></td>
            <td>${map[perReply4Workers]}<c:if test="${empty map[perReply4Workers]}">0</c:if>%</td>
        </tr>
    </c:forEach>
    <tr class="tr_dark" style="font-weight: bold;">
        <td>三</td>
        <td>初步设计批复</td>
        <td>${totalPlanCB}</td>
        <td>${yearPlanCB}</td>
        <td>${monthPlanCB}</td>
        <td>${accPlanCB}</td>
        <td>${perCB}%</td>
    </tr>
    <c:forEach items="${categorys}" var="category" varStatus="status">
        <c:set var="totalPreDesign" value="total_${PreDesign}_${category.code}"/>
        <c:set var="yearPreDesign" value="year_${PreDesign}_${category.code}"/>
        <c:set var="monthPreDesign" value="month_${PreDesign}_${category.code}"/>
        <c:set var="accPreDesign" value="acc_${PreDesign}_${category.code}"/>
        <c:set var="perPreDesign" value="per_${PreDesign}_${category.code}"/>
        <tr class="tr_dark">
            <td>3.${status.index+1}</td>
            <td>${category.name}</td>
            <td>${map[totalPreDesign]}<c:if test="${empty map[totalPreDesign]}">0</c:if></td>
            <td>${map[yearPreDesign]}<c:if test="${empty map[yearPreDesign]}">0</c:if></td>
            <td>${map[monthPreDesign]}<c:if test="${empty map[monthPreDesign]}">0</c:if></td>
            <td>${map[accPreDesign]}<c:if test="${empty map[accPreDesign]}">0</c:if></td>
            <td>${map[perPreDesign]}<c:if test="${empty map[perPreDesign]}">0</c:if>%</td>
        </tr>
    </c:forEach>
    <tr class="tr_dark" style="font-weight: bold;">
        <td>四</td>
        <td>用地规划许可证</td>
        <td>${totalPlanYDGH}</td>
        <td>${yearPlanYDGH}</td>
        <td>${monthPlanYDGH}</td>
        <td>${accPlanYDGH}</td>
        <td>${perYDGH}%</td>
    </tr>
    <c:forEach items="${categorys}" var="category" varStatus="status">
        <c:set var="totalLandUsePlanning" value="total_${LandUsePlanning}_${category.code}"/>
        <c:set var="yearLandUsePlanning" value="year_${LandUsePlanning}_${category.code}"/>
        <c:set var="monthLandUsePlanning" value="month_${LandUsePlanning}_${category.code}"/>
        <c:set var="accLandUsePlanning" value="acc_${LandUsePlanning}_${category.code}"/>
        <c:set var="perLandUsePlanning" value="per_${LandUsePlanning}_${category.code}"/>
        <tr class="tr_dark">
            <td>4.${status.index+1}</td>
            <td>${category.name}</td>
            <td>${map[totalLandUsePlanning]}<c:if test="${empty map[totalLandUsePlanning]}">0</c:if></td>
            <td>${map[yearLandUsePlanning]}<c:if test="${empty map[yearLandUsePlanning]}">0</c:if></td>
            <td>${map[monthLandUsePlanning]}<c:if test="${empty map[monthLandUsePlanning]}">0</c:if></td>
            <td>${map[accLandUsePlanning]}<c:if test="${empty map[accLandUsePlanning]}">0</c:if></td>
            <td>${map[perLandUsePlanning]}<c:if test="${empty map[perLandUsePlanning]}">0</c:if>%</td>
        </tr>
    </c:forEach>
    <tr class="tr_dark" style="font-weight: bold;">
        <td>五</td>
        <td>用地批准书</td>
        <td>${totalPlanYDPZ}</td>
        <td>${yearPlanYDPZ}</td>
        <td>${monthPlanYDPZ}</td>
        <td>${accPlanYDPZ}</td>
        <td>${perYDPZ}%</td>
    </tr>
    <c:forEach items="${categorys}" var="category" varStatus="status">
        <c:set var="totalLandUseApproval" value="total_${LandUseApproval}_${category.code}"/>
        <c:set var="yearLandUseApproval" value="year_${LandUseApproval}_${category.code}"/>
        <c:set var="monthLandUseApproval" value="month_${LandUseApproval}_${category.code}"/>
        <c:set var="accLandUseApproval" value="acc_${LandUseApproval}_${category.code}"/>
        <c:set var="perLandUseApproval" value="per_${LandUseApproval}_${category.code}"/>
        <tr class="tr_dark">
            <td>5.${status.index+1}</td>
            <td>${category.name}</td>
            <td>${map[totalLandUseApproval]}<c:if test="${empty map[totalLandUseApproval]}">0</c:if></td>
            <td>${map[yearLandUseApproval]}<c:if test="${empty map[yearLandUseApproval]}">0</c:if></td>
            <td>${map[monthLandUseApproval]}<c:if test="${empty map[monthLandUseApproval]}">0</c:if></td>
            <td>${map[accLandUseApproval]}<c:if test="${empty map[accLandUseApproval]}">0</c:if></td>
            <td>${map[perLandUseApproval]}<c:if test="${empty map[perLandUseApproval]}">0</c:if>%</td>
        </tr>
    </c:forEach>
    <tr class="tr_dark" style="font-weight: bold;">
        <td>六</td>
        <td>工程规划许可证</td>
        <td>${totalPlanGC}</td>
        <td>${yearPlanGC}</td>
        <td>${monthPlanGC}</td>
        <td>${accPlanGC}</td>
        <td>${perGC}%</td>
    </tr>
    <c:forEach items="${categorys}" var="category" varStatus="status">
        <c:set var="totalEngineerPlanningPermit" value="total_${EngineerPlanningPermit}_${category.code}"/>
        <c:set var="yearEngineerPlanningPermit" value="year_${EngineerPlanningPermit}_${category.code}"/>
        <c:set var="monthEngineerPlanningPermit" value="month_${EngineerPlanningPermit}_${category.code}"/>
        <c:set var="accEngineerPlanningPermit" value="acc_${EngineerPlanningPermit}_${category.code}"/>
        <c:set var="perEngineerPlanningPermit" value="per_${EngineerPlanningPermit}_${category.code}"/>
        <tr class="tr_dark">
            <td>6.${status.index+1}</td>
            <td>${category.name}</td>
            <td>${map[totalEngineerPlanningPermit]}<c:if test="${empty map[totalEngineerPlanningPermit]}">0</c:if></td>
            <td>${map[yearEngineerPlanningPermit]}<c:if test="${empty map[yearEngineerPlanningPermit]}">0</c:if></td>
            <td>${map[monthEngineerPlanningPermit]}<c:if test="${empty map[monthEngineerPlanningPermit]}">0</c:if></td>
            <td>${map[accEngineerPlanningPermit]}<c:if test="${empty map[accEngineerPlanningPermit]}">0</c:if></td>
            <td>${map[perEngineerPlanningPermit]}<c:if test="${empty map[perEngineerPlanningPermit]}">0</c:if>%</td>
        </tr>
    </c:forEach>
    <tr class="tr_dark" style="font-weight: bold;">
        <td>七</td>
        <td>施工许可证</td>
        <td>${totalPlanSG}</td>
        <td>${yearPlanSG}</td>
        <td>${monthPlanSG}</td>
        <td>${accPlanSG}</td>
        <td>${perSG}%</td>
    </tr>
    <c:forEach items="${categorys}" var="category" varStatus="status">
        <c:set var="totalConstructionPermits" value="total_${ConstructionPermits}_${category.code}"/>
        <c:set var="yearConstructionPermits" value="year_${ConstructionPermits}_${category.code}"/>
        <c:set var="monthConstructionPermits" value="month_${ConstructionPermits}_${category.code}"/>
        <c:set var="accConstructionPermits" value="acc_${ConstructionPermits}_${category.code}"/>
        <c:set var="perConstructionPermits" value="per_${ConstructionPermits}_${category.code}"/>
        <tr class="tr_dark">
            <td>7.${status.index+1}</td>
            <td>${category.name}</td>
            <td>${map[totalConstructionPermits]}<c:if test="${empty map[totalConstructionPermits]}">0</c:if></td>
            <td>${map[yearConstructionPermits]}<c:if test="${empty map[yearConstructionPermits]}">0</c:if></td>
            <td>${map[monthConstructionPermits]}<c:if test="${empty map[monthConstructionPermits]}">0</c:if></td>
            <td>${map[accConstructionPermits]}<c:if test="${empty map[accConstructionPermits]}">0</c:if></td>
            <td>${map[perConstructionPermits]}<c:if test="${empty map[perConstructionPermits]}">0</c:if>%</td>
        </tr>
    </c:forEach>
</table>
