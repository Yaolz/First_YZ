/**
 * 添加商品前台验证
 * 
 * @returns
 */
function add_act() {
	var name = $("#name").val();
		var des = $("#des").val();
		var error = $("#error");
		if(name == null || name.trim() == "")　{
			error.text("名称不能为空");
			return;
		}
        $("#form").ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: '/First_YZ/comactivity/addactivity', // 需要提交的 url
            dataType : 'json',
            data:$("#form").serialize(),
            success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
            	if(data.error == "添加成功") {
            		window.location = "/First_YZ/comactivity/activitys";
            	} else {
            		$("#error").text("添加失败");
            	}
            },
            error: function(data) {
            	$("#error").text("error");
            }
            // $(this).resetForm(); // 提交后重置表单
        });
        return false; // 阻止表单自动提交事件
}

/**
 * 修改活动前台验证
 * 
 * @returns
 */
function editor_act() {
		var name = $("#name").val();
		var des = $("#des").val();
		var error = $("#error");
		if(name == null || name.trim() == "")　{
			error.text("名称不能为空");
			return;
		}
		if(des == null || des.trim() == "")　{
			error.text("描述不能为空");
			return;
		}
        $("#form").ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: '/First_YZ/comactivity/editor', // 需要提交的 url
            dataType : 'json',
            data:$("#form").serialize(),
            success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
            	if(data.error == "添加成功") {
            		window.location = "/First_YZ/comactivity/activitys";
            	} else {
            		$("#error").text("添加失败");
            	}
            },
            error: function(data) {
            	// TODO 提示用户，或转到其他页面
            	// window.location = "/BeautHome/error";
            	$("#error").text("error");
            }
            // $(this).resetForm(); // 提交后重置表单
        });
        return false; // 阻止表单自动提交事件
}