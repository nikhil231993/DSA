package learningLogic.LinkedList;

public class LinkedListGeeks {
//
//
//    Node head; // head of list
//   
//    // Linked list Node.
//    // This inner class is made static
//    // so that main() can access it
//    static class Node {
//   
//        int data;
//        Node next;
//   
//        // Constructor
//        Node(int d)
//        {
//            data = d;
//            next = null;
//        }
//    }
//   
//    // Method to insert a new node
//    public static insert(int data)
//    {
//        // Create a new node with given data
//        Node new_node = new Node(data);
//        new_node.next = null;
//   
//        // If the Linked List is empty,
//        // then make the new node as head
//        if (head == null) {
//            head = new_node;
//        }
//        else {
//            // Else traverse till the last node
//            // and insert the new_node there
//            Node last = head;
//            while (last.next != null) {
//                last = last.next;
//            }
//   
//            // Insert the new_node at last node
//            last.next = new_node;
//        }
//   
//        // Return the list by head
//        
//    }
//   
//    // Method to print the LinkedList.
//    public static void printList(LinkedListGeeks list)
//    {
//        Node currNode = list.head;
//    
//        System.out.print("LinkedList: ");
//    
//        // Traverse through the LinkedList
//        while (currNode != null) {
//            // Print the data at current node
//            System.out.print(currNode.data + " ");
//    
//            // Go to next node
//            currNode = currNode.next;
//        }
//    }
//    
//    // Driver code
//    public static void main(String[] args)
//    {
//        /* Start with the empty list. */
//    	LinkedListGeeks list = new LinkedListGeeks();
//   
//        //
//        // ******INSERTION******
//        //
//   
//        // Insert the values
//        insert(1);
//        insert(2);
//        insert(3);
//        insert(4);
//   
//        // Print the LinkedList
//        printList(list);
//    }
}
