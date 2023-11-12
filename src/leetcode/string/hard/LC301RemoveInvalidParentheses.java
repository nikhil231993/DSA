package leetcode.string.hard;

import java.util.*;

public class LC301RemoveInvalidParentheses {

    public static void main(String[] args) {
        
        //Approach 1 This gives TLE due to recursion
        String s = "()())()";
        HashSet<String> set=new HashSet<>();
        List<String> list=new ArrayList<>();
        int count=validate(s);
        removeInvalidParentheses(s,set,count);
        list.addAll(set);
        System.out.println(list);
        
        //Approach 2
        int count1=validate(s);
        System.out.println(removeInvalidParenthesesBetter(s,set,count));
    }

    private static List<String> removeInvalidParenthesesBetter(String s, HashSet<String> set, int count) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (valid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    public static void removeInvalidParentheses(String s, HashSet<String> set, int count) {
        if(count<0)
            return;

        if(count==0){
            if(validate(s)==0){
               set.add(s);
            }
            return;
        }
        for(int i=0;i<s.length();i++){
            String start=s.substring(0,i);
            String remain=s.substring(i+1);
            removeInvalidParentheses(start+remain,set,count-1);
        }
    }

    public static int validate(String s){

        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')
                st.push(ch);
            else if(ch==')'){
                if(st.isEmpty() || st.peek()!='(')
                    st.push(')');
                else if(st.peek()=='(')
                    st.pop();
            }
        }
        return st.size();
    }

    public static boolean valid(String s){

        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')
                st.push(ch);
            else if(ch==')'){
                if(st.isEmpty() || st.peek()!='(')
                    st.push(')');
                else if(st.peek()=='(')
                    st.pop();
            }
        }
        return st.size()==0;
    }
}
