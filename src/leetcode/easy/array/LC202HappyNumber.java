package leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

public class LC202HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappyFCD(17));
	}

	public static boolean isHappy(int n) {

		HashSet<Integer> sumDup = new HashSet<Integer>();
		while (n != 1) {

			if (sumDup.contains(n)) {
				return false;
			} else {
				sumDup.add(n);
				int sum = 0;
				while (n > 0) {

					int num = n % 10;
					sum += num * num;
					n = n / 10;
				}
				n = sum;

			}

		}
		return true;

	}

	




    public boolean isHappy2(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1){
            n = getDigits(n);
            
            //Exist in set checking
            if (set.contains(n)) return false;
            set.add(n);
            
        }
        return true;
    }
    
	public static boolean isHappyFCD(int n) {
        if (n == 1) return true;
        
		// int fast = getDigits(n);
        int slow = n;
		int fast = n;
        int count=0;
        do {
            slow = getDigits(slow);
            
			fast = getDigits(getDigits(fast));
//            fast = getDigits(fast);
			count++;
			System.out.println("count is: " + count);
			if (fast == 1 || slow == 1)
				return true;
		} while (fast != slow);

        return false;
    }
    
	public static int getDigits(int n) {
        int sum = 0;
        while (n > 0){
            int m = n % 10;
            sum += (m*m);
            n = n / 10;
        }
        return sum;
    }
}
