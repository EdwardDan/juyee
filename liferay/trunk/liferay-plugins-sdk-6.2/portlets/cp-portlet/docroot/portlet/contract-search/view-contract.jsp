<%@page import="com.justonetech.cp.contract.service.ContractLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
    <style type="text/css">
        tr{
            text-align: center;
        }
        tr.head  td{
            background-color: #63B8FF;
            text-align: center;
            font-size: 16px;
            color: white;
            font-family: "宋体";
            font-weight: bold;
        }
        tr.body td.title{
            width: 20%;
        }
        tr.body td.content{
            width: 30%;
        }
    </style>
<%
	String contractId = ParamUtil.getString(request,"bjbh");
	Contract contract = ContractLocalServiceUtil.getContract(contractId);
%>
<table border="1" width="100%">
    <tr class="head">
        <td  colspan="4">项目详细信息</td>
    </tr>
    <tr class="body">
        <td class="title">报建编号:</td>
        <td class="content"></td>
        <td class="title">所在地区:</td>
        <td class="content"></td>
    </tr>
    <tr class="body">
        <td class="title">项目名称:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">建设单位:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">建设地点:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr>
        <td class="title">立项批文:</td>
        <td class="content"></td>
        <td class="title" >批准文号:</td>
        <td class="content" ></td>
    </tr>
    <tr>
        <td class="title">单位性质:</td>
        <td class="content"></td>
        <td class="title" >资金来源构成:</td>
        <td class="content" ></td>
    </tr>
    <tr>
        <td class="title">总投资(万元):</td>
        <td class="content"></td>
        <td class="title" >总建筑面积(㎡):</td>
        <td class="content" ></td>
    </tr>
    <tr>
        <td class="title">项目分类:</td>
        <td class="content"></td>
        <td class="title" >建设规模:</td>
        <td class="content" ></td>
    </tr>
    <tr class="head">
        <td  colspan="4">合同信息报送编号:<%=contractId%></td>
    </tr>
    <tr class="body">
        <td class="title">合同名称:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">监理标段号:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr>
        <td class="title">发包方式:</td>
        <td class="content"></td>
        <td class="title" >承包方式:</td>
        <td class="content" ></td>
    </tr>
    <tr class="body">
        <td class="title">发包单位:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">承包单位:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr>
        <td class="title">总监理工程师:</td>
        <td class="content"></td>
        <td class="title" ></td>
        <td class="content" ></td>
    </tr>
    <tr>
        <td class="title">证件类型:</td>
        <td class="content"></td>
        <td class="title" >证件号:</td>
        <td class="content" ></td>
    </tr>
    <tr>
        <td class="title">项目类别:</td>
        <td class="content"></td>
        <td class="title" >工程类别:</td>
        <td class="content" ></td>
    </tr>
    <tr class="body">
        <td class="title">工程规模:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr>
        <td class="title">标段工程建安造价(万元):</td>
        <td class="content"></td>
        <td class="title" >建筑面积(㎡):</td>
        <td class="content" ></td>
    </tr>
    <tr>
        <td class="title">开、竣工日期:</td>
        <td class="content"></td>
        <td class="title" >合同价(万元):</td>
        <td class="content" ></td>
    </tr>
    <tr>
        <td class="title">合同签订日期:</td>
        <td class="content"></td>
        <td class="title" >合同起止日期(合同有效期):</td>
        <td class="content" ></td>
    </tr>
    <tr class="body">
        <td class="title">承包内容:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">采用合同示范文本:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">附注其他说明:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">是否注销:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">注销时间:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">注销说明:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="head">
        <td  colspan="4">合同报送信息签名</td>
    </tr>
    <tr class="body">
        <td class="title">企业数字签名:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">信息报送状态:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="head">
        <td  colspan="4">合同报送信息变更</td>
    </tr>
    <tr class="body">
        <td class="title">企业数字签名:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">变更记录:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="head">
        <td  colspan="4">合同报送信息企业名称变更</td>
    </tr>
    <tr class="body">
        <td class="title">企业数字签名:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">变更记录:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="head">
        <td  colspan="4">合同报送信息发承包单位变更</td>
    </tr>
    <tr class="body">
        <td class="title">企业数字签名:</td>
        <td class="content" colspan="3"></td>
    </tr>
    <tr class="body">
        <td class="title">变更记录:</td>
        <td class="content" colspan="3"></td>
    </tr>
</table>