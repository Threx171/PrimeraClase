package com.example;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Botiga {

    private NavigableMap<String, Double> nMap = new TreeMap<String, Double>();

    public static void main(String[] args) {
        Botiga b = new Botiga();
        b.nMap.put("Guilty Gear Strive", 25.99);
        System.out.println(b.inserirVideojoc("Guilty Gear Xrd", 50.00));
    }

    public String inserirVideojoc(String nomVideojoc, double preuVideojoc) {
        if (nomVideojoc.equals(""))  {
            return "El nom del producte no pot ser buit";
        }else if (!this.nMap.containsKey(nomVideojoc)){
            this.nMap.put(nomVideojoc, preuVideojoc);
            return "Producte inserit";
        }else{
            return "El producte ja existeix";
        }
    }
    public String eliminarVideojoc(String nomVideojoc) {
        if (nomVideojoc.equals(""))  {
            return "El nom del producte no pot ser buit";
        }else if (this.nMap.containsKey(nomVideojoc)){
            this.nMap.remove(nomVideojoc);
            return "Producte eliminat";
        }else{
            return "El producte no existeix";
        }      
    }
}
