package zadanie;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Klasa pracownika, wykonujaca zadania
 * @author Rafal Wasik
 * 
 *
 */
public class Worker implements Server
{
	/**
	 * Metoda wykonuje podane zadanie
	 * @param t - Zadanie do wykonania
	 * @return Wynik zadania
	 */
	@Override
	public <T> T execute(Task<T> t) throws RemoteException
	{
		return t.execute();
	}
	
	/**
	 * Metoda tworzaca oraz przypisujaca pracownika do serwera
	 * @param args - Tabela String zawierajaca nazwe pracownika
	 */
	public static void main(String[] args) 
	{
		if (args.length == 0)
		{
			System.out.println("Brak nazwy pracownika!");
			return;
		}
		if (System.getSecurityManager() == null) 
	    {
	        System.setSecurityManager(new SecurityManager());
	    }
	    try 
	    {
	    	String name = args[0];
	        Server worker = new Worker();
	        Server stub = (Server) UnicastRemoteObject.exportObject(worker, 0);
	        Registry reg = LocateRegistry.getRegistry();
	        reg.rebind(name, stub);
	        System.out.println("Uruchomiono pracownika: " + name);
	    } 
	    catch (Exception e) 
	    {
	    	System.err.println("Blad pracownika!");
	        e.printStackTrace();
	    }
	}
}
