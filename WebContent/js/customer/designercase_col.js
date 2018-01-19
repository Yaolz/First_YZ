/**
 * 收藏公司
 * @returns
 */
function designercase_col() {
	var cus_id = $("#cus_id").val();
	var descase_id = $("#descase_id").val();
	var error = $("#error");
	if(cus_id == null || cus_id.trim() == "") {
//		error.text("请登录或注册");
		alert("请登录或注册");
		return;
	}
	$.ajax({
		type: 'post', // 提交方式 get/post
        url: '/First_YZ/col/designercasecol', // 需要提交的 url
        dataType : 'json',
        data:{"descase_id" : descase_id, "cus_id":cus_id}, 
        success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
            // 此处可对 data 作相关处理
        	if(data.save == "成功") {
        		$("#save").attr("class", "btn btn-info btn-lg active");
				$("#save").attr("disabled", "disabled");
				$("#save").text("已收藏");
        	} else {
        		alert("收藏失败");
        	}
        },
        error: function(data) {
        	// TODO 提示用户，或转到其他页面
        	alert("收藏失败");
        	window.location = "/First_YZ/home.jsp";
        }
	});
}
