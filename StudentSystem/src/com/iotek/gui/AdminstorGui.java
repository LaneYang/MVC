package com.iotek.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.iotek.Joption.GuiMessage;
import com.iotek.Joption.UpdatePassword;
import com.iotek.cont.AdminstorAll;
import com.iotek.cont.GotoLogin;
import com.iotek.cont.UpdateCon;
import com.luwenrui.abstractfather.GuiView;
import com.luwenrui.staticType.StaticType;

public class AdminstorGui extends GuiView{

	private JPanel painMain;
	private JPanel painTop;
	private JPanel painCenter;
	private JPanel painEast;

	private JLabel titleLabel;
	private JTextArea teaArea;
	
	private JButton passButton;
	private JButton addButton;
	private JButton findButton;
	private JButton sidSortButton;
	private JButton nameSortButton;
	private JButton clasSortButton;
	private JButton backButton;
	private JButton exitButton;
	private JScrollPane js;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == passButton){
			String pass = UpdatePassword.PassOption("请输入原密码");
			if (pass.equals(StaticType.getLoginInfo().getPassword())) {
				String pass1 = UpdatePassword.PassOption("请输入新密码");
				String pass2 = UpdatePassword.PassOption("再次输入新密码");
				if (pass1.equals(pass2)) {
					StaticType.getLoginInfo().setPassword(pass1);
					new UpdateCon().mine();
				} else {
					GuiMessage.showErr("两次输入密码不一致");
				}
			} else {
				GuiMessage.showErr("与原密码不一致");
			}
		}else if (e.getSource() == addButton){
			GuiView.frame.remove(painMain);
			new AddTeacher().show();
		}else if (e.getSource() == findButton){
			GuiView.frame.remove(painMain);
			new FindTeacherGui().show();
		}else if (e.getSource() == sidSortButton){
			teaArea.setText(new AdminstorAll().idS());
		}else if (e.getSource() == nameSortButton){
			teaArea.setText(new AdminstorAll().nameS());
		}else if (e.getSource() == clasSortButton){
			teaArea.setText(new AdminstorAll().clS());
		}else if (e.getSource() == backButton){
			new GotoLogin().Back(painMain);
		}else if (e.getSource() == exitButton){
			super.exit();
		}

	}

	public void show() {
		// TODO Auto-generated method stub
		GuiView.Show(this.PrintJPanel());
	}

	@Override
	protected JPanel PrintJPanel() {
		// TODO Auto-generated method stub
		String title = "欢迎光临," + com.luwenrui.staticType.StaticType.getLoginInfo().getUsername() + "管理员";
		painTop = new JPanel();
		painTop.setLayout(new FlowLayout());
		titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("宋体", Font.BOLD, 24));
		painTop.add(titleLabel);
		
		teaArea = new JTextArea();
		teaArea.setSize(500, 500);
		teaArea.setLineWrap(true);
		teaArea.setText(new AdminstorAll().idS());
		teaArea.setPreferredSize(new Dimension(500,600));
		teaArea.setEditable(false);
		js = new JScrollPane(teaArea);
		painCenter = new JPanel();
		painCenter.setSize(500, 500);
		painCenter.add(js);
		
		passButton = new JButton("修改密码(P)");
		passButton.setMnemonic(KeyEvent.VK_P);
		passButton.addActionListener(this);
		
		addButton = new JButton("添加教师(A)");
		addButton.setMnemonic(KeyEvent.VK_A);
		addButton.addActionListener(this);
		
		findButton = new JButton("查找教师(F)");
		findButton.setMnemonic(KeyEvent.VK_F);
		findButton.addActionListener(this);
		
		sidSortButton = new JButton("按教师号排序(T)");
		sidSortButton.setMnemonic(KeyEvent.VK_T);
		sidSortButton.addActionListener(this);
		
		nameSortButton = new JButton("按姓名排序(N)");
		nameSortButton.setMnemonic(KeyEvent.VK_N);
		nameSortButton.addActionListener(this);
		
		clasSortButton = new JButton("按班级排序(C)");
		clasSortButton.setMnemonic(KeyEvent.VK_C);
		clasSortButton.addActionListener(this);
		
		backButton = new JButton("返 回(B)");
		backButton.setMnemonic(KeyEvent.VK_B);
		backButton.addActionListener(this);
		
		exitButton = new JButton("退 出(E)");
		exitButton.setMnemonic(KeyEvent.VK_E);
		exitButton.addActionListener(this);
		
		JPanel buttonPan = new JPanel();
		buttonPan.setLayout(new GridLayout(9,1,30,30));
		buttonPan.add(passButton);
		buttonPan.add(addButton);
		buttonPan.add(findButton);
		buttonPan.add(sidSortButton);
		buttonPan.add(nameSortButton);
		buttonPan.add(clasSortButton);
		buttonPan.add(backButton);
		buttonPan.add(exitButton);
		buttonPan.add(new JLabel());

		painEast = new JPanel();
		painEast.setLayout(new BorderLayout(30,30));
		painEast.add(buttonPan,BorderLayout.CENTER);
		painEast.add(new JLabel(),BorderLayout.EAST);
		
		painMain = new JPanel();
		painMain.setLayout(new BorderLayout(30,30));
		painMain.setSize(700, 700);
		painMain.add(painTop,BorderLayout.NORTH);
		painMain.add(painCenter,BorderLayout.CENTER);
		painMain.add(painEast,BorderLayout.EAST);
		return painMain;
	}
}
