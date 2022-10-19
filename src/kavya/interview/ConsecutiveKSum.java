package kavya.interview;

import java.util.Scanner;

public class ConsecutiveKSum {

    //driver
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter value for n");
        int n = sc.nextInt();
        System.out.println("Enter values");
        int num[] = new int[n];
        for(int i =0;i<n;i++){
            num[i] = sc.nextInt();
        }
        System.out.println("Enter value for k");
        int k = sc.nextInt();
        System.out.println("Maximum sum: " + findMaxSum(num,n,k));
    }

    private static int findMaxSum(int[] num, int n, int k) {
        if(k>n){
            System.out.println("Impossible combination");
        }
        int maxSum = 0;
//        int currentSum = 0;
        for(int i=0;i<k;i++){
            maxSum = maxSum + num[i];
        }
        int currentSum = maxSum;
        for (int j=k;j<n;j++){
            currentSum = currentSum+num[j]-num[j-k];
            if(currentSum>maxSum){
                maxSum=currentSum;
            }
        }
        return maxSum;
    }
}
