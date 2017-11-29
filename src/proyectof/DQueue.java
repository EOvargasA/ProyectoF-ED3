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
    //atributos
    private DNode<T> front;
    private DNode<T> rear;
    private int size;
    
    //constructores
    DQueue(){
        front = rear = null;//front y rear se hacen nulo
        size = 0;
    }
    
    DQueue(T d){
        DNode <T> n = new DNode<T> (d);
        front = rear = n;//front y rear se hacen igual a nuestro unico nodo
        size = 1;
    }
    
    //metodos
    public void enqueueFront (T d){
        DNode <T> n = new DNode<T> (d);//declaramos el nodo que vamos a meter
        if (isEmpty()){//si esta vacio
            front = rear = n;//todo se iguala al nodo
        } else {//si no
            n.back = front;//su parte trasera es igual al frente
            front.next = n;//su el sigueinte del frente es nuestro nodo
            front = n;//nuestro nodo se vuelde el nuevo primero
        }
        size++;//se aumenta el tamaño
    }
    
    public void enqueueLast (T d){
        DNode <T> n = new DNode<T> (d);//declaramos el nodo a introducir
        if (isEmpty()){//si no hay nodos
            front = rear = n;//todo se hace igual al nodo
        } else {//si no
            n.next = rear;//el siguiente del nodo es el ultimo
            rear.back = n;//el anterior del ultimo es el nodo
            rear = n;//el nodo es el nuevo ultimo
        }
        size++;//se aumenta el tamaño
    }
    
    public T dequeueFront (){
        if(!isEmpty()){//si no esta vacio
            DNode<T> n = front;//obtenemos el frente
            if (size == 1){//si solo hay un elemento
                clearQueue();//limpiamos el elemento
            } else {//si no
                front.back = front;//el frente es igual a su anterior
                front.next = null;//el frente del anterior se vuelve nulo
                size--;//se reduce el tamaño del arreglo
            }
            return n.data;//regresas los datos de n
        }
        return null;//regresas nulo
    }
    
    public T dequeueRear (){
        if(!isEmpty()){//si esta vacio
            DNode<T> n = rear;//se hace a n igual que el ultimo
            if(size == 1){//si solo hay un elemento
                clearQueue();//se limpia el elemento
            }else{//si no
                rear.next = rear;//el siguiente de rear se vuelve el nuevo rear
                rear.back = null;//el anterior del ultimo se vuelve nulo
                size--;//se reduce el tamaño
            }
            return n.data;//regresa el dato
        }
        return null;//regresa nulo
    }
    
    //getters y setters
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
        return size == 0;//regresa la comparativa del tamaño y 0
    }
    
    public void clearQueue(){
        front = rear = null;//se hace todo el arreglo igual a nulo
        size = 0;//el tamaño del arreglose reduce a 0
    }
    
    public void showQueue() {
        DNode<T> pointer = front;//declaramos nuestro apuntador
        for (int i = 0; i < size; i++){//se recorre el arreglo
            System.out.print("["+pointer.data.toString()+"]");//vamos imprimiendo el nodo en el que estemos
            if (pointer.next != null){//si el siguiene es diferente de nulo
                System.out.println("<->");//se imprime una flechita
            }
            pointer = pointer.next;//se va al siguiente apuntador
        }
    }
}
