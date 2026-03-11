import java.util.Scanner;

public class InputDevice {

    public static Order readOrderFromUser(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter customer name:");
                String customerName = scanner.nextLine().trim();
                Customer customer = new Customer(customerName);

                System.out.println("How many items in the order?");
                int n = Integer.parseInt(scanner.nextLine().trim());

                Food[] foods = new Food[n];
                for (int i = 0; i < n; i++) {
                    System.out.println("Enter food type (Burger, Soda, Pasta, Pizza):");
                    String type = scanner.nextLine().trim();

                    System.out.println("Enter food name:");
                    String name = scanner.nextLine().trim();

                    System.out.println("Enter price:");
                    double price = Double.parseDouble(scanner.nextLine().trim());

                    switch (type.toLowerCase()) {
                        case "burger":
                            System.out.println("With pickles? (true/false)");
                            boolean withPickles = Boolean.parseBoolean(scanner.nextLine().trim());
                            foods[i] = new Burger(name, price, withPickles);
                            break;
                        case "soda":
                            System.out.println("Enter volume in ml:");
                            int volume = Integer.parseInt(scanner.nextLine().trim());
                            System.out.println("Is it zero sugar? (true/false)");
                            boolean sugar = Boolean.parseBoolean(scanner.nextLine().trim());
                            foods[i] = new Soda(name, price, volume, sugar);
                            break;
                        case "pasta":
                            System.out.println("Enter type (carbonara, bolognese, macNCheese, chicken, pesto):");
                            Pasta.pastaType pastaType = Pasta.pastaType.valueOf(scanner.nextLine().trim());
                            foods[i] = new Pasta(name, price, pastaType);
                            break;
                        case "pizza":
                            System.out.println("Enter toppings separated by commas (pepperoni,corn,pepper,olives,mushrooms,ham,mozzarella):");
                            String[] toppingsStr = scanner.nextLine().trim().split(",");
                            Pizza.availableToppings[] toppings = new Pizza.availableToppings[toppingsStr.length];
                            for (int j = 0; j < toppingsStr.length; j++) {
                                toppings[j] = Pizza.availableToppings.valueOf(toppingsStr[j].trim());
                            }
                            foods[i] = new Pizza(name, price, toppings);
                            break;
                        default:
                            System.out.println("Unknown type, using generic food.");
                            foods[i] = new Food(name, price);
                    }
                }

                Order order = new Order(customer, foods);
                order.validate();
                return order;

            } catch (InvalidOrder e) {
                System.out.println("Invalid order: " + e.getMessage());
                System.out.println("Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number input. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid enum input. Please try again.");
            }
        }
    }
}
