package leetcode.company.microsoft;

import java.util.Stack;

public class LC1475SpecialDiscount {

    public static void main(String[] args) {

        int[] prices=new int[]{8,4,6,2,3};
        int[] resul=finalPrices(prices);
        for(int num:resul)
            System.out.println(num);
    }

    private static int[] finalPrices(int[] prices) {

        int n=prices.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && prices[st.peek()]>=prices[i]){
                prices[st.peek()]-=prices[i];
                st.pop();
            }
            st.push(i);
        }
        return prices;
    }
}
