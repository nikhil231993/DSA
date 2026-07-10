package leetcode.company.leetcode75Remaining;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC2215FindDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{2,4,6};
        System.out.println(findDifference(nums1, nums2));

        System.out.println(findDifferenceApproach2(nums1, nums2));
    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet();
        List<List<Integer>> result=new ArrayList<>();
        Set<Integer> list1=new HashSet<>();


        for(int num:nums2)
            set1.add(num);
        Set<Integer> list2=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            if(!set1.contains(nums1[i]))
                list2.add(nums1[i]);
        }

        set1=new HashSet();
        for(int num:nums1)
            set1.add(num);

        for(int i=0;i<nums2.length;i++){
            if(!set1.contains(nums2[i]))
                list1.add(nums2[i]);
        }
        result.add(new ArrayList<>(list2));
        result.add(new ArrayList<>(list1));
        return result;
    }

    private static List<List<Integer>> findDifferenceApproach2(int[] nums1, int[] nums2) {
        Set<Integer> distinctNums1=new HashSet();
        Set<Integer> distinctNums2=new HashSet<>();
        for(int num:nums1)
            distinctNums1.add(num);
        for(int num:nums2)
            distinctNums2.add(num);

        for(int i=0;i<nums1.length;i++){
            if(distinctNums2.contains(nums1[i])){
                distinctNums1.remove(nums1[i]);
                distinctNums2.remove(nums1[i]);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>(distinctNums1));
        result.add(new ArrayList<>(distinctNums2));
        return result;
    }
}
