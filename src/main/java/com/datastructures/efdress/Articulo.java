package com.datastructures.efdress;

import com.datastructures.efdress.enums.*;
import java.util.Random;
import java.util.TreeMap;

public class Articulo implements Comparable<Articulo> {

    private int id;
    private String nombre;
    private String material;
    private String ocasion;
    private String clase;
    private String tipo;
    private String ubicacion;

    public Articulo() {

    }

    protected Articulo(int id, String nombre, String material,
            String ocasion, String clase, String tipo, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.material = material;
        this.ocasion = ocasion;
        this.clase = clase;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }
    
    @Override
    public int compareTo(Articulo otro) {
        return Integer.compare(this.id, otro.id);
    }

    public void crearArticulo(int id, String nombre, String material,
            String ocasion, String clase, String tipo, String ubicacion) {
        try {
            this.setId(id);
            this.setNombre(nombre);
            this.setMaterial(material);
            this.setOcasion(ocasion);
            this.setClase(clase);
            this.setTipo(tipo);
            this.setUbicacion(ubicacion);
        } catch (Exception e) {
            System.out.println("\nHubo un error con los datos suministrados");
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("No se pudo crear el objeto");
        }
    }

    public void actulizarArticulo(String nombre, String material,
            String ocasion, String clase, String tipo, String ubicacion) {
        try {
            this.setNombre(nombre);
            this.setMaterial(material);
            this.setOcasion(ocasion);
            this.setClase(clase);
            this.setTipo(tipo);
            this.setUbicacion(ubicacion);
        } catch (Exception e) {
            System.out.println("\nHubo un error con los datos suministrados");
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("No se pudo actualizar el objeto");
        }
    }

    public static TreeMap<Integer, Articulo> generarDatosPrueba(int numeroCasos) {
        TreeMap<Integer, Articulo> ropaPrueba = new TreeMap<>();
        long startTime, endTime,time;
        Articulo prueba;
        Material[] materiales = Material.values();
        Ocasion[] ocasiones = Ocasion.values();
        Clase[] clases = Clase.values();
        Enum<?>[] tipos;
        Random random = new Random();
        int i = 1;
        System.out.println("\n\nGenerando "+ numeroCasos+" datos de prueba...");
        startTime=System.currentTimeMillis();
        while (i <= numeroCasos) {
            Material ranMaterial = materiales[random.nextInt(materiales.length)];
            Ocasion ranOcasion = ocasiones[random.nextInt(ocasiones.length)];
            Clase ranClase = clases[random.nextInt(clases.length)];
            tipos = obtenerTipos(ranClase.name());
            Enum<?> ranTipo = tipos[random.nextInt(tipos.length)];
            prueba = new Articulo(
                    i,
                    ranTipo.name() + " de " + ranMaterial.name(),
                    ranMaterial.name(),
                    ranOcasion.name(),
                    ranClase.name(),
                    ranTipo.name(),
                    "Valid URL"
            );
            ropaPrueba.put(prueba.getId(),prueba);
            i++;
        }
        endTime=System.currentTimeMillis();
        time=endTime-startTime;
        System.out.println("Total tiempo (ms): "+time);
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
        String pattern = "^[\\p{L}\\p{N}\\sáéíóúÁÉÍÓÚ]*$";
        if (nombre.matches(pattern)) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre contiene caracteres invalidos");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if ("".equals(material)) {
            this.material = material;
            return;
        }
        for (Material e : Material.values()) {
            if (e.name().equals(material)) {
                this.material = material;
                return;
            }
        }
        throw new IllegalArgumentException("El material no esta disponible");
    }

    public String getOcasion() {
        return ocasion;
    }

    public void setOcasion(String ocasion) {
        if ("".equals(material)) {
            this.material = material;
            return;
        }
        for (Ocasion e : Ocasion.values()) {
            if (e.name().equals(ocasion)) {
                this.ocasion = ocasion;
                return;
            }
        }
        throw new IllegalArgumentException("La ocasion no esta disponible");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (this.clase != null) {
            Enum<?>[] tipos = obtenerTipos(this.clase);
            for (Enum<?> e : tipos) {
                if (e.name().equals(tipo)) {
                    this.tipo = tipo;
                    return;
                }
            }
            throw new IllegalArgumentException("El tipo no esta disponible");
        }
        throw new IllegalStateException("No se ha asignado una clase previamente");
        
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

    public void setClase(String clase) throws IllegalArgumentException {
        for (Clase e : Clase.values()) {
            if (e.name().equals(clase)) {
                this.clase = clase;
                return;
            }
        }
        throw new IllegalArgumentException("La clase no esta disponible");
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
