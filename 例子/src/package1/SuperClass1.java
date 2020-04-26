package package1;

public class SuperClass1 extends SuperClass{
	void limit() {
		//SuperClass.i++;					//i在本包内可访问，super代表父类
		SuperClass.j1++;				//j在本包或子类中可访问
		SuperClass a=new SuperClass();	//实例成员用对象访问
		a.j++;
		//SuperClass.k++;				//SuperClass的私有成员在另一个类中不能访问
		SuperClass.m--;					//公有权限，任何抵挡都可访问
	}
}
