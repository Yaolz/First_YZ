package com.yz.DaoCol;

import java.util.List;

import com.yz.bean.Product;
import com.yz.bean.ProductCol;

public interface ProductColDAO extends BaseCol<Integer,ProductCol>{

	public List<Product> queryPage(int pageNo, int pageSize,String customerid);
	
}
