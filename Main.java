import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size: ");
        int n = sc.nextInt();

        System.out.print("Enter number of Players: ");
        int numPlayers = sc.nextInt();
        sc.nextLine();

        Queue<Player> players = new LinkedList<>();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name of the " + (i + 1) + "th player: ");
            players.add(new Player(sc.nextLine()));
        }

        Board board = new Board(n);
        Dice dice = new Dice();
        Logger logger = new Logger();
        Game game = new Game(board, players, dice, logger);

        game.run();

        sc.close();
    }
}
