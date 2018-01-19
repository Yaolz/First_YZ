package com.yz.DaoCol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Product;
import com.yz.bean.ProductCol;
import com.yz.common.AbstractBaseDAO;

public class ProductColDAOImpl extends AbstractBaseDAO implements ProductColDAO{

	@Override
	public void add(ProductCol t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_product_col(id,customer_id,product_id) value(uuid(),?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getProduct_id());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id,String customerid) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_product_col where product_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductCol> queryByCustomerId(String customerid) {
		Connection conn = getConn();
		List<ProductCol> desi = new ArrayList<ProductCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_product_col where customer_id=?");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductCol c =  new ProductCol();
				c.setId(rs.getString("id"));
				c.setProduct_id(rs.getString("product_id"));
				c.setCustomer_id(rs.getString("customer_id"));
				c.setCreated_time(rs.getDate("created_time"));
				desi.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return desi;
	}

	@Override
	public List<ProductCol> queryPageByCustomerId(int pageNo, int pageSize,String customerid) {
		Connection conn = getConn();
		List<ProductCol> product = new ArrayList<ProductCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_product_col customer_id=? limit ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductCol pro = new ProductCol();
				pro.setId(rs.getString("id"));
				pro.setProduct_id(rs.getString("product_id"));
				pro.setCustomer_id(rs.getString("customer_id"));
				pro.setCreated_time(rs.getDate("created_time"));
				product.add(pro);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public ProductCol queryById(String id) {
		Connection conn=getConn();
		ProductCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_product_col where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new ProductCol();
				desi.setId(rs.getString("id"));
				desi.setProduct_id(rs.getString("product_id"));
				desi.setCustomer_id(rs.getString("customer_id"));
				desi.setCreated_time(rs.getDate("created_time"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return desi;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_product_col");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ProductCol queryBySave(String id, String customerid) {
		Connection conn=getConn();
		ProductCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_product_col where product_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new ProductCol();
				desi.setId(rs.getString("id"));
				desi.setProduct_id(rs.getString("product_id"));
				desi.setCustomer_id(rs.getString("customer_id"));
				desi.setCreated_time(rs.getDate("created_time"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return desi;
	}

	@Override
	public List<Product> queryPage(int pageNo, int pageSize, String customerid) {
		Connection conn=getConn();
		List<Product> product = new ArrayList<Product>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select t_product.* from t_product, t_product_col where t_product.id = t_product_col.product_id and t_product_col.customer_id=? LIMIT ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pro = new Product();
				pro.setSupply_id(rs.getString("supply_id"));
				pro.setId(rs.getString("id"));
				pro.setPrice(rs.getFloat("price"));
				pro.setSale_price(rs.getFloat("sale_price"));
				pro.setName(rs.getString("name"));
				pro.setImage(rs.getString("image"));
				pro.setStatus(rs.getString("status"));
				product.add(pro);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

}
