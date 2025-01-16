package leetcode.linkedlist.striver;


import java.util.ArrayList;
import java.util.List;

public class V19FindPairsInDLL {

    //Approach 1 : Use two traversals using temp1 and temp2 and check for the sum (Nested Traversals )
    //TC:O(N*N)
    //SC:O(1)

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,9};
        int k =5;

        NodeDLL head=new NodeDLL(arr[0]);

        System.out.println("Convert Array to DLL");
        V3DoublyLinkedList.convertArrayToDLL(head, arr);
        V3DoublyLinkedList.display(head);

        //Approach 2
        List<int[]> list=new ArrayList<>();
        findPairs(head,k, list);

        for(int[] r: list){
            System.out.println(r[0]+"--"+r[1]);
        }
    }

    private static void findPairs(NodeDLL head, int k, List<int[]> list) {

        NodeDLL tail=head;
        while(tail.next!=null)
            tail=tail.next;

        NodeDLL start=head;
        while(start.data < tail.data){
            if(start.data + tail.data == k){
                list.add(new int[]{ start.data, tail.data });
                start=start.next;
                tail=tail.prev;
            }else if(start.data + tail.data > k)
                tail=tail.prev;
            else
                start=start.next;
        }
        //TC:O(2N)
        //SC:O(1)+ space for answers
    }
}
