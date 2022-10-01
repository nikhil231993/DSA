package learningLogic;

import java.util.Hashtable;

public class HashTable {

	public static void main(String[] args) {
		Hashtable<Object, String> ht1 = new Hashtable<>();
		ht1.put("test", "test");
//		ht1.put(null, "test");
		
		

		System.out.println(ht1.get("test"));


	}

}
