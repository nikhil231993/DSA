package leetcode.stack.medium;

import java.util.Stack;

public class LC2288ApplyDiscounts {

    public static void main(String[] args) {

        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        System.out.println(discountPrices(sentence, discount));
    }

    public static String discountPrices(String sentence, int discount) {

        String[] str=sentence.split(" ");
        String ans="";
        for(int i=0; i<str.length; i++){
            if(isValid(str[i])){
                long val=Long.parseLong(str[i].substring(1));
                ans+=("$"+ String.format("%.2f", val*(1-discount/100.0d)));
            }else{
                ans+=str[i];
            }
            ans+=" ";
        }
        return ans.substring(0, ans.length()-1);
    }

    public static boolean isValid(String str){

        if(str.charAt(0)!='$')
            return false;
        else if(str.length()<=1)
            return false;

        for(int i=1; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
}
