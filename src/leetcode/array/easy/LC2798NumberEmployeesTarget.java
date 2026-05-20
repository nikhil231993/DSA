package leetcode.array.easy;

public class LC2798NumberEmployeesTarget {

    public static void main(String[] args) {

        int[] hours=new int[]{0,1,2,3,4};
        int target=2;

        System.out.println(numberOfEmployeesWhoMetTarget(hours,target));
    }

    private static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {

        int count=0, n=hours.length;
        for (int hour : hours) {
            if (hour >= target)
                count++;
        }
        return count;

		//TC:O(n)
		//SC:O(1)
    }
}
