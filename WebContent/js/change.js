function pwd() {
	var email = $("#email").val();
	var old_pwd = $("#old_pwd").val();
	var new_pwd = $("#new_pwd").val();
	var pwd = $("#pwd").val();
	var error = $("#error");
	if(old_pwd == null || old_pwd.trim() == "")　{
		error.text("旧密码不能为空");
		return;
	}
	if(pwd == null || pwd.trim() == "")　{
		error.text("新密码不能为空");
		return;
	}
	if(old_pwd == new_pwd) {
		error.text("新密码不能与旧密码一致");
		return;
	}
	if(new_pwd != pwd) {
		error.text("两次密码不一致");
		return;
	}
}

/**
 * 管理员的修改密码
 * @returns
 */
function change_pwd() {
	pwd();
	$.post("/First_YZ/admin/pwd", $("#form").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/admins/message.jsp";
		}
		$("#info").text(data.info);
	}, "JSON");
}
/**
 * 公司的修改密码 
 * @returns
 */
function company_pwd() {
	pwd();
	$.post("/First_YZ/company/pwd", $("#form").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/company/message";
		}
		$("#info").text(data.info);
	}, "JSON");
}
/**
 * 用户的修改密码
 * @returns
 */
function customer_pwd() {
	pwd();
	$.post("/First_YZ/customer/pwd", $("#form").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/customer/message";
		}
		$("#info").text(data.info);
	}, "JSON");
}
/**
 * 设计师的密码修改
 * @returns
 */
function designer_pwd() {
	pwd();
	$.post("/First_YZ/designer/pwd", $("#form").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/designers/message.jsp";
		}
		$("#info").text(data.info);
	}, "JSON");
}
/**
 * 设计师的密码修改
 * @returns
 */
function supply_pwd(){
	pwd();
	$.post("/First_YZ/supply/pwd", $("#form").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/supplys/message.jsp";
		}
		$("#info").text(data.info);
	}, "JSON");
}