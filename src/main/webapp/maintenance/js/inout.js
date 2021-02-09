var config = {
	"inoutConfig":[
		{field:"ck",checkbox:"true",width:100},
		{field:"inLicensePlate",title:"车牌号",width:100,align:"center"},
		{field:"inControllerNo",title:"入口编号",width:100,align:"center",hidden:true},
		{field:"fullName",title:"入口名称",width:100,align:"center"},
		{field:"inDateTime",title:"入场时间",width:150,align:"center",formatter:timeformat},
		{field:"iutDateTime",title:"出场时间",width:150,align:"center",formatter:timeformat},
		{field:"inPhoto",title:"入场图片",width:250,align:"center",formatter:chaoLianjie},
		{field:"outPhoto",title:"出厂图片",width:250,align:"center",formatter:chaoLianjie},
		{field:"environmentalCode",title:"环保编码",width:120,align:"center"},
		{field:"registerDate",title:"注册日期",width:120,align:"center",formatter:getMyDate},
		{field:"vin",title:"车辆识别代码",width:180,align:"center"},
		{field:"engineNO",title:"发动机号码",width:180,align:"center"},
		{field:"disChargeStage",title:"排放阶段",width:80,align:"center"},
		{field:"disChargeStageName",title:"排放阶段中文",width:80,align:"center",hidden:true},
		{field:"accompanyList",title:"随车清单",width:180,align:"center",formatter:chaoLianjie},
		{field:"drivingLicense",title:"行驶证",width:180,align:"center",formatter:chaoLianjie},
		{field:"motorCadeName",title:"车队名称",width:180,align:"center"}
	]
}


$(function(){
	onload_colunmn();
	$(document).keydown(function (event) {
		if (event.keyCode == 13) { //keyCode=13是回车键
			$('.dianjsoso').triggerHandler('click');
		}
	});
})

function refreash(){
	try {
		 var targetObj = $("#ttt");
		 $.parser.parse(targetObj);
	} catch (e) {

	}
}


function search_column_isneed(formid){

}




function onload_colunmn(){

	$("#inoutTable").datagrid({
		url:basePath+"/api/abAccount/select",
		title:"",
		columns:[config["inoutConfig"]],
		nowrap:false,
		pagination:true,
		rownumbers:true,
		onBeforeLoad:beforeLoad,
		pageSize:25,   //表格中每页显示的行数
		pageList:[25,50,100],
		loadMsg:"数据正在努力加载，请稍后...",
		singleSelect:false,
		onLoadSuccess:function(data) {
			$("#inoutTable").datagrid("clearChecked");
		},onDblClickRow :function(index,row){

		}

	})
}




/*时间处理*/
function timeformat(value) {
	if(value == null){
		return "---";
	}else{
		var date = new Date(value.time);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		var Y = date.getFullYear() + '-';
		var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		var D = (date.getDate()< 10 ?('0'+date.getDate()):date.getDate())+" ";
		var h = (date.getHours()< 10 ?('0'+date.getHours()):date.getHours()) + ':';
		var m = (date.getMinutes()< 10 ?('0'+date.getMinutes()):date.getMinutes()) + ':';
		var s = (date.getSeconds()< 10 ?('0'+date.getSeconds()):date.getSeconds());
		if(h=="00:" && m=="00:" && s=="00"){
			return Y+M+D;
		}else{
			return Y+M+D+h+m+s;
		}

	}



}

function reloadData() {
	try {
		$("#inoutTable").datagrid("reload");

	} catch (e) {

	}
}
function beforeLoad(param) {
	param.inLicensePlate = $("#inLicensePlate").val();
	param.motorCadeName = $("#motorCadeName").val();
	param.disChargeStage = $("#disChargeStage").val();
	param.startTime = $("#startTime").val();
	param.endTime = $("#endTime").val();
	param.controllerDoor = controllerDoor;
}


function chaoLianjie(value, row, index){

	return "<a href='" + value + "' target='_blank'>"+value+"</a>";
	// if(value != null || value)
	// return "<a href='" + row.ExamPlaceID + "' target='_blank'>绑定考生</a>";
}


function getMyDate(value){
	if(value == null){
		return "---";
	}else{
		var date = new Date(value.time);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		var Y = date.getFullYear() + '-';
		var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		var D = (date.getDate()< 10 ?('0'+date.getDate()):date.getDate());
		return Y+M+D;
	}
}


