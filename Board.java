import java.util.*;

public class Board {
    private int n;
    private int totalCells;
    private Map<Integer, Snake> snakes = new HashMap<>();
    private Map<Integer, Ladder> ladders = new HashMap<>();

    public Board(int n) {
        this.n = n;
        this.totalCells = n * n;
        Set<Integer> usedIndices = new HashSet<>();
        this.snakes = new SnakeGenerator().generate(n, usedIndices);
        this.ladders = new LadderGenerator().generate(n, usedIndices);
    }

    public MoveResult getNewPosition(Player player, int roll) {
        int currPosition = player.getPosition();
        int nextPosition = currPosition + roll;
        if (nextPosition > totalCells)
            return new MoveResult(currPosition, roll, currPosition, MoveType.OVERSHOT);
        if (snakes.containsKey(nextPosition)) {
            Snake snake = snakes.get(nextPosition);
            return new MoveResult(currPosition, roll, snake.getTail(), MoveType.SNAKE);
        }
        if (ladders.containsKey(nextPosition)) {
            Ladder ladder = ladders.get(nextPosition);
            return new MoveResult(currPosition, roll, ladder.getEnd(), MoveType.LADDER);
        }
        return new MoveResult(currPosition, roll, nextPosition, MoveType.NORMAL);
    }

    public boolean isWinner(int position) {
        return position == totalCells;
    }

    public void printBoard() {
        System.out.println("\n--- Board Layout ---");
        System.out.println("Size    : " + n + " x " + n + " (" + totalCells + " cells)");
        System.out.println("Snakes  : " + snakes.values().stream()
                .map(s -> s.getHead() + "->" + s.getTail())
                .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b));
        System.out.println("Ladders : " + ladders.values().stream()
                .map(l -> l.getStart() + "->" + l.getEnd())
                .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b));
        System.out.println("--------------------\n");
    }

    public int getTotalCells() {
        return this.totalCells;
    }
}