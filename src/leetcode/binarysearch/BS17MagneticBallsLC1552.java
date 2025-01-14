package leetcode.binarysearch;

import java.util.Arrays;

public class BS17MagneticBallsLC1552 {

    public static void main(String[] args) {

       int[] position =new int[] {1,2,3,4,7};
       int m = 3;
       System.out.println(maxDistance(position,m));
    }

    public static int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int n=position.length, low=1, high=position[n-1]-position[0], ans=1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(mid, position, m)){
                ans=mid;
                low=mid+1;
            }else
                high=mid-1;
        }
        return ans;
    }

    public static boolean isPossible(int distance, int[] position, int m){

        int count=1, last=position[0];

        for(int i=1;i<position.length;i++){

            if(position[i]-last>=distance){
                count++;
                last=position[i];
            }
            if(count>=m)
                return true;
        }
        return false;

        // TC:nlog n + log(arr[n-1]-arr[0])*O(n)
        // SC:O(1)
    }
}
