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

import com.iotek.Joption.GuiMessage;
import com.iotek.cont.LoginGoto;
import com.luwenrui.abstractfather.GuiView;
import com.luwenrui.panduan.PanDuan;
import com.luwenrui.staticType.StaticType;

public class LoginGui extends GuiView {

	private int num = 1;
	private JPanel painMain;
	private JPanel painTop;
	private JPanel painCenter;
	private JPanel painTail;
	
	private JLabel loginLabel;
	private JLabel nameLabel;
	private JLabel passLabel;
	
	private JTextField nameText;
	private JPasswordField passText;
	
	private JButton okButton;
	private JButton regiButton;
	private JButton exitButton;
	
	public void show(){
		super.Show(this.PrintJPanel());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Boolean boo = false;
		if (e.getSource() == okButton){
			String name = nameText.getText();
			char[] passTemp = passText.getPassword();
			String pass = new String(passTemp);
			boo = new PanDuan().NamePd(name);
			if (boo){
				boo = new PanDuan().PwdPd(pass);
				if (boo){
					boo = new PanDuan().Login(name, pass);
					if (boo){
						//根据类型跳转
						int i = StaticType.getLoginInfo().getType();
						GuiView.frame.remove(painMain);
						new LoginGoto().Goto(i);
					}	
				}
			}
			
			if (!boo){
				GuiMessage.showErr("您已经登录失败"+num+"次");
				num++;
				if (num == 4){
					super.exit();
				}
			}
			
		}else if (e.getSource() == regiButton){
			GuiView.frame.remove(painMain);
			new RegiGui().show();
		}else if (e.getSource() == exitButton){
			super.exit();
		}
		
	}

	@Override
	protected JPanel PrintJPanel() {
		// TODO Auto-generated method stub
		painMain = new JPanel();
		painMain.setLayout(new BorderLayout(30,30));
		painMain.setSize(500, 200);
		
		painTop = new JPanel();
		painTop.setLayout(new FlowLayout());
		
		painCenter = new JPanel(new BorderLayout(30,30));
		JPanel painc= new JPanel(new GridLayout(2,2,30,30));
		
		painTail = new JPanel(new BorderLayout(30,30));
		JPanel painButton = new JPanel(new GridLayout(1,3,20,20));
		
		loginLabel = new JLabel("登   录");
		loginLabel.setFont(new Font("宋体",Font.BOLD,24));
		painTop.add(loginLabel);
		
		nameLabel = new JLabel("用户名：",JLabel.TRAILING);
		nameText = new JTextField(20);
		passLabel = new JLabel("密     码：",JLabel.TRAILING);
		passText = new JPasswordField(20);
		passText.setEchoChar('*');
		painc.add(nameLabel);
		painc.add(nameText);
		painc.add(passLabel);
		painc.add(passText);
		painCenter.add(new JLabel(),BorderLayout.EAST);
		painCenter.add(new JLabel(),BorderLayout.WEST);
		painCenter.add(painc,BorderLayout.CENTER);
		
		okButton = new JButton("登 录(L)");
		okButton.setMnemonic(KeyEvent.VK_L);
		okButton.addActionListener(this);
		regiButton = new JButton("注 册(R)");
		regiButton.setMnemonic(KeyEvent.VK_R);
		regiButton.addActionListener(this);
		exitButton = new JButton("退 出(E)");
		exitButton.setMnemonic(KeyEvent.VK_E);
		exitButton.addActionListener(this);
		painButton.add(okButton);
		painButton.add(regiButton);
		painButton.add(exitButton);
		
		painTail.add(new JLabel(),BorderLayout.WEST);
		painTail.add(new JLabel(),BorderLayout.EAST);
		painTail.add(new JLabel(),BorderLayout.SOUTH);
		painTail.add(painButton,BorderLayout.CENTER);
		
		painMain.add(painTop,BorderLayout.NORTH);
		painMain.add(painCenter,BorderLayout.CENTER);
		painMain.add(painTail,BorderLayout.SOUTH);
		return painMain;
	}
}
