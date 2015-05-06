/**
 * Classe Singleton Upatos
 * @author romain
 *
 */
public class Upatos extends Dieu {
	private static Upatos instance = null;
	private String nom;
	
	private Upatos() {
		super(null, null, null);
	}
	
	public static synchronized Upatos getInstance() {
		if(instance == null) {
			instance = new Upatos();
		}
		return instance;
	}
}
