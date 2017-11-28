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
    private int dest;
    private double weigth;
    
    public Edge (int e){
        e = this.dest;
        this.weigth = 0.0;
    }
    
    public Edge (int e, double w){
        e = this.dest;
        this.weigth = w;    
    }
    
    public int getDest(){
        return this.dest;
    }
    
    public double getWeigth (){
        return this.weigth;
    }
    
    public String toString (){
        return this.dest+"("+this.weigth+")";
    }
}
