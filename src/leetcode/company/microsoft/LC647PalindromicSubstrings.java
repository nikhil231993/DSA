package leetcode.company.microsoft;

public class LC647PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstringsRecursion(s));
    }

    private static int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            int left=i;
            int right=i;

            while(left>=0 && right<n){
                if(s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }else break;
            }

            left=i;
            right=i+1;
            while(left>=0 && right<n){
                if(s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }else break;
            }
        }
        return count;
        //TC:O(n square)
        //Better optimized solution needs Manacher's algo
    }

    private static int countSubstringsRecursion(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            count+=palindrome(i,i, s, n);
            count+=palindrome(i,i+1, s, n);
        }
        return count;
    }

    private static int palindrome(int left, int right, String s, int n){

        int count=0;
        while(left>=0 && right<n){
            if(s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }else break;
        }
        return count;
    }
}
