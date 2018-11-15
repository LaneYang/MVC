package com.iotek.cont;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.luwenrui.dao.Admin;
import com.luwenrui.sql.AdminDataIn;

public class AutoId {
	
	public int setId(){
		int max = 0; 
		// TODO Auto-generated method stub
		TreeMap<Integer, Admin> treeMap = new AdminDataIn().DataOu();
		Set<Map.Entry<Integer, Admin>> set = treeMap.entrySet();

		Iterator<Map.Entry<Integer, Admin>> i = set.iterator();

		while (i.hasNext()) {
			Map.Entry<Integer, Admin> me = i.next();
			if (me.getValue().getId()>max){
				max = me.getValue().getId();
			}
		}
		return max++;
	}

}
