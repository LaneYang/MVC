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
import com.iotek.cont.GotoLogin;
import com.iotek.cont.TeacherAll;
import com.iotek.cont.UpdateCon;
import com.luwenrui.abstractfather.GuiView;
import com.luwenrui.staticType.StaticType;

public class TeacherGui extends GuiView {

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
	private JButton ageSortButton;
	private JButton scoreSortButton;
	private JButton backButton;
	private JButton exitButton;
	private JScrollPane js;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == passButton) {
			String pass = UpdatePassword.PassOption("������ԭ����");
			if (pass.equals(StaticType.getLoginInfo().getPassword())) {
				String pass1 = UpdatePassword.PassOption("������������");
				String pass2 = UpdatePassword.PassOption("�ٴ�����������");
				if (pass1.equals(pass2)) {
					StaticType.getLoginInfo().setPassword(pass1);
					new UpdateCon().mine();
				} else {
					GuiMessage.showErr("�����������벻һ��");
				}
			} else {
				GuiMessage.showErr("��ԭ���벻һ��");
			}
		} else if (e.getSource() == addButton) {
			GuiView.frame.remove(painMain);
			new AddStudent().show();
		} else if (e.getSource() == findButton) {
			GuiView.frame.remove(painMain);
			new FindStudentGui().show();
		} else if (e.getSource() == sidSortButton) {
			teaArea.setText(new TeacherAll().showS(1));
		} else if (e.getSource() == ageSortButton) {
			teaArea.setText(new TeacherAll().showS(2));
		} else if (e.getSource() == scoreSortButton) {
			teaArea.setText(new TeacherAll().showS(4));
		} else if (e.getSource() == backButton) {
			new GotoLogin().Back(painMain);
		} else if (e.getSource() == exitButton) {
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
		String title = "��ӭ����," + StaticType.getLoginInfo().getUsername() + "��ʦ";
		painTop = new JPanel();
		painTop.setLayout(new FlowLayout());
		titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("����", Font.BOLD, 24));
		painTop.add(titleLabel);

		teaArea = new JTextArea();
		teaArea.setSize(500, 500);
		teaArea.setLineWrap(true);
		teaArea.setText(new TeacherAll().showS(1));
		teaArea.setPreferredSize(new Dimension(600, 600));
		teaArea.setEditable(false);
		js = new JScrollPane(teaArea);
		painCenter = new JPanel();
		painCenter.setSize(500, 500);
		painCenter.add(js);

		passButton = new JButton("�޸�����(P)");
		passButton.setMnemonic(KeyEvent.VK_P);
		passButton.addActionListener(this);

		addButton = new JButton("���ѧ��(A)");
		addButton.setMnemonic(KeyEvent.VK_A);
		addButton.addActionListener(this);

		findButton = new JButton("����ѧ��(F)");
		findButton.setMnemonic(KeyEvent.VK_F);
		findButton.addActionListener(this);

		sidSortButton = new JButton("��ѧ�ź�����(T)");
		sidSortButton.setMnemonic(KeyEvent.VK_T);
		sidSortButton.addActionListener(this);

		ageSortButton = new JButton("����ʵ��������(G)");
		ageSortButton.setMnemonic(KeyEvent.VK_G);
		ageSortButton.addActionListener(this);

		

		scoreSortButton = new JButton("���ܳɼ�����(S)");
		scoreSortButton.setMnemonic(KeyEvent.VK_S);
		scoreSortButton.addActionListener(this);

		backButton = new JButton("�� ��(B)");
		backButton.setMnemonic(KeyEvent.VK_B);
		backButton.addActionListener(this);

		exitButton = new JButton("�� ��(E)");
		exitButton.setMnemonic(KeyEvent.VK_E);
		exitButton.addActionListener(this);

		JPanel buttonPan = new JPanel();
		buttonPan.setLayout(new GridLayout(9, 1, 30, 30));
		buttonPan.add(passButton);
		buttonPan.add(addButton);
		buttonPan.add(findButton);
		buttonPan.add(sidSortButton);
		buttonPan.add(ageSortButton);
		buttonPan.add(scoreSortButton);
		buttonPan.add(backButton);
		buttonPan.add(exitButton);
		buttonPan.add(new JLabel());

		painEast = new JPanel();
		painEast.setLayout(new BorderLayout(30, 30));
		painEast.add(buttonPan, BorderLayout.CENTER);
		painEast.add(new JLabel(), BorderLayout.EAST);

		painMain = new JPanel();
		painMain.setLayout(new BorderLayout(30, 30));
		painMain.setSize(700, 700);
		painMain.add(painTop, BorderLayout.NORTH);
		painMain.add(painCenter, BorderLayout.CENTER);
		painMain.add(painEast, BorderLayout.EAST);
		return painMain;
	}
}
