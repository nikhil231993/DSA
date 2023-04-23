package leetcode.binarytree;

public class Test {
//	static Node target;

	public static void main(String[] args) {

		System.out.println(1<<1);
//		mappping();
//		System.out.println(target.data);

//		System.out.println(Integer.toBinaryString(-1>>1));
//		System.out.println(Integer.toBinaryString(-1>>>1));
//		System.out.println(Integer.toBinaryString(-1>>1));
//		System.out.println(Integer.toBinaryString(-1>>>1));

//		System.out.println(128>>1);
//		System.out.println(128>>2);
//		System.out.println(128<<1);
//		System.out.println(128<<2);

		String s="n";
		int[] arr=new int[10];
		test(s,arr);
		System.out.println(s);
		for(int n:arr)
			System.out.println(n);



	}

	private static void test(String s,int[] arr) {
		System.out.println(s);

		s="Nikhil";
		for(int i=0;i<arr.length;i++)
			arr[i]=10;
	}

//	private static void mappping() {
//		Node n = new Node(10);
//		target = n;
//
//	}

}
