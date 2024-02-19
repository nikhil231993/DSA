package leetcode.linkedlist.easy;

import java.util.LinkedList;

public class LC706DesignHashMap {

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

	public int hashFunction(int key) {
		return key % bucketSize;
	}

	public void put(int key, int value) {

		int i = hashFunction(key);

		if (bucket[i] == null) {
			bucket[i] = new LinkedList<Node>();
			LinkedList<Node> list = bucket[i];
			list.add(new Node(key, value));

		} else {

			for (Node entry : bucket[i]) {
				if (entry.key == key) {
					entry.value = value;
					return;
				}
			}
			bucket[i].add(new Node(key, value));
		}
	}

	public int getPos(int key) {

		int i = hashFunction(key);

		if (bucket[i] == null)
			return -1;

		int pos = 0;
		for (Node entry : bucket[i]) {
			if (entry.key == key) {
				return pos;
			}
			pos++;
		}
		return -1;
	}

	public int get(int key) {

		int i = hashFunction(key);
		int pos = getPos(key);

		if (pos < 0)
			return -1;

		LinkedList<Node> list = bucket[i];
		Node temp= list.get(pos);
		return temp.value;
	}

	public void remove(int key) {

		int i = hashFunction(key);
		int pos = getPos(key);
		if (pos < 0)
			return;

		if (bucket[i] == null)
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
