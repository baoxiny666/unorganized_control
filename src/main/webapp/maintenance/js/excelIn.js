
$(function(){

})
function uploadFile() {
    var file=$("#file");
    console.log("file",file)
    var tmp=file[0].files[0];
    if(tmp){
        var formdata = new FormData();
        formdata.append("file",tmp);
        console.log("33",formdata);
        $.ajax({
            url: basePath+"/api/carRegister/importExcel",
            type: "post",
            data:formdata,
            dataType: "json",
            processData: false,
            contentType: false,
            success: function (res) {
                console.log("上传文件返回信息",res);
                if("0"==res.status){
                    layer.alert(res.message||"文件上传成功");
                    $("#uploadFile").modal("hide");
                    //清空文件框的显示内容
                    $("#file").val("");
                    $("#file")[0].files[0]="";
                }else{
                    layer.alert(res.message||"文件上传失败");
                }
            }
        });
    }
}
