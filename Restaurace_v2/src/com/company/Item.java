package com.company;
public class Item {
    String itemTitle;
    double itemPrice;
    int itemQuantity;
    public Item(String itemTitle, double itemPrice, int itemQuantity) {
        this.itemTitle = itemTitle;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
    public String getItemTitle() {
        return itemTitle;
    }
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}