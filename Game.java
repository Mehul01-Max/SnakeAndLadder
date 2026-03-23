import java.util.*;

public class Game {
    Board board;
    Queue<Player> players;
    Dice dice;
    Logger logger;
    List<Player> leaderboard = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Game(Board board, Queue<Player> players, Dice dice, Logger logger) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.logger = logger;
    }

    void run() {
        System.out.println("=== Game Start ===");
        board.printBoard();
        while (players.size() > 1) {
            Player player = players.poll();
            takeTurn(player);
            if (board.isWinner(player.getPosition())) {
                leaderboard.add(player);
                logger.logWinner(player, leaderboard);
            } else {
                players.add(player);
            }
        }
        leaderboard.add(players.poll());

        logger.logResult(leaderboard);
    }

    void takeTurn(Player player) {
        // System.out.println(" it's " + player.getName() + " turn press any key to
        // roll");
        // sc.nextLine();
        int roll = dice.roll();
        MoveResult moveResult = board.getNewPosition(player, roll);
        logger.logTurn(player, moveResult);
        player.setPosition(moveResult.finalPos);
    }

}
