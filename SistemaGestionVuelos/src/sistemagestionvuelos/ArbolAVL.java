
package sistemagestionvuelos;

// Clase que implementa la estructura y operaciones del Árbol AVL
public class ArbolAVL {

    NodoAVL raiz; // Nodo raíz del árbol

    // ------------------------------
    // MÉTODOS DE UTILIDAD
    // ------------------------------

    // Devuelve la altura del nodo (0 si es nulo)
    int obtenerAltura(NodoAVL n) {
        return (n == null) ? 0 : n.altura;
    }

    // Calcula el factor de balanceo de un nodo
    int obtenerBalance(NodoAVL n) {
        return (n == null) ? 0 : obtenerAltura(n.izquierda) - obtenerAltura(n.derecha);
    }

    // Devuelve el mayor de dos números (usado para calcular alturas)
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // ------------------------------
    // ROTACIONES (para balancear el árbol)
    // ------------------------------

    // Rotación simple a la derecha
    NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL temp = x.derecha;

        // Rotamos los punteros
        x.derecha = y;
        y.izquierda = temp;

        // Actualizamos alturas
        y.altura = max(obtenerAltura(y.izquierda), obtenerAltura(y.derecha)) + 1;
        x.altura = max(obtenerAltura(x.izquierda), obtenerAltura(x.derecha)) + 1;

        // x pasa a ser la nueva raíz
        return x;
    }

    // Rotación simple a la izquierda
    NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL temp = y.izquierda;

        // Rotamos punteros
        y.izquierda = x;
        x.derecha = temp;

        // Actualizamos alturas
        x.altura = max(obtenerAltura(x.izquierda), obtenerAltura(x.derecha)) + 1;
        y.altura = max(obtenerAltura(y.izquierda), obtenerAltura(y.derecha)) + 1;

        // y pasa a ser la nueva raíz
        return y;
    }

    // ------------------------------
    // INSERCIÓN
    // ------------------------------

    NodoAVL insertar(NodoAVL nodo, Vuelo vuelo) {
        // 1️⃣ Inserción normal en un árbol binario
        if (nodo == null) {
            return new NodoAVL(vuelo);
        }

        if (vuelo.numero < nodo.vuelo.numero) {
            nodo.izquierda = insertar(nodo.izquierda, vuelo);
        } else if (vuelo.numero > nodo.vuelo.numero) {
            nodo.derecha = insertar(nodo.derecha, vuelo);
        } else {
            // Si el número ya existe, no se inserta
            System.out.println("❗ El vuelo con número " + vuelo.numero + " ya existe.");
            return nodo;
        }

        // 2️⃣ Actualizamos altura del nodo actual
        nodo.altura = 1 + max(obtenerAltura(nodo.izquierda), obtenerAltura(nodo.derecha));

        // 3️⃣ Calculamos el factor de balanceo
        int balance = obtenerBalance(nodo);

        // 4️⃣ Aplicamos rotaciones si el árbol se desbalancea

        // Caso Izquierda-Izquierda
        if (balance > 1 && vuelo.numero < nodo.izquierda.vuelo.numero)
            return rotacionDerecha(nodo);

        // Caso Derecha-Derecha
        if (balance < -1 && vuelo.numero > nodo.derecha.vuelo.numero)
            return rotacionIzquierda(nodo);

        // Caso Izquierda-Derecha
        if (balance > 1 && vuelo.numero > nodo.izquierda.vuelo.numero) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        // Caso Derecha-Izquierda
        if (balance < -1 && vuelo.numero < nodo.derecha.vuelo.numero) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        // Retornamos el nodo sin cambios
        return nodo;
    }

    // ------------------------------
    // BÚSQUEDA
    // ------------------------------

    // Busca un vuelo por número
    Vuelo buscarPorNumero(NodoAVL nodo, int numero) {
        if (nodo == null) return null;

        if (numero == nodo.vuelo.numero) return nodo.vuelo;
        if (numero < nodo.vuelo.numero)
            return buscarPorNumero(nodo.izquierda, numero);
        else
            return buscarPorNumero(nodo.derecha, numero);
    }

    // Busca vuelos por destino (muestra todos los que coincidan)
    void buscarPorDestino(NodoAVL nodo, String destino) {
        if (nodo == null) return;

        buscarPorDestino(nodo.izquierda, destino);
        if (nodo.vuelo.destino.equalsIgnoreCase(destino))
            System.out.println(nodo.vuelo);
        buscarPorDestino(nodo.derecha, destino);
    }

    // ------------------------------
    // ELIMINACIÓN
    // ------------------------------

    NodoAVL eliminar(NodoAVL nodo, int numero) {
        if (nodo == null) return nodo;

        // Eliminación normal de ABB
        if (numero < nodo.vuelo.numero) {
            nodo.izquierda = eliminar(nodo.izquierda, numero);
        } else if (numero > nodo.vuelo.numero) {
            nodo.derecha = eliminar(nodo.derecha, numero);
        } else {
            // Nodo encontrado
            if ((nodo.izquierda == null) || (nodo.derecha == null)) {
                NodoAVL temp = (nodo.izquierda != null) ? nodo.izquierda : nodo.derecha;

                // Caso sin hijos
                if (temp == null) {
                    nodo = null;
                } else { // Caso con un hijo
                    nodo = temp;
                }
            } else {
                // Nodo con dos hijos: obtener el sucesor (mínimo de la derecha)
                NodoAVL temp = nodoMinimo(nodo.derecha);
                nodo.vuelo = temp.vuelo;
                nodo.derecha = eliminar(nodo.derecha, temp.vuelo.numero);
            }
        }

        // Si el árbol quedó vacío
        if (nodo == null) return nodo;

        // Actualizamos altura
        nodo.altura = 1 + max(obtenerAltura(nodo.izquierda), obtenerAltura(nodo.derecha));

        // Balanceamos
        int balance = obtenerBalance(nodo);

        // Casos de rotación igual que en inserción
        if (balance > 1 && obtenerBalance(nodo.izquierda) >= 0)
            return rotacionDerecha(nodo);

        if (balance > 1 && obtenerBalance(nodo.izquierda) < 0) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && obtenerBalance(nodo.derecha) <= 0)
            return rotacionIzquierda(nodo);

        if (balance < -1 && obtenerBalance(nodo.derecha) > 0) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    // Encuentra el nodo con el valor mínimo
    NodoAVL nodoMinimo(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.izquierda != null)
            actual = actual.izquierda;
        return actual;
    }

    // ------------------------------
    // RECORRIDOS
    // ------------------------------

    void inorden(NodoAVL nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.println(nodo.vuelo);
            inorden(nodo.derecha);
        }
    }

    void preorden(NodoAVL nodo) {
        if (nodo != null) {
            System.out.println(nodo.vuelo);
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }
    }

    void postorden(NodoAVL nodo) {
        if (nodo != null) {
            postorden(nodo.izquierda);
            postorden(nodo.derecha);
            System.out.println(nodo.vuelo);
        }
    }
}

