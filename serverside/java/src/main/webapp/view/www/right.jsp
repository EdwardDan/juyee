<%--<%@ page import="org.springframework.security.web.authentication.AbstractProcessingFilter" %>--%>
<%--&lt;%&ndash;<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@ include file="/common/taglibs.jsp" %>&ndash;%&gt;--%>
<%--<%@include file="common.jsp" %>--%>
<%--<script language=javascript src="${ctx}/js/default.js" type="text/javascript"></script>--%>

<%--<script type="text/javascript">--%>
    <%--$(function () {--%>
        <%--adjustDivPostionCenter("loginDiv");--%>
        <%--<%--%>
            <%--if (session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null) {--%>
        <%--%>--%>

        <%--var errMsg = "${SPRING_SECURITY_LAST_EXCEPTION.message}";--%>
        <%--var emptyErr = "${not empty param.login_error}";--%>
        <%--if (errMsg != "" && emptyErr == "true") {--%>
            <%--showErrorMsg(errMsg);--%>
        <%--}--%>
        <%--<%--%>
            <%--}--%>
        <%--%>--%>
    <%--});--%>
    <%--function submitForm(form) {--%>
        <%--var loginName = document.getElementById("j_username").value;--%>
        <%--var password = document.getElementById("j_password").value;--%>
        <%--var validation_code = document.getElementById("j_validation_code").value;--%>

        <%--if (loginName == null || loginName == "" || loginName == "请输入账号") {--%>
            <%--alert("账号必须输入！");--%>
            <%--document.getElementById("j_username").focus();--%>
            <%--return false;--%>
        <%--}--%>

        <%--if (password == null || password == "" || password == "请输入登录密码") {--%>
            <%--alert("密码必须输入！");--%>
            <%--document.getElementById("j_password").focus();--%>
            <%--return false;--%>
        <%--}--%>

        <%--if (validation_code == null || validation_code == "") {--%>
            <%--alert("验证码必须输入！");--%>
            <%--document.getElementById("j_validation_code").focus();--%>
            <%--return false;--%>
        <%--}--%>

        <%--//预验证--%>
        <%--document.getElementById("btnSub").disabled = true;--%>
        <%--var msg = getAjaxData("${ctx}/site/checkLogin.do?password=" + password + "&userName=" + loginName + "&validateCode=" + validation_code);--%>
        <%--if (!msg.status) {--%>
            <%--reloadImage();--%>
            <%--alert(msg.msg);--%>
            <%--document.getElementById("j_username").focus();--%>
            <%--document.getElementById("btnSub").disabled = false;--%>
            <%--return false;--%>

        <%--} else {--%>
            <%--document.getElementById("btnSub").disabled = true;--%>
            <%--return true;--%>
        <%--}--%>
    <%--}--%>
    <%--//加载验证码--%>
    <%--function reloadImage() {--%>
        <%--document.getElementById("pic").src = "${ctx}/common/imageCode.jsp?p=" + Math.random();--%>
    <%--}--%>

    <%--//清除提示--%>
    <%--var slh_hint = "请输入受理号码";--%>
    <%--function clearHint(input){--%>
       <%--if(input.value == slh_hint){--%>
           <%--input.value = "";--%>
       <%--}--%>
    <%--}--%>
    <%--function addHint(input){--%>
        <%--if(input.value == ""){--%>
            <%--input.value = slh_hint;--%>
        <%--}--%>
    <%--}--%>

    <%--//受理号查询--%>
    <%--function doQuerySlh(btn){--%>
       <%--var code = $("#slh").val();--%>
        <%--if(code ==null || code=="" || code == slh_hint){--%>
            <%--alert(slh_hint+"！");--%>
        <%--}else{--%>
            <%--window.open("${ctx}/site/querySlh.do?code="+code,900,600);--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>
<%--<div class="logintitle"><img src="${ctx}/view/www/images/login.jpg" alt=""/></div>--%>
<%--<div class="login">--%>
    <%--<div class="bg">--%>
        <%--<form id="loginForm" name="loginForm" action="../j_spring_security_check" method="post"--%>
              <%--onsubmit="return submitForm(this)">--%>
            <%--<ul style="height:130px">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${isPlatformUser}">--%>
                        <%--<li>&nbsp;</li>--%>
                        <%--<li class="bottom">--%>
                            <%--&nbsp;${realName}：你已登录！--%>
                            <%--<input type="button" name="btnLogin" id="btnLogin" value="进入" class="but"--%>
                                   <%--onclick="window.location='${ctx}/platform/index.do'"/>--%>
                            <%--<input type="hidden" name="loginRefer" value="site">--%>
                        <%--</li>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<li>--%>
                            <%--帐&nbsp;&nbsp;&nbsp;号：<input type="text" name="j_username" id="j_username" class="input"--%>
                                                        <%--style="width: 145px;" maxlength="30"--%>
                                                        <%--value="<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>"/>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--密&nbsp;&nbsp;&nbsp;码：<input type="password" name="j_password" id="j_password" class="input"--%>
                                                        <%--style="width: 80px" maxlength="30"/>--%>
                            <%--<span style="cursor:pointer" onclick="window.open('${ctx}/site/regGetPass.do')">找回密码</span>--%>
                        <%--</li>--%>
                        <%--<li style="vertical-align:middle;">--%>
                            <%--验证码：<input type="text" name="j_validation_code" id="j_validation_code" class="input"--%>
                                       <%--maxlength="4" style="display:inline-block;vertical-align:middle; width: 80px;"/>--%>
                            <%--<img id="pic" src="${ctx}/common/imageCode.jsp" height="20" onclick="reloadImage()"--%>
                                 <%--title="点击更换图片" style="vertical-align:middle;cursor:pointer" alt="">--%>
                                <%--&lt;%&ndash;<span onclick="reloadImage()" style="cursor:pointer">换一张</span>&ndash;%&gt;--%>
                        <%--</li>--%>
                        <%--<li class="bottom">--%>
                            <%--<input type="submit" name="btnSub" id="btnSub" value="登 录" class="but"--%>
                                   <%--style="margin-left:25px"/>--%>
                            <%--<input type="reset" name="btnReset" id="btnReset" value="重 写" class="but"/>--%>
                            <%--<input type="hidden" name="loginRefer" value="site">--%>
                            <%--<a href="javascript:void(0)" onclick="window.open('${ctx}/site/reg.do')"--%>
                               <%--style="text-decoration:underline">用户注册</a>--%>
                                <%--&lt;%&ndash;<input type="button" name="btnReg" id="btnReg" value="注 册" class="but" onclick="window.open('${ctx}/site/reg.do')"/>&ndash;%&gt;--%>
                        <%--</li>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</ul>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<div class="ggl">--%>
    <%--<div class="one">&nbsp;&nbsp;--%>
        <%--<marquee scrolldelay="300" direction="up" height="90%" width="90%" onmouseover="this.stop()"--%>
                 <%--onmouseout="this.start()">--%>
            <%--<c:forEach items="${gonggao}" var="bean">--%>
                <%--<div><a href="javascript:void(0)"--%>
                        <%--onclick="viewInfo(${bean.id},'${OA_PUBLIC_INFO_TYPE_BULLETIN}')"--%>
                        <%--title="${bean.title}"><sys:cutString--%>
                        <%--length="100">${bean.title}</sys:cutString></a></div>--%>
            <%--</c:forEach>--%>
        <%--</marquee>--%>
    <%--</div>--%>


    <%--&lt;%&ndash;<div class="kstd">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div><img src="${ctx}/view/www/images/kstd.jpg" width="247" height="29" alt=""/></div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="kuang"><img src="${ctx}/view/www/images/kstd1.jpg" alt="" width="242" height="185" border="0"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;usemap="#Mapp"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<map name="Mapp" id="Mapp">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<area shape="rect" coords="5,4,121,45"&ndash;%&gt;--%>
                      <%--&lt;%&ndash;href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_INTRODUCTION}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<area shape="rect" coords="124,4,235,46" href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_NEWS}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<area shape="rect" coords="5,47,121,86" href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_WORK}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<area shape="rect" coords="123,47,235,88"&ndash;%&gt;--%>
                      <%--&lt;%&ndash;href="${ctx}/site/list.do?type=${OA_PUBLIC_INO_TYPE_PARTYMEMBER}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<area shape="rect" coords="6,90,121,130" href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_POLICY}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<area shape="rect" coords="124,90,237,130"&ndash;%&gt;--%>
                      <%--&lt;%&ndash;href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_BULLETIN}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<area shape="rect" coords="8,132,121,172" href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_PIC}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<area shape="rect" coords="124,132,235,172"&ndash;%&gt;--%>
                      <%--&lt;%&ndash;href="${ctx}/site/list.do?type=${OA_PUBLIC_INFO_TYPE_STANDARD}"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</map>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<div class="kstd" style="background-color: #FAFAFA">--%>
        <%--<div><img src="${ctx}/view/www/images/wsbsdt_1.jpg" width="247" height="29" alt=""/></div>--%>
        <%--<div class="kuang">--%>
            <%--<table cellspacing="0" cellpadding="0" border="0" width="100%">--%>
                <%--<tr>--%>
                    <%--<td align="center" style="padding-top: 3px">--%>
                        <%--<a href="${ctx}/view/www/wsbsdt.jsp"><img src="${ctx}/view/www/images/wsbsdt_2.jpg" alt="" width="240" height="69" border="0"></a>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr><td align="left" style="padding-left: 8px"><img src="${ctx}/view/www/images/wsbsdt_3.jpg" alt="" width="121" height="41" border="0"></td></tr>--%>
                <%--<tr>--%>
                    <%--<td height="40" align="left" style="padding-left: 10px">--%>
                    <%--<input type="text" name="slh" id="slh" class="wsbsdt_input" style="width: 140px;color: #708090;" maxlength="30" value="请输入受理号码" onclick="clearHint(this)" onblur="addHint(this)">--%>
                        <%--<input type="button" value="查询" onclick="doQuerySlh(this)" class="button"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr><td height="10"></td></tr>--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="yqlj">--%>
        <%--<div class="kuang">--%>
            <%--<ul>--%>
                <%--<li><a href="http://www.shucm.sh.cn/gb/jsjt2009/node696/node1513/zbxx/index.html" target="_blank"><img--%>
                        <%--src="${ctx}/view/www/images/wsbs_1.jpg" border="0"/></a></li>--%>
                <%--<li><a href="http://www.shucm.sh.cn/gb/jsjt2009/node696/node1513/zbjg/index.html" target="_blank"><img--%>
                        <%--src="${ctx}/view/www/images/wsbs_2.jpg" border="0"/></a></li>--%>
                <%--<li><a href="http://www.ciac.sh.cn/zxfw_new_xm.aspx" target="_blank"><img--%>
                        <%--src="${ctx}/view/www/images/wsbs_3.jpg" border="0"/></a></li>--%>
                <%--<li><a href="http://www.ciac.sh.cn/zxfw_new_qy.aspx" target="_blank"><img--%>
                        <%--src="${ctx}/view/www/images/wsbs_4.jpg" border="0"/></a></li>--%>
                <%--<li><a href="http://www.ciac.sh.cn/zxfw_new_ry.aspx" target="_blank"><img--%>
                        <%--src="${ctx}/view/www/images/wsbs_5.jpg" border="0"/></a></li>--%>
                <%--<li><a href="http://www.ciac.sh.cn/zxfw_new_jc.aspx" target="_blank"><img--%>
                        <%--src="${ctx}/view/www/images/wsbs_6.jpg" border="0"/></a></li>--%>
            <%--</ul>--%>
        <%--</div>--%>
        <%--<div class="clr"></div>--%>
    <%--</div>--%>
<%--</div>--%>



