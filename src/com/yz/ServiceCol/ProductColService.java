package com.yz.ServiceCol;

import java.util.List;

import com.yz.bean.Product;
import com.yz.bean.ProductCol;

public interface ProductColService extends ServiceCol<Integer,ProductCol>{

	public List<Product> queryPage(int pageNo, int pageSize,String customerid);
	
}
