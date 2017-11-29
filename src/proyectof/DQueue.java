/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectof;

/**
 *
 * @author Osiris
 */
public class DQueue<T> {
    private DNode<T> front;
    private DNode<T> rear;
    private int size;
    
    DQueue(){
        front = rear = null;
        size = 0;
    }
    
    DQueue(T d){
        DNode <T> n = new DNode<T> (d);
        front = rear = n;
        size = 1;
    }
    
    public void enqueueFront (T d){
        DNode <T> n = new DNode<T> (d);
        if (isEmpty()){
            front = rear = n;
        } else {
            n.back = front;
            front.next = n;
            front = n;
        }
        size++;
    }
    
    public void enqueueLast (T d){
        DNode <T> n = new DNode<T> (d);
        if (isEmpty()){
            front = rear = n;
        } else {
            n.next = rear;
            rear.back = n;
            rear = n;
        }
        size++;
    }
    
    public T dequeueFront (){
        if(!isEmpty()){
            DNode<T> n = front;
            if (size == 1){
                clearQueue();
            } else {
                front.back = front;
                front.next = null;
                size--;
            }
            return n.data;
        }
        return null;
    }
    
    public T dequeueRear (){
        if(!isEmpty()){
            DNode<T> n = rear;
            if(size == 1){
                clearQueue();
            }else{
                rear.next = rear;
                rear.back = null;
                size--;
            }
            return n.data;
        }
        return null;
    }
    
    public T getFront(){
        return front.data;
    }
    
    public T getRear (){
        return rear.data;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clearQueue(){
        front = rear = null;
        size = 0;
    }
    
    public void showQueue() {
        DNode<T> pointer = front;
        for (int i = 0; i < size; i++){
            System.out.print("["+pointer.data.toString()+"]");
            if (pointer.next != null){
                System.out.println("<->");
            }
            pointer = pointer.next;
        }
    }
}
