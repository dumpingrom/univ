import java.util.Vector;

/**
 * La classe Dieu possede quatre attributs, String nom, Dieu pere et Deesse mere
 * et Vector<Dieu> olympe destine a contenir la totalite des instances de la classe (et
 * de ses heritieres)
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
	 * @param n String le nom du Dieu
	 * @param p Dieu le pere du Dieu
	 * @param m Deesse la mere du Dieu
	 */
	public Dieu(String n, Dieu p, Deesse m) {
		// creation d'un booleen initialise a true
		boolean appeleParOrigine = true;
		// creation d'une instance de la classe ExceptionDieu heritiere de RuntimeException
		// avec en parametre le mesage a afficher
		ExceptionDieu ex = new ExceptionDieu("\n\u001B[31m"+n+" n'a pas ete cree par le big bang\u001B[0m");
		// recuperation du tableau StackTraceElement 
		StackTraceElement[] ste = ex.getStackTrace();
		
		if(ste.length > 2) {
			System.out.println(ste.length);
			if(ste[1].getClassName() != "Origine" && ste[2].getClassName() != "Origine" && !(this instanceof Upatos)) {
				appeleParOrigine = false;
			}
		}
		else {
			appeleParOrigine = false;
		}
		
		// on parcourt le tableau de StackTraceElement
		// si la classe Origine a fait un appel, le booleen est vrai et la boucle est stoppee
		/*for (int i = 0; i < ste.length; i++) {
			System.out.println(n);
			System.out.println(i+" => "+ste[i].getClassName()+"\n");
			if(ste[i].getMethodName() == "bigbang" || (this instanceof Upatos)) {
				appeleParOrigine = true;
				break;
			}
		}*/
		
		// si le booleen est toujours faux apres l'instruction precedente
		// on jette une exception ExceptionDieu et le programme s'arrete
		if(appeleParOrigine == false) {
			throw ex;
		}
		// sinon creation du Dieu
		else {
			this.nom = n;
			this.pere = p;
			this.mere = m;
			// ajout du Dieu a l'olympe pour iteration
			olympe.addElement(this);
		}
		
	}
	
	/*
	 * GETTERS
	 */
	/**
	 * getter pour l'attribut nom
	 * @return String le nom de l'instance de Dieu appelante
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
