<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        function loginCheck() {
            loadAjaxDataCallback("loginCheck", "${ctx}/platform/loginCheck.do?account=admin&password=1234&jumpUrl=${ctx}/platform/jump.do?code=jsdwgl&account=admin&name=&type=sg", backThing);
        }

        function backThing(ret) {
            var obj = eval("(" + ret + ")");
            if (obj.success) {
                window.location.href = obj.url;
            }
        }
    });

</script>
<div id="loginCheck"></div>
<br>
<input type="button" class="button_normal_longer" value="测试登录"
       onclick="loginCheck()">
<br><br>
<input type="button" class="button_normal_longer" value="项目信息汇总"
       onclick="window.location.href='${ctx}/platform/jump.do?code=xmxxhz&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="送达回证"
       onclick="window.location.href='${ctx}/platform/jump.do?code=sdhz&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="邮件管理"
       onclick="window.location.href='${ctx}/platform/jump.do?code=yjgl&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="信息发布"
       onclick="window.location.href='${ctx}/platform/jump.do?code=xxfb&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="短信平台"
       onclick="window.location.href='${ctx}/platform/jump.do?code=dxpt&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="外出会议管理"
       onclick="window.location.href='${ctx}/platform/jump.do?code=wchygl&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="内部会议管理"
       onclick="window.location.href='${ctx}/platform/jump.do?code=nbhygl&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="车辆申请"
       onclick="window.location.href='${ctx}/platform/jump.do?code=clsq&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="办公用品库"
       onclick="window.location.href='${ctx}/platform/jump.do?code=bgypk&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="办公用品申请"
       onclick="window.location.href='${ctx}/platform/jump.do?code=bgypsq&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="领导一周工作安排"
       onclick="window.location.href='${ctx}/platform/jump.do?code=ldyzgzap&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="信访管理"
       onclick="window.location.href='${ctx}/platform/jump.do?code=xfgl&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="科室一周工作"
       onclick="window.location.href='${ctx}/platform/jump.do?code=ksyzgz&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="工作督办"
       onclick="window.location.href='${ctx}/platform/jump.do?code=gzdb&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="发文管理"
       onclick="window.location.href='${ctx}/platform/jump.do?code=fwgl&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="收文流程配置"
       onclick="window.location.href='${ctx}/platform/jump.do?code=swlcpz&account=admin&name=&type=sg'">
<br><br>
<input type="button" class="button_normal_longer" value="收文登记单"
       onclick="window.location.href='${ctx}/platform/jump.do?code=swdjd&account=admin&name=&type=sg'">
