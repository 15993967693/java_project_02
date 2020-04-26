package package2;
import package1.*;
public class SubClass2 extends SuperClass1 {
	void limit() {
		//SuperClass.i++;	//i在本包内可访问，现在是在另一个包中访问，所以不行
		//j++;				//父类实例成员j，可以继承
		//super.j++;			//父类实例成员j，可以用super调用
		
		SuperClass.j1--;	//父类static成员j1，用类名可以调用
		
		j1++;				//父类static成员j1，可以继承
		
		//SuperClass.k++;	//SuperClass的私有成员只能在本类访问
		SuperClass1.m--;		//公有权限，任何地方都可访问
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperClass1 sup=new SuperClass1();
		//System.out.println(sup.j++);//父类成员j，用对象不可以调用
		//sup.limit();//父类成员j，用对象不可以调用
		System.out.println(sup.j1++);
	}

}
