public class Food {

    protected String name;
    protected double price;

    Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;

    }


    public void setPrice(double price) {
        this.price = price;
    }

  @Override
    public String toString()
    {
        return name + " $" + price ;
    }




}
