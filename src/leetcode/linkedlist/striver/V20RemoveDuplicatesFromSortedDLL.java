package leetcode.linkedlist.striver;

public class V20RemoveDuplicatesFromSortedDLL {

    public static void main(String[] args) {


        int[] arr=new int[]{1,1,2,3,3,4,5,5,6};

        NodeDLL head=new NodeDLL(arr[0]);

        System.out.println("Convert Array to DLL");
        V3DoublyLinkedList.convertArrayToDLL(head, arr);
        V3DoublyLinkedList.display(head);
        removeDuplicates(head);

        System.out.println("###################    After Removing Duplicates   ###################");
        V3DoublyLinkedList.display(head);
    }

    private static void removeDuplicates(NodeDLL head) {
        
        NodeDLL temp=head;
        while(temp!=null && temp.next!=null){
            NodeDLL nextNode=temp.next;

            while(nextNode!=null && nextNode.data==temp.data)
                nextNode=nextNode.next;

            temp.next=nextNode;
            if(nextNode!=null)
                nextNode.prev=temp;
            temp=temp.next;
        }
        //TC: O(N)
        //SC: O(1)
    }

    /** self 1
      class Solution {
          Node removeDuplicates(Node head) {
              if(head==null || head.next==null)
                  return head;

              Node temp=head;
              while(temp!=null){

                  Node prevNode=temp;
                  while(temp.next!=null && temp.data==temp.next.data){
                      temp=temp.next;
                  }
                  prevNode.next=temp.next;
                  if(temp.next!=null)
                      temp.next.prev=prevNode;
                  temp=temp.next;
              }
              return head;
          }
      }
     */

    /** Self 2
    class Solution {
        Node removeDuplicates(Node head) {
            if(head==null || head.next==null)
                return head;
            Node temp=head;
            while(temp!=null){
                Node nextNode=temp.next;
                while(nextNode!=null && nextNode.data==temp.data)
                    nextNode=nextNode.next;
                temp.next=nextNode;
                if(nextNode!=null)
                    nextNode.prev=temp;
                temp=temp.next;
            }
            return head;
        }
    }
     */
}
