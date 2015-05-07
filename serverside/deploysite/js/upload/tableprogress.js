
function TableProgress(file, target) {
    this.fileProgressID = file.id;
    this.opacity = 100;
    this.height = 0;
    this.target = target;
    this.fileProgressWrapper = document.getElementById(this.fileProgressID);
    if (!this.fileProgressWrapper) {
        this.fileProgressWrapper = document.createElement("tr");
        this.fileProgressWrapper.id = this.fileProgressID;
        this.fileProgressWrapper.style.height = "25px";
        this.fileProgressElement = document.createElement("div");
        this.fileProgressElement.className = "progressContainer";

        var progressCancel = document.createElement("a");
        progressCancel.className = "progressCancel";
        progressCancel.href = "#";
        progressCancel.style.visibility = "hidden";
        progressCancel.appendChild(document.createTextNode(" "));

        var progressText = document.createElement("div");
        progressText.className = "progressName";
        progressText.appendChild(document.createTextNode(file.name));


        var progressBar = document.createElement("div");
        progressBar.className = "progressBarInProgress";

        var progressStatus = document.createElement("div");
        progressStatus.className = "progressBarStatus";
        progressStatus.innerHTML = "&nbsp;";

        this.fileProgressElement.appendChild(progressCancel);
        this.fileProgressElement.appendChild(progressText);
        this.fileProgressElement.appendChild(progressStatus);
        this.fileProgressElement.appendChild(progressBar);

        var div = $('<div style="width:'+target.settings.width*0.25+'px; text-align: left;" class="datagrid-cell"/>');
        var td = $("<td/>");

        div.append($(this.fileProgressElement));
        td.append(div);

        $(this.fileProgressWrapper).append(td);
        //        this.fileProgressWrapper.appendChild(td.get(0));
        this.addTds(this.fileProgressWrapper);
        target.ui.addProgress(this.fileProgressWrapper);

    } else {
        this.fileProgressElement = $(this.fileProgressWrapper).find(".datagrid-cell").get(0).firstChild;
        this.reset();
    }

    this.height = this.fileProgressWrapper.offsetHeight;
    this.setTimer(null);

}

TableProgress.prototype.setTimer = function (timer) {
    this.fileProgressElement["FP_TIMER"] = timer;
};
TableProgress.prototype.getTimer = function (timer) {
    return this.fileProgressElement["FP_TIMER"] || null;
};

TableProgress.prototype.reset = function () {
    this.fileProgressElement.className = "progressContainer";

    this.fileProgressElement.childNodes[2].innerHTML = "&nbsp;";
    this.fileProgressElement.childNodes[2].className = "progressBarStatus";

    this.fileProgressElement.childNodes[3].className = "progressBarInProgress";
    this.fileProgressElement.childNodes[3].style.width = "0%";

    this.appear();
};

TableProgress.prototype.setProgress = function (percentage) {
    this.fileProgressElement.className = "progressContainer green";
    this.fileProgressElement.childNodes[3].className = "progressBarInProgress";
    this.fileProgressElement.childNodes[3].style.width = percentage + "%";

    this.appear();
};
TableProgress.prototype.setComplete = function (value,deleteUrl,downloadUrl,callBack) {
    var target = this.target;
    var parentNode = this.fileProgressElement.parentNode;
    var fileName = this.fileProgressElement.childNodes[1].innerHTML;
    if(value!=null){
        var settings = {attachmentId:value,fileName:fileName,deleteUrl:deleteUrl,downloadUrl:downloadUrl};
        parentNode.replaceChild(callBack.call(this,settings),this.fileProgressElement);
        var del = $("<a style='text-decoration:underline;cursor:hand;'>删除</a>");
        var wrap = this.fileProgressWrapper;
        del.click(function(){
            $.ajax({ type:"post", url: deleteUrl, data: {attachmentId:value},success: function(){
                $(wrap).remove();
                target.settings.height = target.settings.height - 26;
                target.ui.reSize();
            } });
        });
        $(this.fileProgressWrapper).find("td:last").children().append(del);
    }
};
TableProgress.prototype.setError = function () {
    this.fileProgressElement.className = "progressContainer red";
    this.fileProgressElement.childNodes[3].className = "progressBarError";
    this.fileProgressElement.childNodes[3].style.width = "";

    var oSelf = this;
    this.setTimer(setTimeout(function () {
        oSelf.disappear();
    }, 5000));
};
TableProgress.prototype.setCancelled = function () {
    this.fileProgressElement.className = "progressContainer";
    this.fileProgressElement.childNodes[3].className = "progressBarError";
    this.fileProgressElement.childNodes[3].style.width = "";

    var oSelf = this;
    this.setTimer(setTimeout(function () {
        oSelf.disappear();
    }, 2000));
};
TableProgress.prototype.setStatus = function (status) {
    this.fileProgressElement.childNodes[2].innerHTML = status;
};

// Show/Hide the cancel button
TableProgress.prototype.toggleCancel = function (show, swfUploadInstance) {
    this.fileProgressElement.childNodes[0].style.visibility = show ? "visible" : "hidden";
    if (swfUploadInstance) {
        var fileID = this.fileProgressID;
        this.fileProgressElement.childNodes[0].onclick = function () {
            swfUploadInstance.cancelUpload(fileID);
            return false;
        };
    }
};

TableProgress.prototype.appear = function () {
    if (this.getTimer() !== null) {
        clearTimeout(this.getTimer());
        this.setTimer(null);
    }

    if (this.fileProgressWrapper.filters) {
        try {
            this.fileProgressWrapper.filters.item("DXImageTransform.Microsoft.Alpha").opacity = 100;
        } catch (e) {
            // If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
            this.fileProgressWrapper.style.filter = "progid:DXImageTransform.Microsoft.Alpha(opacity=100)";
        }
    } else {
        this.fileProgressWrapper.style.opacity = 1;
    }

    this.fileProgressWrapper.style.height = "";

    this.height = this.fileProgressWrapper.offsetHeight;
    this.opacity = 100;
    this.fileProgressWrapper.style.display = "";

};

// Fades out and clips away the FileProgress box.
TableProgress.prototype.disappear = function () {

    var reduceOpacityBy = 15;
    var reduceHeightBy = 4;
    var rate = 30;	// 15 fps

    if (this.opacity > 0) {
        this.opacity -= reduceOpacityBy;
        if (this.opacity < 0) {
            this.opacity = 0;
        }

        if (this.fileProgressWrapper.filters) {
            try {
                this.fileProgressWrapper.filters.item("DXImageTransform.Microsoft.Alpha").opacity = this.opacity;
            } catch (e) {
                // If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
                this.fileProgressWrapper.style.filter = "progid:DXImageTransform.Microsoft.Alpha(opacity=" + this.opacity + ")";
            }
        } else {
            this.fileProgressWrapper.style.opacity = this.opacity / 100;
        }
    }

    if (this.height > 0) {
        this.height -= reduceHeightBy;
        if (this.height < 0) {
            this.height = 0;
        }

        this.fileProgressWrapper.style.height = this.height + "px";
    }

    if (this.height > 0 || this.opacity > 0) {
        var oSelf = this;
        this.setTimer(setTimeout(function () {
            oSelf.disappear();
        }, rate));
    } else {
        this.fileProgressWrapper.style.display = "none";
        this.setTimer(null);
    }
};

TableProgress.prototype.addTds = function(tr){
    var tds = $(['<td>',
        '<div style="width:'+this.target.settings.width*0.25+'px; text-align: left;" class="datagrid-cell "><input type="text" field="summary"></div>',
        '</td>','<td>',
        '<div style="width:'+this.target.settings.width*0.2+'px; text-align: left;" class="datagrid-cell "><input type="text" field="author"></div>',
        '</td>','<td>',
        '<div style="width:'+this.target.settings.width*0.15+'px; text-align: left;" class="datagrid-cell "><input type="checkbox" field="isRead"></div>',
        '</td>','<td>',
        '<div style="width:'+this.target.settings.width*0.15+'px; text-align: left;" class="datagrid-cell "><a></a></div>',
        '</td>'
    ].join(""));
    $(tr).append(tds);
};