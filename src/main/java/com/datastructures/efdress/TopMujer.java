package com.datastructures.efdress;

import com.datastructures.efdress.enums.ClasTopM;

public class TopMujer extends Articulo{

    private ClasTopM clasTopM;

    public TopMujer(String clasTopM){
        this.clasTopM=ClasTopM.valueOf(clasTopM.toUpperCase());
    }
}
