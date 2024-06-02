package leetcode.string.hard;

public class LC65ValidNumber {

    public static void main(String[] args) {

        String s="3E+7";
        System.out.println(isBoolean(s));
    }

    public static boolean isBoolean(String s){

        s=s.trim();

        boolean numberSeen=false;
        boolean expoSeen=false;
        boolean decimalSeen=false;

        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '.':
                    if(decimalSeen || expoSeen) return false;
                    decimalSeen=true;
                    break;
                case 'E':
                case 'e':
                    if(expoSeen || !numberSeen) return false;
                    expoSeen=true;
                    numberSeen=false; //0e
                    break;
                case '+':
                case '-':
                    if(i!=0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E')) return false;
                    break;
                default:
                    if(!isDigit(s.charAt(i)))
                        return false;
                    numberSeen=true;
                    break;
            }
        }
        return numberSeen;

        //TC:O(N)
        //SC:O(1)
    }

    public static boolean isDigit(char ch){

        if(ch>='0' && ch<='9')
            return true;
        return false;
    }
}
