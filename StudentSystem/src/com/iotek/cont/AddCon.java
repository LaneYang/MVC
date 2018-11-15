package com.iotek.cont;

import com.iotek.Joption.GuiMessage;
import com.iotek.interfacev.UpdateInterface;
import com.luwenrui.dao.Admin;
import com.luwenrui.dao.Student;
import com.luwenrui.dao.Teacher;
import com.luwenrui.panduan.PanDuan;
import com.luwenrui.sql.AdminDataIn;
import com.luwenrui.sql.StuDataIn;
import com.luwenrui.sql.TeaDataIn;
import com.luwenrui.staticType.StaticType;
import com.luwenrui.zhuanhuan.Zhuanhuan;

public class AddCon implements UpdateInterface {

	@Override
	public void other() {
		// TODO Auto-generated method stub
		int i = StaticType.getUpdateInfo().getType();
		if (new PanDuan().TwoServer(StaticType.getUpdateInfo().getUsername())) {
			switch (i) {
			case 2:
				int id = new AutoId().setId();
				id++;
				Admin ad = Zhuanhuan.TtoA(StaticType.getUpdateInfo());
				ad.setId(id);
				new AdminDataIn().ObjectAdd(ad);
				Teacher sd = Zhuanhuan.TtoTe(StaticType.getUpdateInfo());
				sd.setId(id);
				new TeaDataIn().ObjectAdd(sd);

				break;
			case 3:
				int ids = new AutoId().setId();
				ids++;
				Admin adt = Zhuanhuan.TtoA(StaticType.getUpdateInfo());
				adt.setId(ids);
				new AdminDataIn().ObjectAdd(adt);
				Student st = Zhuanhuan.TtoS(StaticType.getUpdateInfo());
				st.setId(ids);
				new StuDataIn().ObjectAdd(st);
				break;
			}
			GuiMessage.showErr("Ìí¼Ó³É¹¦ ");
		}
	}

	@Override
	public void mine() {
		// TODO Auto-generated method stub

	}

}
