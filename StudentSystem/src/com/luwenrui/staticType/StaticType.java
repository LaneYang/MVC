package com.luwenrui.staticType;

import com.luwenrui.dao.Temp;

public class StaticType {

	private static Temp loginInfo = new Temp();
	private static Temp updateInfo = new Temp();
	
	public static Temp getLoginInfo() {
		return loginInfo;
	}
	public static void setLoginInfo(Temp loginInfo) {
		StaticType.loginInfo = loginInfo;
	}
	public static Temp getUpdateInfo() {
		return updateInfo;
	}
	public static void setUpdateInfo(Temp updateInfo) {
		StaticType.updateInfo = updateInfo;
	}
	
	
}
