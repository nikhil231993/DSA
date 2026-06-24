package leetcode.company.microsoft;

public class LC432AllOneDataStructure {

    //Approach 1 : Using list but it takes O(n) in removing from the list to search and delete it
    /*
    class Node{
    int count;
    List<String> keys;
    Node next;
    Node prev;
    public Node(int count){
        keys=new ArrayList<>();
        this.count=count;
        next=null;
        prev=null;
    }
}

class AllOne {

    Map<String, Node> map=new HashMap<>();
    Node head;
    Node tail;
    public AllOne() {
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.prev=head;
    }

    private void addNode(Node n, int count){
        Node node=new Node(count);
        node.next=n.next;
        n.next.prev=node;
        n.next=node;
        node.prev=n;
    }

    private void removeNode(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }

    public void inc(String key) {
        if(!map.containsKey(key)){
            if(head.next.count!=1)
                addNode(head, 1);
            head.next.keys.add(key);
            map.put(key, head.next);
        }else{

            Node n=map.get(key);
            int count=n.count;
            if(n.next.count!=count+1)
                addNode(n, count+1);

            n.next.keys.add(key);
            map.put(key, n.next);
            n.keys.remove(key);
            if(n.keys.isEmpty()){
                removeNode(n);
            }
        }
    }

    public void dec(String key) {
        if(!map.containsKey(key)) return;
        Node n=map.get(key);
        if(n.count==1){
            n.keys.remove(key);
            if(n.keys.isEmpty())
                removeNode(n);
            map.remove(key);
        }else{
            int count=n.count;
            if(n.prev.count!=count-1){
                addNode(n.prev, count-1);
            }
            n.prev.keys.add(key);
            map.put(key, n.prev);
            n.keys.remove(key);
            if(n.keys.isEmpty())
                removeNode(n);
        }
    }

    public String getMaxKey() {
        if(tail.prev.keys.size()!=0) return tail.prev.keys.get(0);
        return "";
    }

    public String getMinKey() {
        if(head.next.keys.size()!=0) return head.next.keys.get(0);
        return "";
    }
}
     */

    //Approach 2: Using set as set internally uses hashmap to find the bucket and the item
    /*
    class Node{
    int count;
    Set<String> keys;
    Node next;
    Node prev;
    public Node(int count){
        keys=new HashSet<>();
        this.count=count;
        next=null;
        prev=null;
    }
}

class AllOne {

    Map<String, Node> map=new HashMap<>();
    Node head;
    Node tail;
    public AllOne() {
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.prev=head;
    }

    private void addNode(Node n, int count){
        Node node=new Node(count);
        node.next=n.next;
        n.next.prev=node;
        n.next=node;
        node.prev=n;
    }

    private void removeNode(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }

    public void inc(String key) {
        if(!map.containsKey(key)){
            if(head.next.count!=1)
                addNode(head, 1);
            head.next.keys.add(key);
            map.put(key, head.next);
        }else{

            Node n=map.get(key);
            int count=n.count;
            if(n.next.count!=count+1)
                addNode(n, count+1);

            n.next.keys.add(key);
            map.put(key, n.next);
            n.keys.remove(key);
            if(n.keys.isEmpty()){
                removeNode(n);
            }
        }
    }

    public void dec(String key) {
        if(!map.containsKey(key)) return;
        Node n=map.get(key);
        if(n.count==1){
            n.keys.remove(key);
            if(n.keys.isEmpty())
                removeNode(n);
            map.remove(key);
        }else{
            int count=n.count;
            if(n.prev.count!=count-1){
                addNode(n.prev, count-1);
            }
            n.prev.keys.add(key);
            map.put(key, n.prev);
            n.keys.remove(key);
            if(n.keys.isEmpty())
                removeNode(n);
        }
    }

    public String getMaxKey() {
        if(tail.prev.keys.size()!=0) return tail.prev.keys.iterator().next();
        return "";
    }

    public String getMinKey() {
        if(head.next.keys.size()!=0) return head.next.keys.iterator().next();
        return "";
    }
}
     */
}
