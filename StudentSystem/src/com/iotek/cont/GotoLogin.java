package com.iotek.cont;

import javax.swing.JPanel;

import com.iotek.gui.LoginGui;
import com.luwenrui.abstractfather.GuiView;

public class GotoLogin {

	public void Back(JPanel pane){
		GuiView.frame.remove(pane);
		new LoginGui().show();
	}
}
