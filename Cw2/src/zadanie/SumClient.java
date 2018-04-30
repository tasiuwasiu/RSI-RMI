package zadanie;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SumClient
{
	 public static void main(String args[]) 
	 {
		if (args.length == 0)
		{
			System.out.println("Brak adresu rejestru!");
			return;
		}
		
		if (System.getSecurityManager() == null) 
	    {
			System.setSecurityManager(new SecurityManager());
	    }
	    try 
	    {
	    	String name1 = "Worker1";
	        String name2 = "Worker2";
	        Registry registry = LocateRegistry.getRegistry(args[0]);
	        Server comp1 = (Server) registry.lookup(name1);
	        Server comp2 = (Server) registry.lookup(name2);
	        SumTask task1 = new SumTask(10,20);
	        SumTask task2 = new SumTask(20,50);
	        SumResult res1 = comp1.execute(task1);
	        SumResult res2 = comp2.execute(task2);
	        System.out.println("Jeden: " + res1.result + " ,dwa: " + res2.result);
	    } 
	    catch (Exception e) 
	    {
	       System.err.println("Blad klienta!");
	       e.printStackTrace();
	    }
	 }    
}
