package package_GU;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TwoButtons {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoButtons gui=new TwoButtons();
		gui.go();
	}

	public void go() {
		// TODO Auto-generated method stub
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton labelButton=new JButton("Change Label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton=new JButton("Change Circle");
		colorButton.addActionListener(new ColorListener());
		
		label =new JLabel("I'm a label");
		MyDrawerPanel drawerPanel=new MyDrawerPanel();
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawerPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			label.setText("Ouch");
		}
	}
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}
	
	
}
