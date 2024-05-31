package leetcode.math.medium;

public class LC8StringToIntegerAtoi {

	public static void main(String[] args) {

		//String s = "2147483648";
		String s = "2147483646";

		//Approach 1:
		System.out.println(myAtoi(s));

		//Approach 2:
		System.out.println(myAtoiBetter(s));
	}

	private static int myAtoiBetter(String s) {

		int i = 0;
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		if (s.length() == i)
			return 0;

		int sign = 1;
		if (s.charAt(i) == '-') {
			sign = -1;
			i++;
		} else if (s.charAt(i) == '+') {
			sign = 1;
			i++;
		}
		int ans = 0;
		while (i < s.length() && ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57)) {

			int no= s.charAt(i) - '0';
			if(ans>(Integer.MAX_VALUE-no)/10){
				if(sign==-1)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
			}
			ans=ans*10+no;
			i++;
		}
		return ans * sign;
	}

	public static int myAtoi(String s) {

		int i = 0;
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		if (s.length() == i)
			return 0;

		int sign = 1;
		if (s.charAt(i) == '-') {
			sign = -1;
			i++;
		} else if (s.charAt(i) == '+') {
			sign = 1;
			i++;
		}
		long ans = 0;
		while (i < s.length() && ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57)) {
			ans = ans * 10 + s.charAt(i) - '0';
			if (sign == 1 && ans > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && -1 * ans < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			i++;
		}
		return (int) ans * sign;
	}

	//If u see in below case it will fail for input "2147483648" because in it will go out of range in next step whereas in reverseInteger case the input is within range

//	public int myAtoi(String s) {
//
//		int i = 0;
//		while (i < s.length() && s.charAt(i) == ' ') {
//			i++;
//		}
//		if (s.length() == i)
//			return 0;
//
//		int sign = 1;
//		if (s.charAt(i) == '-') {
//			sign = -1;
//			i++;
//		} else if (s.charAt(i) == '+') {
//			sign = 1;
//			i++;
//		}
//		int ans = 0;
//		while (i < s.length() && ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57)) {
//			if(ans>Integer.MAX_VALUE/10 && sign==1)
//				return Integer.MAX_VALUE;
//			else if(sign ==-1 && (-1*ans)<Integer.MIN_VALUE/10)
//				return Integer.MIN_VALUE;
//			ans=ans*10+ s.charAt(i) - '0';
//			i++;
//		}
//		return ans * sign;
//	}
}
