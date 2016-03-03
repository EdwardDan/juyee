<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">主要设计单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSjUnit}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要设计招标方式：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSjZbfs}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要设计中标价：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSjZbj}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要设计资质等级：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSjZzdj}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要设计项目负责人：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSjXmfzr}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要设计证书编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSjZsbh}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要设计证书编号2：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSjZsbh2}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要监理单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainJlUnit}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要监理招标方式：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainJlZbfs}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要监理中标价：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainJlZbj}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要监理资质等级：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainJlZzdj}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要监理项目负责人：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainJlXmfzr}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要监理证书编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainJlZsbh}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要监理证书编号2：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainJlZsbh2}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要施工单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSgUnit}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要施工招标方式：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSgZbfs}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要施工中标价：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSgZbj}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要施工资质等级：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSgZzdj}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要施工项目负责人：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSgXmfzr}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主要施工证书编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSgZsbh}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主要施工证书编号2：</td>
          <td class="form_content">&nbsp;
                      ${bean.mainSgZsbh2}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">工可批准或核准机关和文号：</td>
          <td class="form_content">&nbsp;
                      ${bean.gkpzCode}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">批复或核准日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.hzDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">投资估算：</td>
          <td class="form_content">&nbsp;
                      ${bean.planCost}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">初步设计批准机关和文号：</td>
          <td class="form_content">&nbsp;
                      ${bean.cbshCode}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">批复日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.pfDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">批复工期：</td>
          <td class="form_content">&nbsp;
                      ${bean.pfGq}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">总概算：</td>
          <td class="form_content">&nbsp;
                      ${bean.totalGs}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">批准机关和文号：</td>
          <td class="form_content">&nbsp;
                      ${bean.pzjgCode}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">投资来源：</td>
          <td class="form_content">&nbsp;
                      ${bean.costFrom}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>