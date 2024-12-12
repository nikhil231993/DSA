package leetcode.heap.easy;

public class LC2710RemoveTrailingZeros {

    public static void main(String[] args) {

        String num = "51230100";

        //Approach 1:
        System.out.println(removeTrailingZeros(num));

        //Approach 2:
        System.out.println(removeTrailingZerosOptimised(num));
    }

    public static  String removeTrailingZeros(String num) {

        int flag=0;
        int count=0;
        for(int i=num.length()-1; i>=0; i--){

            if(flag==0 && num.charAt(i)=='0'){
                count++;
            }
            else flag=1;

            if(flag==1)
                break;
        }
        return num.substring(0, num.length()-count);

        //TC:O(n)
        //SC:O(1)
    }

    public static String removeTrailingZerosOptimised(String num) {

        int endIndex = num.length()-1;
        while (endIndex >= 0 && num.charAt(endIndex) == '0') {
            endIndex--;
        }
        return num.substring(0, endIndex+1);

        //TC:O(n) where n is the length of the string
        //SC:O(1)
    }
}
