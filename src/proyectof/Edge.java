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
public class Edge {
    //atributos
    private int dest;
    private double weigth;
    
    //constructores
    public Edge (int e){
        this.dest = e;
        this.weigth = 0.0;//cuando no nos dan peso le damos un peso de 0
    }
    
    public Edge (int e, double w){
        e = this.dest;
        this.weigth = w;    
    }
    
    //get y set
    public int getDest(){
        return this.dest;
    }
    
    public double getWeigth (){
        return this.weigth;
    }
    
    public String toString (){
        return this.dest+"("+this.weigth+")";//concatenamos el numero de arista con el peso dentro de parentesis
    }
}
