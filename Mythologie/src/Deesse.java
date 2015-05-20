/**
 * Classe Deesse heritiere de Dieu
 * @author romain
 *
 */
public class Deesse extends Dieu {
	
	// a decommenter pour tester la creation d'un Dieu au sein d'une classe heritiere de Dieu
	// Deesse testFauxDieu = new Deesse(null, "Youpi", null, null);

	/**
	 * Constructeur de la classe Deesse avec super() sur le constructeur herite
	 * @param n String le nom de la Deesse
	 * @param p Dieu le pere de la Deesse
	 * @param m Deesse la mere de la Deesse
	 */
	public Deesse(Object c, String n, Dieu p, Deesse m) {
		super(c, n, p, m);
	}

}
