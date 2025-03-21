package leetcode.string.medium;

public class LC1839 {

    public static void main(String[] args) {

        String s="aeiaaioaaaaeiiiiouuuooaauuaeiu";
        System.out.println(longestBeautifulSubstring(s));
    }

    public static int longestBeautifulSubstring(String word) {

        int n=word.length();
        int count=1;
        int prev=-1;
        int max=0;

        for(int i=1;i<n;i++){
            if(word.charAt(i)==word.charAt(i-1)){
                if(count==5){
                    if(prev==-1)
                        max=Math.max(max, i-prev);
                    else
                        max=Math.max(max, i-prev+1);
                }
                continue;
            }else if(word.charAt(i)>word.charAt(i-1)){
                count++;
            }else{
                count=1;
                prev=i;
            }
            if(count==5){
                if(prev==-1)
                    max=Math.max(max, i-prev);
                else
                    max=Math.max(max, i-prev+1);
            }
        }
        return max;
    }
}
