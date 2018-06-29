package JanKozak7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {

    private int id;
    private int choice0;  // I did so many choice variables to do not mistake in a code
    private int choice1;
    private int choice2;
    private String choice21;
    private int choice22p;
    private int choice22o;
    private int choice22n;
    private int choice23;
    private int choice24;
    private int choice25;
    private int choice26;
    private int choice11q;
    private String choice11n;
    private double choice11p;
    private int choice23o;
    private int choice24o;
    private int choice25o;
    private int choice26o;
    private String choice23np;
    private Position tempPos;
    private int choice24np;
    private int choice25np;
    private int choice26np;
    private int choice23q;
    private double choice23p;
    private int choice23pp;
    private int choice23ppq;
    private double choice23ppp;
    private int choice23id;
    private ArrayList<Position> listPositions = new ArrayList<Position>();
    private ArrayList<Order> listOrders = new ArrayList<Order>();
    private ArrayList<Position> arrayInner = new ArrayList<Position>();

    menu() {
        System.out.println("This is a program where you can create orders with positions, their quantity and unit price, as also save and read orders from *.txt files\nTo exit a program press 0");
        do {
            Scanner scan1 = new Scanner(System.in);
            System.out.println("Which you want to create? Press a number. \n 1. Position \n 2. Order");
            choice0 = scan1.nextInt();
            if (choice0 == 1) {
                System.out.println("Select an option: \n 1. Create a position \n 2. Count value of position");
                choice1 = scan1.nextInt();
                if (choice1 == 1) {
                    id++;
                    System.out.println("Enter a name e.g. carrot");
                    choice11n = scan1.next();
                    System.out.println("Enter a quantity e.g. 7");
                    choice11q = scan1.nextInt();
                    System.out.println("Enter a price e.g. 0,85 - use a comma to seperate decimal numbers"); // why not a dot sign '.' to seperate decimal numbers?
                    try {
                        choice11p = scan1.nextDouble();
                    } catch (InputMismatchException ex) {
                        System.out.println("InputMismatchException has shown");
                    }
                    Position pos1 = new Position(id, choice11n, choice11q, choice11p);
                    pos1.form();
                    listPositions.add(pos1);
                    System.out.println("You have just added a new position");
                }
                if (choice1 == 2) {
                    System.out.println("Enter a number of position from a list below");
                    for (int i = 0; i < listPositions.size(); i++)
                    System.out.println(i + "." + listPositions.get(i).productName);
                    listPositions.get(scan1.nextInt()).value();
                }
            }
            if (choice0 == 2) {
                System.out.println("Select an option: \n 1. Create an order \n 2. Add a position \n 3. Edit a position \n 4. Delete a position \n 5. Display an order \n 6. Count value of an order");
                choice2 = scan1.nextInt();
                if (choice2 == 1) {
                    System.out.println("Enter a name of an order");
                    choice21 = scan1.next();
                    Order ord1 = new Order(choice21);
                    listOrders.add(ord1);
                }
                if (choice2 == 2) {
                    System.out.println("Enter a number of postion from a list below");
                    for (int i = 0; i < listPositions.size(); i++)
                        System.out.println(i + ". " + listPositions.get(i).productName);
                    choice22p = scan1.nextInt();
                    System.out.println("Enter a number of an order from a list below");
                    for (int i = 0; i < listOrders.size(); i++)
                        System.out.println(i + ". " + listOrders.get(i).orderName);
                    choice22o = scan1.nextInt();
                    //System.out.println("Enter a number you want to put a position in a table");
                    //choice22n = scan1.nextInt();
                    listOrders.get(choice22o).addPosition(listPositions.get(choice22p));
                    arrayInner.add(listPositions.get(choice22p));
                    //listPosInOrd.add(arrayInner);
                    System.out.println("A position " + choice22p + " has been added to an order " + choice22o);
                }
                if (choice2 == 3) {
                    /*try {*/
                    int c;
                        System.out.println("Enter a number of an order to choose a position to edit from a list below");
                        for (int i = 0; i < listOrders.size(); i++)
                            System.out.println(i + ". " + listOrders.get(i).orderName);
                        choice23o = scan1.nextInt();
                        try {
                            System.out.println("Enter a name of position you want to edit from a list below with first uppercase letter");
                            listOrders.get(choice23o).DisplayOrder();
                            choice23np = scan1.next();
                        }
                        catch(NullPointerException npe) {
                            System.out.println("You have to put a name from a list!");
                        }
                        for (int i = 0; i < listPositions.size(); i++) {
                            if ((listPositions.get(i).productName).equals(choice23np)) {
                                tempPos = listPositions.get(i);
                                break;
                            }
                            else
                                System.out.println("There is no such a product name in a list. Check uppercase letters");
                        }
                        System.out.println("Which parametr of position you want to change. Select a number of a parametr \n 1. Quantity \n 2. Price of a product");
                        choice23pp = scan1.nextInt();
                        if (choice23pp == 1) {
                            System.out.println("Enter a new quantity");
                            choice23ppq = scan1.nextInt();
                            Position tempQ = new Position(tempPos.id, tempPos.productName, choice23ppq, tempPos.price);
                            listPositions.remove(tempPos);
                            listPositions.add(tempQ);
                            listOrders.get(choice23o).addPosition(tempQ);
                            //listOrders.get(choice23o).editPosition(tempPos.id, tempPos.productName, choice23ppq, tempPos.price);
                            //Position editPos = new Position;
                            //listOrders.get(choice23o).addPosition(editPos);
                            //listOrders.get(choice23o).deletePosition(tempPos);
                        }
                        if (choice23pp == 2) {
                            System.out.println("Enter a price using comma e.g. 5,8");
                            choice23ppp = scan1.nextDouble();
                            listOrders.get(choice23o).editPosition(tempPos.id, tempPos.productName, tempPos.quantity, choice23ppq);
                        }
                    /*}
                    catch(NullPointerException npe) {
                        npe.printStackTrace();
                    }*/
                      /*  System.out.println("Enter a number id");
                        choice23id = scan1.nextInt();
                        System.out.println("Enter a name");

                        System.out.println("Enter a number of a quantity");
                        choice23q = scan1.nextInt();
                        System.out.println("Enter a price with comma e.g. 2,5");
                        choice23p = scan1.nextDouble();
                        //listOrders.get(choice23o).editPosition(choice23np, );*/
                }
                if (choice2 == 4) {
                    System.out.println("Enter a number of an order to choose a position to delete from a list below");
                    for (int i = 0; i < listOrders.size(); i++)
                        System.out.println(i + ". " + listOrders.get(i).orderName);
                    try {
                        choice24o = scan1.nextInt();
                    }
                    catch(IndexOutOfBoundsException ioobe) {
                        System.out.println("You have to choose a proper number of an order from a list");
                    }
                    System.out.println("Enter a name of position you want to delete from a list below");
                    listOrders.get(choice24o).DisplayOrder();
                   /* for (int i = 0; i < listOrders.size(); i++)
                        System.out.println(i + ". " + listOrders.get(i).orderName);*/
                    choice24np = scan1.nextInt();
                    listOrders.get(choice24o).deletePosition(choice24np);
                    System.out.println("Position has been deleted");
                }
                if (choice2 == 5) {
                    System.out.println("Enter a number of an order to display");
                    for (int i = 0; i < listOrders.size(); i++)
                        System.out.println(i + ". " + listOrders.get(i).orderName);
                    choice25o = scan1.nextInt();
                    listOrders.get(choice25o).DisplayOrder();
                }
                if (choice2 == 6) {
                    System.out.println("Enter a number of an order to count a value");
                    for (int i = 0; i < listOrders.size(); i++)
                        System.out.println(i + ". " + listOrders.get(i).orderName);
                    choice26o = scan1.nextInt();
                    listOrders.get(choice26o).countValueOfOrder();
                }

            }
            System.out.println("\n---------------");
            System.out.println("You can create another orders with positions, their quantity and unit price, as also save and read orders from *.txt files\nTo exit a program press 0");
            System.out.println("The program has been finished");
        }
        while (choice0 != 0);
    }
}
