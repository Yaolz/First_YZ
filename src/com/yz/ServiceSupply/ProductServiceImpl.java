package com.yz.ServiceSupply;

import java.util.List;

import com.yz.DaoSupply.ProductDAO;
import com.yz.DaoSupply.ProductDAOImpl;
import com.yz.bean.Product;

public class ProductServiceImpl implements ProductService{

	private ProductDAO prodao;
	
	public ProductServiceImpl() {
		prodao = new ProductDAOImpl();
	}
	
	@Override
	public void add(Product t) {
		prodao.add(t);
	}

	@Override
	public void delete(String id) {
		prodao.delete(id);
	}

	@Override
	public void update(Product t) {
		prodao.update(t);
	}

	@Override
	public void update_pwd(Product t) {
		prodao.update_pwd(t);
	}

	@Override
	public void update_status(Product t) {
		prodao.update_status(t);
	}

	@Override
	public List<Product> queryAll() {
		return prodao.queryAll();
	}

	@Override
	public List<Product> queryByPager(int pageNo, int pageSize) {
		return prodao.queryByPager(pageNo, pageSize);
	}

	@Override
	public Product queryById(String id) {
		return prodao.queryById(id);
	}

	@Override
	public int count() {
		return prodao.count();
	}

	@Override
	public List<Product> querySupplyId(String supplyid) {
		return prodao.querySupplyId(supplyid);
	}

	@Override
	public List<Product> queryByPagerProduct(int pageNo, int pageSize, String productid) {
		return prodao.queryByPagerProduct(pageNo, pageSize, productid);
	}

}
