package leetcode.math.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC60KthPermutationSequence {

    public static void main(String[] args) {

        int n = 4, k = 11;

        //Approach 1: Learnt in Striver recursion which is generating all combinations and sorting it
        // and fetching k-1
        //https://takeuforward.org/data-structure/find-k-th-permutation-sequence/
        String ans = getPermutationGenerate(n, k);
        System.out.println(ans);

        //Approach 2:
        System.out.println(getPermutation(n,k));
    }

    private static void swap(char s[], int i, int j) {

        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }

    private static void permutationHelper(char s[], int index, ArrayList < String > res) {

        if (index == s.length) {
            String str = new String(s);
            res.add(str);
            return;
        }
        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            permutationHelper(s, index + 1, res);
            swap(s, i, index);
        }
    }

    private static String getPermutationGenerate(int n, int k) {

        String s = "";
        ArrayList < String > res = new ArrayList < > ();
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        permutationHelper(s.toCharArray(), 0, res);
        Collections.sort(res);
        return res.get(k-1);
    }

    public static String getPermutation(int n, int k) {

        int fact=1;
        k=k-1;

        List<Integer> list = new ArrayList<>();
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

        //TC: O(n * n (where this n is for remove function));
        //SC: O(n)
    }
}
