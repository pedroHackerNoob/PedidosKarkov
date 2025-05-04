package karkov.services;

import karkov.models.Request;
import karkov.repository.RepositoryRequest;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceSortPriority {
    static ArrayList<Request> requestsSort = new ArrayList<>();

    public static void sortByPriority() {
        ArrayList<Request> requestsSortLow = new ArrayList<>();
        ArrayList<Request> requestsSortMedium = new ArrayList<>();
        ArrayList<Request> requestsSortHigh = new ArrayList<>();

        for(int i = 0; i < RepositoryRequest.getRequests().size(); i++){
            if (RepositoryRequest.getRequests().get(i).getPrority().equals("baja")) {
                requestsSortLow.add(RepositoryRequest.getRequests().get(i));
            } else if (RepositoryRequest.getRequests().get(i).getPrority().equals("media")) {
                requestsSortMedium.add(RepositoryRequest.getRequests().get(i));
            } else if (RepositoryRequest.getRequests().get(i).getPrority().equals("alta")) {
                requestsSortHigh.add(RepositoryRequest.getRequests().get(i));
            }

        }
        requestsSort.addAll(requestsSortHigh);
        requestsSort.addAll(requestsSortMedium);
        requestsSort.addAll(requestsSortLow);
    }

    public static void showSortByPriority() {
        System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
        System.out.println("-------------------------------------------------------------------------------");
        for(Request request : requestsSort){
            System.out.println(request.toString());
            System.out.println("-------------------------------------------------------------------------------");
        }
    }
}
