var config = {
	"inoutConfig":[
		{field:"ck",checkbox:"true",width:100},
		{field:"_row_number",title:"序号",width:100,align:"center"},
		{field:"inLicensePlate",title:"车牌号",width:100,align:"center"},
		{field:"inControllerNo",title:"入口编号",width:100,align:"center",hidden:true},
		{field:"fullName",title:"入口名称",width:100,align:"center"},
		{field:"inDateTime",title:"入场时间",width:150,align:"center",formatter:timeformat},
		{field:"outDateTime",title:"出场时间",width:150,align:"center",formatter:timeformat},
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
		{field:"shipmentName",title:"运输货物名称",width:80,align:"center"},
		{field:"freightVolume",title:"运输量",width:80,align:"center"},
		{field:"motorCadeName",title:"车队名称",width:180,align:"center"}
	]
}


$(function(){
	onload_colunmn();
})




function refreash(){
	try {
		 var targetObj = $("#ttt");
		 $.parser.parse(targetObj);
	} catch (e) {

	}
}
function showMessagePicsLL(params){
	var urls = basePath + "/api/abAccount/getImages?name="+params;
	showMessagePics(urls);
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
		rownumbers:false,
		onBeforeLoad:beforeLoad,
		pageSize:25,   //表格中每页显示的行数
		pageList:[25,50,100,200,500,1000],
		loadMsg:"数据正在努力加载，请稍后...",
		singleSelect:false,
		onLoadSuccess:function(data) {
			$("#inoutTable").datagrid("clearChecked");
			$('#inoutTable').datagrid('fixRownumber');
		},onDblClickRow :function(index,row){

		}

	})
}

function  exportGridData(){
	var options = $("#inoutTable" ).datagrid("getPager").data("pagination").options;
	var wuzuZhipageNum = options.pageNumber;
	var wuzuZhisize = options.pageSize;



	var form=$("<form>"); //定义一个form表单,通过form表单来发送请求
	form.attr("style","display:none");  //设置表单状态为不显示
	form.attr("method","post");//method属性设置请求类型为post
	form.attr("action",basePath + "/api/abAccount/exportGridData");//action属性设置请求路径，请求类型是post时,路径后面跟参数的方式不可用，可以通过表单中的input来传递参数
	$("body").append(form);//将表单放置在web中
	var input1=$("<input>"); //在表单中添加input标签来传递参数，如有多个参数可添加多个input标签
	input1.attr("type","hidden");//设置为隐藏域
	input1.attr("name","wuZuzhiCurrentPage");//设置参数名称
	input1.attr("value",wuzuZhipageNum);//设置参数值


	var input2=$("<input>"); //
	input2.attr("type","hidden");//设置为隐藏域
	input2.attr("name","motorCadeName");//设置参数名称
	input2.attr("value",$("#motorCadeName").val());//设置参数值

	var input3=$("<input>"); //
	input3.attr("type","hidden");//设置为隐藏域
	input3.attr("name","inLicensePlate");//设置参数名称
	input3.attr("value",$("#inLicensePlate").val());//设置参数值

	var input4=$("<input>"); //
	input4.attr("type","hidden");//设置为隐藏域
	input4.attr("name","disChargeStage");//设置参数名称
	input4.attr("value",$("#disChargeStage").val());//设置参数值

	var input5=$("<input>"); //
	input5.attr("type","hidden");//设置为隐藏域
	input5.attr("name","startTime");//设置参数名称
	input5.attr("value",$("#startTime").val());//设置参数值

	var input6=$("<input>"); //
	input6.attr("type","hidden");//设置为隐藏域
	input6.attr("name","endTime");//设置参数名称
	input6.attr("value",$("#endTime").val());//设置参数值


	var input7=$("<input>"); //
	input7.attr("type","hidden");//设置为隐藏域
	input7.attr("name","controllerDoor");//设置参数名称
	input7.attr("value",controllerDoor);//设置参数值

	var input8=$("<input>"); //
	input8.attr("type","hidden");//设置为隐藏域
	input8.attr("name","wuZuzhiPageSize");//设置参数名称
	input8.attr("value",wuzuZhisize);//设置参数值

	form.append(input1).append(input2).append(input3).append(input4).append(input5).append(input6).append(input7).append(input8);//添加到表单中
	form.submit();//表单提交
}


/*时间处理*/
function timeformat(value) {
	if(value == null){
		return "";
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
	param.inControllerNo = $("#inControllerNo").val();
}


function chaoLianjie(value, row, index){
	return "<a onclick=showMessagePicsLL('"+encodeURI(encodeURI(value.replaceAll("\\","$")))+"') href='javascript:void(0)' >"+value+"</a>";
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


