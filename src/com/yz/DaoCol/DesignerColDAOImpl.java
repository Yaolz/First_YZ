package com.yz.DaoCol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Designer;
import com.yz.bean.DesignerCol;
import com.yz.common.AbstractBaseDAO;

public class DesignerColDAOImpl extends AbstractBaseDAO implements DesignerColDAO{

	@Override
	public void add(DesignerCol t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_designer_col(id,customer_id,designer_id) value(uuid(),?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getDesigner_id());
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
			PreparedStatement ps = conn.prepareStatement("delete from t_designer_col where designer_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DesignerCol> queryByCustomerId(String customerid) {
		Connection conn = getConn();
		List<DesignerCol> desi = new ArrayList<DesignerCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer_col where customer_id=?");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DesignerCol c =  new DesignerCol();
				c.setId(rs.getString("id"));
				c.setDesigner_id(rs.getString("designer_id"));
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
	public List<DesignerCol> queryPageByCustomerId(int pageNo, int pageSize,String customerid) {
		Connection conn = getConn();
		List<DesignerCol> company = new ArrayList<DesignerCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer_col where customer_id=? limit ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DesignerCol desi = new DesignerCol();
				desi.setId(rs.getString("id"));
				desi.setDesigner_id(rs.getString("designer_id"));
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
	public DesignerCol queryById(String id) {
		Connection conn=getConn();
		DesignerCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_designer_col where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new DesignerCol();
				desi.setId(rs.getString("id"));
				desi.setDesigner_id(rs.getString("designer_id"));
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
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_designer_col");
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
	public DesignerCol queryBySave(String id, String customerid) {
		Connection conn=getConn();
		DesignerCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_designer_col where designer_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new DesignerCol();
				desi.setId(rs.getString("id"));
				desi.setDesigner_id(rs.getString("designer_id"));
				desi.setCreated_time(rs.getDate("created_time"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return desi;
	}

	@Override
	public List<Designer> queryPage(int pageNo, int pageSize, String customerid) {
		Connection conn=getConn();
		List<Designer> designer = new ArrayList<Designer>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select t_designer.* from t_designer,t_designer_col  where t_designer.id=t_designer_col.designer_id and t_designer_col.customer_id=? LIMIT ?,?; ");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
				designer.add(d);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designer;
	}

}
