import java.util.*;

public class LadderGenerator implements BoardFeatureGenerator<Ladder> {
    public Map<Integer, Ladder> generate(int n, Set<Integer> usedIndices) {
        Map<Integer, Ladder> ladders = new HashMap<>();
        int totalCells = n * n;
        Random rnd = new Random();
        while (ladders.size() < n) {
            int start = rnd.nextInt(totalCells) + 1;
            if (usedIndices.contains(start))
                continue;
            int rowOfStart = (start - 1) / n;
            int firstCellOfRowAbove = (rowOfStart + 1) * n + 1;
            if (totalCells - firstCellOfRowAbove + 1 <= 0)
                continue;
            int end = rnd.nextInt(totalCells - firstCellOfRowAbove + 1) + firstCellOfRowAbove;
            if (usedIndices.contains(end))
                continue;
            usedIndices.add(start);
            usedIndices.add(end);
            ladders.put(start, new Ladder(start, end));
        }
        return ladders;
    }
}
