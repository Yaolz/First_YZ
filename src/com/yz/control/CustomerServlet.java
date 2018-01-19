package com.yz.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.ServiceCol.CompanyCaseColService;
import com.yz.ServiceCol.CompanyCaseColServiceImpl;
import com.yz.ServiceCol.CompanyColServiceImpl;
import com.yz.ServiceCol.CompnayColService;
import com.yz.ServiceCol.DesignerCaseColService;
import com.yz.ServiceCol.DesignerCaseColServiceImpl;
import com.yz.ServiceCol.DesignerColService;
import com.yz.ServiceCol.DesignerColServiceImpl;
import com.yz.ServiceCol.ProductColService;
import com.yz.ServiceCol.ProductColServiceImpl;
import com.yz.ServiceCol.SupplyColService;
import com.yz.ServiceCol.SupplyColServiceImpl;
import com.yz.ServiceCustomer.AppointServite;
import com.yz.ServiceCustomer.AppointServiteImpl;
import com.yz.ServiceCustomer.CustomerService;
import com.yz.ServiceCustomer.CustomerServiceImpl;
import com.yz.bean.Appointment;
import com.yz.bean.Company;
import com.yz.bean.CompanyCase;
import com.yz.bean.Customer;
import com.yz.bean.Designer;
import com.yz.bean.DesignerCase;
import com.yz.bean.Product;
import com.yz.bean.Supply;
import com.yz.common.Content;
import com.yz.common.EncryptUtil;
import com.yz.common.WebUtil;

public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1028159468904311542L;

	private CustomerService cusservice;
	private CompnayColService comcol;
	private DesignerColService descol;
	private SupplyColService supcol;
	private CompanyCaseColService companycasecol;
	private DesignerCaseColService designercasecol;
	private ProductColService productcol;
	private AppointServite appservice;

	public CustomerServlet() {
		cusservice = new CustomerServiceImpl();
		comcol = new CompanyColServiceImpl();
		descol = new DesignerColServiceImpl();
		supcol = new SupplyColServiceImpl();
		companycasecol=new CompanyCaseColServiceImpl();
		designercasecol=new DesignerCaseColServiceImpl();
		productcol=new ProductColServiceImpl();
		appservice = new AppointServiteImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("reg")) {
			reg(req, resp);
		} else if (method.equals("reg_page")) {
			reg_page(req, resp);
		} else if (method.equals("login_page")) {
			login_page(req, resp);
		} else if (method.equals("login")) {
			login(req, resp);
		} else if (method.equals("home")) {
			home(req, resp);
		} else if (method.equals("all")) {
			all(req, resp);
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
		} else if (method.equals("companycol")) {
			companycol(req, resp);
		} else if (method.equals("designercol")) {
			designercol(req, resp);
		} else if (method.equals("supplycol")) {
			supplycol(req, resp);
		} else if (method.equals("deletedes")) {
			deletedes(req,resp);
		} else if (method.equals("deletecom")) {
			deletecomcol(req,resp);
		} else if (method.equals("deletesup")) {
			deletesup(req,resp);
		} else if(method.equals("comcasecol")){
			comcasecol(req, resp);
		} else if(method.equals("descasecol")){
			descasecol(req, resp);
		} else if(method.equals("procol")){
			procol(req, resp);
		} else if(method.equals("deleteproduct")){
			deleteproduct(req, resp);
		} else if(method.equals("deletedesigner")){
			deletedesigner(req, resp);
		} else if(method.equals("deletecompany")){
			deletecompany(req, resp);
		} else if (method.equals("out")) {
			out(req,resp);
		} 
	}
	
	public void out(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("customer");
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		out.write("{\"info\":\"数据成功\"}");
	}
	
	public void deletecompany(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		companycasecol.delete(id,cus.getId());
		resp.sendRedirect("comcasecol");
	}
	
	public void deletedesigner(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		designercasecol.delete(id,cus.getId());
		resp.sendRedirect("descasecol");
	}
	

	public void deleteproduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		productcol.delete(id,cus.getId());
		resp.sendRedirect("procol");
	}
	
	public void comcasecol(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		int total = companycasecol.count(); // 所有个数
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
		List<CompanyCase> comcol = companycasecol.queryPage(pageNo, pageSize, cus.getId());
		req.setAttribute("comcol", comcol);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/customers/company_casescol.jsp").forward(req, resp);
	}

	public void descasecol(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		int total = designercasecol.count(); // 所有个数
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
		List<DesignerCase> descol = designercasecol.queryPage(pageNo, pageSize, cus.getId());
		req.setAttribute("descol", descol);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/customers/designer_casescol.jsp").forward(req, resp);
	}
	
	public void procol(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		int total = productcol.count(); // 所有个数
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
		List<Product> procol = productcol.queryPage(pageNo, pageSize, cus.getId());
		req.setAttribute("procol", procol);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/customers/productcol.jsp").forward(req, resp);
	}
	public void reg_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
	}

	public void login_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Customer cus = cusservice.queryById(id);
		req.setAttribute("cus", cus);
		req.getRequestDispatcher("/customers/change.jsp").forward(req, resp);
	}

	public void pwd_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Customer cus = cusservice.queryById(id);
		req.setAttribute("cus", cus);
		req.getRequestDispatcher("/customers/changepwd.jsp").forward(req, resp);
	}

	public void message(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		cusservice.queryById(id);
		req.getRequestDispatcher("/customers/message.jsp").forward(req, resp);
	}

	public void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json;charset=utf-8");

		if (email == null || email.trim().equals("") || name == null || name.trim().equals("")) {
			req.setAttribute("errMsg", "请输入邮箱和姓名！---后台");
			reg_page(req, resp);
			return;
		} else {
			Customer cus = new Customer();
			cus.setEmail(email);
			cus.setPassword(EncryptUtil.encrypt(pwd));
			cus.setName(name);
			cus.setPhone(phone);

			cusservice.add(cus);
			out.write("{\"info\":\"数据成功\"}");
		}
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		Customer customer = cusservice.queryByEmailPwd(email, EncryptUtil.encrypt(pwd));
		if (customer != null) {
			HttpSession session = req.getSession();
			session.setAttribute("customer", customer);
			cusservice.update_time(customer.getId());
			out.write("{\"info\":\"数据成功\"}");
		} else {
			out.write("{\"info\":\"邮箱或密码错误\"}");
		}
	}

	private void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object customer = session.getAttribute("customer");
		if (customer != null) {
			req.getRequestDispatcher("/customers/customer.jsp").forward(req, resp);
		} else if (customer == null) {
			resp.sendRedirect("login_page");
		}
	}

	public void all(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Customer> cus = cusservice.queryAll();
		req.setAttribute("cus", cus);
		req.getRequestDispatcher("/customers/customer.jsp").forward(req, resp);
	}

	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String plot_name = req.getParameter("plot_name");
		String address = req.getParameter("address");

		Customer cus = new Customer();
		cus.setName(name);
		cus.setId(id);
		cus.setPhone(phone);
		cus.setPlot_name(plot_name);
		cus.setAddress(address);

		cusservice.update(cus);
		Customer cuss = cusservice.queryById(id);
		HttpSession session = req.getSession();
		session.setAttribute("customer", cuss);
		out.write("{\"info\":\"数据成功\"}");
	}

	public void pwd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String old_pwd = req.getParameter("old_pwd");
		String pwd = req.getParameter("pwd");// EncryptUtil.encrypt(req.getParameter("pwd"));
		if (pwd == null || pwd.trim().equals("") || old_pwd == null || old_pwd.trim().equals("")) {
			out.write("{\"info\":\"密码为空\"}");
			return;
		}
		Customer customer = cusservice.queryByEmailPwd(email, EncryptUtil.encrypt(old_pwd));
		if (customer == null) {
			out.write("{\"info\":\"密码错误---\"}");
			return;
		}
		Customer cus = new Customer();
		cus.setId(id);
		cus.setPassword(EncryptUtil.encrypt(pwd));
		cusservice.update_pwd(cus);
		out.write("{\"info\":\"数据成功\"}");
	}

	public void companycol(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		int total = comcol.count(); // 所有个数
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
		List<Company> companycol = comcol.queryPage(pageNo, pageSize, cus.getId());
		req.setAttribute("companycol", companycol);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/customers/company_col.jsp").forward(req, resp);
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
	
	public void deletecomcol(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		comcol.delete(id,cus.getId());
		resp.sendRedirect("companycol");
	}
	
	public void designercol(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		int total = descol.count(); // 所有个数
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
		List<Designer> designercol = descol.queryPage(pageNo, pageSize, cus.getId());
		req.setAttribute("designercol", designercol);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/customers/designer_col.jsp").forward(req, resp);
	}

	public void deletedes(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		descol.delete(id,cus.getId());
		resp.sendRedirect("designercol");
	}
	
	public void supplycol(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		int total = supcol.count(); // 所有个数
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
		List<Supply> supplycol = supcol.queryPage(pageNo, pageSize, cus.getId());
		req.setAttribute("supplycol", supplycol);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/customers/supply_col.jsp").forward(req, resp);
	}
	
	public void deletesup(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			return;
		}
		supcol.delete(id,cus.getId());
		resp.sendRedirect("supplycol");
	}

}
