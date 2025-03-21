package leetcode.linkedlist.easy;

import java.util.LinkedList;

public class LC706DesignHashMap {

	//Approach 1:

	/**
	class MyHashMap {


		public int[] arr=new int[1000000+1];

		public MyHashMap() {
			Arrays.fill(arr, -1);
		}

		public void put(int key, int value) {
			arr[key]=value;
		}

		public int get(int key) {
			return arr[key];
		}

		public void remove(int key) {
			arr[key]=-1;
		}
	}
	 */

	public class Node {
		int key;
		int value;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	LinkedList<Node>[] bucket;

	int bucketSize = 1000;

	public LC706DesignHashMap() {
		bucket = new LinkedList[bucketSize];
	}

	public LC706DesignHashMap(int size) {

	}

	public int hash(int key) {
		return key % bucketSize;
	}

	public void put(int key, int value) {

		Node n=new Node(key, value);
		int i=hash(key);
		if(bucket[i]==null){
			bucket[i]=new LinkedList();
			bucket[i].add(n);
		}else{
			for(Node t : bucket[i]){
				if(t.key==key){
					t.value=value;
					return;
				}
			}
			bucket[i].add(n);
		}
	}

	public int getPos(int key, int i) {

		LinkedList<Node> list=bucket[i];

		int pos=0;
		for(Node temp:list){
			if(temp.key==key)
				return pos;
			pos++;
		}
		return -1;
	}

	public int get(int key) {

		int i=hash(key);
		if(bucket[i]==null)
			return -1;
		int pos=getPos(key, i);
		if(pos==-1)
			return -1;
		return bucket[i].get(pos).value;
	}

	public void remove(int key) {

		int i=hash(key);
		if(bucket[i]==null)
			return;
		int pos=getPos(key, i);
		if(pos==-1)
			return;
		bucket[i].remove(pos);
	}

	public static void main(String[] args) {

		LC706DesignHashMap m = new LC706DesignHashMap();

		System.out.println(m.get(1));

		m.put(1, 10);
		m.put(2, 20);
		System.out.println(m.get(2));
		System.out.println(m.get(1));
		m.put(1, 100);
		System.out.println(m.get(1));
	}
}
