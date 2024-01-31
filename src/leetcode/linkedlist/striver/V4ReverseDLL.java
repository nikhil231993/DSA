package leetcode.linkedlist.striver;

public class V4ReverseDLL {

    public static void main(String[] args) {

        //Approach 1 : Using a stack

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
        NodeDLL current=head;

        while(current!=null){
            prev=current.prev;
            current.prev=current.next;
            current.next=prev;

            current=current.prev;
        }
        return prev.prev;

        //TC:O(n)
        //SC:O(1)
    }
}
