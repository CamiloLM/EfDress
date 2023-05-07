package com.datastructures.efdress;

/*
Llamariamos pantalon a cualquier prenda de ropa que vaya desde la cintura hasta donde llegue
*/

import com.datastructures.efdress.enums.ClasPantalon;
import com.datastructures.efdress.enums.Fit;
import com.datastructures.efdress.enums.Tiro;

public class Pantalon extends Articulo {
    private Tiro tiro;
    private Fit fit;
    private ClasPantalon cp;

    public Pantalon(int id, String nombre, String material, String ocasion, String tipo, String ubicacion, String tiro,String fit) {
        super(id, nombre, material, ocasion, tipo, ubicacion);
        this.tiro=Tiro.valueOf(tiro.toUpperCase());
        this.fit=Fit.valueOf(fit.toUpperCase());
    }



    //cp no debe ser de caracter nulo, la prenda al menos se tiene que clasificar en algo.

    //Getters and Setters
    public Tiro getTiro() {
        return tiro;
    }

    public void setTiro(String tiro) {
        this.tiro = Tiro.valueOf(tiro);
    }

    public Fit getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = Fit.valueOf(fit);
    }

    public ClasPantalon getCp() {
        return cp;
    }

    public void setCp(ClasPantalon cp) {
        this.cp = cp;
    }
}
