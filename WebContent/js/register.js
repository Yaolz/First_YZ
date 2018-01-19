/**
 * 业主的前台验证以及后台的数据处理
 * 
 * @returns
 */
function check_customer(temp){
	var phone_pt = /^1\d{10}$/;
	if(!phone_pt.test(temp.value)){
		alert("手机号码格式不正确，请重新输入!");
		return;
	}
	
}
function pwd_customer(obj) {
	var pwd_pt = /^1\d{5}$/;
	if(!pwd_pt.test(obj.value)) {
		alert("密码不能少于六位数，请重新输入！");
		return;
	}
}
function reg_customer() {
	var email = $("#email").val();
	var name_pt = $("#name_pt").val();
	var pwd_pt = $("#pwd_pt").val();
	var pwds_pt = $("#pwds_pt").val();
	var phone_pt = $("#phone_pt").val();
	var error_pt = $("#error_pt");
	if(name_pt == null || name_pt.trim() == "")　{
		error_pt.text("昵称不能为空");
		return;
	}
	if(email == null || email.trim() == "") {
		error_pt.text("邮箱不能为空");
		return;
	}
	if(phone_pt == null || phone_pt.trim() == "") {
		error_pt.text("手机号码不能为空");
		return;
	}
	if(pwd_pt == null || pwd_pt.trim() == "") {
		error_pt.text("密码不能为空");
		return;
	}
	if(pwds_pt == null || pwds_pt.trim() == "") {
		error_pt.text("确认密码不能为空");
		return;
	}
	if(pwd_pt != pwds_pt) {
		error_pt.text("两次密码输入不一致");
		return;
	}
	$.post("/First_YZ/customer/reg", $("#customer").serialize(),
			function(data) {
				if (data.info == "数据成功") {
					window.location = "/First_YZ/login.jsp";
				}
				$("#error_pt").text(data.info);
			}, "JSON");
}
/**
 * 设计师的前台验证以及后台的数据处理
 * 
 * @returns
 */
function check_designer(temp){
	var phone_sj = /^1\d{10}$/;
	if(!phone_sj.test(temp.value)){
		alert("手机号码格式不正确，请重新输入!");
		return;
	}
}
function reg_designer() {
	var name_sj = $("#name_sj").val();
	var phone_sj = $("#phone_sj").val();
	var email_sj = $("#email_sj").val();
	var pwd_sj = $("#pwd_sj").val();
	var pwds_sj = $("#pwds_sj").val();
	var error_sj = $("#error_sj");
	if(name_sj == null || name_sj.trim() == "")　{
		error_sj.text("昵称不能为空");
		return;
	}
	if(phone_sj == null || phone_sj.trim() == "") {
		error_sj.text("手机号码不能为空");
		return;
	}
	if(email_sj == null || email_sj.trim() == "") {
		error_sj.text("邮箱不能为空");
		return;
	}
	if(pwd_sj == null || pwd_sj.trim() == "") {
		error_sj.text("密码不能为空");
		return;
	}
	if(pwds_sj == null || pwds_sj.trim() == "") {
		error_sj.text("确认密码不能为空");
		return;
	}
	if(pwd_sj != pwds_sj) {
		error_sj.text("两次密码输入不一致");
		return;
	}
	$.post("/First_YZ/designer/reg", $("#designer").serialize(),
			function(data) {
				if (data.info == "数据成功") {
					window.location = "/First_YZ/login.jsp";
				}
				$("#pwd_sj").text(data.info);
			}, "JSON");
}
/**
 * 公司的前台验证以及后台的数据处理
 * 
 * @returns
 */
function check_company(temp){
	var phone_gs = /^1\d{10}$/;
	if(!phone_gs.test(temp.value)){
		alert("手机号码格式不正确，请重新输入!");
		return;
	}
}
function reg_company() {
	var email_gs = $("#email_gs").val();
	var name_gs = $("#name_gs").val();
	var pwd_gs = $("#pwd_gs").val();
	var pwds_gs = $("#pwds_gs").val();
	var phone_gs = $("#phone_gs").val();
	var tel_gs = $("#tel_gs").val();
	var principal_gs = $("#principal_gs").val();
	var open_date_gs = $("#open_date_gs").val();
	var error_gs = $("#error_gs");
	if(name_gs == null || name_gs.trim() == "")　{
		error_gs.text("公司名称不能为空");
		return;
	}
	if(email_gs == null || email_gs.trim() == "") {
		error_gs.text("邮箱不能为空");
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
	if(pwd_gs == null || pwd_gs.trim() == "") {
		error_gs.text("密码不能为空");
		return;
	}
	if(pwds_gs == null || pwds_gs.trim() == "") {
		error_gs.text("确认密码不能为空");
		return;
	}
	if(pwd_gs != pwds_gs) {
		error_gs.text("两次密码输入不一致");
		return;
	}
	$.post("/First_YZ/company/reg", $("#company").serialize(), function(data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/login.jsp";
		}
		$("#error_gs").text(data.info);
	}, "JSON");
}
/**
 * 建材商的前台验证以及后台的数据处理
 * 
 * @returns
 */
function check_supply(temp){
	var phone_jc = /^1\d{10}$/;
	if(!phone_jc.test(temp.value)){
		alert("手机号码格式不正确，请重新输入!");
		return;
	}
}
function reg_supply() {
	var email_jc = $("#email_jc").val();
	var name_jc = $("#name_jc").val();
	var pwd_jc = $("#pwd_jc").val();
	var pwds_jc = $("#pwds_jc").val();
	var phone_jc = $("#phone_jc").val();
	var tel_jc = $("#tel_jc").val();
	var principal_jc = $("#principal_jc").val();
	var open_date_jc = $("#open_date_jc").val();
	var error_jc = $("#error_jc");
	if(name_jc == null || name_jc.trim() == "")　{
		error_jc.text("建材商名称不能为空");
		return;
	}
	if(tel_jc == null || tel_jc.trim() == "") {
		error_jc.text("固定电话不能为空");
		return;
	}
	if(email_jc == null || email_jc.trim() == "") {
		error_jc.text("邮箱不能为空");
		return;
	}
	if(principal_jc == null || principal_jc.trim() == "") {
		error_jc.text("建材商负责人必须填写");
		return;
	}
	if(phone_jc == null || phone_jc.trim() == "") {
		error_jc.text("建材商负责人手机号必须填写");
		return;
	}
	if(open_date_jc == null || open_date_jc.trim() == "") {
		error_jc.text("建材商成立日期不能为空");
		return;
	}
	if(pwd_jc == null || pwd_jc.trim() == "") {
		error_jc.text("密码不能为空");
		return;
	}
	if(pwds_jc == null || pwds_jc.trim() == "") {
		error_jc.text("确认密码不能为空");
		return;
	}
	if(pwd_jc != pwds_jc) {
		error_jc.text("两次密码输入不一致");
		return;
	}
	$.post("/First_YZ/supply/reg", $("#supply").serialize(), function(data) {
		if (data.info == "数据成功") {
			window.location = "/First_YZ/login.jsp";
		}
		$("#error_jc").text(data.info);
	}, "JSON");
}

function customer() {
	var text = "pt";
	var pt = $("#pt").val();
	if (pt == text) {
		reg_customer();
	}
}

function designer() {
	var text = "sj";
	var pt = $("#sj").val();
	if (pt == text) {
		reg_designer();
	}
}

function company() {
	var text = "gs";
	var pt = $("#gs").val();
	if (pt == text) {
		reg_company();
	}
}

function supply() {
	var text = "jc";
	var pt = $("#jc").val();
	if (pt == text) {
		reg_supply();
	}
}
