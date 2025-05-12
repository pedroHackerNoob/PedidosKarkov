package karkov.models;

/**
 * Representa una arista en un grafo ponderado, con un destino y una distancia asociada.
 * Es utilizada para modelar las conexiones entre zonas dentro de un grafo.
 */
public class Arista {

    /**
     * Nombre de la zona destino de esta arista.
     */
    private String destino;

    /**
     * Distancia (peso) de la conexión hacia la zona destino.
     */
    private int distancia;

    /**
     * Crea una nueva arista con el destino y la distancia especificados.
     *
     * @param zona      Nombre de la zona destino.
     * @param distancia Distancia (peso) hacia el destino.
     */
    public Arista(String zona, int distancia) {
        this.destino = zona;
        this.distancia = distancia;
    }

    /**
     * Obtiene el nombre de la zona destino.
     *
     * @return El nombre de la zona destino.
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Establece el nombre de la zona destino.
     *
     * @param destino El nuevo nombre de la zona destino.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene la distancia (peso) hacia el destino.
     *
     * @return La distancia hacia la zona destino.
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * Establece la distancia (peso) hacia el destino.
     *
     * @param distancia La nueva distancia hacia el destino.
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * Devuelve una representación en texto de esta arista, incluyendo destino y distancia.
     *
     * @return Cadena con los datos de la arista.
     */
    @Override
    public String toString() {
        return "Arista{" +
                "destino=" + destino +
                ", distancia=" + distancia +
                '}';
    }
}
