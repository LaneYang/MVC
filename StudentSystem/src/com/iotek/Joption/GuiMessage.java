package com.iotek.Joption;

import javax.swing.JOptionPane;

public class GuiMessage {

	public static void showErr(String message) {
		JOptionPane jpa = new JOptionPane();
		JOptionPane.showMessageDialog(jpa, message);
	}
}
