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
        List<Edge> p = new List<>();
        this.v = v;
        this.e = 0;
        for (int i = 1; i <= v; i++){
            edges.insertLast(p, i);
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
        n = edges.fetch(s);
        if (n != null){
            Edge p = new Edge(d);
            if (!n.data.exist(p)){
                p = new Edge (d,w);
                n.data.insertLast(p, d);
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
                for (int j = 1; j < lp.length; j++){
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
            for (int j = 0; j <= path.length; j++){
                b = path.getLast();
                r = r + b +" ";
                if (j != path.length){
                    r = r + "-> ";
                }
                path.deleteLast();
            }
            return r;
        }else{
            return "el camino buscado no existe";
        }
    }
    
    private void recursiveSDFS (int i, int f){
        if(!visited.exist(i)){
           this.visited.insertLast(new Edge(i),i);
           if(i == f){
               if (path.length == 0){
                   path = visited;
               }else if (path.length > visited.length){
                   path = visited;
               }
           }else{
               Node<List<Edge>> a = edges.fetch(i);
               List<Edge> b = a.data;
               b.pointer = b.first;
               for (int j = 1; j <= b.length; j++){
                   recursiveSDFS(b.pointer.n,f);
                   b.pointer = b.pointer.next;
               }
           }
           this.visited.deleteNode(new Edge(i));
        }
    }
}
