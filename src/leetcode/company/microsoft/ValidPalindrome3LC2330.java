package leetcode.company.microsoft;

public class ValidPalindrome3LC2330 {

    public static void main(String[] args) {
        String s = "abcdba";
        System.out.println(makePalindrome(s));
    }

    private static boolean makePalindrome(String s) {
        int n=s.length(), left=0, right=n-1, count=0;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                count++;
                if(count>2)
                    return false;
            }
            left++;
            right--;
        }
        return true;
        //TC:O(N)
    }
}
