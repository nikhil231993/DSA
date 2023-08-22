package leetcode.heap;

public class MinHeap {

    int[] arr=null;
    int currentLocation=0;
    public MinHeap(int size){
        arr=new int[size+1];
        currentLocation=0;
    }

    public void insert(int value){
        if(currentLocation==arr.length){
            return;
        }
        arr[++currentLocation]=value;
        int tempLocation=currentLocation;

        while(arr[tempLocation/2]>arr[tempLocation] && tempLocation/2>0){
            int temp=arr[tempLocation/2];
            arr[tempLocation/2]=arr[tempLocation];
            arr[tempLocation]=temp;
            tempLocation=tempLocation/2;
        }
    }

    public void print(){

        if(currentLocation==0)
            return;
        for(int i=1;i<=currentLocation/2;i++){
            System.out.println();
            System.out.println("Current number: "+arr[i]);
            if(2*i<=currentLocation)
            System.out.print(" Left Child: "+ arr[2*i]);
            if(2*i+1<=currentLocation)
            System.out.print(" Right Child: "+arr[2*i+1]);
        }

    }


    public int peek() {
        if(currentLocation==0)
            return -1;
        return arr[1];
    }

    public int remove() {
        if(currentLocation==0)
            return -1;
        int removed=arr[1];
        arr[1]=arr[currentLocation--];
        minHeapifyTopToBottom(arr,1);
        return removed;
        //TC:logn (since we are passing length of the stack)
        //SC:logn (recursion stack)
    }

    private void minHeapifyTopToBottom(int[] arr, int index) {
        if(index==currentLocation)
            return ;

        int left=2*index;
        int right=2*index+1;

        if(left<currentLocation || right<currentLocation){
            if(arr[index]>arr[left] && arr[index]>arr[right]){
                    if(arr[left]<arr[right]){
                        int temp=arr[left];
                        arr[left]=arr[index];
                        arr[index]=temp;
                        minHeapifyTopToBottom(arr,left);
                    }else{
                        int temp=arr[right];
                        arr[right]=arr[index];
                        arr[index]=temp;
                        minHeapifyTopToBottom(arr,right);
                    }
            }
        }
    }
}
