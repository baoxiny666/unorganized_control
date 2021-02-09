	var address;
	$(function(){
		$('#tree').tree({
			checkbox: false,
			url: basePath+'maintenance/json/tree.json',
			method: 'get',
			onClick:function(node){
				debugger
				var url;
				if(node.id == 12){
					url=node.attributes.url +encodeURI(encodeURI("CT000001,CT000003,CT000009"));

				}else if(node.id == 13){
					url=node.attributes.url + encodeURI(encodeURI("CT000013,CT000005,CT000007,CT000015,CT000016,CT000011"));
				}

				$('#centeriframe').empty();
				$('#centeriframe').append('<iframe src="'+url+'" style="width:100%;height:100%;" scrolling="auto" frameborder="0"></iframe>');
			}
		});
	})
