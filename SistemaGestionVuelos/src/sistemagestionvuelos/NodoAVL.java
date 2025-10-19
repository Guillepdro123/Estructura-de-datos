
package sistemagestionvuelos;

// Clase que representa un nodo dentro del árbol AVL
public class NodoAVL {
    Vuelo vuelo;           // Contiene los datos del vuelo
    int altura;            // Altura del nodo (usada para calcular el factor de balanceo)
    NodoAVL izquierda;     // Hijo izquierdo
    NodoAVL derecha;       // Hijo derecho

    // Constructor: crea un nodo con un vuelo dado
    public NodoAVL(Vuelo vuelo) {
        this.vuelo = vuelo;
        this.altura = 1; // Altura inicial de un nodo hoja
    }
}

