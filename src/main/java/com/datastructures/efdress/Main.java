package com.datastructures.efdress;

import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// import javafx.scene.layout.StackPane;


import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
// public class Main extends Application {

    public static Articulo addItem(){
        Scanner scanner = new Scanner(System.in);
        Articulo obj;
        System.out.println("\nQue tipo de articulo quiere añadir: ");
        System.out.println("1. Parte superior");
        System.out.println("2. Cuerpo entero");
        System.out.println("3. Parte inferior");
        System.out.println("4. Sombreros");
        System.out.println("5. Calzado\n");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Superior seleccionado");
                obj = new Superior();
                break;
            case 2:
                System.out.println("Entero seleccionado");
                obj = new Entero();
                break;
            case 3:
                System.out.println("Inferior seleccionado");
                obj = new Inferior();
                break;
            case 4:
                System.out.println("Sombrero seleccionado");
                obj = new Sombrero();
                break;
            case 5:
                System.out.println("Calzado seleccionado");
                obj = new Calzado();
                break;
            default:
                System.out.println("La opcion no en lista.");
                obj = null;
                break;
        }
        return obj;
    }

    public static Articulo getItem(int id, LinkedList<Articulo> miRopa) {
        for (Articulo e : miRopa) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public static LinkedList<Articulo> removeItem(Articulo e, LinkedList<Articulo> miRopa) {
        if (miRopa.remove(e)) {
            System.out.println("Objeto eliminado con exito");
        } else {
            System.out.println("No se encuentra el documento.");
        }
        return miRopa;
    }

    public static void updateItem(Articulo e, LinkedList<Articulo> miRopa) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(e);
        System.out.println("Ingrese los datos que quiere actualizar en el siguiente orden separados por comas:");
        System.out.println("Nombre, material, ocasion, tipo, ubicacion. ");
        String entry = scanner.nextLine();
        String[] line = entry.split(",");

        e.setNombre(line[0]);
        e.setMaterial(line[1]);
        e.setOcasion(line[2]);
        e.setTipo(line[3]);
        e.setUbicacion(line[4]);
    }

    public static void guardarObjeto(LinkedList<Articulo> ropa) {
        try {
            try (var writeFile = new ObjectOutputStream(new FileOutputStream(".\\src\\main\\java\\com\\datastructures\\efdress\\datos.dat"))) {
                writeFile.writeObject(ropa);
                System.out.println("Objeto guardado con exito.");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static LinkedList<Articulo> cargarObjeto() {
        try {
            try (var readFile = new ObjectInputStream(new FileInputStream(".\\src\\main\\java\\com\\datastructures\\efdress\\datos.dat"))) {
                LinkedList<Articulo> ropa = (LinkedList)readFile.readObject();
                return ropa;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }

    public static LinkedList<Articulo> generarDatosPrueba (int numeroCasos) {
        Superior obj;
        LinkedList<Articulo> ropa = new LinkedList<>();
        String[] materiales = {"Algodon", "Poliester", "Lino", "Lana", "Seda", "Nylon", "Lycra", "Jean"};
        String[] ocaciones = {"diario", "formal", "deportiva", "dormir", "fiesta", "playa", "calor", "frio"};
        String[] tipos = {"Blusas", "Chaquetas", "Camiseta", "Top", "Jersey", "Sueter", "Esqueletos", "Camisas", "Sudaderas", "Polos", "Chalecos"};
        Random rand = new Random();
        int limite = numeroCasos;
        int i = 1;
        System.out.println("Generando datos de prueba...");
        while (i <= limite) {
            obj = new Superior(
                    i,
                    "Articulo Numero: " + Integer.toString(i),
                    materiales[rand.nextInt(materiales.length)],
                    ocaciones[rand.nextInt(ocaciones.length)],
                    tipos[rand.nextInt(tipos.length)],
                    "url"
            );
            ropa.addLast(obj);
            i++;
        }
        return ropa;
    }


    /*
        @Override
        public void start(Stage stage) throws IOException {
            // Scene new item (type)
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root,1280,720);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

            grid2.add(new Label("What kind of item is it?"), 0, 0);
            grid2.add(addItemC2, 1, 0);
            grid2.add(prevSceneB, 1, 1);
            Group root2 = (Group)newItScene2.getRoot();
            root2.getChildren().add(grid2);


            // Scene new Item (Body part)

            final ComboBox addItemC1 = new ComboBox();
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
                switch (selectedIndex1){
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

            Scene newItScene1= new Scene(new Group(), 500, 400);

            EventHandler<ActionEvent> gobackEvent = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
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
            Group root1 = (Group)newItScene1.getRoot();
            root1.getChildren().add(grid1);

            //Main Scene
            //Label label2= new Label("This is the second scene");
            Button addItemb= new Button("Add Item");
            addItemb.setOnAction(e -> stage.setScene(newItScene1));
            VBox layout2= new VBox(20);
            layout2.getChildren().addAll(addItemb);
            Scene mainScene= new Scene(layout2,500,400);


        }
    */
    public static void main(String[] args) {
        LinkedList<Articulo> miRopa = new LinkedList<>();
        // launch(args);

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("\nQue desea hacer: ");
            System.out.println("1. Agregar un articulo");
            System.out.println("2. Mostrar mi ropa");
            System.out.println("3. Eliminar un articulo");
            System.out.println("4. Actualizar un articulo");
            System.out.println("5. Guardar ropa en memoria");
            System.out.println("6. Cargar ropa desde memoria");
            System.out.println("7. Generar datos de prueba");
            System.out.println("0. Salir\n");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    Articulo art = addItem();
                    if (art != null) {
                        miRopa.addLast(art);
                        System.out.println("Objeto añadido con exito.");
                    }
                    break;
                case 2:
                    if (miRopa.size() == 0) System.out.println("No hay ropa añadida");
                    else {
                        for (Articulo e : miRopa) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el id del articulo que quiere eliminar");
                    int eliminateId = scanner.nextInt();
                    Articulo eliminateArt = getItem(eliminateId, miRopa);
                    miRopa = removeItem(eliminateArt, miRopa);
                    break;
                case 4:
                    System.out.println("Ingrese el id del articulo que quiere actualizar");
                    int updateId = scanner.nextInt();
                    Articulo updateArt = getItem(updateId, miRopa);
                    updateItem(updateArt, miRopa);
                    break;
                case 5:
                    guardarObjeto(miRopa);
                    System.out.println("La ropa se ha guardado en el archivo datos.dat");
                    break;
                case 6:
                    miRopa = cargarObjeto();
                    if (miRopa == null) System.out.println("No se han podido cargar los datos del archivo.");
                    else System.out.println("Los datos se han cargado con exito.");
                    break;
                case 7:
                    System.out.println("Se van a generar articulos de la parte superior de forma semi-aleatoria");
                    System.out.println("Ingrese la cantidad de datos que quiere generar:");
                    int limite = scanner.nextInt();
                    miRopa = generarDatosPrueba(100);
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Intentelo nuevamente");
                    break;
            }
        }
        scanner.close();
    }
}
