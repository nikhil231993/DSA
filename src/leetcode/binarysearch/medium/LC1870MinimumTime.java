package leetcode.binarysearch.medium;

public class LC1870MinimumTime {

    public static void main(String[] args) {

        int[] dist =new int[] {1,3,2};
        //High is 1e7 because of 63/66 test case which as below
        //dist =[1,1,100000]
        //hour =2.01
        //Expected=10000000
        double hour = 2.7;

        System.out.println(minSpeedOnTime(dist,hour));

        //Same as above but little better
        System.out.println(minSpeedOnTimeSelf(dist, hour));
    }

    public static int minSpeedOnTimeSelf(int[] dist, double hour) {

        int n=dist.length;
        int low=1;
        int high=(int)1e7;
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            double val=find(mid, dist, hour);
            if(val<=hour){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static double find(int mid, int[] dist, double hour){

        double val=0.0;
        for(int i=0;i<dist.length-1;i++){
            val+=Math.ceil(dist[i]/(double)(mid));
        }
        val+=dist[dist.length-1]/(double)mid;
        return val;
    }

    public static boolean isPossible(double speed, int[] dist, double hour){

        double total_hour_so_far = 0;

        for(int it = 0; it < dist.length - 1; it++){
            total_hour_so_far += Math.ceil((double)dist[it]/speed);

            if(total_hour_so_far > hour)
                return false;
        }
        total_hour_so_far += dist[dist.length - 1] / speed;  //This is for the last fraction 0.66666666 in this example
        return total_hour_so_far <= hour ? true : false;
    }

    public static int minSpeedOnTime(int[] dist, double hour) {

        int low = 1, high = (int)1e7;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            double speed = (double) mid;

            if(isPossible(speed, dist, hour)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;

        //TC:O(log 1e 7)
        //SC:O(n)
    }
}
