package com.yz.DaoAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Admin;
import com.yz.common.AbstractBaseDAO;

public class AdminDAOImpl extends AbstractBaseDAO implements AdminDAO {

	@Override
	public void add(Admin t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_admin(id,email,password,name,phone,role,status) values(uuid(),?,?,?,?,?,?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getName());
			ps.setString(4, t.getPhone());
			ps.setString(5, t.getRole());
			ps.setString(6, t.getStatus());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {

	}

	@Override
	public void update(Admin t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update t_admin set name=?, phone=? where id = ?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update_pwd(Admin t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_admin set password=? where id = ?");
			ps.setString(1, t.getPassword());
			ps.setString(2, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Admin> queryAll() {
		Connection conn = getConn();
		List<Admin> adm = new ArrayList<Admin>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_admin");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin a = new Admin();
				a.setId(rs.getString("id"));
				a.setName(rs.getString("name"));
				a.setImg(rs.getString("img"));
				a.setEmail(rs.getString("email"));
				a.setPhone(rs.getString("phone"));
				a.setStatus(rs.getString("status"));
				a.setRole(rs.getString("role"));
				adm.add(a);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adm;
	}

	@Override
	public List<Admin> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Admin> admin = new ArrayList<Admin>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_admin limit ?,?");
			ps.setInt(1, (pageNo-1)*5);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin com = new Admin();
				com.setImg(rs.getString("img"));
				com.setName(rs.getString("name"));
				com.setPhone(rs.getString("phone"));
				com.setStatus(rs.getString("status"));
				admin.add(com);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public Admin queryById(String id) {
		Connection conn = getConn();
		Admin adm = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_admin where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				adm = new Admin();
				adm.setId(rs.getString("id"));
				adm.setEmail(rs.getString("email"));
				adm.setName(rs.getString("name"));
				adm.setPhone(rs.getString("phone"));
				adm.setImg(rs.getString("img"));
				adm.setCreated_time(rs.getDate("created_time"));
				adm.setLast_login_time(rs.getDate("last_login_time"));
				adm.setRole(rs.getString("role"));
				adm.setStatus(rs.getString("status"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adm;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_admin");
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
	public List<Admin> queryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin queryByEmailPwd(String email, String password) {
		Connection conn = getConn();
		Admin admin = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_admin where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setEmail(email);
				admin.setPassword(password);
				admin.setImg(rs.getString("img"));
				admin.setName(rs.getString("name"));
				admin.setId(rs.getString("id"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public void update_status(Admin t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_admin set status=? where id = ?");
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
			PreparedStatement ps = conn.prepareStatement("update t_admin set last_login_time = CURRENT_TIMESTAMP where id = ?");
			ps.setString(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
