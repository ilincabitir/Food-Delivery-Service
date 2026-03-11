public class Pizza extends Food implements Packable{
    enum availableToppings {
        pepperoni,
        corn,
        pepper,
        olives,
        mushrooms,
        ham,
        mozzarella,
    }

    private availableToppings[] Toppings;
    public Pizza (String name, double price,availableToppings[] Toppings) {
        super(name, price);
        this.Toppings = Toppings;
    }

    @Override
    public boolean hasPackaging() {
        return true;
    }
    @Override
    public double getPriceOfPackaging() {
        return 0.5;

    }
    @Override
    public void addPriceOfPackaging(){
        this.price+=getPriceOfPackaging();
    }
    @Override
    public double getTotalPrice() {
        return price + getPriceOfPackaging();
    }


    @Override
    public String toString()
    {
        String s = "";
        for (availableToppings t : Toppings) {
            s += t.toString() + ", ";
        }
        if (!s.isEmpty()) {
            s = s.substring(0, s.length() - 2);
        }
        return name + " with " + s + " ($" + getTotalPrice() + ")";
    }


}
