package leetcode.linkedlist.striver;

public class V6OddEvenLinkedListLC328 {

    //Approach 1 : Create a arr and store the values in it and then retrieve it back and put it in LinkedList
    // Do the above first for odd index and then for even. Handle last node specifically

    //Approach 2
    /**
    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=head.next;

        while(even!=null && even.next !=null){
            odd.next=odd.next.next; // if we change order of this and below line we will get NPE because even changes before odd changes
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
     TC:O(N/2)*2 as we move two steps at a time
     SC:O(1)
     */
}
