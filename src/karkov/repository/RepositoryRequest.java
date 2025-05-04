package karkov.repository;

import karkov.models.Request;

import java.util.ArrayList;

public class RepositoryRequest {
    ArrayList<Request> requests = new ArrayList<>();

    public void addRequest(Request request) {
        requests.add(request);
        for (Request r : requests) {
            System.out.println(r.toString());
        }
    }
}
