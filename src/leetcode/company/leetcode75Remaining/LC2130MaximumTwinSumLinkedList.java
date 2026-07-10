package leetcode.company.leetcode75Remaining;

public class LC2130MaximumTwinSumLinkedList {

    /*
    class Solution {
    public int pairSum(ListNode head) {
        if(head==null) return 0;
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=reverse(slow.next);
        slow.next=null;
        int max=0;
        ListNode temp=head;
        ListNode temp1=newHead;
        while(temp!=null && temp1!=null){
            max=Math.max(max, temp.val+temp1.val);
            temp=temp.next;
            temp1=temp1.next;
        }
        reverse(newHead);
        return max;
    }

    private static ListNode reverse(ListNode head){

        if(head==null) return head;
        ListNode current=head;
        ListNode next=null;
        ListNode prev=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
     */
}
