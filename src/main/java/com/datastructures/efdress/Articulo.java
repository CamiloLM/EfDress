package com.datastructures.efdress;

import java.awt.Color;
import java.util.HashMap;

/**
 * Clase basica de un articulo de ropa
 * nombre: Nombre personalizado del articulo, si no se da una se tiene que crear automaticamente
 * paletaColores: Paleta de colores que tiene cada articulo
 * material: Material del que esta hecho
 * ocasion: Para que ocasion se usa el articulo, por ejemplo formal, deportiva, etc
 * tipo: La subclase que diferencia al articulo de los demas, por ejemplo camisa, chaqueta, etc
 * ubicacion: La dirrecion al archivo que contiene la imagen del articulo
 * @author Camilo Londoño Moreno
 */
abstract public class Articulo {
    private String nombre;
    private String material;
    private HashMap<String, Color> paletaColores;
    private String[] ocasion;
    private String tipo;
    private String ubicacion;

    // Constructor si se dan todos los parametros
    public Articulo(String nombre, String material, HashMap<String, Color> paletaColores,
            String[] ocasion, String tipo, String ubicacion) {
        this.nombre = nombre;
        this.material = material;
        this.paletaColores = paletaColores;
        this.ocasion = ocasion;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }
    
    // Constructor si no se especifica el nombre del articulo
    public Articulo(String material, HashMap<String, Color> paletaColores,
            String[] ocasion, String tipo, String ubicacion) {
        // Se construye un nombre a partir del tipo y los colores
        if (!tipo.isEmpty() && !paletaColores.isEmpty()){
            this.nombre = tipo + paletaColores.keySet().toString();
        } else {
            this.nombre = "Articulo sin nombrar";
        }
        this.material = material;
        this.paletaColores = paletaColores;
        this.ocasion = ocasion;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Color> getPaletaColores() {
        return paletaColores;
    }

    public void setPaletaColores(HashMap<String, Color> paletaColores) {
        this.paletaColores = paletaColores;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String[] getOcasion() {
        return ocasion;
    }

    public void setOcasion(String[] ocasion) {
        /**
         * Posibles categorias de ocaciones:
         * De diario, Formal, Deportiva, Dormir, Fiesta
         * Traje de baño, Verano/Calor, Invierno/Frio
        */
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
    
}
