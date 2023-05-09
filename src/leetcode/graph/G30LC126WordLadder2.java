package leetcode.graph;

import java.util.*;

public class G30LC126WordLadder2 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        //Below solution gives TLE in Leetcode. Next solution will work on Leetcode
        System.out.println(wordLadder(beginWord,endWord,wordList));

//Time Complexity and Space Complexity: It cannot be predicted for this particular algorithm because there can be multiple sequences of transformation from startWord to targetWord depending upon the example, so we cannot define a fixed range of time or space in which this program would run for all the test cases.
//
//Note: This approach/code will give TLE when solved on the Leetcode platform due to the strict time constraints being put up there. So, you need to optimize it to a greater extent in order to pass all the test cases for LeetCode.For the optimized approach to this question please check out the next video.
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

        //we can usedonlevel array also to store values added inside contains check below

        List<List<String>> result=new ArrayList<>();
        while(!q.isEmpty()){
            List<String> individualList=q.poll();

            String word=individualList.get(individualList.size()-1);

            //erase all words that has been
            //used in the previous levels to transform
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
