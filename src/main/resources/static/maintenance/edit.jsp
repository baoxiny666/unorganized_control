<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String dataid = request.getParameter("dataid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	var path = "<%=path%>";
	var basePath = "<%=basePath%>";
	var dataid = "<%=dataid%>";
</script>
<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.min.js"></script>
<script src="<%=basePath%>static/js/base64_ie.js"></script>
<script type="text/javascript" src="<%=basePath%>static/easyui/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=basePath%>static/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>static/img/favicon.ico" media="screen" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easyui/themes/default/easyui.css">

<link rel="stylesheet" type="text/css" href="<%=basePath%>static/maintenance/css/edit.css">
<title>质保书维护</title>
<script type="text/javascript">

	$.extend($.fn.validatebox.defaults.rules, {
		usercontent : {// 验证身份证 
	        validator : function(value) { 
	            return /^[\u4e00-\u9fa5]+|[a-zA-Z0-9]+$/.test(value); 
	        }, 
	        message : '不能输入特殊符号' 
	    },
	    accountexsit:{
	    	validator:function(value){
	    		var rex = /^[\u4e00-\u9fa5]+|[a-zA-Z0-9]+$/;
	            if(rex.test(value))//手机号码正确的话，校验是否已存在
	            {
	                var url = basePath+'/user/userValidate.do?uname='+value;
	                var ret = $.ajax({url:url,async:false,cache:false,type:"post"}).responseText;//这里一定要用这种方式，如果是在ajax的回调函数里面return就不行。
	                var b = ret=="true";
	                if(!b){
	                    $.fn.validatebox.defaults.rules.accountexsit.message = '用户名已存在';
	                }
	                return b;
	            }else{
	                $.fn.validatebox.defaults.rules.accountexsit.message = '不能有特殊符号';
	                return false;
	            }
	        },
	        message:''
	    },
	    passwordkuang:{
	    	validator:function(value){
	    		var rex = /^[\w]{6,12}$/;
	    		return rex.test(value);
	    	},
	    	message:'密码只能由数字，字母组成，下划线,并且长度限制在6-12位'
	    },
	    company:{
	    	validator:function(value){
	    		 
    		    if(value.length >255){
    		    	return false;
    		    }
    		    if(value.length <4){
    		    	return false;
    		    }
    		    
    		    return true;
    		      
    		 
	    	},
	    	message:'超出字数了或者字数过少'
	    },
	    companyid:{
	    	validator:function(value){
	    		var tex = /^[1-9]\d*|0$/;
	    		return tex.test(value);
	    	},
	    	message:'只能输入非负整数'
	    }
   		
			
	
	});

</script>
</head>
<body style="width:100%;height:100%;" border="1px" margin="0px" padding="0px">
	<form id="ff" method="post" style="line-height: 59px; " enctype="multipart/form-data" target="dummyiframe">
	 	<div class="kuang">
            <div class="titlestyle">用户名: </div>
            <div  class="valuesstyle">
                <input  class="easyui-validatebox"  type="text" id="uname" name="uname"  disabled="disabled"  placeholder="用户名"/>
            </div>
        </div>
        <div class="kuang">
            <div class="titlestyle">密码: </div>
            <div  class="valuesstyle">
                <input  class="easyui-validatebox"  type="text" id="upassword" name="upassword"  validType="passwordkuang" placeholder="密码"/>
            </div>
        </div>
        <div class="kuang">
            <div class="titlestyle">用户名称: </div>
            <div  class="valuesstyle">
                <input  class="easyui-validatebox"  data-options="required:true" type="text" id="username" name="username" placeholder="用户名称"/>
            </div>
        </div>
        <div class="kuang">
            <div class="titlestyle">所属公司ID: </div>
            <div  class="valuesstyle">
                <input  class="easyui-validatebox"  data-options="required:true" type="text" id="companyid" validType="companyid"  name="companyid" placeholder="所属公司ID"/>
            </div>
        </div>
        <div class="kuang">
            <div class="titlestyle">所属公司: </div>
            <div  class="valuesstyle">
                <input  class="easyui-validatebox"  data-options="required:true" type="text" validType="company" id="company" name="company" placeholder="所属公司"/>
            </div>
        </div>
    </form>
  
    <div style="text-align:center;padding:5px 0;clear:both">
        <a href="javascript:void(0)" class="easyui-linkbutton" id="submitForm" onclick="submitForm()" style="width:80px">提交</a>
    </div>
</body>
<script type="text/javascript" src="<%=basePath%>static/maintenance/js/edit.js"></script>
</html>