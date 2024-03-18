package leetcode.binarysearch.medium;

public class LC1870MinimumTime {

    public static void main(String[] args) {

        int[] dist =new int[] {1,3,2};
        double hour = 2.7;
        System.out.println(minSpeedOnTime(dist,hour));
    }

    public static boolean isPossible(double speed, int[] dist, double hour){

        double total_hour_so_far = 0;

        for(int it = 0; it < dist.length - 1; it++){
            double h = dist[it]/speed;
            total_hour_so_far += Math.ceil(h);

            if(total_hour_so_far > hour) return false;
        }
        total_hour_so_far += dist[dist.length - 1] / speed;
        return total_hour_so_far <= hour ? true : false;
    }

    public static int minSpeedOnTime(int[] dist, double hour) {

        int low = 1;
        int high = (int)1e7;
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
    }
}
