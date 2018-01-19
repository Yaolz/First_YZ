function message() {
	var name = $("#name").val();
	var principal = $("#principal").val();
	var phone = $("#phone").val();
	var plot_name = $("#plot_name").val();
	var address = $("#address").val();
	var tel = $("#tel").val();
	var error = $("#error");
	if (name == null || name.trim() == "") {
		error.text("请输入姓名");
		return;
	}
	if (principal == null || principal.trim() == "") {
		error.text("请输入建材商负责人姓名");
		return;
	}
	if (phone == null || phone.trim() == "") {
		error.text("请输入手机号");
		return;
	}
	if (address == null || address.trim() == "") {
		error.text("请输入地址");
		return;
	}
	if (tel = null || tel.trim() == "") {
		error.text("请输入固定电话");
		return;
	}
	$.post("/First_YZ/supply/editor", $("#form").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/supply/message";
		}
		$("#error").text(data.info);
	}, "JSON");
}