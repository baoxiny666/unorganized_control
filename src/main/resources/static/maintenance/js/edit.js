	
	
	$(function(){
		/*查询当前选中的记录数据*/
		searchCheckedDatas();
	})
	
	
	function refreash(){
		try {
			var targetObj = $("#ff");
			$.parser.parse(targetObj);
		} catch (e) {
	
		}
	}
	
	// =====
	
	function searchCheckedDatas(){
	
		$.ajax({
	        type: "post",
	        url: basePath+"/user/selectDataById.do",
	        async: true,
	        dataType: 'JSON',
	        data:{"dataid":dataid},//将对象转为json字符串
	        success: function(obj) {
	            for (var item in obj){	
	            	if(item != 'upassword'){
	            		$("#"+item).val(obj[item]);
	            	}
	            	
				}
	        }
	    });
	}
	// =====
	
	
	
	function submitForm(){
		var isValid = $("#ff").form('validate');
			form = new FormData(document.getElementById("ff"));	 		//alert(isValid);
	    if(isValid){
			var fields = $('#ff').serializeArray();
		    var obj = {}; //声明一个对象
		    $.each(fields, function(index, field) {
		        obj[field.name] = field.value; //通过变量，将属性值，属性一起放到对象中
		    })
	
		    obj["uuidindex"] = dataid;
		    obj["companybase"] = window.Base64.encode(obj["companyid"]);
		    console.log(JSON.stringify(obj));
		    var dats=JSON.stringify(obj);
	
		    $.ajax({
		        type: "post",
		        url: basePath+"/user/userEdit.do",
		        contentType:"application/json;charset=utf-8",
		        async: false,
		        dataType: 'JSON',
		        data:dats,//将对象转为json字符串
		        success: function(obj) {
		          /**/
		           var recordid = obj.recordid;
		          
		           parent.doEditwindowClose();
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
	
    function getMyDate(str){  
	   var oDate = new Date(str),  
	   oYear = oDate.getFullYear(),  
	   oMonth = oDate.getMonth()+1,  
	   oDay = oDate.getDate(),  
	  
	   oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay);//最后拼接时间  
	   return oTime;  
	}; 

	function checknum(idd){
        var nMax = 2000;
        var textDom =  document.getElementById(idd);
        var len =textDom.value.length;    
        if(len>nMax){
            textDom.value = textDom.value.substring(0,nMax);
            return;
        }
        document.getElementById(idd+"in").value="你还可以输入"+(nMax-len)+"个字";
    }

    function angle_dis(value){
		return /^(\d?\d(\.\d*)?|180)$/.test(value);
    }

    function zhengs_dis(value){
    	return /^([0]|[1-9][0-9]*)$/.test(value);
    }

    function xiaos_or_zhengs(value){
    	return /^(\+)?\d+(\.\d+)?$/.test(value);
    }
