# RouteSimulator 

Descripción: El objetivo de este proyecto es implementar un programa que simule rutas de evacuación en diferentes eventos que podrían ocurrir en el campus universitario. Para nuestra implementación decidimos hacer un menú el cual muestra al usuario 4 opciones por pantalla:

1) Mostrar el mapa: Para esta opción se muestra por pantalla cada uno de los vértices (zonas) del mapa y sus diferentes aristas (caminos) a cada uno de las zonas enlazadas, desplieguelo para poder escoger los nombres de los vertices para las demás funciones.

2) Empezar el simulacro: Esta opción es la que hace el mayor trabajo en el programa, aplica Dijkstra en el mapa y muestra el camino más corto de un punto establecido a otro, una vez ingreses la opción te pedirá que digites el punto de origen y el punto destino y también si quieres agregar diferentes eventos que pueden ocurrir en las zonas y así cambiar la ruta que tome el Dijkstra.

3) Mostrar la estructura organizativa: Esta opción únicamente muestra por pantalla la estructura organizativa con sus brigadas y equipos de ayuda.

4) Salir: Esta opción termina la ejecución del programa.

# Características del proyecto:
- Representación de mapa mediante grafo ponderado.
- Implementación de lista de adyacencia enlazada.
- Cálculo de rutas óptimas con algoritmo de Dijkstra.
- Modificación dinámica del mapa en tiempo de ejecución.
- Sistema de clasificación de zonas por nivel de riesgo.
- Recalculo automático de rutas ante cambios
- Bloqueo total de rutas en zonas críticas

# Autores:
- Axton Urbina Pérez
- Daniel Moreno Chavarría
- Cristopher Ureña
- Alejandro Alpizar Rodriguez

