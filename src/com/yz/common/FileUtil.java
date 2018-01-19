package com.yz.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;



public class FileUtil {
	
	public static String mkUpload(HttpServletRequest req) {
		String path = req.getServletContext().getRealPath("/"); // 获取项目部署后的真实根路径
		File file = new File(path, "img");
		if (!file.exists()) {
			file.mkdir(); // 如果uploads文件夹不存在，则创建此文件夹
		}
		return file.getAbsolutePath();
	}
	
	public static void save(HttpServletRequest req, FileItem item) {
		try {
			InputStream in = item.getInputStream(); // 获取文件输入流
			byte[] bytes = new byte[1024]; // 每次只读1024个字节
			int total = -1;
			FileOutputStream out = new FileOutputStream(FileUtil.mkUpload(req) + "/" + item.getName());
			while ((total = in.read(bytes)) != -1) { // 从客户端读取文件
				// 写出到服务端
				out.write(bytes);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
