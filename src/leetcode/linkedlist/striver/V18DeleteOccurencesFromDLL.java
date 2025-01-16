package leetcode.linkedlist.striver;

public class V18DeleteOccurencesFromDLL {

    //Approach 3 is simple to understand

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

    //Approach 2:

    /**
    public static Node deleteAllOccurrences(Node head, int k) {

        Node temp=head;
        while(temp!=null){
            if(temp.data==k){
                if(temp==head){
                    head=head.next;
                    temp=temp.next;
                    continue;
                }
                Node prevNode=temp.prev;
                Node nextNode=temp.next;
                if(nextNode!=null){
                    nextNode.prev=prevNode;
                }
                //if(prevNode!=null){
                prevNode.next=nextNode;
                //}
                temp=nextNode;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }
     */

    //Approach 3

    /**
    public static Node deleteAllOccurrences(Node head, int k) {

        if(head==null) return null;

        while(head!=null && head.data==k){
            head=head.next;
        }

        Node temp=head;

        while(temp!=null){
            if(temp.data!=k)
                temp=temp.next;
            else{
                Node prevNode=temp.prev;
                Node nextNode=temp.next;
                if(nextNode!=null){
                    nextNode.prev=prevNode;
                }
                prevNode.next=nextNode;
                temp=nextNode;
            }
        }
        return head;
    }
     */
}
