package karkov.models;

import karkov.repository.RepositoryRequest;
import karkov.services.ServiceGraphPounder;

public class TestModelsDefault {
    public static void defaultTest(){
        RepositoryRequest.addRequest(new Request(0, "Zona A", "av. las flores #23", "baja", 5));
        RepositoryRequest.addRequest(new Request(1, "Zona A", "av. las flores #23", "baja", 5));
        RepositoryRequest.addRequest(new Request(2, "Zona B", "calle real, casa 11", "alta", 2));
        RepositoryRequest.addRequest(new Request(3, "Zona A", "barrio el centro #7", "media", 8));
        RepositoryRequest.addRequest(new Request(4, "Zona C", "col. altavista, pasaje 4", "alta", 6));
        RepositoryRequest.addRequest(new Request(5, "Zona D", "av. del mar #19", "media", 1));
        RepositoryRequest.addRequest(new Request(6, "Zona F", "res. el bosque, bloque C", "baja", 9));
        RepositoryRequest.addRequest(new Request(7, "Zona G", "calle el triunfo #42", "alta", 4));
        RepositoryRequest.addRequest(new Request(8, "Zona H", "calle central, casa 10", "media", 7));
        RepositoryRequest.addRequest(new Request(9, "Zona I", "zona norte, av 2", "baja", 3));
        RepositoryRequest.addRequest(new Request(10, "Zona E", "zona sur, av 13", "baja", 3));

        // Configuración de conexiones entre zonas (grafo con pesos)
        ServiceGraphPounder.agregarConexion("Centro", "Zona A", 4);
        ServiceGraphPounder.agregarConexion("Centro", "Zona B", 2);
        ServiceGraphPounder.agregarConexion("Zona A", "Zona C", 5);
        ServiceGraphPounder.agregarConexion("Zona B", "Zona A", 1);
        ServiceGraphPounder.agregarConexion("Zona B", "Zona D", 7);
        ServiceGraphPounder.agregarConexion("Zona C", "Zona D", 3);
        ServiceGraphPounder.agregarConexion("Zona D", "Zona E", 2);
        ServiceGraphPounder.agregarConexion("Zona E", "Zona F", 3);
        ServiceGraphPounder.agregarConexion("Zona F", "Zona G", 2);
        ServiceGraphPounder.agregarConexion("Zona G", "Zona H", 4);
        ServiceGraphPounder.agregarConexion("Zona H", "Zona I", 1);
        ServiceGraphPounder.agregarConexion("Zona I", "Centro", 6);
        ServiceGraphPounder.agregarConexion("Zona C", "Zona G", 6);
        ServiceGraphPounder.agregarConexion("Zona B", "Zona F", 9);
    }
}
