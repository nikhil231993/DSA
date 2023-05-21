package leetcode.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class LC60PermutationSequence {

    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(getPermutation(n,k));
    }

    public static String getPermutation(int n, int k) {

        String ans="";

        List<Integer> list=new ArrayList();
        int fact=1;

        for(int i=1;i<n;i++){
            fact=fact*i;
            list.add(i);
        }
        list.add(n);
        k=k-1;
        while(true){
            ans=ans+list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0) break;
            k=k%fact;
            fact=fact/list.size();
        }
        return ans;
        //TC:O(N) for while loop *O(n) for removing
        //Sc:O(N) ans string+O(n) list
    }
}
