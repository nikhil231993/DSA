package leetcode.array.extra;

public class GfgSecondLargestAndsecondSmallest {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,4,7,7,5};
        int[] result= getSecondOrderElements(nums);

        System.out.println("SecondLargest: "+ result[0]);
        System.out.println("SecondSmallest: "+ result[1]);
        //TC:O(n)
        //SC:O(1)
    }

    public static int[] getSecondOrderElements(int []a) {
        Integer max=Integer.MIN_VALUE;
        Integer secondMax=Integer.MIN_VALUE;
        Integer smallest=Integer.MAX_VALUE;
        Integer secondSmallest=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                secondMax=max;
                max=a[i];
            }else if(a[i]>secondMax && a[i]!=max){
                secondMax=a[i];
            }
            if(a[i]<smallest){
                secondSmallest=smallest;
                smallest=a[i];
            }else if(a[i]<secondSmallest && a[i]!=smallest){
                secondSmallest=a[i];
            }

        }
        return new int[]{secondMax, secondSmallest };
    }
}
