public class Customer implements Displayable, Comparable<Customer>{
    private OutputDevice od = new OutputDevice(System.out);
    private String name;

    public Customer(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Customer other) {
        return this.name.compareToIgnoreCase(other.name);

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


}
