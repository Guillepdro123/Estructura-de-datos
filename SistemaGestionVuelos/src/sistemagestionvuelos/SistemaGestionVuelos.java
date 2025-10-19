
package sistemagestionvuelos;

import java.util.Scanner;

// Clase principal: gestiona la interacción del usuario con el árbol AVL
public class SistemaGestionVuelos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolAVL arbol = new ArbolAVL();
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE GESTION DE VUELOS (AVL) ===");
            System.out.println("1. Registrar vuelo");
            System.out.println("2. Buscar vuelo por numero");
            System.out.println("3. Buscar vuelos por destino");
            System.out.println("4. Eliminar vuelo");
            System.out.println("5. Mostrar recorridos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Numero del vuelo: ");
                    int numero = sc.nextInt(); sc.nextLine();
                    System.out.print("Origen: ");
                    String origen = sc.nextLine();
                    System.out.print("Destino: ");
                    String destino = sc.nextLine();
                    System.out.print("Hora: ");
                    String hora = sc.nextLine();
                    System.out.print("Aerolinea: ");
                    String aerolinea = sc.nextLine();

                    Vuelo nuevoVuelo = new Vuelo(numero, origen, destino, hora, aerolinea);
                    arbol.raiz = arbol.insertar(arbol.raiz, nuevoVuelo);
                    System.out.println("✅ Vuelo registrado exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el numero del vuelo: ");
                    int numBuscar = sc.nextInt();
                    Vuelo encontrado = arbol.buscarPorNumero(arbol.raiz, numBuscar);
                    System.out.println((encontrado != null) ? encontrado : "❌ No se encontró el vuelo.");
                    break;

                case 3:
                    System.out.print("Ingrese el destino: ");
                    String destBuscar = sc.nextLine();
                    System.out.println("✈️ Vuelos hacia " + destBuscar + ":");
                    arbol.buscarPorDestino(arbol.raiz, destBuscar);
                    break;

                case 4:
                    System.out.print("Numero del vuelo a eliminar: ");
                    int numEliminar = sc.nextInt();
                    arbol.raiz = arbol.eliminar(arbol.raiz, numEliminar);
                    System.out.println("🗑️ Vuelo eliminado si existia.");
                    break;

                case 5:
                    System.out.println("\nRecorrido Inorden:");
                    arbol.inorden(arbol.raiz);
                    System.out.println("\nRecorrido Preorden:");
                    arbol.preorden(arbol.raiz);
                    System.out.println("\nRecorrido Postorden:");
                    arbol.postorden(arbol.raiz);
                    break;

                case 0:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("❗ Opción no valida.");
            }
        } while (opcion != 0);
    }
}

