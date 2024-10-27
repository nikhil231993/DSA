package leetcode.designPatterns.behaviourial.iterator;

import java.util.*;
import java.util.Iterator;

public class BasicsUnderstandingIteratorBehaviour {

    public static void main(String[] args) {

        //Here client does not bother how the data has to fetched.
        //It only needs to know how to access iterator and next() and hasNext();

        System.out.println("Set : ");
        Set<Integer> set=new LinkedHashSet<>();
        set.add(10);
        set.add(2);
        set.add(3);
        set.add(3);

        Iterator itr=set.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

        System.out.println("TreeSet : ");

        Set<Integer> treeSet=new TreeSet<>();
        treeSet.add(10);
        treeSet.add(2);
        treeSet.add(3);

        Iterator itr4=treeSet.iterator();
        while(itr4.hasNext())
            System.out.println(itr4.next());


        System.out.println("List : ");

        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(2);
        list.add(3);

        Iterator itr1=list.iterator();
        while(itr1.hasNext())
            System.out.println(itr1.next());

        System.out.println("Stack : ");
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(10);
        st.push(20);
        st.push(30);

        Iterator itr3=st.iterator();
        while(itr3.hasNext())
            System.out.println(itr3.next());

        System.out.println("PriorityQueue : ");
        Queue<Integer> queue=new PriorityQueue<>();
        queue.offer(1);
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        Iterator itr5=queue.iterator();
        while(itr5.hasNext())
            System.out.println(itr5.next());

    }
}
