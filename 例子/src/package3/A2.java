package package3;

public class A2 {
	static int i=1,j=2;
	static int plus() {		//不可将static去掉，静态的不能覆盖实例的
		return i+j;
	}
}
