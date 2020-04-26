package package_Thread;

public class ThreadTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable thRunnable=new MyRunnable();
		Thread myThread=new Thread(thRunnable);
		Runnable theRunable1=new MyRunnable1();
		Thread myThread2=new Thread(theRunable1);
		
		myThread.start();
		myThread2.start();
		System.out.println("Ö÷Ïß³Ì");
		
	}

}
