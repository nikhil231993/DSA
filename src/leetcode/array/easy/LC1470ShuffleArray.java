package leetcode.array.easy;

public class LC1470ShuffleArray {

    public static void main(String[] args) {
       int[] nums =new int[] {2,5,1,3,4,7};
       int n = 3;
       int[] r=shuffle(nums,n);
       for(int n1:r)
           System.out.println(n1);
    }

    public static int[] shuffle(int[] nums, int n) {

        int[] temp=new int[n];
        int s=0;
        for(int p=0;p<n;p++)
            temp[s++]=nums[p];

        int[] temp1=new int[n];
        int l=0;
        for(int q=n;q<2*n;q++)
            temp1[l++]=nums[q];

        int[] result=new int[2*n];
        int k=0;

        int i=0;
        int j=0;
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
}
