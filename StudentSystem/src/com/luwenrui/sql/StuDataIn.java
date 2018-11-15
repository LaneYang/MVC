package com.luwenrui.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.iotek.jdbc.SqlClose;
import com.iotek.jdbc.SqlConnect;
import com.luwenrui.dao.Student;

public class StuDataIn{

	public TreeMap<Integer,Student> DataOu(){
		TreeMap<Integer,Student> admin = new TreeMap<Integer,Student>();
		
		Connection con = SqlConnect.sqlconnect();
		try {
			Statement smt = con.createStatement();
			String sql = "select * from stu";
			ResultSet rest = smt.executeQuery(sql);
			
			while(rest.next()){
				Student ad = new Student();
				ad.setId(rest.getInt("id"));
				ad.setUsername(rest.getString("username"));
				ad.setPassword(rest.getString("password"));
				ad.setRealName(rest.getString("realName"));
				ad.setClassName(rest.getString("class"));
				ad.setMathScore(rest.getDouble("math"));
				ad.setEnglishScore(rest.getDouble("english"));
				ad.setChineseScore(rest.getDouble("chinese"));
				ad.setIfUpdated(0);
				admin.put(ad.getId(), ad);
			}
			
			SqlClose.sqlclose(smt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return admin;
	}
	public boolean ObjectAdd(Student admin){
		String sql = "insert into stu(id,username,password,realName,class,math,english,chinese) value(?,?,?,?,?,?,?,?);";
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, admin.getId());
			stm.setString(2, admin.getUsername());
			stm.setString(3, admin.getPassword());
			stm.setString(4, admin.getRealName());
			stm.setString(5, admin.getClassName());
			stm.setDouble(6, admin.getMathScore());
			stm.setDouble(7, admin.getEnglishScore());
			stm.setDouble(8,admin.getChineseScore());
			stm.executeUpdate();
			SqlClose.sqlclose(stm, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean ObjectUpdate(Student admin){
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement psrnt = con.prepareStatement("update stu set username=?,password=?,realName=?,class=?,math=?,english=?,chinese=? where id ="+admin.getId()+";");
			psrnt.setString(1, admin.getUsername());
			psrnt.setString(2, admin.getPassword());
			psrnt.setString(3, admin.getRealName());
			psrnt.setString(4, admin.getClassName());
			psrnt.setDouble(5, admin.getMathScore());
			psrnt.setDouble(6, admin.getEnglishScore());
			psrnt.setDouble(7, admin.getChineseScore());
			psrnt.executeUpdate();
			SqlClose.sqlclose(psrnt, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean ObjectRemove(Student admin){
		Connection con = SqlConnect.sqlconnect();
		try {
			PreparedStatement psrnt = con.prepareStatement("delete from stu where id = "+admin.getId()+";");
			psrnt.executeUpdate();
			SqlClose.sqlclose(psrnt, con);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Student DataOut(int id){
		
		Student ad = new Student();
		Connection con = SqlConnect.sqlconnect();
		try {
			Statement smt = con.createStatement();
			String sql = "select * from stu where id="+id+";";
			ResultSet rest = smt.executeQuery(sql);
			
			while(rest.next()){
				ad.setId(rest.getInt("id"));
				ad.setUsername(rest.getString("username"));
				ad.setPassword(rest.getString("password"));
				ad.setRealName(rest.getString("realName"));
				ad.setClassName(rest.getString("class"));
				ad.setMathScore(rest.getDouble("math"));
				ad.setEnglishScore(rest.getDouble("english"));
				ad.setChineseScore(rest.getDouble("chinese"));
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
