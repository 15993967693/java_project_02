package package_GU;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {
	JFrame frame;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.repaint();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleGui3C gui3c=new SimpleGui3C();
		gui3c.go();
	}
	public void go() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button=new JButton("Change colors");
		button.addActionListener(this);
		
		MyDrawerPanel drawPanel=new MyDrawerPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}
