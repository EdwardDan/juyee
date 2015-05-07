(function($){
    $.fn.uploadGrid = function(settings){
        settings = $.extend({
            height: 80, //default height
            width: 800, //default width
            minwidth: 30, //min width of columns
            minheight: 80, //min height of columns
            resizable: true, //resizable table
            url: false, //ajax url
            method: 'POST', // data sending method
            dataType: 'json', // type of data loaded
            errormsg: 'Connection Error',
            title: '附件列表',
            params:{}
        }, settings);
        this.settings = settings;
        var grid = this;
        var ui = {
            init:function(){
                $(ui.header).addClass("panel-header");
                $(ui.title).addClass("panel-title").html('<span id="'+settings.placeHolderId+'">文件上传</span>'+
                        '<input id="'+settings.cancelId+'" type="button" value="取消上传" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" /> ');
                var save = $('<input id="'+settings.saveId+'" type="button" value="保存"  style="margin-left: 2px; height: 22px; font-size: 8pt;" /> ');
                $(ui.title).append(save);
                save.click(function(){ui.save()});
                $(ui.header).append($(ui.title));
                $(grid).append($(ui.header));
                $(grid).append($( '<input type="hidden" id="upload_code"><input type="hidden" name="documentId" id="documentId">'));
                $(ui.body).addClass("layout-body panel-body").append($(ui.gridWraper).addClass("datagrid-view"));
                $(ui.gridWraper).append($(ui.gridView).addClass("datagrid-view2"));
                $(ui.gridView).append($(ui.gridHeader).addClass("datagrid-header"));
                $(ui.gridHeader).append($(ui.gridInner).addClass("datagrid-header-inner"));
                $(ui.gridInner).append($(ui.gridTable).attr("border",0).attr("cellpadding",0).attr("cellspacing",0).attr("style","height: 26px;"));
                $(ui.datagrid).addClass("datagrid-body").append($(ui.dataTable).attr("border",0).attr("cellpadding",0).attr("cellspacing",0));
                $(grid).append($(ui.body));
                $(ui.gridView).append($(ui.datagrid));
                this.createHeader([{name:"文件名",width:0.25},{name:"摘要",width:0.25},{name:"作者",width:0.2},{name:"是否只读",width:0.15},{name:"操作",width:0.15}] );
            },

            createHeader:function(datas){
                var tr = $("<tr/>");
                $(datas).each(function(index){
                    var td = $(['<td class="" field="displayName">',
                        '<div style="width:'+settings.width*datas[index].width+ 'px; text-align: left; cursor: default;" class="datagrid-cell">',
                        '<span>'+datas[index].name+'</span>',
                        '<span class="datagrid-sort-icon">&nbsp;</span>',
                        '</div> </td>'].join(""));
                    tr.append(td);
                });
                $(ui.gridTable).append(tr);
            },

            reSize:function(){
                $(ui.header).attr("style","width:"+(grid.settings.width+4)+"px");
                $(ui.body).attr("style","width:"+(grid.settings.width+4)+"px;height:"+(grid.settings.height)+"px;");
                $(ui.gridWraper).attr("style","width:"+(grid.settings.width+2)+"px;height:"+(grid.settings.height-20)+"px;");
                $(ui.gridView).attr("style","width:"+(grid.settings.width)+"px;left:0px");
                $(ui.gridHeader).attr("style","width:"+(grid.settings.width)+"px;height:24.9px;");
                $(ui.datagrid).attr("style","width:"+(grid.settings.width)+"px;height:"+(grid.settings.height-20)+"px;");
            },
            appendTo:function(body){
                $(body).append($(ui.header));
            },

            addRow:function(datas){
                $(ui.dataTable).append(this.createRow(datas));
            },

            createRow:function(datas){
                var tr = $("<tr/>").attr("style","height: 25px;");
                $(datas).each(function(index){
                    var td = $(['<td>',
                        '<div style="width:'+settings.width*datas[index].width+'px; text-align: left;" class="datagrid-cell ">'+datas[index].name+'</div>',
                        '</td>'].join(""));
                    tr.append(td);
                });
                return tr;
            },

            addProgress:function(progress){
                $(ui.dataTable).append($(progress));
                grid.settings.height =  grid.settings.height + 29;
                this.reSize();
            },

            save:function(){
                var trs = $(ui.dataTable).find("tr");
                var datas = [];
                $(trs).each(function(index){
                    var documentId = $(this).find("td:first").find("a").attr("id");
                    var data = [];
                    if(documentId){
                        data.push(documentId.split("_")[1]);
                        data.push($(this).find("td:eq(1)").find("input").attr("value"));
                        data.push($(this).find("td:eq(2)").find("input").attr("value"));
                        data.push( $(this).find("td:eq(3)").find("input").attr("checked"));
                        datas.push(data.join(","));
                    }
                });
                $.ajax({
                    type:"post",
                    url: settings.saveUrl,
                    data: {datas:datas.join("|")},
                    dataType: 'json',
                    success: function(d){
                        alert("保存成功");
                    },
                    error: function() {alert("加载失败")}
                })
            },

            createRows:function(params){
                var attachmentId = params.attachmentId;
                var tr = $("<tr/>").attr("style","height: 25px;");
                var td =$("<td/>").append($('<div style="width:'+settings.width*0.25+'px; text-align: left;" class="datagrid-cell "/>')).append(createTableTr(params));
                tr.append($(td));
                var tds = $(['<td>',
                    '<div style="width:'+settings.width*0.25+'px; text-align: left;" class="datagrid-cell "><input type="text" field="summary" value="'+params.summary+'"></div>',
                    '</td>','<td>',
                    '<div style="width:'+settings.width*0.2+'px; text-align: left;" class="datagrid-cell "><input type="text" field="author" value="'+params.author+'"></div>',
                    '</td>','<td>',
                    '<div style="width:'+settings.width*0.15+'px; text-align: left;" class="datagrid-cell "><input type="checkbox" field="isRead"' +(params.readOnly==1?"checked":"")+'></div>',
                    '</td>','<td>',
                    '<div style="width:'+settings.width*0.15+'px; text-align: left;" class="datagrid-cell "><a></a></div>',
                    '</td>'
                ].join(""));
                tr.append(tds);
                var del = $("<a style='text-decoration:underline;cursor:hand;'>删除</a>");
                del.click(function(){
                    $.ajax({ type:"post", url: grid.settings.deleteUrl, data: {attachmentId:attachmentId},success: function(){
                        tr.remove();
                        grid.settings.height = grid.settings.height - 29;
                        ui.reSize();
                    } });
                });
                tr.find("td:last").children().append(del);
                return tr;
            },

            initRows:function(){
                $.ajax({
                    type:"post",
                    url: settings.initUrl,
                    data: {documentId:settings.documentId},
                    dataType: 'json',
                    success: function(datas){
                        $.each(datas,function(index){
                            var params = {attachmentId:this.attachmentID,fileName:this.fileName,deleteUrl:settings.deleteUrl,downloadUrl:settings.downloadUrl,author:this.author,summary:this.summary,readOnly:this.readOnly};
                            ui.addProgress(ui.createRows(params));
                        });
                    },
                    error: function() {alert("加载失败")}
                })
            }
        };
        //init divs
        ui.header = document.createElement('div'); //create global container
        ui.title = document.createElement('div'); //create title container
        ui.body = document.createElement('div'); //create title container
        ui.gridWraper = document.createElement('div'); //create title container
        ui.gridView = document.createElement('div');
        ui.gridHeader = document.createElement('div');
        ui.gridInner = document.createElement('div');
        ui.gridTable = document.createElement('table');
        ui.datagrid = document.createElement('div');
        ui.dataTable = document.createElement('table');

        ui.init();
        ui.reSize();
        if(settings.documentId){
            ui.initRows();
        }

        this.ui = ui;
        return this;
    }
})(jQuery);
