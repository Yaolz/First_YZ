package com.yz.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.ServiceCol.DesignerColService;
import com.yz.ServiceCol.DesignerColServiceImpl;
import com.yz.ServiceDesigner.DesignerCaseService;
import com.yz.ServiceDesigner.DesignerCaseServiceImpl;
import com.yz.ServiceDesigner.DesignerService;
import com.yz.ServiceDesigner.DesignerServiceImpl;
import com.yz.bean.Customer;
import com.yz.bean.Designer;
import com.yz.bean.DesignerCase;
import com.yz.bean.DesignerCol;
import com.yz.common.Content;
import com.yz.common.WebUtil;

public class DesignerServlet extends HttpServlet {

	private static final long serialVersionUID = 4679280630079696932L;

	private DesignerService desservice;
	private DesignerCaseService descaseservice;
	private DesignerColService descolservice;

	public DesignerServlet() {
		desservice = new DesignerServiceImpl();
		descaseservice=new DesignerCaseServiceImpl();
		descolservice = new DesignerColServiceImpl();
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
		}else if (method.equals("editor_page")) {
			editor_page(req,resp);
		} else if (method.equals("editor")) {
			editor(req,resp);
		} else if (method.equals("message")) {
			message(req,resp);
		} else if (method.equals("pwd_page")) {
			pwd_page(req, resp);
		} else if (method.equals("pwd")) {
			pwd(req, resp);
		} else if(method.equals("desdetail")){
			desShow(req,resp);
			desdetail(req, resp);
		} else if (method.equals("out")) {
			out(req,resp);
		}
	}
	
	public void out(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("designer");
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		out.write("{\"info\":\"数据成功\"}");
	}
	
	public void desdetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Designer desi = desservice.queryById(id);
		req.setAttribute("desi", desi);

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
	
		List<DesignerCase> desicase=descaseservice.queryByPagerDesigner(pageNo, pageSize,id);
		req.setAttribute("desicase", desicase);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/detail/designerdetail.jsp").forward(req, resp);
	}

	private void desShow(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
//		Company com = comservice.queryById(id);
//		req.setAttribute("com", com);
		HttpSession session  = req.getSession();
		Object obj = session.getAttribute("customer");
		if(obj != null) {
			Customer cus = (Customer)obj;
			DesignerCol descol = descolservice.queryBySave(id, cus.getId());
			if(descol != null) {
				req.setAttribute("saved", true);
			} else {
				req.setAttribute("saved", false);
			}
		} else {
			req.setAttribute("saved", false);
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
		Designer des = desservice.queryById(id);
		req.setAttribute("des", des);
		req.getRequestDispatcher("/designers/change.jsp").forward(req, resp);
	}
	
	public void message(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		desservice.queryById(id);
		req.getRequestDispatcher("/designers/message.jsp").forward(req, resp);
	}
	
	public void pwd_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Designer des = desservice.queryById(id);
		req.setAttribute("des", des);
		req.getRequestDispatcher("/designers/changepwd.jsp").forward(req, resp);
	}
	
	public void reg(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json;charset=utf-8");

		if (email == null || email.trim().equals("") || name == null || name.trim().equals("")) {
			req.setAttribute("errMsg", "请输入邮箱和姓名！---后台");
			reg_page(req, resp);
			return;
		} else {
			Designer des = new Designer();
			des.setEmail(email);
			des.setPassword(pwd);
			des.setName(name);
			des.setAddress(address);
			des.setPhone(phone);

			desservice.add(des);
			out.write("{\"info\":\"数据成功\"}");
		}
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json;charset=utf-8");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String S = "Y";
		Designer designer = desservice.queryByEmailPwd(email, pwd);
		if (designer != null) {
			if (designer.getStatus().equals(S)) {
				HttpSession session = req.getSession();
				session.setAttribute("designer", designer);
				desservice.update_time(designer.getId());
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
		Object designer = session.getAttribute("designer");
		if (designer != null) {
			req.getRequestDispatcher("/designers/designer.jsp").forward(req, resp);
		} else if (designer == null) {
			resp.sendRedirect("login_page");
		}
	}

	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String experience = req.getParameter("experience");
		String style = req.getParameter("style");
		String des = req.getParameter("des");
		
		Designer d = new Designer();
		d.setId(id);
		d.setName(name);
		d.setAddress(address);
		d.setPhone(phone);
		d.setExperience(experience);
		d.setStyle(style);
		d.setDes(des);
		
		desservice.update(d);
		Designer designer = desservice.queryById(id);
		HttpSession session = req.getSession();
		session.setAttribute("designer", designer);
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
		Designer designer = desservice.queryByEmailPwd(email, old_pwd);
		if (designer == null) {
			out.write("{\"info\":\"密码错误\"}");
			return;
		}
		Designer des = new Designer();
		des.setId(id);
		des.setPassword(pwd);
		desservice.update_pwd(des);
		out.write("{\"info\":\"数据成功\"}");
	}
	
}
