package leetcode.heap;

public class MaxHeap {

    int[] arr=null;

    int currentLoc=0;

    public MaxHeap(int size){

        arr=new int[size+1];
        currentLoc=0;
    }

    public void insert(int value) {

        if(currentLoc==arr.length)
            return;
        arr[++currentLoc]=value;
        int tempLocation=currentLoc;

        while(arr[tempLocation/2]<arr[tempLocation] && tempLocation/2>0){
            int temp=arr[tempLocation];
            arr[tempLocation]=arr[tempLocation/2];
            arr[tempLocation/2]=temp;
            tempLocation=tempLocation/2;
        }
    }

    public void print() {

        if(currentLoc==0)
            return;
        for(int i=1;i<=currentLoc/2;i++){
            System.out.println("Curent Number: "+arr[i]);
            if(2*i<=currentLoc)
                System.out.print("Left child: "+arr[2*i]);
            if(2*i+1<=currentLoc)
                System.out.println("Right child: "+arr[2*i+1]);
        }
    }

    public int peek() {

        if(currentLoc==0)
            return -1;
        return arr[1];
    }

    public int remove() {

        if(currentLoc==0)
            return -1;
        int removed=arr[1];
        arr[1]=arr[currentLoc--];
        maxHeapifyTopToBottom(arr,1);
        //TC:logn (since we are passing length of the stack)
        //SC:logn (recursion stack)
        return removed;
    }

    private void maxHeapifyTopToBottom(int[] arr, int index) {

        if(index==currentLoc)
            return;

        int left=2*index;
        int right=2*index+1;

        if(left<currentLoc || right<currentLoc){
            if(arr[left]>arr[index] && arr[right]>arr[index]){
                if(arr[left]>arr[right]){
                    int temp=arr[left];
                    arr[left]=arr[index];
                    arr[index]=temp;
                    maxHeapifyTopToBottom(arr,left);
                }else{
                    int temp=arr[right];
                    arr[right]=arr[index];
                    arr[index]=temp;
                    maxHeapifyTopToBottom(arr,right);
                }
            }
        }
    }
}
