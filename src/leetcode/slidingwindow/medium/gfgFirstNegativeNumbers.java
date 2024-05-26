package leetcode.slidingwindow.medium;

import java.util.ArrayList;
import java.util.List;

public class gfgFirstNegativeNumbers {

    public static void main(String[] args) {

        int N = 5, K=2;
        long[] A = new long[]{-8, 2, 3, -6, 10};
        System.out.println(printFirstNegativeInteger(A, N, K));
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K) {

        long[] subArr=new long[N-K+1];
        int i=0;
        int left=0, right=0;
        List<Long> list=new ArrayList<Long>();
        while(right<N){

            if(A[right]<0)
                list.add(A[right]);
            while(right-left+1==K){ // can use if also here

                if(list.size()==0){
                    subArr[i]=0;
                }else {
                    subArr[i]=list.get(0);
                    if(A[i]==list.get(0))
                        list.remove(0);
                }
                left++;
                i++;
            }
            right++;
        }
        return subArr;
    }
}
