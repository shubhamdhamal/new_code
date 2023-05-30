import java.rmi.Naming;
import java.util.Scanner;

public class RPSClient {
    public static void main(String[] args) {
        try {
            RPSInterface game = (RPSInterface) Naming.lookup("rmi://localhost/RPSGame");
            int playerId = game.register();
            System.out.println("You are player " + playerId + ".");
            Scanner scanner = new Scanner(System.in);
            while (!game.allPlayersReady()) {
                System.out.println("Waiting for other player...");
                Thread.sleep(1000);
            }
            System.out.println("Both players are ready. Enter your move (1=rock, 2=paper, 3=scissors):");
            int move = scanner.nextInt();
            boolean success = game.play(playerId, move);
            while (!success) {
                System.out.println("You already played. Enter your move again:");
                move = scanner.nextInt();
                success = game.play(playerId, move);
            }
		while (!game.isallPlayersPlayed()) {
                System.out.println("Waiting for other player to play...");
                Thread.sleep(1000);
            }
            int result = game.getResult(playerId);
            if (result == 0) {
                System.out.println("It's a tie!");
            } else {
                System.out.println("Player " + result + " wins!");
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
