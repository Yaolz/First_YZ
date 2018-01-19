function message() {
	var name = $("#name").val();
	var phone = $("#phone").val();
	var plot_name = $("#plot_name").val();
	var address = $("#address").val();
	var error = $("#error");
	if (name == null || name.trim() == "") {
		error.text("请输入姓名");
//		alert("请输入姓名")
		return;
	}
	if (phone == null || phone.trim() == "") {
		error.text("请输入手机号");
		return;
	}
	$.post("/First_YZ/customer/editor", $("#form").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/customer/message";
		}
		$("#error").text(data.info);
	}, "JSON");
}