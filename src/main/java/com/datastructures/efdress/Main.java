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
        int casos=1;
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


    public static void main(String[] args) {
        launch();
        Scanner scanner = new Scanner(System.in);

        /*
        System.out.println("\nCreando un nuevo objeto por consola");
        String[] arr = userInputUtil(scanner);
        System.out.println(newItem(size, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
         */

        System.out.println("\nAgregando más objetos por codigo");
        newItem(size, "Abrigo lindo", "Lana", "Casual", "Abrigo", "Chaquetas", "");
        newItem(size, "Botas rockeras", "Cuero", "Casual", "Calzado", "Botas", "");
        newItem(size, "Pantalonzote", "Seda", "Formal", "Pantalon", "Pantalones", "");

        System.out.println("\nMirar toda la ropa");
        System.out.println(miRopa);

        System.out.println("\nRecorrer la ropa elemento por elemento");
        //recorrerRopa(scanner);

        System.out.println("\nBuscar por nombre");
        System.out.println(findItem("lindo"));

        System.out.println("\nBuscar por ID");
        System.out.println(findItem(1));

        System.out.println("\nAcutalizar objeto");
        System.out.println(updateItem(1, "Sombrero Fachero", "Poliester", "Fiesta", "Sombrero", "Sombrero", ""));

        System.out.println("\nEliminar objeto");
        System.out.println(removeItem(2));

        System.out.println("\nMirar toda la ropa");
        System.out.println(miRopa);
        
        // Favoritos
        favs.saveFavorite(miRopa.get(0).getId());
        favs.saveFavorite(miRopa.get(1).getId());
        
        //Obteniendo favorito por id
        System.out.println(findItem(favs.getFav(0)));
        System.out.println(findItem(favs.getFav(1)));

        //Este item no existe
        System.out.println(findItem(favs.getFav(9)));

        //Obteniendo todos los favoritos
        Integer[] favoritos = favs.getAllFavs();
        for (Integer id: favoritos) {
            System.out.print(id + ", ");
        }
        //Eliminando favorito
        System.out.println();
        favs.deleteFavorite(1);
        favs.deleteFavorite(2);
        System.out.println(favs);
        //Eliminando todos los favoritos
        favs.deleteAll();
        System.out.println(favs);
        
        
        // Conjunto de ropa
        miRopa.clear();
        newItem(0, "Cacucha", "Poliester", "Casual", "Sombrero", "Gorra", "");
        newItem(1, "Abrigo lindo", "Lana", "Casual", "Abrigo", "Chaquetas", "");
        newItem(2, "Camisa comoda", "Lana", "Diario", "TopHombre", "Camisetas", "");
        newItem(3, "Botas rockeras", "Cuero", "Casual", "Calzado", "Botas", "");
        newItem(4, "Pantalonzote", "Seda", "Formal", "Pantalon", "Pantalones", "");
        newItem(5, "Pijama Pikachu", "Algodon", "Dormir", "Entero", "Pijamas", "");


        System.out.println("\nAñadiendo por articulo");
        conj.add(findItem(0));
        conj.add(findItem(1));
        conj.add(findItem(2));
        
        System.out.println("\nAñadiendo por indice");
        conj.add(5,3);
        conj.add(4,4);
        conj.add(3,5);
        
        System.out.println(conj);
        
        System.out.println("\nEliminando por articulo");
        conj.remove(findItem(1));
        
        System.out.println("\nEliminando por articulo");
        conj.remove(3);
        
        System.out.println(conj);
        
        System.out.println(conj.isEmpty());
        conj.removeAll();
        System.out.println(conj.isEmpty());

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
        // Scene new item (type)
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // Scene new Item (Body part)
       /* final ComboBox addItemC1 = new ComboBox();
        addItemC1.getItems().addAll(
                "Upper Body (Tops, coats/jackets, etc.)",
                "Lower Body (Trousers, skirts, etc.)",
                "Upper & lower body (dress, jumpsuit, etc.)",
                "Footwear",
                "Headwear",
                "Accesory"
        );
        addItemC1.setOnAction((event) -> {
            addItemC2.getItems().clear();
            int selectedIndex1 = addItemC1.getSelectionModel().getSelectedIndex();
            Object selectedItem = addItemC1.getSelectionModel().getSelectedItem();
            System.out.println("Selection made: [" + selectedIndex1 + "] " + selectedItem);
            System.out.println("   ComboBox.getValue(): " + addItemC1.getValue());
            switch (selectedIndex1) {
                case 0:
                    addItemC2.getItems().addAll(
                            "Coat",
                            "Jacket",
                            "Vest",
                            "Shirt",
                            "T-shirt",
                            "Other type of top"
                    );
                    break;

                case 1:
                    addItemC2.getItems().addAll(
                            "Trouser",
                            "Skirt",
                            "Short",
                            "Jeans",
                            "Other type of pants"
                    );
                    break;

                case 2:
                    addItemC2.getItems().addAll(
                            "Dress",
                            "Overall",
                            "Swimsuit",
                            "Jumpsuit"
                    );
                    break;

                case 3:
                    addItemC2.getItems().addAll(
                            "Boots",
                            "Sneakers",
                            "Sandals",
                            "Other dress Shoes"
                    );
                    break;
                case 4:
                    addItemC2.getItems().addAll(
                            "Caps",
                            "Beanies",
                            "Other hats"
                    );
                    break;
            }

            stage.setScene(newItScene2);
        });

        Scene newItScene1 = new Scene(new Group(), 500, 400);

        EventHandler<ActionEvent> gobackEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addItemC2.getItems().clear();
                stage.setScene(newItScene2);

            }
        };

        // when button is pressed
        prevSceneB.setOnAction(gobackEvent);
        prevSceneB.setOnAction(e -> stage.setScene(newItScene1));
        GridPane grid1 = new GridPane();
        grid1.setVgap(4);
        grid1.setHgap(10);
        grid1.setPadding(new Insets(5, 5, 5, 5));
        grid1.add(new Label("What kind of item is it?"), 0, 0);
        grid1.add(addItemC1, 1, 0);
        Group root1 = (Group) newItScene1.getRoot();
        root1.getChildren().add(grid1);

        //Main Scene
        //Label label2= new Label("This is the second scene");
        Button addItemb = new Button("Add Item");
        addItemb.setOnAction(e -> stage.setScene(newItScene1));
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(addItemb);
        Scene mainScene = new Scene(layout2, 500, 400);
*/
    }
}