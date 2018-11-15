package com.luwenrui.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.iotek.jdbc.SqlClose;
import com.iotek.jdbc.SqlConnect;
import com.luwenrui.dao.Teacher;

public class TeaDataIn {

	public TreeMap<Integer,Teacher> DataOu(){
		TreeMap<Integer,Teacher> admin = new TreeMap<Integer,Teacher>();
		
		Connection con = SqlConnect.sqlconnect();
		try {
			Statement smt = con.createStatement();
			String sql = "select * from tea";
			ResultSet rest = smt.executeQuery(sql);
			
			while(rest.next()){
				Teacher ad = new Teacher();
				ad.setId(rest.getInt("id"));
				ad.setUsername(rest.getString("username"));
				ad.setPassword(rest.getString("password"));
				ad.setRealName(rest.getString("realname"));
				ad.setClassName(rest.getString("class"));
				ad.setSalary(rest.getDouble("salary"));
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
	public boolean ObjectAdd(Teacher admin){
		String sql = "insert into tea(id,username,password,realname,class,salary) value(?,?,?,?,?,?);";
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, admin.getId());
			stm.setString(2, admin.getUsername());
			stm.setString(3, admin.getPassword());
			stm.setString(4,admin.getRealName());
			stm.setString(5, admin.getClassName());
			stm.setDouble(6, admin.getSalary());
			stm.executeUpdate();
			SqlClose.sqlclose(stm, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean ObjectUpdate(Teacher admin){
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement psrnt = con.prepareStatement("update tea set username=?,password=?,realname=?,class=?,salary=? where id ="+admin.getId()+";");
			psrnt.setString(1, admin.getUsername());
			psrnt.setString(2, admin.getPassword());
			psrnt.setString(3, admin.getRealName());
			psrnt.setString(4, admin.getClassName());
			psrnt.setDouble(5, admin.getSalary());
			psrnt.executeUpdate();
			SqlClose.sqlclose(psrnt, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean ObjectRemove(Teacher admin){
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement psrnt = con.prepareStatement("delete from tea where id = "+admin.getId()+";");
			psrnt.executeUpdate();
			SqlClose.sqlclose(psrnt, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Teacher DataOut(int id){
		Teacher ad = new Teacher();
		Connection con = SqlConnect.sqlconnect();
		try {
			Statement smt = con.createStatement();
			String sql = "select * from tea where id="+id+";";
			ResultSet rest = smt.executeQuery(sql);
			
		
			while (rest.next()){
				ad.setId(rest.getInt("id"));
				ad.setUsername(rest.getString("username"));
				ad.setPassword(rest.getString("password"));
				ad.setRealName(rest.getString("realname"));
				ad.setClassName(rest.getString("class"));
				ad.setSalary(rest.getDouble("salary"));
				ad.setIfUpdated(0);
			}
			
			SqlClose.sqlclose(smt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ad;
	}
}
