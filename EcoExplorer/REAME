# 🌿 EcoExplorer - Catálogo de Plantas Medicinales

Sistema de gestión de plantas medicinales implementado con tablas hash en Java, que permite registrar, buscar y administrar información sobre especies de plantas con propiedades curativas.

## 📋 Descripción

EcoExplorer es una aplicación de consola que utiliza una estructura de datos de tabla hash con manejo de colisiones mediante encadenamiento (listas enlazadas). El sistema permite almacenar información sobre plantas medicinales incluyendo su nombre común, nombre científico, región de origen y propiedades medicinales.

## ✨ Características

- *Registro de plantas*: Añade nuevas plantas al catálogo con toda su información
- *Búsqueda eficiente*: Encuentra plantas por nombre común usando hash
- *Listado alfabético*: Visualiza todas las plantas ordenadas por nombre
- *Eliminación*: Borra plantas del catálogo
- *Persistencia de datos*: Guarda y carga automáticamente desde archivo de texto
- *Visualización de estructura*: Muestra la distribución de datos en la tabla hash

## 🛠 Estructura de Datos

- *Tabla Hash*: Array de tamaño 20 con función hash basada en el nombre común
- *Manejo de colisiones*: Listas enlazadas (chaining)
- *Almacenamiento*: Archivo de texto plano (plantas.txt)

## 🚀 Requisitos

- Java JDK 8 o superior
- Terminal o consola de comandos

## 📦 Instalación y Ejecución

1. Clona el repositorio:
bash
git clone [URL-del-repositorio]
cd ecoexplorer


2. Compila el programa:
bash
javac EcoExplorer.java


3. Ejecuta la aplicación:
bash
java EcoExplorer


## 💻 Uso

Al ejecutar el programa, se presenta un menú con las siguientes opciones:


=== 🌿 ECOEXPLORER - CATÁLOGO DE PLANTAS MEDICINALES ===
1. Registrar planta
2. Buscar planta
3. Listar plantas
4. Eliminar planta
5. Mostrar estructura Hash
0. Salir


### Ejemplos de uso:

*Registrar plantas:*

1️⃣ *Planta 1 - Menta*

Nombre común: Menta
Nombre científico: Mentha spicata
Región: Cundinamarca
Propiedad medicinal: Digestiva

> El programa calcula el hash del nombre "Menta" y la guarda en la tabla hash.

2️⃣ *Planta 2 - Manzanilla*

Nombre común: Manzanilla
Nombre científico: Matricaria chamomilla
Región: Boyacá
Propiedad medicinal: Antiinflamatoria

> Se calcula otro hash y se guarda en una posición diferente de la tabla.

3️⃣ *Planta 3 - Aloe Vera*

Nombre común: Aloe Vera
Nombre científico: Aloe barbadensis
Región: Sucre
Propiedad medicinal: Cicatrizante

> El hash se calcula y la planta se almacena en su posición correspondiente.

*Buscar una planta:*

Ingrese nombre de la planta a buscar: Menta
🔎 Planta encontrada:
🌿 Menta (Mentha spicata)
   Región: Cundinamarca
   Propiedad: Digestiva


## 📁 Estructura del Proyecto


EcoExplorer/
│
├── EcoExplorer.java    # Clase principal con la lógica del programa
├── plantas.txt         # Archivo de datos (generado automáticamente)
└── README.md          # Este archivo


## 🔧 Funcionalidades Técnicas

### Clase Planta
Almacena la información de cada planta:
- nombreComun: Nombre popular de la planta
- nombreCientifico: Nomenclatura binomial
- region: Zona geográfica de origen
- propiedad: Propiedades medicinales

### Métodos Principales

- funcionHash(String clave): Genera índice hash a partir del nombre
- insertar(Planta planta): Añade planta a la tabla hash
- buscar(String clave): Busca planta por nombre común
- eliminar(String clave): Elimina planta del catálogo
- listar(): Muestra todas las plantas ordenadas alfabéticamente
- mostrarEstructura(): Visualiza la distribución en la tabla hash
- guardarEnArchivo(): Persiste datos en archivo de texto
- cargarDesdeArchivo(): Carga datos al iniciar el programa

## 📊 Complejidad

- *Búsqueda*: O(1) promedio, O(n) peor caso
- *Inserción*: O(1) promedio
- *Eliminación*: O(1) promedio

## 🤝 Integrante

- Guillermo Sandoval Ricardo - Desarrollo completo del proyecto

## 🎥 Video Explicativo

Puedes ver la explicación completa del proyecto en el siguiente video:

https://youtu.be/_Um2l3RlFFY

> *Nota:* En el video se explica el funcionamiento del programa, la implementación de la tabla hash y una demostración completa de todas las funcionalidades.

## 📝 Licencia

Este proyecto fue desarrollado con fines educativos.

## 🌱 Contribuciones

Este es un proyecto individual desarrollado como parte de un curso de estructuras de datos.

---

💚 *EcoExplorer* - Preservando el conocimiento ancestral de las plantas medicinales
