/*
 * 622. Design Circular Queue
 */

class MyCircularQueue {

    int[] q;
    int cap; // capacity of the queue
    int front = -1; // the index position of the first element in the queue
    int end = -1; // the index position of the last element in the queue
    int size = 0; // number of elements in the queue
    
    public MyCircularQueue(int k) {
        cap = k;
        q = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        
        end++;
        
        if(end == cap)
            end = 0;
        
        q[end] = value;
        
        size++;
        if(size == 1)
            front = end;
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        
        front++;
        
        if(front == cap)
            front = 0;
        
        size--;
        
        return true;
    }
    
    public int Front() {
        if(size == 0)
            return -1;
        
        return q[front];
    }
    
    public int Rear() {
        if(size == 0)
            return -1;
        
        return q[end];
    }
    
    public boolean isEmpty() {
        if(size == 0)
            return true;
        
        return false;
    }
    
    public boolean isFull() {
        if(size == cap)
            return true;
        
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */