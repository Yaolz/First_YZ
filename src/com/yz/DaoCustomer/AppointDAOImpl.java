package com.yz.DaoCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.Appointment;
import com.yz.common.AbstractBaseDAO;

public class AppointDAOImpl extends AbstractBaseDAO implements AppointDAO  {

	@Override
	public void add(Appointment t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_appointment(id, user_id, company_id, name, phone, plot_name, area,way, budget, app_name) values(uuid(), ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, t.getUser_id());
			ps.setString(2, t.getCompany_id());
			ps.setString(3, t.getName());
			ps.setString(4, t.getPhone());
			ps.setString(5, t.getPlot_name());
			ps.setFloat(6, t.getArea());
			ps.setString(7, t.getWay());
			ps.setString(8, t.getBudget());
			ps.setString(9, t.getApp_name());
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
			PreparedStatement ps = conn.prepareStatement("delete from t_appointment where id = ?");
			ps.setString(1, id);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Appointment t) {
		
	}

	@Override
	public void update_pwd(Appointment t) {}

	@Override
	public void update_status(Appointment t) {}

	@Override
	public List<Appointment> queryAll() {
		return null;
	}

	@Override
	public List<Appointment> queryByPager(int pageNo, int pageSize) {
		return null;
	}

	@Override
	public Appointment queryById(String id) {
		return null;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_appointment");
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
	public List<Appointment> queryPagerByUserId(int pageNo, int pageSize, String customerid) {
		Connection conn = getConn();
		List<Appointment> appointment = new ArrayList<Appointment>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_appointment where user_id=? limit ?,?");
			ps.setString(1, customerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Appointment app = new Appointment();
				app.setId(rs.getString("id"));
				app.setUser_id(rs.getString("user_id"));
				app.setCompany_id(rs.getString("company_id"));
				app.setName(rs.getString("name"));
				app.setPhone(rs.getString("phone"));
				app.setPlot_name(rs.getString("plot_name"));
				app.setArea(rs.getFloat("area"));
				app.setBudget(rs.getString("budget"));
				app.setWay(rs.getString("way"));
				app.setCreated_time(rs.getDate("created_time"));
				app.setApp_name(rs.getString("app_name"));
				appointment.add(app);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointment;
	}

	@Override
	public List<Appointment> queryPagerByCompany(int pageNo, int pageSize, String companyid) {
		Connection conn = getConn();
		List<Appointment> appointment = new ArrayList<Appointment>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_appointment where company_id=? limit ?,?");
			ps.setString(1, companyid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Appointment app = new Appointment();
				app.setId(rs.getString("id"));
				app.setUser_id(rs.getString("user_id"));
				app.setCompany_id(rs.getString("company_id"));
				app.setName(rs.getString("name"));
				app.setPhone(rs.getString("phone"));
				app.setPlot_name(rs.getString("plot_name"));
				app.setArea(rs.getFloat("area"));
				app.setBudget(rs.getString("budget"));
				app.setWay(rs.getString("way"));
				app.setCreated_time(rs.getDate("created_time"));
				app.setApp_name(rs.getString("app_name"));
				appointment.add(app);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointment;
	}

	@Override
	public Appointment queryApped(String cusid, String companyid) {
		Connection conn = getConn();
		Appointment appointment = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_appointment where user_id=? and company_id=?");
			ps.setString(1, cusid);
			ps.setString(2, companyid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				appointment =  new Appointment();
				appointment.setId(rs.getString("id"));
				appointment.setUser_id(rs.getString("user_id"));
				appointment.setCompany_id(rs.getString("company_id"));
				appointment.setName(rs.getString("name"));
				appointment.setPhone(rs.getString("phone"));
				appointment.setPlot_name(rs.getString("plot_name"));
				appointment.setArea(rs.getFloat("area"));
				appointment.setBudget(rs.getString("budget"));
				appointment.setWay(rs.getString("way"));
				appointment.setCreated_time(rs.getDate("created_time"));
				appointment.setApp_name(rs.getString("app_name"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		return appointment;
	}

}
