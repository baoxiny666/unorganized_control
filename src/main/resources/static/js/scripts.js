	$(function(){
		
	})
	
	
	function on_return(){
		if(window.event.keyCode == 13){
			if (document.all('daanniu')!=null){
				document.all('daanniu').click();
			}
		}
	}
	
	
	function loginCheck(){
		var uname = $("#uname").attr("value");    //用户名
    	var upassword = $("#upassword").attr("value");      //密码
    	                //返回来的结果
    	if(uname == ''){
    		layer.tips('请输入用户名！', '#uname', {
         		  tips: [2, '#FF3030'],
         		  time: 3000
         	});
    		
    		$('#uname').focus();
      		return false;
    	}
    	
    	
    	if(upassword == ''){
    		layer.tips('请输入密码！', '#upassword', {
         		  tips: [2, '#FF3030'],
         		  time: 3000
         	});
    		$('#upassword').focus();
      		return false;
    	}
    	
    	var data= {uname:uname,upassword:upassword};
    	        
    	$.ajax({
    	           type:"POST",
    	           url:basePath+"user/checklogin.do",
    	           data:data,
    	           dataType:'json',
    	           success:function(msg){
    	               if(msg.flag==1){
    	                     window.location.href = basePath+"menupage/menu_test.jsp?username="+msg.username;   
    	               }else if(msg.flag==2){
    	            	     window.location.href = basePath+"maintenance/index.jsp?username="+msg.username; 
    	               }else{
    	            	   var type = 'auto';
    	            	   layer.open({
    	            	        type: 1
    	            	        ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
    	            	        ,id: 'layerDemo'+type //防止重复弹出
    	            	        ,content: '<div style="padding: 20px 100px;color:#000000;">'+ msg.error +'</div>'
    	            	        ,btn: '关闭全部'
    	            	        ,btnAlign: 'c' //按钮居中
    	            	        ,shade: 0 //不显示遮罩
    	            	        ,yes: function(){
    	            	          layer.closeAll();
    	            	        }
    	            	   });
    	            	  
    	            	   
    	               }
    	           }
    	  });
       

	}