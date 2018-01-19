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

import com.yz.ServiceSupply.SupplyActivityService;
import com.yz.ServiceSupply.SupplyActivityServiceImpl;
import com.yz.ServiceSupply.SupplyService;
import com.yz.ServiceSupply.SupplyServiceImpl;
import com.yz.bean.Supply;
import com.yz.bean.SupplyActivity;
import com.yz.common.FileUtil;
import com.yz.common.WebUtil;

public class SupplyActivityServlet extends HttpServlet{

	private static final long serialVersionUID = -7731947020137462408L;

	private SupplyService supservice;
	private SupplyActivityService supactivity;
	
	public SupplyActivityServlet() {
		supservice = new SupplyServiceImpl();
		supactivity = new SupplyActivityServiceImpl();
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
		} else if (method.equals("sup_status")) {
			sup_status(req,resp);
		} else if (method.equals("supplyactivity_info")) {
			supplyactivity_info(req,resp);
		} else if (method.equals("editor_page")) {
			editor_page(req,resp);
		} else if (method.equals("editor")) {
			editor(req,resp);
		} else if (method.equals("supdetail")) {
			supdetail(req,resp);
		}
	}
	
	public void supdetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		SupplyActivity supacti = supactivity.queryById(id);
		req.setAttribute("supact", supacti);
		req.getRequestDispatcher("/detail/supplyactivitydetail.jsp").forward(req, resp);
	}

	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		SupplyActivity supacti = supactivity.queryById(id);
		req.setAttribute("supacti", supacti);
		req.getRequestDispatcher("/supplys/activity_editor.jsp").forward(req, resp);
	}
	
	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			SupplyActivity supply = new SupplyActivity();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							supply.setName(item.getString("utf-8"));
						} else if(name.equals("des")) {
							supply.setDes(item.getString("utf-8"));
						} else if(name.equals("id")) {
							supply.setId(item.getString("utf-8"));
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("image")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								supply.setImage("img/" + item.getName());
							}
						}
					}
				}
				supactivity.update(supply);
				//resp.setContentType(Constants.JSON_CONTENT_TYPE);
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

	public void supplyactivity_info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		SupplyActivity supacti = supactivity.queryById(id);
		req.setAttribute("supacti", supacti);
		req.getRequestDispatcher("/supplys/supplyactivity_info.jsp").forward(req, resp);
	}
	
	public void addactivity_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/supplys/addactivity.jsp").forward(req, resp);
	}
	/**
	 * 添加活动
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@SuppressWarnings("hiding")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			SupplyActivity activity = new SupplyActivity();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							activity.setName(item.getString("utf-8"));
						} else if(name.equals("des")) {
							activity.setDes(item.getString("utf-8"));
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("image")) {
							if(item.getName() != null && !item.getName().equals("")) {
								FileUtil.save(req, item);
								activity.setImage("img/" + item.getName());
							}
						}
					}
				}
				HttpSession session = req.getSession();
				Object obj = session.getAttribute("supply");
				if(obj != null) {
					Supply sup = (Supply)obj;
					activity.setSupply_id(sup.getId());
				}
				// pro.setCreated_time(Calendar.getInstance().getTime());
				supactivity.add(activity);
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
/**
 * 活动的分页
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void activitys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("supply");
		Supply supply = (Supply)obj;
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
		List<SupplyActivity> supplyactivity = supactivity.queryByPageSupply(pageNo, pageSize, supply.getId());
		req.setAttribute("supplyactivity",supplyactivity);
		req.setAttribute("totalPage",totalPage);
		req.setAttribute("currPage",pageNo);
		req.getRequestDispatcher("/supplys/supply_activity.jsp").forward(req, resp);
	}
/**
 * 修改状态
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	public void sup_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String statusY = "Y";
		String statusN = "N";
		SupplyActivity sup = supactivity.queryById(id);
		if (sup.getStatus().equals("Y")) {
			SupplyActivity supply = new SupplyActivity();
			supply.setId(id);
			supply.setStatus(statusN);
			supactivity.update_status(supply);
			activitys(req,resp);
		} else if (sup.getStatus().equals("N")) {
			SupplyActivity supply = new SupplyActivity();
			supply.setId(id);
			supply.setStatus(statusY);
			supactivity.update_status(supply);
			activitys(req,resp);
		}
	}
	
}
