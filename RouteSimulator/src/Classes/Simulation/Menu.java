package Classes.Simulation;

import Classes.Tree.OrganizationTree;
import Classes.Graph.Graph;
import Classes.Graph.Vertex;
import java.util.Scanner;

/**
 * Menu class that manages the main user interaction of the simulation system.
 *
 * This class integrates:
 * - The Graph structure (campus map representation).
 * - The OrganizationTree structure (emergency organizational hierarchy).
 *
 * It allows the user to:
 * 1. Display the map using an adjacency list.
 * 2. Start a simulation using Dijkstra's algorithm.
 * 3. Display the organizational emergency structure.
 */
public class Menu {

    private Graph graph;
    private OrganizationTree tree;

    /**
     * Constructs the Menu object.
     *
     * Initializes:
     * - A Graph with a maximum capacity of 20 vertices.
     * - The default organizational structure.
     */
    public Menu() {
        this.graph = new Graph(20);
        this.tree = OrganizationTree.createDefaultStructure();
    }

    /**
     * Displays the main menu and handles user interaction.
     *
     * This method controls:
     * - Menu navigation
     * - Simulation execution using Dijkstra
     * - Dynamic map modifications (blocking paths and changing zone states)
     * - Displaying the organizational tree
     *
     * The loop continues until the user selects option 0 (Exit).
     */
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {

            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Opcion 1 Mostrar mapa (lista adyacencia).");
            System.out.println("2. Opcion 2 Comenzar simulacro (Dijkstra).");
            System.out.println("3. Opcion 3 Mostrar estructura organizativa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    graph.showGraph();
                    break;

                case 2:
                    String X, Y;
                    int opt = 0;
                    sc.nextLine(); // Limpiar buffer

                    System.out.println("Escriba el nombre del punto de partida: ");
                    X = sc.nextLine();
                    System.out.println("Escriba el nombre del destino: ");
                    Y = sc.nextLine();

                    // Primera ejecución para mostrar la ruta inicial
                    graph.Dijkstra(X, Y);

                    System.out.println("\nDesea agregar eventos en el mapa? 1(SI) - 2(NO)");
                    opt = sc.nextInt();

                    while (opt != 2) { // BUCLE PRINCIPAL DE CAMBIOS
                        int op;
                        System.out.print("\nQue desea cambiar caminos(1), zonas(2), Ambos(3): ");
                        op = sc.nextInt();

                        if (op == 1 || op == 3) {
                            int a = 1;
                            while (a != 2) {
                                sc.nextLine(); // Limpiar buffer
                                System.out.println("Ingrese el nombre de la zona origen del camino a bloquear:");
                                String os = sc.nextLine();
                                System.out.println("Ingrese el nombre de la zona destino del camino a bloquear:");
                                String d = sc.nextLine();

                                graph.disableEdge(os, d, false); 
                                System.out.println("camino bloqueado. ¿Bloquear otro camino? 1(SI) - 2(NO) ");
                                a = sc.nextInt();
                            }
                        }

                        if (op == 2 || op == 3) {
                            int e = 1;
                            while (e != 2) {
                                sc.nextLine(); // Limpiar
                                System.out.println("En que zona ocurre el suceso?");
                                String areaName = sc.nextLine();
                                System.out.println("Que esta pasando? Opciones:"

                                + "\nIncendio, Derrumbe por sismo, Inundacion por fuga"

                                + "\nAglomeracion de personas, Construccion, Falla electrica"

                                + "\nLimpeza por mantenimiento, Actividades academicas, Zona de estudio");
                                
                                String event = sc.nextLine();

                                Vertex affectedVertex = graph.FindVertex(areaName);
                                if (affectedVertex != null) {
                                    affectedVertex.getTypeState().setTypeName(event);
                                    graph.typeDetector(affectedVertex);

                                    if (affectedVertex.getTypeState().getState().getState() == 'C') {
                                        graph.disableVertexEdge(areaName);
                                        System.out.println("Zona critica! Rutas bloquadas por este camino.\n");
                                        System.out.println(tree.search("Evacuacion").getFirstChild().getData() + " Haciendose cargo de la situacion");
                                        System.out.println(tree.search("Logistica").getFirstChild().getData() + " Haciendose cargo de la situacion");
                                        System.out.println(tree.search("Atencion").getFirstChild().getData() + " Haciendose cargo de la situacion");
                                        System.out.println(tree.search("Seguridad").getFirstChild().getData() + " Haciendose cargo de la situacion\n");
                                    }
                                    if (affectedVertex.getTypeState().getState().getState() == 'R') {
                                        graph.disableVertexEdge(areaName);
                                        System.out.println("Zona riesgosa! Las rutas aumentan su peso.\n");
                                        System.out.println(tree.search("Equipo Evacuacion A").getNextSibling().getData() + " Haciendose cargo de la situacion");
                                        System.out.println(tree.search("Equipo Logistica A").getNextSibling().getData() + " Haciendose cargo de la situacion");
                                        System.out.println(tree.search("Equipo Atencion A").getNextSibling().getData() + " Haciendose cargo de la situacion");
                                        System.out.println(tree.search("Equipo Seguridad A").getNextSibling().getData() + " Haciendose cargo de la situacion\n");
                                    }
                                }
                                System.out.println("Cambiar estado de otra zona 1(SI) - 2(NO)");
                                e = sc.nextInt();
                            }
                        }

                        // --- RESULTADO FINAL TRAS LOS CAMBIOS ---
                        System.out.println("\n--- RECALCULANDO RUTA CON LOS CAMBIOS ---");
                        graph.Dijkstra(X, Y);

                        System.out.println("\nDesea realizar mas cambios generales al mapa 1(SI) - 2(NO)");
                        opt = sc.nextInt();
                    } 
                    System.out.println("Saliendo de la interaccion dinamica...");
                    break;
                    
                case 3:
                    tree.traverseByLevelsBFS();
                    
                case 0:
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

            System.out.println(); // línea en blanco

        } while (option != 0);
            sc.close();
    }
}
