import java.util.*;

public class SnakeGenerator implements BoardFeatureGenerator<Snake> {

    public Map<Integer, Snake> generate(int n, Set<Integer> usedIndices) {
        HashMap<Integer, Snake> snakes = new HashMap<>();
        Random rnd = new Random();
        int totalCells = n * n;
        while (snakes.size() < n) {

            int tail = rnd.nextInt(totalCells) + 1;
            if (usedIndices.contains(tail))
                continue;
            int rowOfTail = (tail - 1) / n;
            int firstCellOfRowAbove = (rowOfTail + 1) * n + 1;
            if (totalCells - firstCellOfRowAbove + 1 <= 0)
                continue;
            int head = rnd.nextInt(totalCells - firstCellOfRowAbove) + firstCellOfRowAbove;
            if (usedIndices.contains(head))
                continue;
            usedIndices.add(head);
            usedIndices.add(tail);
            snakes.put(head, new Snake(head, tail));
        }
        return snakes;
    }

}
