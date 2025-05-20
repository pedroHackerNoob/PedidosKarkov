package karkov.views;

import karkov.models.Request;
import karkov.repository.RepositoryRequest;
import karkov.services.ServiceSortPriority;
import karkov.services.ServiceSortTime;

import java.util.Scanner;

/**
 * Clase que representa el menú principal del sistema.
 * Permite al usuario agregar, mostrar, eliminar y ordenar solicitudes.
 * También incluye una interfaz gráfica ASCII del grafo de zonas.
 */
public class Menu {

    /**
     * Scanner para capturar la entrada del usuario desde consola.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Permite al usuario crear y registrar una nueva solicitud (Request).
     * Simula la entrada de datos (actualmente fija para pruebas).
     * Incluye zona, número de casa, prioridad y tiempo límite.
     */
    private static void addRequest() {
        String zone = "Zona ";
        System.out.println("" +
                "Ingrese Zona:" +
                "\nA\tB \tC" +
                "\nD\tE\tF" +
                "\nG\tI\tJ ");

        String home = null;
        String priority = null;
        int tempo = 0;

        try {
            // Entrada de prueba reemplazando la interacción con el usuario:
            zone += sc.next();
            System.out.println("Ingrese número de casa: ");
            System.out.println("Ingrese prioridad:\nBaja [1]\nMedia [2]\nAlta [3]");
            priority = sc.next();
            System.out.println("Ingrese límite de tiempo: ");

            // Datos simulados para pruebas:
            home = "113(default)";

            tempo = sc.nextInt();

        } catch (Exception e) {
            sc.next(); // Limpia el buffer
            addRequest(); // Intenta de nuevo
        }

        zone = zone.toUpperCase();

        // Validación y mapeo de prioridad numérica a texto
        if (priority.equals("1")) {
            priority = "baja";
        } else if (priority.equals("2")) {
            priority = "media";
        } else if (priority.equals("3")) {
            priority = "alta";
        } else {
            priority = "baja"; // Valor por defecto
        }

        int idTemp = RepositoryRequest.getRequests().size();
        RepositoryRequest.addRequest(new Request(idTemp, zone, home, priority, tempo));
    }

    /**
     * Muestra el menú de opciones principales del sistema y ejecuta la opción seleccionada.
     */
    public static void optionMenus() {
        while (true){
            System.out.println("\n==========================================\nHome:");
            System.out.println("[1] Agregar Pedido\n[2] Mostrar pedido\n[3] Buscar pedido\n[4] cambiar a repartidor");

            int option = 2; // Valor predeterminado de prueba

            try {
                 option = sc.nextInt();

            } catch (Exception e) {
                System.out.println("Opción inválida.");
                sc.next(); // Limpia el buffer
                continue; // Vuelve a mostrar el menú
            }

            switch (option) {
                case 1:
                    addRequest();
                    RepositoryRequest.showRequests();
                    break;
                case 2:
                    RepositoryRequest.showRequests();
                    showRequest();
                    break;
                case 3:
                    searchRequest();
                    break;
                default:
                    break;
                case 4:
                    MenuDriver.selectRequest();
            }

            if(option == 5){ //desea repetir la operacion
                break;
            }
        }

    }

    /**
     * Muestra submenús para visualizar solicitudes ordenadas por diferentes criterios.
     */
    private static void showRequest() {
        System.out.println("Mostrar últimos pedidos [1]");
        System.out.println("Mostrar pedidos por límite de tiempo [2]");
        System.out.println("Mostrar pedidos por prioridad [3]");

        int option = sc.nextInt();

        switch (option) {
            case 1:
                RepositoryRequest.showRequests();
                break;
            case 2:
                ServiceSortTime.sortByTime();
                break;
            case 3:
                ServiceSortPriority.sortByPriority();
                break;
            default:
                break;
        }
    }

    /**
     * Permite buscar un pedido existente en el sistema mediante su ID.
     *
     * Solicita al usuario que ingrese el ID de un pedido, luego verifica si existe
     * en el repositorio de solicitudes. Si el pedido es encontrado, se muestra su información.
     */
    public static void searchRequest() {
        System.out.println("Ingrese Id del pedido a encontrar");
        int id = sc.nextInt();
        if (RepositoryRequest.getRequest(id) != null) {
            System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
            System.out.println("-------------------------------------------------------------------------------");

//            RepositoryRequest.getRequest(id).setId(id); // Esto puede ser innecesario
            System.out.println(RepositoryRequest.getRequest(id).toString());
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

}
