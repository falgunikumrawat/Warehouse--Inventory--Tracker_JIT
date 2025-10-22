public class AlertService implements StockObserver {
    public void onLowStock( Product product) {
        System.out.println(" Restock Alert: " + product.getName() + " - only " + product.getQuantity() + " left! ");
    }
    
}
