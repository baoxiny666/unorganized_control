<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎登陆</title>
</head>
<script type="text/javascript">
    var path = '<%=path%>';
    var basePath = '<%=basePath%>';
</script>
<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>static/img/favicon.ico" media="screen" />
<link rel="stylesheet" href="<%=basePath%>login/css/layer.css"/>
<script type="text/javascript" src="<%=basePath%>login/js/login.js?v=54"></script>
<script type="text/javascript" src="<%=basePath%>static/js/layer.js?v=76"></script>
<body class="userlogin_body">
    <div class="user_login">
        <div class="user_login_head">
            <div class="title_bg1"></div>
            <div class="title_bg2"><div style="margin-left: 205px;margin-top: 8px;">请选择语言：</div></div>
            <div class="select_language">
                <select class="select_lang">
                    <option value="zh_CN">简体中文</option>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="">关闭</a>
            </div>
        </div>
        <div class="user_login_body">
            <div class="body_bg1"></div>
            <div class="body_bg2">
                <span class="user_name"></span>用户名:</span><input id="username_bg"><br>
                <div style="height:10px;"></div>
                &nbsp;&nbsp;&nbsp;<span class="user_password">密码:</span><input id="password_bg">
            </div>
            <div class="body_bottom_bg">
                <div class="user_bottom" onclick="loginCheck()">
                    <input class="btn_css" type="image" src="./img/user_botton.png">
                </div>
            </div>
        </div>
        <div class="user_login_bottom">
            <div class="bottom_bg1"></div>
            <div class="bottom_bg2"></div>
            <div class="bottom_bg3"></div>
        </div>
    </div>
</body>
</html>
<style>
    .userlogin_body{
        background: url(./img/user_all_bg.gif) 50% top repeat-x rgb(34, 108, 197);
        margin: 110px -150px 0px 0px;
        font: 12px / 150% Arial,Helvetica,sans-serif;
        text-decoration: none;
    }
    .user_login{
        display: block;
        margin: 0px auto;
        width: 800px;
        height: 500px;
        border-radius: 10px;
    }
    .select_language{
        position: relative;
        margin-right: 20px;
        float: left;
        font-size: 12px;
        line-height: 25px;
        font-weight: normal;
        background: url(./img/user_top_r.gif);
        height: 116px;
        width: 180px;;
    }
    .select_lang{
        width: 100px;
        margin-top: 8px;

    }
    a{
        color: #000000;
        text-decoration: none;

    }
    .user_login_head{
        display: flex;
    }
    .title_bg1{
        background: url(./img/user_top_l.gif) no-repeat 50% top;
        width: 129px;
        height: 116px;
    }
    .title_bg2{
        background: url(./img/user_top_c.gif) no-repeat 50% top;
        width: 280px;
        height:116px;
    }
    .user_login_body{
        display: flex;
    }
    .body_bg1{
        background: url(./img/user_main_l.gif) no-repeat #bec5cc 50% top;
        width: 129px;
        height: 139px;
    }
    .body_bg2{
        background: url(./img/user_main_c.gif);
        width: 280px;
        height: 139px;
    }
    .user_name{
        line-height: 25px;
        height: 25px;
        text-align: right;
    }
    #username_bg{
        background: url(./img/user_login_name.gif) no-repeat;
        width: 165px;
        line-height: 20px;
        height: 21px;
        padding-left: 30px;
        border: none;
    }
    #password_bg{
        background: url(./img/user_login_password.gif) no-repeat;
        width:165px;
        line-height: 20px;
        padding-left: 30px;
        height: 21px;
        border: none;
    }
    .body_bottom_bg{
        background: url(./img/user_main_r.gif)#bec5cc no-repeat 50% top;;
        width: 180px;
        height: 139px;
    }
    .user_bottom{
        width: 111px;
        height: 122px;
        background: url(./img/user_botton.gif);
    }
    .btn_css{
        border-top-width: 0px;
        border-left-width: 0px;
        border-bottom-width: 0px;
        border-right-width: 0px;
    }
    .user_login_bottom{
        display: flex;
    }
    .bottom_bg1{
        background: url(./img/user_bottom_l.gif) no-repeat 50% top;
        height:117px;
        width: 129px;
    }
    .bottom_bg2{
        background:url(./img/user_bottom_c.gif) no-repeat 50% top;
        color: #fff;
        line-height: 117px;
        width: 280px;
        height: 117px;
    }
    .bottom_bg3{
        background: url(./img/user_bottom_r.gif) no-repeat 50% top;
        width: 180px;
        height: 117px;
    }
</style>
