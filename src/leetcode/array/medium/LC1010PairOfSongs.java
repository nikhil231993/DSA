package leetcode.array.medium;

public class LC1010PairOfSongs {

	public static void main(String[] args) {

		int[] time = new int[] { 30, 20, 150, 100, 40, 80 };

		//Approach 1: Brute 1st approach is n square where we are going to loop through it
		System.out.println(pairDivisibleBruteForce(time));

		//Approach 2: Optimal Below is the best approach where we check for complement
		System.out.println(pairDivisible(time));
	}

	private static int pairDivisibleBruteForce(int[] time) {

		 int count=0;

		 for(int i=0; i<time.length-1; i++){
		     for(int j=i+1; j<time.length; j++){
		         if((time[i]+time[j])%60 == 0){
		             count++;
		         }
		     }
		 }
		 return count;

		 //TC:O(n2)
		 //SC:O(1)
	}

	private static int pairDivisible(int[] time) {

		int count = 0;
		int[] rest = new int[60];

		for (int t : time) {
			int value = t % 60;
			if (value == 0)
				count += rest[value];
			else {
				count += rest[60 - value];
			}
			rest[value]++;
		}

		return count;

		//TC:O(n)
		//SC:O(1)
	}
}
