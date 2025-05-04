package karkov.models;

public class Pedido {
    int id;
    String zona;
    String direccion;
    String prioridad;
    int horaLimite;

    public Pedido(int id, String zona, String direccion, String prioridad, int horaLimite) {
        this.id = id;
        this.zona = zona;
        this.direccion = direccion;
        this.prioridad = prioridad;
        this.horaLimite = horaLimite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getHoraLimite() {
        return horaLimite;
    }

    public void setHoraLimite(int horaLimite) {
        this.horaLimite = horaLimite;
    }
}
