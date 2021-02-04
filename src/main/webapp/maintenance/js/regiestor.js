var config = {
	"regiestorConfig":[
		{field:"ck",checkbox:"true"},
		{field:"licensePlate",title:"车牌号",width:80,align:"center"},
		{field:"CDateTime",title:"创建时间",width:200,align:"center"},
		{field:"environmentalCode",title:"环保编码",width:150,align:"center"},
		{field:"registerDate",title:"注册日期",width:150,align:"center"},
		{field:"VIN",title:"车辆识别代码",width:140,align:"center"},
		{field:"engineNo",title:"发动机号码",width:140,align:"center"},
		{field:"disChargeStage",title:"排放阶段",width:200,align:"center"},
		{field:"accompanyList",title:"随车清单",width:400,align:"center"},
		{field:"drivingLicense",title:"行驶证",width:400,align:"center"},
		{field:"motorCadeName",title:"车队名称",width:200,align:"center"}
	]
};


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

	$("#regiestFormTable").datagrid({
		url:basePath+"/api/carRegister/select",
		title:"",
		columns:[config["regiestorConfig"]],
		nowrap:false,
		pagination:true,
		rownumbers:true,
		onBeforeLoad:beforeLoad,
		pageSize:25,   //表格中每页显示的行数
		pageList:[25,50,100],
		loadMsg:"数据正在努力加载，请稍后...",
		singleSelect:false,
		onLoadSuccess:function(data) {
			$("#regiestFormTable").datagrid("clearChecked");
		},onDblClickRow :function(index,row){


		}

	})
}


function doExcelIn(){
	var excelInUrl = basePath+"/maintenance/excelIn.jsp";
	showMessageDialog_excelIn(excelInUrl);
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
		$("#regiestFormTable").datagrid("reload");

	} catch (e) {

	}
}
function beforeLoad(param) {
	param.licensePlate = $("#licensePlate").val();
	param.motorCadeName = $("#motorCadeName").val();
	param.disChargeStage = $("#disChargeStage").val();
	param.startTime = $("#startTime").val();
	param.endTime = $("#endTime").val();
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

function accompanyList(){
}

function drivingLicense(){

}

