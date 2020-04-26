package package6;

import java.util.jar.Attributes.Name;

public class Animal {
	private static final String Name = null;
	private String name;
	public static int A;
	public String getName() {
		return name;
	}
	public Animal(String thename) {
		name=thename;
		System.out.println(name);
	}
	public static String get() {
		
		System.out.println("static");
		return Name;
	}
	public void name() {
		A=0;
		get();
	}
}
