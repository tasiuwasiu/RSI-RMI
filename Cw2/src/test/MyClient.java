package test;

public class MyClient
{
	
	public static void main (String[] args)
	{
		double wynik;
		CalcObject zObiekt;
		CalcObject2 zObiekt2;
		ResultType wynik2;
		InputType inObj;
		
		inObj = new InputType();
		inObj.x1 = 3.0;
		inObj.x2 = 4.0;
		inObj.operation = "add";
		
		if (args.length == 0)
		{
			System.out.println("You have to enter RMI objet");
			return;
		}
		
		String adres = args[0];
		String adres2 = args[1];
		/*
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		*/
		
		try
		{
			zObiekt = (CalcObject) java.rmi.Naming.lookup(adres);
			zObiekt2 = (CalcObject2) java.rmi.Naming.lookup(adres2);
		}
		catch (Exception e)
		{
			System.out.println("Nie mozna pobrac referencji");
			e.printStackTrace();
			return;
		}
		
		System.out.println("Referencja jest pobrana");
		
		try
		{
			wynik = zObiekt.calculate(1.1, 2.2);
			wynik2 = zObiekt2.calculate(inObj);
		}
		catch (Exception e)
		{
			System.out.println("Blad zdalnego wykonywania");
			e.printStackTrace();
			return;
		}
		
		System.out.println("Wynik = " + wynik);
		System.out.println("wynik2 =" + wynik2.result);
		return;
	}

}
