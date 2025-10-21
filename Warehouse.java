import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String , Product>inventory = new HashMap<>();

      private ArrayList<StockObserver>observers = new ArrayList<>();

      public void addProduct( Product product){
        if( product == null )
        return;
        inventory.put(product.getID() , product);
      }
      public void registerObserver(StockObserver observer){
        if ( observer == null )
        return;
        observers.add(observer);
      }
      private void notifyObservers( Product product){
       for ( StockObserver obs: observers){
        obs.onLowStock(product);
       }
           }
           public synchronized void receiveShipment(String productID , int qty){
            Product product = inventory.get(productID);
            if(product == null){
                System.out.println("Invalid product ID: " + productID);
                return;
            }
            product.increaseQuantity(qty);
            System.out.println("Received " + qty + " units of " + product.getName() + " ( now " + product.getQuantity() + ")");
           }
           public synchronized void fulfillOrder(String productID , int qty ){
            Product product = inventory.get(productID);
               if( product == null ){
                System.out.println("Invalid productID: " + productID);
                return;
               }
               boolean ok = product.decreaseQuantity(qty);
               if(!ok){
                System.out.println(" Insufficient stock for " + product.getName());
                return;
               }
               System.out.println("Fulfilled order of " + qty + " " + product.getName() + " (now" + product.getQuantity() + ")");
               if(product.isLowStock()){
                notifyObservers(product);
               }
           }
           public Product geProduct(String productID){
            return inventory.get(productID);
           }
    
}
