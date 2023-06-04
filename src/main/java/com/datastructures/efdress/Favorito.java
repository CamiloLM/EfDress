package com.datastructures.efdress;

import java.util.LinkedList;
import java.util.Stack;

public class Favorito {
    private static Favorito instance;
    private LinkedList<Integer> favorites;
    /*
    Se crea una stack que sirve para guardar los favoritos eliminados en caso
    de que el usuario se arrepienta de haber eliminado alguno
     */

    private Stack<Integer> deletedFavs;

    private Favorito(){
        favorites= new LinkedList<>();
        deletedFavs= new Stack<>();
    }

    /*
    Solo se permite crear una unica instancia de Favorito, ya que solo hay un "Favritos" disponibles
    para el usuario (Hasta el momento).
     */
    public static Favorito getInstance(){
        if(Favorito.instance==null){
            instance= new Favorito();
        }
        return Favorito.instance;
    }
     public boolean saveFavorite(int id){
        if(favorites.contains(id)) return false;
        favorites.add(id);
        return true;
     }
     /*
     Para eliminar algun favorito se podra hacer uno por uno o también
     se podran eliminar todos los favoritos actuales
      */
     public boolean deleteFavorite(int id){
         if(favorites.contains(id)){
             deletedFavs.push(id);
             favorites.removeFirstOccurrence(id);
             return true;
         }
         return false;
     }

     public void deleteAll(){
         favorites.clear();
     }

     public int getFav(int id){
         if(favorites.contains(id)) return id;
         return -1;
     }

     public Integer[] getAllFavs(){
         if(favorites.isEmpty()) return null;
         Integer[] favoritos = new Integer[this.getFavsArray().length];
         Object[] favObj = this.getFavsArray();
         for (int i=0;i<favObj.length;i++){
             favoritos[i]=(int)(favObj[i]);
         }
         return favoritos;
     }
     private Object[] getFavsArray(){
         if (!favorites.isEmpty()){
             return favorites.toArray();
         }
         return null;
     }

     public int undoDeletedFav(){
        return deletedFavs.pop();
    }

    @Override
    public String toString() {
         if(favorites.isEmpty()) return "[]";
         Integer [] items;
         try{
             items=this.getAllFavs();
         }
         catch (NullPointerException np){
             return "[]";
         }
         String fav="[";
         for (Integer item :items){
             fav+=","+item;
        }
         fav+="]";
         return fav;
    }
}
