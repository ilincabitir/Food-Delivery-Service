public class Soda extends Food{
    private boolean isZeroSugar;
    int quantityInML;
    public Soda(String name,double price, int quantityInMl,boolean isZeroSugar ) {
        super(name,price);
        this.quantityInML = quantityInMl;
        this.isZeroSugar = isZeroSugar;

    }

    @Override
    public String toString() {
        String sugar = isZeroSugar ? "with zero sugar " : "";

        return name +" "+ quantityInML +"ml" +"($" +price +")";
    }
}
