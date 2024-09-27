package leetcode.string.medium;

public class LC12IntegerToRoman {

    public static void main(String[] args) {

        int num = 1994;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num){
        
        int[] numR=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numR.length;i++){
            while(num>=numR[i]){
                sb.append(roman[i]);
                num-=numR[i];
            }
        }
        return sb.toString();

        //SC: O(2*13) to store both array and result string
        //TC: It depends on how many times both loop runs
    }
}
