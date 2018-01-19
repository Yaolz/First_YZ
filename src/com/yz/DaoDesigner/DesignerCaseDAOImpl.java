package com.yz.DaoDesigner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.bean.DesignerCase;
import com.yz.common.AbstractBaseDAO;

public class DesignerCaseDAOImpl extends AbstractBaseDAO implements DesignerCaseDAO{

	@Override
	public void add(DesignerCase t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_designer_case(id,designer_id,name,plot_name,style,des,image_1,image_2,image_3,image_4,image_5) values(uuid(),?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, t.getDesigner_id());
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
			ps.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(DesignerCase t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update t_designer_case set name=?, plot_name=?, style=?, des=?, image_1=?, image_2=?, image_3=?, image_4=?, image_5=? where id=?");
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
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_pwd(DesignerCase t) {
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
	public void update_status(DesignerCase t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_designer_case set status=? where id = ?");
			ps.setString(1, t.getStatus());
			ps.setString(2, t.getId());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DesignerCase> queryAll() {
		Connection conn = getConn();
		List<DesignerCase> descase = new ArrayList<DesignerCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer_case");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DesignerCase com = new DesignerCase();
				com.setId(rs.getString("id"));
				com.setDesigner_id(rs.getString("designer_id"));
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
				descase.add(com);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descase;
	}

	@Override
	public List<DesignerCase> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<DesignerCase> designercase= new ArrayList<DesignerCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_designer_case limit ?,?");
			ps.setInt(1, (pageNo-1)*3);
			ps.setInt(2, pageSize);
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
				designercase.add(desi);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designercase;
	}

	@Override
	public DesignerCase queryById(String id) {
		Connection conn = getConn();
		DesignerCase des = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer_case where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				des = new DesignerCase();
				des.setId(rs.getString("id"));
				des.setDesigner_id(rs.getString("designer_id"));
				des.setName(rs.getString("name"));
				des.setPlot_name(rs.getString("plot_name"));
				des.setStyle(rs.getString("style"));
				des.setDes(rs.getString("des"));
				des.setImage_1(rs.getString("image_1"));
				des.setImage_2(rs.getString("image_2"));
				des.setImage_3(rs.getString("image_3"));
				des.setImage_4(rs.getString("image_4"));
				des.setImage_5(rs.getString("image_5"));
				des.setStatus(rs.getString("status"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return des;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_designer_case");
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
	public List<DesignerCase> queryByDesignerId(String designerid) {
		Connection conn = getConn();
		List<DesignerCase> descase = new ArrayList<DesignerCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer_case where designer_id = ?");
			ps.setString(1, designerid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DesignerCase des = new DesignerCase();
				des.setId(rs.getString("id"));
				des.setDesigner_id(rs.getString("designer_id"));
				des.setName(rs.getString("name"));
				des.setPlot_name(rs.getString("plot_name"));
				des.setStyle(rs.getString("style"));
				des.setDes(rs.getString("des"));
				des.setImage_1(rs.getString("image_1"));
				des.setImage_2(rs.getString("image_2"));
				des.setImage_3(rs.getString("image_3"));
				des.setImage_4(rs.getString("image_4"));
				des.setImage_5(rs.getString("image_5"));
				des.setStatus(rs.getString("status"));
				descase.add(des);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descase;
	}

	@Override
	public List<DesignerCase> queryByPagerDesigner(int pageNo, int pageSize, String designerid) {
		Connection conn = getConn();
		List<DesignerCase> designercase= new ArrayList<DesignerCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select*from t_designer_case where designer_id=? limit ?,?");
			ps.setString(1, designerid);
			ps.setInt(2, (pageNo-1)*3);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DesignerCase descase = new DesignerCase();
				descase.setDesigner_id(rs.getString("designer_id"));
				descase.setId(rs.getString("id"));
				descase.setName(rs.getString("name"));
				descase.setPlot_name(rs.getString("plot_name"));
				descase.setStyle(rs.getString("style"));
				descase.setCreated_time(rs.getDate("created_time"));
				descase.setImage_1(rs.getString("image_1"));
				descase.setImage_2(rs.getString("image_2"));
				descase.setImage_3(rs.getString("image_3"));
				descase.setImage_4(rs.getString("image_4"));
				descase.setImage_5(rs.getString("image_5"));
				descase.setStatus(rs.getString("status"));
				designercase.add(descase);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designercase;
	}

}
