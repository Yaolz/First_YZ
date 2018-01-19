package com.yz.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.ServiceCompany.CompanyService;
import com.yz.ServiceCompany.CompanyServiceImpl;
import com.yz.ServiceCustomer.AppointServite;
import com.yz.ServiceCustomer.AppointServiteImpl;
import com.yz.bean.Appointment;
import com.yz.bean.Company;
import com.yz.bean.Customer;
import com.yz.common.Content;
import com.yz.common.WebUtil;

public class AppointmentServlet extends HttpServlet{
	
	private static final long serialVersionUID = -2577400294202942538L;

	private AppointServite appservice;
	private CompanyService comservice;
	
	public AppointmentServlet() {
		appservice = new AppointServiteImpl();
		comservice = new CompanyServiceImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("com")) {
			com(req,resp);
		} else if (method.equals("com_page")) {
			com_page(req,resp);
		} else if (method.equals("company")) {
			company(req,resp);
		} else if (method.equals("app_company")) {
			app_company(req,resp);
		} else if (method.equals("deletecom")) {
			deletecom(req,resp);
		}
	}

	public void com(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType(Content.ContentType);
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			System.out.println("出错");
			return;
		}
		String com_id = req.getParameter("com_id");
		String app_name = req.getParameter("app_name");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String plot_name = req.getParameter("plot_name");
		String area = req.getParameter("area");
		String budget = req.getParameter("budget");
		String way = req.getParameter("way");
		
		Appointment app = new Appointment();
		app.setUser_id(cus.getId());
		app.setCompany_id(com_id);
		app.setApp_name(app_name);
		app.setName(name);
		app.setPhone(phone);
		app.setPlot_name(plot_name);
		app.setArea(Float.parseFloat(area));
		app.setBudget(budget);
		app.setWay(way);
		appservice.add(app);
		out.write("{\"error\":\"成功\"}");
	}
	
	public void com_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String com_id = req.getParameter("com_id");
		Company com = comservice.queryById(com_id);
		req.setAttribute("com", com);
		req.getRequestDispatcher("/appointment/company.jsp").forward(req, resp);
	}
	
	public void company(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("customer");
		Customer cus = (Customer)obj;
		int total = appservice.count(); // 所有个数
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
		List<Appointment> app = appservice.queryPagerByUserId(pageNo, pageSize, cus.getId());
		req.setAttribute("app", app);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/customers/company_appointment.jsp").forward(req, resp);
	}
	
	public void app_company(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("company");
		Company com = (Company)obj;
		int total = appservice.count(); // 所有个数
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
		List<Appointment> app = appservice.queryPagerByCompany(pageNo, pageSize, com.getId());
		req.setAttribute("app", app);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/companys/appointment.jsp").forward(req, resp);
	}
	
	public void deletecom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		appservice.delete(id);
		resp.sendRedirect("company");
	}
	
}
