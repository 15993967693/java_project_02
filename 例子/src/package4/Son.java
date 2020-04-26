package package4;

public class Son extends Father {
	private String name="SON";
	private int i=2;
	public Son() {
		whoAmI();
		tellName(name);
		tellValue(i);
	}
	public void whoAmI(){
		System.out.println("Son says ,I am "+name+",i="+i);
	}
	public void tellName(String name) {
		System.out.println("Son's name is "+name+",i="+i);
	}
	public void tellValue(int i) {
		System.out.println("Father's name is "+name+",i="+i);
	}
}
