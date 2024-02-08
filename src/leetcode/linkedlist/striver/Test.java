package leetcode.linkedlist.striver;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        Node n=new Node(1);
        n.next=new Node(2);
        n.next.next=new Node(3);

        Node head=n;
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
        HashMap<Integer, Node> map=new HashMap<>();
        map.put(n.data,n.next);
        map.put(n.next.data,n.next);
        map.put(n.next.next.data,n.next.next);

        Node temp=map.get(2);
        System.out.println(temp.hashCode());
    }
}
