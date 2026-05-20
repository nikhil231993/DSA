package leetcode.slidingwindow.medium;

public class LC1052GrumpyOwner {

    public static void main(String[] args) {

        int[] customers = new int[] {1,0,1,2,1,1,7,5};
        int[] grumpy = new int[] {0,1,0,1,0,1,0,1};
        int minutes = 3;

        //Approach 1: for loop

        //Approach 2: Better using while instead of if

        //Approach 3:
        System.out.println(maxCustomers(customers,grumpy,minutes));

        //Approach 4: Usual two pointer
        System.out.println(maxSatisfied(customers,grumpy,minutes));
    }

    //Step 1: find the sum for all the customer when store owner was happy
    //Step 2: start from r and then add to sum if grumpy is 1
    //Step 3; if length of window is minutes then subtract the l value only if grumpy is 1 as the window will increase in future
    //Step 4: Store the max value nad decrease
    private static int maxCustomers(int[] customers, int[] grumpy, int minutes) {

        int sum=0;
        for(int i=0; i<customers.length; i++){
            if(grumpy[i]==0)
                sum+=customers[i];
        }
        int r=0, l=0, max=Integer.MIN_VALUE;

        while(r<customers.length){
            if(grumpy[r]==1)
                sum+=customers[r];
            if(r-l+1==minutes){  // we can use while also instead of if also here tested in leetcode
                max=Math.max(max,sum);
                if(grumpy[l]==1){
                    sum-=customers[l];
                }
                l++;
            }
            r++;
        }
        return max;
    }

    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n=customers.length, left=0, right=0, sum=0, max=0;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0)
                sum+=customers[i];
        }

        while(right<n){
            if(grumpy[right]==1)
                sum+=customers[right];
            while((right-left+1)>minutes){  // we cna use here if also
                if(grumpy[left]==1)
                    sum-=customers[left];

                left++;
            }
            if((right-left+1)<=minutes)
                max=Math.max(max, sum);

            right++;
        }
        return max;
    }
}
