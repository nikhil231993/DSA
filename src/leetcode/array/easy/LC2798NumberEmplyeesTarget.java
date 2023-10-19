package leetcode.array.easy;

public class LC2798NumberEmplyeesTarget {

    public static void main(String[] args) {
        int[] hours=new int[]{0,1,2,3,4};
        int target=2;
        System.out.println(numberOfEmployeesWhoMetTarget(hours,target));
    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count=0;
        for(int i=0;i<hours.length;i++){
            if(hours[i]>=target)
                count++;
        }
        return count;
        //TC:O(n);
        //SC:O(1)
    }
}
