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

import com.yz.ServiceCol.DesignerCaseColService;
import com.yz.ServiceCol.DesignerCaseColServiceImpl;
import com.yz.ServiceDesigner.DesignerCaseService;
import com.yz.ServiceDesigner.DesignerCaseServiceImpl;
import com.yz.ServiceDesigner.DesignerService;
import com.yz.ServiceDesigner.DesignerServiceImpl;
import com.yz.bean.Customer;
import com.yz.bean.Designer;
import com.yz.bean.DesignerCase;
import com.yz.bean.DesignerCaseCol;
import com.yz.common.FileUtil;
import com.yz.common.WebUtil;

public class DesignerCaseServlet extends HttpServlet {

	private static final long serialVersionUID = -386557542758343454L;

	private DesignerCaseService descaseservice;
	private DesignerService desservice;
	private DesignerCaseColService descolservice;

	public DesignerCaseServlet() {
		descaseservice = new DesignerCaseServiceImpl();
		desservice = new DesignerServiceImpl();
		descolservice = new DesignerCaseColServiceImpl();
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
		} else if(method.equals("des_status")){
			des_status(req, resp);
		} else if(method.equals("designercase_info")){
			designercase_info(req, resp);
		} else if (method.equals("editor_page")) {
			editor_page(req,resp);
		} else if (method.equals("editor")) {
			editor(req,resp);
		} else if(method.equals("casedetail")){
			desShow(req, resp);
			desdetail(req, resp);
		}

	}
	
	public void desdetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		DesignerCase desdetail= descaseservice.queryById(id);
		req.setAttribute("desdetail", desdetail);
		req.getRequestDispatcher("/detail/designercasedetail.jsp").forward(req, resp);
	}
	private void desShow(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		HttpSession session  = req.getSession();
		Object obj = session.getAttribute("customer");
		if(obj != null) {
			Customer cus = (Customer)obj;
			DesignerCaseCol descol = descolservice.queryBySave(id, cus.getId());
			if(descol != null) {
				req.setAttribute("saved", true);
			} else {
				req.setAttribute("saved", false);
			}
		} else {
			req.setAttribute("saved", false);
		}
	}
	
	
	public void designercase_info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		DesignerCase desinfo = descaseservice.queryById(id);
		req.setAttribute("desinfo", desinfo);
		req.getRequestDispatcher("/designers/designercase_info.jsp").forward(req, resp);
	}
	
	public void des_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String statusY = "Y";
		String statusN = "N";
		DesignerCase designer = descaseservice.queryById(id);
		if (designer.getStatus().equals("N")){
			DesignerCase des = new DesignerCase();
			des.setId(id);
			des.setStatus(statusY);
			descaseservice.update_status(des);
			cases_page(req, resp);
		} else {
			DesignerCase des = new DesignerCase();
			des.setId(id);
			des.setStatus(statusN);
			descaseservice.update_status(des);
			cases_page(req, resp);
		}
	}

	@SuppressWarnings("hiding")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			DesignerCase designer = new DesignerCase();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							designer.setName(item.getString("utf-8"));
						} else if(name.equals("des")) {
							designer.setDes(item.getString("utf-8"));
						} else if (name.equals("plot_name")) {
							designer.setPlot_name(item.getString("utf-8"));
						} else if (name.equals("style")) {
							designer.setStyle(item.getString("utf-8"));
						}  else if(name.equals("id")) {
							designer.setDesigner_id(item.getString("utf-8"));
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("image_1")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_1("img/" + item.getName());
							}
						} else if (name.equals("image_2")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_2("img/" + item.getName());
							}
						} else if (name.equals("image_3")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_3("img/" + item.getName());
							}
						} else if (name.equals("image_4")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_4("img/" + item.getName());
							}
						} else if (name.equals("image_5")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_5("img/" + item.getName());
							}
						}
					}
				}
				descaseservice.add(designer);
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
	
	public void addcase_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/designers/addcase.jsp").forward(req, resp);
	}

	public void cases_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("designer");
		Designer designer = (Designer)obj;
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
	
		List<DesignerCase> descase=descaseservice.queryByPagerDesigner(pageNo, pageSize,designer.getId());
		req.setAttribute("descase", descase);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/designers/designer_cases.jsp").forward(req, resp);
	}

	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		DesignerCase desinfo = descaseservice.queryById(id);
		req.setAttribute("desinfo", desinfo);
		req.getRequestDispatcher("/designers/case_editor.jsp").forward(req, resp);
	}
	
	@SuppressWarnings("hiding")
	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			DesignerCase designer = new DesignerCase();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							designer.setName(item.getString("utf-8"));
						} else if(name.equals("des")) {
							designer.setDes(item.getString("utf-8"));
						} else if (name.equals("plot_name")) {
							designer.setPlot_name(item.getString("utf-8"));
						} else if (name.equals("style")) {
							designer.setStyle(item.getString("utf-8"));
						}  else if(name.equals("id")) {
							designer.setId(item.getString("utf-8"));
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("image_1")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_1("img/" + item.getName());
							}
						} else if (name.equals("image_2")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_2("img/" + item.getName());
							}
						} else if (name.equals("image_3")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_3("img/" + item.getName());
							}
						} else if (name.equals("image_4")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_4("img/" + item.getName());
							}
						} else if (name.equals("image_5")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								designer.setImage_5("img/" + item.getName());
							}
						}
					}
				}
				// pro.setCreated_time(Calendar.getInstance().getTime());
				descaseservice.update(designer);
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
