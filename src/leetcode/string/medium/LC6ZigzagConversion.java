package leetcode.string.medium;

public class LC6ZigzagConversion {

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(convert(s, numRows));
    }

    private static String convert(String s, int row){

        int n=s.length();
        StringBuilder[] sb=new StringBuilder[row];

        for(int i=0; i<row; i++){
            sb[i]=new StringBuilder();
        }
        int i=0;
        while(i<n){
            for(int id=0; id<row && i<n; id++) {
                sb[id].append(s.charAt(i++));
            }
            for(int id=row-2; id>=1 && i< n; id--){
                sb[id].append(s.charAt(i++));
            }
        }

        for(int j=1; j<row; j++){
            sb[0].append(sb[j]);
        }

        return sb[0].toString();

        //TC:O(n)
        //SC:O(n)
     }
}
