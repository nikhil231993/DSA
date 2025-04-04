package leetcode.string.hard;

public class LC273IntegerToEnglish {

    public static void main(String[] args) {

        int num = 2130123000;
        //num=200;
        System.out.println(numberToWords(num));
    }

    private static String numberToWords(int num) {

        String[] ones=new String[]{ "","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve",
        "Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens=new String[]{ "","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

        if(num==0)
            return "Zero";
        else return convert(num, tens, ones);
    }

    public static String convert(int num, String[] tens, String[] ones){

        if(num >= 1000000000){
            return (convert(num/1000000000,tens,ones)+" Billion "+convert(num%1000000000,tens,ones)).trim();
        }else if(num >= 1000000){
            return (convert(num/1000000,tens,ones)+" Million "+convert(num%1000000,tens,ones)).trim();
        }else if(num >= 1000){
            return (convert(num/1000,tens,ones)+" Thousand "+convert(num%1000,tens,ones)).trim();
        }else if(num >= 100){
            return (convert(num/100,tens,ones)+" Hundred "+convert(num%100,tens,ones)).trim();
        }else if(num >= 20){
            return (tens[num/10]+" "+convert(num%10,tens,ones)).trim();
        }return ones[num];
    }

    //TC: log base 10 to number
    //because the number of recursive calls is proportional to the number of digits in the number, which grows logarithmically with the size of the number.
    //SC: log base 10 to number
    //mainly because of the recursion stack. Each recursive call adds a frame to the stack until the base case is reached, leading to space usage proportional to the number of digits in the number.
}
