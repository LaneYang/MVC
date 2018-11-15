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
import com.iotek.cont.FindStudent;
import com.iotek.cont.RemoveCon;
import com.iotek.cont.UpdateCon;
import com.luwenrui.abstractfather.GuiView;
import com.luwenrui.dao.Temp;
import com.luwenrui.staticType.StaticType;

public class FindStudentGui extends GuiView implements ItemListener {

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
	private JLabel englishLabel;
	private JLabel chineseLabel;

	private JTextField tidText;
	private JTextField tnameText;
	private JTextField tageText;
	private JTextField classText;
	private JTextField emploText;
	private JTextField englishText;
	private JTextField chineseText;

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
		if (e.getActionCommand().equals("������¼")) {
			oa = 1;
			GuiView.frame.remove(this.painMain);
			this.show();
		} else if (e.getActionCommand().equals("������¼")) {
			oa = 2;
			GuiView.frame.remove(this.painMain);
			this.show();
		}
		if (e.getSource() == okButton) {
			Temp tem = new Temp();
			tem.setId(Integer.parseInt(tidText.getText()));
			tem.setUsername(tnameText.getText());
			tem.setPassword(StaticType.getUpdateInfo().getPassword());
			tem.setString1(tageText.getText());
			tem.setString2(classText.getText());
			tem.setString3(emploText.getText());
			tem.setString4(englishText.getText());
			tem.setString5(chineseText.getText());
			StaticType.setUpdateInfo(tem);
			StaticType.getUpdateInfo().setType(2);
			new UpdateCon().other();
		} else if (e.getSource() == backButton) {
			GuiView.frame.remove(painMain);
			new TeacherGui().show();
		} else if (e.getSource() == updateButton) {
			if (oa == 2) {
				GuiMessage.showErr("������¼�����޸�");
			} else if (oa == 1) {
				tageText.setEditable(true);
				classText.setEditable(true);
				emploText.setEditable(true);
				englishText.setEditable(true);
				chineseText.setEditable(true);
			}
		} else if (e.getSource() == findButton) {
			if (ziduan == 1 && oa == 1) {
				String id = UpdatePassword.PassOption("�� ����Ҫ���ҵ�ѧ��");
				if (id != null) {
					new FindStudent().findOne(Integer.parseInt(id));
					tidText.setText(StaticType.getUpdateInfo().getId() + "");
					tnameText.setText(StaticType.getUpdateInfo().getUsername());
					tageText.setText(StaticType.getUpdateInfo().getString1());
					classText.setText(StaticType.getUpdateInfo().getString2());
					emploText.setText(StaticType.getUpdateInfo().getString3());
					englishText
							.setText(StaticType.getUpdateInfo().getString4());
					chineseText
							.setText(StaticType.getUpdateInfo().getString5());
				}
			} else if (ziduan == 2 && oa == 2) {
				String name = UpdatePassword.PassOption("������Ҫ���ҵ�����");
				if (name != null) {
					textAre.setText(new FindStudent().findOther(name));
				}
			} else if (ziduan == 3 && oa == 2) {
				String name = UpdatePassword.PassOption("������Ҫ���ҵİ༶");
				if (name != null) {
					textAre.setText(new FindStudent().findClassOther(name));
				}
			}
		} else if (e.getSource() == defauButton) {
			if (oa == 2) {
				GuiMessage.showErr("������¼����ɾ��");
			} else if (oa == 1) {
				String id = UpdatePassword.PassOption("�����ɾ����ѧ����");
				if (id != null) {
					new FindStudent().findOne(Integer.parseInt(id));
					StaticType.getUpdateInfo().setType(2);
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
		titleLabel = new JLabel("ѧ �� �� �� �� ��");
		titleLabel.setFont(new Font("����", Font.BOLD, 24));
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
		jc.addItem("ѧ��");
		jc.addItem("ѧ������");
		jc.addItem("�༶");
		jc.addItemListener(this);
		jcP.add(jc);

		JPanel jrbP = new JPanel();
		jrbP.setLayout(new GridLayout(1, 2, 30, 30));
		jrb1 = new JRadioButton("������¼");
		jrb1.addActionListener(this);
		jrb2 = new JRadioButton("������¼");
		jrb2.addActionListener(this);
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		jrbP.add(jrb1);
		jrbP.add(jrb2);

		findButton = new JButton("����(F)");
		findButton.setMnemonic(KeyEvent.VK_F);
		findButton.addActionListener(this);
		updateButton = new JButton("�޸�(U)");
		updateButton.setMnemonic(KeyEvent.VK_U);
		updateButton.addActionListener(this);
		defauButton = new JButton("ɾ��(D)");
		defauButton.setMnemonic(KeyEvent.VK_D);
		defauButton.addActionListener(this);
		okButton = new JButton("ȷ��(O)");
		okButton.setMnemonic(KeyEvent.VK_O);
		okButton.addActionListener(this);
		backButton = new JButton("����(B)");
		backButton.setMnemonic(KeyEvent.VK_B);
		backButton.addActionListener(this);
		exitButton = new JButton("�˳�(E)");
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
		String string = new String("ѧ��\t�û���\t����\t�༶\t��ѧ\tӢ��\t����\n");

		textAre = new JTextArea();
		textAre.setSize(600, 600);
		textAre.setLineWrap(true);
		textAre.setText(string);
		textAre.setPreferredSize(new Dimension(600, 600));
		textAre.setEditable(false);
		js = new JScrollPane(textAre);
		painCenter = new JPanel();
		painCenter.setSize(600, 600);
		painCenter.add(js);

		return painCenter;
	}

	public JPanel showOneTeacher() {
		JPanel painb = new JPanel();
		painb.setLayout(new BorderLayout());
		showOne = new JPanel();
		showOne.setPreferredSize(new Dimension(500, 500));
		showOne.setSize(500, 500);
		showOne.setLayout(new GridLayout(7, 2, 30, 30));

		tidLabel = new JLabel("ѧ��:", JLabel.TRAILING);
		tidText = new JTextField(15);
		tidText.setEditable(false);

		tnameLabel = new JLabel("ѧ���ʺ�:", JLabel.TRAILING);
		tnameText = new JTextField(15);
		tnameText.setEditable(false);

		tageLabel = new JLabel("ѧ������:", JLabel.TRAILING);
		tageText = new JTextField(15);
		tageText.setEditable(false);

		classLabel = new JLabel("ѧ���༶:", JLabel.TRAILING);
		classText = new JTextField(15);
		classText.setEditable(false);

		emploLabel = new JLabel("��ѧ�ɼ�:", JLabel.TRAILING);
		emploText = new JTextField(15);
		emploText.setEditable(false);

		englishLabel = new JLabel("Ӣ��ɼ�:", JLabel.TRAILING);
		englishText = new JTextField(15);
		englishText.setEditable(false);

		chineseLabel = new JLabel("Ӣ��ɼ�:", JLabel.TRAILING);
		chineseText = new JTextField(15);
		chineseText.setEditable(false);

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
		showOne.add(englishLabel);
		showOne.add(englishText);
		showOne.add(chineseLabel);
		showOne.add(chineseText);

		painb.add(showOne, BorderLayout.CENTER);
		painb.add(new JLabel(), BorderLayout.EAST);
		return painb;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		String s = (String) e.getItem().toString();
		if (s.equals("ѧ��")) {
			ziduan = 1;
		} else if (s.equals("ѧ������")) {
			ziduan = 2;
		} else if (s.equals("�༶")) {
			ziduan = 3;
		}
	}
}
