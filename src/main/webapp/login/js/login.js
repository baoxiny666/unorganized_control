	$(function(){
		$('.username_bg')
	})
	/*设置过期时间*/
	const localStorageSet = (name, data, expire = new Date().getTime() + expire * 1000) => {
		const obj = {
			data,
			expire
		};
		localStorage.setItem(name, JSON.stringify(obj));
	};

	//读取缓存
	const localStorageGet = name => {
		const storage = localStorage.getItem(name);
		const time = new Date().getTime();
		let result = {};
		if (storage) {
			const obj = JSON.parse(storage);
			if (time < obj.expire) {
				result = obj.data;
			} else {
				localStorage.removeItem(name);
			}
		}
		return result;
	};

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


		if(username == "admin" && password == "taiz"){
			let shuju = {
				"wuzuzuser":"admin",
				"wuzuzusername":"超级管理员"
			}
		/*	localStorage.setItem("wuzuzuser","admin");
			localStorage.setItem("wuzuzusername","超级管理员");*/

			let expire = 20;
			localStorageSet('wuzuzuser', shuju, expire);
			window.location.href = basePath+"/maintenance/index"
		}else if(username == "lhtgto" && password == "q123456"){
			let shuju = {
				"wuzuzuser":"lhtgto",
				"wuzuzusername":"联合特钢台账"
			}
		/*	localStorage.setItem("wuzuzuser","lhtgto");
			localStorage.setItem("wuzuzusername","联合特钢台账");*/
			let expire = 20;
			localStorageSet('wuzuzuser', shuju, expire);
			window.location.href = basePath+"/maintenance/index"
		}else if(username == "comesl" && password == "q123456"){
			let shuju = {
				"wuzuzuser":"comesl",
				"wuzuzusername":"公司台账"
			}
			/*localStorage.setItem("wuzuzuser","comesl");
			localStorage.setItem("wuzuzusername","公司台账");*/

			let expire = 20;
			localStorageSet('wuzuzuser', shuju, expire);
			window.location.href = basePath+"/maintenance/index"
		}else{
			alert("您输入的用户名或密码错误！！！！")
		}



	}
