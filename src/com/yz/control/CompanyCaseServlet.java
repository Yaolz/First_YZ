package com.yz.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yz.ServiceCol.CompanyCaseColService;
import com.yz.ServiceCol.CompanyCaseColServiceImpl;
import com.yz.ServiceCompany.CompanyCaseService;
import com.yz.ServiceCompany.CompanyCaseServiceImpl;
import com.yz.ServiceCompany.CompanyService;
import com.yz.ServiceCompany.CompanyServiceImpl;
import com.yz.bean.Company;
import com.yz.bean.CompanyCase;
import com.yz.bean.CompanyCaseCol;
import com.yz.bean.Customer;
import com.yz.common.FileUtil;
import com.yz.common.WebUtil;

public class CompanyCaseServlet extends HttpServlet {

	private static final long serialVersionUID = 7471510004867494938L;

	private CompanyService comservice;
	private CompanyCaseService caseservice;
	private CompanyCaseColService companycasecol;
	

	public CompanyCaseServlet() {
		comservice = new CompanyServiceImpl();
		caseservice = new CompanyCaseServiceImpl();
		companycasecol=new CompanyCaseColServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("addcase")) {
			add(req, resp);
		} else if (method.equals("addcase_page")) {
			addcase_page(req, resp);
		} else if (method.equals("cases_page")) {
			cases_page(req, resp);
		} else if (method.equals("com_status")) {
			com_status(req, resp);
		}  else if(method.equals("companycase_info")){
			companycase_info(req, resp);
		} else if (method.equals("editor_page")) {
			editor_page(req,resp);
		} else if (method.equals("editor")) {
			editor(req,resp);
		} else if(method.equals("casedetail")){
			desShow(req, resp);
			casedetail(req, resp);
		}
	}
	
	public void casedetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CompanyCase comdetail = caseservice.queryById(id);
		req.setAttribute("comdetail", comdetail);
		req.getRequestDispatcher("/detail/companycasedetail.jsp").forward(req, resp);
	}
	
	private void desShow(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		HttpSession session  = req.getSession();
		Object obj = session.getAttribute("customer");
		if(obj != null) {
			Customer cus = (Customer)obj;
			CompanyCaseCol comColId = companycasecol.queryBySave(id, cus.getId());
			if(comColId != null) {
				req.setAttribute("saved", true);
			} else {
				req.setAttribute("saved", false);
			}
		} else {
			req.setAttribute("saved", false);
		}
	}
	
	public void companycase_info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CompanyCase cominfo = caseservice.queryById(id);
		req.setAttribute("cominfo", cominfo);
		req.getRequestDispatcher("/companys/companycase_info.jsp").forward(req, resp);
	}

	@SuppressWarnings("hiding")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			CompanyCase company = new CompanyCase();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							company.setName(item.getString("utf-8"));
						} else if(name.equals("des")) {
							company.setDes(item.getString("utf-8"));
						} else if (name.equals("plot_name")) {
							company.setPlot_name(item.getString("utf-8"));
						} else if (name.equals("style")) {
							company.setStyle(item.getString("utf-8"));
						}  else if(name.equals("id")) {
							company.setCompany_id(item.getString("utf-8"));
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("image_1")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_1("img/" + item.getName());
							}
						} else if (name.equals("image_2")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_2("img/" + item.getName());
							}
						} else if (name.equals("image_3")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_3("img/" + item.getName());
							}
						} else if (name.equals("image_4")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_4("img/" + item.getName());
							}
						} else if (name.equals("image_5")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_5("img/" + item.getName());
							}
						}
					}
				}
				caseservice.add(company);
				out.write("{\"error\":\"添加成功\"}");
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public void addcase_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/companys/addcase.jsp").forward(req, resp);
	}

	public void cases_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("company");
		Company company = (Company)obj;

		int total = caseservice.count(); // 所有个数
		int pageSize = 3;
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

		List<CompanyCase> comcase = caseservice.queryByPagerCompany(pageNo, pageSize, company.getId());
		req.setAttribute("comcase", comcase);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/companys/company_cases.jsp").forward(req, resp);
	}

	public void com_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String statusY = "Y";
		String statusN = "N";
		CompanyCase com = caseservice.queryById(id);
		if (com.getStatus().equals("N")) {
			CompanyCase company = new CompanyCase();
			company.setId(id);
			company.setStatus(statusY);
			caseservice.update_status(company);
			cases_page(req, resp);
		} else {
			CompanyCase company = new CompanyCase();
			company.setId(id);
			company.setStatus(statusN);
			caseservice.update_status(company);
			cases_page(req, resp);
		}
	}
	
	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CompanyCase cominfo = caseservice.queryById(id);
		req.setAttribute("cominfo", cominfo);
		req.getRequestDispatcher("/companys/case_editor.jsp").forward(req, resp);
	}
	
	@SuppressWarnings("hiding")
	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			CompanyCase company = new CompanyCase();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							company.setName(item.getString("utf-8"));
						} else if(name.equals("des")) {
							company.setDes(item.getString("utf-8"));
						} else if (name.equals("plot_name")) {
							company.setPlot_name(item.getString("utf-8"));
						} else if (name.equals("style")) {
							company.setStyle(item.getString("utf-8"));
						}  else if(name.equals("id")) {
							company.setId(item.getString("utf-8"));
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("image_1")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_1("img/" + item.getName());
							}
						} else if (name.equals("image_2")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_2("img/" + item.getName());
							}
						} else if (name.equals("image_3")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_3("img/" + item.getName());
							}
						} else if (name.equals("image_4")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_4("img/" + item.getName());
							}
						} else if (name.equals("image_5")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage_5("img/" + item.getName());
							}
						}
					}
				}
				caseservice.update(company);
				//resp.setContentType(Constants.JSON_CONTENT_TYPE);
				out.write("{\"error\":\"添加成功\"}");
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
