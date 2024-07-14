package leetcode.string.hard;

import java.util.*;

public class LC30SubstringWithConcatenation {

    public static void main(String[] args) {

        String s = "bbbbarfoothefoobarman";
        String[] words =new String[] {"foo","bar"};
        System.out.println(findSubstring(s,words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        //Step 1: create a map with words array and frequency
        //Step 2: create a copy of map
        //Step 3: start from 0 index and form a substring of length of words[0]
        //Step 4: if the string found in map decrease count and if count =1 remove element from map
        //Step 5: if map is empty store the i pointer
        //Step 6: if th word is not found in map then break and continue;

        int len=words[0].length();

        HashMap<String, Integer> map=new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        List<Integer> pos=new ArrayList();
        int size=words.length;
        int origStr=s.length();
        for(int i=0;i<=origStr-size*len;i++){

            HashMap<String, Integer> copyMap=new HashMap<>(map);

            for(int j=0;j<size;j++){

                int startPos=i+j*len;
                int endPos=startPos+len;
                String subString=s.substring(startPos, endPos);

                if(copyMap.containsKey(subString)){
                    if(copyMap.get(subString)==1){
                        copyMap.remove(subString);
                    }else{
                        copyMap.put(subString, copyMap.get(subString)-1);
                    }
                    if(copyMap.isEmpty()){
                        pos.add(i);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return pos;
    }
}
