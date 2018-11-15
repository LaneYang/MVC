package com.iotek.interfacev;

import java.util.TreeMap;

import com.luwenrui.dao.Temp;

public interface SortInterface {

	public TreeMap<Integer,Temp> idSort();
	public TreeMap<String,Temp> realNameSort();
	public TreeMap<String,Temp> classSort();
}
