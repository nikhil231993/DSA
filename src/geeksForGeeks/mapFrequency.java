package geeksForGeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class mapFrequency {

	public static void main(String[] args)
	{
		Map<Integer,Integer> hm=new HashMap<Integer, Integer>();
		hm.put(1, 10);
		hm.put(2, 20);
		hm.put(3, 30);
		hm.put(4, 40);
		hm.put(5, 50);
		Set<Entry<Integer, Integer>> itr= hm.entrySet();
		for(Entry<Integer,Integer> a:itr)
		{
			if(a.getKey()%2==0)
				System.out.println(a.getValue());
		}
	}

}
