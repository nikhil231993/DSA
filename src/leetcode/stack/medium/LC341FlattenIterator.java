package leetcode.stack.medium;

public class LC341FlattenIterator {

    /**
    Approach 1

    private List<Integer> fList =null;
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        fList = new ArrayList<>();
        flattening(nestedList);
        it = fList.iterator();
    }

    public void flattening(List<NestedInteger> nestedList){
        for(NestedInteger currEl : nestedList){
            if(currEl.isInteger()){
                fList.add(currEl.getInteger());
            } else {
                flattening(currEl.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(it.hasNext()){
            return it.next();
        } else{
            return null;
        }
    }
    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
    */

    //Approach 2
    /*
    import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    private List<Integer> fList;
    private int currentIndex; // Replaces the 'it' object

    public NestedIterator(List<NestedInteger> nestedList) {
        fList = new ArrayList<>();
        currentIndex = 0; // Start at the beginning of the list
        flattening(nestedList);
    }

    public void flattening(List<NestedInteger> nestedList){
        for(NestedInteger currEl : nestedList){
            if(currEl.isInteger()){
                fList.add(currEl.getInteger());
            } else {
                flattening(currEl.getList());
            }
        }
    }

    @Override
    public Integer next() {
        // Get the current element, then move the pointer forward by 1
        if (hasNext()) {
            return fList.get(currentIndex++);
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        // If our pointer hasn't reached the end of the list yet, we have a next item
        return currentIndex < fList.size();
    }
}
     */

    /*

    Approach 3

    public class NestedIterator implements Iterator<Integer> {

    // We use a Deque as our Stack for better performance than Java's legacy Stack class
    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        // Push the initial list onto the stack from back to front
        prepareStack(nestedList);
    }

    // Helper method to push a list of NestedIntegers onto the stack in reverse order
    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        // hasNext() guarantees the top element is an integer, so we just pop it.
        if (!hasNext()) {
            return null; // Or throw NoSuchElementException
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        // Keep unpacking the top of the stack until we find an Integer
        while (!stack.isEmpty()) {
            // If the top element is already a flat integer, we are ready!
            if (stack.peek().isInteger()) {
                return true;
            }

            // Otherwise, the top element is a nested list.
            // 1. Pop the list off the stack
            NestedInteger topList = stack.pop();

            // 2. Unpack it and push its contents back onto the stack (back to front)
            prepareStack(topList.getList());
        }

        // If we emptied the stack and found no integers, we are out of elements.
        return false;
    }
}
     */
}
