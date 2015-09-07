<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div" style="overflow: scroll;">
<table border=1 cellpadding=0 cellspacing=0 width="95%" class="table_thin_line_center">
<tr class="tr_title">
    <td colspan=35>“十二五”交通基础设施建设项目汇总表</td>
</tr>
<tr class="tr_header">
    <td nowrap colspan=2 rowspan=3></td>
    <td nowrap rowspan=3>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap rowspan=3>&nbsp;&nbsp;总投资额&nbsp;&nbsp;</td>
    <td nowrap colspan=5>市政道路</td>
    <td nowrap colspan=3 rowspan=2>公交基础设施</td>
    <td nowrap colspan=4>大居配套（区属）</td>
    <td nowrap colspan=4>轨道</td>
    <td nowrap colspan=4>内河</td>
    <td nowrap colspan=4>港口</td>
    <td nowrap colspan=4>航空</td>
    <td nowrap colspan=2 rowspan=2>铁路（市属）</td>
    <td nowrap rowspan=2>拟至十三<br>五实施<br>项目</td>
</tr>
<tr class="tr_header">
    <td nowrap colspan=3>市属</td>
    <td nowrap colspan=2>区属</td>
    <td nowrap colspan=2>配套道路</td>
    <td nowrap colspan=2>配套公交</td>
    <td nowrap colspan=3>市属</td>
    <td nowrap></td>
    <td nowrap colspan=3>市属</td>
    <td nowrap></td>
    <td nowrap colspan=3>市属</td>
    <td nowrap></td>
    <td nowrap colspan=3>市属</td>
    <td nowrap></td>
</tr>
<tr class="tr_header">
    <td nowrap>&nbsp;&nbsp;重大&nbsp;&nbsp;<br>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;非重大&nbsp;&nbsp;<br>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;小计&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;区属&nbsp;&nbsp;<br>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;市属&nbsp;&nbsp;<br>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;区属&nbsp;&nbsp;<br>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;重大&nbsp;&nbsp;<br>&nbsp;&nbsp;项目&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;非重大&nbsp;&nbsp;<br>&nbsp;&nbsp;项目&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;小计&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;重大&nbsp;&nbsp;<br>&nbsp;&nbsp;项目&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;非重大&nbsp;&nbsp;<br>&nbsp;&nbsp;项目&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;小计&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;重大&nbsp;&nbsp;<br>&nbsp;&nbsp;项目&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;非重大&nbsp;&nbsp;<br>&nbsp;&nbsp;项目&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;小计&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;重大&nbsp;&nbsp;<br>&nbsp;&nbsp;项目</td>
    <td nowrap>&nbsp;&nbsp;非重大&nbsp;&nbsp;<br>&nbsp;&nbsp;项目&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;小计&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;投资额&nbsp;&nbsp;</td>
    <td nowrap>&nbsp;&nbsp;个数&nbsp;&nbsp;</td>
</tr>
<tr class="tr_dark">
    <td colspan="2" nowrap style="font-weight: bold;">总计</td>
    <td>${zj_size}</td>
    <td></td>
    <td>${map["szdl_ss_zd"]}</td>
    <td>${map["szdl_ss_fzd"]}</td>
    <td>${map["szdl_ss_xj"]}</td>
    <td>${map["szdl_qs"]}</td>
    <td>${map["szdl_cost"]}</td>
    <td>${map["gjjcss_ss"]}</td>
    <td>${map["gjjcss_qs"]}</td>
    <td>${map["gjjcss_cost"]}</td>
    <td>${map["ptdl"]}</td>
    <td>${map["ptdl_cost"]}</td>
    <td>${map["ptgj"]}</td>
    <td>${map["ptgj_cost"]}</td>
    <td>${map["gd_ss_zd"]}</td>
    <td>${map["gd_ss_fzd"]}</td>
    <td>${map["gd_ss_xj"]}</td>
    <td>${map["gd_ss_cost"]}</td>
    <td>${map["nh_ss_zd"]}</td>
    <td>${map["nh_ss_fzd"]}</td>
    <td>${map["nh_ss_xj"]}</td>
    <td>${map["nh_ss_cost"]}</td>
    <td>${map["gk_ss_zd"]}</td>
    <td>${map["gk_ss_fzd"]}</td>
    <td>${map["gk_ss_xj"]}</td>
    <td>${map["gk_ss_cost"]}</td>
    <td>${map["hk_ss_zd"]}</td>
    <td>${map["hk_ss_fzd"]}</td>
    <td>${map["hk_ss_xj"]}</td>
    <td>${map["hk_ss_cost"]}</td>
    <td>${map["tl"]}</td>
    <td>${map["tl_cost"]}</td>
    <td></td>
</tr>
<tr class="tr_dark">
    <td nowrap style="font-weight: bold;" rowspan="3">已开工<br>项目</td>
    <td nowrap style="font-weight: bold;">小计</td>
    <td>${ykg_size}</td>
    <td></td>
    <td>${map["ykg_szdl_ss_zd"]}</td>
    <td>${map["ykg_szdl_ss_fzd"]}</td>
    <td>${map["ykg_szdl_ss_xj"]}</td>
    <td>${map["ykg_szdl_qs"]}</td>
    <td>${map["ykg_szdl_cost"]}</td>
    <td>${map["ykg_gjjcss_ss"]}</td>
    <td>${map["ykg_gjjcss_qs"]}</td>
    <td>${map["ykg_gjjcss_cost"]}</td>
    <td>${map["ykg_ptdl"]}</td>
    <td>${map["ykg_ptdl_cost"]}</td>
    <td>${map["ykg_ptgj"]}</td>
    <td>${map["ykg_ptgj_cost"]}</td>
    <td>${map["ykg_gd_ss_zd"]}</td>
    <td>${map["ykg_gd_ss_fzd"]}</td>
    <td>${map["ykg_gd_ss_xj"]}</td>
    <td>${map["ykg_gd_ss_cost"]}</td>
    <td>${map["ykg_nh_ss_zd"]}</td>
    <td>${map["ykg_nh_ss_fzd"]}</td>
    <td>${map["ykg_nh_ss_xj"]}</td>
    <td>${map["ykg_nh_ss_cost"]}</td>
    <td>${map["ykg_gk_ss_zd"]}</td>
    <td>${map["ykg_gk_ss_fzd"]}</td>
    <td>${map["ykg_gk_ss_xj"]}</td>
    <td>${map["ykg_gk_ss_cost"]}</td>
    <td>${map["ykg_hk_ss_zd"]}</td>
    <td>${map["ykg_hk_ss_fzd"]}</td>
    <td>${map["ykg_hk_ss_xj"]}</td>
    <td>${map["ykg_hk_ss_cost"]}</td>
    <td>${map["ykg_tl"]}</td>
    <td>${map["ykg_tl_cost"]}</td>
    <td></td>
</tr>
<tr class="tr_dark">
    <td nowrap>已完工项目</td>
    <td>${ywg_size}</td>
    <td></td>
    <td>${map["ywg_szdl_ss_zd"]}</td>
    <td>${map["ywg_szdl_ss_fzd"]}</td>
    <td>${map["ywg_szdl_ss_xj"]}</td>
    <td>${map["ywg_szdl_qs"]}</td>
    <td>${map["ywg_szdl_cost"]}</td>
    <td>${map["ywg_gjjcss_ss"]}</td>
    <td>${map["ywg_gjjcss_qs"]}</td>
    <td>${map["ywg_gjjcss_cost"]}</td>
    <td>${map["ywg_ptdl"]}</td>
    <td>${map["ywg_ptdl_cost"]}</td>
    <td>${map["ywg_ptgj"]}</td>
    <td>${map["ywg_ptgj_cost"]}</td>
    <td>${map["ywg_gd_ss_zd"]}</td>
    <td>${map["ywg_gd_ss_fzd"]}</td>
    <td>${map["ywg_gd_ss_xj"]}</td>
    <td>${map["ywg_gd_ss_cost"]}</td>
    <td>${map["ywg_nh_ss_zd"]}</td>
    <td>${map["ywg_nh_ss_fzd"]}</td>
    <td>${map["ywg_nh_ss_xj"]}</td>
    <td>${map["ywg_nh_ss_cost"]}</td>
    <td>${map["ywg_gk_ss_zd"]}</td>
    <td>${map["ywg_gk_ss_fzd"]}</td>
    <td>${map["ywg_gk_ss_xj"]}</td>
    <td>${map["ywg_gk_ss_cost"]}</td>
    <td>${map["ywg_hk_ss_zd"]}</td>
    <td>${map["ywg_hk_ss_fzd"]}</td>
    <td>${map["ywg_hk_ss_xj"]}</td>
    <td>${map["ywg_hk_ss_cost"]}</td>
    <td>${map["ywg_tl"]}</td>
    <td>${map["ywg_tl_cost"]}</td>
    <td></td>
</tr>
<tr class="tr_dark">
    <td nowrap>在建项目</td>
    <td>${zj_ykg_size}</td>
    <td></td>
    <td>${map["zj_szdl_ss_zd"]}</td>
    <td>${map["zj_szdl_ss_fzd"]}</td>
    <td>${map["zj_szdl_ss_xj"]}</td>
    <td>${map["zj_szdl_qs"]}</td>
    <td>${map["zj_szdl_cost"]}</td>
    <td>${map["zj_gjjcss_ss"]}</td>
    <td>${map["zj_gjjcss_qs"]}</td>
    <td>${map["zj_gjjcss_cost"]}</td>
    <td>${map["zj_ptdl"]}</td>
    <td>${map["zj_ptdl_cost"]}</td>
    <td>${map["zj_ptgj"]}</td>
    <td>${map["zj_ptgj_cost"]}</td>
    <td>${map["zj_gd_ss_zd"]}</td>
    <td>${map["zj_gd_ss_fzd"]}</td>
    <td>${map["zj_gd_ss_xj"]}</td>
    <td>${map["zj_gd_ss_cost"]}</td>
    <td>${map["zj_nh_ss_zd"]}</td>
    <td>${map["zj_nh_ss_fzd"]}</td>
    <td>${map["zj_nh_ss_xj"]}</td>
    <td>${map["zj_nh_ss_cost"]}</td>
    <td>${map["zj_gk_ss_zd"]}</td>
    <td>${map["zj_gk_ss_fzd"]}</td>
    <td>${map["zj_gk_ss_xj"]}</td>
    <td>${map["zj_gk_ss_cost"]}</td>
    <td>${map["zj_hk_ss_zd"]}</td>
    <td>${map["zj_hk_ss_fzd"]}</td>
    <td>${map["zj_hk_ss_xj"]}</td>
    <td>${map["zj_hk_ss_cost"]}</td>
    <td>${map["zj_tl"]}</td>
    <td>${map["zj_tl_cost"]}</td>
    <td></td>
</tr>
<tr class="tr_dark">
    <td nowrap style="font-weight: bold;" rowspan="5">未开工<br>项目</td>
    <td nowrap style="font-weight: bold;">小计</td>
    <td>${wkg_size}</td>
    <td></td>
    <td>${map["wkg_szdl_ss_zd"]}</td>
    <td>${map["wkg_szdl_ss_fzd"]}</td>
    <td>${map["wkg_szdl_ss_xj"]}</td>
    <td>${map["wkg_szdl_qs"]}</td>
    <td>${map["wkg_szdl_cost"]}</td>
    <td>${map["wkg_gjjcss_ss"]}</td>
    <td>${map["wkg_gjjcss_qs"]}</td>
    <td>${map["wkg_gjjcss_cost"]}</td>
    <td>${map["wkg_ptdl"]}</td>
    <td>${map["wkg_ptdl_cost"]}</td>
    <td>${map["wkg_ptgj"]}</td>
    <td>${map["wkg_ptgj_cost"]}</td>
    <td>${map["wkg_gd_ss_zd"]}</td>
    <td>${map["wkg_gd_ss_fzd"]}</td>
    <td>${map["wkg_gd_ss_xj"]}</td>
    <td>${map["wkg_gd_ss_cost"]}</td>
    <td>${map["wkg_nh_ss_zd"]}</td>
    <td>${map["wkg_nh_ss_fzd"]}</td>
    <td>${map["wkg_nh_ss_xj"]}</td>
    <td>${map["wkg_nh_ss_cost"]}</td>
    <td>${map["wkg_gk_ss_zd"]}</td>
    <td>${map["wkg_gk_ss_fzd"]}</td>
    <td>${map["wkg_gk_ss_xj"]}</td>
    <td>${map["wkg_gk_ss_cost"]}</td>
    <td>${map["wkg_hk_ss_zd"]}</td>
    <td>${map["wkg_hk_ss_fzd"]}</td>
    <td>${map["wkg_hk_ss_xj"]}</td>
    <td>${map["wkg_hk_ss_cost"]}</td>
    <td>${map["wkg_tl"]}</td>
    <td>${map["wkg_tl_cost"]}</td>
    <td></td>
</tr>
<tr class="tr_dark">
    <td nowrap>项目建议书未批</td>
    <td>${map["xmjyswp_szdl_xmnum"]}</td>
    <td></td>
    <td>${map["xmjyswp_szdl_ss_zd"]}</td>
    <td>${map["xmjyswp_szdl_ss_fzd"]}</td>
    <td>${map["xmjyswp_szdl_ss_xj"]}</td>
    <td>${map["xmjyswp_szdl_qs"]}</td>
    <td>${map["xmjyswp_szdl_cost"]}</td>
    <td>${map["xmjyswp_gjjcss_ss"]}</td>
    <td>${map["xmjyswp_gjjcss_qs"]}</td>
    <td>${map["xmjyswp_gjjcss_cost"]}</td>
    <td>${map["xmjyswp_ptdl"]}</td>
    <td>${map["xmjyswp_ptdl_cost"]}</td>
    <td>${map["xmjyswp_ptgj"]}</td>
    <td>${map["xmjyswp_ptgj_cost"]}</td>
    <td>${map["xmjyswp_gd_ss_zd"]}</td>
    <td>${map["xmjyswp_gd_ss_fzd"]}</td>
    <td>${map["xmjyswp_gd_ss_xj"]}</td>
    <td>${map["xmjyswp_gd_ss_cost"]}</td>
    <td>${map["xmjyswp_nh_ss_zd"]}</td>
    <td>${map["xmjyswp_nh_ss_fzd"]}</td>
    <td>${map["xmjyswp_nh_ss_xj"]}</td>
    <td>${map["xmjyswp_nh_ss_cost"]}</td>
    <td>${map["xmjyswp_gk_ss_zd"]}</td>
    <td>${map["xmjyswp_gk_ss_fzd"]}</td>
    <td>${map["xmjyswp_gk_ss_xj"]}</td>
    <td>${map["xmjyswp_gk_ss_cost"]}</td>
    <td>${map["xmjyswp_hk_ss_zd"]}</td>
    <td>${map["xmjyswp_hk_ss_fzd"]}</td>
    <td>${map["xmjyswp_hk_ss_xj"]}</td>
    <td>${map["xmjyswp_hk_ss_cost"]}</td>
    <td>${map["xmjyswp_tl"]}</td>
    <td>${map["xmjyswp_tl_cost"]}</td>
    <td></td>
</tr>
<tr class="tr_dark">
    <td nowrap>工可未批复</td>
    <td>${map["gkwpf_szdl_xmnum"]}</td>
    <td></td>
    <td>${map["gkwpf_szdl_ss_zd"]}</td>
    <td>${map["gkwpf_szdl_ss_fzd"]}</td>
    <td>${map["gkwpf_szdl_ss_xj"]}</td>
    <td>${map["gkwpf_szdl_qs"]}</td>
    <td>${map["gkwpf_szdl_cost"]}</td>
    <td>${map["gkwpf_gjjcss_ss"]}</td>
    <td>${map["gkwpf_gjjcss_qs"]}</td>
    <td>${map["gkwpf_gjjcss_cost"]}</td>
    <td>${map["gkwpf_ptdl"]}</td>
    <td>${map["gkwpf_ptdl_cost"]}</td>
    <td>${map["gkwpf_ptgj"]}</td>
    <td>${map["gkwpf_ptgj_cost"]}</td>
    <td>${map["gkwpf_gd_ss_zd"]}</td>
    <td>${map["gkwpf_gd_ss_fzd"]}</td>
    <td>${map["gkwpf_gd_ss_xj"]}</td>
    <td>${map["gkwpf_gd_ss_cost"]}</td>
    <td>${map["gkwpf_nh_ss_zd"]}</td>
    <td>${map["gkwpf_nh_ss_fzd"]}</td>
    <td>${map["gkwpf_nh_ss_xj"]}</td>
    <td>${map["gkwpf_nh_ss_cost"]}</td>
    <td>${map["gkwpf_gk_ss_zd"]}</td>
    <td>${map["gkwpf_gk_ss_fzd"]}</td>
    <td>${map["gkwpf_gk_ss_xj"]}</td>
    <td>${map["gkwpf_gk_ss_cost"]}</td>
    <td>${map["gkwpf_hk_ss_zd"]}</td>
    <td>${map["gkwpf_hk_ss_fzd"]}</td>
    <td>${map["gkwpf_hk_ss_xj"]}</td>
    <td>${map["gkwpf_hk_ss_cost"]}</td>
    <td>${map["gkwpf_tl"]}</td>
    <td>${map["gkwpf_tl_cost"]}</td>
    <td></td>
</tr>
<tr class="tr_dark">
    <td nowrap>工可己批<br>初设未批复</td>
    <td>${map["gkypcswp_szdl_xmnum"]}</td>
    <td></td>
    <td>${map["gkypcswp_szdl_ss_zd"]}</td>
    <td>${map["gkypcswp_szdl_ss_fzd"]}</td>
    <td>${map["gkypcswp_szdl_ss_xj"]}</td>
    <td>${map["gkypcswp_szdl_qs"]}</td>
    <td>${map["gkypcswp_szdl_cost"]}</td>
    <td>${map["gkypcswp_gjjcss_ss"]}</td>
    <td>${map["gkypcswp_gjjcss_qs"]}</td>
    <td>${map["gkypcswp_gjjcss_cost"]}</td>
    <td>${map["gkypcswp_ptdl"]}</td>
    <td>${map["gkypcswp_ptdl_cost"]}</td>
    <td>${map["gkypcswp_ptgj"]}</td>
    <td>${map["gkypcswp_ptgj_cost"]}</td>
    <td>${map["gkypcswp_gd_ss_zd"]}</td>
    <td>${map["gkypcswp_gd_ss_fzd"]}</td>
    <td>${map["gkypcswp_gd_ss_xj"]}</td>
    <td>${map["gkypcswp_gd_ss_cost"]}</td>
    <td>${map["gkypcswp_nh_ss_zd"]}</td>
    <td>${map["gkypcswp_nh_ss_fzd"]}</td>
    <td>${map["gkypcswp_nh_ss_xj"]}</td>
    <td>${map["gkypcswp_nh_ss_cost"]}</td>
    <td>${map["gkypcswp_gk_ss_zd"]}</td>
    <td>${map["gkypcswp_gk_ss_fzd"]}</td>
    <td>${map["gkypcswp_gk_ss_xj"]}</td>
    <td>${map["gkypcswp_gk_ss_cost"]}</td>
    <td>${map["gkypcswp_hk_ss_zd"]}</td>
    <td>${map["gkypcswp_hk_ss_fzd"]}</td>
    <td>${map["gkypcswp_hk_ss_xj"]}</td>
    <td>${map["gkypcswp_hk_ss_cost"]}</td>
    <td>${map["gkypcswp_tl"]}</td>
    <td>${map["gkypcswp_tl_cost"]}</td>
    <td></td>
</tr>
<tr class="tr_dark">
    <td nowrap>初设已批未开工</td>
    <td>${map["csypwkg_szdl_xmnum"]}</td>
    <td></td>
    <td>${map["csypwkg_szdl_ss_zd"]}</td>
    <td>${map["csypwkg_szdl_ss_fzd"]}</td>
    <td>${map["csypwkg_szdl_ss_xj"]}</td>
    <td>${map["csypwkg_szdl_qs"]}</td>
    <td>${map["csypwkg_szdl_cost"]}</td>
    <td>${map["csypwkg_gjjcss_ss"]}</td>
    <td>${map["csypwkg_gjjcss_qs"]}</td>
    <td>${map["csypwkg_gjjcss_cost"]}</td>
    <td>${map["csypwkg_ptdl"]}</td>
    <td>${map["csypwkg_ptdl_cost"]}</td>
    <td>${map["csypwkg_ptgj"]}</td>
    <td>${map["csypwkg_ptgj_cost"]}</td>
    <td>${map["csypwkg_gd_ss_zd"]}</td>
    <td>${map["csypwkg_gd_ss_fzd"]}</td>
    <td>${map["csypwkg_gd_ss_xj"]}</td>
    <td>${map["csypwkg_gd_ss_cost"]}</td>
    <td>${map["csypwkg_nh_ss_zd"]}</td>
    <td>${map["csypwkg_nh_ss_fzd"]}</td>
    <td>${map["csypwkg_nh_ss_xj"]}</td>
    <td>${map["csypwkg_nh_ss_cost"]}</td>
    <td>${map["csypwkg_gk_ss_zd"]}</td>
    <td>${map["csypwkg_gk_ss_fzd"]}</td>
    <td>${map["csypwkg_gk_ss_xj"]}</td>
    <td>${map["csypwkg_gk_ss_cost"]}</td>
    <td>${map["csypwkg_hk_ss_zd"]}</td>
    <td>${map["csypwkg_hk_ss_fzd"]}</td>
    <td>${map["csypwkg_hk_ss_xj"]}</td>
    <td>${map["csypwkg_hk_ss_cost"]}</td>
    <td>${map["csypwkg_tl"]}</td>
    <td>${map["csypwkg_tl_cost"]}</td>
    <td></td>
</tr>
</table>
<br>
</div>