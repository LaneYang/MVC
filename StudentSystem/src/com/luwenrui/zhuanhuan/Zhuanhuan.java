package com.luwenrui.zhuanhuan;

import com.luwenrui.dao.Admin;
import com.luwenrui.dao.Student;
import com.luwenrui.dao.Teacher;
import com.luwenrui.dao.Temp;

public class Zhuanhuan {

	public static Admin TtoA(Temp temp){
		Admin ad = new Admin();
		ad.setId(temp.getId());
		ad.setUsername(temp.getUsername());
		ad.setPassword(temp.getPassword());
		ad.setIfUpdate(temp.getIfUpdated());
		ad.setZhantype(temp.getType());
		return ad;
	}
	
	public static Temp AtoT(Admin admin){
		Temp tp = new Temp();
		tp.setId(admin.getId());
		tp.setUsername(admin.getUsername());
		tp.setPassword(admin.getPassword());
		tp.setIfUpdated(admin.getIfUpdated());
		tp.setType(admin.getZhantype());
		return tp;
	}
	
	public static Student TtoS(Temp temp){
		Student s = new Student();
		s.setId(temp.getId());
		s.setUsername(temp.getUsername());
		s.setPassword(temp.getPassword());
		s.setRealName(temp.getString1());
		s.setClassName(temp.getString2());
		s.setMathScore(Double.parseDouble(temp.getString3()));
		s.setEnglishScore(Double.parseDouble(temp.getString4()));
		s.setChineseScore(Double.parseDouble(temp.getString5()));
		s.setIfUpdate(temp.getIfUpdated());
		return s;
	}
	
	public static Temp StoT(Student s){
		Temp tp = new Temp();
		tp.setId(s.getId());
		tp.setType(s.getType());
		tp.setUsername(s.getUsername());
		tp.setPassword(s.getPassword());
		tp.setString1(s.getRealName());
		tp.setString2(s.getClassName());
		tp.setString3(s.getMathScore()+"");
		tp.setString4(s.getEnglishScore()+"");
		tp.setString5(s.getChineseScore()+"");
		tp.setIfUpdated(s.getIfUpdated());
		return tp;
	}
	
	public static Teacher TtoTe(Temp t){
		Teacher tea = new Teacher();
		tea.setId(t.getId());
		tea.setUsername(t.getUsername());
		tea.setPassword(t.getPassword());
		tea.setRealName(t.getString1());
		tea.setClassName(t.getString2());
		tea.setSalary(Double.parseDouble(t.getString3()));
		tea.setIfUpdated(t.getIfUpdated());
		return tea;
	}
	
	public static Temp TetoT(Teacher t){
		Temp tp = new Temp();
		tp.setId(t.getId());
		tp.setType(t.getType());
		tp.setUsername(t.getUsername());
		tp.setPassword(t.getPassword());
		tp.setString1(t.getRealName());
		tp.setString2(t.getClassName());
		tp.setString3(t.getSalary()+"");
		tp.setIfUpdated(t.getIfUpdated());
		return tp;
	}
}
