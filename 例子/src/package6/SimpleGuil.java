package package6;
import javax.swing.*;
import java.awt.event.*;
public class SimpleGuil implements ActionListener{
	JButton button;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleGuil guil=new SimpleGuil();
		guil.go();
	}
	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("click me");
		button.addActionListener(this);
		button.addActionListener(new A());
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		button.setText("I've been clicked");
	}

}
class A implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JFrame frame1 = new JFrame();
		JButton button1;
		button1 = new JButton("lingyige");
		
		frame1.getContentPane().add(button1);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(300, 300);
		frame1.setVisible(true);
		//System.out.println("ÁíÒ»¸ö¼àÌý");
	}
	
}
