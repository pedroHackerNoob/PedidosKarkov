package karkov.services;

import karkov.models.Request;
import karkov.repository.RepositoryRequest;

import java.util.ArrayList;

public class ServiceSortTime {

    public static void sortByTime(){
        ArrayList<Request> requestsSortedByTime= ServiceSortTime.sort(RepositoryRequest.getRequestArray());
        for (Request request : requestsSortedByTime) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("ID: "+request.getId()+" Tiempo Limite: "+request.getLimitTime()+" Hora");
        }
    }

    private static ArrayList<Request> sort(ArrayList<Request> requests) {

        Request[] helper = new Request[requests.size()];
        sort(requests, helper, 0, requests.size() - 1);
        return requests;
    }

    private static void sort(ArrayList<Request> requests, Request[] helper, int low, int high) {

        if (low < high) {

            int middle = (low + high) / 2;
            sort(requests, helper, low, middle); // Ordena lado izquierdo
            sort(requests, helper, middle + 1, high); // Ordena lado derecho
            merge(requests, helper, low, middle, high); // Mezcla ambos
        }
    }

    private static void merge(ArrayList<Request> requests, Request[] helper, int low, int middle, int high) {
        /* Copia ambas mitades en el requests auxiliar */
        for (int i = low; i <= high; i++) {

            helper[i] = requests.get(i);
        }
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /* Itera el requests auxiliar. Compara la mitad izquierda y la derecha, copiando el menor elemento
         * de las dos mitades al requests original. */
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

        /* Copia el resto del lado izquierdo en el target requests.
         * Los elementos de la izquierda no se copian ya que ya se encuentran en el requests. Por ejemplo
         * 3 5 14 || 2 4 6. Por orden, copiamos 2, 3, 4, 5 y 6 al requests, por lo que tenemos que copiar
         * el resto de la izquierda (14)
         * Otro ejemplo: 2 4 6 || 3 5 14. Copiamos 2, 3, 4, 5 y 6 al requests.
         * El requests helper es una copia del requests, por lo que no tenemos que copiar esa parte,
         * ya está en su posición.
         */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            requests.set(current + i, helper[helperLeft + i]);
        }
    }

}
