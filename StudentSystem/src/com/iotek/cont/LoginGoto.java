package com.iotek.cont;

import com.iotek.gui.AdminstorGui;
import com.iotek.gui.StudentManager;
import com.iotek.gui.TeacherGui;

public class LoginGoto {

	public void Goto(int i){
		switch(i){
		case 1:
			new AdminstorGui().show();
			break;
		case 2:
			new TeacherGui().show();
			break;
		case 3:
			new StudentManager().show();
			break;
		}
	}
}
