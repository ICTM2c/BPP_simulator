import java.util.ArrayList;

public class SimulatorGUI {

    public static void main(String[] args) {
        int size;
        ArrayList<Integer> array = new ArrayList<Integer>();

        for (int i = 1; i < 10 ; i++) {
            size = i + 20;
            System.out.println("Product" + i + ": " + size);
        }
    }

}
