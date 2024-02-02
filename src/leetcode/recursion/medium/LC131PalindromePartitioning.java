package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class LC131PalindromePartitioning {

    public static void main(String[] args) {

      String  s = "aab";
      System.out.println(partition(s));
    }
    public static List<List<String>> partition(String s) {

        List<List<String>> finalResult=new ArrayList();
        List<String> subList=new ArrayList();
        partitionFunction(subList, finalResult, s, 0);
        return finalResult;
    }

    public static void partitionFunction( List<String> subList, List<List<String>> finalResult, String s, int index){

        if(index==s.length()){
            finalResult.add(new ArrayList(subList));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(index, i, s)){
                subList.add(s.substring(index,i+1));
                partitionFunction(subList, finalResult,  s, i+1);
                subList.remove(subList.size()-1);
            }
        }
    }

    public static boolean isPalindrome(int start, int end, String s){

        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
        //Time Complexity: O( (2^n) *k*(n/2) )

        //Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome.
        // O(k) is for inserting the palindromes in another data structure,
        // where k  is the average length of the palindrome list.
        //
        //Space Complexity: O(k * x)
        //Reason: The space complexity can vary depending upon the length of the answer.
        // k is the average length of the list of palindromes and if we have x such list of palindromes
        // in our final answer. The depth of the recursion tree is n, so the auxiliary space required
        // is equal to the O(n).
    }
}
