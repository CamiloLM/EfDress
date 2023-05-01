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
    public Pantalon(String tiro,String fit,String cp){
        this.tiro=Tiro.valueOf(tiro.toUpperCase());
        this.fit=Fit.valueOf(fit.toUpperCase());
        this.cp= ClasPantalon.valueOf(cp.toUpperCase());
    }

    public Pantalon(String fit,String cp){
        this(null,fit,cp);
    }

    //cp no debe ser de caracter nulo, la prenda al menos se tiene que clasificar en algo.
    public Pantalon(String cp){
        this("","",cp);
    }

    //Getters and Setters
    public Tiro getTiro() {
        return tiro;
    }

    public void setTiro(Tiro tiro) {
        this.tiro = tiro;
    }

    public Fit getFit() {
        return fit;
    }

    public void setFit(Fit fit) {
        this.fit = fit;
    }

    public ClasPantalon getCp() {
        return cp;
    }

    public void setCp(ClasPantalon cp) {
        this.cp = cp;
    }
}
