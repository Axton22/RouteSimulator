/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Axton Urbina
 */
public class Vertex {
    private String name;
    private Edge adjacent;
    
    public Vertex(String name) {
        this.name = name;
        this.adjacent = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Edge getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(Edge adjacent) {
        this.adjacent = adjacent;
    }
    
    
}
