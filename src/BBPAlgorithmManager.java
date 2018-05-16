import java.util.List;

public class BBPAlgorithmManager {

    private List<BBPAlgorithm> Algorithms;

    public List<Box> runSimulation(int capacity, List<Product> products) {
        for (BBPAlgorithm alg : Algorithms) {
            alg.simulate(capacity, products);
        }
        return null;
    }

    public void writeResult() {
        //!!
    }
}
