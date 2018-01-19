package com.yz.DaoCol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Supply;
import com.yz.bean.SupplyCol;
import com.yz.common.AbstractBaseDAO;

public class SupplyColDAOImpl extends AbstractBaseDAO implements SupplyColDAO{

	@Override
	public void add(SupplyCol t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_supply_col(id,customer_id,supply_id) value(uuid(),?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getSupply_id());
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
			PreparedStatement ps = conn.prepareStatement("delete from t_supply_col where supply_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SupplyCol> queryByCustomerId(String customerid) {
		Connection conn = getConn();
		List<SupplyCol> desi = new ArrayList<SupplyCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply_col where customer_id=?");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SupplyCol c =  new SupplyCol();
				c.setId(rs.getString("id"));
				c.setSupply_id(rs.getString("supply_id"));
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
	public List<SupplyCol> queryPageByCustomerId(int pageNo, int pageSize,String customerid) {
		Connection conn = getConn();
		List<SupplyCol> company = new ArrayList<SupplyCol>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_supply_col where customer_id=? limit ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SupplyCol desi = new SupplyCol();
				desi.setId(rs.getString("id"));
				desi.setSupply_id(rs.getString("supply_id"));
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
	public SupplyCol queryById(String id) {
		Connection conn=getConn();
		SupplyCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_supply_col where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new SupplyCol();
				desi.setId(rs.getString("id"));
				desi.setSupply_id(rs.getString("supply_id"));
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
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_supply_col");
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
	public SupplyCol queryBySave(String id, String customerid) {
		Connection conn=getConn();
		SupplyCol desi = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from t_supply_col where supply_id = ? and customer_id=?");
			ps.setString(1, id);
			ps.setString(2, customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				desi = new SupplyCol();
				desi.setId(rs.getString("id"));
				desi.setSupply_id(rs.getString("supply_id"));
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
	public List<Supply> queryPage(int pageNo, int pageSize, String customerid) {
		Connection conn = getConn();
		List<Supply> supply = new ArrayList<Supply>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select t_supply.* from t_supply, t_supply_col where t_supply.id = t_supply_col.supply_id and t_supply_col.customer_id=? LIMIT ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Supply s =  new Supply();
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getString("phone"));
				s.setPrincipal(rs.getString("principal"));
				s.setLogo(rs.getString("logo"));
				s.setAddress(rs.getString("address"));
				s.setPhone(rs.getString("phone"));
				s.setTel(rs.getString("tel"));
				s.setOpen_date(rs.getDate("open_date"));
				s.setLongitude(rs.getFloat("longitude"));
				s.setLatitude(rs.getFloat("latitude"));
				s.setDes(rs.getString("des"));
				s.setStatus(rs.getString("status"));
				supply.add(s);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supply;
	}

}
