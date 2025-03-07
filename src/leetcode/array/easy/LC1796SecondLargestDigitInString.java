package leetcode.array.easy;

public class LC1796SecondLargestDigitInString {

    public static void main(String[] args) {

        String s = "dfa12321afd";
        System.out.println(secondHighest(s));
    }

    public static int secondHighest(String s) {

        int n=s.length();
        int largest=-1;
        int secondLargest=-1;
        for(int i=0; i<n; i++){
            if(Character.isDigit(s.charAt(i))){
                int num=s.charAt(i)-'0';
                if(num>largest){
                    secondLargest=largest;
                    largest=num;
                }else if(num<largest && num>secondLargest){
                    secondLargest=num;
                }
            }
        }
        return secondLargest;
    }
}
