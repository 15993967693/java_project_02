package Р§зг1;

public class Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer a=new StringBuffer("ok");
		int i=5;
		System.out.println("Before change a is "+a);
		change(a);
		System.out.println("After change a is "+a);
		
	}
	public static void change(StringBuffer ia) {
		ia.append("ok");
	}
	public static void change(int li) {
		li=10;
	}

}
