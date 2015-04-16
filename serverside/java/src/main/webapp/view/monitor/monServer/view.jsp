<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">项目名称：</td>
            <td class="form_content">&nbsp;
                ${bean.name}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">主机名：</td>
            <td class="form_content">&nbsp;
                ${bean.serverName}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">IP：</td>
            <td class="form_content">&nbsp;
                ${bean.ip}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">端口：</td>
            <td class="form_content">&nbsp;
                ${bean.port}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">服务器类型：</td>
            <td class="form_content">&nbsp;
                ${bean.serverType.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">连接类型：</td>
            <td class="form_content">&nbsp;
                ${bean.connectType.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">代理IP地址：</td>
            <td class="form_content">&nbsp;
                ${bean.proxyIp}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">代理IP主机名：</td>
            <td class="form_content">&nbsp;
                ${bean.proxyName}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">登录名：</td>
            <td class="form_content">&nbsp;
                ${bean.loginName}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">密码：</td>
            <td class="form_content">&nbsp;
                ${bean.password}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">备注：</td>
            <td class="form_content">&nbsp;
                ${bean.description}                    </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>