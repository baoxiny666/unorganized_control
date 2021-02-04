<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script type="text/javascript">
		var path = '<%=path%>';
		var basePath = '<%=basePath%>';
		var username = '${username}';
		var uuidindex = '${uuidindex}';
	</script>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.min.js"></script>
	<script src="<%=basePath%>static/js/base64_ie.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>static/img/favicon.ico" media="screen" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>maintenance/css/index.css">
	<link rel="stylesheet" href="<%=basePath%>static/css/layer.css"/>

	<script type="text/javascript" src="<%=basePath%>static/js/layer.js?v=76"></script>

	<title>无组织管理台账</title>
</head>
<body style="width:100%;height:100%;background-attachment: fixed; overflow-x: hidden; overflow-y: hidden;    margin: 0;" border="1px" margin="0px" padding="0px">
    <div class="top">
	  	<div class="top_left_one">
	  	</div>
	  	<div class="top_left_two">
	  		台账相关
	  	</div>
	  	<div class="top_right_one">
	  		<div class="login_pic">
	  			<img alt="" width="25px" height="25px" src="<%=basePath%>maintenance/img/login_user.png">
	  		</div>
	  		<div class="login_user">${username}</div>
	  		<div class="login_quit" onclick="login_quit()">
	  			<img alt="退出登录" width="20px" height="20px" src="<%=basePath%>maintenance/img/login_user_quit.png">
	  		</div>

	  	</div>
	</div>


	<div id="wholeList" class="easyui-layout">
		<div data-options="region:'west',title:'菜单',split:true" style="width:200px;height:100%">
			<ul class="easyui-tree" id="tree">
				<%--<li>
					<span>无组织管控车辆</span>
					<ul class="main_left">
						<li onclick="qiehuan(this);"  attributes="<%=basePath%>maintenance/regiestor.jsp"><span>车辆登记台账</span></li>
						<li onclick="qiehuan(this);"  attributes="<%=basePath%>maintenance/inoutA.jsp"><span>A台账车辆进出</span></li>
						<li onclick="qiehuan(this);"  attributes="<%=basePath%>maintenance/inoutB.jsp"><span>B台账车辆进出</span></li>
					</ul
				</li>--%>
			</ul>
		</div>
		<div data-options="region:'center',title:''" id="centeriframe" style="padding:5px;background:#eee;width:1700px;height:100%;">
		<%--	<iframe align="center" id="iframeeducation" name="iframeeducation" border=0 frameborder=0 scrolling="AUTO"
					width="100%" height="100%" src="">
			</iframe>--%>
		</div>
	</div>



</body>
<script type="text/javascript" src="<%=basePath%>maintenance/js/index.js?v=34"></script>
</html>
