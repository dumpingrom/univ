/**
 * La classe Dieu possede trois attributs, String nom, Dieu pere et Deesse mere
 * Cette classe est la classe mere des classes Deesse et Upatos
 * @author romain
 *
 */
public class Dieu {
	protected String nom;
	protected Dieu pere;
	protected Deesse mere;
	
	/**
	 * Constructeur de la classe Dieu
	 * @param n String le nom du Dieu
	 * @param p Dieu le pere du Dieu
	 * @param m Deesse la mere du Dieu
	 */
	public Dieu(String n, Dieu p, Deesse m) {
		boolean appeleParOrigine = false;
		RuntimeException ex = new ExceptionDieu(n+" n'a pas ete cree par le big bang");
		StackTraceElement[] ste = ex.getStackTrace();
		
		for (int i = 0; i < ste.length; i++) {
			if(ste[i].getClassName() == "Origine") {
				appeleParOrigine = true;
			}
		}
		
		if(appeleParOrigine == false) {
			throw ex;
		}
		else {
			this.nom = n;
			this.pere = p;
			this.mere = m;			
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
	 * @return Dieu l'instance correspondant au pere de l'instance de Dieu appelante
	 */
	public Dieu getPere() {
		return this.pere;
	}
	
	/**
	 * getter pour la mere du Dieu
	 * @return Deesse l'instance correspondant a la mere de l'instance de Dieu appelante
	 */
	public Deesse getMere() {
		return this.mere;
	}
	
	/*
	 * SETTERS
	 */
	
	/**
	 * Permet d'attribuer une nouvelle valeur a l'attribut nom de l'instance appelante
	 * @param n String le nouveau nom du Dieu
	 */
	public void setNom(String n) {
		this.nom = n;
	}
	
	/**
	 * Permet d'attribuer une nouvelle valeur a l'attribut pere de l'instance appelante
	 * @param p Dieu le nouveau pere du Dieu
	 */
	public void setPere(Dieu p) {
		this.pere = p;
	}
	
	/**
	 * Permet d'attribuer une nouvelle valeur a l'attribut mere de l'instance appelante
	 * @param m Deesse la nouvelle mere du Dieu
	 */
	public void setMere(Deesse m) {
		this.mere = m;
	}
	
	/*
	 * END GETTERS / SETTERS
	 */
	
	/**
	 * Methode d'affichage non utilisee dans la version courante du projet
	 */
	void afficherDieu() {
		System.out.println(this.getNom()+" vient de naitre de ");
		if(this.getPere() != null) {
			System.out.println(this.getPere().getNom());
		}
		else {
			System.out.println("pere inconnu");
		}
		System.out.println(" et de ");
		if(this.getMere() != null) {
			System.out.println(this.getMere().getNom());
		}
		else {
			System.out.println("mere inconnue");
		}
	}
}
