package com.yz.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.ServiceAdimin.AdminService;
import com.yz.ServiceAdimin.AdminServiceImpl;
import com.yz.ServiceCompany.CompanyActivityService;
import com.yz.ServiceCompany.CompanyActivityServiceImpl;
import com.yz.ServiceCompany.CompanyCaseService;
import com.yz.ServiceCompany.CompanyCaseServiceImpl;
import com.yz.ServiceCompany.CompanyService;
import com.yz.ServiceCompany.CompanyServiceImpl;
import com.yz.ServiceCustomer.CustomerService;
import com.yz.ServiceCustomer.CustomerServiceImpl;
import com.yz.ServiceDesigner.DesignerCaseService;
import com.yz.ServiceDesigner.DesignerCaseServiceImpl;
import com.yz.ServiceDesigner.DesignerService;
import com.yz.ServiceDesigner.DesignerServiceImpl;
import com.yz.ServiceSupply.ProductService;
import com.yz.ServiceSupply.ProductServiceImpl;
import com.yz.ServiceSupply.SupplyActivityService;
import com.yz.ServiceSupply.SupplyActivityServiceImpl;
import com.yz.ServiceSupply.SupplyService;
import com.yz.ServiceSupply.SupplyServiceImpl;
import com.yz.bean.Admin;
import com.yz.bean.Company;
import com.yz.bean.CompanyActivity;
import com.yz.bean.CompanyCase;
import com.yz.bean.Customer;
import com.yz.bean.Designer;
import com.yz.bean.DesignerCase;
import com.yz.bean.Product;
import com.yz.bean.Supply;
import com.yz.bean.SupplyActivity;
import com.yz.common.Content;
import com.yz.common.WebUtil;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = -5991629183178042696L;

	private AdminService admservice;
	private CompanyService comservice;
	private DesignerService desservice;
	private SupplyService supservice;
	private CustomerService cusservice;
	private CompanyActivityService activityservice;
	private CompanyCaseService caseservice;
	private DesignerCaseService descaseservice;
	private ProductService proservice;
	private SupplyActivityService supactivity;
	
	

	public AdminServlet() {
		admservice = new AdminServiceImpl();
		comservice = new CompanyServiceImpl();
		desservice = new DesignerServiceImpl();
		supservice = new SupplyServiceImpl();
		cusservice = new CustomerServiceImpl();
		activityservice = new CompanyActivityServiceImpl();
		caseservice = new CompanyCaseServiceImpl();
		descaseservice = new DesignerCaseServiceImpl();
		proservice = new ProductServiceImpl();
		supactivity = new SupplyActivityServiceImpl();
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("reg")) {
			reg(req, resp);
		} else if (method.equals("reg_page")) {
			reg_page(req, resp);
		} else if (method.equals("home")) {
			home(req, resp);
		} else if (method.equals("login_page")) {
			login_page(req, resp);
		} else if (method.equals("login")) {
			login(req, resp);
		} else if (method.equals("editor_page")) {
			editor_page(req, resp);
		} else if (method.equals("editor")) {
			editor(req, resp);
		} else if (method.equals("message")) {
			message(req, resp);
		} else if (method.equals("pwd_page")) {
			pwd_page(req, resp);
		} else if (method.equals("pwd")) {
			pwd(req, resp);
		} else if(method.equals("comstatus")){
			compager(req, resp);
		} else if(method.equals("desstatus")){
			despager(req, resp);
		} else if(method.equals("supstatus")){
			suppager(req, resp);
		} else if(method.equals("admstatus")){
			admpager(req, resp);
		}  else if (method.equals("com_status")) {
			com_status(req,resp);
		} else if (method.equals("des_status")) {
			des_status(req,resp);
		} else if (method.equals("sup_status")) {
			sup_status(req,resp);
		} else if (method.equals("customers")) {
			customers(req,resp);
		} else if(method.equals("alladmin")){
			alladmin(req, resp);
		} else if(method.equals("allcompany")){
			allcompany(req, resp);
		} else if(method.equals("alldesigner")){
			alldesigner(req, resp);
		} else if(method.equals("allsupply")){
			allsupply(req, resp);
		} else if(method.equals("companys_info")){
			companys_info(req, resp);
		} else if(method.equals("designers_info")){
			designers_info(req, resp);
		} else if(method.equals("supplys_info")){
			supplys_info(req, resp);
		} else if (method.equals("comactivitys")) {
			comactivitys(req, resp);
		} else if (method.equals("comcases_page")) {
			comcases_page(req,resp);
		} else if (method.equals("descases_page")) {
			descases_page(req, resp);
		} else if (method.equals("activitys")) {
			activitys(req, resp);
		} else if (method.equals("good")) {
			pros_page(req, resp);
		}	else if(method.equals("admin")){
			admin(req, resp);
		} else if (method.equals("out")) {
			out(req,resp);
		} else if (method.equals("zyz")) {
			zyz(req,resp);
		} else if (method.equals("sup_login")) {
			sup_login(req,resp);
		} else if (method.equals("sup_admin")) {
			sup_admin(req,resp);
		} else if (method.equals("adm_status")) {
			amd_status(req,resp);
		}
	}
	
	public void amd_status(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String statusY = "Y";
		String statusN = "N";
		Admin admin = admservice.queryById(id);
		if (admin.getStatus().equals(statusY)) {
			admin.setStatus("N");
			admservice.update_status(admin);
			resp.sendRedirect("alladmin");
		} else {
			admin.setStatus("Y");
			admservice.update_status(admin);
			resp.sendRedirect("alladmin");
		}
	}
	
	public void zyz(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/sup_login.jsp").forward(req, resp);
	}
	
	public void sup_login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		Admin admin = admservice.queryByEmailPwd(email, pwd);
		if(admin != null) {
			if (admin.getEmail().equals("10086@126.com")) {
				HttpSession session = req.getSession();
				session.setAttribute("admin", admin);
				out.write("{\"info\":\"数据成功\"}");
			} else {
				out.write("{\"info\":\"邮箱或密码错误\"}");
			}
		} else {
			out.write("{\"info\":\"邮箱或密码错误\"}");
		}
	}
	
	public void sup_admin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admins/supadmin.jsp").forward(req, resp);
	}
	
	public void out(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("admin");
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		out.write("{\"info\":\"数据成功\"}");
	}
	
	public void admin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admins/admin.jsp").forward(req, resp);
	}
	public void pros_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply sup = supservice.queryById(id);
		req.setAttribute("sup", sup);
		int total = proservice.count(); // 所有个数
		int pageSize = 3;
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		int pageNo = 1;
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码
				if (pageNo <= 0) {
					pageNo = 1;
				} else if (pageNo > totalPage) {
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
			}
		}

		List<Product> pro = proservice.queryByPagerProduct(pageNo, pageSize, id);
		req.setAttribute("pro", pro);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/admins/good.jsp").forward(req, resp);
	}
 
	public void activitys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply sup = supservice.queryById(id);
		req.setAttribute("sup", sup);
		int total = supactivity.count(); // 所有活动的总数
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
		List<SupplyActivity> supplyactivity = supactivity.queryByPageSupply(pageNo, pageSize, id);
		req.setAttribute("supplyactivity",supplyactivity);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/admins/supply_activity.jsp").forward(req, resp);
	}

	
	public void descases_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Designer des = desservice.queryById(id);
		req.setAttribute("des", des);
		int total = descaseservice.count(); // 所有个数
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
	
		List<DesignerCase> descase=descaseservice.queryByPagerDesigner(pageNo, pageSize,id);
		req.setAttribute("descase", descase);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/admins/designer_cases.jsp").forward(req, resp);
	}

	
	public void comcases_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company com =  comservice.queryById(id);
		req.setAttribute("com", com);
		
		int total = caseservice.count(); // 所有个数
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
	
		List<CompanyCase> comcase=caseservice.queryByPagerCompany(pageNo, pageSize,id);
		req.setAttribute("comcase", comcase);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/admins/company_cases.jsp").forward(req, resp);
	}
	
	public void comactivitys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company com = comservice.queryById(id);
		req.setAttribute("com", com);
		int total = activityservice.count(); // 所有活动的总数
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
		List<CompanyActivity> comactivity=activityservice.queryPageByCompanyId(pageNo, pageSize, id);
		req.setAttribute("comactivity",comactivity);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/admins/company_activitys.jsp").forward(req, resp);
	}
	public void supplys_info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply sup = supservice.queryById(id);
		req.setAttribute("sup", sup);
		req.getRequestDispatcher("/admins/supplys_info.jsp").forward(req, resp);
	}
	public void designers_info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Designer des = desservice.queryById(id);
		req.setAttribute("des", des);
		req.getRequestDispatcher("/admins/designers_info.jsp").forward(req, resp);
	}

	public void companys_info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company com = comservice.queryById(id);
		req.setAttribute("com", com);
		req.getRequestDispatcher("/admins/companys_info.jsp").forward(req, resp);
	}
	
	public void commoncompager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = comservice.count(); // 公司
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
		List<Company> com=comservice.queryByPager(pageNo, pageSize);
		req.setAttribute("com",com);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
	}
	
	public void compager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		commoncompager(req, resp);
		req.getRequestDispatcher("/admins/company_auditing.jsp").forward(req, resp);
	}
	
	public void allcompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		commoncompager(req, resp);
		req.getRequestDispatcher("/admins/companys.jsp").forward(req, resp);
	}

	public void commonadmpager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = admservice.count(); // 所有的管理个数
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
		List<Admin> adm=admservice.queryByPager(pageNo, pageSize);
		req.setAttribute("adm",adm);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
	}
	public void admpager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		commonadmpager(req, resp);
		req.getRequestDispatcher("/admins/adm_auditing.jsp").forward(req, resp);
	}

	public void commondespager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = desservice.count(); // 所有的商品个数
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
		List<Designer> des=desservice.queryByPager(pageNo, pageSize);
		req.setAttribute("des",des);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
	}
	public void despager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		commondespager(req, resp);
		req.getRequestDispatcher("/admins/designer_auditing.jsp").forward(req, resp);
	}
	
	public void alldesigner(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		commondespager(req, resp);
		req.getRequestDispatcher("/admins/designers.jsp").forward(req, resp);
	}
	
	
	public void commonsuppager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = supservice.count(); // 所有的商品个数
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
		List<Supply> sup=supservice.queryByPager(pageNo, pageSize);
		req.setAttribute("sup",sup);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
	}
	
	public void suppager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		commonsuppager(req, resp);
		req.getRequestDispatcher("/admins/supply_auditing.jsp").forward(req, resp);
	}
	
	public void allsupply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		commonsuppager(req, resp);
		req.getRequestDispatcher("/admins/supplys.jsp").forward(req, resp);
	}
	
	public void alladmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Admin> adm = admservice.queryAll();
		req.setAttribute("adm", adm);
		req.getRequestDispatcher("/admins/adm_auditing.jsp").forward(req, resp);
	}

	public void reg_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin.jsp").forward(req, resp);
	}

	public void login_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin_login.jsp").forward(req, resp);
	}
/**
 * 修改页面
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Admin adm = admservice.queryById(id);
		req.setAttribute("adm", adm);
		req.getRequestDispatcher("/admins/change.jsp").forward(req, resp);
	}
/**
 * 显示信息
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void message(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		admservice.queryById(id);
		req.getRequestDispatcher("/admins/message.jsp").forward(req, resp);
	}
/**
 * 修改密码
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void pwd_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Admin adm = admservice.queryById(id);
		req.setAttribute("adm", adm);
		req.getRequestDispatcher("/admins/changepwd.jsp").forward(req, resp);
	}
/**
 * 注册，即添加数据到数据库
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String role = "普通管理员";
		String status = "Y";

		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setPassword(pwd);
		admin.setName(name);
		admin.setPhone(phone);
		admin.setRole(role);
		admin.setStatus(status);

		admservice.add(admin);
		req.getRequestDispatcher("/add.jsp").forward(req, resp);
	}
/**
 * 登录
 * @param req
 * @param resp
 * @throws IOException
 * @throws ServletException
 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		Admin admin = admservice.queryByEmailPwd(email, pwd);
		if (admin != null) {
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			out.write("{\"info\":\"数据成功\"}");
		} else {
			out.write("{\"info\":\"邮箱或密码错误\"}");
		}
	}

	private void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object admin = session.getAttribute("admin");
		if (admin != null) {
			req.getRequestDispatcher("/admins/admin.jsp").forward(req, resp);
		} else if (admin == null) {
			resp.sendRedirect("login_page");
		}
	}
/**
 * 对信息修改的具体操作
 * @param req
 * @param resp
 * @throws IOException
 * @throws ServletException
 */
	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pwd");

		Admin admin = new Admin();
		admin.setId(id);
		admin.setName(name);
		admin.setPhone(phone);
		admin.setPassword(pwd);

		admservice.update(admin);
		Admin adm = admservice.queryById(id);
		HttpSession session = req.getSession();
		session.setAttribute("admin", adm);
		resp.sendRedirect("message");
	}
/**
 * 修改密码以及密码的判断
 * @param req
 * @param resp
 * @throws IOException
 * @throws ServletException
 */
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
		Admin admin = admservice.queryByEmailPwd(email, old_pwd);
		if (admin == null) {
			out.write("{\"info\":\"密码错误\"}");
			return;
		}
		Admin adm = new Admin();
		adm.setId(id);
		adm.setPassword(pwd);
		admservice.update_pwd(adm);
		out.write("{\"info\":\"数据成功\"}");
	}
	public void companystatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> com = comservice.queryAll();
		req.setAttribute("com", com);
		req.getRequestDispatcher("/admins/company_auditing.jsp").forward(req, resp);
	}
	public void designerstatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Designer> des = desservice.queryAll();
		req.setAttribute("des", des);
		req.getRequestDispatcher("/admins/designer_auditing.jsp").forward(req, resp);
	}
	
	public void supplystatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Supply> sup = supservice.queryAll();
		req.setAttribute("sup", sup);
		req.getRequestDispatcher("/admins/supply_auditing.jsp").forward(req, resp);
	}
/**
 * 修改公司的状态，审核
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void com_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String statusY = "Y";
		String statusN = "N";
		Company com = comservice.queryById(id);
		if (com.getStatus().equals("N")){
			Company company = new Company();
			company.setId(id);
			company.setStatus(statusY);
			comservice.update_status(company);
			compager(req,resp);
		} else {
			Company company = new Company();
			company.setId(id);
			company.setStatus(statusN);
			comservice.update_status(company);
			compager(req,resp);
		}
	}
/**
 * 设计师的审核
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void des_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String status = "Y";
		Designer des = desservice.queryById(id);
		if (des.getStatus().equals("N")){
			Designer designer = new Designer();
			designer.setId(id);
			designer.setStatus(status);
			desservice.update_status(designer);
			despager(req,resp);
		} else {
			despager(req,resp);
		}
	}
/**
 * 建材商的审核
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void sup_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String status = "Y";
		Supply sup = supservice.queryById(id);
		if (sup.getStatus().equals("N")){
			Supply supply = new Supply();
			supply.setId(id);
			supply.setStatus(status);
			supservice.update_status(supply);
			suppager(req,resp);
		} else {
			suppager(req,resp);
		}
	}
	
	public void company_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> com = comservice.queryAll();
		req.setAttribute("com", com);
		req.getRequestDispatcher("/admins/company_auditing.jsp").forward(req, resp);
	}
	
	public void customers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = cusservice.count(); // 所有的商品个数
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
		List<Customer> cus=cusservice.queryByPager(pageNo, pageSize);
		req.setAttribute("cus",cus);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/admins/customers.jsp").forward(req, resp);
	}
	
}
