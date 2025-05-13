/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package karkov;

import karkov.services.GraphPounder;
import karkov.models.Request;
import karkov.repository.RepositoryRequest;
import karkov.views.Menu;

/**
 *
 * @author blackhawk
 */
public class Karkov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        RepositoryRequest.addRequest(new Request(1, "Zona A", "av. las flores #23", "baja", 5));
        RepositoryRequest.addRequest(new Request(2, "Zona B", "calle real, casa 11", "alta", 2));
        RepositoryRequest.addRequest(new Request(3, "Zona A", "barrio el centro #7", "media", 8));
        RepositoryRequest.addRequest(new Request(4, "Zona C", "col. altavista, pasaje 4", "alta", 6));
        RepositoryRequest.addRequest(new Request(5, "Zona D", "av. del mar #19", "media", 1));
        RepositoryRequest.addRequest(new Request(6, "Zona F", "res. el bosque, bloque C", "baja", 9));
        RepositoryRequest.addRequest(new Request(7, "Zona G", "calle el triunfo #42", "alta", 4));
        RepositoryRequest.addRequest(new Request(8, "Zona H", "calle central, casa 10", "media", 7));
        RepositoryRequest.addRequest(new Request(9, "Zona I", "zona norte, av 2", "baja", 3));


//        ServiceSortPriority.sortByPriority();
//        ServiceSortPriority.showSortByPriority();
//        ServiceSortTime.sortByTime();

        GraphPounder map = new GraphPounder();

        map.agregarConexion("Centro", "Zona A", 4);
        map.agregarConexion("Centro", "Zona B", 2);
        map.agregarConexion("Zona A", "Zona C", 5);
        map.agregarConexion("Zona B", "Zona A", 1);
        map.agregarConexion("Zona B", "Zona D", 7);
        map.agregarConexion("Zona C", "Zona D", 3);
        map.agregarConexion("Zona D", "Zona E", 2);
        map.agregarConexion("Zona E", "Zona F", 3);
        map.agregarConexion("Zona F", "Zona G", 2);
        map.agregarConexion("Zona G", "Zona H", 4);
        map.agregarConexion("Zona H", "Zona I", 1);
        map.agregarConexion("Zona I", "Centro", 6); // Conexión cíclica para asegurar rutas alternativas
        map.agregarConexion("Zona C", "Zona G", 6); // Otra ruta posible
        map.agregarConexion("Zona B", "Zona F", 9); // Ruta larga alternativa

//        map.obtenerCadaCamino("Centro");
        Menu.optionMenus();
    }
}
