package leetcode.math.easy;

import java.util.Stack;

public class LC67AddTwoBinary {

	public static void main(String[] args) {

		String a = "1010";
		String b = "1011";

		//Approach 1: Best
		System.out.println(addBinary(a, b));

		//Approach 2: Better
		System.out.println(addBinaryWithoutStringBuilder(a, b));

		//Approach 3: Brute
		System.out.println(addBinaryWithStringAndStack(a, b));
	}

	public static String addBinaryWithStringAndStack(String a, String b) {

		int n=a.length(), m=b.length();
		int i=n-1, j=m-1;
		int carry=0, sum=0;

		Stack st=new Stack();
		String s="";
		while(i>=0 || j>=0){

			sum=carry;
			if(i>=0){
				sum+=(a.charAt(i--)-'0');
			}

			if(j>=0){
				sum+=(b.charAt(j--)-'0');
			}

			st.push(sum%2);
			carry=sum/2;
		}

		if(carry!=0)
			st.push(carry);

		while(!st.isEmpty())
			s+=st.pop();
		return s;

		//SC:O(n) for stack
		//TC:O(2 *n )
	}

	public static String addBinaryWithoutStringBuilder(String a, String b) {

		int n=a.length(), m=b.length();
		int i=n-1, j=m-1;
		int carry=0, sum=0;

		String s="";
		while(i>=0 || j>=0){

			sum=carry;
			if(i>=0){
				sum+=(a.charAt(i--)-'0');
			}

			if(j>=0){
				sum+=(b.charAt(j--)-'0');
			}

			s=sum%2+s;
			carry=sum/2;
		}

		if(carry!=0)
			s=carry+s;
		return s;
	}

	public static String addBinary(String a, String b) {

		int sum = 0;
		int carry = 0;
		int i = a.length() - 1, j = b.length() - 1;
		StringBuilder result = new StringBuilder();

		while (i >= 0 || j >= 0) {
			sum = carry;
			if (i >= 0) {
				sum += a.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += b.charAt(j--) - '0';
			}
			result.append(sum % 2);// we can use stack for this step. then we don't have to reverse as we can pop the ans in correct order
			carry = sum / 2;
		}
		if (carry != 0) { // we can use sum instead of carry
			result.append(carry);
		}
		return result.reverse().toString();

		// TC:O(n) where n is the length of larger string
		// SC:O(n+1) where n is the length of the larger string
	}
}
