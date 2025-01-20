package leetcode.array.easy;

public class LC1470ShuffleArray {

    public static void main(String[] args) {

       int[] nums =new int[] {2,5,1,3,4,7};
       int n = 3;

       //Approach 1
       int[] r=shuffle(nums,n);
       for(int n1:r)
           System.out.print(n1);

        System.out.println();
        System.out.println("######################");

       //Approach 2
        int[] r1=shuffleBetter(nums,n);
        for(int n1:r1)
            System.out.print(n1);

        System.out.println();
        System.out.println("######################");

        //Approach 3
        int[] r2=shuffleBetter(nums,n);
        for(int n1:r2)
            System.out.print(n1);
    }

    public static int[] shuffle(int[] nums, int n) {

        int[] temp=new int[n];
        int s=0;
        for(int p=0; p<n; p++)
            temp[s++]=nums[p];

        int[] temp1=new int[n];
        int l=0;
        for(int q=n; q<2*n; q++)
            temp1[l++]=nums[q];

        int[] result=new int[2*n];
        int k=0;

        int i=0, j=0;
        int flag=0;
        while(i<n || j<n){
            if(flag==0){
                result[k++]=temp[i++];
                flag=1;
            }
            else {
                result[k++] = temp1[j++];
                flag = 0;
            }
        }
        return result;
    }

    public static int[] shuffleBetter(int[] nums, int n) {

        int[] result= new int[2*n];
        int i=0,j=n,k=0;
        while(i<n && j<2*n){
            result[k++]=nums[i++];
            result[k++]=nums[j++];
        }
        return result;
    }

    public static int[] shuffleSelf(int[] nums, int n) {

        int[] result=new int[nums.length];
        int k=0;
        for(int i=0;i<nums.length/2;i++){
            result[k]=nums[i];
            result[k+1]=nums[i+n];
            k=k+2;
        }
        return result;
    }
}
