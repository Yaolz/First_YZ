package com.yz.DaoSupply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Product;
import com.yz.common.AbstractBaseDAO;

public class ProductDAOImpl extends AbstractBaseDAO implements ProductDAO{

	@Override
	public void add(Product t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_product(id,supply_id,name,price,sale_price,des,image) values(uuid(),?,?,?,?,?,?)");
			ps.setString(1, t.getSupply_id());
			ps.setString(2, t.getName());
			ps.setFloat(3, t.getPrice());
			ps.setFloat(4, t.getSale_price());
			ps.setString(5, t.getDes());
			ps.setString(6, t.getImage());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("");
			ps.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Product t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_product set name=?, price=?, sale_price=?, des=?, image=? where id=?");
			ps.setString(1, t.getName());
			ps.setFloat(2, t.getPrice());
			ps.setFloat(3, t.getSale_price());
			ps.setString(4, t.getDes());
			ps.setString(5, t.getImage());
			ps.setString(6, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_pwd(Product t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("");
			ps.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_status(Product t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_product set status=? where id = ?");
			ps.setString(1, t.getStatus());
			ps.setString(2, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> queryAll() {
		Connection conn = getConn();
		List<Product> pros = new ArrayList<Product>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pro = new Product();
				pro.setId(rs.getString("id"));
				pro.setSupply_id(rs.getString("supply_id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getFloat("price"));
				pro.setSale_price(rs.getFloat("sale_price"));
				pro.setImage(rs.getString("image"));
				pro.setDes(rs.getString("des"));
				pro.setStatus(rs.getString("status"));
				pros.add(pro);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pros;
	}

	@Override
	public List<Product> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("");
			ps.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product queryById(String id) {
		Connection conn = getConn();
		Product pro = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_product where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pro = new Product();
				pro.setId(rs.getString("id"));
				pro.setSupply_id(rs.getString("supply_id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getFloat("price"));
				pro.setSale_price(rs.getFloat("sale_price"));
				pro.setImage(rs.getString("image"));
				pro.setDes(rs.getString("des"));
				pro.setCreated_time(rs.getDate("created_time"));
				pro.setStatus(rs.getString("status"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_product");
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
	public List<Product> querySupplyId(String supplyid) {
		Connection conn = getConn();
		List<Product> pros = new ArrayList<Product>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_product where supply_id = ?");
			ps.setString(1, supplyid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product pro = new Product();
				pro.setId(rs.getString("id"));
				pro.setSupply_id(rs.getString("supply_id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getFloat("price"));
				pro.setSale_price(rs.getFloat("sale_price"));
				pro.setImage(rs.getString("image"));
				pro.setDes(rs.getString("des"));
				pro.setStatus(rs.getString("status"));
				pros.add(pro);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pros;
	}

	@Override
	public List<Product> queryByPagerProduct(int pageNo, int pageSize, String productid) {
		Connection conn = getConn();
		List<Product> product= new ArrayList<Product>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_product where supply_id=? limit ?,?");
			ps.setString(1, productid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pro = new Product();
				pro.setSupply_id(productid);
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
