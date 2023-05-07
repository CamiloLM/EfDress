package com.datastructures.efdress;

import com.datastructures.efdress.enums.ClasTopH;

public class TopHombre extends Articulo {

    private ClasTopH clasTopH;
    public TopHombre(int id, String nombre, String material, String ocasion, String tipo, String ubicacion) {
        super(id, nombre, material, ocasion, tipo, ubicacion);
    }
    public TopHombre(String clasTopH){
        this.clasTopH=ClasTopH.valueOf(clasTopH.toUpperCase());
    }
}
