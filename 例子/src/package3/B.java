package package3;

public class B extends A {
	int i=10,k=20;		//i与父类同名，隐藏了父类的i
	int plus() {
		return i+k+j;	//覆盖了父类的同名方法
	}
}
