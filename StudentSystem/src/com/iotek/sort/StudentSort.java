package com.iotek.sort;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.iotek.interfacev.SortInterface;
import com.luwenrui.dao.Student;
import com.luwenrui.dao.Temp;
import com.luwenrui.sql.StuDataIn;
import com.luwenrui.staticType.StaticType;
import com.luwenrui.zhuanhuan.Zhuanhuan;

public class StudentSort implements SortInterface {

	@Override
	public TreeMap<Integer, Temp> idSort() {
		TreeMap<Integer, Temp> temp = new TreeMap<Integer, Temp>();
		TreeMap<Integer, Student> stu = new TreeMap<Integer, Student>();
		stu = new StuDataIn().DataOu();
		Set<Map.Entry<Integer, Student>> set = stu.entrySet();

		Iterator<Map.Entry<Integer, Student>> i = set.iterator();
		Temp p = new Temp();
		while (i.hasNext()) {
			Map.Entry<Integer, Student> me = i.next();
			if (StaticType.getLoginInfo().getString2()
					.equals(me.getValue().getClassName())||me.getValue().getClassName().equals(null)) {
				p = Zhuanhuan.StoT(me.getValue());
				temp.put(p.getId(), p);
			}
		}
		
		return temp;
	}

	@Override
	public TreeMap<String, Temp> realNameSort() {
		TreeMap<String, Temp> temp = new TreeMap<String, Temp>();
		TreeMap<Integer, Student> stu = new TreeMap<Integer, Student>();
		stu = new StuDataIn().DataOu();
		Set<Map.Entry<Integer, Student>> set = stu.entrySet();

		Iterator<Map.Entry<Integer, Student>> i = set.iterator();
		Temp p = new Temp();
		while (i.hasNext()) {
			Map.Entry<Integer, Student> me = i.next();
			if (StaticType.getLoginInfo().getString2()
					.equals(me.getValue().getClassName())) {
				p = Zhuanhuan.StoT(me.getValue());
				temp.put(p.getString1()+p.getId(), p);
			}

		}
		return temp;
	}

	@Override
	public TreeMap<String, Temp> classSort() {
		TreeMap<String, Temp> temp = new TreeMap<String, Temp>();
		TreeMap<Integer, Student> stu = new TreeMap<Integer, Student>();
		stu = new StuDataIn().DataOu();
		Set<Map.Entry<Integer, Student>> set = stu.entrySet();

		Iterator<Map.Entry<Integer, Student>> i = set.iterator();
		Temp p = new Temp();
		while (i.hasNext()) {
			Map.Entry<Integer, Student> me = i.next();
			if (StaticType.getLoginInfo().getString2()
					.equals(me.getValue().getClassName())) {
				p = Zhuanhuan.StoT(me.getValue());
				temp.put(p.getString2()+p.getId(), p);
			}

		}
		return temp;
	}
	
	
	public TreeMap<String, Temp> scoreSort() {
		TreeMap<String, Temp> temp = new TreeMap<String, Temp>();
		TreeMap<Integer, Student> stu = new TreeMap<Integer, Student>();
		stu = new StuDataIn().DataOu();
		Set<Map.Entry<Integer, Student>> set = stu.entrySet();

		Iterator<Map.Entry<Integer, Student>> i = set.iterator();
		Temp p = new Temp();
		while (i.hasNext()) {
			Map.Entry<Integer, Student> me = i.next();
			if (StaticType.getLoginInfo().getString2()
					.equals(me.getValue().getClassName())) {
				p = Zhuanhuan.StoT(me.getValue());
				double b = Double.parseDouble(p.getString3())+Double.parseDouble(p.getString4())+Double.parseDouble(p.getString5());
				temp.put(b+"", p);
			}

		}
		return temp;
	}
}
