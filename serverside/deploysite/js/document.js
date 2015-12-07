var fileUploadId = "fileUpload";
function downloadDoc(id, secondDir) {
    secondDir = secondDir || "";
    var url = CONTEXT_NAME + "/docCommon/downloadByAttachmentId.do?attachmentId=" + id + "&secondDir=" + secondDir;
    var targetIframe = "fileDownLoadTargetIframe";
    if (!window.frames[targetIframe]) {
        var iframe = $(createFrame("", "fileDownLoadTargetIframe"));
        $("body").append($(iframe).hide());
    }
    window.frames[targetIframe].location = url;
}

function uploadDoc(xmlconfig, bizCodeEle, docIdEle, userId, secondDir) {
    var bizCode = "";
    if (bizCodeEle.length == 1) {
        bizCode = bizCodeEle.val();
    }
    var docId = "";
    if (docIdEle.length == 1) {
        docId = docIdEle.val();
    }
    var params = "xmlConfig=" + xmlconfig + "&bizCode=" + bizCode
        + "&userId=" + userId + "&secondDir=" + secondDir;
    var isNewDoc = false;
    if (!docId) {
        isNewDoc = true;
        var rs = $.ajax({
            url:CONTEXT_NAME + "/docCommon/getDocument.do?" + params,
            async:false,
            success:function (data) {
                docId = data;
                $(docIdEle).val(data);
            }
        });
    }
    params += "&docId=" + docId;
    var url = CONTEXT_NAME + "/docCommon/add.do?" + params;
    openIframeWindow(null, "附件上传", url, isNewDoc, docIdEle, bizCodeEle, 600, 300);
}

function openIframeWindow(windowId, title, url, isNewDoc, docIdEle, bizCodeEle, width, height) {
    if (windowId == null) windowId = fileUploadId;
    if ($('#' + windowId).length <= 0) {
        $("body").append("<div id=\"" + windowId + "\"></div>");
    }
    if (width == null) width = 750;
    if (height == null) height = 500;
    var left = ($(window).width() - width) * 0.5 + 20;
    var top = ($(window).height() - height) * 0.5 - 10;
    $('#' + windowId).window({
        title:title,
        loadingMessage:"正在加载数据......",
        iconCls:"icon-edit",
        width:width,
        height:height,
        left:left,
        top:top,
        content:createFrame(url, windowId + "iframe"),
        modal:true,
        shadow:true,
        minimizable:false,
        maximizable:true,
        closed:true,
        resizable:true,
        onClose:function () {
            if (isNewDoc && docIdEle.val()) {
                $.get(CONTEXT_NAME + "/docCommon/getDelIsNull.do?docId=" + docIdEle.val(), function (msg) {
                    msg = eval("(" + msg + ")");
                    if (msg.success) {
                        docIdEle.val('');
                    }
                });
//                refreshWindow();
            }
        }
    });
//    $('#'+newWindowId).show();
    $('#' + windowId).window('open');
//    $('#' + windowId).window("refresh");
}