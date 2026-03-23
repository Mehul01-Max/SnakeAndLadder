import java.util.*;

public interface BoardFeatureGenerator<T> {
    Map<Integer, T> generate(int n, Set<Integer> usedIndices);
}