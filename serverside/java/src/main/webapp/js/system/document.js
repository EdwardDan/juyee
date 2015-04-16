/****************************************************
 document.js文件
 描述：文档管理子系统中业务文档表单挂接的入口
 前提：要调用document.js中的函数，必须包含function.js，select.js
 方法：
 查看：function viewClientDoc(xmlconfig,documentid)
 新增：function newClientDoc(xmlconfig,tablename,recordid,clientcategoryid,flag,documentcategoryidinput)
 更新：function changeClientDoc(xmlconfig,documentid)
 删除：function deleteClientDoc(tablename,recordid,documentId)
 下载：function downloadClientAttach(documentattachid)
 ****************************************************/

/*
 * 查看文档
 * 参数：xmlconfig—定义每个字段的是否显示(visible属性)、是否只读(readonly属性)、是否有缺省值（元素值）
 documentid—关联文档ID
 * 例如：xmlconfig= "<code visible='true' readonly='false'>1111</origincode>"+	//原始编号
 "<origincode visible='true' readonly='false'>电动机飞机</origincode>"+	//原始编号
 "<name visible='true' readonly='false'>电动机飞机</name>"+							//标题
 "<author visible='true' readonly='false'></author>"+										//作者
 "<keywords visible='true' readonly='false'></keywords>"+								//关键字
 "<abstractcontent visible='true' readonly='false'></abstractcontent>"+		//摘要
 "<description visible='true' readonly='false'></description>"+					//备注
 "<propertyid visible='true' readonly='false'></propertyid>"+//实现阶段
 "<formatid visible='true' readonly='false'></formatid>"+								//文档格式
 "<createuser visible='true' readonly='false'></createuser>"+				//创建时间
 "<lastmodifyuser visible='true' readonly='false'></lastmodifyuser>"+		//最后修改时间
 "<deptid visible='true' readonly='false'></deptid>";				//上传单位ID
 * 结果：
 */
//增加relatecategoryid参数主要为业务文档查看接口调用
function viewDocument(documentid, relatecategoryid)
{
    if (relatecategoryid != null)
        viewClientDoc("", documentid, relatecategoryid);
    else
        viewClientDoc("", documentid);
}
function viewClientDoc(xmlconfig, documentid, relatecategoryid)
{
    var sPath = CONTEXT_NAME + "/file/common/view.html?id=" + documentid + "&xmlconfig=" + xmlconfig;
    if (relatecategoryid != null)
        sPath += "&relatecategoryid=" + relatecategoryid;

    var param = "dialogWidth=800px;dialogHeight=600px;center=yes;help=no";
    showModalDialog(sPath, "", param);
}


/*
 * 新增文档
 * 参数：xmlconfig—同上
 tablaname—挂接表单表名
 recordid—记录ID
 clientcategoryid—业务文档类型ID
 flag—表明是否需要弹出文档目录选择框 flag="true"表示为需要，判定原则：如果业务文档类型下的关联文档分类接点多于1个则为'true'
 documentcategoryidinput—当flag为true时存放选定的文档类型。
 * 结果：
 */
function newClientDoc(xmlconfig, tablename, recordid, flag, clientcategoryid, documentid, documentcategoryidinput, modifiedFlagInput)
{
    if (flag == "true")
    {
        //        selectClientCategory(clientcategoryid, documentcategoryidinput);
    }
    if (isNaN(parseInt(documentcategoryidinput.value)) || documentcategoryidinput.value == "0")
    {
        alert("必须选取文档分类!");
        return null;
    }

    //    alert(documentcategoryidinput.value);
    var url = CONTEXT_NAME + "/file/common/input.html?xmlconfig=" + xmlconfig +
              "&tablename=" + tablename + "&recordid=" + recordid + "&id=" + documentid.value +
              "&categoryid=" + documentcategoryidinput.value + "&date=" + new Date().getSeconds() + "&modifiedFlag=";
    if (modifiedFlagInput.value) {
        url += modifiedFlagInput.value;
    }
    var param = "dialogWidth=800px;dialogHeight=600px;center=yes;help=no";
    var value = showModalDialog(url, "", param);

    if (!value || value.indexOf("mrCancel") == 0)
    {
        return null;
    }
    else
    {
        documentid.value = getIdElement(value);
        modifiedFlagInput.value = "true";
    }
    //    alert(modifiedFlagInput.value);
}

/**
 * 修改图标
 * @param imgObj
 * @param modifiedFlag
 */
function changeDocImg(imgObj,modifiedFlag){
   if(modifiedFlag.value == "true"){
       var img = imgObj.src + "";
       imgObj.src = img.replace("tjfjz.gif","xgfjz.gif");
   }
}

/*
 * 修改文档
 * 参数：xmlconfig—同上
 documentid—关联文档ID
 * 结果：
 */
function changeClientDoc(xmlconfig, documentid, tablename, recordid, modifiedFlagInput)
{
    //    alert(modifiedFlagInput.value);
    var sPath = CONTEXT_NAME + "/file/common/input.html?id=" + documentid +
                "&xmlconfig=" + xmlconfig + "&tablename=" + tablename +
                "&recordid=" + recordid + "&modifiedFlag=" + modifiedFlagInput.value;
    var param = "dialogWidth=800px;dialogHeight=600px;center=yes;help=no";
    var value = showModalDialog(sPath, "", param);
    if (value && !(value.indexOf("mrCancel") == 0))
    {
        modifiedFlagInput.value = "true";
        return getIdElement(value);
    }
    return null;
}

/*
 * 下载文档
 * 参数：documentattachid—文档附件ID
 * 结果：
 */
function downloadAttach(documentattachid)
{
    if (documentattachid == null || documentattachid == "")
    {
        return;
    }
    var param = "width=300,height=200,top=200,left=200,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no";
    //    var url = CONTEXT_NAME+"/file/file_document/FileDocumentDownload.jsp?attachid="+documentattachid;
    var url = CONTEXT_NAME + "/file/fileDocument/download.html?attachmentId=" + documentattachid;
    //直接下载附件必须弹出窗口，否则会报js错误
    var openObj = null;
    if (parent.window)
    {
        if (parent.parent.frames[0])
        {
            if (parent.parent.frames[0].statusfrm)
                openObj = parent.parent.frames[0].statusfrm;
            else if (parent.parent.parent)
            {
                if (parent.parent.parent.frames[0].statusfrm)
                    openObj = parent.parent.parent.frames[0].statusfrm;
            }

        }
    }
    if (null == openObj || "undefined" == openObj)
    {
        if (window.frames["docUploadFrame"])
            openObj = window.frames["docUploadFrame"];
    }
    if (null == openObj || "undefined" == openObj)
    {
        if (window.statusfrm)
            openObj = window.statusfrm;
    }

    if (null != openObj && "undefined" != openObj)
    {
        openObj.location = url;
    }
    else
    {
        window.open(url, "download", param);
    }
}

/*
 * 下载文档(图纸附件)
 * 参数：documentattachid—文档附件ID
 * 结果：
 */
function downloadAttachForBlueprint(documentattachid)
{
    if (documentattachid == null || documentattachid == "")
    {
        return;
    }
    var param = "width=300,height=200,top=200,left=200,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no";
    //    var url = CONTEXT_NAME+"/file/file_document/FileDocumentDownload.jsp?attachid="+documentattachid;
    var url = CONTEXT_NAME + "/design/desBlueprint/download.html?attachmentId=" + documentattachid;
    //直接下载附件必须弹出窗口，否则会报js错误
    var openObj = null;
    if (parent.window)
    {
        if (parent.parent.frames[0])
        {
            if (parent.parent.frames[0].statusfrm)
                openObj = parent.parent.frames[0].statusfrm;
            else if (parent.parent.parent)
            {
                if (parent.parent.parent.frames[0].statusfrm)
                    openObj = parent.parent.parent.frames[0].statusfrm;
            }

        }
    }
    if (null == openObj || "undefined" == openObj)
    {
        if (window.frames["docUploadFrame"])
            openObj = window.frames["docUploadFrame"];
    }
    if (null == openObj || "undefined" == openObj)
    {
        if (window.statusfrm)
            openObj = window.statusfrm;
    }

    if (null != openObj && "undefined" != openObj)
    {
        openObj.location = url;
    }
    else
    {
        window.open(url, "download", param);
    }
}

/*
 * 下载文档
 * 参数：documentattachid—文档附件ID
 * 结果：
 */
function inlineOpenAttach(documentattachid)
{
    if (documentattachid == null || documentattachid == "")
    {
        return;
    }
    var url = CONTEXT_NAME + "/file/file_document/FileDocumentDownload.jsp?openFlag=inline&attachid=" + documentattachid;
    window.open(url, "_blank");
}

/*********************************************简单附件上传 begin***************************************************/
/**
 * 简单附件上传
 * @param attachObj
 * @param attachFileDir
 * @param filterFileExt
 */
function upload(attachObj, attachFileDir, filterFileExt)
{
    var url = CONTEXT_NAME + "/file/common/init.html?attachFileDir=" + attachFileDir + "&filterFileExt=" + filterFileExt;
    var strFeatures = "dialogWidth=540px;dialogHeight=380px;center=yes;help=no";
    var ret = showModalDialog(url, "", strFeatures);
    if (ret == null || ret == "") {
        return;
    }
    attachObj.value = ret;
}
/*
 * 下载文档
 * 参数：documentattachid—文档附件ID
 * 结果：
 */
function uploadDownload(attachFileDir, attachFileName)
{
    if (attachFileDir == null || attachFileName == "")
    {
        return;
    }
    var param = "width=300,height=200,top=200,left=200,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no";
    var url = CONTEXT_NAME + "/file/common/uploadDownload.html?attachFileDir=" + encodeURI(attachFileDir) + "&attachFileName=" + encodeURI(attachFileName);
    //直接下载附件必须弹出窗口，否则会报js错误
    var openObj = statusfrm;
    if (null != openObj && "undefined" != openObj)
    {
        openObj.location = url;
    } else {
        window.open(url, "download", param);
    }
}

function uploadDelte(attachFileObj, deleteObj) {
    if (confirm("是否确定删除？")) {
        attachFileObj.value = "";
        deleteObj.style.display = "none";
        document.getElementById("img_upload_view").style.display = "none";
        var editObj = document.getElementById("img_upload_edit");
        var edit_src = editObj.src;
        editObj.src = edit_src.replace("xgfjz.gif", "tjfjz.gif");
        editObj.style.display = "inline";
    }
}
/*********************************************简单附件上传 end***************************************************/