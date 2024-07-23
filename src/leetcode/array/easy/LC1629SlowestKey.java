package leetcode.array.easy;

public class LC1629SlowestKey {

	public static void main(String[] args) {

		int[] arr = new int[] { 12, 23, 36, 46, 62 };
		String s = "spuda";

		System.out.println(slowestKey(arr, s));
	}

	private static char slowestKey(int[] releaseTimes, String keysPressed) {

		int n=releaseTimes.length;
		char ch=keysPressed.charAt(0);
		int max=releaseTimes[0];
		for(int i=1;i<n;i++){
			if((releaseTimes[i]-releaseTimes[i-1])>max){
				max=releaseTimes[i]-releaseTimes[i-1];
				ch=keysPressed.charAt(i);
			}else if((releaseTimes[i]-releaseTimes[i-1])==max && keysPressed.charAt(i)>ch){
				ch=keysPressed.charAt(i);
			}
		}
		return ch;

		//TC:O(n)
		//SC:O(1)
	}
}
