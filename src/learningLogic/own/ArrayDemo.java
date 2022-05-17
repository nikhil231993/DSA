package learningLogic.own;

import java.util.ArrayList;

public class ArrayDemo {

	public static void main(String[] args) {
		
		
		int[] array = {2, 4, 8, 12, 12, 4};
		
		int element=10;
		
		//System.out.println(howMany(array,element));
		
		//System.out.println(findMax(array));
		//System.out.println(maxArray(array));
		
		
		

	}
	private static int findMax(int[] array) {
		
	
	
		int max=0;
		for(int i=0;i<array.length-1;i++)
		{
			if(array[i]>array[i+1])
				max=array[i];
		}
		
		if(array.length ==0)
			return -1;
		
		return max;
	}
	
	public static ArrayList<Integer> maxArray(int[] array) {
		
		ArrayList<Integer> maxList=new ArrayList<Integer>();
		int count=0;
		int c=findMax(array);
		
	    for(int i=0;i<array.length;i++){
	    	  if(c ==array[i]) {
	    		  count++;
	    	  }
	    	  
	      }
	    
	    for(int i=0;i<count;i++)
	    	maxList.add(c);
	    
	    if(c==-1)
	    	return null;
		
		
		
		return maxList;
	}
	public static int howMany(int[] array, int element) {
	
        
        int count=0;
      for(int i=0;i<array.length;i++){
    	  if(element ==array[i])
    	  count++;
      }
	
		return count;
	}
	
	public void swapZero(int[] array) {
		// TODO Implement method
		
	}

}
