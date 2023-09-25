/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class customer {
    private int customerId;
    private String name;
    private int quantity;
    private double price;

    public customer(int customerId,String name, int quantity, double price) {
        this.customerId = customerId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getCustomerId(){
        return customerId;
    }
    
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    }
    
    

