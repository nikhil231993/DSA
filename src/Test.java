
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        next = null;
    }
}
public class Test {
//    i/p - 0-> 1 -> 2 -> 3 -> 4 -> 5->null
//    k = 2
//            4->5->0->1->2->3
//    len = 6
//    point = len - k

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int k = 2;
        Node head = null;
        Node temp = null;
        for (int num : nums) {
            if (head == null) {
                head = new Node(num);
                temp = head;
            } else {
                temp.next = new Node(num);
                temp = temp.next;
            }
        }
        int len = findLen(head);
        System.out.println(len);
        int breakingPoint = len - k;
        System.out.println(breakingPoint);
        int count = 0;
        Node tail = findTail(head);
        tail.next = head;
        Node temp1 = head;
        while (temp1 != null) {
            if (count == breakingPoint-1) {
                break;
            }
            count++;
            temp1 = temp1.next;
        }
        Node newHead = temp1.next;
        temp.next = null;
        System.out.println(newHead);

    }

    private static Node findTail(Node head) {
        Node temp =  head;
        Node prev = null;
        while (temp != null) {
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }
    private static int findLen(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

}
