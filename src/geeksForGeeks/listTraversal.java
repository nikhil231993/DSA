package geeksForGeeks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class listTraversal {

	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the size");
		int n=scan.nextInt();
		List<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			al.add(scan.nextInt());
		Iterator<Integer> itr=al.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		scan.close();
		
	}

}
