package com.datastructures.efdress;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Clase basica de un articulo de ropa
 * id: Identiicador unico del objeto
 * nombre: Nombre personalizado del articulo
 * material: Material del que esta hecho
 * ocasion: Para que ocasion se usa el articulo, por ejemplo formal, deportiva, etc
 * tipo: La subclase que diferencia al articulo de los demas, por ejemplo camisa, chaqueta, etc
 * ubicacion: La dirrecion al archivo que contiene la imagen del articulo
 * @author Camilo Londoño Moreno
 */
abstract public class Articulo implements Serializable {
    protected int id;
    protected String nombre;
    protected String material;
    protected String ocasion;
    protected String tipo;
    protected String ubicacion;

    //?
    protected char genero;
    protected String marca;
    protected String talla;

    // Constructor si se dan todos los parametros
    public Articulo(int id, String nombre, String material, String ocasion, String tipo, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.material = material;
        this.ocasion = ocasion;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    public Articulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos que se piden acontinuacion separados por comas:");
        System.out.println("Id, nombre, material, ocasion, tipo, ubicacion. ");
        String entry = scanner.nextLine();
        String[] line = entry.split(",");

        this.setId(Integer.parseInt(line[0]));
        this.setNombre(line[1]);
        this.setMaterial(line[2]);
        this.setOcasion(line[3]);
        this.setTipo(line[4]);
        this.setUbicacion(line[5]);
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero){
        this.genero=genero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getTalla() {
        return talla;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(getId())
                .append(", Nombre: ").append(getNombre())
                .append(", Material: ").append(getMaterial())
                .append(", Ocasion: ").append(getOcasion())
                .append(", Tipo: ").append(getTipo())
                .append(", Ubicación: ").append(getUbicacion());
        return sb.toString();
    }

}
