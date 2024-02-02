package leetcode.linkedlist.striver;

public class V15LengthOfLoopLinkedList {

    //Approach 1: Parse each element and put it in hashset and then find where loop exist. Then parse again from that point
    // till u come back to same point and have count incremented. Final count will be the answer.

    //Approach 2:

    /**
    public static int lengthOfLoop(Node head) {
        if(head==null)
            return 0;
        Node slow=head;
        Node fast=head;
        int count=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }

        if(fast==null)
            return 0;

        Node temp=fast;
        count++;
        temp=temp.next;
        while(temp!=fast){
            count++;
            temp=temp.next;
        }
        return count;
    }
     */
}
