<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">会议开始时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">会议结束时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">会议地点：</td>
          <td class="form_content">&nbsp;
                      ${bean.address}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主持人：</td>
          <td class="form_content">&nbsp;
                      ${bean.chargePerson}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">发起单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.startDept}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">会议领导：</td>
          <td class="form_content">&nbsp;
                      ${bean.leader}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">与会单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.innerPersons}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">会议名称：</td>
          <td class="form_content">&nbsp;
                      ${bean.title}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">会议内容：</td>
          <td class="form_content">&nbsp;
                      ${bean.content}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">与中心相关事宜：</td>
          <td class="form_content">&nbsp;
                      ${bean.relateMatter}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">工作建议：</td>
          <td class="form_content">&nbsp;
                      ${bean.workAdvise}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">状态：</td>
          <td class="form_content">&nbsp;
                      ${bean.status}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">分管领导审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.fgAuditOpinion}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">分管领导审核时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.fgAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主任审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.zrAuditOpinion}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主任审核时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.zrAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">创建时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">创建用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.createUser}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">更新时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">更新用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.updateUser}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>