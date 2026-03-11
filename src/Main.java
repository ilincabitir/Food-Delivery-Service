import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileReaderDevice frd = new FileReaderDevice();
        List<Order> orders = frd.readOrders("Orders.txt");

        OutputDevice od = new OutputDevice("Orders.txt");
        OrderUtils ou = new OrderUtils();
        OutputDevice o = new OutputDevice(System.out);
        Scanner scanner = new Scanner(System.in);

        List<Order> newOrders;

        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Start a new order");
            System.out.println("2. Continue session");
            System.out.println("3. Show all orders");
            System.out.println("4. Exit");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":

                    newOrders = new ArrayList<>();
                    orders = new ArrayList<>();

                    System.out.println("Starting a new session...");


                    try {
                        File file = new File("orders.txt");
                        if (file.exists()) {
                            new FileWriter(file, false).close();
                            System.out.println("Previous order data cleared.");
                        }
                    } catch (IOException e) {
                        System.out.println("Error clearing file: " + e.getMessage());
                    }


                    Order newOrder = InputDevice.readOrderFromUser(scanner);
                    newOrders.add(newOrder);
                    orders.add(newOrder);


                    od.writeOrders(newOrders);


                    System.out.println("New order saved:");
                    System.out.println(newOrder);

                    break;



                case "2":
                    newOrders = new ArrayList<>();
                    System.out.println("Continuing session...");
                    boolean adding = true;
                    while (adding) {
                        Order nextOrder = InputDevice.readOrderFromUser(scanner);
                        newOrders.add(nextOrder);
                        orders.add(nextOrder);

                        System.out.println("Add another order? (y/n)");
                        adding = scanner.nextLine().trim().equalsIgnoreCase("y");
                    }
                    // append only new orders to file
                    od.writeOrders(newOrders);
                    break;

                case "3":
                    System.out.println("\n========= All Orders =========");
                    ou.printOrders(orders);
                    break;

                case "4":
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }


            if (args.length != 1) {
                o.writeMessage("Please provide one argument (c, o, go)");
                return;
            }


            switch (args[0]) {
                case "c":
                    ou.printCustomers(orders);
                    break;
                case "go":
                    ou.printGroupedOrders(orders);
                    break;
                default:
                    o.writeMessage("Invalid argument. Use c or go.");
            }

        }
    }
}
