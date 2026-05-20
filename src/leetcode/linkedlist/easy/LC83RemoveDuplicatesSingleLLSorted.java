package leetcode.linkedlist.easy;

public class LC83RemoveDuplicatesSingleLLSorted {

    /**
    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp=head;

        while(temp!=null && temp.next!=null){

            ListNode nextNode=temp.next;
            while(nextNode!=null && nextNode.val==temp.val){
                nextNode=nextNode.next;
            }
            temp.next=nextNode;
            temp=temp.next;
        }
        return head;
    }
     */
}
