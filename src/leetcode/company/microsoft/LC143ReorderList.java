package leetcode.company.microsoft;

public class LC143ReorderList {
/*
    class Solution {
        public void reorderList(ListNode head) {
            if(head==null)
                return ;
            ListNode slow=head;
            ListNode fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode current=slow.next;
            slow.next=null;
            ListNode prev=null;
            ListNode next=null;
            while(current!=null){
                next=current.next;
                current.next=prev;
                prev=current;
                current=next;
            }
            ListNode firstHead=head;
            ListNode secondHead=prev;
            while(secondHead!=null){
                ListNode firstNext=firstHead.next;
                ListNode secondNext=secondHead.next;
                firstHead.next=secondHead;
                secondHead.next=firstNext;
                firstHead=firstNext;
                secondHead=secondNext;
            }
        }
    }
 */
}
