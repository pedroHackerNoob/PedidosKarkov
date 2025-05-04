package karkov.repository;

import karkov.models.Request;

import java.util.ArrayList;

public class RepositoryRequest {
    static ArrayList<Request> requests = new ArrayList<>();

    public static void addRequest(Request request) {
        requests.add(request);
    }
    public static void readRequests(){
        for (Request r : requests) {
            System.out.println(r.toString());
        }
    }

    public static ArrayList<Request> getRequests() {
        return requests;
    }

    public static void setRequests(ArrayList<Request> requests) {
        RepositoryRequest.requests = requests;
    }
}
