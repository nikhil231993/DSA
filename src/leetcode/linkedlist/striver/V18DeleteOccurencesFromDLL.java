package leetcode.linkedlist.striver;

public class V18DeleteOccurencesFromDLL {

    /**
    public static Node deleteAllOccurrences(Node head, int k) {

        Node temp=head;
        while(temp!=null){
            if(temp.data==k){
                if(temp==head){
                    head=head.next;
                }
                Node prevNode=temp.prev;
                Node nextNode=temp.next;
                if(nextNode!=null){
                    nextNode.prev=prevNode;
                }
                if(prevNode!=null){
                    prevNode.next=nextNode;
                }
                temp=nextNode;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }

     TC:O(N)
     SC:O(1)
         */
}
