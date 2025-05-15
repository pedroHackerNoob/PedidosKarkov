package karkov.services;

import karkov.models.Request;
import karkov.repository.RepositoryRequest;

import java.util.ArrayList;

/**
 * Servicio encargado de buscar y mostrar una solicitud específica por su ID.
 */
public class ServiceSearchId {
    /**
     * Busca y muestra una solicitud específica por su ID utilizando búsqueda binaria.
     *
     * Verifica primero si el ID está dentro del rango válido de solicitudes registradas.
     * Si es válido, llama al método de búsqueda binaria para localizar y mostrar los datos.
     *
     * @param id El identificador único del pedido que se desea buscar.
     */
    public static void searchById(int id) {
        if (id < 0 || id >= RepositoryRequest.getRequests().size()-1) {
            System.out.println("⚠️ Solicitud con ID " + id + " no encontrada.");
            return;
        }else {
            System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
            System.out.println("-------------------------------------------------------------------------------");
            binarySearch(RepositoryRequest.getRequestArray(), id);
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    /**
     * Realiza una búsqueda binaria para encontrar una solicitud (Request) por su ID.
     *
     * La búsqueda binaria requiere que el arreglo esté previamente ordenado por ID.
     * Si el elemento se encuentra, se muestra en consola; de lo contrario, se muestra un mensaje de advertencia.
     *
     * @param requests Lista de solicitudes ordenadas por ID.
     * @param target El ID del pedido que se desea encontrar.
     */
    public static void binarySearch(ArrayList<Request> requests, int target) {
        int izquierda = 0;
        int derecha = requests.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int currentId = requests.get(medio).getId();

            if (currentId == target) {
                System.out.println(requests.get(medio).toString());
                return;
            } else if (currentId < target) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        System.out.println("⚠️ No existe el ID " + target);
    }

}
