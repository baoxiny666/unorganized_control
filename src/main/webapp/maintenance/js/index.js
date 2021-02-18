	var address;
	var cunchu;
	$(function(){
		debugger;
		cunchu  = localStorage.getItem("wuzuzuser");
		if(cunchu == null || cunchu == undefined || cunchu == ''){
			window.location.href = basePath+"/";
		}else{
			var jsonJob = JSON.parse(cunchu);
			cunchuName  = jsonJob.data.wuzuzusername;
			$(".login_user").empty();
			$(".login_user").html(cunchuName);
			if(jsonJob.data.wuzuzuser == 'admin'){
				createTreeAdmin()
			}else if(jsonJob.data.wuzuzuser == 'lhtgto'){
				createTreeA()
			}else if(jsonJob.data.wuzuzuser == 'comesl'){
				createTreeB()
			}
		}

	})


	function createTreeAdmin(){
		$('#tree').tree({
			checkbox: false,
			url: basePath+'maintenance/json/tree.json',
			method: 'get',
			onClick:function(node){
				var url;
				if(node.id == 1){
					return;
				}
				if(node.id == 13){
					url=node.attributes.url +encodeURI(encodeURI("CT000001,CT000003,CT000009"));

				}else if(node.id == 12){
					url=node.attributes.url + encodeURI(encodeURI("-1"));
				}

				$('#centeriframe').empty();
				$('#centeriframe').append('<iframe src="'+url+'" style="width:100%;height:100%;" scrolling="auto" frameborder="0"></iframe>');
			}
		});
	}


	function createTreeA(){
		$('#tree').tree({
			checkbox: false,
			url: basePath+'maintenance/json/treeA.json',
			method: 'get',
			onClick:function(node){
				var url;
				if(node.id == 1){
					return
				}
				if(node.id == 13){
					url=node.attributes.url +encodeURI(encodeURI("CT000001,CT000003,CT000009"));

				}else if(node.id == 12){
					url=node.attributes.url + encodeURI(encodeURI("-1"));
				}

				$('#centeriframe').empty();
				$('#centeriframe').append('<iframe src="'+url+'" style="width:100%;height:100%;" scrolling="auto" frameborder="0"></iframe>');
			}
		});
	}


	function createTreeB(){
		$('#tree').tree({
			checkbox: false,
			url: basePath+'maintenance/json/treeB.json',
			method: 'get',
			onClick:function(node){
				var url;
				if(node.id == 1){
					return
				}

				if(node.id == 13){
					url=node.attributes.url +encodeURI(encodeURI("CT000001,CT000003,CT000009"));

				}else if(node.id == 12){
					url=node.attributes.url + encodeURI(encodeURI("-1"));
				}

				$('#centeriframe').empty();
				$('#centeriframe').append('<iframe src="'+url+'" style="width:100%;height:100%;" scrolling="auto" frameborder="0"></iframe>');
			}
		});
	}


	function login_quit(){
		localStorage.clear();
		window.location.href = basePath +"/";
	}
