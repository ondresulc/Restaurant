package com.company;
import java.time.LocalDate;
import java.util.*;

public class AllOrders {
    static ArrayList<Order> orderList = new ArrayList<>();
    public static void addOrderInAllOrdersList(Order oneOrder) {
        orderList.add(oneOrder);
    }
    public static void orderTotal() {
        int orderTotal = orderList.size();
        System.out.println("Total number of ORDERS in your restaurant is: " + orderTotal);
        System.out.println("----------------------------------------------------");
    }
    public static void getItemTotalSold(String itemName) {
        int itemCounter = 0;
        for (int i = 0; i < orderList.size(); i++) {
            for (int j = 0; j < orderList.get(i).getItems().size(); j++) {
                String x = orderList.get(i).getItems().get(j).itemTitle;
                if (x.equals(itemName))
                    itemCounter  += orderList.get(i).getItems().get(j).getItemQuantity();
            }
        }
        System.out.println("There was "+ itemCounter +" pcs of "+ itemName+ " in total sold.");
    }
    public static void dayTurnover() {
        LocalDate date = LocalDate.now();
        double tmp = 0;
        for (int i = 0; i < orderList.size(); i++) {
            LocalDate dateFound = orderList.get(i).getOrderDate();
            for (int j = 0; j < orderList.get(i).getItems().size(); j++) {
                if (date.equals(dateFound))
                    tmp  += orderList.get(i).getItems().get(j).getItemQuantity();
            }
        }
    }
    public static void orderValue() {
        Map<LocalDate,Double> tmp = new HashMap<>();
        for (int i = 0; i < orderList.size(); i++) {
            double sum = 0;
            for (Item item: orderList.get(i).getItems()) {
                double itemValue = item.getItemQuantity() * item.getItemPrice();
                sum +=itemValue;
            }

            if(tmp.containsKey(orderList.get(i).orderDate)) {
                tmp.put(orderList.get(i).orderDate, tmp.get(orderList.get(i).orderDate) + sum);
            }
            else{
                tmp.put(orderList.get(i).orderDate,sum);
            }
        }

        System.out.println("Let's have a look at the turnovers day by day: ");
        for (LocalDate x:tmp.keySet()) {
            System.out.println(x + " | " + tmp.get(x) + " | CZK");
        }
    }
    public static void allItemsPrintOut() {
        Set<String> allItems = new HashSet<>();
        for (int i = 0; i < orderList.size(); i++) {
            for (int j = 0; j < orderList.get(i).getItems().size(); j++) {
                allItems.add(orderList.get(i).getItems().get(j).getItemTitle());
            }
        }
        List<String> list = new ArrayList<>(allItems);
        Collections.sort(list);
        System.out.println("==================================================================================================");
        System.out.println("These items were sold by far:");
        System.out.println(list);
        System.out.println("==================================================================================================");
    }
}
