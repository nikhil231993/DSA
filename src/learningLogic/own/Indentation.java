package learningLogic.own;

import java.util.ArrayList;
import java.util.Scanner;

public class Indentation {

	public static void main(String[] args) {

		// char a='c';
		// int n=a-32;
		// System.out.println((char)n);
		// TODO Implement method
		String arg = "bcdxyz@3210.";
		String str = "Hello 90, bye 2";

		String strNew = null;
//		int n = 0;
		char s = 0;
		/*
		 * char[] args1=arg.toCharArray();
		 * 
		 * for (int i = 0; i < arg.length(); i++) { if (str.charAt(i) >= 97 &&
		 * str.charAt(i) <= 122) { if(arg.contains(Character.toString(str.charAt(i))) ||
		 * arg.contains(Character.toString(str.charAt(i)).toUpperCase())){ n = (int)
		 * str.charAt(i) - 32; s = (char) (n); str =
		 * str.replace(String.valueOf(str.charAt(i)), String.valueOf(s)); } } else if
		 * (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
		 * if(arg.contains(Character.toString(str.charAt(i))) ||
		 * arg.contains(Character.toString(str.charAt(i)).toLowerCase())){ n = (int)
		 * str.charAt(i) + 32; s = (char) (n); str =
		 * str.replace(String.valueOf(str.charAt(i)), String.valueOf(s)); } }
		 * 
		 * 
		 * } System.out.println(str);
		 */

		char n = 'h';
		boolean more = false;
		//str= str.toLowerCase();
		

		for (int i = 0; i < str.length(); i++) {
			if ( str.charAt(i) >= n && more && (str.charAt(i)>=97 && str.charAt(i) <=122) || (str.charAt(i)>=65 && str.charAt(i) <=90)) {
				strNew = str.replace(String.valueOf(str.charAt(i)), "");
				str = strNew;
				i--;
			}
			else if (str.charAt(i) <= n  && !more && (str.charAt(i)>=97 && str.charAt(i) <=122) || (str.charAt(i)>=65 && str.charAt(i) <=90)) {
				strNew = str.replace(String.valueOf(str.charAt(i)), "");
				str = strNew;
				i--;
			}

		}
		
		
		
		System.out.println(str);

		/*
		 * String arg="6,.a";
		 * 
		 * if (arg.matches("[^a-zA-Z]+")) { System.out.println("No letters"); } String
		 * str="my lucky numbers are 6, 8, and 19."; String strNew=null;
		 * 
		 * if( strNew == null || strNew.trim().isEmpty() ) {
		 * System.out.println("Empty string"); } // char[] args1=arg.toCharArray();
		 * 
		 * for(int i=0;i<arg.length();i++) { if(!(arg.charAt(i) >= '0' && arg.charAt(i)
		 * <= '9')) { strNew = str.replace(String.valueOf(arg.charAt(i)), "");
		 * str=strNew; } }
		 * 
		 * 
		 * System.out.println(strNew);
		 */

		// ArrayList<String> myList = new ArrayList<String>();
		// return the first element of the list
		// String firestString = myList.get(0);
		/*
		 * Scanner scan=new Scanner(System.in); int input=scan.nextInt();
		 * 
		 * Indentation id=new Indentation();
		 * 
		 * System.out.println(id.convertTime(seconds));
		 * System.out.println(id.digitsSum(input));
		 * 
		 * System.out.println(155%10);
		 */

	}
	/*
	 * public String convertTime(int seconds) { String result; if(seconds == 0
	 * ||seconds < 0 ) result=seconds+":"+seconds+":"+seconds; else{ int hrs=0; int
	 * mins=0; int sec=0; hrs=seconds/3600; int remMins=seconds%3600;
	 * mins=remMins/60; sec=remMins%60; result=hrs+":"+mins+":"+sec; } return
	 * result; }
	 */
	/*
	 * public int digitsSum(int input) { int result=0; if(input > 0 && input < 10)
	 * result=input; else if(input >10){ while(input >0) { int remNum=input%10;
	 * result+=remNum; input=input/10;
	 * 
	 * } } return result; }
	 */
}
