package leetcode.string.medium;

import java.util.Stack;

public class LC227BasicCalculator2 {

	public static void main(String[] args) {
		
		String s = " 3-5 / 2 ";
	    System.out.println(calculate(s));
	}

	public static int calculate(String s) {

		int length = s.length();
		if (length == 0) return 0;
		Stack<Integer> stack=new Stack();
		char ch;
		int currentNumber=0;
		char operation='+';
		for(int i=0;i<s.length();i++){
			ch=s.charAt(i);
			if(Character.isDigit(ch)){
				currentNumber=currentNumber*10 + ch-'0';
			}
			if(!Character.isDigit(ch) && ' '!=ch || i==s.length()-1){
				if(operation=='+'){
					stack.push(currentNumber);
				}else if(operation=='-'){
					stack.push(-currentNumber);
				}else if(operation=='*'){
					int lastNumber=stack.pop();
					stack.push(lastNumber*currentNumber);
				}else if(operation=='/'){
					int lastNumber=stack.pop();
					stack.push(lastNumber/currentNumber);
				}
				operation=ch;
				currentNumber=0;
			}
		}
		int result=0;
		while(!stack.isEmpty()){
			result+=stack.pop();
		}
		return result;
		//TC:O(n)
		//SC:O(n) in worst case where all the characters are pushed into stack
	}
}
