package geeksForGeeks;


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class removeDuplicatesButKeepInsertionOrder {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = scan.nextInt();
		System.out.println("Enter the elemets of the array: ");
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = scan.nextInt();

		Set<Integer> s = new LinkedHashSet<Integer>();
		
	
		for (int i = 0; i < arr.length; i++) {

			if (!s.contains(arr[i])) {
			s.add(arr[i]);
			}
		}
		System.out.println("arraylist is: " + s);
		for(Integer a:s)
			System.out.println(a);
	

		scan.close();
	}

}
