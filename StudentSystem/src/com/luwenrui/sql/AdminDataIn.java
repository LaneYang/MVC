package com.luwenrui.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.iotek.jdbc.SqlClose;
import com.iotek.jdbc.SqlConnect;
import com.luwenrui.dao.Admin;

public class AdminDataIn{

	public TreeMap<Integer,Admin> DataOu(){
		TreeMap<Integer,Admin> admin = new TreeMap<Integer,Admin>();
		
		Connection con = SqlConnect.sqlconnect();
		try {
			Statement smt = con.createStatement();
			String sql = "select * from admin";
			ResultSet rest = smt.executeQuery(sql);
			
			while(rest.next()){
				Admin ad = new Admin();
				ad.setId(rest.getInt("id"));
				ad.setZhantype(rest.getInt("type"));
				ad.setUsername(rest.getString("username"));
				ad.setPassword(rest.getString("password"));
				ad.setIfUpdate(0);
				admin.put(ad.getId(), ad);
			}
			
			SqlClose.sqlclose(smt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return admin;
	}
	public boolean ObjectAdd(Admin admin){
		String sql = "insert into admin(id,type,username,password) value(?,?,?,?);";
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, admin.getId());
			stm.setInt(2, admin.getZhantype());
			stm.setString(3, admin.getUsername());
			stm.setString(4, admin.getPassword());
			stm.executeUpdate();
			SqlClose.sqlclose(stm, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean ObjectUpdate(Admin admin){
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement psrnt = con.prepareStatement("update admin set type=?,username=?,password=? where id ="+admin.getId()+";");
			psrnt.setInt(1, admin.getZhantype());
			psrnt.setString(2, admin.getUsername());
			psrnt.setString(3, admin.getPassword());
			psrnt.executeUpdate();
			SqlClose.sqlclose(psrnt, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean ObjectRemove(Admin admin){
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement psrnt = con.prepareStatement("delete from admin where id = "+admin.getId()+";");
			psrnt.executeUpdate();
			SqlClose.sqlclose(psrnt, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
