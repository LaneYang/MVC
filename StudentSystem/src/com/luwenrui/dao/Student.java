package com.luwenrui.dao;

import com.luwenrui.abstractfather.Person;

public class Student extends Person {

	private final int type = 3;
	private String realName;
	private String className;
	private Double mathScore;
	private Double englishScore;
	private Double chineseScore;
	
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
	
	public void setIfUpdated(int i){
		super.setIfUpdate(i);
	}
	
	public int getIfUpdated(){
		return super.getIfUpdate();
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
	public double getMathScore() {
		if (mathScore == null){
			return 0;
		}else{
			return mathScore;
		}
	}
	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}
	public double getEnglishScore() {
		if (englishScore == null){
			return 0;
		}else{
			return englishScore;
		}
	}
	public void setEnglishScore(double englishScore) {
		this.englishScore = englishScore;
	}
	public double getChineseScore() {
		if (chineseScore == null){
			return 0;
		}else{
			return chineseScore;
		}
	}
	public void setChineseScore(double chineseScore) {
		this.chineseScore = chineseScore;
	}
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		this.setId(0);
		this.setUsername(null);
		this.setPassword(null);
		this.setRealName(null);
		this.setClassName(null);
		this.setMathScore(0);
		this.setChineseScore(0);
		this.setEnglishScore(0);
		this.setIfUpdate(0);
	}

}
