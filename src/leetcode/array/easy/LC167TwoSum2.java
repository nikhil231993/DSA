package leetcode.array.easy;

public class LC167TwoSum2 {

    public static void main(String[] args) {

       int[] numbers =new int[] {2,7,11,15};
       int target = 9;
       System.out.println(twoSum(numbers, target));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int i=0;
        int j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j] == target){
                return new int[]{i+1,j+1};
            }
            else if(numbers[i]+numbers[j] > target)
                j--;
            else
                i++;
        }
        return new int[]{};

        //SC:O(1)
        //TC:O(n)
    }
}
