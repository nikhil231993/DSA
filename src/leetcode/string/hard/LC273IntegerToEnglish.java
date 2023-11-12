package leetcode.string.hard;

public class LC273IntegerToEnglish {
    public static void main(String[] args) {
        int num = 2139000000;
        System.out.println(numberToWords(num));
    }

    private static String numberToWords(int num) {

        String[] ones=new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve",
        "Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens=new String[]{"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

        if(num==0)
            return "Zero";
        else return convertEnglish(num, ones, tens);
    }

    private static String convertEnglish(int num, String[] ones, String[] tens) {

        if(num>=1000000000)
            return convertEnglish(num/1000000000,ones,tens)+" Billion "+convertEnglish(num%1000000000,ones,tens);
        else if(num>=1000000)
            return convertEnglish(num/1000000,ones,tens)+ " Million "+convertEnglish(num%1000000,ones,tens);
        else if(num>=1000)
            return convertEnglish(num/1000,ones,tens)+ " Thousand "+convertEnglish(num%1000,ones,tens);
        else if(num>=100)
            return (convertEnglish(num/100,ones,tens)+" Hundred "+convertEnglish(num%100,ones,tens)).trim();
        else if(num>=20)
            return (tens[num/10]+" "+convertEnglish(num%10,ones,tens)).trim();
        return ones[num];
    }
}
