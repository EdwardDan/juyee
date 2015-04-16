<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/common/header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎访问${siteName}--受理状态查询</title>
    <link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .Header .title_wsbs {
            background-repeat: no-repeat;
            height: 113px;
            width: auto;
            padding: 0px;
        }

        .ContentHome .wsbs {
            float: right;
            width: 247px;
            margin-top: 0px;
        }

        .ContentHome {
            width: 969px;
            margin: 0 auto;
            padding: 7px 0;
            clear: both;
            background-color: #fff;
        }

        .ContentHome .tcy {
            float: left;
            width: 969px;
            border: 1px solid #e0e1e3;
        }

        .ContentHome .tcy .title {
            float: left;
            width: 969px;
            border: 1px solid #e0e1e3;
        }

        .ContentHome .tcy .table_title {
            background-image: url(${ctx}/view/www/images/wsbsdt_5.jpg);
            background-repeat: repeat-x;
            font-size: 14px;
            font-weight: bold;
            border: 1px solid #48a8e5;
            text-align: center;
        }

        .ContentHome .tcy .table_line {
            border: 1px solid #48a8e5;
        }

        .ContentHome .tcy .td_light {
            background-color: #eff7fa;
        }

        .ContentHome .tcy .td_dark {
            background-color: #efefef;
        }
    </style>
</head>

<body>
<div class="Header">
    <div class="title_wsbs"><img src="${ctx}/view/www/images/wsbsdt_4.jpg" width="969" height="113"/></div>
    <div class="clr"></div>
</div>

<div class="ContentHome">
    <div class="tcy">
        <c:choose>
            <c:when test="${getDataSuccess==true}">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="center" bgcolor="#FFFFFF"><br/>
                            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td height="25" class="table_title">申请信息</td>
                                </tr>
                                <tr>
                                    <td class="table_line">
                                        <table width="100%" align="center" cellpadding="0" cellspacing="1"
                                               class="table_wsbs">
                                            <tr class="td_light">
                                                <td height="25" align="right"
                                                    width="35%">${applyInfos[0]}</td>
                                                <td align="left">&nbsp;${applyInfos[1]}</td>
                                            </tr>
                                            <tr class="td_dark">
                                                <td height="25" align="right">${applyInfos[2]}</td>
                                                <td align="left">&nbsp;${applyInfos[3]}</td>
                                            </tr>
                                            <tr class="td_light">
                                                <td height="25" align="right">${applyInfos[4]}</td>
                                                <td align="left">&nbsp;${applyInfos[5]}</td>
                                            </tr>
                                            <tr class="td_dark">
                                                <td height="25" align="right">${applyInfos[6]}</td>
                                                <td align="left">&nbsp;${applyInfos[7]}</td>
                                            </tr>
                                            <tr class="td_light">
                                                <td height="25" align="right">${applyInfos[8]}</td>
                                                <td align="left">&nbsp;${applyInfos[9]}</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <br/>
                            <br/>
                            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td height="25" class="table_title">过程信息</td>
                                </tr>
                                <tr>
                                    <td class="table_line">
                                        <table width="100%" cellpadding="0" cellspacing="1" class="table_wsbs">
                                            <c:forEach items="${processList}" var="item" varStatus="status">
                                            <tr align="center" <c:choose><c:when test="${status.index%2==0}">class="td_light"</c:when><c:otherwise>class="td_dark"</c:otherwise></c:choose>>
                                                <td height="25" width="30%">${item[0]}</td>
                                                <td width="40%">${item[1]}</td>
                                                <td width="30%">${item[2]}</td>
                                            </tr>
                                            </c:forEach>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <br/>
                            <br/>

                            <div style="text-align: center"><input type="button" value="关闭" class="button"
                                                                   onclick="self.close()"></div>
                            <br/>
                        </td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="center" bgcolor="#FFFFFF"><br/>
                            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td height="25" class="table_title">受理状态查询</td>
                                </tr>
                                <tr>
                                    <td class="table_line" style="height: 250px;text-align: center;color: red">
                                        未查询到受理号[${code}]的相关信息！
                                    </td>
                                </tr>
                            </table>
                            <br>
                            <br>
                            <div style="text-align: center"><input type="button" value="关闭" class="button"
                                                                   onclick="self.close()"></div>
                            <br/>
                        </td>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<div class="clr"></div>

<div class="Foot">
    <div class="icp">
        <p>
            <a href="${ctx}/site/index.do?type=index">返回首页</a> |
            <a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_INTRODUCTION}">机构介绍</a> |
            <a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_NEWS}">建管要闻</a> |
            <a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_WORK}">工作动态</a> |
            <a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_BULLETIN}">公告公示</a> |
            <a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_POLICY}">政策法规</a> |
            <a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_STANDARD}">现行标准</a> |
            <a href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_PIC}">行业风采</a> |
            <a href="${ctx}/site/list.do?type=${OA_PUBLIC_INO_TYPE_PARTYMEMBER}">党群天地</a> |
        </p>

        <p>上海市虹口区建筑建材业管理署 版权所有 地址：上海市虹口区茸北路690号　电话：57786700　E-mail：sjqjgs@126.com</p>
    </div>
    <div class="clr"></div>
</div>
</body>
</html>



