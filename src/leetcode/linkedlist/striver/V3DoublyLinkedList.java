package leetcode.linkedlist.striver;

public class V3DoublyLinkedList {

    public static void main(String[] args) {

        int[] arr=new int[]{5,10,15,20,25};

        NodeDLL head=new NodeDLL(arr[0]);

        System.out.println("Convert Array to DLL");
        NodeDLL newHead=convertArrayToDLL(head, arr);
        display(newHead);

        System.out.println("Delete the head of the LinkedList");
        NodeDLL newHead1=deleteHead(newHead);
        display(newHead1);
    }

    private static NodeDLL deleteHead(NodeDLL head) {

        if(head==null)
            return null;
        head.next.prev=null;
        head=head.next;
        return head;
    }

    private static void display(NodeDLL head) {

        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }

    private static NodeDLL convertArrayToDLL(NodeDLL head, int[] arr) {

        NodeDLL temp=head;
        for(int i=1; i<arr.length;i++){
            NodeDLL n=new NodeDLL(arr[i]);
            n.prev=temp;
            temp.next=n;
            temp=n;
        }
        return head;
    }
}
