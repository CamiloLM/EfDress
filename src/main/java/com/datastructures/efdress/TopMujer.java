package com.datastructures.efdress;

import com.datastructures.efdress.enums.ClasTopM;

public class TopMujer extends Articulo{

    private ClasTopM clasTopM;
    public TopMujer(int id, String nombre, String material, String ocasion, String tipo, String ubicacion) {
        super(id, nombre, material, ocasion, tipo, ubicacion);
    }

    public TopMujer(String clasTopM){
        this.clasTopM=ClasTopM.valueOf(clasTopM.toUpperCase());
    }
}
