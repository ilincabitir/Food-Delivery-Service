public class Burger extends Food implements Packable{
  private boolean hasPickles;
  public Burger(String name, double price,boolean hasPickles) {
    super(name, price);
    this.hasPickles = hasPickles;
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
      String pickles = hasPickles ? "with pickles " : "";
      return name +" "+ pickles +"($" +getTotalPrice() +")";
  }



}
