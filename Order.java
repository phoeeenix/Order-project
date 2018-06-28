package JanKozak7;

import java.io.*;
import java.util.ArrayList;

class Order implements Serializable {

    //private Position[] table = new Position[2];
    private ArrayList<Position> atable = new ArrayList<Position>();
    //private int noOfPositions;
    // private int maxNoOfPos;
    //private int noInTable;
    protected String orderName;

    public Order(String orderName) {
        this.orderName = orderName;
       // maxNoOfPos = 10;
    }

 /*   public Order (int maxNoOfPos) {

    }*/

    public void addPosition (Position positionToAdd/*, int noInTable*/) {
/*        if (table[noInTable] != null) {
            if ((table[noInTable].productName).equals(positionToAdd.productName)) {
                table[noInTable].quantity += positionToAdd.quantity;
                System.out.println("Position has been updated. Quantity is bigger on " + positionToAdd.quantity);
            }
        }
            else {
                table[noInTable] = positionToAdd;*/
                atable.add(positionToAdd);
                System.out.println("Position " + atable.get(atable.indexOf(positionToAdd)).productName + " has been added");
            }
//    }

    double countValueOfOrder() {
        double SummaryOfValue = 0;
        for (int i = 0; i < atable.size(); i++) {
            SummaryOfValue += atable.get(i).value();
        }
        System.out.println("Count value for order is: " + SummaryOfValue);
        return SummaryOfValue;
    }

    public void DisplayOrder() {
        int i = 0;
        for (Position display : atable) {
            System.out.println("Position number " + i);
            display.form();
            i++;
        }
    }

    public void deletePosition(int noInTable) {
        Position deletedPos = new Position(0,"deleted position", 0,0);
        atable.remove(noInTable);
    }

    public void editPosition(int id, String name, int quantity_c, double price_c) {
        /*atable.g = */Position editPos1 = new Position(id, name, quantity_c, price_c);
    }

}
