package leetcode.linkedlist.striver;

public class V13MiddleOfLinkedList {

    //Approach 1: Count the entire length of LL and then delete the node in next parse which is at (N/2)+1;

    /**
    ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp!=null) {
            n++;
            temp = temp.next;
        }

        temp = head;

        for(int i = 0; i < n / 2; i++) {
            temp = temp.next;
        }

        return temp;
    }
     */

    //Approach 2:

    /**
    public ListNode middleNode(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
     TC:O(N/2)
     SC:O(1)
     */
}
