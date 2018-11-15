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

public class RemoveCon implements UpdateInterface{

	@Override
	public void other() {
		// TODO Auto-generated method stub
		int i = StaticType.getUpdateInfo().getType();
		switch (i){
		case 1:
			Admin ad = Zhuanhuan.TtoA(StaticType.getUpdateInfo());
			new AdminDataIn().ObjectRemove(ad);
			Teacher sd = Zhuanhuan.TtoTe(StaticType.getUpdateInfo());
			new TeaDataIn().ObjectRemove(sd);
			break;
		case 2:
			Admin adt = Zhuanhuan.TtoA(StaticType.getUpdateInfo());
			new AdminDataIn().ObjectRemove(adt);
			Student st = Zhuanhuan.TtoS(StaticType.getUpdateInfo());
			new StuDataIn().ObjectRemove(st);
			break;
		}
		GuiMessage.showErr("É¾³ý³É¹¦ ");
	}

	@Override
	public void mine() {
		// TODO Auto-generated method stub
		
	}

}
