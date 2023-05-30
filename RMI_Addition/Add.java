import java.rmi.*;

public interface Add extends Remote{
	public int add(int a,int b) throws RemoteException;
}