package leetcode.string.hard;

import java.util.*;

public class LC301RemoveInvalidParentheses {

    public static void main(String[] args) {
        
        //Approach 1 This gives TLE due to recursion
        String s = "))";
        s="()())()";
        HashSet<String> set=new HashSet<>();
        List<String> list=new ArrayList<>();
        int count=validate(s);
        removeInvalidParentheses(s,set,count);
        list.addAll(set);
        System.out.println(list);
        
        //Approach 2
        System.out.println(removeInvalidParenthesesBetter(s));
    }

    private static List<String> removeInvalidParenthesesBetter(String s) {

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

            if (found) continue; // if we find true once then there is no point in reducing size further as that is the minimum

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

        // This code is important to find invalid parenthesis for any question
        if(count<0)
            return;

        if(count==0){
            if(validate(s)==0){
               set.add(s);
            }
            return;
        }
        for(int i=0;i<s.length();i++){ // we can add acechk for character also but it wont make any difference
            String start=s.substring(0,i);
            String remain=s.substring(i+1);
            removeInvalidParentheses(start+remain, set, count-1);
        }

        //TC:O(2 raise to n)
        //since in the worst case we will have only left parentheses in the expression and for every bracket we will have two options i.e. whether to remove it or consider it. Considering that the expression has N parentheses, the time
        //SC:O(N)
        //because we are resorting to a recursive solution and for a recursive solution there is always stack space used as internal function states are saved onto a stack during recursion. The maximum depth of recursion decides the stack space used. Since we process one character at a time and the base case for the recursion is when we have processed all of the characters of the expression string, the size of the stack would be O(N). Note that we are not considering the space required to store the valid expressions. We only count the intermediate space here.
    }

    public static int validate(String s){

        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')
                st.push(ch);
            else if(ch==')'){
                if(!st.isEmpty() && st.peek()=='(') // we can remove st.peek()!='(' here
                    st.pop();
                else
                    st.push(')');
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
                if(!st.isEmpty() && st.peek()=='(') // we can remove st.peek()!='(' here
                    st.pop();
                else
                    st.push(')');
            }
        }
        return st.size()==0;
    }
}
