package com.yz.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.DaoCol.CompanyCaseColDAO;
import com.yz.DaoCol.CompanyCaseColDAOImpl;
import com.yz.DaoCol.CompanyColDAO;
import com.yz.DaoCol.CompanyColDAOImpl;
import com.yz.DaoCol.DesignerColDAO;
import com.yz.DaoCol.DesignerColDAOImpl;
import com.yz.DaoCol.SupplyColDAO;
import com.yz.DaoCol.SupplyColDAOImpl;
import com.yz.ServiceCol.DesignerCaseColService;
import com.yz.ServiceCol.DesignerCaseColServiceImpl;
import com.yz.ServiceCol.ProductColService;
import com.yz.ServiceCol.ProductColServiceImpl;
import com.yz.bean.CompanyCaseCol;
import com.yz.bean.CompanyCol;
import com.yz.bean.Customer;
import com.yz.bean.DesignerCaseCol;
import com.yz.bean.DesignerCol;
import com.yz.bean.ProductCol;
import com.yz.bean.SupplyCol;
import com.yz.common.Content;
import com.yz.common.WebUtil;

public class ColServlet extends HttpServlet{

	private static final long serialVersionUID = 2623473169669883555L;

	private CompanyColDAO comdao;
	private DesignerColDAO desdao;
	private SupplyColDAO supdao;
	private CompanyCaseColDAO comcasedao;
	private DesignerCaseColService descasecol;
	private ProductColService productcol;
	
	public ColServlet() {
		comdao = new CompanyColDAOImpl();
		desdao = new DesignerColDAOImpl();
		supdao = new SupplyColDAOImpl();
		comcasedao = new CompanyCaseColDAOImpl();
		descasecol = new DesignerCaseColServiceImpl();
		productcol=new ProductColServiceImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("companycol")) {
			company(req,resp);
		} else if (method.equals("designercol")) {
			designercol(req,resp);
		} else if (method.equals("supplycol")) {
			supplycol(req,resp);
		} else if (method.equals("companycasecol")) {
			companycasecol(req,resp);
		} else if (method.equals("designercasecol")) {
			designercasecol(req,resp);
		} else if(method.equals("productcol")){
			productcol(req, resp);
		}
	}

	public void company(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String companyid = req.getParameter("com_id");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			resp.setContentType(Content.ContentType);
			out.write("{\"save\":\"您没有权限！请登录用户账号\"}");
			return;
		}
		CompanyCol com = new CompanyCol();
		if (companyid != null) {
			com.setCompany_id(companyid);
			com.setCustomer_id(cus.getId());
			comdao.add(com);
			out.write("{\"save\":\"成功\"}");
		} else {
			out.write("{\"save\":\"收藏失败\"}");
		}
		
	}
	
	public void designercol(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String designer_id = req.getParameter("des_id");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			resp.setContentType(Content.ContentType);
			out.write("{\"save\":\"您没有权限！请登录用户账号\"}");
			return;
		}
		DesignerCol des = new DesignerCol();
		if (designer_id != null) {
			des.setDesigner_id(designer_id);
			des.setCustomer_id(cus.getId());
			desdao.add(des);
			out.write("{\"save\":\"成功\"}");
		} else {
			out.write("{\"save\":\"收藏失败\"}");
		}
	}

	public void supplycol(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String supply_id = req.getParameter("sup_id");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			resp.setContentType(Content.ContentType);
			out.write("{\"save\":\"您没有权限！请登录用户账号\"}");
			return;
		}
		SupplyCol sup = new SupplyCol();
		if (supply_id != null) {
			sup.setSupply_id(supply_id);
			sup.setCustomer_id(cus.getId());
			supdao.add(sup);
			out.write("{\"save\":\"成功\"}");
		} else {
			out.write("{\"save\":\"收藏失败\"}");
		}
	}
	
	public void companycasecol(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String comcase_id = req.getParameter("comcase_id");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			resp.setContentType(Content.ContentType);
			out.write("{\"save\":\"您没有权限！请登录用户账号\"}");
			return;
		}
		CompanyCaseCol comcase = new CompanyCaseCol();
		if (comcase != null) {
			comcase.setCase_id(comcase_id);
			comcase.setCustomer_id(cus.getId());
			comcasedao.add(comcase);
			out.write("{\"save\":\"成功\"}");
		} 
	}
	
	public void designercasecol(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String descase_id = req.getParameter("descase_id");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			resp.setContentType(Content.ContentType);
			out.write("{\"save\":\"您没有权限！请登录用户账号\"}");
			return;
		}
		DesignerCaseCol descase = new DesignerCaseCol();
		if(descase != null) {
			descase.setCase_id(descase_id);
			descase.setCustomer_id(cus.getId());
			descasecol.add(descase);
			out.write("{\"save\":\"成功\"}");
		} 
	}
	
	public void productcol(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pro_id = req.getParameter("pro_id");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		Object obj = session.getAttribute("customer");
		Customer cus = null;
		if(obj != null) {
			cus = (Customer)obj;
		} else {
			resp.setContentType(Content.ContentType);
			out.write("{\"save\":\"您没有权限！请登录用户账号\"}");
			return;
		}
		ProductCol pro = new ProductCol();
		if(pro != null) {
			pro.setProduct_id(pro_id);
			pro.setCustomer_id(cus.getId());
			productcol.add(pro);
			out.write("{\"save\":\"成功\"}");
		} 
	}
	
}
