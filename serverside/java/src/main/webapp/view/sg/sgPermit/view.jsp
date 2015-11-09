<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">年：</td>
          <td class="form_content">&nbsp;
                      ${bean.year}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">报建编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.bjbh}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">项目名称：</td>
          <td class="form_content">&nbsp;
                      ${bean.projectName}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">建设单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.buildName}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">沪交管收字_年：</td>
          <td class="form_content">&nbsp;
                      ${bean.hYear}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">沪交管收字_号：</td>
          <td class="form_content">&nbsp;
                      ${bean.hNum}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">申请人：</td>
          <td class="form_content">&nbsp;
                      ${bean.applyPerson}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">申请事项：</td>
          <td class="form_content">&nbsp;
                      ${bean.applyMatter}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">申请号：</td>
          <td class="form_content">&nbsp;
                      ${bean.applyNum}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">材料提交人：</td>
          <td class="form_content">&nbsp;
                      ${bean.materialPerson}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">材料提交人联系电话：</td>
          <td class="form_content">&nbsp;
                      ${bean.materialPersonPhone}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">材料提交人联系地址：</td>
          <td class="form_content">&nbsp;
                      ${bean.materialPersonAddress}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">收件人：</td>
          <td class="form_content">&nbsp;
                      ${bean.receivePerson}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">收件人联系电话：</td>
          <td class="form_content">&nbsp;
                      ${bean.receivePersonPhone}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">状态：</td>
          <td class="form_content">&nbsp;
                      ${bean.status}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">初审意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.csOpinion}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">复核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.fhOpinion}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.shOpinion}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">分管领导审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.fgldOpinion}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">中心领导审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.zxldOpinion}                    </td>
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