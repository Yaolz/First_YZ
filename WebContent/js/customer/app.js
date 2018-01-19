function company_app() {
	var cus_id = $("#cus_id").val();
	var com_id = $("#com_id").val();
	var name= $("#name").val();
	var phone = $("#phone").val();
	var plot_name = $("#plot_name").val();
	var area = $("#area").val();
	var way = $("#way").val();
	var budget = $("#budget").val();
	var error = $("#error");
	if(name == null || name.trim() == "") {
		error.text("请输入您的姓名");
		return;
	}
	if(phone == null || phone.trim() == "") {
		error.text("请输入您的手机号");
		return;
	}
	if(plot_name == null || plot_name.trim() == "") {
		error.text("请输入您所在的小区");
		return;
	}
	if(area == null || area.trim() == "") {
		error.text("请输入您的建筑面积");
		return;
	}
	$.post("/First_YZ/app/com", $("#form").serialize(), function(
			data) {
		if (data.error == "成功") {
			window.location = "/First_YZ/home.jsp";
		} else {
			alert("预约失败");
			window.location = "/First_YZ/home.jsp";
		}
	}, "JSON");
}