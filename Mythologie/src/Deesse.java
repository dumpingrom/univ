/**
 * Classe Deesse heritiere de Dieu
 * @author romain
 *
 */
public class Deesse extends Dieu {

	/**
	 * Constructeur de la classe Deesse avec super() sur le constructeur herite
	 * @param n String le nom de la Deesse
	 * @param p Dieu le pere de la Deesse
	 * @param m Deesse la mere de la Deesse
	 */
	public Deesse(String n, Dieu p, Deesse m) {
		super(n, p, m);
	}

}