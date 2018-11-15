package com.iotek.cont;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.iotek.interfacev.FindInterface;
import com.iotek.sort.StudentSort;
import com.luwenrui.dao.Temp;
import com.luwenrui.staticType.StaticType;

public class FindStudent implements FindInterface {

	//����ID
	@Override
	public void findOne(int id) {
		// TODO Auto-generated method stub
		TreeMap<Integer,Temp> treemap = new StudentSort().idSort();
		Set<Map.Entry<Integer, Temp>> set = treemap.entrySet();

		Iterator<Map.Entry<Integer, Temp>> newi = set.iterator();

		while (newi.hasNext()) {
			Map.Entry<Integer, Temp> me = newi.next();
			if (id == me.getValue().getId()){
				StaticType.setUpdateInfo(me.getValue());
			}
			
		}
	}
	//��������
	@Override
	public String findOther(String name) {
		// TODO Auto-generated method stub
		String string = new String("ѧ��\t��ʵ����\t�༶\t��ѧ\tӢ��\t����\n");
		TreeMap<Integer,Temp> treemap = new StudentSort().idSort();
		Set<Map.Entry<Integer, Temp>> set = treemap.entrySet();

		Iterator<Map.Entry<Integer, Temp>> newi = set.iterator();

		while (newi.hasNext()) {
			Map.Entry<Integer, Temp> me = newi.next();
			if (me.getValue().getString1().equals(name)){
				string = string + me.getValue().getId()+ "\t"
				+ me.getValue().getString1() + "\t"
				+ me.getValue().getString2() + "\t"
				+ me.getValue().getString3() + "\t"
				+ me.getValue().getString4() + "\t"
				+ me.getValue().getString5() + "\n";
			}
			
		}
		return string;
	}
	
	//���ݰ༶
	public String findClassOther(String name){
		String string = new String("ѧ��\t��ʵ����\t�༶\t��ѧ\tӢ��\t����\n");
		TreeMap<Integer,Temp> treemap = new StudentSort().idSort();
		Set<Map.Entry<Integer, Temp>> set = treemap.entrySet();

		Iterator<Map.Entry<Integer, Temp>> newi = set.iterator();

		while (newi.hasNext()) {
			Map.Entry<Integer, Temp> me = newi.next();
			if (me.getValue().getString2().equals(name)){
				string = string + me.getValue().getId()+ "\t"
				+ me.getValue().getString1() + "\t"
				+ me.getValue().getString2() + "\t"
				+ me.getValue().getString3() + "\t"
				+ me.getValue().getString4() + "\t"
				+ me.getValue().getString5() + "\n";
			}
			
		}
		return string;
	}

}
