<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<head>
    <%--<object classid="clsid:4B3CB088-9A00-4D24-87AA-F65C58531039" id="SynCardOcx1"--%>
    <%--codeBase="${ctx}/tools/SynCardOcx.CAB#version=1,0,0,1" width="0" height="0">--%>
    <%--</object>--%>
    <%--<object id="CardReader1" codebase="${ctx}/tools/FirstActivex.cab#version=1,3,1,1"--%>
    <%--classid="CLSID:F225795B-A882-4FBA-934C-805E1B2FBD1B"--%>
    <%--width="102" height="126">--%>
    <%--<param name="_Version" value="65536"/>--%>
    <%--<param name="_ExtentX" value="2646"/>--%>
    <%--<param name="_ExtentY" value="1323"/>--%>
    <%--<param name="_StockProps" value="0"/>--%>
    <%--</object>--%>
    <script type="text/javascript">
        var formId = "bean";
        var time;
        $(function () {
            //页面验证初始化
            var validateCondition = [
                {name: "name", rule: "validate[required,maxSize[25]]"},
                {name: "sex", rule: "validate[required,maxSize[1]]"},
                {name: "cardNo", rule: "validate[required,custom[onlyLetterNumber],minSize[10],maxSize[18]]"},
                {name: "mobile", rule: "validate[required,custom[mobile]]"},
                {name: "certificateCode", rule: "validate[maxSize[25]]"},
                {name: "certificateName", rule: "validate[maxSize[50]]"},
                {name: "positionType", rule: "validate[required]"}
            ];
            validateInit(validateCondition, formId);
            $("#ocxPhoto").hide();
            <c:if test="${empty bean.id}">
            $("#positionType").get(0).selectedIndex = 1;
            </c:if>

        });
        function viewFinger(id) {
            var v = document.all ? 'IE' : 'others';
            if (v != 'IE') {
                showErrorMsg("您当前的浏览器不支持该功能，<br/>请使用IE浏览器！");
                return;
            }

            if (id == null) {
                showErrorMsg("请先保存信息再采集指纹!");
            }
            else {
                openWindow("指纹信息表", "${ctx}/checkFingerPrint/modify.do?id=" + id, true);
            }
        }
        var isInit = false;
        var isBlank;
        function scanIdCard() {
            var obj = document.getElementById("CardReader1");
            if (false == isInit) {
//设置端口号，1表示串口1，2表示串口2，依此类推；1001表示USB。0表示自动选择
                obj.setPortNum(0);
                isInit = true;
            }
            obj.Flag = 0;
            //obj.BaudRate=115200;
//设置照片保存路径，照片文件名：(身份证号).bmp。默认路径为系统临时目录,照片文件名：image.bmp
//读卡
            var rst = obj.ReadCard();
//获取各项信息,当rst为0x90的时候为正常读取
            if (0x90 == rst) {
                $("#ocxPhoto").show();
                $("#tPhoto").hide();
                document.getElementById("name").value = obj.NameL();
                document.getElementById("cardNo").value = obj.CardNo();
                document.getElementById("photoFile").value = "/${IDCARD_IMAGE_PATH}/" + obj.CardNo() + ".jpg";
//                    document.getElementById("image").innerHTML = "<img src='" + SynCardOcx1.PhotoName + "'/>";
                document.getElementById("image").value = obj.GetImage();
                if (obj.Sex() == 1) {
                    document.getElementById("sex1").checked = true;
                } else {
                    document.getElementById("sex2").checked = true;
                }
            }
            isBlank = document.getElementById("image").value.length;
            //当读到照片为空白时,自动重读
            if (isBlank == 1136) {
                scanIdCard();
            }
        }
        //保存操作
        function save(btn) {
            clearInterval(time);
            disableBtn(btn);

            if (!validateForm(formId)) {
                enableBtn(btn);
                return;
            }

            if (!checkCardNo()) {
                enableBtn(btn);
                return;
            }

            var positionTypeId = $("#positionType").val();
            saveAjaxData("${ctx}/checkManager/save.do?gdCode=${gdCode}&jdTaskCode=${jdTaskCode}&positionTypeId=" + positionTypeId, formId, true);

        }
        function fingerPrint(id) {
            openWindow("指纹信息表", "${ctx}/checkFingerPrint/modify.do?id=" + id, true);
        }

        //根据身份证号检查考勤人员是否已经在其他工地注册，或者已经该工地下注册。
        function checkCardNo() {
            var v = $("#cardNo");
            v.val($.trim(v.val()));
            var id = $("#id").val();

            if (v != null && v != "") {
                var msg = getAjaxData("${ctx}/checkManager/checkCardNo.do?gdCode=${gdCode}&jdTaskCode=${jdTaskCode}&cardNo=" + v.val() + "&id=" + id);
                if (msg.success == "warning") {
                    showInfoMsg("注意：该人员已经在“" + msg.msg + "”工地下注册！");
                    return true;
                } else if (msg.success == "error") {
                    showErrorMsg("身份证号为：“" + v.val() + "”的人员已经在该工地下注册！");
                    return false;
                }
            }
            return true;
        }

        /**
         * 去除select中重复的选项。
         */
        function removeRepeat() {
            var select = document.getElementById("positionType");
            removeRepeatOption(select);
        }

        //        if (str > 0) {
        //            time = setInterval("scanIdCard()", 2000);
        //        }
        function changeDevice(id) {
            if (null == id) {
                openWindow("添加管理人员表", "${ctx}/checkManager/add.do?gdCode=${gdCode}&jdTaskCode=${jdTaskCode}&sWitch=xz", true);
            } else {
                openWindow("修改管理人员表", "${ctx}/checkManager/modify.do?id=${id}&gdCode=${gdCode}&jdTaskCode=${jdTaskCode}&sWitch=xz", true);
            }
        }
    </script>

</head>
<body>
<form:form commandName="bean">
    <input type="hidden" id="id" name="id" value="${bean.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">

            <tr class="tr_dark">
                <td class="form_label_right" width="12%">监督任务书编号：</td>
                <td class="form_content" width="39%">
                    &nbsp;
                        ${jdTaskCode}
                </td>

                <td class="form_label_right" width="10%">工地编号：</td>
                <td class="form_content">
                    &nbsp;
                        ${gdCode}
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">工地名称：</td>
                <td class="form_content">
                    &nbsp;
                        ${gdName}
                </td>

                <td class="form_label_right">工程名称：</td>
                <td class="form_content">
                    &nbsp;
                        ${projectName}
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right" width="12%">姓名：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>

                <td class="form_label_right" width="10%">性别：</td>
                <td class="form_content">
                    <form:radiobutton path="sex" value="${male}"/>男
                    <form:radiobutton path="sex" value="${female}"/>女

                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">岗位：</td>
                <td class="form_content">
                    <sys:code code="${positionType}" name="positionType" type="select" defaultName=""
                              sysCodeDetailId="${checkManagerPosition.positionType.id}" disabled="" id="positionType"
                              isAlowedNull="true"
                              onChange=""/>
                </td>

                <td class="form_label_right">身份证号：</td>
                <td class="form_content">
                    <form:input path="cardNo" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">手机号码：</td>
                <td class="form_content">
                    <form:input path="mobile" cssClass="input_text"/>
                </td>

                <td class="form_label_right">采集日期：</td>
                <td class="form_content">
                    &nbsp;
                </td>
            </tr>

                <%--<tr class="tr_light">--%>
                <%--<td class="form_label_right">身份证照片：</td>--%>
                <%--<td class="form_content" colspan="3">--%>
                <%--&nbsp;<input type="file" name="file" id="file" class="input_light">&nbsp;--%>

                <%--</td>--%>
                <%--</tr>--%>

            <tr class="tr_dark">
                <td class="form_label_right">照片：</td>
                <td class="form_content">
                        <%--&nbsp;<input type="button" value="拍照" class="button_normal" onclick="">&nbsp;--%>
                        <%--<input type="button" value="选择照片" class="button_normal_long" onclick="">&nbsp;--%>
                    <input type="button" value="扫描身份证" class="button_normal_long" onclick="scanIdCard()">&nbsp;
                        <%--<input type="button" value="切换为新中身份证阅读器" class="button_normal_long" style="width: 140px;background-repeat: repeat-x;"  onclick="changeDevice(${id})">&nbsp;--%>
                    <input type="hidden" value="${bean.photoFile}" name="photoFile" id="photoFile">&nbsp;
                </td>

                <td class="form_label_right">岗位证书：</td>
                <td class="form_content">
                    &nbsp;${uploadButtonImage}&nbsp;证书扫描件
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right" rowspan="5">&nbsp;<input type="hidden" name="image" id="image" value="">
                </td>
                <td class="form_content" rowspan="5" style="width: 180px; height: 140px">
                    <div id="ocxPhoto">
                        <object id="CardReader1" codebase="${ctx}/tools/FirstActivex.cab#version=1,3,3,1"
                                classid="CLSID:F225795B-A882-4FBA-934C-805E1B2FBD1B"
                                width="102" height="126">
                            <param name="_Version" value="65536"/>
                            <param name="_ExtentX" value="2646"/>
                            <param name="_ExtentY" value="1323"/>
                            <param name="_StockProps" value="0"/>
                        </object>
                    </div>
                    <div id="tPhoto">
                        <c:if test="${not empty photoFile}"><img src="${ctx}/uploads/doc${photoFile}"></c:if>
                    </div>
                    &nbsp;
                </td>

                <td class="form_label_right">证书编号：</td>
                <td class="form_content">
                    <input type="text" id="certificateCode" name="certificateCode"
                           value="${checkManagerPosition.certificateCode}"
                           class="input_text">
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">证书名称：</td>
                <td class="form_content">
                    <input type="text" id="certificateName" name="certificateName"
                           value="${checkManagerPosition.certificateName}"
                           class="input_text">
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">&nbsp;</td>
                <td class="form_content">
                    &nbsp;
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">&nbsp;</td>
                <td class="form_content">
                    &nbsp;
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">&nbsp;</td>
                <td class="form_content">
                    &nbsp;
                </td>
            </tr>


                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label_right">&nbsp;</td>--%>
                <%--&lt;%&ndash;<td class="form_content">&ndash;%&gt;--%>
                <%--&lt;%&ndash;</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td class="form_content_center" rowspan="4" style="width: 1in;"><img src="${ctx}${bean.photo}" width="100px"&ndash;%&gt;--%>
                <%--&lt;%&ndash;height="140px"/></td>&ndash;%&gt;--%>
                <%--<td class="form_content" style="width: 180px; height: 140px"><img src="${ctx}${photo}" width="180px" height="140px"/>--%>
                <%--</td>--%>

                <%--<td class="form_label_right">&nbsp;</td>--%>
                <%--<td class="form_content" style="width: 180px; height: 140px"><img src="${ctx}${photo}" width="180px" height="140px"/>--%>
                <%--</td>--%>
                <%--</tr>--%>

            <tr class="tr_button">
                <td class="form_border" colspan="4">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="关闭" class="button_cancel"
                           onclick="clearInterval(time);closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
</body>