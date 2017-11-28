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
public class Graph {
    private int v,e;
    private List<List<Edge>> edges = new List<>();
    private List<Edge> visited = new List<>();
    private List<Edge> path = new List<>();
    
    private boolean visited(int e){
        Edge a = new Edge(e);
        return this.visited.exist(a);
    }
    
    public Graph (int v){
        this.v = v;
        this.e = 0;
        for (int i = 1; i <= v; i++){
            edges.insertLast(new List<>(), i);
        }
    }  
    
    public int getEdges (){
        return e;
    }
    
    public int getVertices(){
        return v;
    }
    
    public boolean isEdge (int s, int d){
        Node<List<Edge>> n;
        n = edges.fetch(s);
        if (n == null){
            return false;
        }
        Edge p = new Edge(d);
        return n.data.exist(p);
    }
    
    public double getEWeigth (int s, int d){
        Node<List<Edge>> n;
        n = edges.fetch(s);
        if (n == null){
            return -1.0;
        }
        Node<Edge> p = n.data.fetch(d);
        if (p == null){
            return -1.0;
        }
        return p.data.getWeigth();
    }
    
    public void insertE (int s, int d, double w){
        Node<List<Edge>> n;
        n = edges.first;
        if (n != null){
            Edge p = new Edge(d);
            for (int j = 1; j <= v; j++){
                if (n.n == s){
                    n.data.insertLast(p, d);
                }
                n = n.next;
            }
        }
    }
    
    public void insertE (int s, int d){
        insertE(s,d,0.0);
    }
    
    public List<Edge> adjacentTo(int s){
        Node<List<Edge>> n;
        n = edges.fetch(s);
        return n.data;
    }
    
    public String toString (){
        String r = "";
        List<Edge> lp;
        for (int i = 1; i < v+1; i++){
            r = r+"Vertice "+this.edges.fetch(i).n+" ";
            lp = adjacentTo(i);
            if (lp.isEmpty()){
                r = r+"Sin adyacentes ";
            }else{
                r = r + "Con adyacentes: ";
                lp.pointer = lp.first;
                for (int j = 1; j <= lp.length; j++){
                    r = r+lp.pointer.data.toString()+" ";
                    lp.pointer = lp.pointer.next;
                }
            }
        }
        return r;
    }
    
    public String shortDFS (int i, int f){
        recursiveSDFS(i,f);
        String r = "";
        Node<Edge> b;
        if (path.length != 0){
            path.pointer = path.first;
            for (int j = 0; j < path.length; j++){
                b = path.pointer;
                r = r + b.data.toString() +" ";
                if (j < path.length - 1){
                    r = r + "-> ";
                }
                path.pointer = path.pointer.next;
            }
            return r;
        }else{
            return "el camino buscado no existe";
        }
    }
    
    private void recursiveSDFS (int i, int f){
        if(!visited.exist(i)){
           Edge z = new Edge(i);
           this.visited.insertLast(z,i);
           if(i == f){
               if (path.length == 0){
                   visitedP();
               }else if (path.length > visited.length){
                   visitedP();
               }
           }else{
               Node<List<Edge>> a = edges.fetch(i);
               List<Edge> b = a.data;
               b.pointer = b.first;
               for (int j = 1; j <= b.length; j++){
                   recursiveSDFS(b.pointer.n,f);
                   if (j < b.length){
                    b.pointer = b.pointer.next;
                   }
               }
           }
           this.visited.deleteLast();
        }
    }
    
    private void visitedP (){
        visited.pointer = visited.first;
        Node<Edge> a = new Node<Edge>(new Edge(1),1);
        Edge b = new Edge (1);
        path.clearList();
        for (int i = 0; i < visited.length; i++){
            a = visited.pointer;
            b = a.data;
            path.insertLast(b,i);
            visited.pointer = visited.pointer.next;
        }
    } 
}
