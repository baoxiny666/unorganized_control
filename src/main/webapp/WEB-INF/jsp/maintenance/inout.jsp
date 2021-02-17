<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String controllerDoor = request.getParameter("controllerDoor");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript">
		var path = '<%=path%>';
		var basePath = '<%=basePath%>';
		var controllerDoor = '<%=controllerDoor%>';
	</script>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>img/favicon.ico" media="screen" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>maintenance/css/index.css">
	<link rel="stylesheet" href="<%=basePath%>css/layer.css"/>
	<script type="text/javascript" src="<%=basePath%>maintenance/js/inout.js?v=666"></script>
	<script type="text/javascript" src="<%=basePath%>js/layer.js?v=76"></script>

	<script>

		$.extend($.fn.datagrid.methods, {
			fixRownumber : function (jq) {
				return jq.each(function () {
					var panel = $(this).datagrid("getPanel");
					var clone = $(".datagrid-cell-rownumber", panel).last().clone();
					clone.css({
						"position" : "absolute",
						left : -1000
					}).appendTo("body");
					var width = clone.width("auto").width();
					if (width > 25) {
						//多加5个像素,保持一点边距
						$(".datagrid-header-rownumber,.datagrid-cell-rownumber", panel).width(width + 5);
						$(this).datagrid("resize");
						//一些清理工作
						clone.remove();
						clone = null;
					} else {
						//还原成默认状态
						$(".datagrid-header-rownumber,.datagrid-cell-rownumber", panel).removeAttr("style");
					}
				});
			}
		});
	</script>
	<title>无组织管理台账</title>
</head>
<body style="width:100%;height:100%;background-attachment: fixed; overflow-x: hidden; overflow-y: hidden;margin: 0;" border="1px" margin="0px" padding="0px">
	<div id="ttt">
		<span>车牌号：</span><input type="text" id="inLicensePlate">
		<span>车队名称：</span><input type="text" id="motorCadeName">
		<span>门信息：</span>
		<select style="width: 150px;" id="inControllerNo">
			<option value="-1">全部</option>
			<option value="CT000013">一号门入口</option>
			<option value="CT000003">二号门入口</option>
			<option value="CT000005">四号门入口</option>
			<option value="CT000007">五号门入口</option>
			<option value="CT000009">六号门入口</option>
			<option value="CT000015">九号门南进口</option>
			<option value="CT000016">九号门北进口</option>
			<option value="CT000011">十一号门入口</option>
		</select>


		<span>排放阶段：</span>
		<select style="width: 150px;" id="disChargeStage">
			<option value="-1">全部</option>
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="D">电动</option>
			<option value="X">无排放阶段</option>
		</select>
		<span>日期时间：</span><input class="easyui-datetimebox" id="startTime"></input>
		<span>至</span>&nbsp;<input class="easyui-datetimebox" id="endTime"></input>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:reloadData()" data-options="plain:true,iconCls:'icon-search'">查询</a>&nbsp;&nbsp;&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="javascript:exportGridData()" data-options="plain:true,iconCls:'icon-remove'">导出</a>&nbsp;&nbsp;&nbsp;
	</div>
	<table  id="inoutTable" style="width:100%;height:800px">

	</table>

	<div class="easyui-window" title="图像" id="picsWindow" style="display:none;" closed="true">
		<div>
			<div class="datagrid-toolbar">
				<script type="text/javascript">
					function showMessagePics(params){
						var content = '<img src="'+params+'" width="100%" height="100%" ></img>';
						$("#picsWindow").window({
							content:content,
							title: "图像",
							width: 600,
							modal: false,
							closed: false,
							height: 650,
							inline:false,
							onClose:function(){

								$(this).window("close");

							}
						});
						$("#picsWindow").window("center");
					}
				</script>
			</div>
		</div>
	</div>
</body>
</html>
