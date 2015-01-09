package com.onmobile.training.command;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Button2 extends JButton implements Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Button2 clicked");
	}
}
