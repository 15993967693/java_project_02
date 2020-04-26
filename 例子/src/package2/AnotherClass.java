package package2;
import package1.*;

public class AnotherClass {
	void limit() {
		//SuperClass.i++;	//i在本包内，现在是在另一个包中访问，所以不行
		//SuperClass.j--;	//j在本包或子类中可访问，现在是在外包，而且也不是子类
		//SuperClass.k++;	//SuperClass的私有成员只能在本类中访问
		SuperClass1.m--;		//公有权限，任何地方都能访问
	}
}
