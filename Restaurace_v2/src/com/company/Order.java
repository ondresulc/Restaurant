package com.company;
import java.time.LocalDate;
import java.util.ArrayList;
public class Order {
    int orderID;
    int tableNr;
    LocalDate orderDate;
    PaymentType type;
    ArrayList<Item> items;
    public Order(int orderID, int tableNr, LocalDate orderDate, PaymentType type,  ArrayList<Item> items) {
        this.orderID = orderID;
        this.tableNr = tableNr;
        this.orderDate = orderDate;
        this.type = type;
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public int getTableNr() {
        return tableNr;
    }
    public void setTableNr(int tableNr) {
        this.tableNr = tableNr;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public PaymentType getPaymentType() {
        return type;
    }
    public void setType(PaymentType type) {
        this.type = type;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public String oneOrderInfo() {
        String info = getOrderID() + " | "
                + getTableNr() + " | "
                + getOrderDate() + " | "
                + getPaymentType() + " | ";
        return info;
    }
    public String getItemsInfo() {
        String itemName = items.get(0).itemTitle;
        return itemName;
    }
}