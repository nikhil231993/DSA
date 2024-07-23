package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class LC2942CharInWords {

    public static void main(String[] args) {

        String[] words = new String[]{"leet","code"};
        char x = 'e';

        System.out.println(findWordsContaining(words,x));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> list=new ArrayList();
        for(int i=0;i<words.length;i++){
            if(words[i].indexOf(x)!=-1)
                list.add(i);
        }
        return list;

        //TC:O(n) and TC of indexOf function
        //SC:O(1)
    }
}
