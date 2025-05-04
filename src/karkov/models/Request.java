package karkov.models;

import karkov.repository.RepositoryRequest;

public class Request extends RepositoryRequest {
    int id;
    String zone;
    String address;
    String prority;
    int limitTime;

    public Request(int id, String zone, String address, String prority, int limitTime) {
        this.id = id;
        this.zone = zone;
        this.address = address;
        this.prority = prority;
        this.limitTime = limitTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrority() {
        return prority;
    }

    public void setPrority(String prority) {
        this.prority = prority;
    }

    public int getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", zona='" + zone + '\'' +
                ", direccion='" + address + '\'' +
                ", prioridad='" + prority + '\'' +
                ", horaLimite=" + limitTime +
                '}';
    }
}
