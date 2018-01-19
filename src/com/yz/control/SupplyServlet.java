package com.yz.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.DaoCol.SupplyColDAO;
import com.yz.DaoCol.SupplyColDAOImpl;
import com.yz.ServiceSupply.ProductService;
import com.yz.ServiceSupply.ProductServiceImpl;
import com.yz.ServiceSupply.SupplyActivityService;
import com.yz.ServiceSupply.SupplyActivityServiceImpl;
import com.yz.ServiceSupply.SupplyService;
import com.yz.ServiceSupply.SupplyServiceImpl;
import com.yz.bean.Customer;
import com.yz.bean.Product;
import com.yz.bean.Supply;
import com.yz.bean.SupplyActivity;
import com.yz.bean.SupplyCol;
import com.yz.common.Content;
import com.yz.common.DateUtil;
import com.yz.common.WebUtil;

public class SupplyServlet extends HttpServlet {

	private static final long serialVersionUID = 7675389862400187637L;

	private SupplyService supservice;
	private ProductService proservice;
	private SupplyColDAO supdao;
	private SupplyActivityService supactservice;

	public SupplyServlet() {
		supservice = new SupplyServiceImpl();
		proservice = new ProductServiceImpl();
		supdao = new SupplyColDAOImpl();
		supactservice = new SupplyActivityServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("reg_page")) {
			reg_page(req, resp);
		} else if (method.equals("reg")) {
			reg(req, resp);
		} else if (method.equals("login_page")) {
			login_page(req, resp);
		} else if (method.equals("login")) {
			login(req, resp);
		} else if (method.equals("home")) {
			home(req, resp);
		} else if(method.equals("message")){
			message(req, resp);
		} else if (method.equals("editor")) {
			editor(req,resp);
		} else if (method.equals("editor_page")) {
			editor_page(req,resp);
		} else if (method.equals("pwd_page")) {
			pwd_page(req, resp);
		} else if (method.equals("pwd")) {
			pwd(req, resp);
		} else if(method.equals("supidetail")){
			desShow(req,resp);
			supidetail(req, resp);
		} else if (method.equals("out")) {
			out(req,resp);
		}
	}
	
	public void out(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("supply");
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		out.write("{\"info\":\"数据成功\"}");
	}
	
	public void supidetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply sup = supservice.queryById(id);
		req.setAttribute("supi", sup);

		int total = proservice.count(); // 所有个数
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
		List<Product> proicase=proservice.queryByPagerProduct(pageNo, pageSize, id);
		List<SupplyActivity> supact = supactservice.queryByPageSupply(pageNo, pageSize, id);
		req.setAttribute("proicase", proicase);
		req.setAttribute("supact", supact);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/detail/supplydetail.jsp").forward(req, resp);
	}

	private void desShow(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		HttpSession session  = req.getSession();
		Object obj = session.getAttribute("customer");
		if(obj != null) {
			Customer cus = (Customer)obj;
			SupplyCol comColId = supdao.queryBySave(id, cus.getId());
			if(comColId != null) {
				req.setAttribute("saved", true);
			} else {
				req.setAttribute("saved", false);
			}
		} else {
			req.setAttribute("saved", false);
		}
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
		Supply supply = supservice.queryByEmailPwd(email, old_pwd);
		if (supply == null) {
			out.write("{\"info\":\"密码错误\"}");
			return;
		}
		Supply sup = new Supply();
		sup.setId(id);
		sup.setPassword(pwd);
		supservice.update_pwd(sup);
		out.write("{\"info\":\"数据成功\"}");
		
	}

	public void pwd_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply sup = supservice.queryById(id);
		req.setAttribute("sup", sup);
		req.getRequestDispatcher("/supplys/changepwd.jsp").forward(req, resp);
	}
	
	public void reg_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/supply.jsp").forward(req, resp);
	}

	public void login_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply sup = supservice.queryById(id);
		req.setAttribute("sup", sup);
		req.getRequestDispatcher("/supplys/change.jsp").forward(req, resp);
	}
	public void message(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		supservice.queryById(id);
		req.getRequestDispatcher("/supplys/message.jsp").forward(req, resp);
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
			reg_page(req, resp);
			return;
		} else {
			Supply sup = new Supply();
			sup.setEmail(email);
			sup.setPassword(pwd);
			sup.setName(name);
			sup.setPrincipal(principal);
			sup.setAddress(address);
			sup.setPhone(phone);
			sup.setTel(tel);
			if (open_date != null) {
				sup.setOpen_date(DateUtil.parseDate(open_date, "yyyy-MM-dd"));
			}
			supservice.add(sup);
			out.write("{\"info\":\"数据成功\"}");
		}
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json;charset=utf-8");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String S = "Y";
		Supply supply = supservice.queryByEmailPwd(email, pwd);
		if (supply != null) {
			if (supply.getStatus().equals(S)) {
				HttpSession session = req.getSession();
				session.setAttribute("supply", supply);
				supservice.update_time(supply.getId());
				out.write("{\"info\":\"数据成功\"}");
			} else {
				out.write("{\"info\":\"审核暂时未通过，请等待\"}");
			}
		} else {
			out.write("{\"info\":\"邮箱或密码错误\"}");
		}
	}

	public void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object supply = session.getAttribute("supply");
		if (supply != null) {
			req.getRequestDispatcher("/supplys/supply.jsp").forward(req, resp);
		} else if (supply == null) {
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
		
		Supply sup = new Supply();
		sup.setId(id);
		sup.setName(name);
		sup.setPrincipal(principal);
		sup.setPhone(phone);
		sup.setAddress(address);
		sup.setTel(tel);
		sup.setOpen_date(DateUtil.parseDate(open_date, "yyyy-MM-dd"));
		if (longitudeStr != null) { 
			float longitude = 0f;
			try {
				longitude = Float.parseFloat(longitudeStr);
			} catch (NumberFormatException e) {
				return;
			}
			sup.setLongitude(longitude);
		}
		if (latitudeStr != null) { 
			float latitude = 0f;
			try {
				latitude = Float.parseFloat(latitudeStr);
			} catch (NumberFormatException e) {
				return;
			}
			sup.setLatitude(latitude);
		}
		sup.setDes(des);
		
		supservice.update(sup);
		Supply supply = supservice.queryById(id);
		HttpSession session = req.getSession();
		session.setAttribute("supply", supply);
		out.write("{\"info\":\"数据成功\"}");
	}
	
}
