package zadanie;

import java.io.Serializable;

/**
 * Interfejs zadania do wykonania 
 * @author Rafal Wasik
 * 
 * @param <T> - Klasa wyniku zadania
 */
public interface Task<T> extends Serializable
{
	/**
	 * Metoda wykonania zadania
	 * @return Wynik zadania
	 */
	T execute();
}
