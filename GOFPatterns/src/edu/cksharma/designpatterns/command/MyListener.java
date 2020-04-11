package edu.cksharma.designpatterns.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Command cmd = (Command)e.getSource();
		cmd.execute();
	}
}