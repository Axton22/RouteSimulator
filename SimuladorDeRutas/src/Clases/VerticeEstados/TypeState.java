package Clases.VerticeEstados;

import Clases.VerticeEstados.AreaState;
import Clases.Grafo.Vertex;

/**
 * Represents the specific event or condition occurring in a vertex (area).
 *
 * Each TypeState contains:
 * - A descriptive name of the event (e.g., Fire, Construction, Flood).
 * - An AreaState object that defines the safety level:
 *   'S' = Safe
 *   'R' = Risky
 *   'C' = Critical
 *
 * This class is used to classify zones and determine
 * how they affect pathfinding and emergency response.
 */
public class TypeState {
    private String typeName;
    private AreaState state;

    /**
     * Constructs a TypeState with a given event name and safety state.
     *
     * @param name  descriptive name of the event or condition
     * @param state character representing the safety level
     */
    public TypeState(String name, char state) {
        this.typeName = name;
        this.state = new AreaState(state);
    }

    /**
     * Returns the name of the event type.
     *
     * @return event name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the name of the event type.
     *
     * @param typeName new event name
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Returns the AreaState associated with this type.
     *
     * @return AreaState object
     */
    public AreaState getState() {
        return state;
    }
}
