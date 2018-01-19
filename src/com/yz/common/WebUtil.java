package com.yz.common;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

	public static String getUriMethod(HttpServletRequest request) {
		String uri = request.getRequestURI(); 
		return uri.substring(uri.lastIndexOf("/") + 1); // 获取jsp中/后面的数据
	}

}
