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

import com.yz.ServiceCol.ProductColService;
import com.yz.ServiceCol.ProductColServiceImpl;
import com.yz.ServiceSupply.ProductService;
import com.yz.ServiceSupply.ProductServiceImpl;
import com.yz.ServiceSupply.SupplyService;
import com.yz.ServiceSupply.SupplyServiceImpl;
import com.yz.bean.Customer;
import com.yz.bean.Product;
import com.yz.bean.ProductCol;
import com.yz.bean.Supply;
import com.yz.common.Content;
import com.yz.common.FileUtil;
import com.yz.common.WebUtil;

public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 7122572555158101831L;

	private ProductService proservice;
	private SupplyService supservice;
	private ProductColService   productcol;

	public ProductServlet() {
		proservice = new ProductServiceImpl();
		supservice = new SupplyServiceImpl();
		productcol=new ProductColServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("addpro")) {
			add(req, resp);
		} else if (method.equals("addpro_page")) {
			addpro_page(req, resp);
		} else if (method.equals("pros_page")) {
			pros_page(req, resp);
		} else if (method.equals("pro_status")) {
			pro_status(req, resp);
		} else if (method.equals("good_info")) {
			good_info(req, resp);
		} else if (method.equals("editor_page")) {
			editor_page(req,resp);
		} else if (method.equals("editor")) {
			editor(req,resp);
		} else if(method.equals("prodetail")){
			desshow(req, resp);
			prodetail(req, resp);
		}
	}
	
	public void desshow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		HttpSession session  = req.getSession();
		Object obj = session.getAttribute("customer");
		if(obj != null) {
			Customer cus = (Customer)obj;
			ProductCol comColId = productcol.queryBySave(id, cus.getId());
			if(comColId != null) {
				req.setAttribute("saved", true);
			} else {
				req.setAttribute("saved", false);
			}
		} else {
			req.setAttribute("saved", false);
		}
	}


	public void prodetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product prodetail = proservice.queryById(id);
		req.setAttribute("supdetail", prodetail);
		req.getRequestDispatcher("/detail/procasedetail.jsp").forward(req, resp);
	}


	public void good_info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product pro = proservice.queryById(id);
		req.setAttribute("pro", pro);
		req.getRequestDispatcher("/supplys/good_info.jsp").forward(req, resp);
	}

	
	public void pro_status(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String statusY = "Y";
		String statusN = "N";
		Product product = proservice.queryById(id);
		if (product.getStatus().equals("N")) {
			Product pro = new Product();
			pro.setId(id);
			pro.setStatus(statusY);
			proservice.update_status(pro);
			pros_page(req, resp);
		} else {
			Product pro = new Product();
			pro.setId(id);
			pro.setStatus(statusN);
			proservice.update_status(pro);
			pros_page(req, resp);
		}
	}
	
	@SuppressWarnings("hiding")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			Product pro = new Product();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							pro.setName(item.getString("utf-8"));
						} else if (name.equals("price")) {
							pro.setPrice(Float.valueOf(item.getString("utf-8")));
						} else if(name.equals("sale_price")) {
							pro.setSale_price(Float.valueOf(item.getString("utf-8")));
						} else if(name.equals("des")) {
							pro.setDes(item.getString("utf-8"));
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
				HttpSession session = req.getSession();
				Object obj = session.getAttribute("supply");
				if(obj != null) {
					Supply sup = (Supply)obj;
					pro.setSupply_id(sup.getId());
				}
				// pro.setCreated_time(Calendar.getInstance().getTime());
				proservice.add(pro);
				resp.setContentType(Content.ContentType);
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
	

	public void addpro_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply sup = supservice.queryById(id);
		req.setAttribute("sup", sup);
		req.getRequestDispatcher("/supplys/addproduct.jsp").forward(req, resp);
	}

	public void pros_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("supply");
		Supply supply = (Supply)obj;
		int total = proservice.count(); // 所有个数
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

		List<Product> product = proservice.queryByPagerProduct(pageNo, pageSize, supply.getId());
		req.setAttribute("product", product);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.getRequestDispatcher("/supplys/good.jsp").forward(req, resp);
	}
	
	public void editor_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product pro = proservice.queryById(id);
		req.setAttribute("pro", pro);
		req.getRequestDispatcher("/supplys/good_editor.jsp").forward(req, resp);
	}

	@SuppressWarnings("hiding")
	public void editor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			Product pro = new Product();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							pro.setName(item.getString("utf-8"));
						} else if (name.equals("price")) {
							pro.setPrice(Float.valueOf(item.getString("utf-8")));
						} else if(name.equals("sale_price")) {
							pro.setSale_price(Float.valueOf(item.getString("utf-8")));
						} else if(name.equals("des")) {
							pro.setDes(item.getString("utf-8"));
						} else if (name.equals("id")) {
							pro.setId(item.getString("utf-8"));
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
				// pro.setCreated_time(Calendar.getInstance().getTime());
				proservice.update(pro);
				resp.setContentType("text/json;charset=utf-8");
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
