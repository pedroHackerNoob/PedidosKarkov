package karkov.repository;

import karkov.models.Request;

import java.util.ArrayList;

public class RepositoryRequest {
    static ArrayList<Request> requests = new ArrayList<>();

    public static void addRequest(Request request) {
        requests.add(request);
    }
    public static void showRequests(){
        for (Request r : requests) {
            System.out.println("| ID  | Zona            | Dirección                      | Prioridad | Hora Limite |");
            System.out.println("-------------------------------------------------------------------------------");

            System.out.println(r.toString());
        }
    }

    public static ArrayList<Request> getRequests() {
        return requests;
    }
    public static Request getRequest(int id) {

        return requests.get(id);
    }
    public static ArrayList<Request> getRequestArray() {
        return requests;
    }
    public static void setRequests(ArrayList<Request> requests) {
        RepositoryRequest.requests = requests;
    }
}
