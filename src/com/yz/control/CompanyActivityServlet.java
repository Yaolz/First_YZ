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

import com.yz.ServiceCompany.CompanyActivityService;
import com.yz.ServiceCompany.CompanyActivityServiceImpl;
import com.yz.ServiceCompany.CompanyService;
import com.yz.ServiceCompany.CompanyServiceImpl;
import com.yz.bean.Company;
import com.yz.bean.CompanyActivity;
import com.yz.common.FileUtil;
import com.yz.common.WebUtil;

public class CompanyActivityServlet extends HttpServlet {

	private static final long serialVersionUID = 4719490448636011610L;

	private CompanyService comservice;
	private CompanyActivityService activityservice;
	
	public CompanyActivityServlet() {
		comservice = new CompanyServiceImpl();
		activityservice = new CompanyActivityServiceImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("addactivity_page")) {
			addactivity_page(req, resp);
		} else if (method.equals("addactivity")) {
			add(req, resp);
		} else if (method.equals("activitys")) {
			activitys(req, resp);
		} else if (method.equals("com_status")) {
			com_status(req,resp);
		} else if(method.equals("companyactivity_info")){
			companyactivity_info(req, resp);
		} else if (method.equals("editor_page")) {
			editor_page(req,resp);
		} else if (method.equals("editor")) {
			editor(req,resp);
		} else if (method.equals("comdetail")) {
			comdetail(req,resp);
		}
	}
	
	public void comdetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CompanyActivity comact = activityservice.queryById(id);
		req.setAttribute("comact", comact);
		req.getRequestDispatcher("/detail/companyactivitydetail.jsp").forward(req, resp);
	}
	
	public void companyactivity_info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CompanyActivity comacti = activityservice.queryById(id);
		req.setAttribute("comacti", comacti);
		req.getRequestDispatcher("/companys/companyactivity_info.jsp").forward(req, resp);
	}

	public void addactivity_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/companys/addactivity.jsp").forward(req, resp);
	}

	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			CompanyActivity pro = new CompanyActivity();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							pro.setName(item.getString("utf-8"));
						} else if(name.equals("des")) {
							pro.setDes(item.getString("utf-8"));
						} else if(name.equals("id")) {
							pro.setCompany_id(item.getString("utf-8"));
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("image")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								pro.setImage("img/" + item.getName());
							}
						}
					}
				}
				activityservice.add(pro);
				resp.sendRedirect("activitys");
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	public void activitys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("company");
		Company company = (Company)obj;
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
		List<CompanyActivity> comactivity=activityservice.queryPageByCompanyId(pageNo, pageSize, company.getId());
		req.setAttribute("comactivity",comactivity);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/companys/company_activitys.jsp").forward(req, resp);
	}

	public void com_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String statusY = "Y";
		String statusN = "N";
		CompanyActivity com = activityservice.queryById(id);
		if(com.getStatus().equals("Y")) {
			CompanyActivity company = new CompanyActivity();
			company.setId(id);
			company.setStatus(statusN);
			activityservice.update_status(company);
			activitys(req,resp);
		} else if (com.getStatus().equals("N")) {
			CompanyActivity company = new CompanyActivity();
			company.setId(id);
			company.setStatus(statusY);
			activityservice.update_status(company);
			activitys(req,resp);
		}
	}
	
	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CompanyActivity comacti = activityservice.queryById(id);
		req.setAttribute("comacti", comacti);
		req.getRequestDispatcher("/companys/activity_editor.jsp").forward(req, resp);
	}
	
	@SuppressWarnings("hiding")
	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			CompanyActivity company = new CompanyActivity();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							company.setName(item.getString("utf-8"));
						} else if(name.equals("des")) {
							company.setDes(item.getString("utf-8"));
						} else if(name.equals("id")) {
							company.setId(item.getString("utf-8"));
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("image")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								company.setImage("img/" + item.getName());
							}
						}
					}
				}
				activityservice.update(company);
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
