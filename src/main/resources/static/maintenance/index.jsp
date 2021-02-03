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

	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/maintenance/css/index.css">
	<link rel="stylesheet" href="<%=basePath%>static/css/layer.css"/>
	<script type="text/javascript" src="<%=basePath%>static/maintenance/js/index.js?v=54"></script>
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
	  			<img alt="" width="25px" height="25px" src="<%=basePath%>static/maintenance/img/login_user.png">
	  		</div>
	  		<div class="login_user">${username}</div>
	  		<div class="login_quit" onclick="login_quit()">
	  			<img alt="退出登录" width="20px" height="20px" src="<%=basePath%>static/maintenance/img/login_user_quit.png">
	  		</div>

	  	</div>
	</div>


	<div id="wholeList" class="easyui-layout" style="width:1920px;height:calc(100% - 60px);">
		<div data-options="region:'west',title:'West',split:true" style="width:200px;">

		</div>
		<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
			rrrrrrr
		</div>
	</div>


	<div style="width:100%;height:calc(100% - 60px)" id="tablesize">
	     <table  id="tt" title="" class="easyui-datagrid"  style="display:none;"
				 iconCls="icon-list"
				 toolbar="#tb"  pageList="[50,100,200,300]"
				 pagination="true" pageNumber="1"
				 rownumbers="true" striped="true"
				 fit="true" idField="id"
				 nowrap="true"
				 singleSelect="true">

	     </table>
	</div>
</body>
</html>
