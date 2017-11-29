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
public class ProyectoF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph a = new Graph(12);//instanciamos el grafo que vamos a evaluar
        //instanciamos todas las conexiones entre estos
        a.insertE(1, 2);
        a.insertE(1, 4);
        a.insertE(2, 1);
        a.insertE(2, 7);
        a.insertE(2, 8);
        a.insertE(3, 5);
        a.insertE(4, 1);
        a.insertE(4, 5);
        a.insertE(4, 10);
        a.insertE(5, 3);
        a.insertE(5, 4);
        a.insertE(5, 6);
        a.insertE(5, 10);
        a.insertE(6, 5);
        a.insertE(6, 7);
        a.insertE(6, 11);
        a.insertE(7,2);
        a.insertE(7, 6);
        a.insertE(7, 9);
        a.insertE(8, 2);
        a.insertE(8, 11);
        a.insertE(8, 12);
        a.insertE(9, 7);
        a.insertE(10, 4);
        a.insertE(10, 5);
        a.insertE(10, 11);
        a.insertE(11, 6);
        a.insertE(11, 8);
        a.insertE(11, 10);
        a.insertE(12, 8);
        Edge b = new Edge(0);//se crea el nodo 0, puesto que este solo tiene 1 camino posible
        System.out.println(b.toString()+" -> "+a.shortDFS(1, 12));//se concatena nuestro nodo 0 con el camino mas corto a partir del nodo 1
    }
    
}
