package com.iotek.sort;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.iotek.interfacev.SortInterface;
import com.luwenrui.dao.Teacher;
import com.luwenrui.dao.Temp;
import com.luwenrui.sql.TeaDataIn;
import com.luwenrui.zhuanhuan.Zhuanhuan;

public class TeacherSort implements SortInterface{

	public TreeMap<Integer,Temp> idSort(){
		TreeMap<Integer,Temp> temp = new TreeMap<Integer,Temp>();
		TreeMap<Integer,Teacher> stu = new TreeMap<Integer,Teacher>();
		stu =new TeaDataIn().DataOu();
		Set<Map.Entry<Integer, Teacher>> set = stu.entrySet();

		Iterator<Map.Entry<Integer, Teacher>> i = set.iterator();
		Temp p = new Temp();
		while (i.hasNext()) {
			Map.Entry<Integer, Teacher> me = i.next();
			p = Zhuanhuan.TetoT(me.getValue());
			temp.put(p.getId(), p);

		}
		return temp;
	}
	
	public TreeMap<String,Temp> realNameSort(){
		TreeMap<String,Temp> temp = new TreeMap<String,Temp>();
		TreeMap<Integer,Teacher> stu = new TreeMap<Integer,Teacher>();
		stu = new TeaDataIn().DataOu();
		Set<Map.Entry<Integer, Teacher>> set = stu.entrySet();

		Iterator<Map.Entry<Integer, Teacher>> i = set.iterator();
		Temp p = new Temp();
		while (i.hasNext()) {
			Map.Entry<Integer, Teacher> me = i.next();
			p = Zhuanhuan.TetoT(me.getValue());
			temp.put(p.getString1()+p.getId(), p);

		}
		return temp;
	}
	
	public TreeMap<String,Temp> classSort(){
		TreeMap<String,Temp> temp = new TreeMap<String,Temp>();
		TreeMap<Integer,Teacher> stu = new TreeMap<Integer,Teacher>();
		stu = new TeaDataIn().DataOu();
		Set<Map.Entry<Integer, Teacher>> set = stu.entrySet();

		Iterator<Map.Entry<Integer, Teacher>> i = set.iterator();
		Temp p = new Temp();
		while (i.hasNext()) {
			Map.Entry<Integer, Teacher> me = i.next();
			p = Zhuanhuan.TetoT(me.getValue());
			temp.put(p.getString2()+p.getId(), p);

		}
		return temp;
	}
}
