import java.rmi.*;

public class Client{
	public static void main(String args[]){
		try{
			Add obj=(Add)Naming.lookup("rmi://localhost/guru");
			System.out.println(obj.add(5,7));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}