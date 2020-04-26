package package_Thread;

public class RyanAndMonicaJob implements Runnable{
	
	private BankAccount account=new BankAccount();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RyanAndMonicaJob theJob=new RyanAndMonicaJob();
		Thread one=new Thread(theJob);
		Thread two=new Thread(theJob);
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x=0;x<10;x++) {
			makeWithdrawal(10);
			if(account.getBalance()<10) {
				System.out.println("Overdrawn");
			}
		}
	}

	private void makeWithdrawal(int amount) {
		// TODO Auto-generated method stub
		if (account.getBalance()>=amount) {
			System.out.println(Thread.currentThread().getName()+"is about to withdraw");
			try {
				System.out.println(Thread.currentThread().getName()+"is about to sleep");
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"woke up");
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+"completes the withdrawl");
		} else {
			System.out.println("Sorry ,not enough for "+Thread.currentThread().getName());
		}
	}

}
