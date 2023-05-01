package com.datastructures.efdress;

import com.datastructures.efdress.enums.ClasTopH;

public class TopHombre extends Articulo {

    private ClasTopH clasTopH;

    public TopHombre(String clasTopH){
        this.clasTopH=ClasTopH.valueOf(clasTopH.toUpperCase());
    }
}
