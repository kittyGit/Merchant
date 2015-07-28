var WXWB_UTIL; // 实用工具类
WXWB_UTIL = {
    //左边去除
    ltrim: function (text) {
        return text == null ? "" : text.toString().replace(/^\s+/ ,"");
    }
   //右边去除
   ,rtrim: function (text) {
        return text == null ? "" : text.toString().replace(/\s+$/ ,"");
   }
   //左右空格去除
   ,trim: function (text) {
       return this.ltrim(this.rtrim(text));
   }
   //计算字符串长度
   ,msglen: function (text) { // 微博字数计算规则 汉字 1 英文 0.5 网址 11 除去首尾空白
        text = text.replace(new RegExp("((news|telnet|nttp|file|http|ftp|https)://){1}(([-A-Za-z0-9]+(\\.[-A-Za-z0-9]+)*(\\.[-A-Za-z]{2,5}))|([0-9]{1,3}(\\.[0-9]{1,3}){3}))(:[0-9]*)?(/[-A-Za-z0-9_\\$\\.\\+\\!\\*\\(\\),;:@&=\\?/~\\#\\%]*)*","gi"),'填充填充填充填充填充填');
        return Math.ceil(($.trim(text.replace(/[^\u0000-\u00ff]/g,"aa")).length)/2);
   }
   //文字超长截取 text:要截取的字符串,max:保留长度,suff:超长代替字符串
   ,limit: function (text ,max ,suff) {
        if (text == null) {
            return "";
        }
        text = text.toString();
        suff = suff || "...";
        if (text.length <= max) {
            return text;
        } else {
            return text.substring(0,max) + suff;
        }
   }
   //截取文件名称长度 filename:文件名称,max:保留长度
   ,limitFileName: function (filename,max) {
        max = max || 10;
        var fileExt;
        var fileNameArr = filename.split(".");
        if (fileNameArr.length > 1) {
            fileExt = fileNameArr.splice(-1);
            return this.limit(fileNameArr.join("") ,max ,"") + "." + fileExt.join("");
        } else {
            return this.limit(fileNameArr[0] ,max ,"");
        }
   } 
   // 输入框中指定位置插入文本
   ,insertText: function (text ,caret ,holder) {

       var pre;
       var suff;
       var holderText;

       caret = caret || 0;

       if (holder.nodeName) {
           holder = $(holder);
       }

       holderText = holder.val();
       pre = holderText.substr(0,caret);
       suff = holderText.substr(caret);
       holderText = [pre,text,suff].join("");
       holder.val(holderText);
       holder.focus();
       holder.cursorPos([pre,text].join("").length);
   }
};

//显示日期和农历
function CalConv() {
	var today = new Date();
	var SolarYear = today.getFullYear();
	var SolarMonth = today.getMonth() + 1;
	var SolarDate = today.getDate();
	//var Weekday = today.getDay();
    //var d=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");

    document.write("", SolarYear,"年",SolarMonth,"月",SolarDate,"日");
}

//提示
var showAlertTip = function(str,cssobj,tarobj,timer) {
	if(str == null || str == "" || str == "null"){
		return ;
	}
	
	$(".errortip").fadeOut("slow");
	cssobj = cssobj || {};
	timer = timer || false;
	this.tip = function (cssobj) {
		var	o = $("<div class=\"errortip\"><b class=\"c\">◆</b><b class=\"b\">◆</b><div class=\"mes\"></div></div>").appendTo($("body"));
		return o.css(cssobj);
	}(cssobj);
	this.reset =function (tarobj) {
		var rect=tarobj[0].getBoundingClientRect(),dh=document.body.scrollTop + document.documentElement.scrollTop;
		var tipHeight = dh+rect.top+tarobj.height()+10;
		tipHeight = tipHeight < $(window).height()-20 ? tipHeight : rect.top+10;
		tip.css({"top":tipHeight,"left":rect.left});
		tarobj[0].scrollIntoView(false);
	};
	this.autoClose = function (timer) {
		setTimeout(function(){
		tip.fadeOut("slow");
		},timer);
	};
	this.show = function (str){
		this.tip.css("display","inline-block").find(".mes").html(str);
	};
	if (tarobj) {
		this.reset(tarobj);	
	}
	this.show(str);
	if (timer) {
		this.autoClose(timer);	
	}
};


var WX_VALIDATOR; //数据验证封装
WX_VALIDATOR = {
    // 错误信息中的label代表将被替换的字段,|代表默认值 
    _regexp: {
                required : [/.+/,"[label]不能为空"] // 字段为必填
                ,email : [/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,"邮箱无效"] // 邮箱
                ,chinese :  [/^[\u4E00-\u9FA5]+$/,"[label]格式不正确，只能输入中文字符"] // 验证中文
                ,username : [/^[a-z]\w{3,}$/i,"[label]只能由a-zA-Z0-9组成，且长度大于3，不能以数字开头"] //用户名
                ,regusername : [/^[a-z]\w{2,14}$/i,"[label]无效"] // 用户名
                ,regpassword : [/^.{3,}$/i,"[label]不能少于3个字符"] // 用户密码
                ,uname : [/^[^<>|\"]{3,15}$/i,"[label]只能含3-15个字符，不能包含敏感字符"] //由3-15个字符组成，不能包含<|"
                ,pwd : [/^.{3,15}$/i,"[label]无效，请使用3-15位任意字符。"] // 密码        
                ,number:[/^\d+(\.\d+)?$/i,"[label]无效，请使用正整数。"] //验证数字
                ,date:[/^\d{4}-\d{2}-\d{2}$/i,"[label]无效,请使用正确的日期。"]//验证日期
                ,filedirectory:[/^(([a-zA-Z]:(\\|\/))([a-zA-Z0-9]+(\\|\/))*)([a-zA-Z0-9]+)$/i,"[label]无效,路径只支持字母数字。"]//验证文件目录
                ,ip:[/^(?:(?:\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.){3}(?:\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])$/i,"[label]无效,请使用正确IP地址格式。"]//验证IP地址
                ,http:[/^(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:\/~\+#]*[\w\-\@?^=%&amp;\/~\+#])?$/i,"[label]无效,请使用正确HTTP地址格式。"]//验证HTTP地址
                ,phone : [/^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/i,"[label]无效，请使用正确的电话号码格式。"] // 电话号码(xxx-xxxxxxx)
                ,mobilephone : [/^1[1-9]\d{9}$/i,"[label]无效，请使用正确的手机号码格式。"] // 手机号码11位(1xxxxxxxxxx)
                ,zipcode : [/^[1-9]{1}(\d+){5}$/i,"[label]无效，请使用正确的邮政编码格式。"] 
    }
};

(function () { //根据正则表达式自动添加方法
    var validator = null;
    for ( validator in WX_VALIDATOR._regexp) {
        if ( WX_VALIDATOR._regexp.hasOwnProperty(validator) ) {
            // 返回空代表验证通过，否则返回具有一定规则信息的错误信息
            if (validator != "uname") {
            WX_VALIDATOR[validator] = new Function("str","return WX_VALIDATOR._regexp[\"" + validator +"\"][0].test(str) ? \"\": WX_VALIDATOR._regexp[\"" + validator + "\"][1]");
        	} else {
        	WX_VALIDATOR[validator] = new Function("str","return WX_VALIDATOR._regexp[\"" + validator +"\"][0].test(str.replace(/[^x00-xff]/g,'bb')) ? \"\": WX_VALIDATOR._regexp[\"" + validator + "\"][1]");	
        	}
        }
    }
}());
//加载验证form
(function(){
	/**
	 * 表单验证 标签加有data-validator才进行验证
	 * 验证类型 data-validator  参数值为WX_VALIDATOR._regexp中和类型列表
	 * 标签加载显示的默认值 data-placeholder
	 * 是否必须验证 data-must  true:必须验证 false:不一定进行验证(默认值)  解决有些不必填写，写了但写错的检查。
	 * 允许的最长长度 data-length 默认不限制
	 * 出错提示语句  date-lable
	 */
	formValidate = function () {
	    var validatorErrorInfo;
	    var validatorList;
	    var strValidator;
	    var allowSubmit = true;
	    var placeholder;
	    var dataMust;
	    var val = null;
	    $(":file[data-validator],:hidden[data-validator],:text[data-validator],:password[data-validator],textarea[data-validator],select[data-validator]").each(function(i){
	        //验证种类列表
	    	var that = $(this);
	    	strValidator = that.attr("data-validator");	    
	    	validatorList= strValidator.split(",");
	    	placeholder = that.attr("data-placeholder");
	    	//检查select 是否选择 否则清空数据
	    	if(that.get(0).tagName === "SELECT"){
	    		if(that.val() === "0"){
	    		   val = "";
	    		}
	    	}else{
	    		val = WXWB_UTIL.trim(that.val());
	    	}
	    	
	    	dataMust = that.attr("data-must") || false;
	    	dataLength = that.attr("data-length") || 0;
	    	for(var i=0;i<validatorList.length;i++){	    	
	    		//默认值相同则不用比较 并且数据不是必须填
	    		if(placeholder !== null && placeholder !== undefined && placeholder === val){
	    			if(!dataMust){
	    				continue;
	    			}
	    			val = "";	    		    
	    		}
	    		//如果超过长度则返回false
	    		if(parseInt(dataLength) >0 && WXWB_UTIL.msglen(val) > parseInt(dataLength)){
	    		     showAlertTip(that.attr("date-lable")+"值超过长度"+dataLength,{},that,2000);
		    		 allowSubmit = false;
		    		 return false;
	    		}
	    		//默认值不相同则比较
	    	    validatorErrorInfo = WX_VALIDATOR[validatorList[i]](val);
		    	if(validatorErrorInfo){
		    		 validatorErrorInfo = validatorErrorInfo.replace(/\[label.*?\]/ig,that.attr("date-lable")); 
		    		 showAlertTip(validatorErrorInfo,{},that,2000);
		    		 allowSubmit = false;
		    		 return false;
		    	 }
	    	}
	    });
	    
	    return allowSubmit;
	};
	
	/**
	 * 查询提交验证 去除查询框里的默认值
	 */
	queryValidator = function(thatBtn,action,form){
		var that = $(this);
		form = form || "formList";
		var allowSubmit = formValidate();
		var placeholder;
		var val;
		if(allowSubmit){
			$(":text[data-placeholder],:password[data-placeholder],textarea[data-placeholder]").each(function(i){
				placeholder = $(this).attr("data-placeholder");
				val = $(this).val();
				if(placeholder !== null && placeholder !== undefined && placeholder === val){
	    		    $(this).val("");
	    		}
			});
			//提交	
			var formName="#";
			var url = "";	
			if(!that.attr("data-url") && thatBtn){
				that = thatBtn;
			}
			
			if(that.attr("data-url")){
				formName += that.attr("data-form") || "formList";
				url = that.attr("data-url");
			}else if(action && form){
				formName += form;
				url = action;
			}
			
			if(url && formName){
//				alert(url+" "+formName);
				$(formName).attr("action",url);
				$(formName).submit();
			}			
		}else{
			return allowSubmit;
		}
	};
}());

//对话框控件
var WX_DIALOG;
var CURRENT_PAGE_BG_ID;
WX_DIALOG = {
    _id: 0,
    _zindex: 999,

    _msgboxTextHeight: function (text,width) { // 模拟计算文字高度
            var dummy = $("<div class=\"wxDialog\"><div class=\"msgbox\"><div class=\"msgtext\">" + text + "</div></div></div>");
            var dummycss;
            var dummyHeight;
            dummy.css({
                visibility:"hidden"
            });
            dummy.append(text); // 修正
            $("body").append(dummy);
            dummyHeight = dummy.find(".msgtext").height();
            dummy.remove();
            return dummyHeight;
    },
    
    // 移除所有的对话框
    _disposeAllDialog: function () {
        var dialog = $(".wxDialog"); // 对话框主层
        var modalBgLayer = $(".wxDialogModalBg"); // 取背景层
        dialog.remove();
        modalBgLayer.animate({
            opacity:0
        },200,function () {
            modalBgLayer.remove();
        });
    },

    // 移除指定ID的对话框
    _disposeDialog: function (id) {
        $("#dialog"+id).remove();
        $("#dialogModalBg"+id).remove();        
    },
    resizeTo: function (id,width,height) {
        $("#dialog"+id).css({
            width: width,
            height: height
        });
    },
    _createDialog: function (options) { // 对话框初始化
        var dialog;
        var dialogClose;
        var innerDOM;
        var dialogHtml = "<div class=\"wxDialog\" data-id=\"" + this._id + "\" id=\"dialog" + this._id + "\">"
                        +"<div class=\"wxDialogBg\"><iframe></iframe></div>"
                        +"<div class=\"wxDialogMain\"></div>";
        if(options && options.showClose){ // 是否显示关闭按钮
            dialogHtml += "<a class=\"close\" href=\"javascript:void(0);\" title=\"关闭\"></a>";
        }
        dialogHtml += "</div>";
        dialog = $(dialogHtml);
        
        dialog.css({
            zIndex: WX_DIALOG._zindex
        });

        dialogClose = dialog.find(".close");

        if (dialogClose.length>0) { // 关闭按钮
            dialogClose.click(function () {
            	if (options && options.onClose) {
            		options.onClose();	
            	}
                WX_DIALOG._disposeDialog(dialog.attr("data-id"));
            });
        }
        
        if(options && options.autoClose){
            setTimeout(function () {
                WX_DIALOG._disposeDialog(dialog.attr("data-id"));
                if (options.autoClose.callback) {
                    options.autoClose.callback();
                }
            },(options.autoClose.wait || 2000));
        }
        
        if(options && options.getDOM){ // 添加DOM(jQuery Object)
            innerDOM = options.getDOM();
            dialog.find(".wxDialogMain").append(innerDOM);
        }
        
        dialog.css({
            width: options.width + "px",
            height: options.height + "px",
            top: options.top + "px",
            left: options.left + "px"
        });
        return dialog; 
    },

    _merge: function (obj1,obj2) {
        for (var k in obj1) {
            if (obj1.hasOwnProperty(k)) {
                if (obj2.hasOwnProperty(k)) {
                    obj1[k] = obj2[k];
                }
            }
        }
        return obj1;
    },

    _init: function (options) {
        
        var dialog = $(".wxDialog"); // 对话框主层
        var modalBgLayer = $(".wxDialogModalBg"); // 取背景层

        this._id ++;
        this._zindex ++;
        
        if (options && options.modal){ // 无背景层,调用者要求使用背景层
            modalBgLayer = $("<div class=\"wxDialogModalBg\" id=\"dialogModalBg" + this._id + "\"><iframe></iframe></div>");
            modalBgLayer.css({
                opacity: 0.35,
               zIndex: WX_DIALOG._zindex
            });
            
            $("body").append(modalBgLayer);
            
        } 
        
        dialog = this._createDialog(options);
        dialog.slideDown(300);
        $("body").append(dialog);

        if (options.callback) {
            options.callback(dialog);
        }

        return this._id;
    },
    
    msgbox: function (msgtype,text,options){ // 消息提示, msgtype为error,warning,info，text为要显示的文字
        msgtype = msgtype || "warning";
        var textHeight = this._msgboxTextHeight(text,140/*信息区文字宽度*/);
        var msgboxWidth = 220; // 信息提示框宽度
        var msgboxHeight = textHeight + 30 ; // 信息提示框高度
        var msgboxLeft = ($("body").width() - msgboxWidth) / 2; // 水平居中
        var msgboxTop = (document.documentElement.scrollTop || document.body.scrollTop) + (options.verticalAlign === "middle" ? 1:0.618) * (document.documentElement.clientHeight - msgboxHeight) / 2; // 黄金分割垂直居中
        var defaultOptions = {
            showClose: true,
            modal: true,
            autoClose: {
                wait: 2000,
                callback: null
            }
        };
        defaultOptions = this._merge(defaultOptions,options);
        this._init({
            modal: defaultOptions.modal,
            showClose: defaultOptions.showClose,
            autoClose: defaultOptions.autoClose,
            width: msgboxWidth,
            height: msgboxHeight,
            top: msgboxTop,
            left: msgboxLeft,
            getDOM: function () {
                var msgInfo = "<div class=\"msgboxtitle\">系统提示</div><div class=\"msgbox\"><div class=\"msgicon\" style=\"height:"+textHeight+"px;\"><div class=\"icon "+msgtype+"\"></div></div><div class=\"msgtext\">"+text+"</div></div>";
                return $(msgInfo);
            }
        });
    },
    
    _tipbox: function (type ,text ,modal ,callback) {
        type = type || "success";
        this.msgbox(type, text,{
            showClose: false,
            "modal": modal,
            autoClose: {
                wait: 2000,
                callback: callback
            }
        });
    },

    tipbox: function (type ,text ,callback) {
        this._tipbox(type ,text ,false ,callback);
    },

    modaltipbox: function (type ,text ,callback) {
        this._tipbox(type ,text ,true ,callback);
    },

    confirmbox: function (options) {
        var confirmboxWidth = 200;
        var confirmboxHeight = 80;
        var confirmboxLeft = options.left || ($("body").width() - confirmboxWidth) / 2; // 水平居中
        var confirmboxTop = options.top || ((document.documentElement.scrollTop || document.body.scrollTop) + 0.618 * (document.documentElement.clientHeight - confirmboxHeight) / 2); // 黄金分割垂直居中
        var text = options.text || "请确认";
        this._init({
            modal: true,
            showClose: false,
            width: confirmboxWidth,
            height: confirmboxHeight,
            top: confirmboxTop,
            left: confirmboxLeft,
            callback: function (dialog) {
                dialog.find("button[class=wxok]").click(function () {
                    if (options.ok) {
                        options.ok();
                    }
                    // 移除本身对话框
                    WX_DIALOG._disposeDialog(dialog.attr("data-id"));
                });
                dialog.find("button[class=wxcancel]").click(function () {
                    if (options.cancel) {
                        options.cancel();
                    }
                    // 移除所有对话框
                    WX_DIALOG._disposeDialog(dialog.attr("data-id"));
                });
            },
            getDOM: function () {
                var msgInfoText = "<div class=\"msgboxtitle\">系统提示</div><div class=\"confirmbox\"><div class=\"confirmtext\"><span class=\"icon\"></span>"+text+"</div><div class=\"confirmbtns\"><button class=\"wxok\">确认</button><button class=\"wxcancel\">取消</button></div></div>";
                var msgInfo = $(msgInfoText);

                return msgInfo;
            }
        });
    },
    
    createIFrame: function (options,width,height) {
		var boxWidth = width || 500;
		var boxHeight = height || 410;
		var boxLeft = ($("body").width() - boxWidth) / 2;
		var boxTop = (document.documentElement.scrollTop || document.body.scrollTop) + 1 /*0.618*/ * (document.documentElement.clientHeight - boxHeight) / 2;
		this._init({
		   modal: true
		   ,showClose: true
		   ,width: boxWidth
		   ,height: boxHeight
		   ,top: boxTop
		   ,left: boxLeft
		   ,onClose:function(){
			   if(options && options.onClose){
				   options.onClose();
			   }
		   }
		   ,getDOM: function () {
			    if(options.action){
			    	if (options.action.indexOf("?") > 0) {
			    		options.action += "&random=" + new Date().Format();
					} else {
						options.action += "?random=" + new Date().Format();
					}
			    }			    
			    var manager = "<iframe id=\"ediFrame\" src=\"" + options.action + "\" frameBorder=\"0\"></iframe>";
	            manager = $(manager);
	            manager.css({
	                width: boxWidth
	                ,height:boxHeight
	                ,border:0
	            });
	            return manager;
		   } 
		}); 
	},

	pageInit: function (text,msgtype){ // 页面加载初始化, msgtype为error,warning,info，text为要显示的文字
		text = text || "页面正在为您努力加载.......";
        msgtype = msgtype || "info";
        var options = {verticalAlign: "middle"};
        var textHeight = 10;//this._msgboxTextHeight(text,10/*信息区文字宽度*/);
        var msgboxWidth = 280; // 信息提示框宽度
        var msgboxHeight = textHeight + 30 ; // 信息提示框高度
        var msgboxLeft = ($("body").width() - msgboxWidth) / 2; // 水平居中
        var msgboxTop = (document.documentElement.scrollTop || document.body.scrollTop) + (options.verticalAlign === "middle" ? 1:0.618) * (document.documentElement.clientHeight - msgboxHeight) / 2; // 黄金分割垂直居中
        
        CURRENT_PAGE_BG_ID = this._init({
            modal: true,
            showClose: false,
            autoClose: false,
            width: msgboxWidth,
            height: msgboxHeight,
            top: msgboxTop,
            left: msgboxLeft,
            getDOM: function () {
                var msgInfo = "<div class=\"msgbox\"><div class=\"msgicon\" style=\"height:"+textHeight+"px;\"><div class=\"icon "+msgtype+"\"></div></div><div class=\"msgtext\" style=\"width:200px;\">"+text+"</div></div>";
                return $(msgInfo);
            }
        });
    },    
    unPageLoad: function () {
    	// 移除加载提示对话框
    	if(CURRENT_PAGE_BG_ID){
    		this._disposeDialog(CURRENT_PAGE_BG_ID);
    	}    	
    }
};

//获取文字长度　
function _getStrLength(c) {
	var b;
	var a;
	for (b = 0, a = 0; b < c.length; b++) {
		if (c.charCodeAt(b) < 128) {
			a++;
		} else {
			a = a + 2;
		}
	}
	return a;
}

var broswerFlag;
$(function(){
	if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
		var g = window.navigator.userAgent.substring(30, 33);
		if (g == "6.0") {
			broswerFlag = "IE6";
		} else {
			if (g == "7.0") {
				broswerFlag = "IE7";
			} else {
				if (g == "8.0") {
					broswerFlag = "IE8";
				}
			}
		}
	} else {
		if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
			broswerFlag = "Firefox";
		} else {
			if (window.navigator.userAgent.indexOf("Opera") >= 0) {
				broswerFlag = "Opera";
			} else {
				if (window.navigator.userAgent.indexOf("Safari") >= 1) {
					broswerFlag = "Safari";
				} else {
					broswerFlag = "Other";
				}
			}
		}
	}
	
	//button按钮加载样式
	$(":button,:submit,:reset").each(function() {
			if (!$(this).attr("class")) {
				$(this).addClass("button");
				var C = _getStrLength($(this).text());
				if (C < 5) {
						$(this).width(50);
				}
				var e = 0;
				var D = 50;
				e = _getStrLength($(this).filter(":has(span)").find("span").text());
				if (e != 0) {
					D = 20 + 7 * e + 10;
				}
				if (broswerFlag == "Firefox" || broswerFlag == "Opera" || broswerFlag == "Safari") {
					$(this).filter(":has(span)").css( {
						paddingLeft : "5px",
						width : D + 8 + "px"
					});
				} else {
					$(this).filter(":has(span)").css( {
						paddingLeft : "5px",
						width : D + "px"
					});
				}
				$(this).filter(":has(span)").find("span").css( {
					cursor : "default"
				});
			}
	});
	
});

Date.prototype.Format = function(formatStr){
    var str = formatStr || "yyyyMMddHHmmss";   
    var Week = ['日','一','二','三','四','五','六'];  
  
    str=str.replace(/yyyy|YYYY/,this.getFullYear());   
    str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));   
  
    str=str.replace(/MM/,this.getMonth()>9?this.getMonth().toString():'0' + this.getMonth());   
    str=str.replace(/M/g,this.getMonth());   
  
    str=str.replace(/w|W/g,Week[this.getDay()]);   
  
    str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());   
    str=str.replace(/d|D/g,this.getDate());   
  
    str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());   
    str=str.replace(/h|H/g,this.getHours());   
    str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());   
    str=str.replace(/m/g,this.getMinutes());   
  
    str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());   
    str=str.replace(/s|S/g,this.getSeconds());   
  
    return str;   
};


//var WX_API;
//WX_API = {
//	queryInfoCategoryList:function(options,callback){
//		$.post("InfoColumnSetItems.do", options, callback , "json");
//	},
//	delAdvertImg:function(options,callback){
//		$.post("DelAttrament.do", options, callback , "json");
//	}
//};
