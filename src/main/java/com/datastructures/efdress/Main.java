package com.datastructures.efdress;

import static com.datastructures.efdress.Articulo.obtenerTipos;
import com.datastructures.efdress.enums.Clase;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {

    protected static AVLTree miRopa = new AVLTree();
    protected static Favorito favs = Favorito.getInstance();

//    public static void guardarObjeto(LinkedList<Articulo> ropa) {
//        try {
//            try (var writeFile = new ObjectOutputStream(new FileOutputStream(".\\src\\main\\java\\com\\datastructures\\efdress\\datos.dat"))) {
//                writeFile.writeObject(ropa);
//                System.out.println("Objeto guardado con exito.");
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }
//
//    public static LinkedList<Articulo> cargarObjeto() {
//        try {
//            try (var readFile = new ObjectInputStream(new FileInputStream(".\\src\\main\\java\\com\\datastructures\\efdress\\datos.dat"))) {
//                LinkedList<Articulo> ropa = (LinkedList) readFile.readObject();
//                return ropa;
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(e);
//            return null;
//        }
//    }
    public static void medirTiempo(int n) {
        // Aqui creen los parametros que necesitan para llamar a la funcion
        miRopa = Articulo.generarDatosPrueba(n);
        Random random = new Random();
        int randomNumber = random.nextInt(n + 1);

        long startTime = System.currentTimeMillis();
        // Aqui solo hacen la llamada a la funcion
        System.out.println(findItem(randomNumber));
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime + "ms.");
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
        Enum<?>[] tipos = obtenerTipos(values[3]);
        if (tipos != null) {
            System.out.println("De las siguientes opciones " + Arrays.toString(tipos));
            System.out.print("Tipo: ");
            values[4] = scanner.nextLine();
        }
        System.out.print("Ubicación: ");
        values[5] = scanner.nextLine();
        return values;
    }

    public static void newItem(int id, String nombre, String material, String ocasion,
            String clase, String tipo, String ubicacion) {
        Articulo nuevo = new Articulo();
        try {
            nuevo.crearArticulo(id, nombre, material, ocasion, clase, tipo, ubicacion);
            miRopa.insert(nuevo);
            System.out.println("Articulo añadido con exito");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showValues() {
        System.out.println(miRopa);
    }

    public static void updateItem(int id, String nombre, String material, String ocasion,
            String clase, String tipo, String ubicacion) {
        Articulo actual = findItem(id);
        if (actual != null) {
            try {
                actual.actulizarArticulo(nombre, material, ocasion, clase, tipo, ubicacion);
                System.out.println("Articulo actualizado con exito");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Articulo findItem(int id) {
        return miRopa.search(id);
    }

    public static ArrayList findItem(String patron) {
        return miRopa.search(patron);
    }

    public static void removeItem(int id) {
        miRopa.delete(id);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCreando un nuevo objeto por consola");
        String[] arr = userInputUtil(scanner);
        newItem(miRopa.index(), arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);

        System.out.println("\nAgregando más objetos por codigo");
        newItem(miRopa.index(), "Abrigo lindo", "Lana", "Casual", "Abrigo", "Chaquetas", "");
        newItem(miRopa.index(), "Botas rockeras", "Cuero", "Casual", "Calzado", "Botas", "");
        newItem(miRopa.index(), "Pantalonzote", "Seda", "Formal", "Pantalon", "Pantalones", "");
        System.out.println(findItem(1));

        System.out.println("\nMirar toda la ropa");
        showValues();

        System.out.println("\nBuscar por nombre");
        System.out.println(findItem("lindo"));

        System.out.println("\nBuscar por ID");
        System.out.println(findItem(1));

        System.out.println("\nAcutalizar objeto");
        updateItem(1, "Sombrero Fachero", "Poliester", "Fiesta", "Sombrero", "Sombrero", "");
        System.out.println(findItem(1));

        System.out.println("\nEliminar objeto");
        removeItem(2);

        System.out.println("\nMirar toda la ropa");
        showValues();

        System.out.println("\nMidiendo un caso de prueba");
        medirTiempo(1000);
        
        miRopa = Articulo.generarDatosPrueba(8);

        //Probando los favoritos
        favs.saveFavorite(miRopa.search(1).getId());
        favs.saveFavorite(miRopa.search(2).getId());
        favs.saveFavorite(miRopa.search(3).getId());
        favs.saveFavorite(miRopa.search(4).getId());
        favs.saveFavorite(miRopa.search(5).getId());
        favs.saveFavorite(miRopa.search(6).getId());
        favs.saveFavorite(miRopa.search(7).getId());
        favs.saveFavorite(miRopa.search(8).getId());

        //Obteniendo favorito por id
        System.out.println(findItem(favs.getFav(1)));
        System.out.println(findItem(favs.getFav(2)));

        //Este item no existe
        System.out.println(findItem(favs.getFav(9)));

        //Obteniendo todos los favoritos
        Integer[] favoritos = favs.getAllFavs();
        for (Integer id : favoritos) {
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

    }
}