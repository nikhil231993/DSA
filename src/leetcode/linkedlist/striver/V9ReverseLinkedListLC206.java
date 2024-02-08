package leetcode.linkedlist.striver;

public class V9ReverseLinkedListLC206 {

    //Approach 1: Take elements and put it in Stack

    //Approach 2: Iterative

    /**
    public ListNode reverseList(ListNode head) {

        ListNode prev=null;
        ListNode next=null;
        ListNode current=head;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
     TC:O(n)
     SC:O(1)
     */

    //Approach 3
    /**
    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
     TC:O(n)
     SC:O(n) stack space
    */
}
