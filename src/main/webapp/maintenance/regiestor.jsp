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
	<script type="text/javascript" src="<%=basePath%>maintenance/js/index.js?v=54"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/layer.js?v=76"></script>

	<title>无组织管理台账</title>
</head>
<body style="width:100%;height:100%;background-attachment: fixed; overflow-x: hidden; overflow-y: hidden;    margin: 0;" border="1px" margin="0px" padding="0px">
	<div>
		<span>车牌号：</span><input type="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span>车队名称：</span><input type="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span>排放阶段：</span><select style="width: 150px;"></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span>日期时间：</span><input class="easyui-datebox"></input>
		<span>至</span>&nbsp;<input class="easyui-datebox"></input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'">查询</a>&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">导入</a>&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">导出</a>&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-print'">打印</a>
	</div>
	<div class="easyui-tabs" style="width:1855px;height:850px;margin-top: 10px;">
		<div title="车辆进出台账信息" style="padding:10px">
			<table id="dg1" style="width:1650px;height:780px" data-options="
						rownumbers:true,
						singleSelect:false,
						autoRowHeight:false,
						pagination:true,
						pageSize:10">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th field="inv" width="100">车牌号</th>
						<th field="date" width="70">入场时间</th>
						<th field="name" width="70">出场时间</th>
						<th field="amount" width="120" align="right">入场图片</th>
						<th field="price" width="120" align="right">出场图片</th>
						<th field="cost" width="100" align="right">环保编码</th>
						<th field="note" width="110" align="right">注册日期</th>
						<th field="note" width="150" align="right">车辆识别代码</th>
						<th field="note" width="150" align="right">发动机号码</th>
						<th field="note" width="110" align="right">排放阶段</th>
						<th field="note" width="110" align="right">随车清单</th>
						<th field="note" width="110" align="right">行驶证</th>
						<th field="note" width="110" align="right">运输货物名称</th>
						<th field="note" width="110" align="right">运输量</th>
						<th field="note" width="110" align="right">车队名称</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
</html>
