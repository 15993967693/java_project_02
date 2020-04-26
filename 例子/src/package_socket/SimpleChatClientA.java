package package_socket;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClientA {
	JTextArea incoming;
	JTextField  outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	
	public void go() {
		JFrame frame=new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel=new JPanel();
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScrollPane=new JScrollPane(incoming);
		qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		outgoing=new JTextField(20);
		JButton sendButton=new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		mainPanel.add(qScrollPane);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		setUpNetworking();
		Thread readerThread=new Thread(new IncomingReader());
		readerThread.start();
		
		frame.setSize(400, 500);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleChatClientA().go();

	}
	public class SendButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
		
	}
	public void setUpNetworking() {
		try {
			sock=new Socket("127.0.0.1", 5000);
			InputStreamReader streamReader=new InputStreamReader(sock.getInputStream());
			reader=new BufferedReader(streamReader);
			//writer=new PrintWriter(sock.getOutputStream());
			writer=new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
			System.out.println("newworking established");
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public class IncomingReader implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String message;
			try {
				while((message=reader.readLine())!=null) {
					System.out.println("read "+message);
					incoming.append(message+"\n");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}

}
