package leetcode.linkedlist.easy;

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

	private int hashFunction(int key) {

		return key % bucketSize;
	}

	private void add(int key) {

		int i = hashFunction(key);
		if (bucket[i] == null)
			bucket[i] = new LinkedList<>();

		if (bucket[i].indexOf(key) == -1)
			bucket[i].add(key);
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

	// 3rd Approac
	private int getPos(int key, int index) {

		if (bucket[index] == null)
			return -1;

		LinkedList<Integer> temp = bucket[index];

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i) == key)
				return i;
		}
		return -1;

	}

	private void addWithGetPos(int key) {

		int i = hashFunction(key);
		int pos = getPos(key, i);
		if (pos < 0) {
			bucket[i] = new LinkedList<Integer>();
		}
		bucket[i].add(key);
	}

	private void removeWithGetPos(int key) {
		int i = hashFunction(key);
		int pos = getPos(key, i);

		if (pos < 0)
			return;

		bucket[i].remove(pos);
	}

	private boolean containsWithGetPos(int key) {

		int i = hashFunction(key);
		int pos = getPos(key, i);
		if (pos < 0)
			return false;
		return true;
	}

	public static void main(String[] args) {

		LC705DesignHashSet lc = new LC705DesignHashSet(10);

		System.out.println(lc.containsWithGetPos(1));
		lc.add(1);
		lc.remove(1);
		System.out.println(lc.containsWithGetPos(1));

	}

}
