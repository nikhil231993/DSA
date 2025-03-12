package leetcode.slidingwindow.medium;

import java.util.HashMap;

public class naukriCountWithKDifferentCharacters {

    public static void main(String[] args) {

        String str="aacfssa";
        int k=3;
        int n=str.length();
        System.out.println(func(str, k, n)- func(str, k-1, n));
    }

    public static int func(String s, int k, int n){

        HashMap<Character, Integer> map=new HashMap<>();

        int r=0, l=0, count=0;
        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k){

                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0)
                    map.remove(s.charAt(l));
                l++;
            }
            if(map.size()<=k)
                count+=(r-l+1);
            r++;
        }
        return count;
    }
}
