package com.yz.DaoCompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.CompanyCase;
import com.yz.common.AbstractBaseDAO;

public class CompanyCaseDAOImpl extends AbstractBaseDAO implements CompanyCaseDAO {

	@Override
	public void add(CompanyCase t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_company_case(id,company_id,name,plot_name,style,des,image_1,image_2,image_3,image_4,image_5) values(uuid(),?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, t.getCompany_id());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPlot_name());
			ps.setString(4, t.getStyle());
			ps.setString(5, t.getDes());
			ps.setString(6, t.getImage_1());
			ps.setString(7, t.getImage_2());
			ps.setString(8, t.getImage_3());
			ps.setString(9, t.getImage_4());
			ps.setString(10, t.getImage_5());
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
	public void update(CompanyCase t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update t_company_case set name=?, plot_name=?, style=?, des=?, image_1=?, image_2=?, image_3=?, image_4=?, image_5=? where id=?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPlot_name());
			ps.setString(3, t.getStyle());
			ps.setString(4, t.getDes());
			ps.setString(5, t.getImage_1());
			ps.setString(6, t.getImage_2());
			ps.setString(7, t.getImage_3());
			ps.setString(8, t.getImage_4());
			ps.setString(9, t.getImage_5());
			ps.setString(10, t.getId());
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_pwd(CompanyCase t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update_status(CompanyCase t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company_case set status=? where id = ?");
			ps.setString(1, t.getStatus());
			ps.setString(2, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CompanyCase> queryAll() {
		Connection conn = getConn();
		List<CompanyCase> coms = new ArrayList<CompanyCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_case");
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
				coms.add(com);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coms;
	}


	@Override
	public CompanyCase queryById(String id) {
		Connection conn = getConn();
		CompanyCase com = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_case where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				com = new CompanyCase();
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
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company_case");
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
	public List<CompanyCase> queryByCompanyId(String companyid) {
		Connection conn = getConn();
		List<CompanyCase> comcase = new ArrayList<CompanyCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_case where company_id = ?");
			ps.setString(1, companyid);
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
				comcase.add(com);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comcase;

	}

	@Override
	public List<CompanyCase> queryByPagerCompany(int pageNo, int pageSize, String companyid) {
		Connection conn = getConn();
		List<CompanyCase> companycase= new ArrayList<CompanyCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_company_case where company_id=? limit ?,?");
			ps.setString(1, companyid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyCase comcase = new CompanyCase();
				comcase.setCompany_id(rs.getString("company_id"));
				comcase.setId(rs.getString("id"));
				comcase.setName(rs.getString("name"));
				comcase.setPlot_name(rs.getString("plot_name"));
				comcase.setStyle(rs.getString("style"));
				comcase.setImage_1(rs.getString("image_1"));
				comcase.setImage_2(rs.getString("image_2"));
				comcase.setImage_3(rs.getString("image_3"));
				comcase.setImage_4(rs.getString("image_4"));
				comcase.setImage_5(rs.getString("image_5"));
				comcase.setStatus(rs.getString("status"));
				companycase.add(comcase);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companycase;
	}

	@Override
	public List<CompanyCase> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<CompanyCase> companycase= new ArrayList<CompanyCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company_case limit ?,?");
			ps.setInt(1, (pageNo-1)*3);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyCase comcase = new CompanyCase();
				comcase.setCompany_id(rs.getString("company_id"));
				comcase.setId(rs.getString("id"));
				comcase.setName(rs.getString("name"));
				comcase.setPlot_name(rs.getString("plot_name"));
				comcase.setStyle(rs.getString("style"));
				comcase.setImage_1(rs.getString("image_1"));
				comcase.setImage_2(rs.getString("image_2"));
				comcase.setImage_3(rs.getString("image_3"));
				comcase.setImage_4(rs.getString("image_4"));
				comcase.setImage_5(rs.getString("image_5"));
				comcase.setStatus(rs.getString("status"));
				companycase.add(comcase);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companycase;
	}

}
