package leetcode.string.medium;

public class LC1839 {

    public static void main(String[] args) {

        String s="aeiaaioaaaaeiiiiouuuooaauuaeiu";
        System.out.println(longestBeautifulSubstring(s));
    }

    private static int longestBeautifulSubstring(String word) {
        int n=word.length(), maxLength=0, currLength=1, vowelCount=1;
        for(int i=1; i<n; i++){
            if(word.charAt(i)<word.charAt(i-1)){
                vowelCount=1;
                currLength=0;
            }else {
                if(word.charAt(i)>word.charAt(i-1))
                    vowelCount++;
            }
            currLength++;
            if(vowelCount==5)
                maxLength=Math.max(maxLength, currLength);
        }
        return maxLength;
        //TC:O(n)
        //SC:O(1)
    }
}
