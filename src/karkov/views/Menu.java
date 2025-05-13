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
        System.out.println("Ingrese Zona:\nA\nB\nC\nD\nE\nF\nG\nH\nI\nJ ");
        String home = null;
        String priority = null;
        int tempo = 0;

        try {
            // Entrada de prueba reemplazando la interacción con el usuario:
            System.out.println("Ingrese número de casa: ");
            System.out.println("Ingrese prioridad:\nBaja [3]\nMedia [2]\nAlta [1]");
            System.out.println("Ingrese límite de tiempo: ");

            // Datos simulados para pruebas:
            home = "113";
            priority = "1";
            zone += "b";
            tempo = 666;

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
        System.out.println("1. Add Request");
        System.out.println("2. Show Requests");
        System.out.println("3. Delete Request");
        System.out.println("4. Update Request");
        System.out.println("5. Exit Request");

        int option = 1; // Valor predeterminado de prueba

        try {
            // option = sc.nextInt(); // Habilitar cuando se use entrada real
        } catch (Exception e) {
            System.out.println("Opción inválida.");
            sc.next(); // Limpia el buffer
            optionMenus(); // Vuelve a mostrar el menú
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
            default:
                break;
        }

        if (stillOperation()) optionMenus(); // Repetir si se desea continuar
        else sc.close();
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
                ServiceSortPriority.sortByPriority();
                break;
            case 3:
                ServiceSortTime.sortByTime();
                break;
            default:
                break;
        }
    }

    /**
     * Pregunta al usuario si desea continuar con la operación.
     *
     * @return {@code true} si el usuario desea continuar, {@code false} en caso contrario.
     */
    public static boolean stillOperation() {
        System.out.println("¿Desea continuar? [y/n]");
        String still = null;

        try {
            still = sc.next();
        } catch (Exception e) {
            sc.next();
            System.out.println("Opción inválida.");
            stillOperation();
        }

        return "y".equalsIgnoreCase(still);
    }

    /**
     * Imprime una representación en texto (ASCII) del grafo de zonas y sus conexiones.
     */
    public static void grafoUi() {
        System.out.println("                [Zona C]\n" +
                "                   |\n" +
                "                 5 |\n" +
                "                   |\n" +
                "               [Zona A]\n" +
                "                   |\n" +
                "        4          |           1\n" +
                "Centro -------- [Zona B] ---------\n" +
                " |              /   |   \\         \\\n" +
                " |            2    7     9         \\\n" +
                " |           /     |       \\        \\\n" +
                " |         /       |         \\        \\\n" +
                "[Zona I]--6       [Zona D]     \\        \\\n" +
                "   |                 |          \\        \\\n" +
                "   |                 2           \\        \\\n" +
                "   |                 |            \\        \\\n" +
                "[Zona H] --------- [Zona E]        \\        \\\n" +
                "   |                   |            \\        \\\n" +
                "   1                   3             \\        \\\n" +
                "   |                   |              \\        \\\n" +
                "[Zona G] <------------- [Zona F] <-----         \\\n" +
                "   ^         6             ^                    \\\n" +
                "    \\______________________/                      \\\n" +
                "                      2                            9\n");
    }
}
