/**
 **/
JOTree = function(options){
    this.options ={
        showMenuMethod:null
    };
    this.options = $.extend(this.options,options||{});
    this.init();
};

JOTree.prototype = {
    init:function(){
        this.addMethods();
        this.setting = {
            async:{
                enable:true,
                autoParam:["id","uid","type"],
                url:this.options.url
            }, callback:{
            }
        };
        this.setting = $.extend(this.setting,this.options||{});
        if(this.options.menuId){
            this.setting.callback.onRightClick = this.OnRightClick;
        }
        if(this.options.check){
            this.setting.check = {
                enable: true,
                chkStyle:"checkbox",
                chkboxType: { "Y": "ps", "N": "ps" }
            }
        }

        this.initRoot();
        this.tree =  $.fn.zTree.init($("#"+this.options.treeId), this.setting, null);
    },
    initRoot:function(){
        this.root = this.options.root|| [{
            name: "根节点", open: true, click:true,checked:true
        }];
    },
    addMethods:function(){
        var treeObj = this;
        this.OnRightClick = function(event, treeId, treeNode){
            if(treeObj.options.menuId){
                treeObj.addMenu(treeNode,event);
            }
        }
    },
    addMenu:function(treeNode,event){
        this.menu = $("#"+this.options.menuId);
        this.tree.selectNode(treeNode);
        this.showRMenu(treeNode,event);
    },
    showRMenu:function(treeNode,e){
        var menuId = this.options.menuId;

        var menu = this.menu;
        $("#"+menuId+" ul").show();


        //右键菜单回调
        if(this.options.showMenuMethod){
            this.options.showMenuMethod.call(this,treeNode);
        }
        menu.css({"top":$(e.target).position().top+"px", "left":$(e.target).position().left+"px", "visibility":"visible"});
        $("body").bind("mousedown", function(event){
            if (!(event.target.id == menuId || $(event.target).parents("#"+menuId).length>0)) {
                menu.css({"visibility" : "hidden"});
            }
        });
    },
    setMenuMethod:function(methodName){
        this.options.showMenuMethod = methodName;
    },
    getMenuMethod:function(){
        return  this.options.showMenuMethod;
    }

};

function getFont(treeId, node) {
    return node.font ? node.font : {};
}

function OnRightClick(){
    alert(12);
}