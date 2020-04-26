package package3;

public class B2 extends A2 {
	static int i=10,k=20;		//i与父类同名，隐藏了父类的i
	static int plus() {			//覆盖了父类的同名方法，如果将static去掉不行，实例的不能覆盖静态的
		return j+i+k;
	}
}
