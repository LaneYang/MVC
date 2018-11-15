package com.iotek.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.iotek.cont.AddCon;
import com.luwenrui.abstractfather.GuiView;
import com.luwenrui.dao.Temp;
import com.luwenrui.panduan.PanDuan;
import com.luwenrui.staticType.StaticType;

public class AddStudent extends GuiView {

	private JPanel painMain;
	private JPanel painTop;
	private JPanel painCenter;
	private JPanel painTail;

	private JLabel titleLabel;
	private JLabel sidLabel;
	private JLabel nameLabel;
	private JLabel passLabel;
	private JLabel passAginLabel;
	private JLabel reNaLabel;
	private JLabel classLabel;
	private JLabel mathLabel;
	private JLabel englishLabel;
	private JLabel clangLabel;

	private JTextField sidText;
	private JTextField nameText;
	private JPasswordField passText;
	private JPasswordField passAginText;
	private JTextField reNaText;
	private JTextField classText;
	private JTextField mathText;
	private JTextField englishText;
	private JTextField clangText;

	private JButton okButton;
	private JButton backButton;
	private JButton exitButton;

	public void show() {
		// TODO Auto-generated method stub
		GuiView.Show(this.PrintJPanel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == okButton) {
			boolean boo = false;
			boo = new PanDuan().NamePd(nameText.getText());
			boo = new PanDuan().PwdPd(new String(passText.getPassword()));
			boo = new PanDuan().TwoPass(new String(passText.getPassword()),
					new String(passAginText.getPassword()));
			if (boo) {
				Temp tp = new Temp();
				tp.setUsername(nameText.getText());
				tp.setPassword(new String(passText.getPassword()));
				tp.setType(3);
				tp.setString1(reNaText.getText());
				tp.setString2(classText.getText());
				tp.setString3(mathText.getText());
				tp.setString4(englishText.getText());
				tp.setString5(clangText.getText());
				StaticType.setUpdateInfo(tp);
				new AddCon().other();
			}
		}else if (e.getSource() == backButton){
			GuiView.frame.remove(this.painMain);
			new TeacherGui().show();
		}else if (e.getSource() == exitButton){
			super.exit();
		}

	}

	@Override
	protected JPanel PrintJPanel() {
		// TODO Auto-generated method stub
		painMain = new JPanel();
		painMain.setLayout(new BorderLayout(30, 30));
		painMain.setSize(600, 700);

		painTop = new JPanel();
		painTop.setLayout(new FlowLayout());
		titleLabel = new JLabel("学 生 添 加");
		titleLabel.setFont(new Font("宋体", Font.BOLD, 24));
		painTop.add(titleLabel);

		painCenter = new JPanel();
		painCenter.setLayout(new BorderLayout(30, 30));
		JPanel jpa = new JPanel();
		jpa.setLayout(new GridLayout(9, 2, 30, 30));
		sidLabel = new JLabel("学号:", JLabel.TRAILING);
		sidText = new JTextField(15);
		sidText.setText("0");
		sidText.setEditable(false);
		jpa.add(sidLabel);
		jpa.add(sidText);
		nameLabel = new JLabel("帐户:", JLabel.TRAILING);
		nameText = new JTextField(15);
		jpa.add(nameLabel);
		jpa.add(nameText);
		passLabel = new JLabel("密码:", JLabel.TRAILING);
		passText = new JPasswordField(15);
		passText.setEchoChar('*');
		jpa.add(passLabel);
		jpa.add(passText);
		passAginLabel = new JLabel("再次输入密码:", JLabel.TRAILING);
		passAginText = new JPasswordField(15);
		passAginText.setEchoChar('*');
		jpa.add(passAginLabel);
		jpa.add(passAginText);
		reNaLabel = new JLabel("真实姓名:", JLabel.TRAILING);
		reNaText = new JTextField(15);
		jpa.add(reNaLabel);
		jpa.add(reNaText);
		classLabel = new JLabel("班级:", JLabel.TRAILING);
		classText = new JTextField(15);
		classText.setText(StaticType.getLoginInfo().getString2());
		classText.setEditable(false);
		jpa.add(classLabel);
		jpa.add(classText);
		mathLabel = new JLabel("数学:", JLabel.TRAILING);
		mathText = new JTextField(15);
		mathText.setText("0");
		mathText.setEditable(true);
		jpa.add(mathLabel);
		jpa.add(mathText);
		englishLabel = new JLabel("英语:", JLabel.TRAILING);
		englishText = new JTextField(15);
		englishText.setText("0");
		englishText.setEditable(true);
		jpa.add(englishLabel);
		jpa.add(englishText);
		clangLabel = new JLabel("语文:", JLabel.TRAILING);
		clangText = new JTextField(15);
		clangText.setText("0");
		clangText.setEditable(true);
		jpa.add(clangLabel);
		jpa.add(clangText);
		painCenter.add(new JLabel(), BorderLayout.EAST);
		painCenter.add(jpa, BorderLayout.CENTER);
		painCenter.add(new JLabel(), BorderLayout.WEST);

		painTail = new JPanel();
		painTail.setLayout(new BorderLayout(30, 30));
		JPanel buttonpain = new JPanel();
		okButton = new JButton("添 加(R)");
		okButton.setMnemonic(KeyEvent.VK_R);
		okButton.addActionListener(this);
		backButton = new JButton("返 回(B)");
		backButton.setMnemonic(KeyEvent.VK_B);
		backButton.addActionListener(this);
		exitButton = new JButton("退 出(E)");
		exitButton.setMnemonic(KeyEvent.VK_E);
		exitButton.addActionListener(this);
		buttonpain.setLayout(new GridLayout(1, 3, 30, 30));
		buttonpain.add(okButton);
		buttonpain.add(backButton);
		buttonpain.add(exitButton);
		painTail.add(buttonpain, BorderLayout.CENTER);
		painTail.add(new JLabel(), BorderLayout.SOUTH);
		painTail.add(new JLabel(), BorderLayout.EAST);
		painTail.add(new JLabel(), BorderLayout.WEST);

		painMain.add(painTop, BorderLayout.NORTH);
		painMain.add(painCenter, BorderLayout.CENTER);
		painMain.add(painTail, BorderLayout.SOUTH);
		return painMain;
	}

}
