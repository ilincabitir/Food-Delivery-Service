public class Pasta extends Food implements Packable{
    enum pastaType{
        carbonara,
        bolognese,
        macNCheese,
        chicken,
        pesto,
    }

    private pastaType type;

    public Pasta (String name, double price, pastaType type){
        super(name,price);
        this.type = type;
    }

    @Override
    public boolean hasPackaging() {
        return true;
    }
    @Override
    public double getPriceOfPackaging() {
        return 1;

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
    public String toString() {

        return name +" "+ type +"($" +getTotalPrice() +")";
    }

}
