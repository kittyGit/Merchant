
$(function(){
	//数据列表单双行样式
	$(".editorTab tr:even").addClass("ItemOdd");
	
	/**
	 * 编辑提交
	 */
	$(":button[data-type='finishBtn']").on("click",function(){
	    var that = $(this);
	    queryValidator(that);
	});
	
	/**
	 * 取消
	 */
	$(":button[data-type='cancel']").on("click",function () {	
		top.window.reloadMainFrame();
    });   
	
	//重新设置页面高度
	$(".contentPanel").css("height",top.$("#ediFrame").get(0).offsetHeight-$(".editorTitle2").get(0).offsetHeight-$(".editorBottom").get(0).offsetHeight);
	//取消加载提示
	top.window.WX_DIALOG.unPageLoad();	
	/**
	 * 编辑成功关闭弹出层 并刷新当前页面
	 */
	function successClose(){
		var objMsg = $(".showMsg");
		var strMsg = objMsg.attr("data-msg") || "";
		if(!strMsg){
			return;
		}
		
		var jsonMsg = $.parseJSON(strMsg);
		objMsg.html(jsonMsg.msg);
	    if(jsonMsg.ret==0){	    
	    	objMsg.css({"color":"green"});
	    	//top.window.reloadMainFrame();
	    	var autoClose = function(timer){   		
	    	     var resetBtn = $("<input type=\"button\" value=\"5秒后关闭，继续新增请点！\" class=\"button\" />");
	    	     $(".editorBottom").append(resetBtn);
	    	     resetBtn.animate({
	    	            opacity:0
	    	            //width:0
	    	        },timer,function () {
	    	        	top.window.reloadMainFrame();
	    	     });
	    	     
	    	     resetBtn.click(function(){
	    	    	 $("#formList")[0].reset();
	    	    	 $("input:text,input:hidden,input:password,textarea").val("");
	    	    	 $(this).stop();
	    	    	 $(this).remove(); 
	    	     });
	    	};
	    	autoClose(5000); 
	    }
	}
	successClose();
});

