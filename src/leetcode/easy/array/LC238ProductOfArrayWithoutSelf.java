package leetcode.easy.array;

public class LC238ProductOfArrayWithoutSelf {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };

		int[] r = product(nums);

		for (Integer n : r)
			System.out.println(n);

	}

	private static int[] product(int[] nums) {
        int product=1;
		int[] response = new int[nums.length];
        for(int i=0;i<nums.length;i++){
           product=1;
           for(int j=0;j<nums.length;j++){

               if(i!=j){
                   product*=nums[j];
               }
           }
			response[i] = product;
           
        }

		return response;
        //SC:O(1)
		// TC:O(n2)
	}

}
