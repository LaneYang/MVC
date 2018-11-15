package com.luwenrui.abstractfather;

public abstract class Person {

	private int id;
	private String username;
	private String password;
	private int ifUpdate = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getIfUpdate() {
		return ifUpdate;
	}
	public void setIfUpdate(int ifUpdate) {
		this.ifUpdate = ifUpdate;
	}
	public abstract void clean();
}
