package leetcode.TwoPointer.easy;

public class LC917ReverseLetters {

    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println(reverseOnlyLetters(s));
    }

    public static String reverseOnlyLetters(String s) {
        String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int left=0;
        int right=s.length()-1;
        char[] ch=s.toCharArray();
        while(left<right){
            while(left<right && letters.indexOf(ch[right])==-1){
                right--;
            }
            while(left<right && letters.indexOf(ch[left])==-1){
                left++;
            }
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        return new String(ch);
    }
}
