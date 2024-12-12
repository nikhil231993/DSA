package leetcode.stack;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(10);

        Iterator<Integer> it= list.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
