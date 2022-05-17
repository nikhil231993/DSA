package learningLogic.own;

import java.util.ArrayList;
import java.util.List;

public class RetainAndRemove {

	public static void main(String[] args) {
		List<Integer> fullList=new ArrayList<Integer>();
		fullList.add(1);
		fullList.add(2);
		fullList.add(3);
		fullList.add(4);
		fullList.add(5);
		fullList.add(6);
		fullList.add(7);
		fullList.add(8);		
		fullList.add(9);
		fullList.add(10);
		
		List<Integer> clinetList=new ArrayList<Integer>();
		clinetList.add(1);
		clinetList.add(2);
		
	
		List<String> forbiddenList = new ArrayList(clinetList);

		List<String> retainedList = new ArrayList(clinetList);

		
		retainedList.retainAll(fullList);
		
        forbiddenList.removeAll(retainedList);
		
		System.out.println("full list: "+fullList);
		System.out.println("Forbidden list: "+forbiddenList);
		System.out.println("reatined list: "+retainedList);
	}

}
