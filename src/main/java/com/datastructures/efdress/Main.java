package com.datastructures.efdress;


import java.util.*;

/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
*/

import java.util.function.Supplier;
import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
// public class Main extends Application {
protected static TreeMap<String, Articulo> miRopa = new TreeMap<>();
    protected static ArrayList<String> itemOpcion= new ArrayList<String>(
            Arrays.asList("material","ocasion","ubicacion"));
    protected static ArrayList<String> pantsOpcion= new ArrayList<String>(
            Arrays.asList("tiro","fit"));
    protected static ArrayList<String> clases= new ArrayList<String>(
            Arrays.asList("Abrigo", "Calzado", "Entero", "Pantalon", "Sombrero", "TopHombre", "TopMujer"));
    protected static HashMap<String, ArrayList<String>> tipos= new HashMap<String, ArrayList<String>>(){{
        put("Abrigo", new ArrayList<String>(
                Arrays.asList("CHAQUETAS","CHALECOS","ABRIGOS","SWEATERS","CORTAVIENTOS","HOODIES","BLAZERS","SACOS","IMPERMEABLES","CARDIGANS")));
        put("Calzado", new ArrayList<String>(
                Arrays.asList("TENIS","MODA","TENISDEPORTIVOS","ZAPATOS","CASUALES","BOTAS","SANDALIAS","MOCASINES","GUAYOS","FORMALES",
                        "BOTINES","ALPARGATAS","ZAPATILLAS","PANTUFLAS","ESCOLAR","OUTDOOR","ZUECOS","TACONES","BALLERINASBALETAS",
                        "BOTASLLUVIA","BOTASAGUA","HAWAIANAS")));
        put("Entero", new ArrayList<String>(
                Arrays.asList("OVEROLES","JARDINERAS","JARDINERAS_SHORT","BANO","LICRAS","TRAJES","VESTIDOS","PIJAMAS")));
        put("Pantalon", new ArrayList<String>(
                Arrays.asList("LEGGINS","JOGGERS","PANTALONES","JEANS","SHORTS","BERMUDAS","DEPORTIVOS","FALDAS")));
        put("Sombrero", new ArrayList<String>(
                Arrays.asList("BOINA","GORRA","SOMBRERO")));

        put("TopHombre", new ArrayList<String>(Arrays.asList("CAMISAS","CAMISETAS","CAMISETAS_DEPORTIVAS","POLOS")));
        put("TopMujer", new ArrayList<String>(Arrays.asList("CAMISETAS","BLUSAS","CROPTOPS","CAMISAS","TOPS","BODYS","CORSET")));


    }};
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

    public static void medirTiempo(LinkedList<Articulo> miRopa) {
        int limite = 1000;
        miRopa = generarDatosPrueba(limite);

        long startTime = System.currentTimeMillis();
        guardarObjeto(miRopa);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms.");
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

    public static int update(HashMap<String, String> atributos, String nombre){



        Articulo actual= miRopa.get(nombre);
        if(actual==null){return -1;}

        if(atributos.containsKey("nombre")){

            miRopa.remove(nombre);
            actual.setNombre(atributos.get("nombre"));
            if(actual instanceof Pantalon){miRopa.put(actual.getNombre(), (Pantalon) actual);}
            if(actual instanceof Abrigo){miRopa.put(actual.getNombre(), (Abrigo) actual);}
            if(actual instanceof Entero){miRopa.put(actual.getNombre(), (Entero) actual);}
            if(actual instanceof Calzado){miRopa.put(actual.getNombre(), (Calzado) actual);}
            if(actual instanceof Sombrero){miRopa.put(actual.getNombre(), (Sombrero) actual);}
            if(actual instanceof TopHombre){miRopa.put(actual.getNombre(), (TopHombre) actual);}
            if(actual instanceof TopMujer){miRopa.put(actual.getNombre(), (TopMujer) actual);}
        }

        if(actual instanceof Pantalon){
                        if(atributos.containsKey("fit")){
                            ((Pantalon) actual).setFit(atributos.get("fit"));
                        } else if (atributos.containsKey("tiro")){
                            ((Pantalon) actual).setTiro(atributos.get("tiro"));
                        }

        }

        for(String at: atributos.keySet()){
            if(at=="tipo"){
                actual.setTipo(atributos.get(at));
            } else if (at=="ocasion"){
                actual.setOcasion(atributos.get(at));
            } else if (at=="material"){
                actual.setMaterial(atributos.get(at));
            } else if (at=="ubicacion"){
                actual.setUbicacion(atributos.get(at));
            } else if (at=="ocasion"){
                actual.setOcasion(atributos.get(at));
            } else if (at=="nombre"){
                actual.setNombre(atributos.get(at));
            }
        }
        if(actual instanceof Pantalon){miRopa.replace(nombre, (Pantalon) actual);}
        if(actual instanceof Abrigo){miRopa.replace(nombre, (Abrigo) actual);}
        if(actual instanceof Entero){miRopa.replace(nombre, (Entero) actual);}
        if(actual instanceof Calzado){miRopa.replace(nombre, (Calzado) actual);}
        if(actual instanceof Sombrero){miRopa.replace(nombre, (Sombrero) actual);}
        if(actual instanceof TopHombre){miRopa.replace(nombre, (TopHombre) actual);}
        if(actual instanceof TopMujer){miRopa.replace(nombre, (TopMujer) actual);}

            for(String at: atributos.keySet()){
                if(at=="fit"){
                    ((Pantalon) actual).setFit(atributos.get(at));
                } else if (at=="Tiro"){
                    ((Pantalon) actual).setTiro(atributos.get(at));
                }
            }

        return 0;
    }


    public static int newItem(HashMap<String, String> atributos){

        if(!atributos.containsKey("clase") || !clases.contains(atributos.get("clase")) || !atributos.containsKey("nombre") || !atributos.containsKey("tipo")){
            return -1;
        }

        for(String at: itemOpcion) {
            if (!atributos.containsKey(at)) {
                atributos.put(at, "");
            }
        }
        if(atributos.get("clase")=="Abrigo"){
            if(!tipos.get("Abrigo").contains(atributos.get("tipo"))){return -1;}
            Abrigo nuevoArt= new Abrigo(miRopa.size(), atributos.get("nombre"), atributos.get("material"),atributos.get("ocasion"),atributos.get("tipo"),atributos.get("ubicacion"));
            miRopa.put(atributos.get("nombre"),nuevoArt);
        }

        if(atributos.get("clase")=="Calzado"){
            if(!tipos.get("Calzado").contains(atributos.get("tipo"))){return -1;}
            Calzado nuevoArt= new Calzado(miRopa.size(), atributos.get("nombre"), atributos.get("material"),atributos.get("ocasion"),atributos.get("tipo"),atributos.get("ubicacion"));
            miRopa.put(atributos.get("nombre"),nuevoArt);
        }

        if(atributos.get("clase")=="Entero"){
            if(!tipos.get("Entero").contains(atributos.get("tipo"))){return -1;}
            Entero nuevoArt= new Entero(miRopa.size(), atributos.get("nombre"), atributos.get("material"),atributos.get("ocasion"),atributos.get("tipo"),atributos.get("ubicacion"));
            miRopa.put(atributos.get("nombre"),nuevoArt);
        }
        if(atributos.get("clase")=="Pantalon"){
            for(String at: pantsOpcion) {
                if (!atributos.containsKey(at)) {
                    atributos.put(at, "");
                }
            }
            if(!tipos.get("Pantalon").contains(atributos.get("tipo"))){return -1;}
            Pantalon nuevoArt= new Pantalon(miRopa.size(), atributos.get("nombre"), atributos.get("material"),atributos.get("ocasion"),atributos.get("tipo"),atributos.get("ubicacion"),atributos.get("tiro"),atributos.get("fit"));
            miRopa.put(atributos.get("nombre"),nuevoArt);
        }
        if(atributos.get("clase")=="Sombrero"){
            if(!tipos.get("Sombrero").contains(atributos.get("tipo"))){return -1;}
            Sombrero nuevoArt= new Sombrero(miRopa.size(), atributos.get("nombre"), atributos.get("material"),atributos.get("ocasion"),atributos.get("tipo"),atributos.get("ubicacion"));
            miRopa.put(atributos.get("nombre"),nuevoArt);
        }
        if(atributos.get("clase")=="TopHombre"){
            if(!tipos.get("TopHombre").contains(atributos.get("tipo"))){return -1;}
            TopHombre nuevoArt= new TopHombre(miRopa.size(), atributos.get("nombre"), atributos.get("material"),atributos.get("ocasion"),atributos.get("tipo"),atributos.get("ubicacion"));
            miRopa.put(atributos.get("nombre"),nuevoArt);
        }
        if(atributos.get("clase")=="TopMujer"){
            if(!tipos.get("TopMujer").contains(atributos.get("tipo"))){return -1;}
            TopMujer nuevoArt= new TopMujer(miRopa.size(), atributos.get("nombre"), atributos.get("material"),atributos.get("ocasion"),atributos.get("tipo"),atributos.get("ubicacion"));
            miRopa.put(atributos.get("nombre"),nuevoArt);
        }


return 0;



    }
    public static void main(String[] args) {

HashMap<String, String> atrpr= new HashMap<>(){{put("clase","Abrigo");put("tipo","CHAQUETAS");put("nombre","Abrigo lindo"); put("material","sintetico");put("ocasion","casual");put("ubicacion","lol");}};
HashMap<String, String> atrpr2= new HashMap<>(){{put("clase","Calzado");put("tipo","BOTAS");put("nombre","Botas rockeras"); put("material","Cuero");put("ocasion","casual");put("ubicacion","lol");}};
        HashMap<String, String> atrpr3= new HashMap<>(){{put("tipo","CHALECOS"); put("material","Algodon");put("ocasion","formal");put("ubicacion","lol");}};

       newItem(atrpr);
        newItem(atrpr2);

        String pruebaAbrigo= miRopa.lastKey();
        System.out.println(miRopa.get(pruebaAbrigo).nombre);
        System.out.println(miRopa.get(pruebaAbrigo).tipo);
        System.out.println(miRopa.get(pruebaAbrigo).ubicacion);
        System.out.println(miRopa.get(pruebaAbrigo).material);
        System.out.println(miRopa.get(pruebaAbrigo).id);


        System.out.println(miRopa.get("Abrigo lindo").nombre);
        System.out.println(miRopa.get("Abrigo lindo").tipo);
        System.out.println(miRopa.get("Abrigo lindo").ubicacion);
        System.out.println(miRopa.get("Abrigo lindo").material);
        System.out.println(miRopa.get("Abrigo lindo").id);
update(atrpr3,"Abrigo lindo");


        System.out.println(miRopa.get("Abrigo lindo").nombre);
        System.out.println(miRopa.get("Abrigo lindo").tipo);
        System.out.println(miRopa.get("Abrigo lindo").ubicacion);
        System.out.println(miRopa.get("Abrigo lindo").material);
        System.out.println(miRopa.get("Abrigo lindo").id);


    }
}
