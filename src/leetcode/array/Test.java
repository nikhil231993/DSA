package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        System.out.println(-5%5);

        System.out.println(Math.random()*1000);

        String nam="Nikhil";
        String name="Tes";
        System.out.println(nam.hashCode());
        System.out.println(name.hashCode());

        int a1=4;
        int b1=4;
        System.out.println(a1&b1);
        System.out.println("########");

        int xor=0;
        xor^=21;
        System.out.println(xor);

//		String c = "N";
//		int[] a = new int[27];
//		for(int i=0;i<c.length();i++) {
//			a[c.charAt(i) - 'A']++;
//		}
//
//		for (int i = 0; i < 27; i++)
//			System.out.println((char) (i + 65));

//		int a=60%60;
//		System.out.println(a);

        int[] arr=new int[]{1,2};
        List<Integer> list= Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);

        PriorityQueue<Double> pq=new PriorityQueue<>((a,b)->Double.compare(b,a));
        pq.offer(0.1);
        pq.offer(0.8);

        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }
}
