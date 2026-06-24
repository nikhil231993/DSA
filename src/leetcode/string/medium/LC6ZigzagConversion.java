package leetcode.string.medium;

public class LC6ZigzagConversion {

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(convert(s, numRows));
    }

    private static String convert(String s, int numRows){

        int n=s.length();
        StringBuilder[] sb=new StringBuilder[numRows];

        for(int i=0; i<numRows; i++){
            sb[i]=new StringBuilder();
        }
        int i=0;
        while(i<n){
            for(int k=0; k<numRows && i<n; k++) {
                sb[k].append(s.charAt(i++));
            }
            for(int k=numRows-2; k>=1 && i< n; k--){
                sb[k].append(s.charAt(i++));
            }
        }

        for(int j=1; j<numRows; j++){
            sb[0].append(sb[j]);
        }

        return sb[0].toString();

        //TC:O(n)
        //SC:O(n)
     }
}
