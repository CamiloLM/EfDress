package com.datastructures.efdress;

import java.util.LinkedList;
import java.util.Stack;

public class Reciente {

    private static Reciente instance;
    private LinkedList<Integer> recents;




    private Reciente(){
        recents= new LinkedList<>();
    }

    /*
    Solo se permite crear una unica instancia de Favorito, ya que solo hay un "Favritos" disponibles
    para el usuario (Hasta el momento).
     */
    public static Reciente getInstance(){
        if(Reciente.instance==null){
            instance= new Reciente();
        }
        return Reciente.instance;
    }

    //Cada vez que se use un articulo se añade a la lista enlazada
    public boolean addRecent(int id){
        if(recents.contains(id)) return false;
        recents.add(id);
        return true;
    }

    //Devuelve todos los articulos recientes en forma de arreglo
    public Integer[] getRecents(){
        if(recents.isEmpty()) return null;
        Object [] recentsObj= recents.toArray();
        Integer [] recentsArr= new Integer[recentsObj.length];
        for (int i=0;i<recentsObj.length;i++){
            recentsArr[i]=(int)recentsObj[i];
        }
        return recentsArr;
    }

    //clearHistory() limpia el historial de articulos recientemente usados
    public void clearHistory(){
        if (!recents.isEmpty()) recents.clear();
    }

    @Override
    public String toString() {
        if(recents.isEmpty()) return "[]";
        Integer [] items;
        try{
            items=this.getRecents();
        }
        catch (NullPointerException np){
            return "[]";
        }
        String rec="[";
        for (Integer item :items){
            rec+=","+item;
        }
        rec+="]";
        return rec;
    }
}
