package leetcode.linkedlist.striver;

public class V15LengthOfLoopLinkedList {

    //Approach 1: Parse each element and put it in map with node and step count. The moment u encounter same node in map then
    //subtract the count at that step and the value in map. That is the length of the cycle

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
