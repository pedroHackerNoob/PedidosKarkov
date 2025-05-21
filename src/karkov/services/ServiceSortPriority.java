package karkov.services;

import karkov.models.Request;
import karkov.repository.RepositoryRequest;

import java.util.ArrayList;

public class ServiceSortPriority {
    private static final String HIGH_PRIORITY = "alta";
    private static final String MEDIUM_PRIORITY = "media";
    private static final String LOW_PRIORITY = "baja";

    public static ArrayList<Request> requestsSort = new ArrayList<>();

    public static void sortByPriority() {
        // Clear previous results
        requestsSort.clear();

        ArrayList<Request> requestsSortLow = new ArrayList<>();
        ArrayList<Request> requestsSortMedium = new ArrayList<>();
        ArrayList<Request> requestsSortHigh = new ArrayList<>();

        for(Request request : RepositoryRequest.getRequests()) {
            if (request == null || request.getPrority() == null) {
                continue;
            }

            String priority = request.getPrority();
            switch(priority) {
                case LOW_PRIORITY:
                    requestsSortLow.add(request);
                    break;
                case MEDIUM_PRIORITY:
                    requestsSortMedium.add(request);
                    break;
                case HIGH_PRIORITY:
                    requestsSortHigh.add(request);
                    break;
                default:
                    // prioridad desconocida priority
                    break;
            }
        }

        requestsSort.addAll(requestsSortHigh);
        requestsSort.addAll(requestsSortMedium);
        requestsSort.addAll(requestsSortLow);

        showSortByPriority();
    }


    private static void showSortByPriority() {
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
        System.out.println("-------------------------------------------------------------------------------");
        for(Request request : requestsSort){
            System.out.println(request.toString());
            System.out.println("-------------------------------------------------------------------------------");
        }
    }
}
