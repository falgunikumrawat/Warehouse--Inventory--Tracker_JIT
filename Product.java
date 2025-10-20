public class Product {
    private String id;
    private String name;
    private int quantity;
    private int threshold;

    public Product(String id , String name , int quantity , int threshold){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.threshold = threshold;
    }
    public String getID() { return id ;
    }
    public String getName(){ return name ; 
    }
    public int getQuantity() { return quantity;
    }
    public int getThreshold() { return threshold ;
    }
    public void increaseQuantity(int qty){
        if( qty <= 0 ) return;
        this.quantity += qty;
    }
    public boolean decreaseQuantity(int qty) {
        if ( qty <= 0) return false;
        if ( qty > this.quantity) {
            return false; 
            //insufficient stock
        }
        this.quantity -= qty ;
        return true;
    }
    public boolean isLowStock() {
        return this.quantity < this.threshold;
    }
}
