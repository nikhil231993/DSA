package leetcode.array.extra;

import java.util.ArrayList;
import java.util.Stack;

public class gfgLeadersInArray {

    public static void main(String[] args) {

        int n = 6;
        int[] arr =new int[] {16,17,4,3,5,2};
        System.out.println(leaders(arr, n));
    }


    public static ArrayList<Integer> leaders(int arr[], int n){

        Stack<Integer> st=new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            if(st.isEmpty() || st.peek() <=arr[i]){
                st.push(arr[i]);
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
        while(!st.isEmpty())
            list.add(st.pop());

        return list;

        //TC:O(n)
        //SC:O(n)
    }
}
