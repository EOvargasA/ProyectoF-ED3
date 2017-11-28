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
public class Node <T> {
    T data;
    Node next;
    int n;
    
    Node (T d, int n){
        data = d;
        this.n = n;
        next = null;
    }
}
