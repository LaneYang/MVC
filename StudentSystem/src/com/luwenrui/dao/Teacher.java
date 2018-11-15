package com.luwenrui.dao;

import com.luwenrui.abstractfather.Person;

public class Teacher extends Person {

	private final int type = 2;
	private String realName;
	private String className;
	private double salary;
	
	public int getType(){
		return this.type;
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
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
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
		this.setRealName(null);
		this.setClassName(null);
		this.setSalary(0);
		this.setIfUpdate(0);

	}

}
