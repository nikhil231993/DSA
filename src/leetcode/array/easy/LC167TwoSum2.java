package leetcode.array.easy;

public class LC167TwoSum2 {

    public static void main(String[] args) {

       int[] numbers =new int[] {2,7,11,15};
       int target = 9;
       int[] result=twoSum(numbers, target);

       System.out.println(result[0]+" "+ result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left=0, right=numbers.length-1;
        while(left<right){

            if(numbers[left]+numbers[right] == target){
                return new int[]{left+1,right+1};
            }
            else if(numbers[left]+numbers[right] > target)
                right--;
            else
                left++;
        }
        return new int[]{};

        //TC:O(n)
        //SC:O(1)
    }
}
