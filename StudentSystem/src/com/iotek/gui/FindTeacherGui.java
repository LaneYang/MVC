package com.iotek.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.iotek.Joption.GuiMessage;
import com.iotek.Joption.UpdatePassword;
import com.iotek.cont.AdminstorAll;
import com.iotek.cont.FindTeacher;
import com.iotek.cont.RemoveCon;
import com.iotek.cont.UpdateCon;
import com.luwenrui.abstractfather.GuiView;
import com.luwenrui.dao.Temp;
import com.luwenrui.staticType.StaticType;

public class FindTeacherGui extends GuiView implements ItemListener {

	private int oa = 0;
	private int ziduan = 1;
	private JPanel painMain;
	private JPanel painTop;
	private JPanel painCenter;
	private JPanel painEast;

	private JPanel showOne;
	private JTextArea textAre;
	private JScrollPane js;
	private JComboBox jc;
	private JRadioButton jrb1;
	private JRadioButton jrb2;

	private JLabel titleLabel;
	private JLabel tidLabel;
	private JLabel tnameLabel;
	private JLabel tageLabel;
	private JLabel classLabel;
	private JLabel emploLabel;

	private JTextField tidText;
	private JTextField tnameText;
	private JTextField tageText;
	private JTextField classText;
	private JTextField emploText;

	private JButton findButton;
	private JButton updateButton;
	private JButton defauButton;
	private JButton okButton;
	private JButton backButton;
	private JButton exitButton;
	private ButtonGroup bg;

	public void show() {
		// TODO Auto-generated method stub
		GuiView.Show(this.PrintJPanel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("单条记录")) {
			oa = 1;
			GuiView.frame.remove(this.painMain);
			this.show();
		} else if (e.getActionCommand().equals("多条记录")) {
			oa = 2;
			GuiView.frame.remove(this.painMain);
			this.show();
		}
		if (e.getSource() == okButton) {
			Temp tem = new Temp();
			tem.setId(Integer.parseInt(tidText.getText()));
			tem.setUsername(tnameText.getText());
			tem.setString1(tageText.getText());
			tem.setString2(classText.getText());
			tem.setString3(emploText.getText());
			StaticType.setUpdateInfo(tem);
			new UpdateCon().other();
		} else if (e.getSource() == backButton) {
			GuiView.frame.remove(painMain);
			new AdminstorGui().show();
		} else if (e.getSource() == updateButton) {
			if (oa == 2) {
				GuiMessage.showErr("多条记录不能修改");
			} else if (oa == 1) {
				tageText.setEditable(true);
				classText.setEditable(true);
				emploText.setEditable(true);
			}
		} else if (e.getSource() == findButton) {
			if (ziduan == 1 && oa == 1) {
				String id = UpdatePassword.PassOption("请 输入要查找的教师号");
				if (id != null) {
					new FindTeacher().findOne(Integer.parseInt(id));
					tidText.setText(StaticType.getUpdateInfo().getId() + "");
					tnameText.setText(StaticType.getUpdateInfo().getUsername());
					tageText.setText(StaticType.getUpdateInfo().getString1());
					classText.setText(StaticType.getUpdateInfo().getString2());
					emploText.setText(StaticType.getUpdateInfo().getString3());
				}
			} else if (ziduan == 2 && oa == 2) {
				String name = UpdatePassword.PassOption("请输入要查找的姓名");
				if (name != null) {
					textAre.setText(new FindTeacher().findOther(name));
				}
			} else if (ziduan == 3 && oa == 2) {
				String name = UpdatePassword.PassOption("请输入要查找的班级");
				if (name != null) {
					textAre.setText(new FindTeacher().findClassOther(name));
				}
			}
		} else if (e.getSource() == defauButton) {
			if (oa == 2) {
				GuiMessage.showErr("多条记录不能删除");
			} else if (oa == 1) {
				String id = UpdatePassword.PassOption("请输入要删除的教师号");
				if (id != null) {
					new FindTeacher().findOne(Integer.parseInt(id));
					StaticType.getUpdateInfo().setType(1);
					new RemoveCon().other();
				}
			}
		} else if (e.getSource() == exitButton) {
			super.exit();
		}

	}

	@Override
	protected JPanel PrintJPanel() {
		// TODO Auto-generated method stub
		painTop = new JPanel();
		painTop.setLayout(new FlowLayout());
		titleLabel = new JLabel("教 师 查 找 修 改");
		titleLabel.setFont(new Font("宋体", Font.BOLD, 24));
		painTop.add(titleLabel);

		painCenter = new JPanel();
		painCenter.setLayout(new BorderLayout());
		if (oa == 0 || oa == 1) {
			painCenter.add(this.showOneTeacher(), BorderLayout.CENTER);
			painCenter.add(new JLabel(), BorderLayout.NORTH);
			painCenter.add(new JLabel(), BorderLayout.SOUTH);
			painCenter.add(new JLabel(), BorderLayout.EAST);
		} else {
			painCenter.add(this.showAllTeacher(), BorderLayout.CENTER);
			painCenter.add(new JLabel(), BorderLayout.NORTH);
			painCenter.add(new JLabel(), BorderLayout.SOUTH);
			painCenter.add(new JLabel(), BorderLayout.EAST);
		}

		painEast = new JPanel();
		JPanel jcP = new JPanel();
		jcP.setLayout(new FlowLayout());
		jc = new JComboBox();
		jc.addItem("教师号");
		jc.addItem("教师姓名");
		jc.addItem("班级");
		jc.addItemListener(this);
		jcP.add(jc);

		JPanel jrbP = new JPanel();
		jrbP.setLayout(new GridLayout(1, 2, 30, 30));
		jrb1 = new JRadioButton("单条记录");
		jrb1.addActionListener(this);
		jrb2 = new JRadioButton("多条记录");
		jrb2.addActionListener(this);
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		jrbP.add(jrb1);
		jrbP.add(jrb2);

		findButton = new JButton("查找(F)");
		findButton.setMnemonic(KeyEvent.VK_F);
		findButton.addActionListener(this);
		updateButton = new JButton("修改(U)");
		updateButton.setMnemonic(KeyEvent.VK_U);
		updateButton.addActionListener(this);
		defauButton = new JButton("删除(D)");
		defauButton.setMnemonic(KeyEvent.VK_D);
		defauButton.addActionListener(this);
		okButton = new JButton("确认(O)");
		okButton.setMnemonic(KeyEvent.VK_O);
		okButton.addActionListener(this);
		backButton = new JButton("返回(B)");
		backButton.setMnemonic(KeyEvent.VK_B);
		backButton.addActionListener(this);
		exitButton = new JButton("退出(E)");
		exitButton.setMnemonic(KeyEvent.VK_E);
		exitButton.addActionListener(this);

		JPanel panela = new JPanel();
		panela.setLayout(new GridLayout(8, 1, 30, 30));
		panela.add(jcP);
		panela.add(jrbP);
		panela.add(findButton);
		panela.add(updateButton);
		panela.add(defauButton);
		panela.add(okButton);
		panela.add(backButton);
		panela.add(exitButton);

		painEast = new JPanel();
		painEast.setLayout(new BorderLayout());
		painEast.add(panela, BorderLayout.CENTER);
		painEast.add(new JLabel(), BorderLayout.SOUTH);
		painEast.add(new JLabel(), BorderLayout.NORTH);
		painEast.add(new JLabel(), BorderLayout.EAST);

		painMain = new JPanel();
		painMain.setLayout(new BorderLayout());
		painMain.add(painTop, BorderLayout.NORTH);
		painMain.add(painCenter, BorderLayout.CENTER);
		painMain.add(painEast, BorderLayout.EAST);
		painMain.setSize(700, 700);
		return painMain;
	}

	public JPanel showAllTeacher() {
		

		textAre = new JTextArea();
		textAre.setSize(500, 500);
		textAre.setLineWrap(true);
		textAre.setText(new AdminstorAll().idS());
		textAre.setPreferredSize(new Dimension(500, 600));
		textAre.setEditable(false);
		js = new JScrollPane(textAre);
		painCenter = new JPanel();
		painCenter.setSize(500, 500);
		painCenter.add(js);

		return painCenter;
	}

	public JPanel showOneTeacher() {
		JPanel painb = new JPanel();
		painb.setLayout(new BorderLayout());
		showOne = new JPanel();
		showOne.setPreferredSize(new Dimension(500, 500));
		showOne.setSize(500, 500);
		showOne.setLayout(new GridLayout(5, 2, 30, 30));
		tidLabel = new JLabel("教师号:", JLabel.TRAILING);
		tidText = new JTextField(15);

		tidText.setEditable(false);
		tnameLabel = new JLabel("教师帐号:", JLabel.TRAILING);
		tnameText = new JTextField(15);

		tnameText.setEditable(false);
		tageLabel = new JLabel("教师姓名:", JLabel.TRAILING);
		tageText = new JTextField(15);

		tageText.setEditable(false);
		classLabel = new JLabel("教课班级:", JLabel.TRAILING);
		classText = new JTextField(15);

		classText.setEditable(false);
		emploLabel = new JLabel("教师薪酬:", JLabel.TRAILING);
		emploText = new JTextField(15);

		emploText.setEditable(false);
		showOne.add(tidLabel);
		showOne.add(tidText);
		showOne.add(tnameLabel);
		showOne.add(tnameText);
		showOne.add(tageLabel);
		showOne.add(tageText);
		showOne.add(classLabel);
		showOne.add(classText);
		showOne.add(emploLabel);
		showOne.add(emploText);
		painb.add(showOne, BorderLayout.CENTER);
		painb.add(new JLabel(), BorderLayout.EAST);
		return painb;
	}

	public void itemStateChanged(ItemEvent ie) {
		String s = (String) ie.getItem().toString();
		if (s.equals("教师号")) {
			ziduan = 1;
		} else if (s.equals("教师姓名")) {
			ziduan = 2;
		} else if (s.equals("班级")) {
			ziduan = 3;
		}
	}
}
