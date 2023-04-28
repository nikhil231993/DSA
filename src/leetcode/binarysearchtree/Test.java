package leetcode.binarysearchtree;


import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println(10+5<<2);
        System.out.println(10+(5<<2));
        System.out.println(3<<1<<0);
        System.out.println(3<<1<<1);
        System.out.println(3<<1<<2);
        System.out.println(20/3);
//      Node node=new Node(10);
//      map(node);
//
//        System.out.println("I m back");
//        System.out.println(node.hashCode());
//        System.out.println(node.data);

//        List<Integer> list=new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        list.add(40);
//        map(list);
//        for(Integer n:list)
//            System.out.println(n);

//        String s="Nikhil";
//        map(s+"Thulaseedharan");
//        System.out.println(s);

        String s="Nikhil";
        String n="Thulaseedharan";
        swap(s,n);

        System.out.println(s +" "+n);

    }

    private static void swap(String s, String n) {
        String temp=s;
        s=n;
        n=temp;
        System.out.println(s +" "+n);
    }

    public static void map(String s){
        System.out.println(s);
//        node.data=1000;
//        node=new Node(100);
//        node.data=1;
//        System.out.println(node.hashCode());
//        System.out.println(node.data);

//        list=new ArrayList<Integer>();
//        list.add(100);
//        list.add(200);
//        list.add(300);
//        list.add(400);
//        System.out.println("Difference: ");
//        for(Integer n:list)
//            System.out.println(n);

    }
}
