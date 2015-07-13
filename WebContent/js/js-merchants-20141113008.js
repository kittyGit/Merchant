$(document).ready(function(e) {
	
	$("#username").focus(function(){
		$(".username").css("border","1px solid #3da2e3");
	});
	$("#username").blur(function(){
		$(".username").css("border","1px solid #bbb");
	});
	
	$("#login_password").focus(function(){
		$(".pswd").css("border","1px solid #3da2e3");
	});
	$("#login_password").blur(function(){
		$(".pswd").css("border","1px solid #bbb");
	});
	
	$(".username").click(function(){
		$("#username").focus();
	});
	
	//登录框确认密码提示文字
	$("#login_password").focus(function(){
		$("#pass_label").css("z-index","1");
	});
		
	$("#pass_label").click(function(){
		$("#login_password").css("z-index","5").focus();
		$("#pass_label").css("z-index","3");
	});
		
	$("#login_password").blur(function(){
		
		if($("#login_password").val()==''){
			$("#login_password").css("z-index","5");
			$("#pass_label").css("z-index","10");
		}
	});
        
    //浏览器输入框不支持placeholder input=text时
        if(!placeholderSupport()){   // 判断浏览器是否支持 placeholder
    	    $('[placeholder]').focus(function() {
    	        var input = $(this);
    	        if (input.val() == input.attr('placeholder')) {
    	            input.val('');
    	            input.removeClass('placeholder');
    	        }
    	    }).blur(function() {
    	        var input = $(this);
    	        if (input.val() == '' || input.val() == input.attr('placeholder')) {
    	            input.addClass('placeholder');
    	            input.val(input.attr('placeholder'));
    	        }
    	    }).blur();
    	};
    	function placeholderSupport() {
    	    return 'placeholder' in document.createElement('input');
    	}
        
	//输入框文字
	$(".input-text").focus(function(){
		var value=$(this).val()
		if(value=="请输入优惠券编码或注册手机号码"){
			$(this).val("");
			$(this).css({"color":"#35a726","font-size":"29px","text-align":"center"})
		}
	})
	$(".input-text").blur(function(){
		var value=$(this).val()
		if(value==""||value==" "){
			$(this).val("请输入优惠券编码或注册手机号码");
			$(this).css({"color":"#a1a1a1","font-size":"16px","text-align":"left"})
		}
		else{ $(this).css({"color":"#35a726","font-size":"29px","text-align":"center"})}
	});
	
	//表格隔行变色
    $(".table-a tr").mouseover(function(){    //如果鼠标移到class为stripe的表格的tr上时，执行函数    
      $(this).addClass("hover");}).mouseout(function(){    //给这行添加class值为over，并且当鼠标一出该行时执行函数    
            $(this).removeClass("hover");}) //移除该行的class    
	$(".table-a tr:even").addClass("even");    //给class为stripe的表格的偶数行添加class值为alt 

    /*  //弹出层
	$(".close").click(function(){
		$(".tk_box").hide(70);
	});
	$(".tcshow").click(function(){
		$("#codeSpan").html($("#codeInput").val());
		$("#codeHidden").val($("#codeInput").val());
		$(".tk_box").show(70);
	});
	$('span.close').click(function(){
		$('.tk_box').hide(70);	
	});
	 $(".enter").click(function () {
	        $.post(
	        		  $("ctxHidden").val()+"/coupon/coupon_order_use.action",
	        	      {
	        	        code:$("#codeHidden").val()
	        	      },
	        	      function (data) //回传函数
	        	      {
	        	    	  location.href = $("ctxHidden").val()+"/coupon/coupon_order_index.action?qp.msg=123";
	        	      }
	        );
	    });*/
    
});
function isnumber(obj){   
    reg=/^[0-9]*$/;   
   if(!reg.test(obj)){   
        $(".error_code").html("请输入正确的优惠券编码或注册手机号码！");   
    }else{   
        $(".error_code").html("");   
    }   
}

