package com.datastructures.efdress;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author calon
 */
public class EfDress {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] lista = {"Diario", "Noche"};
        HashMap<String, Color> colores = new HashMap<>();
        colores.put("Amarillo", Color.YELLOW);
        
        Superior chaqueta = new Superior(
                "Chaqueta 1",
                "Cuero",
                colores,
                lista,
                "Chaqueta",
                "url"
        );

    }
}
