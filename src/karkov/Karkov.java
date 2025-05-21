/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package karkov;

import karkov.models.TestModelsDefault;
import karkov.services.ServiceGraphPounder;
import karkov.models.Request;
import karkov.repository.RepositoryRequest;
import karkov.views.Menu;
import karkov.views.MenuDriver;

/**
 * Clase principal del sistema Karkov.
 *
 * Esta clase representa el punto de entrada del programa. Inicializa los pedidos (requests)
 * y configura el grafo de zonas con sus respectivas conexiones. También lanza el menú de operaciones
 * para interacción del usuario.
 *
 * Funcionalidades clave:
 * - Carga inicial de pedidos (requests) predefinidos.
 * - Configuración del grafo de zonas con pesos entre conexiones.
 * - Llamado al menú principal de interacción (`Menu.optionMenus()`).
 * - Ejecución de pruebas de búsqueda de rutas entre zonas.
 *
 * Autor: blackhawk
 */
public class Karkov {

    /**
     * Método principal que lanza la ejecución del sistema.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Carga de pedidos iniciales (simulados para pruebas)
        TestModelsDefault.defaultTest();

        // Llamada al menú principal del sistema
        Menu.optionMenus();

        // Llamada adicional para seleccionar un pedido y mostrar ruta
        MenuDriver.selectRequest();

        // Llamadas de prueba para búsqueda por ID (comentadas)
        // ServiceSearchId.searchById(10);
        // ServiceSearchId.searchById(3);
    }
}
