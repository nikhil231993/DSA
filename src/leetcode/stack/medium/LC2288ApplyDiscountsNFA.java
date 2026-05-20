package leetcode.stack.medium;


public class LC2288ApplyDiscountsNFA {

    public static void main(String[] args) {

        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        System.out.println(discountPrices(sentence, discount));

        //sentence ="706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6"
        //discount=28

        //To handle above case we use double or long
        System.out.println(discountPricesOptimised(sentence, discount));
    }

    public static String discountPrices(String sentence, int discount) {

        String[] str=sentence.split(" ");
        String ans="";

        for(int i=0; i<str.length; i++){
            if(isValid(str[i])){
                Long val=Long.parseLong(str[i].substring(1));  // double val=Double.parseDouble(str[i].substring(1));
                ans+=("$"+ String.format("%.2f", val*(1-discount/100.0d)));
            }else{
                ans+= str[i];
            }
            ans+=" ";
        }
        return ans.substring(0, ans.length()-1);

        //TC:O(n) where n is the length of str
        //SC:O(n) where n is the length of str
    }

    public static boolean isValid(String str){

        if(str.charAt(0)!='$')
            return false;
        else if(str.length()<=1)
            return false;

        for(int i=1;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    private static String discountPricesOptimised(String sentence, int discount) {

        String[] s=sentence.split(" ");
        int n=s.length;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            String str=s[i];
            if(isValidFun(str)){
                double val=Long.parseLong(str.substring(1));
                double disc=val*(1-(discount/100.0d));
                sb.append("$").append(String.format("%.2f", disc));
            }else{
                sb.append(str);
            }
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private static boolean isValidFun(String s){
        if(s.length()==1)
            return false;
        else if(s.charAt(0)!='$')
            return false;
        for(int i=1;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }
}
