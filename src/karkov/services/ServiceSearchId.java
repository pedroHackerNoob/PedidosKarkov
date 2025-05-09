package karkov.services;

import karkov.models.Request;
import karkov.repository.RepositoryRequest;

/**
 * Servicio encargado de buscar y mostrar una solicitud específica por su ID.
 */
public class ServiceSearchId {

    /**
     * Busca una solicitud por su ID y muestra sus detalles en formato de tabla.
     * Si el ID no es válido, muestra un mensaje de advertencia.
     *
     * @param id Identificador de la solicitud que se desea buscar.
     */
    public static void searchById(int id) {
        if (id < 0 || id >= RepositoryRequest.getRequests().size()) {
            System.out.println("⚠️ Solicitud con ID " + id + " no encontrada.");
            return;
        }

        System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(RepositoryRequest.getRequest(id).toString());
        System.out.println("-------------------------------------------------------------------------------");
    }
}
