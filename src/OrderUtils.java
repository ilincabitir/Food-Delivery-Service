import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class OrderUtils {
    private InputDevice id =  new InputDevice();
    private OutputDevice od =  new OutputDevice(System.out);


    public static List<Customer> sortCustomersByName(List<Order> orders) {
        return orders.stream()
                .map(Order::getCustomer)
                .collect(Collectors.toCollection(() -> new TreeSet<>()))
                .stream()
                .toList();
    }

    public void printCustomers (List<Order> orders)
    {
        od.writeMessage("=========Customers sorted by name=========");
        sortCustomersByName(orders).forEach(c->c.showDetails());

    }

   public static List <Order> sortOrdersByPrice(List<Order> orders)
   {
       return orders.stream().sorted().toList();
   }

   public void printOrders (List<Order> orders)
   {
       od.writeMessage("=========Orders sorted by total price=========");
       sortOrdersByPrice(orders).forEach(o->o.showDetails());
   }

   public static Map<String,List<Order>> groupOrdersByCustomer(List<Order> orders)
   {
       return orders.stream().collect(Collectors.groupingBy(o->o.getCustomer().getName()));
   }



    public void printGroupedOrders(List<Order> orders) {
        od.writeMessage("=========Orders Grouped by Customer=========");

        groupOrdersByCustomer(orders).forEach((name, customerOrders) -> {
                    od.writeMessage(name + " has " + customerOrders.size() + " order(s):");
                    customerOrders.forEach(o ->  o.showDetails());
            });
    }




}
