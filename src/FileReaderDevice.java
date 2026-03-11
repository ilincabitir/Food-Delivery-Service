import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderDevice {

    public List<Order> readOrders(String filename) {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(":\\[|\\]\\(total:");
                if (parts.length >= 2) {
                    String customerName = parts[0].trim();
                    String foodsPart = parts[1].trim();
                    Customer customer = new Customer(customerName);

                    String[] foodNames = foodsPart.split(",");
                    List<Food> foods = new ArrayList<>();
                    for (String f : foodNames) {
                        f = f.trim();
                        // parse name and price from format "name ($price)"
                        int priceStart = f.lastIndexOf("($");
                        int priceEnd = f.lastIndexOf(")");
                        if (priceStart != -1 && priceEnd != -1) {
                            String name = f.substring(0, priceStart).trim();
                            double price = Double.parseDouble(f.substring(priceStart + 2, priceEnd));
                            foods.add(new Food(name, price));
                        } else {
                            foods.add(new Food(f, 0));
                        }
                    }

                    orders.add(new Order(customer, foods.toArray(new Food[0])));
                }
            }
        } catch (IOException e) {
            System.out.println("File not found or empty. Starting fresh.");
        }

        return orders;
    }
}

