package leetcode.company.microsoft;

public class InsertDeleteGetMax {

    //Without Duplicate

    /* Approach 1

    package problems.interview.microsoft;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class MaxDataStructure {

    private Set<Integer> set;
    private PriorityQueue<Integer> maxHeap;

    public MaxDataStructure() {
        set = new HashSet<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    // Insert element
    public void insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            maxHeap.add(val);
            System.out.println(val + " inserted");
        } else {
            System.out.println(val + " already exists");
        }
    }

    // Check if element exists
    public boolean get(int val) {
        return set.contains(val);
    }

    // Get maximum element
    public int getMax() {
        if (maxHeap.isEmpty()) {
            throw new RuntimeException("No elements present");
        }
        return maxHeap.peek();
    }

    // Delete element
    public void delete(int val) {

        if (!set.contains(val)) {
            System.out.println(val + " not found");
            return;
        }

        set.remove(val);
        maxHeap.remove(val);

        System.out.println(val + " deleted");
    }

    // Print current elements
    public void printState() {
        System.out.println("Set : " + set);
        System.out.println("Heap: " + maxHeap);
        System.out.println();
    }

    public static void main(String[] args) {

        MaxDataStructure ds = new MaxDataStructure();

        // Insert elements
        ds.insert(10);
        ds.insert(5);
        ds.insert(30);
        ds.insert(20);

        ds.printState();

        // Check elements
        System.out.println("Does 5 exist? " + ds.get(5));
        System.out.println("Does 100 exist? " + ds.get(100));

        System.out.println();

        // Get maximum element
        System.out.println("Max element: " + ds.getMax());

        System.out.println();

        // Delete elements
        ds.delete(30);

        ds.printState();

        System.out.println("New Max element: " + ds.getMax());
    }
}

     */


    /* Approach 2
    import java.util.*;

class MaxDataStructure {

    private PriorityQueue<Integer> heap;
    private HashSet<Integer> set;

    public MaxDataStructure() {

        heap = new PriorityQueue<>((a,b)->b-a);
        set = new HashSet<>();
    }

    public void insert(int val){

        if(set.add(val)){
            heap.offer(val);
        }
    }

    public void delete(int val){

        set.remove(val);
    }

    public boolean contains(int val){

        return set.contains(val);
    }

    public int getMax(){

        while(!heap.isEmpty() &&
                !set.contains(heap.peek())){

            heap.poll();
        }

        if(heap.isEmpty())
            throw new RuntimeException();

        return heap.peek();
    }
}

     */


    /* Approach 3
    import java.util.TreeSet;

class MaxDataStructure {

    private TreeSet<Integer> tree;

    public MaxDataStructure() {
        tree = new TreeSet<>();
    }

    public void insert(int val) {
        tree.add(val);
    }

    public boolean contains(int val) {
        return tree.contains(val);
    }

    public void delete(int val) {
        tree.remove(val);
    }

    public int getMax() {
        if(tree.isEmpty())
            throw new RuntimeException("Empty");

        return tree.last();
    }
}
     */



    // With Duplicates

    /*
    import java.util.*;

class MaxDS {

    private PriorityQueue<Integer> heap =
            new PriorityQueue<>((a,b)->b-a);

    private HashMap<Integer,Integer> freq =
            new HashMap<>();

    public void insert(int val){

        heap.offer(val);

        freq.put(val,
                freq.getOrDefault(val,0)+1);
    }

    public void delete(int val){

        if(!freq.containsKey(val))
            return;

        int count = freq.get(val);

        if(count==1)
            freq.remove(val);
        else
            freq.put(val,count-1);
    }

    public int getMax(){

        while(!heap.isEmpty()){

            int top = heap.peek();

            if(freq.containsKey(top))
                return top;

            heap.poll();
        }

        throw new RuntimeException();
    }
}
     */

    //Approach 2
    /*
    import java.util.TreeMap;

class MaxDS {

    private TreeMap<Integer,Integer> map = new TreeMap<>();

    public void insert(int val){

        map.put(val,
                map.getOrDefault(val,0)+1);
    }

    public void delete(int val){

        if(!map.containsKey(val))
            return;

        int freq = map.get(val);

        if(freq==1)
            map.remove(val);
        else
            map.put(val,freq-1);
    }

    public int getMax(){

        if(map.isEmpty())
            throw new RuntimeException();

        return map.lastKey();
    }
}
     */
}