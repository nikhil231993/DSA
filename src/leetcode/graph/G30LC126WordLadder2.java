package leetcode.graph;

import java.util.*;

public class G30LC126WordLadder2 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        //Below solution gives TLE in Leetcode. Next solution will work on Leetcode
        System.out.println(wordLadder(beginWord,endWord,wordList));
    }

    private static List<List<String>> wordLadder(String beginWord, String endWord, List<String> wordList) {

        Set<String> set=new HashSet<>();
        for(String s:wordList)
            set.add(s);

        Queue<List<String>> q=new LinkedList<>();
        List<String> l=new ArrayList<>();
        l.add(beginWord);
        q.offer(l);
        int level=0;

        List<List<String>> result=new ArrayList<>();
        while(!q.isEmpty()){
            List<String> individualList=q.poll();

            String word=individualList.get(individualList.size()-1);

            if(individualList.size()>level){
                level++;
                for(String s:individualList){
                    set.remove(s);
                }
            }

            if(word.equals(endWord)){
                if(result.size()==0){
                    result.add(individualList);
                }else if (individualList.size()==result.get(0).size()){
                    result.add(individualList);
                }
            }

            for(int i=0;i<word.length();i++){
                char[] replacedArray=word.toCharArray();
                char temp=replacedArray[i];
                for(char c='a';c<='z';c++){
                    replacedArray[i]=c;
                    String s=new String(replacedArray);
                    if(set.contains(s)){
                        individualList.add(s);
                        q.offer(new ArrayList<>(individualList));
                        individualList.remove(individualList.size()-1);
                    }
                }
                replacedArray[i]=temp;
            }


        }
        return  result;

    }
}
