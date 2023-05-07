package com.datastructures.efdress;

import com.datastructures.efdress.enums.ClasAbrigo;

/*Llamaremos Abrigo a cualquier tipo de saco,chaqueta, blazer, to_do lo que tenga que ver con este tipo de
prendas de ropa*/

public class Abrigo extends Articulo{
    private ClasAbrigo claseAbr;
    public Abrigo(int id, String nombre, String material, String ocasion, String tipo, String ubicacion) {
        super(id, nombre, material, ocasion, tipo, ubicacion);
    }
    public Abrigo(String clase){
        this.claseAbr=ClasAbrigo.valueOf(clase.toUpperCase());
    }


}
