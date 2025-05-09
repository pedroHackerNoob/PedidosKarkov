package karkov.services;

import karkov.models.Request;
import karkov.repository.RepositoryRequest;

public class ServiceSearchId {
    public static void searchById(int id) {
        System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(RepositoryRequest.getRequest(id).toString());
        System.out.println("-------------------------------------------------------------------------------");
    }
}
