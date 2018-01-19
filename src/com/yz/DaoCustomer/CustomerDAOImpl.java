package com.yz.DaoCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Customer;
import com.yz.common.AbstractBaseDAO;
import com.yz.control.CustomerServlet;

public class CustomerDAOImpl extends AbstractBaseDAO implements CustomerDAO{

	@Override
	public void add(Customer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_customer(id,email,img,password,name,phone) values(uuid(),?,?,?,?,?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getName());
			ps.setString(4, t.getPhone());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		
	}

	@Override
	public void update(Customer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update t_customer set name=?, phone=?, plot_name=?, address=? where id = ?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getPlot_name());
			ps.setString(4, t.getAddress());
			ps.setString(5, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> queryAll() {
		Connection conn = getConn();
		List<Customer> cus = new ArrayList<Customer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_customer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Customer c =  new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setImg(rs.getString("img"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setAddress(rs.getString("address"));
				c.setPlot_name(rs.getString("plot_name"));
				cus.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cus;
	}
	@Override
	public List<Customer> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Customer> customer= new ArrayList<Customer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_customer limit ?,?");
			ps.setInt(1, (pageNo-1)*3);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer cus = new Customer();
				cus.setId(rs.getString("id"));
				cus.setName(rs.getString("name"));
				cus.setImg(rs.getString("img"));
				cus.setPhone(rs.getString("phone"));
				cus.setStatus(rs.getString("status"));
				cus.setEmail(rs.getString("email"));
				cus.setPlot_name(rs.getString("plot_name"));
				cus.setLast_login_time(rs.getDate("last_login_time"));
				cus.setAddress(rs.getString("address"));
				customer.add(cus);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_customer");
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
	public Customer queryById(String id) {
		Connection conn = getConn();
		Customer cus = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_customer where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cus = new Customer();
				cus.setId(id);
				cus.setPassword(rs.getString("password"));
				cus.setImg(rs.getString("img"));
				cus.setName(rs.getString("name"));
				cus.setEmail(rs.getString("email"));
				cus.setPhone(rs.getString("phone"));
				cus.setAddress(rs.getString("address"));
				cus.setPlot_name(rs.getString("plot_name"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public List<Customer> queryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer queryByEmailPwd(String email, String password) {
		Connection conn = getConn();
		Customer customer = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_customer where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setEmail(email);
				customer.setImg(rs.getString("img"));
				customer.setPassword(password);
				customer.setStatus(rs.getString("status"));
				customer.setName(rs.getString("name"));
				customer.setId(rs.getString("id"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void update_pwd(Customer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update t_customer set password=? where id = ?");
			ps.setString(1, t.getPassword());
			ps.setString(2, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_status(Customer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set status=? where id = ?");
			ps.setString(1, t.getStatus());
			ps.setString(2, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update_time(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set last_login_time = CURRENT_TIMESTAMP where id = ?");
			ps.setString(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
