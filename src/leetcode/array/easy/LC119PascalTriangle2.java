package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class LC119PascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex=10;
        System.out.println(getRow(rowIndex));
    }
    public static List<Integer> getRow(int rowIndex) {

        List<Integer>prev=new ArrayList<>();
        List<Integer>temp=null;
        for(int i=0;i<=rowIndex;i++){
            temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }
                else{
                    temp.add(prev.get(j-1)+prev.get(j));
                }

            }
            prev=temp;

        }
        return temp;

        // List<Integer> row = new ArrayList<Integer>();
        // 	int re = 1;
        // 	row.add(re);
        //     int n=rowIndex+1;
        // 	for (int i = 1; i < n; i++) {
        // 		re *= (n - i);
        // 		re /= (i);
        // 		row.add(re);
        // 	}
        // 	// SC:O(1)
        // 	// TC:O(n)
        // 	return row;
        //above fails for n>30
    }
}
