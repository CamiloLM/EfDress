/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datastructures.efdress;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author calon
 */
public class Sombrero extends Articulo {
    private String estampado;
    private double talla;
    
    public Sombrero(String nombre, String material, HashMap<String, Color> paletaColores,
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
    
}
