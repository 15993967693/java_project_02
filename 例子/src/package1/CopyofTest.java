package package1;

public class CopyofTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperClass sup=new SuperClass();
		SubClass sub=new SubClass();
		SuperClass supsub=new SubClass();
		System.out.println("sup.i="+sup.j);
		//System.out.println(supsub.j);
		System.out.println(supsub.plus());
	}

}
