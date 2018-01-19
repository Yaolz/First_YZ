package com.yz.ServiceSupply;

import java.util.List;

import com.yz.bean.Product;
import com.yz.dao.BaseDAO;

public interface ProductService extends BaseDAO<Integer, Product>{

	public List<Product> querySupplyId(String supplyid);
	
	public List<Product> queryByPagerProduct(int pageNo, int pageSize,String productid);
	
}
