package com.datastructures.efdress;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author calon
 */
public class Entero extends Articulo {

    private ClasEntero ce;

    public Entero(String claseEntero){
        this.ce=ClasEntero.valueOf(claseEntero.toUpperCase());
    }

    public Entero(int id, String nombre, String material, String ocasion, String tipo, String ubicacion) {
        super(id, nombre, material, ocasion, tipo, ubicacion);
    }

    public Entero() {
        super();
    }

}
