import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlertService alert = new AlertService();
        System.out.println("Enter Warehouse Name: ");
        String warehouseName = sc.nextLine();
        Warehouse warehouse = new Warehouse(warehouseName);
              warehouse.addObserver(alert);
              warehouse.loadFromFile();

              while (true){ 
                System.out.println("\n===== Warehouse Inventory Menu =====");
                System.out.println("1. Add product");
                System.out.println("2. Receive shipment");
                System.out.println("3. Fulfill order");
                System.out.println("4. Show Inventory");
                System.out.println("5. Save & Exit");
                System.out.println("Choose option: ");
                  int choice = sc.nextInt();

                  switch (choice) {
                    case 1:
                           System.out.print("Enter product ID:");
                             int id = sc.nextInt();
                             sc.nextLine();
                     
                          System.out.print("Enter product Name:");
                             String name = sc.nextLine();
                          System.out.print("Enter Quantity: ");
                            int qty = sc.nextInt();
                         System.out.print("Enter Reorder Threshold: ");
                           int th = sc.nextInt();
                           warehouse.addProduct(new Product(id, name, qty, th));
                           break;
                    case 2:
                           System.out.print("Enter product ID:");
                              id = sc.nextInt();
                           System.out.println("Enter Shipment Quantity: ");
                              qty = sc.nextInt();
                              new Thread(() -> warehouse.registerShipment(id, qty)).start();

                           break;
                    case 3:
                           System.out.print("Enter Product ID: ");
                              id = sc.nextInt();
                           System.out.print("Enter Order Quantity: ");
                               qty = sc.nextInt();
                               new Thread(() -> warehouse.fulfillOrder(id, qty)).start();
                               break;
                     case 4: 
                            warehouse.showInventory();
                            break;
                     case 5:
                           warehouse.saveToFile();
                           System.out.println(" Exiting system... ");
                              return;
                                    default:
                           System.out.println(" Invalid choice");

                        }
                  }
               }
            }

