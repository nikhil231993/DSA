import java.util.*;


class NodeLRU{

    protected int key;

    protected NodeLRU prev;

    protected NodeLRU next;

    public NodeLRU(int key){
        this.key=key;
        this.prev=null;
        this.next=null;
    }
}


class LRU{

    private int size=0;
    HashMap<Integer, NodeLRU> map;

    NodeLRU head=null;
    NodeLRU tail=null;

    public LRU(int size){
        this.size=size;
        this.map=new HashMap<>();
        head=new NodeLRU(-1);
        tail=new NodeLRU(-1);
        head.next=tail;
        tail.prev=head;
    }

    protected void refer(int key){

        if(map.size()<4){
            insert(key);
        }else{
            NodeLRU temp=tail.prev;
            remove(temp.key);
            insert(key);
        }
    }

    public void insert(int key){

        if(map.size()==0){
            put(key);
            return;
        }

        if(!map.containsKey(key)){
            put(key);
            return;
        }

        if(map.containsKey(key)){
            remove(key);
            put(key);
            return;
        }
    }

    public void remove(int key){

        NodeLRU temp=map.get(key);

        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        map.remove(key);
    }

    public void put(int key){

        NodeLRU node=new NodeLRU(key);
        map.put(key, node);
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    public void display(){

        NodeLRU temp=head.next;

        while(temp.key!=-1){
            System.out.println(temp.key);
            temp=temp.next;
        }
    }
}


public class Test3 {

    public static void main(String[] args) {

        LRU cache=new LRU(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);

        cache.display();
    }
}
