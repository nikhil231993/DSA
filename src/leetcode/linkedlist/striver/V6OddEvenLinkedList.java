package leetcode.linkedlist.striver;

public class V6OddEvenLinkedList {

    //Approach 1 : Create a arr and store the values in it and then retrieve it back and put it in LinkedList
    // Do eth above first for odd index and then for even. Handle last node specifically

    //Approach 2
    /**
    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null)
            return ListNode;

        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=head.next;

        while(even!=null && even.next !=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return odd;
    }
     TC:O(N/2)*2 as we move two steps at a time
     SC:O(1)
     */
}
