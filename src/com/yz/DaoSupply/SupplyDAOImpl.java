package com.yz.DaoSupply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Supply;
import com.yz.common.AbstractBaseDAO;
import com.yz.common.DateUtil;

public class SupplyDAOImpl extends AbstractBaseDAO implements SupplyDAO  {

	@Override
	public void add(Supply t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_supply(id, email, password, name, principal,address,phone,tel,open_date) values(uuid(), ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getName());
			ps.setString(4, t.getPrincipal());
			ps.setString(5, t.getAddress());
			ps.setString(6, t.getPhone());
			ps.setString(7, t.getTel());
			ps.setDate(8, DateUtil.convert(t.getOpen_date()));
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Supply t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update t_supply set name=?, phone=?, principal=?, address=?, tel=?, open_date=?,longitude=?,latitude=?,des=? where id = ?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getPrincipal());
			ps.setString(4, t.getAddress());
			ps.setString(5, t.getTel());
			ps.setDate(6, DateUtil.convert(t.getOpen_date()));
			ps.setFloat(7, t.getLongitude());
			ps.setFloat(8, t.getLatitude());
			ps.setString(9, t.getDes());
			ps.setString(10, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Supply> queryAll() {
		Connection conn = getConn();
		List<Supply> sup = new ArrayList<Supply>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Supply c =  new Supply();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setPrincipal(rs.getString("principal"));
				c.setLogo(rs.getString("logo"));
				c.setAddress(rs.getString("address"));
				c.setPhone(rs.getString("phone"));
				c.setTel(rs.getString("tel"));
				c.setOpen_date(rs.getDate("open_date"));
				c.setLongitude(rs.getFloat("longitude"));
				c.setLatitude(rs.getFloat("latitude"));
				c.setDes(rs.getString("des"));
				c.setStatus(rs.getString("status"));
				sup.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sup;
	}

	@Override
	public List<Supply> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Supply> supply= new ArrayList<Supply>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_supply limit ?,?");
			ps.setInt(1, (pageNo-1)*3);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Supply sup = new Supply();
				sup.setId(rs.getString("id"));
				sup.setName(rs.getString("name"));
				sup.setEmail(rs.getString("email"));
				sup.setAddress(rs.getString("address"));
				sup.setPhone(rs.getString("phone"));
				sup.setLogo(rs.getString("logo"));
				sup.setTel(rs.getString("tel"));
				sup.setPrincipal(rs.getString("principal"));
				sup.setStatus(rs.getString("status"));
				supply.add(sup);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supply;
	}
	

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_supply");
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
	public Supply queryById(String id) {
		Connection conn = getConn();
		Supply sup = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sup = new Supply();
				sup.setId(rs.getString("id"));
				sup.setPassword(rs.getString("password"));
				sup.setName(rs.getString("name"));
				sup.setEmail(rs.getString("email"));
				sup.setPhone(rs.getString("phone"));
				sup.setPrincipal(rs.getString("principal"));
				sup.setLogo(rs.getString("logo"));
				sup.setAddress(rs.getString("address"));
				sup.setPhone(rs.getString("phone"));
				sup.setTel(rs.getString("tel"));
				sup.setOpen_date(rs.getDate("open_date"));
				sup.setLongitude(rs.getFloat("longitude"));
				sup.setLatitude(rs.getFloat("latitude"));
				sup.setChecked(rs.getString("checked"));
				sup.setChecked_time(rs.getDate("checked_time"));
				sup.setCreated_time(rs.getDate("created_time"));
				sup.setDes(rs.getString("des"));
				sup.setStatus(rs.getString("status"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sup;
	}

	@Override
	public List<Supply> queryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supply queryByEmailPwd(String email, String password) {
		Connection conn = getConn();
		Supply supply = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				supply = new Supply();
				supply.setEmail(email);
				supply.setPassword(password);
				supply.setLogo(rs.getString("logo"));
				supply.setStatus(rs.getString("status"));
				supply.setName(rs.getString("name"));
				supply.setId(rs.getString("id"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supply;
	}

	@Override
	public void update_pwd(Supply t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update t_supply set password=? where id = ?");
			ps.setString(1, t.getPassword());
			ps.setString(2, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_status(Supply t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_supply set status=? where id = ?");
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
			PreparedStatement ps = conn.prepareStatement("update t_supply set last_login_time = CURRENT_TIMESTAMP where id = ?");
			ps.setString(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
