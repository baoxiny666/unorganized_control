$(function(){
	init()
})

function init(){
	$(".main_left li").on("click",function(){
		var address =$(this).attr("data-src");
		$("#iframeeducation").attr("src",address);
	});
}
