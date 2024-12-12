package leetcode.recursion.medium;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Integer a11=10;
        System.out.println(String.valueOf(a11));

        HashSet<Integer> set=new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));

        List<Integer> list=new ArrayList<>();
        list.add(100);
        list.add(2);
        list.add(20);

        Collections.sort(list,(a,b)->{
            if(a>b)
                return 1;
            return 0;
        });

        System.out.println(list);
    }
}
