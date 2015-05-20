import java.util.Vector;

/**
 * La classe Dieu possede quatre attributs, String nom, Dieu pere et Deesse mere
 * et Vector<Dieu> olympe, attribut static destine a contenir la totalite des instances 
 * de la classe (et de ses heritieres)
 * Cette classe est la classe mere des classes Deesse et Upatos
 * @author romain
 *
 */
public class Dieu {
	protected String nom;
	protected Dieu pere;
	protected Deesse mere;
	protected static volatile Vector<Dieu> olympe = new Vector<Dieu>();
	
	/**
	 * Constructeur de la classe Dieu
	 * @param classe Object, objet devant etre de la classe Origine
	 * @param n String le nom du Dieu
	 * @param p Dieu le pere du Dieu
	 * @param m Deesse la mere du Dieu
	 */
	public Dieu(Object classe, String n, Dieu p, Deesse m) {
		// creation d'une instance de la classe ExceptionDieu heritiere de RuntimeException
		// avec en parametre le mesage a afficher
		ExceptionDieu ex = new ExceptionDieu("\n\u001B[31m"+n+" n'a pas ete cree par le big bang\u001B[0m");
		
		// si le parametre classe est une instance de la classe Origine, ou si
		// cette instance est de la classe Upatos, on assigne les valeurs aux attributs
		// sinon ExceptionDieu
		if(classe instanceof Origine || this instanceof Upatos) {
			this.nom = n;
			this.pere = p;
			this.mere = m;
			// ajout du Dieu a l'olympe pour iteration
			olympe.addElement(this);
		}
		else {
			throw ex;
		}
		
	}
	
	/*
	 * GETTERS
	 */
	/**
	 * getter pour l'attribut nom
	 * @return String le nom de l'instance de Dieu courante
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * getter pour le pere du Dieu
	 * @return Dieu l'instance correspondant au pere de l'instance de Dieu courante
	 */
	public Dieu getPere() {
		return this.pere;
	}
	
	/**
	 * getter pour la mere du Dieu
	 * @return Deesse l'instance correspondant a la mere de l'instance de Dieu courante
	 */
	public Deesse getMere() {
		return this.mere;
	}
	
	/**
	 * Cette fonction renvoie le Vector olympe contenant l'ensemble des instances de la classe Dieu
	 * @return Vector<Dieu> olympe, contenant toutes les instances de Dieu
	 */
	static Vector<Dieu> getOlympe() {
		return olympe;
	}
	
	/*
	 * SETTERS
	 */
	
	/**
	 * Permet d'attribuer une nouvelle valeur a l'attribut nom de l'instance courante
	 * @param n String le nouveau nom du Dieu
	 */
	public void setNom(String n) {
		this.nom = n;
	}
	
	/**
	 * Permet d'attribuer une nouvelle valeur a l'attribut pere de l'instance courante
	 * @param p Dieu le nouveau pere du Dieu
	 */
	public void setPere(Dieu p) {
		this.pere = p;
	}
	
	/**
	 * Permet d'attribuer une nouvelle valeur a l'attribut mere de l'instance courante
	 * @param m Deesse la nouvelle mere du Dieu
	 */
	public void setMere(Deesse m) {
		this.mere = m;
	}
	
	/*
	 * END GETTERS / SETTERS
	 */
}
