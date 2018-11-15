package com.iotek.cont;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.iotek.interfacev.ShowAll;
import com.iotek.sort.StudentSort;
import com.luwenrui.dao.Temp;

public class TeacherAll implements ShowAll {

	@Override
	public String showS(int i) {
		// TODO Auto-generated method stub
		String stri = null;
		switch(i){
		case 1:
			stri =  this.idS();
			break;
		case 2:
			stri =  this.nameS();
			break;
		case 3:
			stri =  this.clS();
			break;
		case 4:
			stri = this.scS();
			break;
		}
		
		return stri;
	}
	
	public String idS(){
		String string = new String("学号\t真实姓名\t班级\t数学\t英语\t语文\n");
		TreeMap<Integer,Temp> treemap = new StudentSort().idSort();
		Set<Map.Entry<Integer, Temp>> set = treemap.entrySet();

		Iterator<Map.Entry<Integer, Temp>> newi = set.iterator();

		while (newi.hasNext()) {
			Map.Entry<Integer, Temp> me = newi.next();
			string = string + me.getValue().getId()+ "\t"
					+ me.getValue().getString1() + "\t"
					+ me.getValue().getString2() + "\t"
					+ me.getValue().getString3() + "\t"
					+ me.getValue().getString4() + "\t"
					+ me.getValue().getString5() + "\n";
		}
		return string;
	
	}
	
	public String nameS(){
		String string = new String("学号\t真实姓名\t班级\t数学\t英语\t语文\n");
		TreeMap<String,Temp> treemap = new StudentSort().realNameSort();
		Set<Map.Entry<String, Temp>> set = treemap.entrySet();

		Iterator<Map.Entry<String, Temp>> newi = set.iterator();

		while (newi.hasNext()) {
			Map.Entry<String, Temp> me = newi.next();
			string = string + me.getValue().getId()+ "\t"
					+ me.getValue().getString1() + "\t"
					+ me.getValue().getString2() + "\t"
					+ me.getValue().getString3() + "\t"
					+ me.getValue().getString4() + "\t"
					+ me.getValue().getString5() + "\n";
		}
		return string;
	}
	
	public String clS(){
		String string = new String("学号\t真实姓名\t班级\t数学\t英语\t语文\n");
		TreeMap<String,Temp> treemap = new StudentSort().classSort();
		Set<Map.Entry<String, Temp>> set = treemap.entrySet();

		Iterator<Map.Entry<String, Temp>> newi = set.iterator();

		while (newi.hasNext()) {
			Map.Entry<String, Temp> me = newi.next();
			string = string + me.getValue().getId()+ "\t"
					+ me.getValue().getString1() + "\t"
					+ me.getValue().getString2() + "\t"
					+ me.getValue().getString3() + "\t"
					+ me.getValue().getString4() + "\t"
					+ me.getValue().getString5() + "\n";
		}
		return string;
	}
	
	public String scS(){
		String string = new String("学号\t真实姓名\t班级\t数学\t英语\t语文\n");
		Set<Map.Entry<String, Temp>> set = new StudentSort().scoreSort().entrySet();

		Iterator<Map.Entry<String, Temp>> newi = set.iterator();

		while (newi.hasNext()) {
			Map.Entry<String, Temp> me = newi.next();
			string = string + me.getValue().getId()+ "\t"
					+ me.getValue().getString1() + "\t"
					+ me.getValue().getString2() + "\t"
					+ me.getValue().getString3() + "\t"
					+ me.getValue().getString4() + "\t"
					+ me.getValue().getString5() + "\n";
		}
		return string;
	}
}
