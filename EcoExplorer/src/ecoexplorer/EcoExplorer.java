package ecoexplorer;

import java.io.*;
import java.util.*;

class Planta {
    String nombreComun;
    String nombreCientifico;
    String region;
    String propiedad;

    public Planta(String nombreComun, String nombreCientifico, String region, String propiedad) {
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.region = region;
        this.propiedad = propiedad;
    }

    @Override
    public String toString() {
        return nombreComun + ";" + nombreCientifico + ";" + region + ";" + propiedad;
    }

    public String mostrar() {
        return "🌿 " + nombreComun + " (" + nombreCientifico + ")\n" +
               "   Region: " + region + "\n" +
               "   Propiedad: " + propiedad;
    }
}

public class EcoExplorer {
    private static final int TAMANIO = 20;
    private static LinkedList<Planta>[] tablaHash = new LinkedList[TAMANIO];
    private static final String ARCHIVO = "plantas.txt";

    // Función hash: convierte texto en un índice numérico dentro del tamaño permitido
    public static int funcionHash(String clave) {
        return Math.abs(clave.toLowerCase().hashCode()) % TAMANIO;
    }

    // Inserta una planta en la tabla hash
    public static void insertar(Planta planta) {
        int indice = funcionHash(planta.nombreComun);
        if (tablaHash[indice] == null) {
            tablaHash[indice] = new LinkedList<>();
        }
        tablaHash[indice].add(planta);
        System.out.println("✅ Planta registrada con exito.");
        guardarEnArchivo();
    }

    // Busca por nombre común
    public static void buscar(String clave) {
        int indice = funcionHash(clave);
        if (tablaHash[indice] != null) {
            for (Planta p : tablaHash[indice]) {
                if (p.nombreComun.equalsIgnoreCase(clave)) {
                    System.out.println("🔎 Planta encontrada:\n" + p.mostrar());
                    return;
                }
            }
        }
        System.out.println("❌ No se encontro la planta.");
    }

    // Elimina por nombre
    public static void eliminar(String clave) {
        int indice = funcionHash(clave);
        if (tablaHash[indice] != null) {
            Iterator<Planta> it = tablaHash[indice].iterator();
            while (it.hasNext()) {
                if (it.next().nombreComun.equalsIgnoreCase(clave)) {
                    it.remove();
                    System.out.println("🗑 Planta eliminada.");
                    guardarEnArchivo();
                    return;
                }
            }
        }
        System.out.println("⚠ Planta no encontrada para eliminar.");
    }

    // Lista todas las plantas en orden alfabético
    public static void listar() {
        List<Planta> todas = new ArrayList<>();
        for (LinkedList<Planta> lista : tablaHash) {
            if (lista != null) todas.addAll(lista);
        }
        todas.sort(Comparator.comparing(p -> p.nombreComun.toLowerCase()));

        if (todas.isEmpty()) {
            System.out.println("🌱 No hay plantas registradas.");
            return;
        }

        System.out.println("\n📋 LISTA DE PLANTAS:");
        for (Planta p : todas) {
            System.out.println(p.mostrar() + "\n");
        }
    }

    // Muestra la estructura de la tabla hash
    public static void mostrarEstructura() {
        System.out.println("\n🧩 ESTRUCTURA DE TABLA HASH:");
        for (int i = 0; i < TAMANIO; i++) {
            System.out.print("[" + i + "]: ");
            if (tablaHash[i] != null) {
                for (Planta p : tablaHash[i]) System.out.print(p.nombreComun + " -> ");
            }
            System.out.println();
        }
    }

    // Guarda todos los datos en el archivo TXT
    public static void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (LinkedList<Planta> lista : tablaHash) {
                if (lista != null) {
                    for (Planta p : lista) {
                        bw.write(p.toString());
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ Error al guardar en archivo.");
        }
    }

    // Carga los datos desde el archivo TXT al iniciar el programa
    public static void cargarDesdeArchivo() {
        File file = new File(ARCHIVO);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    insertarSinGuardar(new Planta(datos[0], datos[1], datos[2], datos[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ Error al cargar datos del archivo.");
        }
    }

    // Inserta sin volver a guardar (para no duplicar al cargar)
    private static void insertarSinGuardar(Planta planta) {
        int indice = funcionHash(planta.nombreComun);
        if (tablaHash[indice] == null) tablaHash[indice] = new LinkedList<>();
        tablaHash[indice].add(planta);
    }

    // Menú principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cargarDesdeArchivo();
        int opcion;

        do {
            System.out.println("\n=== 🌿 ECOEXPLORER - CATALOGO DE PLANTAS MEDICINALES ===");
            System.out.println("1. Registrar planta");
            System.out.println("2. Buscar planta");
            System.out.println("3. Listar plantas");
            System.out.println("4. Eliminar planta");
            System.out.println("5. Mostrar estructura Hash");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre comun: ");
                    String n = sc.nextLine();
                    System.out.print("Nombre cientifico: ");
                    String nc = sc.nextLine();
                    System.out.print("Region: ");
                    String r = sc.nextLine();
                    System.out.print("Propiedad medicinal: ");
                    String p = sc.nextLine();
                    insertar(new Planta(n, nc, r, p));
                    break;
                case 2:
                    System.out.print("Ingrese nombre de la planta a buscar: ");
                    buscar(sc.nextLine());
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    System.out.print("Ingrese nombre de la planta a eliminar: ");
                    eliminar(sc.nextLine());
                    break;
                case 5:
                    mostrarEstructura();
                    break;
                case 0:
                    System.out.println("💚 Gracias por usar EcoExplorer.");
                    break;
                default:
                    System.out.println("⚠ Opción no valida.");
            }
        } while (opcion != 0);
    }
}



