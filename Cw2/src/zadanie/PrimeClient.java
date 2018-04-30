package zadanie;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Klasa klienta, jako wynik pracy drukuje liczby pierwsze z przedzialu
 * @author Rafal Wasik
 * 
 *
 */
public class PrimeClient
{
	/**
	 * Glowna metoda klienta, wykonujaca zadanie na podanej liczbie pracownikow
	 * @param args - Tabela String zawierajaca adres serwera, liczbe pracownikow, dolny zakres oraz gorny zakres przedzialu
	 */
	 public static void main(String args[]) 
	 {
		if (args.length < 4)
		{
			System.out.println("Blednie podane argumenty!");
			return;
		}
		
		if (System.getSecurityManager() == null) 
	    {
			System.setSecurityManager(new SecurityManager());
	    }
	    try 
	    {
	    	int workerNumber = Integer.parseInt(args[1]);
	    	int min = Integer.parseInt(args[2]);
	    	int max = Integer.parseInt(args[3]);
	    	int przedzial = (max-min)/workerNumber;
	    	PrimeTask[] tasks = new PrimeTask[workerNumber];
	    	PrimeResult[] results = new PrimeResult[workerNumber];
	    	Registry registry = LocateRegistry.getRegistry(args[0]);
	    	Server[] workers = new Server[workerNumber];
	    	for (int i=0; i<workerNumber; i++)
	    	{
	    		String name = "Worker" + (i+1);
	    		workers[i] = (Server) registry.lookup(name);
	    		if(i==0)
	    		{
	    			tasks[i]= new PrimeTask(min, min+ (i+1)*przedzial);
	    		}
	    		if(i==workerNumber)
	    		{
	    			tasks[i] = new PrimeTask(min+(i*przedzial),max);
	    		}
	    		else
	    		{
	    			tasks[i] = new PrimeTask (min+(i*przedzial), min+(i+1)*przedzial);
	    		}
	    	}
	    	
	    	for (int i=0; i<workerNumber; i++)
	    	{
	    		results[i] = workers[i].execute(tasks[i]);
	    		for (Integer e:results[i].primeList)
	    		       System.out.println(e);
	    	}
	    		
	    } 
	    catch (Exception e) 
	    {
	       System.err.println("Blad klienta!");
	       e.printStackTrace();
	    }
	 }    
}
