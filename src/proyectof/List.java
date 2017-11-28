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
public class List <T> {
    Node first = null;
    Node last = null;
    Node pointer = null;
    int length;
    
    List (){
        first = last = null;
        length = 0;
    }
    
    List(T d, int n){
        Node node = new Node(d,n);
        first = node;
        last = node;
        node.next = null;
        length = 1;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void insertFirst(T d, int n){
        Node node = new Node(d,n);
        if (isEmpty()){
            first = node;
            last = node;
            node.next = null;
        }else{
            node.next = first;
            first = node;
        }
        length++;
    }
    public void insertLast(T d, int n){
        Node node = new Node(d,n);
        if (isEmpty()){
            first = node;
            last = node;
            node.next = null;
        }else{
            last.next = node;
            last = node;
        }
        length++;
    }
    
    public Node<T> getLast(){
        return this.last;
    }
    
    public void deleteFirst(){
        if (!isEmpty()){
            if (first.next == null){
                first = last = null;
            }else{
                first = first.next;
            }
            length--;
        }
    }
    public void deleteLast(){
        if (!isEmpty()){
            if (first.next == null){
                first = last = null;
            }else{
                pointer = first;
                while(pointer.next != last){
                    pointer = pointer.next;
                }
                last = pointer;
                last.next = pointer = null;
            }   
        }
        length--;
    }
    public boolean deleteNode(T n){
        Node p = fetchBack(n);
        if (p != null){
            if (p.data == n){
                deleteFirst();
                return true;
            }else if (p.data == last.data){
                deleteLast();
            }else{
                p.next = p.next.next;
                length--;
                return true;
            }
        }
        return false;
    }
    public Node fetchBack(T n){
        if (!isEmpty()){
            if (first == last){
                if (first.data == n){
                    return first;
                }
                return null;
            }
            if (first.data == n){
                return first;
            }
            pointer = first;
            while(pointer.next != null){
                if (pointer.next.data == n){
                    return pointer;
                }
                pointer = pointer.next;
            }
        }
        return null;
    }
    public Node fetch (T n){
        if (!isEmpty()){
            if (first == last){
                if (first.data == n){
                    return first;
                }
            }else{
                pointer = first;
                for (int i = 0; i <= length; i++){
                    if (pointer.data == n){
                        return pointer;
                    }
                    pointer = pointer.next;
                }
            }
        }
        return null;
    }
    
    public Node fetch (int n){
        if (!isEmpty()){
            if (first == last){
                if (first.n == n){
                    return first;
                }
            }else{
                pointer = first;
                for (int i = 0; i <= length; i++){
                    if (pointer.n == n){
                        return pointer;
                    }
                    pointer = pointer.next;
                }
            }
        }
        return null;
    }
    
    public boolean exist (T n){
        if (!isEmpty()){
            if (first == last){
                if (first.data == n){
                    return true;
                }
            }else{
                pointer = first;
                for (int i = 0; i < length; i++){
                    if (pointer.data == n){
                        return true;
                    }
                    pointer = pointer.next;
                }
            }
        }
        return false;
    }
    
    public boolean exist (int n){
        if (!isEmpty()){
            if (first == last){
                if (first.n == n){
                    return true;
                }
            }else{
                pointer = first;
                for (int i = 0; i < length; i++){
                    if (pointer.n == n){
                        return true;
                    }
                    pointer = pointer.next;
                }
            }
        }
        return false;
    }
    
    public void showList(){
        pointer = first;
        System.out.print("First->");
        for (int i = 0; i < length; i++){
            System.out.print("["+pointer.data.toString()+"]->");
            pointer = pointer.next;
        }
        System.out.println("Last");
    }
    
    public void clearList(){
        first = last = pointer = null;
        length = 0;
    }
}
