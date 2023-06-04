package com.datastructures.efdress;

import static com.datastructures.efdress.Articulo.generarDatosPrueba;
import static com.datastructures.efdress.Articulo.obtenerTipos;
import com.datastructures.efdress.enums.Clase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.*;

public class Main extends Application{
    protected static Articulo proofItem;

    private static int size = 0;
    protected static TreeMap<Integer, Articulo> miRopa = new TreeMap<>();
    protected static Favorito favs = Favorito.getInstance();
    protected static Reciente rec = Reciente.getInstance();
    protected static Conjunto conj = new Conjunto();

    public static void medirTiempo(int n, String funcion, int casos) {
        // Se generan n instancias de la clase artículo aleatoriamente
        Random random = new Random();
        int randomNumber;
        long startTime, endTime, time;
        String nombre;
        ArrayList < String > nombres = new ArrayList < > ();
        switch (funcion) {
        case ("buscarId"):
            startTime = System.currentTimeMillis();

            for (int i = 0; i < casos; i++) {
                randomNumber = random.nextInt(n + casos);
                findItem(randomNumber);
            }
            endTime = System.currentTimeMillis();
            time = (endTime - startTime);

            System.out.println("Tiempo: " + time);

            break;

        case ("eliminar"):
            startTime = System.currentTimeMillis();

            for (int i = 0; i < casos; i++) {
                randomNumber = random.nextInt(n + casos);
                removeItem(randomNumber);

            }
            endTime = System.currentTimeMillis();
            time = (endTime - startTime);
            System.out.println("Tiempo: " + time);

            break;
        case ("buscarNombre"):
            int i = 0;
            while (i < casos) {
                randomNumber = random.nextInt(n + casos);
                //System.out.println(randomNumber);
                if (findItem(randomNumber) != null) {
                    nombres.add(findItem(randomNumber).getNombre());
                    i++;
                }
            }

            startTime = System.currentTimeMillis();

            for (int j = 0; j < nombres.size(); j++) {

                findItem(nombres.get(j));

            }
            endTime = System.currentTimeMillis();
            time = (endTime - startTime);
            System.out.println("Tiempo: " + time);

            break;

        case ("nuevo"):
            miRopa = generarDatosPrueba(n, casos);
            /*
                           startTime = System.currentTimeMillis();

                            for (int i = 0; i < 100; i++) {
                                proofItem = new Articulo(n+i, "Camiseta verde gym", "Lycra", "Deportiva", "TopMujer", "Camisetas", "url");
                                miRopa.put(n+i, proofItem);
                            }
                            endTime = System.currentTimeMillis();
                            System.out.print("Tamaño actual : " + miRopa.size()+ ". ");
                            time = endTime - startTime;

                            System.out.println("Total: " + time);
            */
            break;
        }
    }

    public static void medirTiempoFav(int n, String funcion) {
        // Se generan n instancias de la clase artículo aleatoriamente
        Random random = new Random();
        int casos=100;
        int randomNumber;
        long startTime, endTime, time;
        ArrayList < Integer > ids = new ArrayList < > ();
        switch (funcion) {
        case ("eliminar"):
            startTime = System.currentTimeMillis();

            for (int i = 0; i < casos; i++) {
                randomNumber = random.nextInt(n + 100);
                favs.deleteFavorite(randomNumber);

            }
            endTime = System.currentTimeMillis();
            time = (endTime - startTime);
            System.out.println("Time: " + time);

            break;
        case ("buscarId"):

            for (int i = 0; i < casos; i++) {
                ids.add(random.nextInt(n + 100));

            }

            startTime = System.currentTimeMillis();

            for (int i = 0; i < casos; i++) {

                favs.getFav(ids.get(i));

            }
            endTime = System.currentTimeMillis();
            time = (endTime - startTime);
            System.out.println("Time: " + time);

            break;

        case ("nuevo"):

            for (int i = 0; i < n; i++) {
                favs.saveFavorite(i);
            }
            startTime = System.currentTimeMillis();

            for (int i = 0; i < casos; i++) {
                favs.saveFavorite(i);
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Total: " + time);

            break;
        }
    }

    public static String[] userInputUtil(Scanner scanner) {
        String[] values = new String[6];
        System.out.println("Ingrese los datos que se piden a continuación:");
        System.out.print("Nombre: ");
        values[0] = scanner.nextLine();
        System.out.print("Material: ");
        values[1] = scanner.nextLine();
        System.out.print("Ocasion: ");
        values[2] = scanner.nextLine();
        System.out.println("De las siguientes opciones " + Arrays.toString(Clase.values()));
        System.out.print("Clase: ");
        values[3] = scanner.nextLine();
        Enum < ? > [] tipos = obtenerTipos(values[3]);
        if (tipos != null) {
            System.out.println("De las siguientes opciones " + Arrays.toString(tipos));
            System.out.print("Tipo: ");
            values[4] = scanner.nextLine();
        }
        System.out.print("Ubicación: ");
        values[5] = scanner.nextLine();
        return values;
    }

    public static void recorrerRopa(Scanner scanner) {
        boolean salir = false;
        NavigableSet<Integer> navigableSet = miRopa.navigableKeySet();
        Integer currentElement = navigableSet.first();
        while (!salir) {
            System.out.println("\nElemento actual: " + findItem(currentElement));
            System.out.println("1. Recorrer un elemento hacia adelante");
            System.out.println("2. Recorrer un elemento hacia atrás");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (currentElement != navigableSet.last()) {
                        currentElement = navigableSet.higher(currentElement);
                    } else {
                        System.out.println("No hay más elementos hacia adelante.");
                    }
                    break;

                case 2:
                    if (currentElement != navigableSet.first()) {
                        currentElement = navigableSet.lower(currentElement);
                    } else {
                        System.out.println("No hay más elementos hacia atrás.");
                    }
                    break;

                case 3:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        }
    }
    public static Articulo newItem(int id, String nombre, String material, String ocasion,
        String clase, String tipo, String ubicacion) {
        Articulo nuevo = new Articulo();
        try {
            nuevo.crearArticulo(id, nombre, material, ocasion, clase, tipo, ubicacion);
            miRopa.put(id, nuevo);
            size += 1;
            System.out.println("Articulo añadido con exito");
            return nuevo;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Articulo updateItem(int id, String nombre, String material, String ocasion,
        String clase, String tipo, String ubicacion) {
        Articulo actual = findItem(id);
        if (actual != null) {
            try {
                actual.actulizarArticulo(nombre, material, ocasion, clase, tipo, ubicacion);
                System.out.println("Articulo actualizado con exito");
                return actual;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return actual;
    }

    public static Articulo findItem(int id) {
        return miRopa.get(id);
    }

    public static Articulo findItem(String patron) {
        for (Articulo art: miRopa.values()) {
            if (art.getNombre().contains(patron)) {
                return art;
            }
        }
        return null;
    }

    public static Articulo removeItem(int id) {
        return miRopa.remove(id);
    }

    public static void menuRopa(Scanner scanner) {
        int opcionRopa;
        do {
            System.out.println("\n***** SUBMENÚ ROPA *****");
            System.out.println("1. Añadir articulos");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Recorrer 1 a 1");
            System.out.println("5. Mostrar toda la ropa");
            System.out.println("6. Actualizar articulo");
            System.out.println("7. Eliminar articulo");
            System.out.println("8. Eliminar toda la ropa");
            System.out.println("9. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcionRopa = scanner.nextInt();
            scanner.nextLine();

            switch (opcionRopa) {
                case 1:
                    System.out.println("Has seleccionado: Añadir ropa");
                    String[] arr = userInputUtil(scanner);
                    System.out.println(newItem(size, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
                    break;
                case 2:
                    System.out.println("Has seleccionado: Buscar por ID");
                    System.out.print("Ingrese el id que quiere buscar");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(findItem(n));
                    break;
                case 3:
                    System.out.println("Has seleccionado: Buscar por nombre");
                    System.out.print("Ingrese el nombre que quiere buscar");
                    String entry = scanner.nextLine();
                    System.out.println(findItem(entry));
                    break;
                case 4:
                    System.out.println("Has seleccionado: Recorrer");
                    if (miRopa.size() > 0) {
                        recorrerRopa(scanner);
                    } else {
                        System.out.println("No hay ropa agregada");
                    }
                    break;
                case 5:
                    System.out.println("Has seleccionado: Mostrar");
                    if (miRopa.size() > 0) {
                        System.out.println(miRopa);
                    } else {
                        System.out.println("No hay ropa agregada");
                    }
                    break;
                case 6:
                    System.out.println("Has seleccionado: Actualizar");
                    System.out.print("Ingrese el id del articulo que va a modificar");
                    int m = scanner.nextInt();
                    scanner.nextLine();
                    String[] updt = userInputUtil(scanner);
                    System.out.println(updateItem(m, updt[0], updt[1], updt[2], updt[3], updt[4], updt[5]));
                    break;
                case 7:
                    System.out.println("Has seleccionado: Eliminar");
                    System.out.print("Ingrese el id del articulo que va a eliminar");
                    int e = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(removeItem(e));
                    break;
                case 8:
                    System.out.println("Has seleccionado: Eliminar toda la ropa");
                    miRopa.clear();
                    break;
                case 9:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcionRopa != 9);
    }

    public static void menuFavoritos(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\n***** SUBMENÚ FAVORITOS *****");
            System.out.println("1. Buscar favorito");
            System.out.println("2. Añadir favorito");
            System.out.println("3. Eliminar favorito");
            System.out.println("4. Mostrar favoritos");
            System.out.println("5. Limpiar favoritos");
            System.out.println("6. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado: Buscar en Favoritos");
                    System.out.print("Ingrese el id del articulo que quiere buscar");
                    int b = scanner.nextInt();
                    scanner.nextLine();
                    if(favs.getFav(b)==-1){
                        System.out.println("Este articulo no se encuentra en favoritos");
                    }
                    else {
                        System.out.println(findItem(favs.getFav(b)));
                    }

                    break;
                case 2:
                    System.out.println("Has seleccionado: Añadir a Favoritos");
                    System.out.print("Ingrese el id del articulo que quiere añadir");
                    int a = scanner.nextInt();
                    scanner.nextLine();
                    favs.saveFavorite(a);
                    break;
                case 3:
                    System.out.println("Has seleccionado: Eliminar de Favoritos");
                    System.out.print("Ingrese el id del articulo que quiere eliminar");
                    int e = scanner.nextInt();
                    scanner.nextLine();
                    if(favs.deleteFavorite(e)){
                        System.out.println(("Articulo eliminado"));
                    }
                    else{
                        System.out.println("Este articulo no existe");
                    }
                    break;
                case 4:
                    System.out.println("Has seleccionado: Mostrar Favoritos");
                    Integer[] favoritos = favs.getAllFavs();
                    try{
                        for (Integer id: favoritos) {
                            System.out.print(id + ", ");
                        }
                    }catch (NullPointerException np){
                        System.out.println("No se han seleccionado favoritos");
                    }

                    break;
                case 5:
                    System.out.println("Has seleccionado: Limpiar Favoritos");
                    favs.deleteAll();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 6);

    }

    public static void menuConjuntos(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\n***** SUBMENÚ CONJUNTOS *****");
            System.out.println("1. Buscar conjuntos");
            System.out.println("2. Añadir conjuntos");
            System.out.println("3. Eliminar conjuntos");
            System.out.println("4. Limpiar conjuntos");
            System.out.println("5. Mostrar conjuntos");
            System.out.println("6. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado: Buscar en Conjuntos");
                    System.out.print("Ingrese el id del articulo que quiere buscar");
                    int b = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(conj.getObject(b));
                    break;
                case 2:
                    System.out.println("Has seleccionado: Añadir a Conjuntos");
                    System.out.print("Ingrese el id del articulo que quiere añadir");
                    int a = scanner.nextInt();
                    scanner.nextLine();
                    conj.add(findItem(a));
                    break;
                case 3:
                    System.out.println("Has seleccionado: Eliminar de Conjuntos");
                    System.out.print("Ingrese el id del articulo que quiere eliminar");
                    int e = scanner.nextInt();
                    scanner.nextLine();
                    conj.remove(findItem(e));
                    break;
                case 4:
                    System.out.println("Has seleccionado: Limpiar Conjuntos");
                    conj.removeAll();
                    break;
                case 5:
                    System.out.println("Has seleccionado: Mostrar Conjuntos");
                    if (!conj.isEmpty()) {
                        System.out.println(conj);
                    } else {
                        System.out.println("El conjunto no tiene articulos");
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 6);

    }

    public static void menuRecientes(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\n***** SUBMENÚ RECIENTES *****");
            System.out.println("1. Añadir");
            System.out.println("2. Mostrar");
            System.out.println("3. Limpiar");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado: Añadir a Recientes");
                    System.out.print("Ingrese el id del articulo que quiere añadir");
                    int a = scanner.nextInt();
                    scanner.nextLine();
                    rec.addRecent(a);
                    break;
                case 2:
                    System.out.println("Has seleccionado: Mostrar de Recientes");
                    System.out.println(rec);
                    break;
                case 3:
                    System.out.println("Has seleccionado: Limpiar Recientes");
                    rec.clearHistory();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 4);

    }

    public static void menuPruebas(Scanner scanner) {
        int opcion;
        Scanner scannerPruebas = new Scanner(System.in);

        do {
            System.out.println("\n***** SUBMENÚ PRUEBAS *****");
            System.out.println("1. Pruebas ropa");
            System.out.println("2. Pruebas favoritos");
            System.out.println("3. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado: Pruebas ropa");
                    String[] array = {"nuevo", "buscarNombre", "buscarId", "eliminar"};

                    System.out.print("¿Cuántas operaciones desea medir por funcionalidad? ");
                    int casos = scanner.nextInt();
                    for (int i = 4; i <= 8; i++) {
                        System.out.print("\n\nNúmero de datos: ");
                        if (i != 8) {
                            System.out.println(Math.pow(10, i));
                        } else {
                            System.out.println(Math.pow(10, i)/2);
                        }
                        for (String str : array) {
                            if(str!="nuevo") System.out.println("Operación "+str);
                            if (i != 8) {
                                medirTiempo((int)Math.pow(10, i), str, casos);
                            } else {
                                medirTiempo((int)Math.pow(10, i) / 2, str, casos);
                            }
                        }
                        miRopa.clear();
                    }
                    break;
                case 2:
                    System.out.println("Has seleccionado: Pruebas favoritos");
                    String[] array2 = {"nuevo", "buscarId", "eliminar"};

                    System.out.print("Midiendo 100 operaciones por funcionalidad.");

                    for (int i = 4; i <= 5; i++) {
                        System.out.print("\n\nNúmero de datos: ");
                        System.out.println(Math.pow(10, i));

                        for (String str : array2) {
                            System.out.println("Operación "+str);

                            medirTiempoFav((int )Math.pow(10, i), str);
                            }
                        miRopa.clear();

                    }

                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }

        } while (opcion != 3);
                scannerPruebas.close();

}

    public static void main(String[] args) {
        launch();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("***** MENÚ *****");
            System.out.println("1. Ropa");
            System.out.println("2. Favoritos");
            System.out.println("3. Recientes");
            System.out.println("4. Conjuntos");
            System.out.println("5. Mediciones");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuRopa(scanner);
                    break;
                case 2:
                    menuFavoritos(scanner);
                    break;
                case 3:
                    menuRecientes(scanner);
                    break;
                case 4:
                    menuConjuntos(scanner);
                    break;
                case 5:
                    menuPruebas(scanner);
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 6);

        /*
        // Pruebas con muchos datos
        System.out.println("\n\n\n\t\tPRUEBAS");
        System.out.println("\n\t\tTreeMap");
        String[] operaciones = {
            "nuevo",
            "buscarNombre",
            "buscarId",
            "eliminar"
        };
        int casos = 100;

        for (int i = 4; i < 8; i++) {
            System.out.println("\n\n\nInitial size: " + miRopa.size());

            //if (i == 8) { miRopa = generarDatosPrueba((int)(Math.pow(10,i)/2));}
            //else {miRopa = generarDatosPrueba((int)Math.pow(10,i));}

            for (String operacion: operaciones) {
                if (i == 8) {
                    System.out.println("\n" + operacion + ":");

                    medirTiempo((int)(Math.pow(10, i) / 2), operacion, casos);
                } else {
                    System.out.println("\n" + operacion + ": ");

                    medirTiempo((int) Math.pow(10, i), operacion, casos);
                } //  }

            }
            miRopa.clear();
            System.gc();

        }

        System.out.println("\n\t\tFavoritos (Linked List)");
        String[] op = {
            "nuevo",
            "buscarId",
            "eliminar"
        };
        for (int i = 4; i < 8; i++) {
            if (i == 8) System.out.println("Prueba con " + (int)(Math.pow(10, i) / 2));
            else {
                System.out.println("Prueba con " + (int) Math.pow(10, i));

            }
            for (String operacion: op) {
                if (i == 8) {
                    System.out.println("\n" + operacion + ":");

                    medirTiempoFav((int)(Math.pow(10, i) / 2), operacion);
                } else {
                    System.out.println("\n" + operacion + ": ");

                    medirTiempoFav((int) Math.pow(10, i), operacion);
                } //  }

            }
            favs.deleteAll();
            System.gc();

        }
        */
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}