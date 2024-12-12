package leetcode.linkedlist.striver;

public class V4ReverseDLL {

    public static void main(String[] args) {

        //Approach 1: Take a Stack and put the values in the stack
        //TC:O(2N)
        //SC:O(N) we use external Stack

        //Approach 2
        int[] arr=new int[]{5,10,15,20,25};

        NodeDLL head=new NodeDLL(arr[0]);

        System.out.println("Convert Array to DLL");
        V3DoublyLinkedList.convertArrayToDLL(head, arr);
        V3DoublyLinkedList.display(head);

        System.out.println("Reverse DLL");
        NodeDLL newHead=reverseDLL(head);
        V3DoublyLinkedList.display(newHead);
    }

    private static NodeDLL reverseDLL(NodeDLL head) {

        if(head==null || head.next==null)
            return head;

        NodeDLL prev=null;
        NodeDLL temp=head;

        while(temp!=null){
            prev=temp.prev;
            temp.prev=temp.next;
            temp.next=prev;

            temp=temp.prev;
        }
        return prev.prev; // here due to swapping above in line 34 prev will be second last node
        // so we use prev.prev to return the last node which will be the new head

        //TC:O(n)
        //SC:O(1)
    }
}
