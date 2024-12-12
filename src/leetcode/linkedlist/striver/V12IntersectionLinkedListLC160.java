package leetcode.linkedlist.striver;

public class V12IntersectionLinkedListLC160 {

    //Approach 1: Put each node of one LL in HashSet and then iterate through other node and check if it exists in it.

    //Approach 2: Find the length of each linked list and then find diff. Jump the diff in the long LL and then start both iteration
    //together and then find which one matches

    //Approach 3:

    /**
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null || headB==null)
            return null;
        ListNode temp1=headA;
        ListNode temp2=headB;

        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;
            if(temp1==temp2)
                return temp1;
            if(temp1==null){
                temp1=headB;
            }
            if(temp2==null){
                temp2=headA;
            }
        }
        return temp1; // This for the first node which might be equal
    }
     TC:O(N1+N2)
     SC:O(1)
     */
}
