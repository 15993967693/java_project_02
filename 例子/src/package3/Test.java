package package3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		B b=new B();
		A c=new B();
		System.out.println("a.i="+a.i+","+"a.j="+a.j+","+"a.plus()="+a.plus());
									//调用A中的plus(),i为A中的
		System.out.println("b.i="+b.i+","+"b.j="+b.j+","+"b.k="+b.k+","+"b.plus()="+b.plus());
									//调用B中的plus(),i为B中的
		//System.out.println("c.i="+c.i+","+"c.j="+c.j+","+"c.k="+c.k+","+"c.plus()="+c.plus());
									//k是B中增加的，上转型对象只能调用重写
		System.out.println("c.i="+c.i+","+"c.j="+c.j+","+"c.plus()="+c.plus());
	}

}
