package com.luwenrui.panduan;



import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.iotek.Joption.GuiMessage;
import com.luwenrui.dao.Admin;
import com.luwenrui.dao.Student;
import com.luwenrui.dao.Teacher;
import com.luwenrui.dao.Temp;
import com.luwenrui.sql.AdminDataIn;
import com.luwenrui.sql.StuDataIn;
import com.luwenrui.sql.TeaDataIn;
import com.luwenrui.staticType.StaticType;
import com.luwenrui.zhuanhuan.Zhuanhuan;

public class PanDuan {
	Boolean boo = false;

	public boolean Login(String name, String password) {
		// TODO Auto-generated method stub
		TreeMap<Integer, Admin> treeMap = new AdminDataIn().DataOu();
		Set<Map.Entry<Integer, Admin>> set = treeMap.entrySet();

		Iterator<Map.Entry<Integer, Admin>> i = set.iterator();

		while (i.hasNext()) {
			Map.Entry<Integer, Admin> me = i.next();
			if (me.getValue().getUsername().equals(name) == true
					&& me.getValue().getPassword().equals(password) == true) {
				int num = me.getValue().getZhantype();
				switch (num){
				case 1:
					StaticType.setLoginInfo(Zhuanhuan.AtoT(me.getValue()));
					break;
				case 2:
					Teacher tea = new TeaDataIn().DataOut(me.getValue().getId());
					Temp tp = Zhuanhuan.TetoT(tea);
					StaticType.setLoginInfo(tp);
					break;
				case 3:
					Student stu = new StuDataIn().DataOut(me.getValue().getId());
					StaticType.setLoginInfo(Zhuanhuan.StoT(stu));
					break;
				}
				return true;
			}

		}
		return false;
	}

	public boolean NamePd(String name) {
		if (name.length() < 6 || name.length() > 16) {
			GuiMessage.showErr("�ʺų��Ȳ���ȷ");
			return false;
		}
		return true;
	}
	public boolean PwdPd(String password){
		if(password.length()<6 ||password.length()>20){
			GuiMessage.showErr("���볤�Ȳ���ȷ");
			return false;
		}
		return true;
	}
	public boolean ScorePd(String score){
		if (score.length()<4){
			GuiMessage.showErr("����ȷ�ĳɼ�");
			return false;
		}
		for (int i = 0;i<score.length();i++){
			if ((score.charAt(i)<'0' || score.charAt(i)>'9')&& score.charAt(i)!='.' ){
				GuiMessage.showErr("�ɼ�ֻ��������");
				return false;
			}
		}
		Double age = new Double(Double.parseDouble(score));
		if (age<0 || age>100){
			GuiMessage.showErr("�ɼ�ֻ����0-100֮��");
			return false;
		}else{
			return true;
		}
	}
	
	public boolean TwoPass(String pass,String pass1){
		if (pass.equals(pass1)){
			return true;
		}else{
			GuiMessage.showErr("�����������벻һ��");
			return false;
		}
	}
	
	public boolean TwoServer(String name){
		TreeMap<Integer, Admin> treeMap = new AdminDataIn().DataOu();
		Set<Map.Entry<Integer, Admin>> set = treeMap.entrySet();

		Iterator<Map.Entry<Integer, Admin>> i = set.iterator();

		while (i.hasNext()) {
			Map.Entry<Integer, Admin> me = i.next();
			if (me.getValue().getUsername().equals(name)){
				GuiMessage.showErr("�ʺ����ظ�");
				return false;
			}
			
		}
		return true;
	}
}
