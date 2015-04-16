(function ($) {
    $.fn.joFilter = function (arg) {
        if (typeof arg === 'string') {

            var fn = $.fn.joFilter[arg];
            if (!fn) {
                throw ("joFilter - No such method: " + arg);
            }
            var args = $.makeArray(arguments).slice(1);
            return fn.apply(this, args);
        }

        var p = $.extend(true, {
            filter:null,
            columns:[],
            onChange:null,
            beforeRedraw:null,
            afterRedraw:null,
            checkValues:null,
            error:false,
            errmsg:"",
            errorcheck:true,
            showQuery:true,
            sopt:null,
            ops:[
                {"name":"eq", "description":"equal", "operator":"="},
                {"name":"ne", "description":"not equal", "operator":"<>"},
                {"name":"lt", "description":"less", "operator":"<"},
                {"name":"le", "description":"less or equal", "operator":"<="},
                {"name":"gt", "description":"greater", "operator":">"},
                {"name":"ge", "description":"greater or equal", "operator":">="},
                {"name":"bw", "description":"begins with", "operator":"LIKE"},
                {"name":"bn", "description":"does not begin with", "operator":"NOT LIKE"},
                {"name":"in", "description":"in", "operator":"IN"},
                {"name":"ni", "description":"not in", "operator":"NOT IN"},
                {"name":"ew", "description":"ends with", "operator":"LIKE"},
                {"name":"en", "description":"does not end with", "operator":"NOT LIKE"},
                {"name":"cn", "description":"contains", "operator":"LIKE"},
                {"name":"nc", "description":"does not contain", "operator":"NOT LIKE"},
                {"name":"nu", "description":"is null", "operator":"IS NULL"},
                {"name":"nn", "description":"is not null", "operator":"IS NOT NULL"},
                {"name":"bt", "description":"between", "operator":"BETWEEN {0} WITH {1}", cnDesc:" 从 '{0}' 到 '{1}' "}
            ],
            numopts:['eq', 'ne', 'lt', 'le', 'gt', 'ge', 'nu', 'nn', 'in', 'ni'],
            stropts:['eq', 'ne', 'bw', 'bn', 'ew', 'en', 'cn', 'nc', 'nu', 'nn', 'in', 'ni'],
            _gridsopt:[], // grid translated strings, do not tuch
            groupOps:[
                { op:"AND", text:"并且" },
                { op:"OR", text:"或" }
            ],
            groupButton:true,
            ruleButtons:true,
            direction:"ltr"
        }, arg || {});
        return this.each(function () {
            if (this.filter) {
                return;
            }
            this.p = p;
            // setup filter in case if they is not defined
            if (this.p.filter === null || this.p.filter === undefined) {
                this.p.filter = {
                    groupOp:this.p.groupOps[0].op,
                    rules:[],
                    groups:[]
                };
            }
            var i, len = this.p.columns.length, cl,
                isIE = /msie/i.test(navigator.userAgent) && !window.opera;

            // translating the options
            if (this.p._gridsopt.length) {
                // ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
                for (i = 0; i < this.p._gridsopt.length; i++) {
                    this.p.ops[i].description = this.p._gridsopt[i];
                }
            }
            this.p.initFilter = $.extend(true, {}, this.p.filter);

            // set default values for the columns if they are not set
            if (!len) {
                return;
            }
            for (i = 0; i < len; i++) {
                cl = this.p.columns[i];
                if (cl.stype) {
                    // grid compatibility
                    cl.inputtype = cl.stype;
                } else if (!cl.inputtype) {
                    cl.inputtype = 'text';
                }
                if (cl.sorttype) {
                    // grid compatibility
                    cl.searchtype = cl.sorttype;
                } else if (!cl.searchtype) {
                    cl.searchtype = 'string';
                }
                if (cl.hidden === undefined) {
                    // jqGrid compatibility
                    cl.hidden = false;
                }
                if (!cl.label) {
                    cl.label = cl.name;
                }
                if (cl.index) {
                    cl.name = cl.index;
                }
                if (!cl.hasOwnProperty('searchoptions')) {
                    cl.searchoptions = {};
                }
                if (!cl.hasOwnProperty('searchrules')) {
                    cl.searchrules = {};
                }

            }
//            if (this.p.showQuery) {
            $(this).append("<table class='queryresult ui-widget ui-widget-content' style='display:block;max-width:440px;border:0px none;' dir='" + this.p.direction + "'><tbody><tr><td class='query'></td></tr></tbody></table>");
//            }
            /*
             *Perform checking.
             *
             */
            var checkData = function (val, colModelItem) {
                var ret = [true, ""];
                if ($.isFunction(colModelItem.searchrules)) {
                    ret = colModelItem.searchrules(val, colModelItem);
                } else if ($.jgrid && $.jgrid.checkValues) {
                    try {
                        ret = $.jgrid.checkValues(val, -1, null, colModelItem.searchrules, colModelItem.label);
                    } catch (e) {
                    }
                }
                if (ret && ret.length && ret[0] === false) {
                    p.error = !ret[0];
                    p.errmsg = ret[1];
                }
            };
            /* moving to common
             randId = function() {
             return Math.floor(Math.random()*10000).toString();
             };
             */

            this.onchange = function () {
                // clear any error
                this.p.error = false;
                this.p.errmsg = "";
                return $.isFunction(this.p.onChange) ? this.p.onChange.call(this, this.p) : false;
            };
            /*
             * Redraw the filter every time when new field is added/deleted
             * and field is  changed
             */
            this.reDraw = function () {
                if ($.isFunction(this.p.beforeRedraw)) {
                    this.p.beforeRedraw.call(this, this.p);
                }
                $("table.group:first", this).remove();
                var t = this.createTableForGroup(p.filter, null);
                $(this).append(t);
                if ($.isFunction(this.p.afterRedraw)) {
                    this.p.afterRedraw.call(this, this.p);
                }
            };
            /*
             * Creates a grouping data for the filter
             * @param group - object
             * @param parentgroup - object
             */
            this.createTableForGroup = function (group, parentgroup) {
                var that = this, i;
                // this table will hold all the group (tables) and rules (rows)
                var table = $("<table class='group ui-widget ui-widget-content' style='border:0px none; width: 100%;'><tbody></tbody></table>"),
                    // create error message row
                    align = "left";
                if (this.p.direction == "rtl") {
                    align = "right";
                    table.attr("dir", "rtl");
                }
                if (parentgroup === null) {
                    table.append("<tr class='error' style='display:none;'><th colspan='5' class='ui-state-error' align='" + align + "'></th></tr>");
                }

                var tr = $("<tr></tr>");
                table.append(tr);
                // this header will hold the group operator type and group action buttons for
                // creating subgroup "+ {}", creating rule "+" or deleting the group "-"
                var th = $("<th colspan='5' align='" + align + "'></th>");
                tr.append(th);

                if (this.p.ruleButtons === true) {
                    // dropdown for: choosing group operator type
                    var groupOpSelect = $("<select class='opsel'></select>");
                    th.append(groupOpSelect);
                    // populate dropdown with all posible group operators: or, and
                    var str = "", selected;
                    for (i = 0; i < p.groupOps.length; i++) {
                        selected = group.groupOp === that.p.groupOps[i].op ? " selected='selected'" : "";
                        str += "<option value='" + that.p.groupOps[i].op + "'" + selected + ">" + that.p.groupOps[i].text + "</option>";
                    }

                    groupOpSelect
                        .append(str)
                        .bind('change', function () {
                            group.groupOp = $(groupOpSelect).val();
                            that.onchange(); // signals that the filter has changed
                        });
                }
                // button for adding a new subgroup
                var inputAddSubgroup = "<span></span>";
                if (this.p.groupButton) {
                    inputAddSubgroup = $("<input type='button' value='+ {}' title='Add subgroup' class='add-group'/>");
                    inputAddSubgroup.bind('click', function () {
                        if (group.groups === undefined) {
                            group.groups = [];
                        }

                        group.groups.push({
                            groupOp:p.groupOps[0].op,
                            rules:[],
                            groups:[]
                        }); // adding a new group

                        that.reDraw(); // the html has changed, force reDraw

                        that.onchange(); // signals that the filter has changed
                        return false;
                    });
                }
                th.append(inputAddSubgroup);
                if (this.p.ruleButtons === true) {
                    // button for adding a new rule
                    var inputAddRule = $("<input type='button' value='+' title='Add rule' class='add-rule ui-add'/>"), cm;
                    inputAddRule.bind('click', function () {
                        //if(!group) { group = {};}
                        if (group.rules === undefined) {
                            group.rules = [];
                        }
                        for (i = 0; i < that.p.columns.length; i++) {
                            // but show only serchable and serchhidden = true fields
                            var searchable = (typeof that.p.columns[i].search === 'undefined') ? true : that.p.columns[i].search ,
                                hidden = (that.p.columns[i].hidden === true),
                                ignoreHiding = (that.p.columns[i].searchoptions.searchhidden === true);
                            if ((ignoreHiding && searchable) || (searchable && !hidden)) {
                                cm = that.p.columns[i];
                                break;
                            }
                        }

                        var opr;
                        if (cm.searchoptions.sopt) {
                            opr = cm.searchoptions.sopt;
                        }
                        else if (that.p.sopt) {
                            opr = that.p.sopt;
                        }
                        else if (cm.searchtype === 'string') {
                            opr = that.p.stropts;
                        } else {
                            opr = that.p.numopts;
                        }

                        group.rules.push({
                            field:cm.name,
                            op:opr[0],
                            data:""
                        }); // adding a new rule

                        that.reDraw(); // the html has changed, force reDraw
                        // for the moment no change have been made to the rule, so
                        // this will not trigger onchange event
                        return false;
                    });
                    th.append(inputAddRule);
                }

                // button for delete the group
                if (parentgroup !== null) { // ignore the first group
                    var inputDeleteGroup = $("<input type='button' value='-' title='Delete group' class='delete-group'/>");
                    th.append(inputDeleteGroup);
                    inputDeleteGroup.bind('click', function () {
                        // remove group from parent
                        for (i = 0; i < parentgroup.groups.length; i++) {
                            if (parentgroup.groups[i] === group) {
                                parentgroup.groups.splice(i, 1);
                                break;
                            }
                        }

                        that.reDraw(); // the html has changed, force reDraw

                        that.onchange(); // signals that the filter has changed
                        return false;
                    });
                }

                // append subgroup rows
                if (group.groups !== undefined) {
                    for (i = 0; i < group.groups.length; i++) {
                        var trHolderForSubgroup = $("<tr></tr>");
                        table.append(trHolderForSubgroup);

                        var tdFirstHolderForSubgroup = $("<td class='first'></td>");
                        trHolderForSubgroup.append(tdFirstHolderForSubgroup);

                        var tdMainHolderForSubgroup = $("<td colspan='4'></td>");
                        tdMainHolderForSubgroup.append(this.createTableForGroup(group.groups[i], group));
                        trHolderForSubgroup.append(tdMainHolderForSubgroup);
                    }
                }
                if (group.groupOp === undefined) {
                    group.groupOp = that.p.groupOps[0].op;
                }

                // append rules rows
                if (group.rules !== undefined) {
                    for (i = 0; i < group.rules.length; i++) {
                        table.append(
                            this.createTableRowForRule(group.rules[i], group)
                        );
                    }
                }

                return table;
            };
            /*
             * Create the rule data for the filter
             */
            this.createTableRowForRule = function (rule, group) {
                // save current entity in a variable so that it could
                // be referenced in anonimous method calls

                var that = this, tr = $("<tr></tr>"),
                    //document.createElement("tr"),

                    // first column used for padding
                    //tdFirstHolderForRule = document.createElement("td"),
                    i, op, trpar, cm, str = "", selected;
                //tdFirstHolderForRule.setAttribute("class", "first");
                tr.append("<td class='first'></td>");


                // create field container
                var ruleFieldTd = $("<td class='columns' style='width: 10%;' nowrap></td>");
                tr.append(ruleFieldTd);


                // dropdown for: choosing field
                var ruleFieldSelect = $("<select></select>"), ina, aoprs = [];
                ruleFieldTd.append(ruleFieldSelect);
                if (!this.p.showQuery) {
                    ruleFieldSelect.hide();
                    ruleFieldTd.append("<span>" + rule.field + ": </span>");
                }
                ruleFieldSelect.bind('change',
                    function () {
                        rule.field = $(ruleFieldSelect).val();

                        trpar = $(this).parents("tr:first");
                        for (i = 0; i < that.p.columns.length; i++) {
                            if (that.p.columns[i].name === rule.field) {
                                cm = that.p.columns[i];
                                break;
                            }
                        }
                        if (!cm) {
                            return;
                        }
                        cm.searchoptions.id = $.jgrid.randId();
                        if (isIE && cm.inputtype === "text") {
                            if (!cm.searchoptions.size) {
                                cm.searchoptions.size = 10;
                            }
                        }
                        var elm = $.jgrid.createEl(cm.inputtype, cm.searchoptions, "", true, that.p.ajaxSelectOptions, true);
                        $(elm).addClass("input-elm");
                        //that.createElement(rule, "");

                        if (cm.searchoptions.sopt) {
                            op = cm.searchoptions.sopt;
                        }
                        else if (that.p.sopt) {
                            op = that.p.sopt;
                        }
                        else if (cm.searchtype === 'string') {
                            op = that.p.stropts;
                        }
                        else {
                            op = that.p.numopts;
                        }
                        // operators
                        var s = "", so = 0;
                        aoprs = [];
                        $.each(that.p.ops, function () {
                            aoprs.push(this.name)
                        });
                        for (i = 0; i < op.length; i++) {
                            ina = $.inArray(op[i], aoprs);
                            if (ina !== -1) {
                                if (so === 0) {
                                    rule.op = that.p.ops[ina].name;
                                }
                                s += "<option value='" + that.p.ops[ina].name + "'>" + that.p.ops[ina].description + "</option>";
                                so++;
                            }
                        }
                        $(".selectopts", trpar).empty().append(s);
                        $(".selectopts", trpar)[0].selectedIndex = 0;
                        if ($.browser.msie && $.browser.version < 9) {
                            var sw = parseInt($("select.selectopts", trpar)[0].offsetWidth) + 1;
                            $(".selectopts", trpar).width(sw);
                            $(".selectopts", trpar).css("width", "auto");
                        }
                        // data
                        $(".data", trpar).empty().append(elm);
                        $(".input-elm", trpar).bind('change', function () {
                            rule.data = $(this).val();
                            that.onchange(); // signals that the filter has changed
                        });
                        setTimeout(function () { //IE, Opera, Chrome
                            rule.data = $(elm).val();
                            that.onchange();  // signals that the filter has changed
                        }, 0);
                    });

                // populate drop down with user provided column definitions
                var j = 0;
                for (i = 0; i < that.p.columns.length; i++) {
                    // but show only serchable and serchhidden = true fields
                    var searchable = (typeof that.p.columns[i].search === 'undefined') ? true : that.p.columns[i].search ,
                        hidden = (that.p.columns[i].hidden === true),
                        ignoreHiding = (that.p.columns[i].searchoptions.searchhidden === true);
                    if ((ignoreHiding && searchable) || (searchable && !hidden)) {
                        selected = "";
                        if (rule.field === that.p.columns[i].name) {
                            selected = " selected='selected'";
                            j = i;
                        }
                        str += "<option value='" + that.p.columns[i].name + "'" + selected + ">" + that.p.columns[i].label + "</option>";
                    }
                }
                ruleFieldSelect.append(str);


                // create operator container
                var ruleOperatorTd = $("<td class='operators'></td>");
                tr.append(ruleOperatorTd);
                cm = p.columns[j];
                // create it here so it can be referentiated in the onchange event
                //var RD = that.createElement(rule, rule.data);
//                cm.searchoptions.id = $.jgrid.randId();
                cm.searchoptions.id = cm.searchoptions.id || $.jgrid.randId(); //不覆盖配置中的ID
                if (isIE && cm.inputtype === "text") {
                    if (!cm.searchoptions.size) {
                        cm.searchoptions.size = 10;
                    }
                }
                var ruleDataInput = $.jgrid.createEl(cm.inputtype, cm.searchoptions, rule.data, true, that.p.ajaxSelectOptions, true);

                // dropdown for: choosing operator
                var ruleOperatorSelect = $("<select class='selectopts'></select>");
                ruleOperatorTd.append(ruleOperatorSelect);
                if (!this.p.showQuery) {
                    ruleOperatorSelect.hide();
                }
                ruleOperatorSelect.bind('change',
                    function () {
                        rule.op = $(ruleOperatorSelect).val();
                        trpar = $(this).parents("tr:first");
                        var rd = $(".input-elm", trpar)[0];
                        if (rule.op === "nu" || rule.op === "nn") { // disable for operator "is null" and "is not null"
                            rule.data = "";
                            rd.value = "";
                            rd.setAttribute("readonly", "true");
                            rd.setAttribute("disabled", "true");
                        } else {
                            rd.removeAttribute("readonly");
                            rd.removeAttribute("disabled");
                        }

                        that.onchange();  // signals that the filter has changed
                    });

                // populate drop down with all available operators
                if (cm.searchoptions.sopt) {
                    op = cm.searchoptions.sopt;
                }
                else if (that.p.sopt) {
                    op = that.p.sopt;
                }
                else if (cm.searchtype === 'string') {
                    op = p.stropts;
                }
                else {
                    op = that.p.numopts;
                }
                str = "";
                $.each(that.p.ops, function () {
                    aoprs.push(this.name)
                });
                for (i = 0; i < op.length; i++) {
                    ina = $.inArray(op[i], aoprs);
                    if (ina !== -1) {
                        if (rule.op === that.p.ops[ina].name) {
                            selected = " selected='selected'";
//                            if (!this.p.showQuery) {
//                                ruleOperatorTd.append("<span>" + that.p.ops[ina].description + "</span>");
//                            }
                        } else {
                            selected = "";
                        }
                        str += "<option value='" + that.p.ops[ina].name + "'" + selected + ">" + that.p.ops[ina].description + "</option>";
                    }
                }
                ruleOperatorSelect.append(str);
                // create data container
                var ruleDataTd = $("<td class='data' nowrap></td>");
                tr.append(ruleDataTd);

                // textbox for: data
                // is created previously
                //ruleDataInput.setAttribute("type", "text");
                ruleDataTd.append(ruleDataInput);

                $(ruleDataInput)
                    .addClass("input-elm")
                    .bind('change', function () {
                        rule.data = $(this).val();
                        that.onchange(); // signals that the filter has changed
                    });

                // create action container
                var ruleDeleteTd = $("<td></td>");
                tr.append(ruleDeleteTd);

                // create button for: delete rule
                if (this.p.ruleButtons === true) {
                    var ruleDeleteInput = $("<input type='button' value='-' title='Delete rule' class='delete-rule ui-del'/>");
                    if (!this.p.showQuery) {
                        ruleDeleteInput.hide();
                    }
                    ruleDeleteTd.append(ruleDeleteInput);
                    //$(ruleDeleteInput).html("").height(20).width(30).button({icons: {  primary: "ui-icon-minus", text:false}});
                    ruleDeleteInput.bind('click', function () {
                        // remove rule from group
                        for (i = 0; i < group.rules.length; i++) {
                            if (group.rules[i] === rule) {
                                group.rules.splice(i, 1);
                                break;
                            }
                        }

                        that.reDraw(); // the html has changed, force reDraw

                        that.onchange(); // signals that the filter has changed
                        return false;
                    });
                }
                return tr;
            };

            this.getStringForGroup = function (group) {
                var s = "(", index;
                if (group.groups !== undefined) {
                    for (index = 0; index < group.groups.length; index++) {
                        if (s.length > 1) {
                            s += " " + this.getGroupOpByOp(group.groupOp).text + " ";
                        }
                        try {
                            s += this.getStringForGroup(group.groups[index]);
                        } catch (eg) {
                            alert(eg);
                        }
                    }
                }

                if (group.rules !== undefined) {
                    try {
                        for (index = 0; index < group.rules.length; index++) {
                            if (this.isNullRule(group.rules[index])) {
                                continue;
                            }
                            if (s.length > 1) {
                                s += " " + this.getGroupOpByOp(group.groupOp).text + " ";
                            }
                            s += this.getStringForRule(group.rules[index]);
                        }
                    } catch (e) {
                        alert(e);
                    }
                }

                s += ")";

                if (s === "()") {
                    return ""; // ignore groups that don't have rules
                } else {
                    return s;
                }
            };
            this.getGroupOpByOp = function (op) {
                var groupOps = this.p.groupOps;
                for (var j = 0; j < groupOps.length; j++) {
                    if (groupOps[j].op == op) {
                        return groupOps[j];
                    }
                }
            };
            this.getStringForRule = function (rule) {
                var opUF = "", opC = "", i, cm, ret, val, cnDesc,
                    numtypes = ['int', 'integer', 'float', 'number', 'currency']; // jqGrid
                for (i = 0; i < this.p.ops.length; i++) {
                    if (this.p.ops[i].name === rule.op) {
                        opUF = $.trim(this.p.ops[i].description);
                        opC = this.p.ops[i].name;
                        cnDesc = this.p.ops[i].cnDesc;
                        break;
                    }
                }
                for (i = 0; i < this.p.columns.length; i++) {
                    if (this.p.columns[i].name === rule.field) {
                        cm = this.p.columns[i];
                        break;
                    }
                }
                val = rule.data;
//                if (opC === 'bw' || opC === 'bn') {
//                    val = val + "%";
//                }
//                if (opC === 'ew' || opC === 'en') {
//                    val = "%" + val;
//                }
//                if (opC === 'cn' || opC === 'nc') {
//                    val = "%" + val + "%";
//                }
                if (opC === 'in' || opC === 'ni') {
                    val = " (" + val + ")";
                }
                if (p.errorcheck) {
                    checkData(rule.data, cm);
                }
                if (opC === 'bt') {
                    if (val.length < 1) {
                        return '';
                    }
                    val = val.split(",");
//                    var ret = cnDesc.replace("{0}", val[0]);
//                    ret = ret.replace("{1}", val[1]);
                    var valRet = "";
                    if( val[0] != null &&  val[0] != "undifined" &&  val[0] != ""){
                        valRet = cnDesc.replace("{0}", val[0]);
                    }else{
                        valRet = cnDesc.replace("{0}", "--");
                    }
                    if( val[1] != null &&  val[1] != "undifined" &&  val[1] != ""){
                        valRet = valRet.replace("{1}", val[1]);
                    }else{
                        valRet = valRet.replace("{1}", "--");
                    }
                    return rule.field + valRet;
                }
                if ($.inArray(cm.searchtype, numtypes) !== -1 || opC === 'nn' || opC === 'nu') {
                    ret = rule.field + " " + opUF + " " + val;
                }
                else {
                    ret = rule.field + " " + opUF + " \"" + val + "\"";
                }
                return ret;
            };
            this.isNullRule = function (rule) {
                return (rule.data === null || rule.data === "") && ('nn' != rule.op || 'nu' != rule.op);
            };
            this.resetFilter = function () {
                this.p.filter = $.extend(true, {}, this.p.initFilter);
                this.reDraw();
                this.onchange();
            };
            this.hideError = function () {
                $("th.ui-state-error", this).html("");
                $("tr.error", this).hide();
            };
            this.showError = function () {
                $("th.ui-state-error", this).html(this.p.errmsg);
                $("tr.error", this).show();
            };
            this.toUserFriendlyString = function () {
                return this.getStringForGroup(p.filter);
            };
            this.toString = function () {
                // this will obtain a string that can be used to match an item.
                var that = this;

                function getStringRule(rule) {
                    if (that.p.errorcheck) {
                        var i, cm;
                        for (i = 0; i < that.p.columns.length; i++) {
                            if (that.p.columns[i].name === rule.field) {
                                cm = that.p.columns[i];
                                break;
                            }
                        }
                        if (cm) {
                            checkData(rule.data, cm);
                        }
                    }
                    return rule.op + "(item." + rule.field + ",'" + rule.data + "')";
                }

                function getStringForGroup(group) {
                    var s = "(", index;

                    if (group.groups !== undefined) {
                        for (index = 0; index < group.groups.length; index++) {
                            if (s.length > 1) {
                                if (group.groupOp === "OR") {
                                    s += " || ";
                                }
                                else {
                                    s += " && ";
                                }
                            }
                            s += getStringForGroup(group.groups[index]);
                        }
                    }

                    if (group.rules !== undefined) {
                        for (index = 0; index < group.rules.length; index++) {
                            if (s.length > 1) {
                                if (group.groupOp === "OR") {
                                    s += " || ";
                                }
                                else {
                                    s += " && ";
                                }
                            }
                            s += getStringRule(group.rules[index]);
                        }
                    }

                    s += ")";

                    if (s === "()") {
                        return ""; // ignore groups that don't have rules
                    } else {
                        return s;
                    }
                }

                return getStringForGroup(this.p.filter);
            };

            // Here we init the filter
            this.reDraw();

//            if (this.p.showQuery) {
            this.onchange();
//            }
            // mark is as created so that it will not be created twice on this element
            this.filter = true;
        });
    };
    $.extend($.fn.joFilter, {
        /*
         * Return SQL like string. Can be used directly
         */
        toSQLString:function () {
            var s = "";
            this.each(function () {
                s = this.toUserFriendlyString();
            });
            return s;
        },
        /*
         * Return filter data as object.
         */
        filterData:function () {
            var s;
            this.each(function () {
                s = this.p.filter;
            });
            return s;

        },
        getParameter:function (param) {
            if (param !== undefined) {
                if (this.p.hasOwnProperty(param)) {
                    return this.p[param];
                }
            }
            return this.p;
        },
        resetFilter:function () {
            return this.each(function () {
                this.resetFilter();
            });
        },
        addFilter:function (pfilter) {
            if (typeof pfilter === "string") {
                pfilter = jQuery.jgrid.parse(pfilter);
            }
            this.each(function () {
                this.p.filter = pfilter;
                this.reDraw();
                this.onchange();
            });
        }

    });

    $.jgrid.extend({
        joSearchGrid:function (p) {
            p = $.extend({
                recreateFilter:false,
                drag:true,
                sField:'searchField',
                sValue:'searchString',
                sOper:'searchOper',
                sFilter:'filters',
                loadDefaults:true, // this options activates loading of default filters from grid's postData for Multipe Search only.
                beforeShowSearch:null,
                afterShowSearch:null,
                onInitializeSearch:null,
                beforeRedraw:null,
                afterRedraw:null,
                closeAfterSearch:false,
                closeAfterReset:false,
                closeOnEscape:false,
                multipleSearch:false,
                multipleGroup:false,
                //cloneSearchRowOnAdd: true,
                top:0,
                left:0,
                jqModal:true,
                modal:false,
                resize:true,
                width:450,
                height:'auto',
                dataheight:'auto',
                showQuery:false,
                advance:true,
                onChange:null,
                errorcheck:true,
                // translation
                // if you want to change or remove the order change it in sopt
                // ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc'],
                sopt:null,
                stringResult:undefined,
                onClose:null,
                onSearch:null,
                beforeReset:null,
                onReset:null,
                toTop:true,
                overlay:30,
                columns:[],
                tmplNames:null,
                tmplFilters:null,
                // translations - later in lang file
                tmplLabel:' Template: ',
                showOnLoad:false,
                layer:null
            }, $.jgrid.search, p || {});
            return this.each(function () {
                var $t = this;
                if (!$t.grid) {
                    return;
                }
                var fid = "fbox_" + $t.p.id,
                    showFrm = true,
                    IDs = {themodal:'searchmod' + fid, modalhead:'searchhd' + fid, modalcontent:'searchcnt' + fid, scrollelm:fid},
                    defaultFilters = $t.p.postData[p.sFilter];
                if (typeof(defaultFilters) === "string") {
                    defaultFilters = $.jgrid.parse(defaultFilters);
                }
                if (p.recreateFilter === true) {
                    $("#" + IDs.themodal).remove();
                }
                function showFilter() {
                    if ($.isFunction(p.beforeShowSearch)) {
                        showFrm = p.beforeShowSearch($("#" + fid));
                        if (typeof(showFrm) === "undefined") {
                            showFrm = true;
                        }
                    }
                    if (showFrm) {
                        $.jgrid.viewModal("#" + IDs.themodal, {gbox:"#gbox_" + fid, jqm:p.jqModal, modal:p.modal, overlay:p.overlay, toTop:p.toTop});
                        if ($.isFunction(p.afterShowSearch)) {
                            p.afterShowSearch($("#" + fid), p);
                        }
                    }
                }

                if ($("#" + IDs.themodal).html() !== null) {
                    showFilter();
                } else {
                    var fil = $("<div><div id='" + fid + "' class='searchFilter' style='overflow:auto'></div></div>").insertBefore("#gview_" + $t.p.id),
                        align = "left", butleft = "";
                    if ($t.p.direction == "rtl") {
                        align = "right";
                        butleft = " style='text-align:left'";
                        fil.attr("dir", "rtl");
                    }
                    var columns = $.extend([], $t.p.colModel),
                        bS = "<a href='javascript:void(0)' id='" + fid + "_search' class='fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset'><span class='ui-icon ui-icon-search'></span>" + p.Find + "</a>",
                        bC = "<a href='javascript:void(0)' id='" + fid + "_reset' class='fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search'><span class='ui-icon ui-icon-arrowreturnthick-1-w'></span>" + p.Reset + "</a>",
                        bQ = "", tmpl = "", colnm, found = false, bt, cmi = -1;
                    if (p.advance) {  //if (p.showQuery) {
                        bQ = "<a href='javascript:void(0)' id='" + fid + "_query' class='fm-button ui-state-default ui-corner-all fm-button-icon-left'><span class='ui-icon ui-icon-comment'></span>高级</a>";
                    }
                    if (!p.columns.length) {
                        $.each(columns, function (i, n) {
                            if (!n.label) {
                                n.label = $t.p.colNames[i];
                            }
                            // find first searchable column and set it if no default filter
                            if (!found) {
                                var searchable = (typeof n.search === 'undefined') ? true : n.search ,
                                    hidden = (n.hidden === true),
                                    ignoreHiding = (n.searchoptions && n.searchoptions.searchhidden === true);
                                if ((ignoreHiding && searchable) || (searchable && !hidden)) {
                                    found = true;
                                    colnm = n.index || n.name;
                                    cmi = i;
                                }
                            }
                        });
                    } else {
                        columns = p.columns;
                    }
                    // old behaviour
                    if ((!defaultFilters && colnm) || p.multipleSearch === false) {
                        var cmop = "eq";
                        if (cmi >= 0 && columns[cmi].searchoptions && columns[cmi].searchoptions.sopt) {
                            cmop = columns[cmi].searchoptions.sopt[0];
                        } else if (p.sopt && p.sopt.length) {
                            cmop = p.sopt[0];
                        }
                        defaultFilters = {"groupOp":"AND", rules:[
                            {"field":colnm, "op":cmop, "data":""}
                        ]};
                    }
                    found = false;
                    if (p.tmplNames && p.tmplNames.length) {
                        found = true;
                        tmpl = p.tmplLabel;
                        tmpl += "<select class='ui-template'>";
                        tmpl += "<option value='default'>Default</option>";
                        $.each(p.tmplNames, function (i, n) {
                            tmpl += "<option value='" + i + "'>" + n + "</option>";
                        });
                        tmpl += "</select>";
                    }

                    bt = "<table class='EditTable' style='border:0px none;margin-top:5px' id='" + fid + "_2'><tbody><tr><td colspan='2'><hr class='ui-widget-content' style='margin:1px'/></td></tr><tr><td class='EditButton' style='text-align:" + align + "'>" + bC + tmpl + "</td><td class='EditButton' " + butleft + ">" + bQ + bS + "</td></tr></tbody></table>";

                    $("#" + fid).joFilter({
                        columns:columns,
                        filter:p.loadDefaults ? defaultFilters : null,
                        showQuery:p.showQuery,
                        errorcheck:p.errorcheck,
                        sopt:p.sopt,
                        groupButton:p.multipleGroup,
                        ruleButtons:p.multipleSearch,
                        beforeRedraw:p.beforeRedraw,
                        afterRedraw:p.afterRedraw,
                        _gridsopt:$.jgrid.search.odata,
                        ajaxSelectOptions:$t.p.ajaxSelectOptions,
                        onChange:p.onChange || function (sp) {
//                            if (this.p.showQuery) {
                            $('.query', this).html(this.toUserFriendlyString());
//                            }
                        },
                        direction:$t.p.direction
                    });
                    fil.append(bt);
                    if (found && p.tmplFilters && p.tmplFilters.length) {
                        $(".ui-template", fil).bind('change', function (e) {
                            var curtempl = $(this).val();
                            if (curtempl == "default") {
                                $("#" + fid).joFilter('addFilter', defaultFilters);
                            } else {
                                $("#" + fid).joFilter('addFilter', p.tmplFilters[parseInt(curtempl, 10)]);
                            }
                            return false;
                        });
                    }
                    if (p.multipleGroup === true) {
                        p.multipleSearch = true;
                    }
                    if ($.isFunction(p.onInitializeSearch)) {
                        p.onInitializeSearch($("#" + fid));
                    }
                    p.gbox = "#gbox_" + fid;
                    if (p.layer) {
                        $.jgrid.createModal(IDs, fil, p, "#gview_" + $t.p.id, $("#gbox_" + $t.p.id)[0], "#" + p.layer, {position:"relative"});
                    } else {
                        $.jgrid.createModal(IDs, fil, p, "#gview_" + $t.p.id, $("#gbox_" + $t.p.id)[0]);
                    }
                    if (bQ) {
                        $("#" + fid + "_query").bind('click', function (e) {
                            $(".queryresult", fil).toggle();
                            return false;
                        });
                    }
                    if (p.stringResult === undefined) {
                        // to provide backward compatibility, inferring stringResult value from multipleSearch
                        p.stringResult = p.multipleSearch;
                    }
                    $("#" + fid + "_search").bind('click', function () {
                        var fl = $("#" + fid),
                            sdata = {}, res ,
                            filters = fl.joFilter('filterData');
                        if (p.errorcheck) {
                            fl[0].hideError();
                            if (!p.showQuery) {
                                fl.joFilter('toSQLString');
                            }
                            if (fl[0].p.error) {
                                fl[0].showError();
                                return false;
                            }
                        }

                        if (p.stringResult) {
                            try {
                                // xmlJsonClass or JSON.stringify
                                res = xmlJsonClass.toJson(filters, '', '', false);
                            } catch (e) {
                                try {
                                    res = JSON.stringify(filters);
                                } catch (e2) {
                                }
                            }
                            if (typeof(res) === "string") {
                                sdata[p.sFilter] = res;
                                $.each([p.sField, p.sValue, p.sOper], function () {
                                    sdata[this] = "";
                                });
                            }
                        } else {
                            if (p.multipleSearch) {
                                sdata[p.sFilter] = filters;
                                $.each([p.sField, p.sValue, p.sOper], function () {
                                    sdata[this] = "";
                                });
                            } else {
                                sdata[p.sField] = filters.rules[0].field;
                                sdata[p.sValue] = filters.rules[0].data;
                                sdata[p.sOper] = filters.rules[0].op;
                                sdata[p.sFilter] = "";
                            }
                        }
                        $t.p.search = true;
                        $.extend($t.p.postData, sdata);
                        if ($.isFunction(p.onSearch)) {
                            p.onSearch();
                        }
                        $($t).trigger("reloadGrid", [
                            {page:1}
                        ]);
                        if (p.closeAfterSearch) {
                            $.jgrid.hideModal("#" + IDs.themodal, {gb:"#gbox_" + $t.p.id, jqm:p.jqModal, onClose:p.onClose});
                        }
                        return false;
                    });
                    $("#" + fid + "_reset").bind('click', function () {
                        if ($.isFunction(p.beforeReset)) {
                            p.beforeReset(fid, p);
                        }
                        var sdata = {},
                            fl = $("#" + fid);

                        $t.p.search = false;
                        if (p.multipleSearch === false) {
                            sdata[p.sField] = sdata[p.sValue] = sdata[p.sOper] = "";
                        } else {
                            sdata[p.sFilter] = "";
                        }
                        fl[0].resetFilter();
                        if (found) {
                            $(".ui-template", fil).val("default");
                        }
                        $.extend($t.p.postData, sdata);
                        if ($.isFunction(p.onReset)) {
                            p.onReset();
                        }
                        $($t).trigger("reloadGrid", [
                            {page:1}
                        ]);
                        if (p.closeAfterReset) {
                            $.jgrid.hideModal("#" + IDs.themodal, {gb:"#gbox_" + $t.p.id, jqm:p.jqModal, onClose:p.onClose});
                        }
                        return false;
                    });
                    showFilter();
                    $(".fm-button:not(.ui-state-disabled)", fil).hover(
                        function () {
                            $(this).addClass('ui-state-hover');
                        },
                        function () {
                            $(this).removeClass('ui-state-hover');
                        }
                    );
                }
            });
        }
    });
})(jQuery)