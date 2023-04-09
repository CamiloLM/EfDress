package com.datastructures.efdress;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author calon
 */
public class Inferior extends Articulo {
    private int talla;
    private String estampado;
    
    public Inferior(String nombre, String material, HashMap<String, Color> paletaColores,
            String[] ocasion, String tipo, String ubicacion) {
        super(nombre, material, paletaColores, ocasion, tipo, ubicacion);
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getEstampado() {
        return estampado;
    }

    public void setEstampado(String estampado) {
        this.estampado = estampado;
    }
    
}
