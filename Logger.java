import java.util.*;

public class Logger {

    public void logTurn(Player player, MoveResult move) {
        System.out.println(player.getName() + " (pos " + move.startPos + ") rolled " + move.rolled);
        if (move.type == MoveType.OVERSHOT) {
            System.out.println(" OVERSHOT stays at " + move.startPos);
            return;
        } else if (move.type == MoveType.SNAKE) {
            System.out.println(" Snake! Slide from " + (move.startPos + move.rolled) + " down to " + move.finalPos);
            return;
        } else if (move.type == MoveType.LADDER) {
            System.out.println(" Ladder! Climbs from " + (move.startPos + move.rolled) + " up to " + move.finalPos);
            return;
        }
        System.out.println(" Moves from " + move.startPos + " to " + move.finalPos);
    }

    public void logWinner(Player player, List<Player> leaderboard) {
        System.out.println(player.getName() + " wins! (#" + leaderboard.size() + ")");
    }

    public void logResult(List<Player> leaderboard) {
        System.out.println("==== Final Result ====");

        for (int i = 0; i < leaderboard.size(); i++) {
            System.out.println("#" + (i + 1) + " " + leaderboard.get(i).getName());
        }
    }
}