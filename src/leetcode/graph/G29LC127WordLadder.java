package leetcode.graph;

import java.util.*;

class PairG29{
    String word;
    int level;

    public PairG29(String word, int level){
        this.word=word;
        this.level=level;
    }
}
public class G29LC127WordLadder {

    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(wordLadder(beginWord,endWord,wordList));

        //TC:word.length*26(internal loop) * while loop(size of wordlist)*log n for set
        //SC:set size
    }

    public static int wordLadder(String beginWord, String endWord, List<String> wordList){
        //Create a set to store all the values in list so that it can be removed when it matches
        Set<String> set=new HashSet<>();
        for(String s:wordList)
            set.add(s);

        //Add the begin word into queue with 1 as level of initial string is 1
        Queue<PairG29> q=new LinkedList<>();
        q.offer(new PairG29(beginWord,1));

        //There can be a chance this word exist in array so to avoid any issue we will delete it
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word=q.peek().word;
            Integer level=q.peek().level;
            q.poll();

            //If the word fetched is same as the endword return the level
            if(word.equals(endWord))
                return level;

            //Else parse through the word and change one letter and check if it exists in set

            for(int i=0;i<word.length();i++){
                //take the char in hand to return it back into word even though it is not needed
                char[] charArray=word.toCharArray();
                char original=charArray[i];//This line is not needed as the actual word is not changed
                for(char c='a';c<='z';c++){
                    charArray[i]=c;
                    String replacedString=new String(charArray);
                    if(set.contains(replacedString)){
                        q.offer(new PairG29(replacedString,level+1));
                        set.remove(replacedString);
                    }
                }
                charArray[i]=original;//This line is not needed as the actual word is not changed
            }
        }
        return 0;//We will return 0 if we don't reach the word
    }
}
