package leetcode.string.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC1408StringMatching {

    public static void main(String[] args) {

        String[] words=new String[]{"mass","as","hero","superhero"};
        System.out.println(stringMatching(words));
    }

    public static List<String> stringMatching(String[] words) {

        HashSet<String> set=new HashSet<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j && words[i].contains(words[j])){
                    set.add(words[j]);
                }
            }
        }
        return new ArrayList<>(set);

        //TC:O(n square) + O(n log n)
        //SC:O(n+n) for set and list
    }
}
