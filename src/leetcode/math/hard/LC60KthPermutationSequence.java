package leetcode.math.hard;

import java.util.ArrayList;
import java.util.List;

public class LC60KthPermutationSequence {

    public static void main(String[] args) {

        int n = 4, k = 12;
        System.out.println(getPermutation(n,k));
    }

    public static String getPermutation(int n, int k) {

        int fact=1;
        k=k-1;

        List<Integer> list=new ArrayList<>();
        for(int i=1;i<n;i++){
            fact=fact*i;
            list.add(i);
        }
        list.add(n);
        String ans="";

        while(true){
            ans=ans+ list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0) break;
            k=k%fact;
            fact=fact/list.size();
        }
        return ans;

        //TC:O(n * n (where this n is for remove function) );
        //SC:O(n)
    }
}
