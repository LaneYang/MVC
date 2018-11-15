package com.luwenrui.dao;

import com.luwenrui.abstractfather.Person;

public class Temp extends Person {

	private int type;
	
	private String string1;
	private String string2;
	private String string3;
	private String string4;
	private String string5;
	private String string6;
	private String string7;
	private String string8;
	private String string9;
	
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
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}

	public String getString4() {
		return string4;
	}

	public void setString4(String string4) {
		this.string4 = string4;
	}

	public String getString5() {
		return string5;
	}

	public void setString5(String string5) {
		this.string5 = string5;
	}

	public String getString6() {
		return string6;
	}

	public void setString6(String string6) {
		this.string6 = string6;
	}

	public String getString7() {
		return string7;
	}

	public void setString7(String string7) {
		this.string7 = string7;
	}

	public String getString8() {
		return string8;
	}

	public void setString8(String string8) {
		this.string8 = string8;
	}

	public String getString9() {
		return string9;
	}

	public void setString9(String string9) {
		this.string9 = string9;
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
		this.setType(0);
		this.setString1(null);
		this.setString2(null);
		this.setString3(null);
		this.setString4(null);
		this.setString5(null);
		this.setString6(null);
		this.setString7(null);
		this.setString8(null);
		this.setString9(null);
		this.setIfUpdate(0);

	}

}
