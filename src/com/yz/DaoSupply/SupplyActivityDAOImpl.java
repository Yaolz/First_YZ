package com.yz.DaoSupply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.SupplyActivity;
import com.yz.common.AbstractBaseDAO;

public class SupplyActivityDAOImpl extends AbstractBaseDAO implements SupplyActivityDAO{

	@Override
	public void add(SupplyActivity t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_supply_activity(id,supply_id,name,image,des) values(uuid(),?,?,?,?)");
			ps.setString(1, t.getSupply_id());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SupplyActivity t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_supply_activity set name=?, image=?, des=? where id=?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getImage());
			ps.setString(3, t.getDes());
			ps.setString(4, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_pwd(SupplyActivity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update_status(SupplyActivity t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_supply_activity set status=? where id = ?");
			ps.setString(1, t.getStatus());
			ps.setString(2, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SupplyActivity> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplyActivity> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<SupplyActivity> supply = new ArrayList<SupplyActivity>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply_activity limit ?,?");
			ps.setInt(1, (pageNo-1)*3);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SupplyActivity sup = new SupplyActivity();
				sup.setId(rs.getString("id"));
				sup.setSupply_id(rs.getString("supply_id"));
				sup.setName(rs.getString("name"));
				sup.setImage(rs.getString("image"));
				sup.setDes(rs.getString("des"));
				supply.add(sup);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supply;
	}

	@Override
	public SupplyActivity queryById(String id) {
		Connection conn = getConn();
		SupplyActivity sup = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply_activity where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sup = new SupplyActivity();
				sup.setId(rs.getString("id"));
				sup.setSupply_id(rs.getString("supply_id"));
				sup.setName(rs.getString("name"));
				sup.setImage(rs.getString("image"));
				sup.setDes(rs.getString("des"));
				sup.setCreated_time(rs.getDate("created_time"));
				sup.setStatus(rs.getString("status"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sup;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_supply_activity");
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
	public List<SupplyActivity> queryBySupplyId(String supplyid) {
		Connection conn = getConn();
		List<SupplyActivity> supply = new ArrayList<SupplyActivity>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply_activity where supply_id=?");
			ps.setString(1, supplyid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SupplyActivity sup = new SupplyActivity();
				sup.setId(rs.getString("id"));
				sup.setSupply_id(rs.getString("supply_id"));
				sup.setName(rs.getString("name"));
				sup.setImage(rs.getString("image"));
				sup.setDes(rs.getString("des"));
				supply.add(sup);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supply;
	}

	@Override
	public List<SupplyActivity> queryByPageSupply(int pageNo, int pageSize, String supplyid) {
		Connection conn = getConn();
		List<SupplyActivity> supply = new ArrayList<SupplyActivity>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply_activity where supply_id=? limit ?,?");
			ps.setString(1, supplyid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SupplyActivity sup = new SupplyActivity();
				sup.setId(rs.getString("id"));
				sup.setSupply_id(rs.getString("supply_id"));
				sup.setName(rs.getString("name"));
				sup.setImage(rs.getString("image"));
				sup.setDes(rs.getString("des"));
				sup.setCreated_time(rs.getDate("created_time"));
				sup.setStatus(rs.getString("status"));
				supply.add(sup);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supply;
	}

}
