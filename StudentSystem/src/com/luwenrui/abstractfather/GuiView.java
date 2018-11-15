package com.luwenrui.abstractfather;

import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class GuiView implements ActionListener {

	public static JFrame frame = new JFrame("学生管理系统");

	protected static void Show(JPanel panel) {
		double height = panel.getHeight();
		double widthy = panel.getWidth();

		frame.getContentPane().add(panel);
		frame.setLocation(
						(int) (Toolkit.getDefaultToolkit().getScreenSize().width - widthy) / 2,
						(int) (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected void exit(){
		System.exit(1);
	}
	
	protected abstract JPanel PrintJPanel();
}
