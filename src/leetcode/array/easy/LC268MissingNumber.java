package leetcode.array.easy;

public class LC268MissingNumber {

    public static void main(String[] args) {

        int[] num=new int[] {9,6,4,2,3,5,7,0,1};

		// Approach 1: Brute as we do summation here
        System.out.println(missingNumber(num));

		// Approach 2: Optimal
        System.out.println(xor(num));

		// Approach 3: Optimal
		System.out.println(xorAnotherApproach(num));
    }

	private static int xorAnotherApproach(int[] nums) {

		int n = nums.length, num = 0;
		for (int i = 0; i < n; i++) {
			num ^= i + 1;
			num ^= nums[i];
		}
		return num;

        //TC:O(n)
        //SC:O(n)
	}

	private static int xor(int[] num) {

        //This is better in case of large numbers as it cannot cross the large number
        int XOR1=0, XOR2=0;
        for(int i=0;i<num.length;i++){
            XOR1=XOR1^num[i];
            XOR2=XOR2^i;
        }
        XOR2=XOR2^num.length;

        return  XOR1^XOR2;

        //TC:O(n)
        //SC:O(n)
    }

    public static int missingNumber(int[] nums) {

        int n=nums.length, sum=0,i=0;
        int actualsum=(n)*(n+1)/2;

        for( i=0;i<nums.length;i++)
            sum+=nums[i];
        return actualsum-sum;

        //SC:O(1)
        //TC:O(n)
    }
}
