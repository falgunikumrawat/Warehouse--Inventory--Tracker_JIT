import java.util.*;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
  private String name;
    private Map<Integer , Product>inventory = new HashMap<>();

      private ArrayList<StockObserver>observers = new ArrayList<>();
       public Warehouse(String name){
        this.name = name;
       }
      public void addObserver(StockObserver observer){
          observers.add(observer);
      }
      public void addProduct( Product product){
        inventory.put(product.getID() , product);
        System.out.println(" Product added: " + product.getName());
      }
      public void registerShipment( int id , int amount){
        Product p = inventory.get(id);
        if (p != null ){
          p.increaseStock(amount);
          System.out.println(" shipment received: " + p.getName());
        }else{
          System.out.println("Invalid product ID");
        }
      }
      public void fulfillOrder(int id, int amount){
        Product p = inventory.get(id);
        if(p != null && p.decreaseStock(amount)){
          System.out.println(" Order fulfilled: " + amount + " units of " + p.getName());
          if(p.getQuantity() < p.getThreshold()){
            for ( StockObserver o : observers){
              o.onLowStock(p);
            }
          }
        }
      }
      public void showInventory() {
        System.out.println("\n Current Inventory of " + name + ":");
        for(Product p : inventory.values()){
          System.out.println(p);
        }
      }
      // Persist inventory to fiel
      public void saveToFile() {
        try(PrintWriter pw = new PrintWriter(new FileWriter(name + "_inventory.txt"))){
          for(Product p: inventory.values()){
            pw.println(p.getID() + "," + p.getName() + "," + p.getQuantity() + "," + p.getThreshold());
          }
          System.out.println(" Inventory saved to file. ");
        }
        catch(IOException e){
          e.printStackTrace();
        }
      }
      // Load inventory from file 
      public void loadFromFile() {
        File file = new File(name + "_inventory.txt");
        if (!file.exists())
        return;
        try(Scanner sc = new Scanner(file)){
          while ( sc.hasNextLine()){
            String[] parts = sc.nextLine().split(",");
            int id = Integer.parseInt(parts[0]);
            String pname = parts[1];
            int qty = Integer.parseInt(parts[2]);
            int threshold = Integer.parseInt(parts[3]);
            inventory.put(id,new Product(id, pname, qty, threshold));
          }
          System.out.println("Inventory loaded from file.");
        }
        catch(Exception e){
          e.printStackTrace();
        }
      }
    }

 //minor update to correct commit message      
        