package com.datastructures.efdress;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author calon
 */
public class Entero extends Articulo {
    private String estampado;
    private double talla;
    private String marca;

    public Entero(String nombre, String material, HashMap<String, Color> paletaColores,
            String[] ocasion, String tipo, String ubicacion) {
        super(nombre, material, paletaColores, ocasion, tipo, ubicacion);
    }

    public String getEstampado() {
        return estampado;
    }

    public void setEstampado(String estampado) {
        this.estampado = estampado;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
