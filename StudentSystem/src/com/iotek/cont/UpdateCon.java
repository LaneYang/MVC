package com.iotek.cont;

import com.iotek.Joption.GuiMessage;
import com.iotek.interfacev.UpdateInterface;
import com.luwenrui.dao.Admin;
import com.luwenrui.dao.Student;
import com.luwenrui.dao.Teacher;
import com.luwenrui.sql.AdminDataIn;
import com.luwenrui.sql.StuDataIn;
import com.luwenrui.sql.TeaDataIn;
import com.luwenrui.staticType.StaticType;
import com.luwenrui.zhuanhuan.Zhuanhuan;

public class UpdateCon implements UpdateInterface{

	public void other(){
		
		int i = StaticType.getUpdateInfo().getType();
		switch (i){
		case 1:
			Admin ad = Zhuanhuan.TtoA(StaticType.getUpdateInfo());
			new AdminDataIn().ObjectUpdate(ad);
			Teacher sd = Zhuanhuan.TtoTe(StaticType.getUpdateInfo());
			new TeaDataIn().ObjectUpdate(sd);
			break;
		case 2:
			Admin adt = Zhuanhuan.TtoA(StaticType.getUpdateInfo());
			new AdminDataIn().ObjectUpdate(adt);
			Student st = Zhuanhuan.TtoS(StaticType.getUpdateInfo());
			new StuDataIn().ObjectUpdate(st);
			break;
		}
		GuiMessage.showErr("修改成功 ");
	}
	
	public void mine(){
		int i = StaticType.getLoginInfo().getType();
		switch(i){
		case 1:
			Admin ad = Zhuanhuan.TtoA(StaticType.getLoginInfo());
			new AdminDataIn().ObjectUpdate(ad);
			break;
		case 2:
			Admin adt = Zhuanhuan.TtoA(StaticType.getLoginInfo());
			new AdminDataIn().ObjectUpdate(adt);
			Teacher st = Zhuanhuan.TtoTe(StaticType.getLoginInfo());
			new TeaDataIn().ObjectUpdate(st);
			break;
		case 3:
			Admin ads = Zhuanhuan.TtoA(StaticType.getLoginInfo());
			new AdminDataIn().ObjectUpdate(ads);
			Student std = Zhuanhuan.TtoS(StaticType.getLoginInfo());
			new StuDataIn().ObjectUpdate(std);
			break;
		}
		GuiMessage.showErr("修改成功 ");
	}
}
