package com.company;
import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("WELCOME TO OUR RESTAURANT PROGRAMME");
        System.out.println("===================================");

        ArrayList<Item> oneOrderList = new ArrayList<>();
        oneOrderList.add(new Item("pizza", 150, 2));
        oneOrderList.add(new Item("coffee", 50, 4));
        oneOrderList.add(new Item("desert", 75, 2));
        oneOrderList.add(new Item("soda", 40, 3));
        oneOrderList.add(new Item("soup", 50, 2));
        Order oneOrder = new Order(1,
                10,
                LocalDate.of(2021, 05, 18),
                PaymentType.BY_CARD,
                oneOrderList);
        double sum = calculateOrderValue(oneOrderList);
        System.out.println();
        System.out.println("The total value of the order Nr. "+ oneOrder.getOrderID() + " makes: " + sum + " CZK");
        AllOrders.addOrderInAllOrdersList(oneOrder);
//        AllOrders.getItemsInfo();
        oneOrderList.clear();
        System.out.println("----------------------------------------------------");
        //-----------------------------------------------------------------------
        oneOrderList.add(new Item("pizza", 160, 5));
        oneOrderList.add(new Item("coffee", 70, 1));
        oneOrderList.add(new Item("vodka", 80, 10));
        oneOrderList.add(new Item("desert", 80, 4));
        oneOrderList.add(new Item("soup", 55, 3));
        oneOrder = new Order(2,
                2,
                LocalDate.of(2021, 05, 18),
                PaymentType.CASH,
                oneOrderList);
        sum = calculateOrderValue(oneOrderList);
        System.out.println("The total value of the order Nr. "+ oneOrder.getOrderID() + " makes: " + sum + " CZK");
        AllOrders.addOrderInAllOrdersList(oneOrder);
        oneOrderList.clear();
        System.out.println("----------------------------------------------------");
        //-----------------------------------------------------------------------
        oneOrderList.add(new Item("spaghetti", 180, 3));
        oneOrderList.add(new Item("beer", 40, 6));
        oneOrderList.add(new Item("lemonade", 35, 4));
        oneOrderList.add(new Item("soda", 40, 3));
        oneOrderList.add(new Item("soup", 60, 3));
        oneOrder = new Order(3,
                3,
                LocalDate.of(2021, 05, 19),
                PaymentType.BY_CARD,
                oneOrderList);
        sum = calculateOrderValue(oneOrderList);
        System.out.println("The total value of the order Nr. "+ oneOrder.getOrderID() + " makes: " + sum + " CZK");
        AllOrders.addOrderInAllOrdersList(oneOrder);
        oneOrderList.clear();
        System.out.println("----------------------------------------------------");
        //-----------------------------------------------------------------------
        oneOrderList.add(new Item("steak", 320, 6));
        oneOrderList.add(new Item("beer", 40, 10));
        oneOrderList.add(new Item("coca-cola", 45, 12));
        oneOrderList.add(new Item("soda", 40, 3));
        oneOrderList.add(new Item("soup", 60, 3));
        oneOrder = new Order(4,
                5,
                LocalDate.of(2021, 05, 19),
                PaymentType.BY_CARD,
                oneOrderList);
        sum = calculateOrderValue(oneOrderList);
        System.out.println("The total value of the order Nr. "+ oneOrder.getOrderID() + " makes: " + sum + " CZK");
        AllOrders.addOrderInAllOrdersList(oneOrder);
        oneOrderList.clear();
        System.out.println("----------------------------------------------------");
        //-----------------------------------------------------------------------
        oneOrderList.add(new Item("tuna-fish", 190, 3));
        oneOrderList.add(new Item("beer", 40, 8));
        oneOrderList.add(new Item("coca-cola", 45, 5));
        oneOrderList.add(new Item("soda", 40, 1));
        oneOrderList.add(new Item("coffee", 60, 6));
        oneOrder = new Order(5,
                5,
                LocalDate.of(2021, 05, 20),
                PaymentType.BY_CARD,
                oneOrderList);
        sum = calculateOrderValue(oneOrderList);
        System.out.println("The total value of the order Nr. "+ oneOrder.getOrderID() + " makes: " + sum + " CZK");
        AllOrders.addOrderInAllOrdersList(oneOrder);
        oneOrderList.clear();
        System.out.println("----------------------------------------------------");
        //-----------------------------------------------------------------------
        oneOrderList.add(new Item("pizza", 160, 10));
        oneOrderList.add(new Item("beer", 40, 4));
        oneOrderList.add(new Item("coca-cola", 45, 2));
        oneOrderList.add(new Item("desert", 75, 3));
        oneOrderList.add(new Item("vodka", 80, 19));
//        oneOrderList.add(new Item("goulash", 120, 1));

        oneOrder = new Order(6,
                5,
                LocalDate.of(2021, 05, 20),
                PaymentType.CASH,
                oneOrderList);
        sum = calculateOrderValue(oneOrderList);

        System.out.println("The total value of the order Nr. "+ oneOrder.getOrderID() + " makes: " + sum + " CZK");

        AllOrders.addOrderInAllOrdersList(oneOrder);

        //the total number of orders
        System.out.println("----------------------------------------------------");
        AllOrders.orderTotal();

        //the total number of the item sold
        AllOrders.getItemTotalSold("pizza");
        System.out.println("----------------------------------------------------");

        Order tmp = AllOrders.orderList.get(0);
        oneOrderList.clear();
        AllOrders.orderValue();

        //listing of all items sold ever (sorted alphabetically)
        AllOrders.allItemsPrintOut();
    }
    private static double calculateOrderValue(ArrayList<Item> oneOrderList) {
        double sum = 0;
        for (Item item: oneOrderList) {
            double itemValue = item.getItemQuantity() * item.getItemPrice();
            sum +=itemValue;
        }
        return sum;
    }
    public static void turnoverByDate(){
        LocalDate date = LocalDate.now();
        double dayTurnoverCounter = 0;
        for (int i = 0; i < AllOrders.orderList.size(); i++) {
            date = AllOrders.orderList.get(i).getOrderDate();
        }
    }
    private static void printOrderInfo(ArrayList<Item> oneOrderList, Order orderOne) {
        String itemInfo = "";
        for (int i = 0; i < oneOrderList.size(); i++) {
            itemInfo = oneOrderList.get(i).getItemTitle()  + " | "
                    + oneOrderList.get(i).getItemPrice()   + " | "
                    + oneOrderList.get(i).getItemQuantity();
            System.out.println(orderOne.oneOrderInfo() + " " + itemInfo);
        }
    }
}