package geeksForGeeks;

import java.util.Scanner;

public class toCheckPrimeNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// System.out.println("Enter the size of the array:");
		// int size = scan.nextInt();
		int[] arr = new int[100];
		// System.out.println("Enter the elemts in the array:");
		for (int i = 0; i < 100; i++)
			arr[i] = i + 1;
		int pno = 0;
		int npno = 0;
		for (int j = 0; j < 100; j++) {
			int flag = 0;
			for (int i = 2; i <= arr[j] / 2; i++) {
				if (arr[j] == 2) {
					System.out.println("prime");
					pno++;
					break;
				}
				if (arr[j] == 1) {
					System.out.println("not a primne number");
					flag=1;
					break;
				}
				else if (arr[j] % i == 0) {
					flag = 1;
					break;
				} else
					continue;

			}
			if (flag == 0) {
				System.out.println(arr[j] + "-->prime");
				pno++;
			} else {
				System.out.println(arr[j] + "-->Not prime");
				npno++;
			}
		}
		System.out.println("Number of prime nos: " + pno);

		scan.close();
	}

}
