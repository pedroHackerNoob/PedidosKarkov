package karkov.models;

/**
 * Representa una solicitud o pedido realizado por un cliente en el sistema.
 * <p>
 * Esta clase actúa como entidad principal que contiene datos relevantes como la zona,
 * dirección, prioridad y hora límite de entrega.
 */
public class Request {

    private int id;
    private String zone;
    private String address;
    private String prority;
    private int limitTime;

    /**
     * Constructor para inicializar una solicitud con todos sus atributos.
     *
     * @param id         Identificador único de la solicitud.
     * @param zone       Zona geográfica del destino.
     * @param address    Dirección completa donde se debe realizar la entrega.
     * @param prority    Nivel de prioridad (por ejemplo: alta, media, baja).
     * @param limitTime  Tiempo límite para realizar la entrega (en minutos, por ejemplo).
     */
    public Request(int id, String zone, String address, String prority, int limitTime) {
        this.id = id;
        this.zone = zone;
        this.address = address;
        this.prority = prority;
        this.limitTime = limitTime;
    }

    // Getters y Setters con descripciones:

    /**
     * Obtiene el ID de la solicitud.
     * @return ID de la solicitud.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la solicitud.
     * @param id Nuevo ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la zona geográfica de la solicitud.
     * @return Zona de entrega.
     */
    public String getZone() {
        return zone;
    }

    /**
     * Establece la zona de la solicitud.
     * @param zone Nueva zona.
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * Obtiene la dirección de entrega de la solicitud.
     * @return Dirección.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Establece la dirección de entrega.
     * @param address Nueva dirección.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Obtiene la prioridad de la solicitud.
     * @return Prioridad.
     */
    public String getPrority() {
        return prority;
    }

    /**
     * Establece la prioridad de la solicitud.
     * @param prority Nueva prioridad.
     */
    public void setPrority(String prority) {
        this.prority = prority;
    }

    /**
     * Obtiene el tiempo límite para atender la solicitud.
     * @return Tiempo límite en formato entero (ej. minutos).
     */
    public int getLimitTime() {
        return limitTime;
    }

    /**
     * Establece el tiempo límite para la solicitud.
     * @param limitTime Nuevo tiempo límite.
     */
    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }

    /**
     * Devuelve una representación en forma de tabla de la solicitud.
     *
     * @return Cadena formateada que incluye los datos clave de la solicitud.
     */
    @Override
    public String toString() {
        return String.format("| %-3d | %-15s | %-30s | %-8s | %-10d |",
                id, zone, address, prority, limitTime);
    }
}
