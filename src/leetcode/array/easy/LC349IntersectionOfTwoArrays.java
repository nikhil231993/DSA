package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC349IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 =new int[] {1,2,2,1};
        int[] nums2 =new int[] {2,2};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n=nums1.length;
        int m=nums2.length;
        List<Integer> r=new ArrayList<>();
        int[] result=uniqueIntersection(n,m,nums1,nums2,r);

        for(int nu:result)
            System.out.println(nu);
    }

    private static int[] uniqueIntersection(int n, int m, int[] nums1, int[] nums2, List<Integer> r) {

        int i=0,j=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                if(r.size() ==0 || r.get(r.size()-1)!=nums1[i]){
                    r.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        int k=0;
        int[] n1=new int[r.size()];
        for(Integer num:r)
            n1[k++]=num;

        return n1;
        //TC:O(nlogn)+(mlogm)
        //SC:O(n+m)
    }
}
