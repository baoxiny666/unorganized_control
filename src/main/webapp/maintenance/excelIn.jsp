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
        var path = "<%=path%>";
        var basePath = "<%=basePath%>";
    </script>
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-1.11.1.min.js"></script>
    <script src="<%=basePath%>static/js/base64_ie.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>static/img/favicon.ico" media="screen" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>maintenance/css/excelIn.css">
<script type="text/javascript">

</script>
</head>
<body style="width:100%;height:100%;" border="1px" margin="0px" padding="0px">
	<form id="excelInfile" method="post" style="line-height: 59px; " enctype="multipart/form-data" target="dummyiframe">
        <input class="easyui-filebox" label="导入文件:" labelPosition="top" data-options="prompt:'请选择文件" style="width:100%">
    </form>

    <div style="text-align:center;padding:5px 0;clear:both">
        <a href="javascript:void(0)" class="easyui-linkbutton" id="submitForm" onclick="submitForm()" style="width:80px">提交</a>
    </div>
</body>
<script type="text/javascript" src="<%=basePath%>maintenance/js/excelIn.js"></script>
</html>
