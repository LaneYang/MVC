package com.iotek.Joption;

import javax.swing.JOptionPane;
import com.luwenrui.abstractfather.GuiView;

public class UpdatePassword {

	public static String PassOption(String message) {

		String title = new String("ÐÞ¸ÄÃÜÂë");
		int typeMessage = JOptionPane.INFORMATION_MESSAGE;
		String password = (String) JOptionPane.showInputDialog(GuiView.frame,
				message, title, typeMessage);
		if (password==null || password.equals("")){
			return null;
		}
		return password;

	}
}
