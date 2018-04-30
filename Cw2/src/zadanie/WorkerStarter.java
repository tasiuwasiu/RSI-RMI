package zadanie;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Klasa inicjalizuje wybrana ilosc pracownikow
 * @author Rafal Wasik
 * 
 *
 */
public class WorkerStarter
{
	/**
	 * Metoda main inicjalizujaca oraz przypisujaca pracownikow do serwera
	 * @param args - Tabela String zawierajaca ilosc pracownikow do utworzenia
	 */
	public static void main(String[] args) 
	{
		Registry reg;
		
		if (args.length == 0)
		{
			System.out.println("Brak liczby pracownikow!");
			return;
		}
		if (System.getSecurityManager() == null) 
	    {
	        System.setSecurityManager(new SecurityManager());
	    }
		try
		{
			 reg = LocateRegistry.createRegistry(1099);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	    try 
	    {
	    	int workersNumber = Integer.parseInt(args[0]);
	    	String[] name = new String [workersNumber];
	        Server[] workers = new Worker[workersNumber];
	        Server[] stubs = new Server[workersNumber];
	        reg = LocateRegistry.getRegistry();
	        for (int i=0; i<workersNumber; i++)
	        {
	        	workers[i] = new Worker();
	        	name[i] = "Worker"+(i+1);
	        	reg = LocateRegistry.getRegistry();
	        	stubs[i] = (Server) UnicastRemoteObject.exportObject(workers[i], 0);
	        	reg.rebind(name[i], stubs[i]);
	        }
	        
	        System.out.println("Uruchomiono pracownikow");
	    } 
	    catch (Exception e) 
	    {
	    	System.err.println("Blad pracownika!");
	        e.printStackTrace();
	    }
	}
}
