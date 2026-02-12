package Main;

import Clases.Arbol.OrganizationTree;
import Clases.Grafo.Graph;
import Clases.Grafo.Vertex;
import Clases.Simulacion.Menu;

/**
 * Main class of the Route Simulation system.
 *
 * This class serves as the entry point of the application.
 * It initializes the Menu object and starts the user interaction.
 */
public class SimuladorDeRutas {

    /**
     * Main method of the application.
     *
     * Creates a Menu instance and launches the simulation system.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();
    }
    
}
