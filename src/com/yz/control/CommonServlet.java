package com.yz.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.ServiceCompany.CompanyCaseService;
import com.yz.ServiceCompany.CompanyCaseServiceImpl;
import com.yz.ServiceCompany.CompanyService;
import com.yz.ServiceCompany.CompanyServiceImpl;
import com.yz.ServiceDesigner.DesignerCaseService;
import com.yz.ServiceDesigner.DesignerCaseServiceImpl;
import com.yz.ServiceDesigner.DesignerService;
import com.yz.ServiceDesigner.DesignerServiceImpl;
import com.yz.ServiceSupply.SupplyService;
import com.yz.ServiceSupply.SupplyServiceImpl;
import com.yz.bean.Company;
import com.yz.bean.CompanyCase;
import com.yz.bean.Designer;
import com.yz.bean.DesignerCase;
import com.yz.bean.Supply;
import com.yz.common.WebUtil;

public class CommonServlet extends HttpServlet {

	private static final long serialVersionUID = -8803523802928727656L;

	private CompanyService comservice;
	private DesignerService desservice;
	private SupplyService supservice;
	private CompanyCaseService caseservice;
	private DesignerCaseService descaseservice;

	public CommonServlet() {
		comservice = new CompanyServiceImpl();
		desservice = new DesignerServiceImpl();
		supservice = new SupplyServiceImpl();
		caseservice = new CompanyCaseServiceImpl();
		descaseservice = new DesignerCaseServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("regss")) {
			registerss(req, resp);
		} else if (method.equals("logins")) {
			logins(req, resp);
		} else if (method.equals("companys")) {
			companys(req, resp);
		} else if (method.equals("descase")) {
			designercase(req, resp);
		} else if (method.equals("desi")) {
			designer(req, resp);
		} else if (method.equals("supplys")) {
			supplys(req, resp);
		} else if (method.equals("indexs")) {
			indexs(req, resp);
		} else if (method.equals("common")) {
			common(req, resp);
		}
	}

	public void indexs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}

	public void registerss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
	}

	public void logins(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	public void designercase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = descaseservice.count(); // 显示公司个数
		int pageSize = 6;
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		int pageNo = 1;
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码
														// 1
				if (pageNo <= 0) {
					pageNo = 1;
				} else if (pageNo > totalPage) {
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
			}
		}
		List<DesignerCase> desicase = descaseservice.queryByPager(pageNo, pageSize);
		HttpSession session = req.getSession();
		session.setAttribute("desicase", desicase);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/designercase.jsp").forward(req, resp);
	}

	public void companys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = comservice.count(); // 显示公司个数
		int pageSize = 6;
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		int pageNo = 1;
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码
														// 1
				if (pageNo <= 0) {
					pageNo = 1;
				} else if (pageNo > totalPage) {
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
			}
		}

		List<Company> company = comservice.queryByPager(pageNo, pageSize);
		HttpSession session = req.getSession();
		session.setAttribute("companypage", company);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/company.jsp").forward(req, resp);
	}

	public void designer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = desservice.count(); // 显示设计师个数
		int pageSize = 6;
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		int pageNo = 1;
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码
														// 1
				if (pageNo <= 0) {
					pageNo = 1;
				} else if (pageNo > totalPage) {
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
			}
		}

		List<Designer> designer = desservice.queryByPager(pageNo, pageSize);
		HttpSession session = req.getSession();
		session.setAttribute("designerpage", designer);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/designer.jsp").forward(req, resp);
	}

	public void supplys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = supservice.count(); // 显示建材商个数
		int pageSize = 6;
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
		int pageNo = 1;
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码
														// 1
				if (pageNo <= 0) {
					pageNo = 1;
				} else if (pageNo > totalPage) {
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
			}
		}

		List<Supply> supply = supservice.queryByPager(pageNo, pageSize);
		HttpSession session = req.getSession();
		session.setAttribute("supplypage", supply);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/supply.jsp").forward(req, resp);
	}

	public void common(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageSize = 6;
		int pageNo = 1;
		List<Company> com = comservice.queryByPager(pageNo, pageSize);
		List<CompanyCase> comcase = caseservice.queryByPager(pageNo, pageSize);
		List<Designer> des = desservice.queryByPager(pageNo, pageSize);
		List<Supply> sup = supservice.queryByPager(pageNo, pageSize);
		HttpSession session = req.getSession();
		session.setAttribute("com", com);
		session.setAttribute("comcase", comcase);
		session.setAttribute("des", des);
		session.setAttribute("sup", sup);
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}

}
