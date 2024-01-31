package leetcode.linkedlist.striver;

public class V5AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

 /**
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum=0;
            int carry=0;
            ListNode l=new ListNode(-1);
            ListNode temp=l;
            while(l1!=null || l2!=null){
                sum=carry;
                if(l1!=null){
                    sum+=l1.val;
                    l1=l1.next;
                }
                if(l2!=null){
                    sum+=l2.val;
                    l2=l2.next;
                }

                ListNode n=new ListNode(sum%10);
                carry=sum/10;
                temp.next=n;
                temp=temp.next;

            }
            if(carry!=0){
                ListNode n1=new ListNode(carry);
                temp.next=n1;
            }

            return l.next;
        }
    }

  Time Complexity: O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively,
  the algorithm above iterates at most max(m,n) times.

  Space Complexity: O(max(m,n)). The length of the new list is at most max(m,n)+1.
  */
}
