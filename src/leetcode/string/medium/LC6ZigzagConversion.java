package leetcode.string.medium;

public class LC6ZigzagConversion {

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int row){

        int n=s.length();
        StringBuilder[] sb=new StringBuilder[row];

        for(int i=0;i<row;i++){
            sb[i]=new StringBuilder();
        }
        int ch=0;
        while(ch<n){
            for(int id=0;id<row && ch<n;id++) {
                sb[id].append(s.charAt(ch++));
            }
            for(int id=row-2;id>=1 && ch< n;id--){
                sb[id].append(s.charAt(ch++));
            }
        }

        for(int j=1;j<row;j++){
            sb[0].append(sb[j]);
        }

        return sb[0].toString();

        // TC:O(n)
        // SC:O(n)
     }
}
