package leetcode.string.easy;

public class LC1768MergeAlternatively {

    public static void main(String[] args) {

        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1,word2));
    }

    public static String mergeAlternately(String word1, String word2) {

        int n1=word1.length(), n2=word2.length();
        int i=0, j=0;
        StringBuilder sb=new StringBuilder();

        while(i < n1 || j < n2){
            if(i < n1)
                 sb.append(word1.charAt(i++));
            if(j < n2)
                sb.append(word2.charAt(j++));
        }
        return sb.toString();

        //TC:O(n+m)
        //SC:O(n+m)
    }
}
