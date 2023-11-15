package leetcode.TwoPointer.easy;

public class LC2000ReversePrefixOfWord {

    public static void main(String[] args) {
       String word = "abcdefd";
       char ch = 'd';
        System.out.println(reversePrefix(word,ch));
    }

    public static String reversePrefix(String word, char ch) {
        char[] ch1=word.toCharArray();
        int right=0;
        for(int i=0;i<word.length();i++){
            if(ch1[i]==ch){
                right=i;
                break;
            }

        }
        int left=0;
        while(left<=right){
            char temp=ch1[left];
            ch1[left]=ch1[right];
            ch1[right]=temp;
            left++;
            right--;
        }

        return new String(ch1);
    }
}
