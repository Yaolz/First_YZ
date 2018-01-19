package com.yz.DaoCol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.CompanyCase;
import com.yz.bean.CompanyCaseCol;
import com.yz.common.AbstractBaseDAO;

public class CompanyCaseColDAOImpl extends AbstractBaseDAO implements CompanyCaseColDAO{

	@Override
	public void add(CompanyCaseCol t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_case_col(id,customer_id,case_id) value(uuid(),?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getCase_id());
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
			PreparedStatement ps = conn.prepareStatement("delete from t_company_case_col where case_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CompanyCaseCol> queryByCustomerId(String customerid) {
		Connection conn = getConn();
		List<CompanyCaseCol> company = new ArrayList<CompanyCaseCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_case_col where customer_id=?");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CompanyCaseCol c =  new CompanyCaseCol();
				c.setId(rs.getString("id"));
				c.setCase_id(rs.getString("case_id"));
				c.setCustomer_id(rs.getString("customer_id"));
				c.setCreated_time(rs.getDate("created_time"));
				company.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public List<CompanyCaseCol> queryPageByCustomerId(int pageNo, int pageSize,String customerid) {
		Connection conn = getConn();
		List<CompanyCaseCol> company = new ArrayList<CompanyCaseCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_company_case_col customer_id=? limit ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyCaseCol com = new CompanyCaseCol();
				com.setId(rs.getString("id"));
				com.setCase_id(rs.getString("case_id"));
				com.setCustomer_id(rs.getString("customer_id"));
				com.setCreated_time(rs.getDate("created_time"));
				company.add(com);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public CompanyCaseCol queryById(String id) {
		Connection conn=getConn();
		CompanyCaseCol company = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_company_case_col where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				company = new CompanyCaseCol();
				company.setId(rs.getString("id"));
				company.setCase_id(rs.getString("case_id"));
				company.setCustomer_id(rs.getString("customer_id"));
				company.setCreated_time(rs.getDate("created_time"));
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
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company_case_col");
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
	public CompanyCaseCol queryBySave(String id, String customerid) {
		Connection conn=getConn();
		CompanyCaseCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_company_case_col where case_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new CompanyCaseCol();
				desi.setId(rs.getString("id"));
				desi.setCase_id(rs.getString("case_id"));
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
	public List<CompanyCase> queryPage(int pageNo, int pageSize, String customerid) {
		Connection conn = getConn();
		List<CompanyCase> company = new ArrayList<CompanyCase>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select t_company_case.* from t_company_case, t_company_case_col where t_company_case.id = t_company_case_col.case_id and t_company_case_col.customer_id=? LIMIT ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyCase com = new CompanyCase();
				com.setId(rs.getString("id"));
				com.setCompany_id(rs.getString("company_id"));
				com.setName(rs.getString("name"));
				com.setPlot_name(rs.getString("plot_name"));
				com.setStyle(rs.getString("style"));
				com.setDes(rs.getString("des"));
				com.setImage_1(rs.getString("image_1"));
				com.setImage_2(rs.getString("image_2"));
				com.setImage_3(rs.getString("image_3"));
				com.setImage_4(rs.getString("image_4"));
				com.setImage_5(rs.getString("image_5"));
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
