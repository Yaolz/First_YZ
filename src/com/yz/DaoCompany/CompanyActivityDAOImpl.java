package com.yz.DaoCompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.CompanyActivity;
import com.yz.common.AbstractBaseDAO;

public class CompanyActivityDAOImpl extends AbstractBaseDAO implements CompanyActivityDAO{

	@Override
	public void add(CompanyActivity t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_activity(id,company_id,name,image,des) values(uuid(),?,?,?,?)");
			ps.setString(1, t.getCompany_id());
			ps.setString(2, t.getName());
			ps.setString(3, t.getImage());
			ps.setString(4, t.getDes());
			ps.executeUpdate();
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
	public void update(CompanyActivity t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company_activity set name=?, image=?, des=?, image=? where id=?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getImage());
			ps.setString(3, t.getDes());
			ps.setString(4, t.getImage());
			ps.setString(5, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_pwd(CompanyActivity t) {
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
	public void update_status(CompanyActivity t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company_activity set status=? where id = ?");
			ps.setString(1, t.getStatus());
			ps.setString(2, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CompanyActivity> queryAll() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_activity");
			ps.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CompanyActivity> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<CompanyActivity> company = new ArrayList<CompanyActivity>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_activity limit ?,?");
			ps.setInt(1, (pageNo-1)*3);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyActivity com = new CompanyActivity();
				com.setId(rs.getString("id"));
				com.setCompany_id(rs.getString("company_id"));
				com.setName(rs.getString("name"));
				com.setImage(rs.getString("image"));
				com.setDes(rs.getString("des"));
				company.add(com);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public CompanyActivity queryById(String id) {
		Connection conn = getConn();
		CompanyActivity com = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_activity where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				com = new CompanyActivity();
				com.setId(rs.getString("id"));
				com.setCompany_id(rs.getString("company_id"));
				com.setName(rs.getString("name"));
				com.setDes(rs.getString("des"));
				com.setImage(rs.getString("image"));
				com.setCreated_time(rs.getDate("created_time"));
				com.setStatus(rs.getString("status"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return com;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company_activity");
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
	public List<CompanyActivity> queryByCompanyId(String companyid) {
		Connection conn = getConn();
		List<CompanyActivity> company = new ArrayList<CompanyActivity>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_activity where company_id=?");
			ps.setString(1, companyid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyActivity com = new CompanyActivity();
				com.setId(rs.getString("id"));
				com.setCompany_id(rs.getString("company_id"));
				com.setName(rs.getString("name"));
				com.setImage(rs.getString("image"));
				com.setDes(rs.getString("des"));
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
	public List<CompanyActivity> queryPageByCompanyId(int pageNo, int pageSize, String companyid) {
		Connection conn = getConn();
		List<CompanyActivity> company = new ArrayList<CompanyActivity>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_activity where company_id=? limit ?,?");
			ps.setString(1,companyid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyActivity com = new CompanyActivity();
				com.setId(rs.getString("id"));
				com.setCompany_id(rs.getString("company_id"));
				com.setName(rs.getString("name"));
				com.setImage(rs.getString("image"));
				com.setDes(rs.getString("des"));
				com.setStatus(rs.getString("status"));
				company.add(com);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

}
