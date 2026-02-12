package Clases.Grafo;

/**
 * Represents a weighted, undirected graph implemented using
 * adjacency lists.
 * <p>
 * This graph models the physical connectivity of the university campus,
 * where:
 * <ul>
 *     <li>Vertices represent buildings, classrooms, intersections, or exits.</li>
 *     <li>Edges represent paths between locations with an associated weight
 *         (distance in meters).</li>
 * </ul>
 *
 * The class supports:
 * <ul>
 *     <li>Vertex and edge insertion</li>
 *     <li>Graph visualization</li>
 *     <li>Depth-First Search (DFS)</li>
 *     <li>Dijkstra's shortest path algorithm</li>
 *     <li>Dynamic enabling/disabling of edges</li>
 * </ul>
 *
 * It is part of the Dynamic Simulation System for Campus Management and Routing.
 */
public class Graph {

    /**
     * Array that stores the vertices of the graph.
     */
    private Vertex[] vertex;

    /**
     * Current number of vertices stored in the graph.
     */
    private int size;
    
    /**
     * Constructs a Graph with a maximum capacity of vertices.
     * Automatically initializes the campus map.
     *
     * @param max maximum number of vertices allowed in the graph
     */
    public Graph(int max) {
        vertex = new Vertex[max];
        size = 0;
        mapInitializer();
    }
    
    /**
     * Initializes the predefined campus map by adding
     * vertices and weighted edges between them.
     */
    public void mapInitializer(){
        
        addVertex("Aula 9");
        addVertex("Aula 10-11");
        addVertex("Aula 4-6");
        addVertex("Aula 1-3");
        addVertex("Desvio aula 10-11");
        addVertex("Interseccion aula 10-11 y 9");
        addVertex("Interseccion aula 4-6");
        addVertex("Interseccion aula 1-3");
        addVertex("Interseccion gimnasio-biblioteca");
        addVertex("Gimnasio");
        addVertex("Biblioteca");
        addVertex("Auditorio");
        addVertex("Soda");
        addVertex("Salida");
        
        addEdge("Salida", "Soda", 62);
        addEdge("Soda", "Auditorio", 36);
        addEdge("Auditorio", "Aula 9", 54);
        addEdge("Auditorio", "Biblioteca", 45);
        addEdge("Biblioteca", "Interseccion gimnasio-biblioteca", 23);
        addEdge("Interseccion gimnasio-biblioteca", "Gimnasio", 38);
        addEdge("Soda", "Gimnasio", 70);
        addEdge("Interseccion gimnasio-biblioteca", "Interseccion aula 1-3", 20);
        addEdge("Interseccion aula 1-3", "Interseccion aula 4-6", 20);
        addEdge("Interseccion aula 1-3", "Aula 1-3", 25);
        addEdge("Interseccion aula 4-6", "Aula 4-6", 25);
        addEdge("Aula 1-3", "Aula 4-6", 20);
        addEdge("Interseccion aula 4-6", "Interseccion aula 10-11 y 9", 12);
        addEdge("Interseccion aula 10-11 y 9", "Desvio aula 10-11", 16);
        addEdge("Desvio aula 10-11", "Aula 10-11", 28);
        addEdge("Interseccion aula 10-11 y 9", "Aula 9", 38);
        
    }
     
    /**
     * Adds a new vertex to the graph.
     *
     * @param name name of the vertex
     */
    public void addVertex(String name){
        vertex[size] = new Vertex(name);
        size++;
    }
    
    /**
     * Searches for a vertex by name.
     *
     * @param nombre name of the vertex to search
     * @return the corresponding {@link Vertex} if found, otherwise null
     */
    public Vertex FindVertex(String nombre){
        if(vertex != null){
            for(int i = 0; i < size;i++){ 
                if(nombre.equals(vertex[i].getName())){
                    return vertex[i];
                }  
            }
        }
        System.out.println("La zona no existe");
        return null;
    } 
    
    /**
     * Adds a weighted, undirected edge between two vertices.
     *
     * @param origin name of the origin vertex
     * @param destination name of the destination vertex
     * @param weight weight (distance) of the edge
     */
    public void addEdge(String origin, String destination, int weight){
        Vertex vOrigin = FindVertex(origin);
        Vertex vDestination = FindVertex(destination);
        
        if(vOrigin != null && vDestination != null){
            Edge newDestEdge = new Edge(vDestination, weight);
            
            if(vOrigin.getEdgeHead() == null){
                vOrigin.setEdgeHead(newDestEdge);
            }
            else{
                Edge aux = vOrigin.getEdgeHead(); 
                while (aux.getNext() != null) {
                    aux = aux.getNext();
                }
                aux.setNext(newDestEdge);       
            }

            Edge haciaOrigen = new Edge(vOrigin, weight);
        
            if (vDestination.getEdgeHead() == null) {
                vDestination.setEdgeHead(haciaOrigen);
            } 
            else {
                Edge aux = vDestination.getEdgeHead();
                while (aux.getNext() != null) {
                    aux = aux.getNext();
                }
                aux.setNext(haciaOrigen);
            }                   
        }       
    }
    
    /**
     * Displays the graph structure in adjacency list format.
     */
    public void showGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print("Vertice " + vertex[i].getName() + " conectado con: ");
            Edge aux = vertex[i].getEdgeHead();
            while (aux != null) {
                System.out.print(aux.getDestination().getName() + " (" + aux.getWeight() + "m) -> ");
                aux = aux.getNext();
            }
            System.out.println("null");
        }
    }
    
    /**
     * Resets the visited state of all vertices.
     */
    public void resetVisited() {
        for (int i = 0; i < size; i++) {
            vertex[i].setVisited(false);
        }
    }
    
    /**
     * Performs a Depth-First Search (DFS) traversal starting from a given vertex.
     *
     * @param origenInicio name of the starting vertex
     */
    public void DFS(String origenInicio){
        Vertex inicio = FindVertex(origenInicio);
        if(inicio != null){
            recursiveDFS(inicio);
        }else{
            System.out.println("El punto de inicio no exixte");
        }
    }
    
    /**
     * Recursive helper method for DFS traversal.
     *
     * @param current current vertex being visited
     */
    private void recursiveDFS(Vertex current){
        current.setVisited(true);
        System.out.println("Visitando: " + current.getName());
        
        Edge aux = current.getEdgeHead();
        while(aux!=null){

            Vertex destination = aux.getDestination();
            if(!destination.isVisited() && aux.isAvailable()){
                recursiveDFS(destination);
            } 
            aux = aux.getNext();
        }
    }
    
    /**
     * Executes Dijkstra's algorithm to compute the shortest path
     * between two vertices considering dynamic risk states.
     *
     * @param startName name of the starting vertex
     * @param endName name of the destination vertex
     */
    public void Dijkstra(String startName, String endName){
        Vertex startVertex = FindVertex(startName);
        Vertex endVertex = FindVertex(endName);

        if (startVertex == null || endVertex == null) {
            System.out.println("Error: Uno de los edificios no existe.");
            return;
        }

        for (int i = 0; i < size; i++) {
            vertex[i].setDistance(999999999);
            vertex[i].setVisited(false);      
            vertex[i].setPredecessor(null);   
        }

        startVertex.setDistance(0);

        for (int i = 0; i < size; i++) {
            Vertex u = shortDistance();
            if (u == null) break;
            u.setVisited(true);

            Edge edge = u.getEdgeHead();
            while (edge != null) {
                if (edge.isAvailable()) {

                    Vertex v = edge.getDestination();

                    typeDetector(v);
                    char state = v.getTypeState().getState().getState();

                    int extraWeight = 0;
                    if (state == 'R') {
                        extraWeight = 50; 
                    }

                    int weight = edge.getWeight();
                    
                    if (!v.isVisited() && (u.getDistance() + weight + extraWeight) < v.getDistance()) {
                        v.setDistance(u.getDistance() + weight + extraWeight);
                        v.setPredecessor(u); 
                    }
                }
                edge = edge.getNext();
            }
        }

        if (endVertex.getDistance() >= 999999999) {
            System.out.println("No se encontro una ruta segura hacia " + endName);
        } else {
            printRoad(endVertex);
            System.out.println("Distacia total del vertice "+
            startVertex.getName()+" a "+endVertex.getName()+" es: "+endVertex.getDistance());
        }
    }
    
    /**
     * Determines and updates the safety classification of a vertex
     * based on its associated type.
     *
     * @param vertex vertex to classify
     */
    public void typeDetector(Vertex vertex){
        if (vertex == null) return;
        
        if (vertex.getTypeState().getTypeName().equals("Incendio") ||
            vertex.getTypeState().getTypeName().equals("Derrumbe por sismo") ||
            vertex.getTypeState().getTypeName().equals("Inundacion por fuga")) {
                vertex.getTypeState().getState().setState('C');
        }
        else if (vertex.getTypeState().getTypeName().equals("Aglomeracion de personas") ||
            vertex.getTypeState().getTypeName().equals("Construccion") ||
            vertex.getTypeState().getTypeName().equals("Falla electrica")) {
                vertex.getTypeState().getState().setState('R');
        }
        else if (vertex.getTypeState().getTypeName().equals("Limpieza por mantenimeinto") ||
            vertex.getTypeState().getTypeName().equals("Actividades academicas") ||
            vertex.getTypeState().getTypeName().equals("Zona de estudio") ||
            vertex.getTypeState().getTypeName().equals("Casual")) {
                vertex.getTypeState().getState().setState('S');
        }
        else {
            System.out.println("El tipo de estado es incorrecto o está mal escrito");
        }
    }
    
    /**
     * Prints the computed shortest path recursively from
     * the starting vertex to the destination vertex.
     *
     * @param v destination vertex
     */
    private void printRoad(Vertex v) {
        if (v == null) return;
        printRoad(v.getPredecessor());
        System.out.print(v.getName() + " -> ");
    }
    
    /**
     * Finds the unvisited vertex with the shortest current distance.
     *
     * @return the closest unvisited {@link Vertex}, or null if none exists
     */
    private Vertex shortDistance() {
        Vertex minor = null;
        int minimumDistance = 999999999;

        for (int i = 0; i < size; i++) {
            if (!vertex[i].isVisited() && vertex[i].getDistance()< minimumDistance) {
                minimumDistance = vertex[i].getDistance();
                minor = vertex[i];
            }
        }
        return minor;
    }
    
    /**
     * Enables or disables a specific edge between two vertices.
     *
     * @param originName origin vertex name
     * @param destName destination vertex name
     * @param state true to enable, false to disable
     */
    public void disableEdge(String originName, String destName, boolean state) {
        Vertex v = FindVertex(originName);
        if (v != null) {
            Edge aux = v.getEdgeHead();
            while (aux != null) {
                if (aux.getDestination().getName().equals(destName)) {
                    aux.setAvailable(state); 
                    return;
                }
                aux = aux.getNext();
            }
        }
    }
    
    /**
     * Disables all edges connected to a specific vertex,
     * effectively isolating it from the graph.
     *
     * @param name name of the vertex to isolate
     */
    public void disableVertexEdge(String name) {
        Vertex v = FindVertex(name);
        if (v == null) return;

        Edge aux = v.getEdgeHead();
        while (aux != null) {
            aux.setAvailable(false); 
            aux = aux.getNext();
        }

        for (int i = 0; i < size; i++) {
            Edge temp = vertex[i].getEdgeHead();
            while (temp != null) {
                if (temp.getDestination().getName().equalsIgnoreCase(name)) {
                    temp.setAvailable(false);
                }
                temp = temp.getNext();
            }
        }
    }
}
