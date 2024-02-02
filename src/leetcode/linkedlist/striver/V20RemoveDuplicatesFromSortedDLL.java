package leetcode.linkedlist.striver;

public class V20RemoveDuplicatesFromSortedDLL {

    public static void main(String[] args) {


        int[] arr=new int[]{1,1};

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
        }
        //TC:O(N)
        //SC:O(1)
    }
}
