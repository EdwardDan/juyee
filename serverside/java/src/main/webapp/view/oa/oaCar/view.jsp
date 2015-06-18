<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">使用车辆开始时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">使用车辆结束时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">用车人数：</td>
          <td class="form_content">&nbsp;
                      ${bean.personNum}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">用车事由：</td>
          <td class="form_content">&nbsp;
                      ${bean.useCause}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">目的地：</td>
          <td class="form_content">&nbsp;
                      ${bean.address}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">科长审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.kzAuditOpinion}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">科长审核时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.kzAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">办公室主任审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.zrAuditOpinion}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">办公室主任审核时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.zrAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">拟派司机电话：</td>
          <td class="form_content">&nbsp;
                      ${bean.driverMobile}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">状态：</td>
          <td class="form_content">&nbsp;
                      ${bean.status}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">创建时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">创建用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.createUser}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">更新时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
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