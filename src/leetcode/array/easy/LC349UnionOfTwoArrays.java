package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class LC349UnionOfTwoArrays {

    public static void main(String[] args) {
       int n = 5;
       int[] arr1 =new int[] {1, 2, 3, 4, 5};
        int m = 3;
       int[] arr2=new int[] {1, 2, 3};

       List<Integer> list =new ArrayList<>();
        System.out.println(findUnion(n,m,arr1,arr2,list));
    }

    private static List<Integer> findUnion(int n, int m, int[] arr1, int[] arr2, List<Integer> list) {

        int i=0;
        int j=0;

        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                if( list.size()==0 || list.get(list.size()-1) != arr1[i] ){
                    list.add(arr1[i]);
                }
                i++;
            }else{
                if(  list.size()==0 || list.get(list.size()-1) !=arr2[j]){
                    list.add(arr2[j]);
                }
                j++;
            }
        }

        while(i<n){
            if( list.size()==0 || list.get(list.size()-1) != arr1[i] ){
                list.add(arr1[i]);
            }
            i++;
        }
        while(j<m){
            if(  list.size()==0 || list.get(list.size()-1) !=arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }
        return list;

        //TC:O(n+m)
        //SC:O(n+m)
    }
}
