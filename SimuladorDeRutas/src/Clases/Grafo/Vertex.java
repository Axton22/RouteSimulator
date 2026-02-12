package Clases.Grafo;

import Clases.VerticeEstados.TypeState;

/**
 * Represents a vertex (node) in the graph.
 * Each vertex corresponds to a location on the campus map.
 * 
 * A vertex contains:
 * - A name (location identifier)
 * - A linked list of adjacent edges
 * - A TypeState object that defines its safety condition
 * - Attributes used for graph traversal algorithms (DFS and Dijkstra)
 */
public class Vertex {

    private String name;
    private Edge edgeHead;
    private TypeState typeState;
    private boolean visited;
    private int distance;
    private Vertex predecessor;

    /**
     * Creates a new vertex with a given name.
     * 
     * By default:
     * - No adjacent edges
     * - Distance = 0
     * - Not visited
     * - No predecessor
     * - TypeState initialized as "Casual" and Safe ('S')
     *
     * @param name Name of the vertex/location
     */
    public Vertex(String name) {
        this.name = name;
        this.edgeHead = null;
        this.distance = 0;
        this.visited = false;
        this.predecessor = null;
        this.typeState = new TypeState("Casual", 'S'); // Estado por defecto: Casual y seguro
    }

    /**
     * Returns the TypeState object of this vertex.
     * 
     * @return TypeState associated with the vertex
     */
    public TypeState getTypeState() {
        return typeState;
    }

    /**
     * Returns whether the vertex has been visited.
     * Used in DFS and Dijkstra algorithms.
     * 
     * @return true if visited, false otherwise
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Sets the visited status of the vertex.
     * 
     * @param visited true if visited, false otherwise
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Returns the current shortest distance from the source vertex.
     * Used in Dijkstra algorithm.
     * 
     * @return current distance value
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets the distance value for the vertex.
     * 
     * @param distance new distance value
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Returns the predecessor vertex in the shortest path.
     * 
     * @return predecessor vertex
     */
    public Vertex getPredecessor() {
        return predecessor;
    }

    /**
     * Sets the predecessor vertex.
     * 
     * @param predecessor previous vertex in the path
     */
    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    /**
     * Returns the name of the vertex.
     * 
     * @return vertex name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the vertex.
     * 
     * @param name new vertex name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the head of the adjacency list.
     * 
     * @return first Edge in the list
     */
    public Edge getEdgeHead() {
        return edgeHead;
    }

    /**
     * Sets the head of the adjacency list.
     * 
     * @param adjacent first edge
     */
    public void setEdgeHead(Edge adjacent) {
        this.edgeHead = adjacent;
    }

    /**
     * Adds a new edge to the adjacency list.
     * The edge is inserted at the beginning of the list.
     * 
     * @param destination vertex this edge connects to
     * @param weight cost/distance of the edge
     */
    void addEdge(Vertex destination, int weight) {
        Edge newEdge = new Edge(destination, weight);
        newEdge.setNext(edgeHead);
        edgeHead = newEdge;
    }
}
