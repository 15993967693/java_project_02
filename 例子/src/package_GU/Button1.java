package package_GU;
import javax.swing.*;
import java.awt.*;
public class Button1 {
	public static void main(String[] args) {
		Button1 gui=new Button1();
		gui.go();
	}

	private void go() {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame();
		JButton button=new JButton("Click me");
		Font bigFont=new Font("serif", Font.BOLD, 28);
		button.setFont(bigFont);
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
