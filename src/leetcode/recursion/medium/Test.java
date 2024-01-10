package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {

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
