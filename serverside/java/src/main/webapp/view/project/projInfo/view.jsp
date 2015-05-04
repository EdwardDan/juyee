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
          <td class="form_label">年份：</td>
          <td class="form_content">&nbsp;
                      ${bean.year}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">项目序号：</td>
          <td class="form_content">&nbsp;
                      ${bean.no}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">建设里程：</td>
          <td class="form_content">&nbsp;
                      ${bean.buildMileage}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">起讫地点：</td>
          <td class="form_content">&nbsp;
                      ${bean.location}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">开工日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.startDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">工程简介：</td>
          <td class="form_content">&nbsp;
                      ${bean.intro}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">建设单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.jsDept}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">施工单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.sgDept}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">施工单位联系人：</td>
          <td class="form_content">&nbsp;
                      ${bean.sgDeptPerson}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">施工单位联系电话：</td>
          <td class="form_content">&nbsp;
                      ${bean.sgDeptTel}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">监理单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.jlDept}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">监理单位联系人：</td>
          <td class="form_content">&nbsp;
                      ${bean.jlDeptPerson}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">监理单位联系电话：</td>
          <td class="form_content">&nbsp;
                      ${bean.jlDeptTel}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>