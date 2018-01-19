package com.yz.DaoCompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Company;
import com.yz.common.AbstractBaseDAO;
import com.yz.common.DateUtil;

public class CompanyDAOImpl extends AbstractBaseDAO implements CompanyDAO {

	@Override
	public void add(Company t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_company(id, email, password, name, principal,address,phone,tel,open_date) values(uuid(), ?, ?, ?, ?, ?, ?, ?, ?)");
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
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("");
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Company t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update t_company set name=?, phone=?, principal=?, address=?, tel=?, open_date=?, longitude=?, latitude=?, des=? where id = ?");
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
	public List<Company> queryAll() {
		Connection conn = getConn();
		List<Company> cus = new ArrayList<Company>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Company c =  new Company();
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
				cus.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public List<Company> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Company> company= new ArrayList<Company>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_company limit ?,?");
			ps.setInt(1, (pageNo-1)*3);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Company com = new Company();
				com.setId(rs.getString("id"));
				com.setName(rs.getString("name"));
				com.setEmail(rs.getString("email"));
				com.setPhone(rs.getString("phone"));
				com.setAddress(rs.getString("address"));
				com.setLogo(rs.getString("logo"));
				com.setTel(rs.getString("tel"));
				com.setPrincipal(rs.getString("principal"));
				com.setStatus(rs.getString("status"));
				company.add(com);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}
	

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company");
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
	public Company queryById(String id) {
		Connection conn = getConn();
		Company c = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c = new Company();
				c.setId(rs.getString("id"));
				c.setPassword(rs.getString("password"));
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
				c.setChecked(rs.getString("checked"));
				c.setCreated_time(rs.getDate("created_time"));
				c.setChecked_time(rs.getDate("checked_time"));
				c.setDes(rs.getString("des"));
				c.setStatus(rs.getString("status"));
				c.setLast_login_time(rs.getDate("last_login_time"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Company> queryByName(String name) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company where id = ?");
			ps.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Company queryByEmailPwd(String email, String password) {
		Connection conn = getConn();
		Company company = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				company = new Company();
				company.setEmail(email);
				company.setPassword(password);
				company.setLogo(rs.getString("logo"));
				company.setStatus(rs.getString("status"));
				company.setName(rs.getString("name"));
				company.setPhone(rs.getString("phone"));
				company.setId(rs.getString("id"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public void update_pwd(Company t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update  t_company set password=? where id = ?");
			ps.setString(1, t.getPassword());
			ps.setString(2, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_status(Company t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company set status=? where id = ?");
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
			PreparedStatement ps = conn.prepareStatement("update t_company set last_login_time = CURRENT_TIMESTAMP where id = ?");
			ps.setString(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	



}
