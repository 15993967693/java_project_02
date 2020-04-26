package package_Thread;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		go();
	}
	public void go() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doMore();
	}
	public void doMore() {
		System.out.println("Ïß³ÌA");
		
	}

}
