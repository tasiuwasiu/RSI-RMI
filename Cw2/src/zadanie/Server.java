package zadanie;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfejs pracownika
 * @author Rafal Wasik
 * 
 */
public interface Server extends Remote
{
	/**
	 * Metoda wykonujaca zadanie
	 * @param t - zadanie do wykonania
	 * @return wynik zadania
	 * @throws RemoteException - blad wykonania
	 */
	<T> T execute(Task<T> t) throws RemoteException;
}
