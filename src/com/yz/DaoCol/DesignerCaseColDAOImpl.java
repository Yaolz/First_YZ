package com.yz.DaoCol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.DesignerCase;
import com.yz.bean.DesignerCaseCol;
import com.yz.common.AbstractBaseDAO;

public class DesignerCaseColDAOImpl extends AbstractBaseDAO implements DesignerCaseColDAO{

	@Override
	public void add(DesignerCaseCol t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_designer_case_col(id,customer_id,case_id) value(uuid(),?,?)");
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
			PreparedStatement ps = conn.prepareStatement("delete from t_designer_case_col where case_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DesignerCaseCol> queryByCustomerId(String customerid) {
		Connection conn = getConn();
		List<DesignerCaseCol> desi = new ArrayList<DesignerCaseCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer_case_col where customer_id=?");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DesignerCaseCol c =  new DesignerCaseCol();
				c.setId(rs.getString("id"));
				c.setCase_id(rs.getString("case_id"));
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
	public List<DesignerCaseCol> queryPageByCustomerId(int pageNo, int pageSize,String customerid) {
		Connection conn = getConn();
		List<DesignerCaseCol> company = new ArrayList<DesignerCaseCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_designer_case_col customer_id=? limit ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DesignerCaseCol desi = new DesignerCaseCol();
				desi.setId(rs.getString("id"));
				desi.setCase_id(rs.getString("case_id"));
				desi.setCustomer_id(rs.getString("customer_id"));
				desi.setCreated_time(rs.getDate("created_time"));
				company.add(desi);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

	@Override
	public DesignerCaseCol queryById(String id) {
		Connection conn=getConn();
		DesignerCaseCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_designer_case_col where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new DesignerCaseCol();
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
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_designer_case_col");
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
	public DesignerCaseCol queryBySave(String id, String customerid) {
		Connection conn=getConn();
		DesignerCaseCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_designer_case_col where case_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new DesignerCaseCol();
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
	public List<DesignerCase> queryPage(int pageNo, int pageSize, String customerid) {
		Connection conn=getConn();
		List<DesignerCase> designer = new ArrayList<DesignerCase>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select t_designer_case.* from t_designer_case, t_designer_case_col where t_designer_case.id = t_designer_case_col.case_id and t_designer_case_col.customer_id=? LIMIT ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DesignerCase desi = new DesignerCase();
				desi.setId(rs.getString("id"));
				desi.setDesigner_id(rs.getString("designer_id"));
				desi.setName(rs.getString("name"));
				desi.setPlot_name(rs.getString("plot_name"));
				desi.setStyle(rs.getString("style"));
				desi.setDes(rs.getString("des"));
				desi.setImage_1(rs.getString("image_1"));
				desi.setImage_2(rs.getString("image_2"));
				desi.setImage_3(rs.getString("image_3"));
				desi.setImage_4(rs.getString("image_4"));
				desi.setImage_5(rs.getString("image_5"));
				desi.setStatus(rs.getString("status"));
				designer.add(desi);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designer;
	}
	
}
