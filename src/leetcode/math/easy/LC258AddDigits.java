package leetcode.math.easy;

public class LC258AddDigits {

    public static void main(String[] args) {

        int num=38;

        //Approach 1
        System.out.println(addDigits(num));

        //Approach 2
        System.out.println(addDigitsBest(num));

        //Approach 3
        System.out.println(addDigitsBestTest(num));
    }

    private static int addDigitsBestTest(int num) {

        if(num==0)
            return 0;

        int sum=0;
        while(true){
            while(num!=0){
                sum+=num%10;
                num=num/10;
            }
            if(sum<10)
                return sum;
            num=sum;
            sum=0;
        }
    }

    private static int addDigitsBest(int num) {

        //Try debugging you will get it or else ask Me
        //This Method is known as Digit Root
        if(num==0)
            return 0;
        else if(num%9==0)
            return 9;
        else
            return num%9;

        //TC:O(1)
        //SC:O(1)
    }

    public static int addDigits(int num) {

        if(num==0)
            return 0;
        int sum=0;

        while(num!=0){
            sum+=num%10;
            num=num/10;
        }

        if(sum<10)
            return sum;
        else
            return addDigits(sum);

        //SC:O(1)
        //TC:(logn) where log n is the time taken to find no of digits in a number
    }
}
