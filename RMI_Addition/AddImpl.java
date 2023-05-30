import java.rmi.*;
import java.rmi.server.*;

public class AddImpl extends UnicastRemoteObject implements Add {
	AddImpl() throws RemoteException{
	super();
	}
	public int add(int a,int b){
	return a+b;
	}
}