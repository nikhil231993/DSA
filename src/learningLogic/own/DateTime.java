package learningLogic.own;

public class DateTime {
	
	public static void main(String[] args)
	{
		String a="2020-12-13 22:47:42.132";
		StringBuilder b=new StringBuilder(a).append("Z");
		System.out.println(b);
	}

}
