package learningLogic.own;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomList {

	public ArrayList<Integer> arr = new ArrayList<Integer>();

	public CustomList() {
		this.arr.add(2);
		this.arr.add(3);
		this.arr.add(4);
		this.arr.add(5);
		this.arr.add(6);
	//	this.arr.add(8);
	}

	public int get(int index) {
		// TODO Implement method
		for (int i = 0; i < this.arr.size(); i++) {
			if (i == index)
				return this.arr.get(index);
		}
		return -1;
	}

	public void add(int element) {

		this.arr.add(element);
		this.arr.add(0, -1);
		System.out.println(this.arr);
	}

	public void remove(int num, int element) {
		int count=0;
		for (int i = 0; i < this.arr.size() && num!=count; i++) {
			
				if (this.arr.get(i) == element) {
					this.arr.remove(i);
				count++;
				i--;
				}
				
			
			}	

		System.out.println(this.arr);
	}

	public ArrayList<Integer> splice(int index, int num) {

	
		int count=0;
		int[] ar1= {4,5};
        ArrayList<Integer> arrNew=new ArrayList<Integer>();
        if(index < 0 || index >=this.arr.size() || num==0 )
            return arrNew;
        
        for (int i = index; i < this.arr.size() && count!=num; i++) {
        		arrNew.add(this.arr.get(i));
        		this.arr.remove(i);
        		count++;
        		i--;    		
        	
        }
        System.out.println(this.arr);
      
		return arrNew;
	}
	
	public ArrayList<Integer> splice(int index, int num, int[] otherArray) {
        int count=0;
        
        ArrayList<Integer> arrNew=new ArrayList<Integer>();
        
        ArrayList<Integer> arrNewValue=new ArrayList<Integer>();
        if(index < 0 || index >=this.arr.size() || num==0 )
            return arrNew;
        
        CustomList cia=new CustomList();
        arrNewValue=cia.splice(index,num);
        
        for (int i = index; i < this.arr.size() && count!=num; i++) {
    		arrNew.add(this.arr.get(i));
    		this.arr.remove(i);
    		count++;
    		i--;    		
    	
    }        
         ArrayList<Integer> intList = new ArrayList<Integer>(otherArray.length);
        for (int i : otherArray){
            intList.add(i);
        }
        
        System.out.println("Before: "+this.arr);
        
        this.arr.addAll(index, intList);
        System.out.println("Appended: "+this.arr);
      
		return arrNewValue;
	}
	
	public static void main(String[] args) {

		CustomList cl = new CustomList();

		// System.out.println(cl.get(2));

		// cl.add(22);

		//cl.remove(, 5);
		cl.splice(3,1,new int[] { 4, 5 });

	}

}
