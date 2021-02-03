	$(function(){

		
		
	})



	function refreash(){
		try {
			var targetObj = $("#ff");
			$.parser.parse(targetObj);

		
		} catch (e) {

		}
	}

	function submitForm(){
		var isValid = $("#ff").form('validate');
		form = new FormData(document.getElementById("ff")); 		
	    if(isValid){
	        var fields = $('#ff').serializeArray();
		    var obj = {}; //声明一个对象
		    $.each(fields, function(index, field) {
		        obj[field.name] = field.value; //通过变量，将属性值，属性一起放到对象中
		    })
		    obj["companybase"] = window.Base64.encode(obj["companyid"]);

		    console.log(JSON.stringify(obj));
		    var dats=JSON.stringify(obj);
		    $.ajax({
		        type: "post",
		        url: basePath+"/user/userAdd.do",
		        contentType:"application/json;charset=utf-8",
		        async: true,
		        dataType: 'JSON',
		        data:dats, //将对象转为json字符串
		        success: function(res) {
		        	
		        	console.log("增加了一条");
		        	parent.doAddwindowClose();
	              	parent.reloadData();
		            
		        }
		    });
		}
	}



    function getMyDate(str){  
	   var oDate = new Date(str),  
	   oYear = oDate.getFullYear(),  
	   oMonth = oDate.getMonth()+1,  
	   oDay = oDate.getDate(),  
	  
	   oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay);//最后拼接时间  
	   return oTime;  
	}; 

