package tree;
import java.util.Comparator;

public class Comperator implements Comparator<Node> {

    /**
     * Compares two nodes based on frequency from low to high.
     * @param _node1 The first node being compared.
     * @param _node2 The second node being compared.
     * @return -1, 0, or 1 depending on if the first node is less than, equal to, or greater than the
     * second node based on their frequency.
     */
    @Override
    public int compare(final Node node1, final Node node2) {

        if (node1.getFrequency() < node2.getFrequency()) {
            return -1;
        }
        else if (node1.getFrequency() > node2.getFrequency()) {
            return 1;
        }

        return 0;
    }
}