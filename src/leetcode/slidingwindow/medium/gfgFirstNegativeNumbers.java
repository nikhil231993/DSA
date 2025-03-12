package leetcode.slidingwindow.medium;

import java.util.ArrayList;
import java.util.List;

public class gfgFirstNegativeNumbers {

    public static void main(String[] args) {

        int N = 5, K=2;
        long[] A = new long[]{-8, 2, 3, -6, 10};

        //Approach 1: Brute force

        //Approach 2: Better
        long[] r1=printFirstNegativeInteger(A, N, K);
        for(long n: r1)
            System.out.println(n);

        System.out.println("***********************");

        //Approach 3: Best
        long[] r2=printFirstNegativeIntegerBest(A, N, K);
        for(long n: r2)
            System.out.println(n);
    }

    private static long[] printFirstNegativeIntegerBest(long A[], int N, int K) {

        long[] subArr=new long[N-K+1];
        int i=0, left=0, right=0;
        List<Long> list=new ArrayList<Long>();
        while(right<N){

            if(A[right]<0)
                list.add(A[right]);
            if(right-left+1==K){

                if(list.size()==0){
                    subArr[i]=0;
                }else {
                    subArr[i]=list.get(0);
                    if(A[left]==list.get(0))
                        list.remove(0);
                }
                left++;
                i++;
            }
            right++;
        }
        return subArr;

        //TC:O(n)
        //SC:O(1)
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K) {

        long[] subArr=new long[N-K+1];
        int i=0, left=0, right=0;
        List<Long> list=new ArrayList<Long>();
        while(right<N){

            if(A[right]<0)
                list.add(A[right]);
            while(right-left+1==K){ // can use if also here

                if(list.size()==0){
                    subArr[i]=0;
                }else {
                    subArr[i]=list.get(0);
                    if(A[left]==list.get(0))
                        list.remove(0);
                }
                left++;
                i++;
            }
            right++;
        }
        return subArr;

        //TC:O(n)
        //SC:O(1)
    }
}
