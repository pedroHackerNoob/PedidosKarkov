package karkov.repository;

import karkov.models.Request;

import java.util.ArrayList;

/**
 * Clase repositorio que actúa como almacén en memoria de solicitudes ({@link Request}).
 * <p>
 * Permite realizar operaciones básicas sobre la lista de solicitudes como agregar,
 * obtener, listar e imprimir.
 * Esta clase simula una base de datos simple para el sistema.
 */
public class RepositoryRequest {

    /**
     * Lista estática que almacena todas las solicitudes cargadas en el sistema.
     */
    static ArrayList<Request> requests = new ArrayList<>();

    /**
     * Agrega una nueva solicitud al repositorio.
     *
     * @param request La solicitud ({@link Request}) a agregar.
     */
    public static void addRequest(Request request) {
        requests.add(request);
    }

    /**
     * Imprime en consola todas las solicitudes registradas con un formato legible.
     * Utiliza el méthodo {@code toString()} de la clase {@link Request}.
     */
    public static void showRequests() {
        for (Request r : requests) {
            System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
            System.out.println(r.toString());
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    /**
     * Retorna la lista completa de solicitudes almacenadas.
     *
     * @return Lista de solicitudes actuales.
     */
    public static ArrayList<Request> getRequests() {
        return requests;
    }

    /**
     * Retorna una solicitud específica según su índice en la lista.
     *
     * @param id Índice de la solicitud en la lista.
     * @return Objeto {@link Request} correspondiente al índice dado.
     * @throws IndexOutOfBoundsException si el índice no es válido.
     */
    public static Request getRequest(int id) {
        return requests.get(id);
    }

    /**
     * Retorna una referencia a la lista interna de solicitudes.
     * Este méthodo puede ser utilizado por otros servicios que necesiten ordenar o modificar la lista.
     *
     * @return Lista de solicitudes actual.
     */
    public static ArrayList<Request> getRequestArray() {
        return requests;
    }

    /**
     * Reemplaza toda la lista de solicitudes actual por una nueva lista.
     *
     * @param requests Nueva lista de solicitudes a almacenar.
     */
    public static void setRequests(ArrayList<Request> requests) {
        RepositoryRequest.requests = requests;
    }
}
