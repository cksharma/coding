package com.onmobile.training.command;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MyFrame extends JFrame 
{
	public MyFrame() 
	{
		Button1 b1 = new Button1();
		Button2 b2 = new Button2();
		//b1.setSize(80, 80);
		//b2.setSize(80, 80);
		//b1.setName("Button 1");
		//b2.setName("Button 2");
		setLayout(new FlowLayout());
		MyListener listener = new MyListener();
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		add(b1);
		add(b2);
	}
}
