package leetcode.array.extra;

import java.util.Arrays;

public class RepeatingAndMissingNumbers {

    public static void main(String[] args) {
        int[] num=new int[]{3,1,2,5,4,6,7,5};

        //Brute
        //Using two for loops

        //Better
        int[] result=brute(num);
        for(int n:result)
            System.out.println(n);

        //optimal
        int[] result1=optimal1(num);
        for(int n:result1)
            System.out.println(n);
    }

    private static int[] optimal1(int[] num) {
        int n= num.length;
        long s=0,sn=0;
        long s2=0,s2n=0;
        sn=(n*(n+1))/2;
        s2n=(n*(n+1)*(2*n+1))/6;
        for(int i=0;i<n;i++){
            s+=num[i];
            s2+=num[i]*num[i];
        }

        long first=s-sn;
        long second=s2-s2n;
        long val=second/first;
        long repeating=(val+first)/2;
        long missing=val-repeating;

        return new int[]{(int)repeating,(int)missing};

        //TC:O(n)
        //SC:O(n)
    }

    private static int[] brute(int[] num) {

        int[] arr=new int[num.length+1];

        for(int i=0;i<num.length;i++){
            arr[num[i]]++;
        }

        int repeating=-1;
        int missing=-1;
        for(int i=1;i<=num.length;i++){
            int count=arr[i];
            if(count==2)
                repeating=i;
            else if(count==0)
                missing=i;

        }
        return new int[]{repeating,missing};

        //TC:O(n)
        //SC:O(n)
    }
}
