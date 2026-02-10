/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Axton Urbina
 */
public class Graph {
    private Vertex[] vertex;
    private int size;
    
    public Graph(int max) {
        vertex = new Vertex[max];
        size = 0;
    }
    
    public void addVertex(String name){
        vertex[size] = new Vertex(name);
        size++;
    }
}
