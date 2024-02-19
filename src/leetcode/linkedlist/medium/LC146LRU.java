package leetcode.linkedlist.medium;

public class LC146LRU {

    /**
    class LRUCache {
        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        int cap;
        HashMap<Integer, Node> m = new HashMap<>();

        public LRUCache(int capacity) {
            cap = capacity;
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(Node newnode) {
            m.put(newnode.key, newnode);
            Node temp = head.next;

            newnode.next = temp;
            newnode.prev = head;

            head.next = newnode;
            temp.prev = newnode;
        }

        private void deleteNode(Node delnode) {
            m.remove(delnode.key);
            Node prevv = delnode.prev;
            Node nextt = delnode.next;

            prevv.next = nextt;
            nextt.prev = prevv;
        }

        public int get(int key) {
            if (m.containsKey(key)) {
                Node resNode = m.get(key);
                deleteNode(resNode);
                addNode(resNode);
                return resNode.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (m.containsKey(key)) {
                deleteNode(m.get(key));
            }

            if (m.size() == cap) {
                deleteNode(tail.prev);
            }

            addNode(new Node(key, value));

        }
    }
     */
}
