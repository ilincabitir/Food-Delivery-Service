import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class OutputDevice {

    private OutputStream os;
    private String filename;

    public OutputDevice(OutputStream os) {
        this.os = os;
    }

    public OutputDevice(String filename) {
        this.filename = filename;
    }

    public void writeMessage(String s) {
        try {
            if (os != null) {
                os.write((s + "\n").getBytes());
            } else if (filename != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                    writer.write(s);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public void writeOrders(List<Order> orders) {
        if (filename == null) return;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (Order o : orders) {
                writer.write(o.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
