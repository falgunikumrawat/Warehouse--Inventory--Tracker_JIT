public class Product {
    private int id;
    private String name;
    private int quantity;
    private int threshold;

    public Product(int id , String name , int quantity , int threshold){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.threshold = threshold;
    }
    public int getID() { return id ;
    }
    public String getName(){ return name ; 
    }
    public int getQuantity() { return quantity;
    }
    public int getThreshold() { return threshold ;
    }
    public void increaseStock(int amount){
        quantity += amount;
    }
    public boolean decreaseStock(int amount) {
        if (amount > quantity){
            System.out.println( " Not enough stock for " + name);
           return false;
        }
        quantity -= amount;
        return true;
      }
      public String toString() {
        return id + " | " + name + " | Qty: " + quantity + " | Threshold: " + threshold; 
      }
}
