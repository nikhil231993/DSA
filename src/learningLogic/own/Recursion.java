package learningLogic.own;

public class Recursion {

	public static void main(String[] args) {
		foo(3);
		System.out.println("Main Done");

	}

	private static void foo(int i) {
		int a=0;
		if(i<1)
			return;
		else
			foo(i-1);
		
		System.out.println("Hellow World " +i);
		
	}

}
