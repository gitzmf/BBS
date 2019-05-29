$(document).ready(function() {
	onfocus();
	$('#login').click(function(e) {
		submitform();
	});
});
function onfocus(){
	$("#aname").focus();
}


//回车登录
$(document).keydown(function(e){
	if(e.keyCode == 13) {
		submitform();
	}
});

function submitform(){
	$("#errormsg").text("");
	if($("#username").val() == ""){
		$("#errormsg").text("请输入用户名！");
		return false;
	}
	if($("#password").val() == ""){
		$("#errormsg").text("请输入密码！");
		return false;
	}
	
	var actionurl = $('form').attr('action');
	var username = "aname="+$("#username").val();
	var password = "apassword="+$("#password").val();
	var formData = username+"&"+password;
	
	loading('登陆中..', 1);
	setTimeout(function () { 
		unloading();
		window.location.href = actionurl;			
    }, 1000);
	
}

//加载信息
function loading(name, overlay) {
	$('section').append('<div id="overlay"></div><div id="preloader">' + name + '</div>');
	if (overlay == 1) {
		$('#overlay').css('opacity', 0.1).fadeIn(function() {
			$('#preloader').fadeIn();
		});
		return false;
	}
	$('#preloader').fadeIn();
}

function unloading() {
	$('#preloader').fadeOut('fast', function() {
		$('#overlay').fadeOut();
	});
}
