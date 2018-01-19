package com.yz.ServiceCol;

import java.util.List;

import com.yz.DaoCol.ProductColDAO;
import com.yz.DaoCol.ProductColDAOImpl;
import com.yz.bean.Product;
import com.yz.bean.ProductCol;

public class ProductColServiceImpl implements ProductColService{

	private ProductColDAO prodao;
	
	public ProductColServiceImpl() {
		prodao = new ProductColDAOImpl();
	}
	
	@Override
	public void add(ProductCol t) {
		prodao.add(t);
	}

	@Override
	public void delete(String id,String customerid) {
		prodao.delete(id,customerid);
	}

	@Override
	public List<ProductCol> queryByCustomerId(String customerid) {
		return prodao.queryByCustomerId(customerid);
	}

	@Override
	public List<ProductCol> queryPageByCustomerId(int pageNo, int pageSize, String customerid) {
		return prodao.queryPageByCustomerId(pageNo, pageSize, customerid);
	}

	@Override
	public ProductCol queryById(String id) {
		return prodao.queryById(id);
	}

	@Override
	public int count() {
		return prodao.count();
	}

	@Override
	public ProductCol queryBySave(String id, String customerid) {
		return prodao.queryBySave(id, customerid);
	}

	@Override
	public List<Product> queryPage(int pageNo, int pageSize, String customerid) {
		return prodao.queryPage(pageNo, pageSize, customerid);
	}

}
