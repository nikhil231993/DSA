package leetcode.graph;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Set<List<String>> set=new HashSet<>();
        List<String> list1=new ArrayList<>();
        list1.add("Nikhil");
        list1.add("Kavya");

        List<String> list2=new ArrayList<>();
        list2.add("Nikhil");
        list2.add("Kavya");
        set.add(list1);
        set.add(list2);

        System.out.println(set.size());

        System.out.println("++++++++");
        String s="Nikhil";

        char[] ch=s.toCharArray();
        ch[0]='k';
        System.out.println("Original word:" + s);
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
