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
import javax.swing.JTextField;

import com.iotek.Joption.GuiMessage;
import com.iotek.Joption.UpdatePassword;
import com.iotek.cont.GotoLogin;
import com.iotek.cont.UpdateCon;
import com.luwenrui.abstractfather.GuiView;
import com.luwenrui.staticType.StaticType;

public class StudentManager extends GuiView{

	private JPanel paneMain;
	private JPanel paneTop;
	private JPanel paneCenter;
	private JPanel paneEast;
	
	private JLabel titleLabel;
	private JLabel sidLabel;
	private JLabel ageLabel;
	private JLabel reNaLabel;
	private JLabel classLabel;
	private JLabel mathLabel;
	private JLabel englishLabel;

	private JTextField sidText;
	private JTextField ageText;
	private JTextField reNaText;
	private JTextField classText;
	private JTextField mathText;
	private JTextField englishText;

	private JButton passButton;
	private JButton okButton;
	private JButton backButton;
	private JButton exitButton;
	
	public void show(){
		
		GuiView.Show(this.PrintJPanel());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == passButton){
			String pass = UpdatePassword.PassOption("������ԭ����");
			if (pass.equals(StaticType.getLoginInfo().getPassword())){
				String pass1 = UpdatePassword.PassOption("������������");
				String pass2 = UpdatePassword.PassOption("�ٴ�����������");
				if (pass1.equals(pass2)){
					StaticType.getLoginInfo().setPassword(pass1);
				}else{
					GuiMessage.showErr("�����������벻һ��");
				}
			}else{
				GuiMessage.showErr("��ԭ���벻һ��");
			}
		}else if (e.getSource() == okButton){
			
			new UpdateCon().mine();
			
		}else if (e.getSource() == backButton){
			new GotoLogin().Back(paneMain);
		}else if (e.getSource() == exitButton){
			super.exit();
		}
		
	}
	
	@Override
	protected JPanel PrintJPanel() {
		// TODO Auto-generated method stub
		paneTop = new JPanel();
		paneTop.setLayout(new FlowLayout());
		titleLabel = new JLabel("�� ӭ �� ��");
		titleLabel.setFont(new Font("����",Font.BOLD,24));
		paneTop.add(titleLabel);
		
		paneCenter = new JPanel();
		paneCenter.setLayout(new GridLayout(7,2,30,30));
		sidLabel = new JLabel("ѧ��:",JLabel.TRAILING);
		sidText = new JTextField(15);
		sidText.setText(StaticType.getLoginInfo().getId()+"");
		sidText.setEditable(false);
		reNaLabel = new JLabel("��ʵ����:",JLabel.TRAILING);
		reNaText = new JTextField(15);
		reNaText.setText(StaticType.getLoginInfo().getString1());
		reNaText.setEditable(false);
		ageLabel = new JLabel("�༶:",JLabel.TRAILING);
		ageText = new JTextField(15);
		ageText.setText(StaticType.getLoginInfo().getString2());
		ageText.setEditable(false);
		classLabel = new JLabel("��ѧ:",JLabel.TRAILING);
		classText = new JTextField(15);
		classText.setText(StaticType.getLoginInfo().getString3());
		classText.setEditable(false);
		mathLabel = new JLabel("Ӣ��:",JLabel.TRAILING);
		mathText = new JTextField(15);
		mathText.setText(StaticType.getLoginInfo().getString4());
		mathText.setEditable(false);
		englishLabel = new JLabel("����:",JLabel.TRAILING);
		englishText = new JTextField(15);
		englishText.setText(StaticType.getLoginInfo().getString5());
		englishText.setEditable(false);

		paneCenter.add(sidLabel);
		paneCenter.add(sidText);
		paneCenter.add(reNaLabel);
		paneCenter.add(reNaText);
		paneCenter.add(ageLabel);
		paneCenter.add(ageText);
		paneCenter.add(classLabel);
		paneCenter.add(classText);
		paneCenter.add(mathLabel);
		paneCenter.add(mathText);
		paneCenter.add(englishLabel);
		paneCenter.add(englishText);
		
		paneEast = new JPanel();
		paneEast.setLayout(new GridLayout(4,1,30,30));
		passButton = new JButton("�޸�����(P)");
		passButton.setMnemonic(KeyEvent.VK_P);
		passButton.addActionListener(this);
		okButton = new JButton("�ύ�޸�(U)");
		okButton.setMnemonic(KeyEvent.VK_U);
		okButton.addActionListener(this);
		backButton = new JButton("����(B)");
		backButton.setMnemonic(KeyEvent.VK_B);
		backButton.addActionListener(this);
		exitButton = new JButton("�˳�(E)");
		exitButton.setMnemonic(KeyEvent.VK_E);
		exitButton.addActionListener(this);
		paneEast.add(passButton);
		paneEast.add(okButton);
		paneEast.add(backButton);
		paneEast.add(exitButton);
		
		JPanel paneEst = new JPanel();
		paneEst.setLayout(new BorderLayout(30,30));
		paneEst.add(paneEast,BorderLayout.CENTER);
		paneEst.add(new JLabel(),BorderLayout.EAST);
		
		paneMain = new JPanel();
		paneMain.setLayout(new BorderLayout(30,30));
		paneMain.setSize(500, 500);
		paneMain.add(paneTop,BorderLayout.NORTH);
		paneMain.add(paneCenter,BorderLayout.CENTER);
		paneMain.add(paneEst,BorderLayout.EAST);
		paneMain.add(new JLabel(),BorderLayout.SOUTH);
		
		return paneMain;
	}

}
