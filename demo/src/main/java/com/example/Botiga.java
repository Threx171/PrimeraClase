package com.example;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.*;

public class Botiga {

    private NavigableMap<String, Double> nMap = new TreeMap<String, Double>();

    public static void main(String[] args) {
        Botiga b = new Botiga();
        b.nMap.put("Guilty Gear Strive", 25.99);
        System.out.println(b.nMap);
        b.menuBotiga();
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
        }else if (nMap.containsKey(nomVideojoc)){
            this.nMap.remove(nomVideojoc);
            return "Producte eliminat";
        }else{
            return "El producte no existeix";
        }      
    }
    public String changePrice(String name){
        String err = "";
        if(nMap.containsKey(name)){
            System.out.print("Introdueix el preu nou: ");
            Scanner sc = new Scanner(System.in);

            while(true){
                if(!sc.hasNextDouble()){
                System.out.print("El preu ha de ser un número");
                }else break;
            }
            
            Double price = sc.nextDouble();
            nMap.put(name, price);
            System.out.print("El preu s'ha actualitzat");

        }else err = "Producte desconegut";

        return err;
    }
    public void showProducts(){
        for(Iterator i=nMap.keySet().iterator(); i.hasNext();){
            String k=(String)i.next();
            String v=nMap.get(k).toString();
            System.out.println("Nom videojoc: "+k+ ", preu: " +v);
        }
    }
    public void menuBotiga() {
        String menu = "Benvingut al menú de botiga de videojocs\n"+
                      "Tria una opció:\n"+
                      "1)Inserir videojoc\n"+
                      "2)Modificar preu\n"+
                      "3)Eliminar videojoc\n"+
                      "4)Mostrar inventari\n"+
                      "5)Sortir";
        while(true) {
            String nomVideojoc;
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println(menu);
                if(!sc.hasNextInt()){
                    System.out.print("La opció ha de ser un número\n");
                    sc.next();
                }else break;
            }
            int opc = sc.nextInt();
            switch(opc) {
                case 1:
                    System.out.println("Introdueix el nom del videojoc: ");
                    sc.nextLine();
                    nomVideojoc = sc.nextLine();
                    while(true){
                        System.out.println("Introdueix preu del videojoc: ");
                        if(!sc.hasNextDouble()){
                        System.out.print("El preu ha de ser un número\n");
                        sc.next();
                        }else break;
                    }
                    double preuVideojoc = sc.nextDouble();
                    inserirVideojoc(nomVideojoc, preuVideojoc);
                    break;
                case 2:
                    System.out.println("Introdueix el nom del videojoc: ");
                    sc.nextLine();
                    nomVideojoc = sc.nextLine();
                    String err = changePrice(nomVideojoc);
                    if (!err.equals("")) System.out.println(err);
                    break;
                case 3:
                    System.out.println("Introdueix el nom del videojoc: ");
                    sc.nextLine();
                    nomVideojoc = sc.nextLine();
                    System.out.println(eliminarVideojoc(nomVideojoc));
                    break;
                case 4:
                    showProducts();
                    break;
                case 5:
                    System.out.println("Sortint de l'aplicació botiga");
                    return;
            } 
        }
    }
}
