package learningLogic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AddTwoMap {

	public static void main(String[] args) {
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("test1", "test1");
		m1.put("test2", "test2");

		Map<String, String> m2 = new HashMap<String, String>();
		m1.put("test3", "test3");
		m1.put("test4", "test4");

		List<Map<String, String>> r = new LinkedList<>();
		r.add(m1);
		r.add(m2);

		System.out.println(r);
	}

}
