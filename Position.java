package JanKozak7;

import java.io.*;
import java.util.Formatter;
import java.util.ArrayList;

class Position implements Serializable {

//    System.out.println("Created constructior with id number " + id);

    protected int id;
    protected String productName;
    protected int quantity;
    protected double price;
    private double discountValue;

    public Position (int id, String name, int quantity_c, double price_c) {
        this.id = id;
        this.productName = name;
        this.quantity = quantity_c;
        this.price = price_c;
        System.out.println("Created constructior with id number " + id);
    }

    public double value() {
        discount();
        double positionValue = price * quantity * discountValue;
        Formatter formatter = new Formatter();
        formatter.format("%.2f",positionValue);
        System.out.println("Value of " + productName + " id is " + formatter);
        return positionValue * discountValue;
    }

    public void form() {
            Formatter formatter = new Formatter();
            formatter.format("%-20s%-10.2f%-4d%-10.2f%.2f%%" , productName, price, quantity, value(), (1-discountValue) * 100);
            String formattedString = formatter.toString();
            System.out.println(formattedString);
    }
   /* public double getValue() {
        double OrderValue = price * quantity;
        return OrderValue;
    }*/

    public double discount() {
        if (quantity < 5) {
            System.out.println("No Discount, quantity is less than 5");
            discountValue = 1;
        }
        if (quantity > 4 && quantity < 11) {
            discountValue = 0.95;
            Formatter formatter = new Formatter();
            formatter.format("%.2f%%", (1-discountValue) * 100);
            System.out.println("Discount value for " + productName + " = " + formatter);
        }
        if (quantity > 10 && quantity < 21) {
            discountValue = 0.90;
            Formatter formatter = new Formatter();
            formatter.format("%.2f%%", (1-discountValue) * 100);
            System.out.println("Discount value for " + productName + " = " + formatter);
        }
        if (quantity > 20) {
            discountValue = 0.85;
            Formatter formatter = new Formatter();
            formatter.format("%.2f%%", (1-discountValue) * 100);
            System.out.println("Discount value for " + productName + " = " + formatter);
        }
        return discountValue;
    }

}

