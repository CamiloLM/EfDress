package com.datastructures.efdress;

import com.datastructures.efdress.enums.ClasCalzado;

/**
 *
 * @author calon
 */
public class Calzado extends Articulo {
    ClasCalzado cz;

    public Calzado(String cz){
        this.cz= ClasCalzado.valueOf(cz.toUpperCase());
    }

    public Calzado(int id, String nombre, String material, String ocasion, String tipo, String ubicacion) {
        super(id, nombre, material, ocasion, tipo, ubicacion);
    }

    public Calzado() {
        super();
    }
    
}
