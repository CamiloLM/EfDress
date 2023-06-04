package com.datastructures.efdress;

import static com.datastructures.efdress.Main.findItem;

public class Conjunto {
    private int[] conjunto;
    
    public Conjunto() {
        this.conjunto = new int[6];
        for (int i = 0; i < 6; i++) {
            this.conjunto[i] = -1;
        }      
    }
        
    public void add(Articulo art) {
        String clase = art.getClase();
        switch (clase) {
            case "Sombrero":
                conjunto[0] = art.getId();
                break;
            case "Abrigo":
                conjunto[1] = art.getId();;
                break;
            case "TopHombre":
                conjunto[2] = art.getId();;
                break;
            case "TopMujer":
                conjunto[2] = art.getId();;
                break;
            case "Entero":
                conjunto[3] = art.getId();;
                break;
            case "Pantalon":
                conjunto[4] = art.getId();;
                break;
            case "Calzado":
                conjunto[5] = art.getId();;
                break;
        }   
    }
    
    /**
     * Agrega un id al arreglo de conjuntos en el indice indicado.
     * Los indices del arreglo corresponden a:
     * <br>index 0 -> Sombrero.
     * <br>index 1 -> Abrigo.
     * <br>index 2 -> Tops.
     * <br>index 3 -> Entero.
     * <br>index 4 -> Pantalon.
     * <br>index 5 -> Calzado.
    */
    public void add(int index, int id) {
        if (index >= 0 && index <= 5 && id >= 0) {
            conjunto[index] = id;
        }
    }
    
    public int remove(Articulo art) {
        int id = art.getId();
        for (int i = 0; i < 6; i++) {
            if (conjunto[i] == id) {
                conjunto[i] = -1;
                return id;
            }
        }
        return -1;
    }
    
    /**
     * Elimina un id del arreglo de conjuntos en el indice indicado.
     * Los indices del arreglo corresponden a:
     * <br>index 0 -> Sombrero.
     * <br>index 1 -> Abrigo.
     * <br>index 2 -> Tops.
     * <br>index 3 -> Entero.
     * <br>index 4 -> Pantalon.
     * <br>index 5 -> Calzado.
    */
    public int remove(int index) {
        if (index >= 0 && index <= 5) {
            int id  = conjunto[index];
            conjunto[index] = -1;
            return id;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        boolean flag = true;
        for (int el : conjunto) {
            if (el != -1) flag = false;
        }
        return flag;
    }
     
    public void removeAll() {
        this.conjunto = new int[6];
        for (int i = 0; i < 6; i++) {
            this.conjunto[i] = -1;
        }
    }
    
    public int[] getConjunto() {
        return conjunto;
    }

    public Articulo getObject(int id) {
        if (id >= 0) {
            for (int el : conjunto) {
                if ( el == id) {
                    return findItem(el);
                }
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int id : conjunto) {
            if (id != -1) {
                Articulo art = findItem(id);
                sb.append(art.toString()).append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
        
}
