package package4;

public class Father {
	private String name="FATHER";
	private int i=1;
	public Father() {
		whoAmI();
		tellName(name);
		tellValue(i);
	}
	public void whoAmI() {
		System.out.println("Father says, I am "+name+",i="+i);
	}
	public void tellName(String name) {
		System.out.println("Father's name is "+name+",i="+i);
	}
	public void tellValue(int i) {
		System.out.println("Father's name is "+name+",i="+i);
	}
}
