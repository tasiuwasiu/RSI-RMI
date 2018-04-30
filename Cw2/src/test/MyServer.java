package test;

public class MyServer
{
	public static void main (String[] args)
	{
		if (args.length == 0)
		{
			System.out.println("You have to enter RMI object address in the form: ");
			return;
		}
		
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		
		try
		{
			CalcObjImpl implObiektu = new CalcObjImpl();
			java.rmi.Naming.rebind(args[0], implObiektu);
			CalcObjImpl2 implObiektu2 = new CalcObjImpl2();
			java.rmi.Naming.rebind(args[1], implObiektu2);
			System.out.println("Server is registered now");
			System.out.println("Ctrl+C to stop");
		}
		catch (Exception e)
		{
			System.out.println("Error registering");
			e.printStackTrace();
			return;
		}
	}
}
