package Clases.Grafo;

import Clases.Grafo.Vertex;

/**
 * Represents an edge in a weighted, undirected graph.
 * <p>
 * Each edge connects a vertex to a destination vertex and contains:
 * <ul>
 *     <li>A reference to the destination vertex</li>
 *     <li>A weight (distance or time cost)</li>
 *     <li>An availability state (used in dynamic simulation)</li>
 *     <li>A reference to the next edge (linked list representation)</li>
 * </ul>
 *
 * This class is part of the adjacency list implementation of the graph,
 * used to model campus connectivity and route planning.
 */
public class Edge {

    /**
     * Destination vertex of this edge.
     */
    private Vertex destination;

    /**
     * Weight associated with this edge (e.g., distance or time).
     */
    private int weight;

    /**
     * Indicates whether this edge is currently available
     * (used for dynamic path enabling/disabling).
     */
    private boolean available;

    /**
     * Reference to the next edge in the adjacency list.
     */
    private Edge next;
    
    /**
     * Constructs an Edge with the specified destination vertex and weight.
     * The edge is initialized as available.
     *
     * @param dest the destination vertex
     * @param weight the weight associated with the edge
     */
    public Edge(Vertex dest, int weight) {
        this.available = true;
        this.destination = dest;
        this.weight = weight;
        this.next = null;
    }

    /**
     * Returns the destination vertex of this edge.
     *
     * @return the destination {@link Vertex}
     */
    public Vertex getDestination() {
        return destination;
    }

    /**
     * Sets the destination vertex of this edge.
     *
     * @param destination the new destination vertex
     */
    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    /**
     * Returns the weight of this edge.
     *
     * @return the edge weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight of this edge.
     *
     * @param weight the new weight value
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Returns whether this edge is currently available.
     *
     * @return {@code true} if the edge is available, {@code false} otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability state of this edge.
     *
     * @param available {@code true} to enable the edge, {@code false} to disable it
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns the next edge in the adjacency list.
     *
     * @return the next {@link Edge}, or {@code null} if none exists
     */
    public Edge getNext() {
        return next;
    }

    /**
     * Sets the next edge in the adjacency list.
     *
     * @param next the next edge to link
     */
    public void setNext(Edge next) {
        this.next = next;
    }
}
