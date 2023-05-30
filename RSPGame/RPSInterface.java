import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RPSInterface extends Remote {
    int PLAYERS_NUM = 2;
    int ROCK = 1;
    int PAPER = 2;
    int SCISSORS = 3;
    
    int register() throws RemoteException;
    boolean play(int playerId, int move) throws RemoteException;
    boolean allPlayersReady() throws RemoteException;
    boolean isallPlayersPlayed() throws RemoteException;
    int getResult(int playerId) throws RemoteException;
}
