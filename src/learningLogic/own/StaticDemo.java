package learningLogic.own;

import java.util.ArrayList;

public class StaticDemo {

	static ArrayList<StaticDemo> list1 = new ArrayList<StaticDemo>();
	
	static final int a=10;
	
	public StaticDemo(){
		
	}

	String name=null;
	public StaticDemo(String s)
	{
		this.name=s;
		StaticDemo.list1.add(this);
		//this.a=20;
	}
	
	public static void main(String[] args)
	{
		StaticDemo s1=new StaticDemo("Nikhil");
		StaticDemo s2=new StaticDemo("Kavya");
		
		for(StaticDemo s:StaticDemo.list1)
		{
			System.out.println(s.name);
		}
		
		StaticDemo a= new StaticDemo();
		a.myPrint(5);
	}
	
	public boolean equals(Object obj)
	{
		return true;
	}
	
	public void myPrint(double a) {
		System.out.println(a);
		System.out.println(this.a);
	}
	
	
	
}
