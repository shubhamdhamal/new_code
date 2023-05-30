import java.rmi.*;
import java.rmi.registry.*;

public class Server{
	public static void main(String args[]){
		try{
			Add obj=new AddImpl();
			Naming.rebind("rmi://localhost/guru",obj);
			System.out.println("Server Started");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}