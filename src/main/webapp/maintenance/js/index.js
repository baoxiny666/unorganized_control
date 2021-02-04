	var address;

	$(function(){
		$('#tree').tree({
			checkbox: false,
			url: basePath+'maintenance/json/tree.json',
			method: 'get',
			onClick:function(node){
				debugger
				var url=node.attributes.url;
				$('#centeriframe').empty()
				$('#centeriframe').append('<iframe src="'+url+'" style="width:100%;height:100%;" scrolling="auto" frameborder="0"></iframe>');
			}
		});
	})
