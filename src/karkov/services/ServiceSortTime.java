package karkov.services;

import karkov.models.Request;
import karkov.repository.RepositoryRequest;

import java.util.ArrayList;

/**
 * Clase que proporciona funcionalidades para ordenar solicitudes ({@link Request})
 * por su propiedad {@code LimitTime} utilizando el algoritmo Merge Sort.
 * <p>
 * Esta clase trabaja directamente con la lista de solicitudes obtenida desde el
 * {@link RepositoryRequest}, y la ordena de forma ascendente según el tiempo límite
 * de atención para facilitar su gestión.
 */
public class ServiceSortTime {

    /**
     * Méthodo principal que obtiene una lista de solicitudes desde el repositorio,
     * las ordena por su hora límite (LimitTime) y las imprime en consola con formato.
     */
    public static void sortByTime() {
        ArrayList<Request> requestsSortedByTime = new ArrayList<>(RepositoryRequest.getRequestArray());
        sort(requestsSortedByTime);

        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
        System.out.println("-------------------------------------------------------------------------------");
        for (Request request : requestsSortedByTime) {
            System.out.println(request.toString());
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    /**
     * Ordena una lista de objetos {@link Request} por la propiedad {@code LimitTime}
     * utilizando el algoritmo Merge Sort.
     *
     * @param requests Lista de solicitudes a ordenar.
     * @return Lista ordenada por {@code LimitTime}.
     */
    private static ArrayList<Request> sort(ArrayList<Request> requests) {
        Request[] helper = new Request[requests.size()];
        sort(requests, helper, 0, requests.size() - 1);
        return requests;
    }

    /**
     * Méthodo recursivo que divide la lista en sublistas para ordenarlas usando Merge Sort.
     *
     * @param requests Lista principal de solicitudes.
     * @param helper Arreglo auxiliar para facilitar la mezcla.
     * @param low Índice inferior del segmento a ordenar.
     * @param high Índice superior del segmento a ordenar.
     */
    private static void sort(ArrayList<Request> requests, Request[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            sort(requests, helper, low, middle);         // Ordenar mitad izquierda
            sort(requests, helper, middle + 1, high);     // Ordenar mitad derecha
            merge(requests, helper, low, middle, high);   // Combinar mitades
        }
    }

    /**
     * Combina dos sublistas ordenadas dentro de la lista original usando el arreglo auxiliar.
     *
     * @param requests Lista original de solicitudes.
     * @param helper Arreglo auxiliar con copias temporales de las solicitudes.
     * @param low Índice inicial de la primera sublista.
     * @param middle Índice final de la primera sublista.
     * @param high Índice final de la segunda sublista.
     */
    private static void merge(ArrayList<Request> requests, Request[] helper, int low, int middle, int high) {
        // Copiar el rango actual al array auxiliar
        for (int i = low; i <= high; i++) {
            helper[i] = requests.get(i);
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        // Comparar elementos de ambas mitades y copiar el menor al arreglo original
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft].getLimitTime() <= helper[helperRight].getLimitTime()) {
                requests.set(current, helper[helperLeft]);
                helperLeft++;
            } else {
                requests.set(current, helper[helperRight]);
                helperRight++;
            }
            current++;
        }

        // Copiar cualquier elemento restante de la mitad izquierda
        while (helperLeft <= middle) {
            requests.set(current++, helper[helperLeft++]);
        }
    }

}
