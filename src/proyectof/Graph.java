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
    private int v,e;//numero de vertices y de aristas
    private List<List<Edge>> edges = new List<>();//lista que contiene una lista de aristas, que simboliza la coneccion entre las distintas aristas formando vertices 
    private List<Edge> visited = new List<>();//lista donde mantendremos el registro de los nodos que hayamos visitado
    private List<Edge> path = new List<>();//lugar donde se guardara el camino que encontremos mas eficiente
    private DQueue <List<Edge>> pAna = new DQueue<>();//lista de arreglos para la busqueda de anchura
    
    private boolean visited(int e){//checamos si se visita
        Edge a = new Edge(e);//creamos un arista para buscar
        return this.visited.exist(a);//devolvemos si el arista existe
    }
    
    public Graph (int v){//constructor
        this.v = v;
        this.e = 0;
        for (int i = 1; i <= v; i++){
            edges.insertLast(new List<>(), i);
        }
    }  
    
    public int getEdges (){
        return e;//devuelve el numero de aristas
    }
    
    public int getVertices(){
        return v;//devuelve el numero de vertices
    }
    
    public boolean isEdge (int s, int d){
        Node<List<Edge>> n;//declaramos un nodo de una lista de vertices
        n = edges.fetch(s);//lo hacemos igual a la lista de aristas que representan las colindancias de nuestro inicio
        if (n == null){//si no existe regresa falso
            return false;
        }
        Edge p = new Edge(d);//creamos una arista con nuestro valor final
        return n.data.exist(p);//buscamos si la arista p existe (que contiene nuestro valor final)
    }
    
    public double getEWeigth (int s, int d){
        Node<List<Edge>> n;
        n = edges.fetch(s);//declaramos un nodo y hacemos que almacene la lista de adyacencia de nuestro valor inicial
        if (n == null){//si no existe la coneccion
            return -1.0;
        }
        Node<Edge> p = n.data.fetch(d);
        if (p == null){//si no existe el vertice
            return -1.0;
        }
        return p.data.getWeigth();//regresa el peseo del dato
    }
    
    public void insertE (int s, int d, double w){
        Node<List<Edge>> n;
        n = edges.first;//creamos un nodo el cual pueda guardar nuestro apuntador
        if (n != null){//si no es nulo
            Edge p = new Edge(d);//creamos una arista de nuestro final
            for (int j = 1; j <= v; j++){//buscamos el arreglo de aristas que corresponda a nuestro inicio
                if (n.n == s){
                    n.data.insertLast(p, d);//insertamos el nuevo vertice
                }
                n = n.next;//se pasa al sig. elemento
            }
        }
    }
    
    public void insertE (int s, int d){
        insertE(s,d,0.0);//se hace lo mismo que con peso solo que aqui no pesa nada
    }
    
    public List<Edge> adjacentTo(int s){
        Node<List<Edge>> n;
        n = edges.fetch(s);//crea un nodo para almacenar el nodo con la lista de adyacencia que buscamos
        return n.data;//devuelve esa lista
    }
    
    public String toString (){
        String r = "";//se declara nuestro String
        List<Edge> lp;//se declara una lista de vertices
        for (int i = 1; i < v+1; i++){//mientras queden vectores que revisar
            r = r+"Vertice "+this.edges.fetch(i).n+" ";//se agrega el vertice a la cadena
            lp = adjacentTo(i);//se saca su lista de adyacencia
            if (lp.isEmpty()){//si no tiene lista de adyacencia
                r = r+"Sin adyacentes ";//solo se dice que no tiene
            }else{//si tiene
                r = r + "Con adyacentes: ";//se dictamina que tiene
                lp.pointer = lp.first;
                for (int j = 1; j <= lp.length; j++){//mientras haya mas adyacentes
                    r = r+lp.pointer.data.toString()+" ";//estas se concatenan a la variable
                    lp.pointer = lp.pointer.next;//el contador pasa a ser su sig.
                }
            }
        }
        return r;//se regresa nuestra variable de String
    }
    
    public String shortDFS (int i, int f){
        visited.clearList();//se limpian las listas
        path.clearList();
        pAna.clearQueue();
        recursiveSDFS(i,f);//se convoca al metodo para poder obtener en path nuestro camino mas corto
        String r = "";//variable de cadena
        Node<Edge> b;//apuntador
        if (path.length != 0){//si existe
            path.pointer = path.first;//el apuntador se hara su primero
            for (int j = 0; j < path.length; j++){//se entra en un ciclo
                b = path.pointer;
                r = r + b.data.toString() +" ";//se concatena un dato de la cadena
                if (j < path.length - 1){//si no es el ultimo entonces le ponemos una flecha
                    r = r + "-> ";
                }
                path.pointer = path.pointer.next;//se mueve el apuntador
            }
            return r;//regresa nuestra cadena
        }else{//si no
            return "el camino buscado no existe";//no existe la ruta
        }
    }
    
    private void recursiveSDFS (int i, int f){
        if(!visited.exist(i)){//si no se ha visitado
           Edge z = new Edge(i);
           this.visited.insertLast(z,i);//lo insertamos al ultimo usando un nodo recien declarado
           if(i == f){//si inicio es igual a final
               if (path.length == 0){//si no hay un arreglo de antes
                   visitedP();//igualamos la lista de visitados con la del camino
               }else if (path.length > visited.length){//si ya existe una se checa cual es la menor
                   visitedP();//igualamos la lista de visitados con la del camino
               }
           }else{//si no
               Node<List<Edge>> a = edges.fetch(i);//instanciamos el arreglo de Listas
               List<Edge> b = a.data;//obtenemos la lista
               b.pointer = b.first;//preparamos el apuntador
               for (int j = 1; j <= b.length; j++){//recorremos el arreglo
                   recursiveSDFS(b.pointer.n,f);//se vuelve a llamar al metodo con el numero del apuntador
                   if (j < b.length){//si no hemos llegado al ultimo
                    b.pointer = b.pointer.next;//el apuntador se mueve
                   }
               }
           }
           this.visited.deleteLast();//se borra el ultimo visitado
        }
    }
    
    public String shortBFS (int i, int f){
        Edge a = new Edge(i);//declaramos el objeto inicial
        pAna.enqueueLast(new List<Edge>(a,i));//manda el arreglo del inicio a la lista
        List<Edge> pa = new List<>();//declara el arreglo pa
        List<Edge> fa = new List<>();//declara el arreglo fa
        Node <List<Edge>> neir;//declara la lista de arreglos neir
        List<Edge> ber;//declara la lista de aristas ber
        Node<Edge> z, b;//declaramos los nodos b, z
        Edge x, y;//declaramos las aristas x, y
        if (i == f){//si es el primero
            return a.toString();//lo regresamos solo
        }
        do{//mientras
        pa = pAna.dequeueFront();//se saca un elemento de nuestra lista
        fa = pa;//fa se hace igual a pa
        z = pa.last;//z se hace nuestro apuntador
        x = z.data;//x obtiene la data de nuestro apuntador
            visited.insertLast(x, x.getDest());//insertamos x en los visitados
            neir = edges.fetch(x.getDest());//obtenemos la cadena de valores vecinos a x
            ber = neir.data;
            b = ber.first;//b = apuntador
            for (int l = 0; l < ber.length; l++){//mientras haya elementos que analizar
                y = b.data;//y se vuelve nuestro dato
                if (!visited.exist(y.getDest())){//si no se ha visitado
                    fa.insertLast(y, y.getDest());//se inserta para poder usarlo
                    if (y.getDest() == f){//si llegamos a nuestro destino
                        return listS(fa);//devuelve el camino en un arreglo de caracteres
                    }
                    visited.insertLast(y, y.getDest());//se inserta en los nodos visitados
                    pAna.enqueueLast(NIC(fa));//se pone en cola
                    fa.deleteLast();//se elimina de fa
                    fa = pa;//se iguala a pa
                }
                b = b.next;//siguiente del apuntador
            }
        }while(!pAna.isEmpty());//mientras haya algo en pAna
        return "no existe";//devuelve que no existe
    }
    
    private void visitedP (){
        visited.pointer = visited.first;//se declara el apuntador
        Node<Edge> a = new Node<Edge>(new Edge(1),1);//se crea un nuevo nodo
        Edge b = new Edge (1);//se crea una nueva arista
        path.clearList();//se limpia path
        for (int i = 0; i < visited.length; i++){//mientras haya cosas por transferir
            a = visited.pointer;
            b = a.data;//se obtiene el edge  con los datos declarados
            path.insertLast(b,i);//se inserta en path
            visited.pointer = visited.pointer.next;//se pasa al sig del apuntador
        }
    }
    
    private List<Edge> NIC (List<Edge> f){//metodo para tener los mismos valores en puntos de memoria diferentes
        List<Edge> c = new List<Edge>();//se crea una nueva lista
        f.pointer = f.first;//el apuntador se pasa al principio
        Node<Edge> a;
        Edge b;//se declaran las variables a y b
        for (int i = 0; i < f.length; i++){
            a = f.pointer;
            b = a.data;//usando a y b obtenemos el dato
            c.insertLast(b,b.getDest());//lo insertamos en nuestra nueva direccion
            f.pointer = f.pointer.next;//avanza el apuntador
        }
        return c;//regresamos la nueva direccion
    }
    
    private String listS (List fa){//pasar a string un camino
        String r = "";//declaramos nuestra cadena
        Node<Edge> o;//nodo pibote
        if (fa.length != 0){//si existe
            fa.pointer = fa.first;//se declara el apuntador
            for (int j = 0; j < fa.length; j++){//mientras se recorra el arreglo
                o = fa.pointer;//pibote = apuntador
                r = r + o.data.toString() +" ";//se concatena con nuestra cadena
                if (j < fa.length - 1){//si no es el ultimo
                    r = r + "-> ";//se le concatena una flecha
                }
                fa.pointer = fa.pointer.next;//se mueve el apuntador
            }
        }
        return r;//se regresa la cadena
    }
}
