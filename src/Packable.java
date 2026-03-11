public interface Packable {
    boolean hasPackaging();
    double getPriceOfPackaging();
    void addPriceOfPackaging();
    double getTotalPrice();
}
