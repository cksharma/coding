package com.onmobile.training.swings;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame {
	JButton b1, b2, b3, b4;
	
	public MyFrame() {
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("Button3");
		b4 = new JButton("Button4");
		MyListener listener = new MyListener();
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		b4.addActionListener(listener);
		NextListener nextListener = new NextListener();
		b1.addActionListener(nextListener);
		b2.addActionListener(nextListener);
		b3.addActionListener(nextListener);
		b4.addActionListener(nextListener);
		setLayout(new FlowLayout());
		add(b1); add(b2); add(b3); add(b4);
	}
	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o = e.getSource();
			if(o == b1)
			{
				JOptionPane.showMessageDialog(null, "button1 clicked");
			}
			else if(o == b2)
			{
				JOptionPane.showMessageDialog(null, "button2 clicked");
			}
			else if(o == b3)
			{
				JOptionPane.showMessageDialog(null, "button3 clicked");
			}
			else if(o == b4)
			{
				JOptionPane.showMessageDialog(null, "button4 clicked");
			}
		} // end of action performed		
	} // end of MyListener
 // end of MyFrame

	class NextListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o = e.getSource();
			if(o == b1)
			{
				JOptionPane.showMessageDialog(null, "button1 clicked");
			}
			else if(o == b2)
			{
				JOptionPane.showMessageDialog(null, "button2 clicked");
			}
			else if(o == b3)
			{
				JOptionPane.showMessageDialog(null, "button3 clicked");
			}
			else if(o == b4)
			{
				JOptionPane.showMessageDialog(null, "button4 clicked");
			}
		} 	
	}
		
}
public class SwingTest {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 200);
		f.setVisible(true);
	}
}
