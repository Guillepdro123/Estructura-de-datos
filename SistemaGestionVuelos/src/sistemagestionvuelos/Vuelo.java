
package sistemagestionvuelos;

// Clase que representa la información de un vuelo
public class Vuelo {
    // Atributos básicos del vuelo
    int numero;           // Número identificador único del vuelo
    String origen;        // Ciudad o aeropuerto de origen
    String destino;       // Ciudad o aeropuerto de destino
    String hora;          // Hora de salida o llegada
    String aerolinea;     // Nombre de la aerolínea

    // Constructor para inicializar un vuelo
    public Vuelo(int numero, String origen, String destino, String hora, String aerolinea) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
        this.aerolinea = aerolinea;
    }

    // Sobrescribimos toString() para mostrar el vuelo de forma legible
    @Override
    public String toString() {
        return "Vuelo Numero: " + numero + " | " + origen + " → " + destino +
                " | Hora: " + hora + " | Aerolinea: " + aerolinea;
    }
}

