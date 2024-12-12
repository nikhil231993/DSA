package leetcode.linkedlist.easy;

public class LC1290BinaryNumberToInteger {

    //Approach 1: We get the length and then traverse using binary to decimal formula

    /**
     int len=0;
     ListNode temp=head;
     while(temp!=null){
         len++;
         temp=temp.next;
     }
     int sum=0;
     len--;
      temp=head;
     while(temp!=null){
         sum+=Math.pow(2,len--)*temp.val;
         temp=temp.next;
     }
     return sum;
    SC:O(1)
    TC:O(n)
     */

    //Approach 2:

    /**
    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
        int sum=0;
        while(temp!=null){

            sum=2*sum+temp.val;
            temp=temp.next;
        }
        return sum;
    }
     */
}
