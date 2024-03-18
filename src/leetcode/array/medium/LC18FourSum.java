package leetcode.array.medium;

import java.util.*;

public class LC18FourSum {

    public static void main(String[] args) {

        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target=9;

        //Approach 1: Brute
        System.out.println(brute(nums,target));

        //Approach 2: Better (This is similar to better of three sum)
        System.out.println(better(nums,target));

        //Approach 3: Optimal (This is similar to optimal of three sum)
        System.out.println(fourSum(nums,target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        int n=nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
                for(int j=i+1;j<n;j++){
                    if(j>i+1 && nums[j]==nums[j-1])
                        continue;
                    int k=j+1;
                    int l=n-1;

                    while(k<l){
                        //Below is used because since first we add left to right and then assign to long,
                        //before assigning to long if value exceeds integer limit it will be a
                        long sum=nums[i];
                        sum+=nums[j];
                        sum+=nums[k];
                        sum+=nums[l];
                        if(sum==target){
                            List<Integer> list=new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            result.add(list);
                            k++;
                            l--;
                            while(k<l && nums[k]==nums[k-1])
                                k++;
                            while(k<l && nums[l]==nums[l+1])
                                l--;
                        }else if(sum>target){
                            l--;
                        }else{
                            k++;
                        }
                    }
                }
        }
        return result;

        //TC:O(n cube)
        //SC:O(no of result)
    }

    private static List<List<Integer>> better(int[] nums, int target) {

        Set<List<Integer>> s=new HashSet<>();

        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> fourth=new HashSet<>();
                for(int k=j+1;k<n;k++){

                    int fourthNo=target-(nums[i]+nums[j]+nums[k]);
                    if(fourth.contains(fourthNo)){
                        List<Integer> ans=new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        ans.add(fourthNo);
                        Collections.sort(ans);
                        s.add(ans);
                    }
                    fourth.add(nums[k]);
                }
            }
        }

        for(List<Integer> listNo:s)
            list.add(listNo);
        return list;
    }

    private static List<List<Integer>> brute(int[] nums, int target) {

        int n=nums.length;
        Set<List<Integer>> s=new HashSet<>();
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){

                        //Below is used because since first we add left to right and then assign to long,
                        //before assigning to long if value exceeds integer limit it will be a
                        long sum=nums[i];
                        sum+=nums[j];
                        sum+=nums[k];
                        sum+=nums[l];

                        if(sum==target){
                            List<Integer> l1=new ArrayList<>();
                            l1.add(nums[i]);
                            l1.add(nums[j]);
                            l1.add(nums[k]);
                            l1.add(nums[l]);
                            Collections.sort(l1);
                            s.add(l1);
                        }
                    }
                }
            }
        }
        for(List<Integer> n1:s)
            result.add(n1);

        return result;

        //TC:O(n to power 4)
        //SC:O(no of quad) * 2
    }
}
