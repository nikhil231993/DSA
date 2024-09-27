package leetcode.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {

        System.out.println("++++++++");
        String s="Nikhil";

        char[] ch=s.toCharArray();
        ch[0]='k';
        System.out.println(s);
        System.out.println(ch);

        System.out.println("++++++++");

        System.out.println((char)(0+'a'));

        System.out.println("####################");

        int[] orig=new int[10];
        Arrays.fill(orig,-1);

        int[] copy=orig;

        copy[0]=0;

        for(int i=0;i<10;i++)
            System.out.println(orig[i]);

//        System.out.println(6%100);

//        System.out.println(1>>1);
//        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
//        pq.add(10);
//        pq.add(2);
//        pq.add(100);
//
//        pq.poll();
//        for(Integer n:pq)
//            System.out.println(n);
//
//        TreeSet<Integer> t=new TreeSet<>();
//        t.add(1);
//        t.add(100);
//        t.add(2);
//        System.out.println(t);
//        t.remove(100);
//        System.out.println(t);
    }
}
