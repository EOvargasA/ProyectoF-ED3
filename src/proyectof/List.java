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
    Node first = null;//inicio
    Node last = null;//final
    Node pointer = null;//apuntador
    int length;//tamaño
    
    List (){
        first = last = null;//se hacen nulos los apuntadores
        length = 0;//tamaño 0
    }
    
    List(T d, int n){
        Node node = new Node(d,n);//se declara el nuevo nodo
        first = node;
        last = node;//el principio y el final son iguales al nodo
        node.next = null;//se hace nulo el siguiente del nodo
        length = 1;//tamaño = 1
    }
    
    public boolean isEmpty(){
        return first == null;//se checa si los apuntadores son nulos
    }
    
    public void insertFirst(T d, int n){
        Node node = new Node(d,n);//se declara el nodo
        if (isEmpty()){//si esta vacio
            first = node;
            last = node;//first y lasy son iguales a nodo
            node.next = null;//su siguiente es nulo
        }else{
            node.next = first;//el sig del nodo es el primero
            first = node;//el nodo es el primero
        }
        length++;//se aumenta el tamaño
    }
    public void insertLast(T d, int n){
        Node node = new Node(d,n);//se crea el nodo
        if (isEmpty()){//si esta vacio
            first = node;
            last = node;//inicio y final son nodo
            node.next = null;//el siguiente del nodo es nulo
        }else{
            last.next = node;//el siguiente del ultimo es el nodo
            last = node;//el nodo es el nuevo ultimo
        }
        length++;//se aumenta el tamaño
    }
    
    public Node<T> getLast(){
        return this.last;//se obtiene el ultimo
    }
    
    public void deleteFirst(){
        if (!isEmpty()){//si no esta vacio
            if (first.next == null){//si es el unico
                first = last = null;//se elimina todo
            }else{
                first = first.next;//solo se elimina el primero
            }
            length--;//se reduce el tamaño
        }
    }
    public void deleteLast(){
        if (!isEmpty()){//si no esta vacio
            if (first.next == null){//si es el unico
                first = last = null;//todo se elimina
            }else{//si no
                pointer = first;//se apunta al primero
                while(pointer.next != last){//mientras que su siguiente no sea el ultimo se avanza
                    pointer = pointer.next;//se mueve el apuntador
                }
                last = pointer;//se hace al apuntador el ultimo
                last.next = pointer = null;//su sig se hace nulo
            }   
        }
        length--;
    }
    public boolean deleteNode(T n){
        Node p = fetchBack(n);//se busac el trazero del nodo a borrar
        if (p != null){//si existe
            if (p.data == n){//si es ese mismo
                deleteFirst();//borrar primero
                return true;//regresa verdadero
            }else if (p.data == last.data){//si es el ultimo
                deleteLast();//borra el ultimo
                return true;//regresa verdadero
            }else{//si no
                p.next = p.next.next;//el siguiente de p se hace el sig de su sig, saltandose asi el nodo a borrar
                length--;//se disminuye el tamaño
                return true;//regresa verdadero
            }
        }
        return false;//regresa falso
    }
    public Node fetchBack(T n){//buscar hacia atras
        if (!isEmpty()){//si no esta vacio
            if (first == last){//si primero es igual a nulo
                if (first.data == n){//si el dato que busco
                    return first;//regresa principio
                }
                return null;//si no se regresa nulo
            }
            if (first.data == n){//si es el primer dato
                return first;//se regresa ese dato
            }
            pointer = first;// se prepara el apuuntador
            while(pointer.next != null){//mientras que el siguiente del apuntador no sea nulo
                if (pointer.next.data == n){//si el siguiente del dato es lo que busco
                    return pointer;//devuelvo n
                }
                pointer = pointer.next;//se sigue la busqueda
            }
        }
        return null;//si no se encuentra se regresa nulo
    }
    public Node fetch (T n){
        if (!isEmpty()){//si no esta vacio
            if (first == last){//si solo hay un elemento
                if (first.data == n){//si es ese dato
                    return first;//regresa el dato
                }//si no
            }else{
                pointer = first;//se preara el apuntador
                for (int i = 0; i <= length; i++){//mientras se recorre
                    if (pointer.data == n){//si el apuntador es mi dato
                        return pointer;//devuelvo el apuntador
                    }
                    pointer = pointer.next;//pointer pasa al siguiente
                }
            }
        }
        return null;//si no se encuentra se regresa nulo
    }
    
    public Node fetch (int n){//busqueda por identificador numerico
        if (!isEmpty()){//si no esta vacio
            if (first == last){//si solo hay un elemento
                if (first.n == n){//si ese elemento es n
                    return first;//devuelve el elemento
                }
            }else{//si no
                pointer = first;//se prepara el apuntador
                for (int i = 0; i <= length; i++){//mientras se recorre el arreglo
                    if (pointer.n == n){//si el apuntador es igual a n
                        return pointer;//regresa el apuntador
                    }
                    pointer = pointer.next;//el apuntador avanza
                }
            }
        }
        return null;//regresa nulo
    }
    
    public boolean exist (T n){
        if (!isEmpty()){//si no esta vacio
            if (first == last){//si solo hay un elemento
                if (first.data == n){//si ese elemento es el que buscamos
                    return true;//devuelve verdadero
                }
            }else{//si no
                pointer = first;//preparamos el apuntador al inicio
                for (int i = 0; i < length; i++){//recorremos el arreglo
                    if (pointer.data == n){//si encontramos el dato que buscamos
                        return true;//regresa verdadero
                    }
                    pointer = pointer.next;//avnza el apuntador
                }
            }
        }
        return false;//regresa falso si no existe
    }
    
    public boolean exist (int n){
        if (!isEmpty()){//si no esta vacio
            if (first == last){//si solo hay un elemento
                if (first.n == n){//si ese elemento es el que buscamos
                    return true;//regresa verdadero
                }
            }else{//si no
                pointer = first;//el apuntador es el primero
                for (int i = 0; i < length; i++){//mientras recorremos el arreglo
                    if (pointer.n == n){//si encontramos el elemento
                        return true;//regresamos verdadero
                    }
                    pointer = pointer.next;//avanzamos el apuntador
                }
            }
        }
        return false;//regresamos falso
    }
    
    public void showList(){
        pointer = first;//preparamos el apuntador
        System.out.print("First->");//imprimimos la primera parte
        for (int i = 0; i < length; i++){//recorremos el arreglo
            System.out.print("["+pointer.data.toString()+"]->");//vamos omprimiendo el resto de la cadena
            pointer = pointer.next;//movemos el apuntador
        }
        System.out.println("Last");//acaba de imprimir la cadena
    }
    
    public void clearList(){
        first = last = pointer = null;//hacemos todo nulo
        length = 0;//volvemos la anchura a 0
    }
}
