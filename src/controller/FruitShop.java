
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import view.Menu;
import model.Fruit;
import model.customer;
import common.Library;



public class FruitShop extends Menu<String> {

    static String[] menu = {"Exit","Create Fruit", "View orders", "Shopping(for buyer)"};
    Library l;
    ArrayList<Fruit> list_F;
    Hashtable<String, ArrayList<customer>> ht;
//------------------------------------------------------------------------------------------------------------------    

    public FruitShop() {
        super("Fruit Shop System!!!", menu);
        Library l;
        list_F = new ArrayList<>();
        ht= new Hashtable<>();
    }

    @Override
    public void execute(int n) {
        switch (n){
            case 0:
                System.exit(0);
            case 1:
                createFruit();
                break;
            case 2:
                viewListOrder();
                break;
            case 3:
                shopping();
                break;
                
        }
    }
     public void viewListOrder(){
        if(ht.isEmpty()){
            System.out.println("No Order");
            return;
        }
        for(String name: ht.keySet()){
            System.out.println("Customer: "+ name);
            ArrayList<customer> array_o = ht.get(name);
            displayListOrder(array_o);
        }
    }

    public void createFruit() {
        int fruitId = generateID();
        String fruitName = l.getString("Enter fruit name: ");
        double price = l.getDouble("Enter fruit price");
        int quantity = l.getInt("Enter fruit quantity", 1, 100);
        String origin = l.getString("Enter fruit origin: ");
        list_F.add(new Fruit(fruitId, fruitName, price, quantity, origin));
    }

    public void displayFruit() {
        for (Fruit f : list_F) {
            System.out.println("Id: " + f.getFruitId() + " - Name: " + f.getFruitName() + " - Price: " + f.getPrice() + " - quantity:" + f.getQuantity() + " - origin: " + f.getOrigin());
        }
    }

    public void shopping() {
        /*if (ht.isEmpty()) {
            System.out.println("No Product");
            return;
        }*/
        displayFruit();
        String fruitName = l.getString("Enter fruit name: ");
        int quantityOrder = l.getInt("Please input quantity", 1, 10);
        ArrayList<customer> list_o = new ArrayList<>();
        for (Fruit f : list_F) {
            if (fruitName.equals(f.getFruitName())) {
                int fruitId = f.getFruitId();
                double price = f.getPrice();
                int quantity = f.getQuantity();
                if(quantityOrder>quantity){
                     System.out.println("Quantity Order more than quantity");
                     shopping();
                }
                list_o.add(new customer(fruitId, fruitName, quantityOrder, price));
                displayListOrder(list_o);
                String customer = l.getString("Enter Customer of name: ");
                ht.put(customer, list_o);
                System.out.println("Add Successfull");
            }
        }
    }
    
     private void displayListOrder(ArrayList<customer> list_o) {
        double total = 0;
        for (customer o : list_o) {
            System.out.println("Id: " + o.getCustomerId() + " - Customer of name: " + o.getName() + " - quanlity: " + o.getQuantity() + " - price: " + o.getPrice());
            total += o.getPrice() * o.getQuantity();
        }
        System.out.println("Total: "+ total);
    }

    public int generateID() {
        int id = 0;
        if (list_F.size() == 0) {
            return 1;
        } else {

            for (Fruit s : list_F) {
                if (s.getFruitId() == list_F.size()) {
                    id = s.getFruitId() + 1;
                }
            }
        }
        return id;
    }
    
    
    
    
    
}
