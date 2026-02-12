package Clases.Arbol;

/**
 * Represents a specialized organizational tree structure for the operational
 * management system of the university campus.
 * <p>
 * This class extends {@link GeneralTree} and defines a predefined hierarchical
 * structure that models the campus emergency and operational organization.
 *
 * The hierarchy includes:
 * <ul>
 *     <li>Root: Operations Center</li>
 *     <li>Intermediate nodes: Brigades (Evacuation, Attention, Logistics, Security)</li>
 *     <li>Leaf nodes: Operational teams assigned to each brigade</li>
 * </ul>
 *
 * This structure is used in the dynamic simulation to manage team assignments
 * and organizational decision-making processes.
 */
public class OrganizationTree extends GeneralTree {

    /**
     * Constructs an OrganizationTree with the specified root data.
     *
     * @param rootData the data to be stored in the root node
     */
    public OrganizationTree(Object rootData) {
        super(rootData);
    }

    /**
     * Creates and returns a default organizational structure
     * representing the operational hierarchy of the campus.
     * <p>
     * The structure includes predefined brigades and their respective teams.
     *
     * @return a fully initialized {@link OrganizationTree} with default brigades and teams
     */
    public static OrganizationTree createDefaultStructure() {

        OrganizationTree tree = new OrganizationTree("Centro de Operaciones");

        TreeNode root = tree.getRoot();

        // Brigadas
        tree.addChild(root, "Evacuacion");
        tree.addChild(root, "Atencion");
        tree.addChild(root, "Logistica");
        tree.addChild(root, "Seguridad");

        // Equipos para Evacuación
        TreeNode evacuacion = tree.search("Evacuacion");
        tree.addChild(evacuacion, "Equipo Evacuacion A");
        tree.addChild(evacuacion, "Equipo Evacuacion B");

        // Equipos para Logística
        TreeNode logistica = tree.search("Logistica");
        tree.addChild(logistica, "Equipo Logistica A");
        tree.addChild(logistica, "Equipo Logistica B");
        
        // Equipos para Seguridad
        TreeNode seguridad = tree.search("Seguridad");
        tree.addChild(seguridad, "Equipo Seguridad A");
        tree.addChild(seguridad, "Equipo Seguridad B");
        
        // Equipos para Seguridad
        TreeNode atencion = tree.search("Atencion");
        tree.addChild(atencion, "Equipo Atencion A");
        tree.addChild(atencion, "Equipo Atencion B");

        return tree;
    }
}
