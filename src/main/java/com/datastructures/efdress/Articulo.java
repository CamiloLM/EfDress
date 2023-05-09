package com.datastructures.efdress;

import com.datastructures.efdress.enums.*;
import java.util.Random;
import java.util.TreeMap;

public class Articulo {

    private int id;
    private String nombre;
    private String material;
    private String ocasion;
    private String clase;
    private String tipo;
    private String ubicacion;

    public Articulo() {

    }

    private Articulo(int id, String nombre, String material,
            String ocasion, String clase, String tipo, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.material = material;
        this.ocasion = ocasion;
        this.clase = clase;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    public void crearArticulo(int id, String nombre, String material,
            String ocasion, String clase, String tipo, String ubicacion) {
        try {
            this.setId(id);
            this.setNombre(nombre);
            this.setMaterial(nombre);
            this.setOcasion(ocasion);
            this.setClase(clase);
            this.setTipo(tipo);
            this.setUbicacion(ubicacion);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    public void actulizarArticulo(String nombre, String material,
            String ocasion, String clase, String tipo, String ubicacion) {
        try {
            this.setNombre(nombre);
            this.setMaterial(nombre);
            this.setOcasion(ocasion);
            this.setClase(clase);
            this.setTipo(tipo);
            this.setUbicacion(ubicacion);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    public static TreeMap<Integer, Articulo> generarDatosPrueba(int numeroCasos) {
        TreeMap<Integer, Articulo> ropaPrueba = new TreeMap<>();
        Articulo prueba;
        Material[] materiales = Material.values();
        Ocacion[] ocaciones = Ocacion.values();
        Clase[] clases = Clase.values();
        Enum<?>[] tipos;
        Random random = new Random();
        int i = 1;
        System.out.println("Generando datos de prueba...");
        while (i <= numeroCasos) {
            Material ranMaterial = materiales[random.nextInt(materiales.length)];
            Ocacion ranOcacion = ocaciones[random.nextInt(ocaciones.length)];
            Clase ranClase = clases[random.nextInt(clases.length)];
            tipos = obtenerTipos(ranClase.name());
            Enum<?> ranTipo = tipos[random.nextInt(tipos.length)];
            prueba = new Articulo(
                    i,
                    ranTipo.name() + " de " + ranMaterial.name(),
                    ranMaterial.name(),
                    ranOcacion.name(),
                    ranClase.name(),
                    ranTipo.name(),
                    "Valid URL"
            );
            ropaPrueba.put(i, prueba);
            i++;
        }
        return ropaPrueba;
    }

    public static Enum<?>[] obtenerTipos(String className) {
        switch (className) {
            case "Abrigo":
                return Abrigo.values();
            case "Calzado":
                return Calzado.values();
            case "Entero":
                return Entero.values();
            case "Pantalon":
                return Pantalon.values();
            case "Sombrero":
                return Sombrero.values();
            case "TopHombre":
                return TopHombre.values();
            case "TopMujer":
                return TopMujer.values();
            default:
                return null;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOcasion() {
        return ocasion;
    }

    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("ID: ").append(getId());
        sb.append(", Nombre: ").append(getNombre());
        sb.append(", Material: ").append(getMaterial());
        sb.append(", Ocasion: ").append(getOcasion());
        sb.append(", Clase: ").append(getClase());
        sb.append(", Tipo: ").append(getTipo());
        sb.append(", Ubicación: ").append(getUbicacion());
        sb.append("}");
        return sb.toString();
    }

}
