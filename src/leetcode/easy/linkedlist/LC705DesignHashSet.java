package leetcode.easy.linkedlist;

import java.util.LinkedList;

public class LC705DesignHashSet {

	int bucketSize = 1000;

	LinkedList<Integer>[] bucket;

	private LC705DesignHashSet(int size) {
		bucket = new LinkedList[bucketSize];
	}

	private LC705DesignHashSet() {
		bucket = new LinkedList[bucketSize];
	}


	private void add(int key) {
		
		int i=hashFunction(key);
		if(bucket[i]==null)
			bucket[i] = new LinkedList<>();

		if (bucket[i].indexOf(key) == -1)
			bucket[i].add(key);
	}

	private int hashFunction(int key) {

		return key % bucketSize;
	}

	private void remove(int key) {
		int i = hashFunction(key);

		if (bucket[i] == null || bucket[i].indexOf(key) == -1)
			return;

		bucket[i].remove(bucket[i].indexOf(key));
	}

	private boolean contains(int key) {

		int i = hashFunction(key);
		if (bucket[i] == null || bucket[i].indexOf(key) == -1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		
		LC705DesignHashSet lc=new LC705DesignHashSet(10);

		System.out.println(lc.contains(1));
		lc.add(1);
		System.out.println(lc.contains(1));


	}

}
