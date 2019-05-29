<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
	 <link href="${APP_PATH}/static/bootstrap/css/style.css" rel='stylesheet' type='text/css'/>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/jquery-1.11.2.min.js"></script>
</head>
<body>
<script>$(document).ready(function (c) {
    $('.close').on('click', function (c) {
        $('.login-form').fadeOut('slow', function (c) {
            $('.login-form').remove();
        });
    });
});
</script>
<section class="login-form-wrap">
    <!--SIGN UP-->
    <h1>网上论坛后台管理系统</h1>
    <div class="login-form">
        <div class="clear"></div>
        <div class="avtar">
            <img src="${APP_PATH}/static/img/login/avtar.png"/>
        </div>
        <div style="color: white">崔玲玲作品</div>
        <form action="${APP_PATH}/adminController/getLogin" method="post">
            <input type="text" id="username" name="aname" placeholder="用户名">
            <input type="password" id="password" name="apassword" placeholder="密码">
            <div class="signin">
            <input id="login" type="button" value="登陆"  onclick="this.form.submit()">
        </div>
        </form>
    </div>
</section>
<div class="copy-rights">
    <p>Copyright @2018-2019 All rights reserved
        <a href="https://www.haut.edu.cn/" target="_blank" title="河南工业大学">河南工业大学</a>
    </p>
</div>

</body>
</html>