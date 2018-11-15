package com.luwenrui.dao;

import com.luwenrui.abstractfather.Person;

public class Admin extends Person {

	private final int type = 1;
	private int Zhantype;
	public int getType(){
		return this.type;
	}
	
	public int getZhantype() {
		return Zhantype;
	}

	public void setZhantype(int zhantype) {
		Zhantype = zhantype;
	}

	public void setId(int id){
		super.setId(id);
	}
	
	public int getId(){
		return super.getId();
	}
	
	public void setUsername(String name){
		super.setUsername(name);
	}
	
	public String getUsername(){
		return super.getUsername();
	}
	
	public void setPassword(String pass){
		super.setPassword(pass);
	}
	
	public String getPassword(){
		return super.getPassword();
	}
	public void setIfUpdated(int i){
		super.setIfUpdate(i);
	}
	
	public int getIfUpdated(){
		return super.getIfUpdate();
	}
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		this.setId(0);
		this.setUsername(null);
		this.setPassword(null);
		this.setIfUpdate(0);
	}

}
