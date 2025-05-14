package karkov.views;

import karkov.repository.RepositoryRequest;
import karkov.services.ServiceGraphPounder;

import java.util.Scanner;

/**
 * Clase que permite al usuario seleccionar una solicitud (Request) para calcular la ruta más corta desde el Centro.
 * Utiliza el algoritmo de Dijkstra implementado en {@link ServiceGraphPounder}.
 */
public class MenuDriver {

    /**
     * Scanner para capturar entrada desde la consola.
     */
    static Scanner sc = new Scanner(System.in);

    /**
     * Permite seleccionar una solicitud por su ID y calcular el camino más corto desde "Centro" hasta la zona asociada.
     * Muestra todas las solicitudes disponibles y solicita al usuario el ID del pedido.
     */
    public static void selectRequest() {
        while (true) {
            int idTemp = 0;
            String zone = null;

            RepositoryRequest.showRequests();
            System.out.println("Ingrese ID del pedido:");

            try {
                // Entrada de prueba fija. Reemplazar con: idTemp = sc.nextInt();
                idTemp = sc.nextInt();

                // Obtiene la zona asociada a la solicitud seleccionada.
                zone = RepositoryRequest.getRequest(idTemp).getZone();

                // Llama al servicio que calcula el camino más corto desde "Centro" a la zona.
                ServiceGraphPounder.caminoMasCorto("Centro", zone);

            } catch (Exception e) {
                sc.next();
                System.out.println("ID no válido");
                continue;
            }
            if(!Menu.stillOperation()){ //desea repetir la operacion
                break;
            }
        }
    }
}
