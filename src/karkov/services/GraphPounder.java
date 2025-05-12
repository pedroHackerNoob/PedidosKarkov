package karkov.services;

import karkov.models.Arista;
import java.util.*;

/**
 * Representa un grafo ponderado no dirigido en el que se pueden agregar zonas (nodos)
 * y conexiones (aristas) con peso entre ellas. Proporciona métodos para calcular
 * rutas mínimas usando el algoritmo de Dijkstra.
 *
 * Este grafo está pensado para representar zonas interconectadas, por ejemplo, en un
 * sistema de logística o distribución local.
 */
public class GraphPounder {

    /**
     * Mapa que representa el grafo, donde cada zona tiene una lista de aristas (conexiones) asociadas.
     */
    private Map<String, List<Arista>> grafo = new HashMap<>();

    /**
     * Agrega una nueva zona al grafo si aún no existe.
     *
     * @param zona Nombre de la zona a agregar.
     */
    public void agregarZona(String zona) {
        grafo.putIfAbsent(zona, new ArrayList<>());
    }

    /**
     * Agrega una conexión ponderada (arista) entre dos zonas del grafo.
     * Como es un grafo no dirigido, la conexión se agrega en ambos sentidos.
     *
     * @param origen   Zona de origen.
     * @param destino  Zona de destino.
     * @param distancia Distancia (peso) entre las dos zonas.
     */
    public void agregarConexion(String origen, String destino, int distancia) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(new Arista(destino, distancia));
        grafo.get(destino).add(new Arista(origen, distancia)); // Eliminar si se desea un grafo dirigido.
    }

    /**
     * Ejecuta el algoritmo de Dijkstra para calcular la ruta mínima desde una zona
     * de inicio hacia todas las demás zonas del grafo. Imprime las rutas y distancias.
     *
     * @param inicio Zona desde la que se desea calcular las distancias mínimas.
     */
    public void dijkstra(String inicio) {
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> anteriores = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        Set<String> visitados = new HashSet<>();

        for (String zona : grafo.keySet()) {
            distancias.put(zona, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (!visitados.add(actual)) continue;

            for (Arista arista : grafo.get(actual)) {
                int nuevaDistancia = distancias.get(actual) + arista.getDistancia();
                if (nuevaDistancia < distancias.get(arista.getDestino())) {
                    distancias.put(arista.getDestino(), nuevaDistancia);
                    anteriores.put(arista.getDestino(), actual);
                    cola.add(arista.getDestino());
                }
            }
        }

        // Mostrar resultados
        for (String zona : grafo.keySet()) {
            if (!zona.equals(inicio)) {
                System.out.println("Ruta desde " + inicio + " hasta " + zona + ":");
                mostrarRuta(zona, anteriores);
                System.out.println(" | Distancia total: " + distancias.get(zona));
                System.out.println();
            }
        }
    }

    /**
     * Calcula y muestra el camino más corto entre dos zonas utilizando el algoritmo de Dijkstra.
     *
     * @param origen  Zona de origen.
     * @param destino Zona de destino.
     */
    public void caminoMasCorto(String origen, String destino) {
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> anteriores = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        Set<String> visitados = new HashSet<>();

        for (String zona : grafo.keySet()) {
            distancias.put(zona, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (!visitados.add(actual)) continue;

            for (Arista arista : grafo.get(actual)) {
                int nuevaDistancia = distancias.get(actual) + arista.getDistancia();
                if (nuevaDistancia < distancias.get(arista.getDestino())) {
                    distancias.put(arista.getDestino(), nuevaDistancia);
                    anteriores.put(arista.getDestino(), actual);
                    cola.add(arista.getDestino());
                }
            }
        }

        if (distancias.get(destino) == Integer.MAX_VALUE) {
            System.out.println("No existe ruta de " + origen + " a " + destino);
        } else {
            System.out.print("Camino más corto de " + origen + " a " + destino + ": ");
            mostrarRuta(destino, anteriores);
            System.out.println(" | Distancia total: " + distancias.get(destino));
        }
    }

    /**
     * Muestra por consola el camino desde la zona inicial hasta la zona destino
     * siguiendo el mapa de anteriores generado por Dijkstra.
     *
     * @param destino    Zona final del recorrido.
     * @param anteriores Mapa que indica el nodo anterior en el camino mínimo hacia cada nodo.
     */
    private void mostrarRuta(String destino, Map<String, String> anteriores) {
        List<String> ruta = new ArrayList<>();
        while (destino != null) {
            ruta.add(destino);
            destino = anteriores.get(destino);
        }
        Collections.reverse(ruta);
        System.out.print(String.join(" -> ", ruta));
    }
}
