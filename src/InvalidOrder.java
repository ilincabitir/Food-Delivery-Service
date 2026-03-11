public class InvalidOrder extends Exception {
    public InvalidOrder() {
        super("Invalid Order");

    }
    public InvalidOrder(String message) {
        super(message);
    }
}
