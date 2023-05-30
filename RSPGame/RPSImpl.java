import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RPSImpl extends UnicastRemoteObject implements RPSInterface {
    private int numPlayers;
    private boolean ready;
    private int[] moves;
    private boolean flag;

    public RPSImpl() throws RemoteException {
        super();
        numPlayers = 0;
        ready = false;
	flag=false;
        moves = new int[2];
    }

    public int register() throws RemoteException {
        System.out.println("Player " + (numPlayers + 1) + " joined the game.");
        numPlayers++;
        if (numPlayers == 2) {
            ready = true;
            System.out.println("Both players are ready.");
        }
        return numPlayers;
    }

    public boolean allPlayersReady() throws RemoteException {
        System.out.println("Checking if both players are ready.");
        return ready;
    }
    public boolean play(int playerId, int move) throws RemoteException {
        if (moves[playerId - 1] == 0) {
            moves[playerId - 1] = move;
            System.out.println("Player " + playerId + " played " + move + ".");
            return true;
        } else {
            System.out.println("Player " + playerId + " already played.");
            return false;
        }
    }
public boolean isallPlayersPlayed() throws RemoteException {
if(moves[0]!=0 && moves[1]!=0){
	flag=true;
	}
        System.out.println("Checking if both players are played.");
        return flag;
    }
    public int getResult(int playerId) throws RemoteException {
        //int otherPlayerId = 3 - playerId;
        int result;
        if (moves[0]==moves[1]) {
            System.out.println("It's a tie!");
	    return 0;
        } 
	else if((moves[0]==3 &&moves[1]==2)||(moves[0]==2 &&moves[1]==1)||(moves[0]==1 &&moves[1]==2)){
            System.out.println("Player " + 1 + " wins!");
	    return 1;
        }
       else{
	     System.out.println("Player " + 2 + " wins!");
	    return 2;
	}
    }
}
