package leetcode.math.medium;

import java.util.ArrayList;
import java.util.List;

public class LC1492KthFactor {

    public static void main(String[] args) {
        int n=12,k=3;

        //Approach 1
        System.out.println(kthFactor(n,k));
        //Approach 2
        System.out.println(kthFactorBetter(n,k));
    }
    public static int kthFactorBetter(int n, int k) {
        int count =0;
        for (int i =1;i<=n;i++) {
            if (n%i == 0 && ++count == k) {
                return i;
            }
        }
        return -1;
    }

    public static int kthFactor(int n, int k) {

        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0)
                list.add(i);
        }
        if(list.size()<k)
            return -1;
        return list.get(k-1);
    }
}
