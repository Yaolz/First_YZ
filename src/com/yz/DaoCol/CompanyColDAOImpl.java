package com.yz.DaoCol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Company;
import com.yz.bean.CompanyCol;
import com.yz.common.AbstractBaseDAO;

public class CompanyColDAOImpl extends AbstractBaseDAO implements CompanyColDAO{

	@Override
	public void add(CompanyCol t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_col(id,customer_id,company_id) value(uuid(),?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getCompany_id());
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
			PreparedStatement ps = conn.prepareStatement("delete from t_company_col where company_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CompanyCol> queryByCustomerId(String customerid) {
		Connection conn = getConn();
		List<CompanyCol> comcol = new ArrayList<CompanyCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_col where customer_id");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CompanyCol c =  new CompanyCol();
				c.setId(rs.getString("id"));
				c.setCompany_id(rs.getString("company_id"));
				c.setCustomer_id(rs.getString("customer_id"));
				c.setCreated_time(rs.getDate("created_time"));
				comcol.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comcol;
	}

	@Override
	public List<CompanyCol> queryPageByCustomerId(int pageNo, int pageSize,String customerid) {
		Connection conn = getConn();
		List<CompanyCol> comcol = new ArrayList<CompanyCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_company_col where customer_id=? limit ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyCol comc = new CompanyCol();
				comc.setId(rs.getString("id"));
				comc.setCompany_id(rs.getString("company_id"));
				comc.setCustomer_id(rs.getString("customer_id"));
				comc.setCreated_time(rs.getDate("created_time"));
				comcol.add(comc);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comcol;
	}

	@Override
	public CompanyCol queryById(String id) {
		Connection conn=getConn();
		CompanyCol comc=null;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM t_company_col where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				comc = new CompanyCol();
				comc.setId(rs.getString("id"));
				comc.setCompany_id(rs.getString("company_id"));
				comc.setCustomer_id(rs.getString("customer_id"));
				comc.setCreated_time(rs.getDate("created_time"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comc;
	}

	@Override
	public int count() {
		
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company_col");
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
	public CompanyCol queryBySave(String id, String customerid) {
		Connection conn=getConn();
		CompanyCol comc=null;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM t_company_col where company_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				comc = new CompanyCol();
				comc.setId(rs.getString("id"));
				comc.setCompany_id(rs.getString("company_id"));
				comc.setCustomer_id(rs.getString("customer_id"));
				comc.setCreated_time(rs.getDate("created_time"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comc;
	}

	@Override
	public List<Company> queryPage(int pageNo, int pageSize, String customerid) {
		Connection conn = getConn();
		List<Company> company = new ArrayList<Company>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select t_company.* from t_company, t_company_col where t_company.id = t_company_col.company_id and t_company_col.customer_id=? LIMIT ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
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
				company.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

}
