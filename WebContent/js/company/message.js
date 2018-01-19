function message() {
	var name_gs = $("#name_gs").val();
	var phone_gs = $("#phone_gs").val();
	var tel_gs = $("#tel_gs").val();
	var principal_gs = $("#principal_gs").val();
	var open_date_gs = $("#open_date_gs").val();
	var error_gs = $("#error_gs");
	if(name_gs == null || name_gs.trim() == "")　{
		error_gs.text("公司名称不能为空");
		return;
	}
	if(tel_gs == null || tel_gs.trim() == "") {
		error_gs.text("固定电话不能为空");
		return;
	}
	if(principal_gs == null || principal_gs.trim() == "") {
		error_gs.text("公司负责人必须填写");
		return;
	}
	if(phone_gs == null || phone_gs.trim() == "") {
		error_gs.text("公司负责人手机号必须填写");
		return;
	}
	if(open_date_gs == null || open_date_gs.trim() == "") {
		error_gs.text("公司成立日期不能为空");
		return;
	}
	$.post("/First_YZ/company/editor", $("#form").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/company/message";
		}
		$("#error").text(data.info);
	}, "JSON");
}