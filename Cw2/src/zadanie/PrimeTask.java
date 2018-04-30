package zadanie;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa zadania liczenia liczb pierwszych z zadanego przedzialu
 * @author Rafal Wasik
 * 
 *
 */
public class PrimeTask implements Task<PrimeResult>
{
	private static final long serialVersionUID = 1L;
	private int min;
	private int max;
	
	/**
	 * Konsruktor zadania liczenia liczb pierwszych
	 * @param min - dolny granica przedzialu
	 * @param max - gorny granica przedzialu
	 */
	public PrimeTask (int min, int max)
	{
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Metoda zwraca wynik zadania w postaci obiektu klasy PrimeResult
	 * @return pr - obiekt zawieracjacy liste liczb pierwszych z przedzialu
	 */
	@Override
	public PrimeResult execute()
	{
		List<Integer> primeList = new ArrayList<Integer>();
		
		for (; min<= max; min++)  	   
	    { 		 		  
			int l = 0; 		  
	        for(int i=min; i>=1; i--)
	        {
	        	if(min%i==0)
	        		l++;
	        }
	        if (l ==2)
	        {
	        	primeList.add(min);
	        }	
	    }	
		
		PrimeResult pr = new PrimeResult();
		pr.primeList = primeList;
		return pr;
	}

}
