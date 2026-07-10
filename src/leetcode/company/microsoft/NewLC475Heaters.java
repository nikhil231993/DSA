package leetcode.company.microsoft;

import java.util.Arrays;

public class NewLC475Heaters {

    public static void main(String[] args) {
       int[]  houses = new int[] {1,2,3,4};
       int[]  heaters = new int[] {1,4};
        System.out.println(findRadius(houses, heaters));
    }

    private static int findRadius(int[] houses, int[] heaters) {
        int minRadius=0;
        Arrays.sort(heaters);
        int n=heaters.length;

        for(int house : houses){

            int lowerBound=binarySearch(heaters, house);

            int leftDistance=Integer.MAX_VALUE;
            int rightDistance=Integer.MAX_VALUE;
            if(lowerBound>0)
                leftDistance=house-heaters[lowerBound-1];

            if(lowerBound<n)
                rightDistance=heaters[lowerBound]-house;

            int max=Math.min(leftDistance, rightDistance);

            minRadius=Math.max(max, minRadius);
        }
        return minRadius;
    }

    private static int binarySearch(int[] arr, int target){
        int n=arr.length;
        int low=0, high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return ans;
    }
}
