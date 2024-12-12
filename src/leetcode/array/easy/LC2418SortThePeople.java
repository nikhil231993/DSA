package leetcode.array.easy;

import java.util.PriorityQueue;

class Node{

	protected String name;

	protected int height;

    public Node(String name, Integer height){
        this.name=name;
        this.height=height;
    }
}

public class LC2418SortThePeople {

    public static void main(String[] args) {

        String[] names = new String[]{"Mary","John","Emma"};
        int[] heights =new int[] {180,165,170};

        //Approach 1
        String[] result=sortPeople(names,heights);

        System.out.println("#######");

        for(String r:result)
            System.out.println(r);
    }

    public static String[] sortPeople(String[] names, int[] heights) {

        PriorityQueue<Node> pq=new PriorityQueue<>((a, b)->b.height-a.height);

        for(int i=0;i<names.length;i++){
            pq.offer(new Node(names[i], heights[i]));
        }

        String[] result=new String[names.length];

        int j=0;
        while(!pq.isEmpty()){
            result[j++] = pq.poll().name;
        }
        return result;

        //TC:O(n log n)
        //SC:O(n)
    }
}
