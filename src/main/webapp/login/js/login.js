	$(function(){
		$('.username_bg')
	})


	function on_return(){
		if(window.event.keyCode == 13){
			if (document.all('daanniu')!=null){
				document.all('daanniu').click();
			}
		}
	}


	function loginCheck(){
		var username =document.getElementById("username_bg").value;    //用户名
    	var password =document.getElementById("password_bg").value;      //密码
		debugger;//返回来的结果
    	if(username == '' || username == undefined){
    		alert('请输入用户名！!');
    		$('#username_bg').focus();
      		return false;
    	}

    	if(password == ''  || password == undefined){
			alert('请输入密码！!');
    		$('#password_bg').focus();
      		return false;
    	}


		if(username == "admin" && password == "abtaiz"){
			localStorage.setItem("wuzuzuser","admin");
			localStorage.setItem("wuzuzusername","超级管理员");
			window.location.href = basePath+"/maintenance/index"
		}else if(username == "Aaccount" && password == "123456"){
			localStorage.setItem("wuzuzuser","Aaccount");
			localStorage.setItem("wuzuzusername","A台账");
			window.location.href = basePath+"/maintenance/index"
		}else if(username == "Baccount" && password == "123456"){
			localStorage.setItem("wuzuzuser","Baccount");
			localStorage.setItem("wuzuzusername","B台账");
			window.location.href = basePath+"/maintenance/index"
		}else{
			alert("您输入的用户名或密码错误！！！！")
		}



	}
