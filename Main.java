package JanKozak7;

import java.io.*;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu men1 = new menu();
//        Position carrot = new Position(1, "carrot", 3, 2.5);
//        Position potato = new Position(2, "potato", 5, 1.0);
//        carrot.form();
//        potato.form();
//        Order zam = new Order();
//        Order zama = new Order(3);
//        System.out.println("ORDER: " + zam);
//        zam.addPosition(carrot, 0);
//        zam.addPosition(potato, 1);
//        System.out.println("ORDER: " + zam);
//        zam.countValueOfOrder();
//        zam.DisplayOrder();
//        //zam.deletePosition(0);
//        zam.editPosition(1, 2, "tomato", 8, 0.9);
//        System.out.println("-------------------");
//        zam.DisplayOrder();
//        System.out.println("-------------------");
//        Position carrot1 = new Position(3, "carrot", 2, 2.5);
//        zam.addPosition(carrot1, 0);
//        System.out.println("-------------------");
//        zam.DisplayOrder();
//        System.out.println("-------------------");
//        carrot.discount();
//        System.out.println("-------------------");
//        zam.countValueOfOrder();
//        carrot.form();
//        System.out.println("///////////");
        //SaveOrder(zam, "zamowienie");
        //ReadOrder("zamowienie");
    }


    public static void SaveOrder(Order o, String FileName) {
        try {
            FileOutputStream FileOS = new FileOutputStream(FileName);
            ObjectOutputStream ObjectOS = new ObjectOutputStream(FileOS);
            ObjectOS.writeObject(o);
            ObjectOS.close();
            System.out.println("Object has been saved");
        } catch (IOException e) {
            System.out.println("Saving a file did not successed");
            e.printStackTrace();
        }
    }

    public static void ReadOrder(String FileName) {
        try {
            FileInputStream FileIS = new FileInputStream(FileName);
            ObjectInputStream ObjectIS = new ObjectInputStream(FileIS);
            Object objIS = ObjectIS.readObject();
            Order orderIS = (Order) objIS;
            ObjectIS.close();
            System.out.println("Object has been read");
            orderIS.DisplayOrder();
        } catch (IOException ioe) {
            System.out.println("Reading a file did not successed");
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Class has not been found");
        }
    }
}
