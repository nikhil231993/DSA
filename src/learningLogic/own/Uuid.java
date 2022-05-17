package learningLogic.own;

import java.util.HashMap;
import java.util.UUID;

public class Uuid {

	public static void main(String[] args) {
		String str="2021-03-24T19:16:28.247Z";

		//String newStr = str.substring(0, str.indexOf("T"));
		//String lastStr=str.substring((str.indexOf("T"))+1, str.indexOf("."));
		System.out.println( str.substring(0, str.indexOf("T"))+" "+str.substring((str.indexOf("T"))+1, str.indexOf(".")));
		HashMap<Integer, String> h=new HashMap<Integer, String>();


	}

}
