package karkov.models;

import karkov.repository.RepositoryRequest;
import karkov.services.ServiceGraphPounder;

public class TestModelsDefault {
    public static void defaultTest(){
        RepositoryRequest.addRequest(new Request(0, "Zona A", "apt 2", "baja", 5));
        RepositoryRequest.addRequest(new Request(1, "Zona A", "apt 4", "baja", 5));
        RepositoryRequest.addRequest(new Request(2, "Zona B", "apt 6", "alta", 2));
        RepositoryRequest.addRequest(new Request(3, "Zona A", "apt 3", "media", 8));
        RepositoryRequest.addRequest(new Request(4, "Zona C", "apt 4", "alta", 6));
        RepositoryRequest.addRequest(new Request(5, "Zona D", "apt 8", "media", 1));
        RepositoryRequest.addRequest(new Request(6, "Zona F", "apt 5", "baja", 9));
        RepositoryRequest.addRequest(new Request(7, "Zona G", "apt 7", "alta", 4));
        RepositoryRequest.addRequest(new Request(8, "Zona H", "apt 7", "media", 7));
        RepositoryRequest.addRequest(new Request(9, "Zona I", "apt 9", "baja", 3));
        RepositoryRequest.addRequest(new Request(10, "Zona E", "apt 1", "baja", 3));

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
