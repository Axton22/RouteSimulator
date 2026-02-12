package Clases.VerticeEstados;

/**
 * Represents the safety state of a specific area (vertex).
 *
 * The state is represented by a character:
 * - 'S' = Safe
 * - 'R' = Risky
 * - 'C' = Critical
 *
 * This class is used to determine how a zone affects
 * path calculations and emergency handling.
 */
public class AreaState {
    private char state; // 'S' = segura, 'R' = riesgo y 'C' = crítico
    
    /**
     * Constructs an AreaState with a given state value.
     *
     * @param state character representing the safety state
     */
    public AreaState(char state){
        this.state = state;
    }

    /**
     * Returns the current state.
     *
     * @return the state character ('S', 'R', or 'C')
     */
    public char getState() {
        return state;
    }

    /**
     * Sets the state of the area.
     *
     * @param state new state character
     */
    public void setState(char state) {
        this.state = state;
    }
    
    
}
