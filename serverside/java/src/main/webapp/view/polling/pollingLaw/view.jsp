<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">关联字段ID：</td>
          <td class="form_content">&nbsp;
                      ${bean.stddocid}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">条款编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.catalog}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">条款内容：</td>
          <td class="form_content">&nbsp;
                      ${bean.descriptions}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">标准名称：</td>
          <td class="form_content">&nbsp;
                      ${bean.tksm}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">标准编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.tkbh}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">分类：</td>
          <td class="form_content">&nbsp;
                      ${bean.lx}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">监督分类：</td>
          <td class="form_content">&nbsp;
                      ${bean.jdfl}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">序号：</td>
          <td class="form_content">&nbsp;
                      ${bean.iitemno}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">类型：</td>
          <td class="form_content">&nbsp;
                      ${bean.type}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">条款简述：</td>
          <td class="form_content">&nbsp;
                      ${bean.shotdes}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>