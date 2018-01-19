/**
 * 业主的前台验证以及后台验证
 * 
 * @returns
 */
function login_customer() {
	var email_pt = $("#email_pt").val();
	var pwd_pt = $("#pwd_pt").val();
	var error_pt = $("#error_pt");
	if(email_pt == null || email_pt.trim() == "") {
		error_pt.text("邮箱不能为空");
		return;
	}
	if(pwd_pt == null || pwd_pt.trim() == "") {
		error_pt.text("密码不能为空");
		return;
	}
	$.post("/First_YZ/customer/login", $("#customer").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/common/indexs";
		}
		$("#error_pt").text(data.info);
	}, "JSON");
}
/**
 * 选择业主登录
 * 
 * @returns
 */
function customer() {
	var text = "pt";
	var pt = $("#pt").val();
	if (pt == text) {
		login_customer();
	}
}
/**
 * 公司的前台验证以及后台
 * 
 * @returns
 */
function login_company() {
	var error_gs = $("#error_gs");
	$.post("/First_YZ/company/login", $("#company").serialize(),
			function(data) {
				if (data.info == "数据成功") {
					window.location = "/First_YZ/common/indexs";
				}
				$("#error_gs").text(data.info);
			}, "JSON");
}
/**
 * 选择公司登录
 * 
 * @returns
 */
function company() {
	var text = "gs";
	var pt = $("#gs").val();
	if (pt == text) {
		login_company();
	}
}
/**
 * 设计师的前台验证和后台
 * 
 * @returns
 */
function login_designer() {
	var email_sj = $("#email_sj").val();
	var pwd_sj = $("#pwd_sj").val();
	var error_sj = $("#error_sj");
	if(email_sj == null || email_sj.trim() == "") {
		error_sj.text("邮箱不能为空");
		return;
	}
	if(pwd_sj == null || pwd_sj.trim() == "") {
		error_sj.text("密码不能为空");
		return;
	}
	$.post("/First_YZ/designer/login", $("#designer").serialize(), function(
			data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/common/indexs";
		}
		$("#error_sj").text(data.info);
	}, "JSON");
}
/**
 * 选择设计师登录
 * 
 * @returns
 */
function designer() {
	var text = "sj";
	var pt = $("#sj").val();
	if (pt == text) {
		login_designer();
	}
}
/**
 * 建材商的前台验证和后台
 * @returns
 */
function login_supply() {
	var email_jc = $("#email_jc").val();
	var pwd_jc = $("#pwd_jc").val();
	var error_jc = $("#error_jc");
	if(email_jc == null || email_jc.trim() == "") {
		error_jc.text("邮箱不能为空");
		return;
	}
	if(pwd_jc == null || pwd_jc.trim() == "") {
		error_jc.text("密码不能为空");
		return;
	}
	$.post("/First_YZ/supply/login", $("#supply").serialize(), function(data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/common/indexs";
		}
		$("#error_jc").text(data.info);
	}, "JSON");
}
/**
 * 选择建材商
 * @returns
 */
function supply() {
	var text = "jc";
	var pt = $("#jc").val();
	if (pt == text) {
		login_supply();
	}
}