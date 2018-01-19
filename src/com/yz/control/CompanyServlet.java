package com.yz.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.ServiceCol.CompanyColServiceImpl;
import com.yz.ServiceCol.CompnayColService;
import com.yz.ServiceCompany.CompanyActivityService;
import com.yz.ServiceCompany.CompanyActivityServiceImpl;
import com.yz.ServiceCompany.CompanyCaseService;
import com.yz.ServiceCompany.CompanyCaseServiceImpl;
import com.yz.ServiceCompany.CompanyService;
import com.yz.ServiceCompany.CompanyServiceImpl;
import com.yz.ServiceCustomer.AppointServite;
import com.yz.ServiceCustomer.AppointServiteImpl;
import com.yz.bean.Appointment;
import com.yz.bean.Company;
import com.yz.bean.CompanyActivity;
import com.yz.bean.CompanyCase;
import com.yz.bean.CompanyCol;
import com.yz.bean.Customer;
import com.yz.common.Content;
import com.yz.common.DateUtil;
import com.yz.common.WebUtil;


public class CompanyServlet extends HttpServlet{

	private static final long serialVersionUID = 7553550418013154765L;

	private CompanyService comservice;
	private CompanyCaseService comcaseservice;
	private CompnayColService comcol;
	private AppointServite appservice;
	private CompanyActivityService comactservice;
	
	public CompanyServlet() {
		comservice = new CompanyServiceImpl();
		comcaseservice = new CompanyCaseServiceImpl();
		comcol = new CompanyColServiceImpl();
		appservice = new AppointServiteImpl();
		comactservice = new CompanyActivityServiceImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("reg_page")) {
			reg_page(req,resp);
		} else if (method.equals("reg")) {
			reg(req,resp);
		} else if (method.equals("login_page")) {
			login_page(req, resp);
		} else if (method.equals("login")) {
			login(req, resp);
		} else if (method.equals("home")) {
			home(req,resp);
		} else if (method.equals("editor_page")) {
			editor_page(req,resp);
		} else if (method.equals("editor")) {
			editor(req,resp);
		} else if (method.equals("message")) {
			message(req,resp);
		} else if (method.equals("pwd_page")) {
			pwd_page(req, resp);
		} else if (method.equals("pwd")) {
			pwd(req, resp);
		} else if(method.equals("comdetail")){
			desApp(req,resp);
			desShow(req,resp);
			companydetail(req, resp);
		} else if (method.equals("out")) {
			out(req,resp);
		}
	}
	
	public void out(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("company");
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		out.write("{\"info\":\"数据成功\"}");
	}
	
	public void companydetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company comi = comservice.queryById(id);
		req.setAttribute("comi", comi);
		int total = comcaseservice.count(); // 所有个数
		int pageSize = 3;
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		int pageNo = 1;
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码 1
				if (pageNo <= 0) {
					pageNo = 1;
				} else if (pageNo > totalPage) {
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
			}
		}
		List<CompanyCase> comicase=comcaseservice.queryByPagerCompany(pageNo, pageSize,id);
		List<CompanyActivity> comiact = comactservice.queryPageByCompanyId(pageNo, pageSize, id);
		req.setAttribute("comiact", comiact);
		req.setAttribute("comicase", comicase);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/detail/companydetail.jsp").forward(req, resp);
	}
	
	private void desShow(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		HttpSession session  = req.getSession();
		Object obj = session.getAttribute("customer");
		if(obj != null) {
			Customer cus = (Customer)obj;
			CompanyCol comColId = comcol.queryBySave(id, cus.getId());
			if(comColId != null) {
				req.setAttribute("saved", true);
			} else {
				req.setAttribute("saved", false);
			}
		} else {
			req.setAttribute("saved", false);
		}
	}
	
	public void desApp(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		HttpSession session  = req.getSession();
		Object obj = session.getAttribute("customer");
		if (obj != null) {
			Customer cus = (Customer)obj;
			Appointment appointment = appservice.queryApped(cus.getId(),id);
			if (appointment != null) {
				req.setAttribute("apped", true);
			} else {
				req.setAttribute("apped", false);
			}
		} else {
			req.setAttribute("apped", false);
		}
	}

	public void reg_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
	}
	
	public void login_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company com = comservice.queryById(id);
		req.setAttribute("com", com);
		req.getRequestDispatcher("/companys/change.jsp").forward(req, resp);
	}
	
	public void pwd_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company com = comservice.queryById(id);
		req.setAttribute("com", com);
		req.getRequestDispatcher("/companys/changepwd.jsp").forward(req, resp);
	}
	
	public void message(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		comservice.queryById(id);
		req.getRequestDispatcher("/companys/message.jsp").forward(req, resp);
	}
	
	public void reg(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String principal = req.getParameter("principal");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String tel = req.getParameter("tel");
		String open_date = req.getParameter("open_date");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json;charset=utf-8");
		
		if (email == null || email.trim().equals("") || name == null || name.trim().equals("")) {
			req.setAttribute("errMsg", "请输入邮箱和姓名！---后台");
			reg_page(req,resp);
			return;
		} else {
			Company com = new Company();
			com.setEmail(email);
			com.setPassword(pwd);
			com.setName(name);
			com.setPrincipal(principal);
			com.setAddress(address);
			com.setPhone(phone);
			com.setTel(tel);
			if (open_date != null) {
				com.setOpen_date(DateUtil.parseDate(open_date, "yyyy-MM-dd")); 
			}
			comservice.add(com);
			out.write("{\"info\":\"数据成功\"}");
		}
	}
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json;charset=utf-8");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String S = "Y";
		Company company = comservice.queryByEmailPwd(email, pwd);
		if (company != null) {
			HttpSession session = req.getSession();
			session.setAttribute("company", company);
			if (company.getStatus().equals(S)) {
				comservice.update_time(company.getId());
				out.write("{\"info\":\"数据成功\"}");
				return;
			} else {
				out.write("{\"info\":\"审核暂时未通过，请等待\"}");
			}
		} else {
			out.write("{\"info\":\"邮箱或密码错误\"}");
		}
	}
	
	public void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object company = session.getAttribute("company");
		if (company != null) {
			req.getRequestDispatcher("/companys/company.jsp").forward(req, resp);
		} else if (company == null) {
			resp.sendRedirect("login_page");
		}
	}
	
	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String principal = req.getParameter("principal");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String tel = req.getParameter("tel");
		String open_date = req.getParameter("open_date");
		String longitudeStr = req.getParameter("longitude");
		String latitudeStr = req.getParameter("latitude");
		String des = req.getParameter("des");
		
		Company com = new Company();
		com.setId(id);
		com.setName(name);
		com.setPrincipal(principal);
		com.setPhone(phone);
		com.setAddress(address);
		com.setTel(tel);
		com.setOpen_date(DateUtil.parseDate(open_date, "yyyy-MM-dd"));
		if (longitudeStr != null) { 
			float longitude = 0f;
			try {
				longitude = Float.parseFloat(longitudeStr);
			} catch (NumberFormatException e) {
				System.out.println("出错了");
				return;
			}
			com.setLongitude(longitude);
		}
		if (latitudeStr != null) { 
			float latitude = 0f;
			try {
				latitude = Float.parseFloat(latitudeStr);
			} catch (NumberFormatException e) {
				System.out.println("出错了");
				return;
			}
			com.setLatitude(latitude);
		}
		com.setDes(des);
		
		comservice.update(com);
		Company company = comservice.queryById(id);
		HttpSession session = req.getSession();
		session.setAttribute("company", company);
		out.write("{\"info\":\"数据成功\"}");
	}
	
	public void pwd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json;charset=utf-8");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String old_pwd = req.getParameter("old_pwd");
		String pwd = req.getParameter("pwd");
		if (pwd == null || pwd.trim().equals("") || old_pwd == null || old_pwd.trim().equals("")) {
			out.write("{\"info\":\"密码错误\"}");
			return;
		}
		Company company = comservice.queryByEmailPwd(email, old_pwd);
		if (company == null) {
			out.write("{\"info\":\"密码错误\"}");
			return;
		}
		Company com = new Company();
		com.setId(id);
		com.setPassword(pwd);
		comservice.update_pwd(com);
		out.write("{\"info\":\"数据成功\"}");
	}
	
	
}
