package package1;

public class SuperClass {
	//static int i;			//同包中所有类中可见
	//protected int j;		
	protected static int j1;
	private static int k;	//只有本类内可见
	public static int m;	//任何地方可见
	
	private int i=1;
	int j=2;
	int plus() {
		return j+i;
	}
	
	
}
