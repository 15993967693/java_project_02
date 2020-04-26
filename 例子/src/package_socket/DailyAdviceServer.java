package package_socket;
import java.io.*;
import java.net.*;

public class DailyAdviceServer {
	
	String[] adviceList= {"Yes","fake"};
	public void go() {
		try {
			ServerSocket serverSocket=new ServerSocket(4242);
			
			while(true) {
				Socket sock =serverSocket.accept();
				PrintWriter writer=new PrintWriter(sock.getOutputStream());
				String advice=getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private String getAdvice() {
		// TODO Auto-generated method stub
		int random=(int) (Math.random()*adviceList.length);
		return adviceList[random];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyAdviceServer server=new DailyAdviceServer();
		server.go();
	}

}
