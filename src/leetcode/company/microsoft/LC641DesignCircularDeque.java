package leetcode.company.microsoft;

public class LC641DesignCircularDeque {

    /*
    class MyCircularDeque {
    int[] arr;
    int size;
    int capacity;
    int front;
    int rear;
    public MyCircularDeque(int k) {
        arr=new int[k];
        capacity=k;
        size=0;
        front=0;
        rear=-1;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        front=(front-1+capacity)%capacity;
        arr[front]=value;
        size++;
        if(size==1) rear=front;
        return true;
    }

    public boolean insertLast(int value) {
         if(isFull()) return false;
         rear=(rear+1)%capacity;
         arr[rear]=value;
         size++;
         return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        front=(front+1)%capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear=(rear-1+capacity)%capacity;
        size--;
        return true;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==capacity;
    }
}
     */
}
