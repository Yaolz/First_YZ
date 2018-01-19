package com.yz.DaoDesigner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Designer;
import com.yz.common.AbstractBaseDAO;

public class DesignerDAOImpl extends AbstractBaseDAO implements DesignerDAO {

	@Override
	public void add(Designer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_designer(id,email,password,name,address,phone) values(uuid(),?,?,?,?,?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getName());
			ps.setString(4, t.getAddress());
			ps.setString(5, t.getPhone());
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
	public void update(Designer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update t_designer set name=?, phone=?, address=?, experience=?, style=?,des=? where id = ?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getAddress());
			ps.setString(4, t.getExperience());
			ps.setString(5, t.getStyle());
			ps.setString(6, t.getDes());
			ps.setString(7, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Designer> queryAll() {
		Connection conn = getConn();
		List<Designer> des = new ArrayList<Designer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Designer d =  new Designer();
				d.setId(rs.getString("id"));
				d.setName(rs.getString("name"));
				d.setEmail(rs.getString("email"));
				d.setPhone(rs.getString("phone"));
				d.setAddress(rs.getString("address"));
				d.setExperience(rs.getString("experience"));
				d.setStyle(rs.getString("style"));
				d.setDes(rs.getString("des"));
				d.setStatus(rs.getString("status"));
				des.add(d);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return des;
	}

	@Override
	public List<Designer> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Designer> designer= new ArrayList<Designer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_designer limit ?,?");
			ps.setInt(1, (pageNo-1)*3);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Designer des = new Designer();
				des.setId(rs.getString("id"));
				des.setName(rs.getString("name"));
				des.setEmail(rs.getString("email"));
				des.setPhone(rs.getString("phone"));
				des.setAddress(rs.getString("address"));
				des.setHeadicon(rs.getString("headicon"));
				des.setDes(rs.getString("des"));
				des.setStatus(rs.getString("status"));
				designer.add(des);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designer;
	}
	

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_designer");
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
	public Designer queryById(String id) {
		Connection conn = getConn();
		Designer des = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				des = new Designer();
				des.setId(rs.getString("id"));
				des.setName(rs.getString("name"));
				des.setEmail(rs.getString("email"));
				des.setPhone(rs.getString("phone"));
				des.setHeadicon(rs.getString("headicon"));
				des.setChecked(rs.getString("checked"));
				des.setChecked_time(rs.getDate("checked_time"));
				des.setLast_login_time(rs.getDate("last_login_time"));
				des.setCreated_time(rs.getDate("created_time"));
				des.setAddress(rs.getString("address"));
				des.setExperience(rs.getString("experience"));
				des.setStyle(rs.getString("style"));
				des.setDes(rs.getString("des"));
				des.setStatus(rs.getString("status"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return des;
	}

	@Override
	public List<Designer> queryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Designer queryByEmailPwd(String email, String password) {
		Connection conn = getConn();
		Designer designer = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				designer = new Designer();
				designer.setEmail(email);
				designer.setPassword(password);
				designer.setHeadicon(rs.getString("headicon"));
				designer.setStatus(rs.getString("status"));
				designer.setName(rs.getString("name"));
				designer.setId(rs.getString("id"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designer;
	}

	@Override
	public void update_pwd(Designer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update t_designer set password=? where id = ?");
			ps.setString(1, t.getPassword());
			ps.setString(2, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_status(Designer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_designer set status=? where id = ?");
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
			PreparedStatement ps = conn.prepareStatement("update t_designer set last_login_time = CURRENT_TIMESTAMP where id = ?");
			ps.setString(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
