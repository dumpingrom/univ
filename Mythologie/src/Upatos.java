/**
 * Classe Singleton Upatos
 * Cette classe contient un unique attribut statique,
 * instance, qui contiendra l'unique instance d'Upatos
 * qui peut etre creee dans le programme
 * @author romain
 *
 */
public class Upatos extends Dieu {
	private static Upatos instance = null;
	// a decommenter pour tester l'instanciation d'un Dieu par la classe Upatos
	// Dieu fauxDieu = new Dieu("Pouet", null, null);
	
	/**
	 * Constructeur de la classe Upatos
	 * Un super() est effectue avec trois arguments null
	 * Les donnees seront attribuees dans la methode statique bigbang()
	 * de la classe Origine grace aux setters herites de la classe Dieu
	 */
	private Upatos() {
		super(null, null, null);
	}
	
	/**
	 * Cette fonction permet de creer une instance de la classe
	 * Upatos que l'on place dans l'attribut instance si celle-ci n'existe pas
	 * et la retourne si l'instance a deja ete creee
	 * @return Upatos instance unique de la classe Upatos
	 */
	public static synchronized Upatos getInstance() {
		if(instance == null) {
			instance = new Upatos();
		}
		return instance;
	}
}
