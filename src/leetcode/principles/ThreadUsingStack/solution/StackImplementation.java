package leetcode.principles.ThreadUsingStack.solution;

public class StackImplementation {

    private int[] array=null;
    private int stackTop;

    public StackImplementation(int capacity){
        
        array=new int[capacity];
        stackTop=-1;
    }

    public  boolean push(int element){

        synchronized (this) {

            if(isFull()) return false;
            System.out.println("Pusherrrrr");
            ++stackTop;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            array[stackTop]=element;
            return true;
        }
    }

    public int pop(){
        synchronized (this) {

            //if(isEmpty()) return Integer.MIN_VALUE;
            System.out.println("Popperrrrrr");
            int obj=array[stackTop];
            array[stackTop]=Integer.MIN_VALUE;
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stackTop--;
            return obj;
        }
    }

    public boolean isEmpty(){
        return stackTop<0;
    }

    public boolean isFull(){
        return stackTop>=array.length-1;
    }
}
