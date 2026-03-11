import java.util.Arrays;

public class Order implements Displayable, Comparable<Order> {
    private OutputDevice od = new OutputDevice(System.out);
    private Customer customer;
    private Food [] foods;

    public Order(Customer customer, Food [] foods) {
        this.customer = customer;
        this.foods = foods;
    }


    public void validate() throws InvalidOrder {
        if (foods == null || foods.length == 0) {
            throw new InvalidOrder("Order must contain at least one food item.");
        }

        for (Food f : foods) {
            if (f.price < 0) {
                throw new InvalidOrder("Food item '" + f.getName() + "' has invalid price: " + f.price);
            }
        }
    }



    public double totalPrice() {
        double total = 0;
        for (Food food : foods) {
            if (food instanceof Packable p && p.hasPackaging()) {
                total += p.getTotalPrice();
            } else {
                total += food.price;
            }
        }
        return total;
    }



    @Override
    public String toString()
    {
        return  customer.toString() + ":" + Arrays.toString(foods) + "(total: $"+totalPrice()+")";

    }

    @Override
    public boolean detailsAreAvailable()
    {
        return true;
    }
    @Override
    public void showDetails() {
        od.writeMessage(toString());
    }
    @Override
    public int compareTo(Order other) {
        return Double.compare(this.totalPrice(), other.totalPrice());
    }

    public Customer getCustomer()
    {
        return customer;
    }

}
