package leetcode.linkedlist.striver;

public class V3DoublyLinkedList {

    public static void main(String[] args) {

        int[] arr=new int[]{5,10,15,20,25};

        NodeDLL head=new NodeDLL(arr[0]);

        System.out.println("Convert Array to DLL");
        convertArrayToDLL(head, arr);
        display(head);

        System.out.println("Delete the head of the LinkedList");
        int[] arr1=new int[]{5,10,15,20,25};
        NodeDLL head1=new NodeDLL(arr1[0]);
        convertArrayToDLL(head1, arr1);
        NodeDLL newHead1=deleteHead(head1);
        display(newHead1);

        System.out.println("Delete Node at the Last ");
        int[] arr2=new int[]{5,10,15,20,25};
        NodeDLL head2=new NodeDLL(arr2[0]);
        convertArrayToDLL(head2, arr2);
        NodeDLL newHead2=deleteLast(head2);
        display(newHead2);

        System.out.println("Delete Node at a particular position ");
        int[] arr3=new int[]{5,10,15,20,25};
        int k=6;
        NodeDLL head3=new NodeDLL(arr3[0]);
        convertArrayToDLL(head3, arr3);
        NodeDLL newHead3=deleteParticularPosition(head3,k);
        display(newHead3);

        System.out.println("Delete a particular node ");
        int[] arr4=new int[]{5,10,15,20,25};
        NodeDLL head4=new NodeDLL(arr3[0]);
        convertArrayToDLL(head4, arr4);
        deleteParticularNode(head4.next.next.next.next);
        display(head4);
    }

    private static void deleteParticularNode(NodeDLL node) {
        NodeDLL back=node.prev;
        NodeDLL front=node.next;

        if(front==null){ //This means it is the last element which has to be deleted
            node.prev=null;
            back.next=null;
            return;
        }

        back.next=front;
        front.prev=back;
        node.next=node.prev=null;
    }

    private static NodeDLL deleteParticularPosition(NodeDLL head, int k) {

        if(head==null)
            return null;

        int count=0;
        NodeDLL temp=head;
        while(temp!=null){
            count++;
            if(count==k)
                break;
            temp=temp.next;
        }

        //Handle size more than teh DLL
        if(temp==null){
            System.out.println("Specified location is more");
            return null;
        }

        NodeDLL back=temp.prev;
        NodeDLL front=temp.next;

        if(back==null && front ==null)
            return null;
        else if(back==null)
            return deleteHead(head);
        else if(front==null)
            return deleteLast(head);

        back.next=front;
        front.prev=back;
        temp.next=null;//Delete prev connection
        temp.prev=null;//Delete next connection

        return head;
    }

    private static NodeDLL deleteLast(NodeDLL head) {

        if(head==null || head.next==null)
            return null;

        NodeDLL temp=head;

        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next.prev=null;
        temp.next=null;
        return head;
    }

    private static NodeDLL deleteHead(NodeDLL head) {

        if(head==null || head.next==null)
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

    private static void convertArrayToDLL(NodeDLL head, int[] arr) {

        NodeDLL temp=head;
        for(int i=1; i<arr.length;i++){
            NodeDLL n=new NodeDLL(arr[i]);
            n.prev=temp;
            temp.next=n;
            temp=n;
        }
    }
}
