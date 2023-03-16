package learningLogic.recursion.striver;

public class V3SumOfNNumbers {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum=0;
		// Parmetries .i.e. Method prints the result
		sum(numbers, numbers.length - 1,sum);

		//Functional .i.e., Function returns final data
		int result = sumFunctional(numbers, numbers.length - 1);
		System.out.println(result);
		
		// Factorial parameterised
		int product = 1;
		parameterised(5, product);

		// Factorial Functional
		int re = parameterisedFunctional(5);
		System.out.println(re);

	}

	private static int parameterisedFunctional(int r) {
		if(r==1)
			return 1;
		return r * parameterisedFunctional(r - 1);
	}

	private static void parameterised(int n, int product) {
		if (n == 1) {
			System.out.println(product);
			return;
		}
		product *= n;
		parameterised(n - 1, product);

	}

	private static int sumFunctional(int[] numbers, int i) {
		if (i < 0)
			return 0;
		return numbers[i] + sumFunctional(numbers, i - 1);
	}

	private static void sum(int[] numbers, int i, int sum) {
		if (i < 0) {
			System.out.println(sum);
			return;
		}
		sum+=numbers[i--];
		sum(numbers, i,sum);
	}

}
