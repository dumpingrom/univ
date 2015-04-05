
public abstract class Composant {
	/**
	 * etat 0, 1 ou -1 en cas d'entree non connectee (Initialisation a -1)
	 */
	protected int etat;
	protected Composant sortie;
	protected Composant[] entrees;
	
	public Composant() {
		/**
		 * Constructeur vide, la construction se fait dans les classes filles
		 */
	}
	
	public void raccorde(Composant c) {
		for (int i = 0; i < this.entrees.length; i++) {
			if(this.entrees[i] == null) {
				this.entrees[i] = c;
				c.setSortie(this);
				c.miseAJour();
				break;
			}
		}
	}
	
	/**
	 * Methode abstraite miseAJour
	 */
	abstract void miseAJour();
	
	/**
	 * Setter de l'attribut etat
	 * @param e
	 */
	public void setEtat (int e) {
		this.etat = e;
	}
	
	/**
	 * 
	 * @return l'etat du Composant
	 */
	public int getEtat() {
		return this.etat;
	}
	
	/**
	 * Setter pour la Sortie du Composant courant
	 * @param A Le Composant en sortie
	 */
	public void setSortie(Composant A) {
		this.sortie = A;
	}
	
	/**
	 * 
	 * @return le Composant en Sortie
	 */
	public Composant getSortie() {
		return this.sortie;
	}
	
	/**
	 * Getter pour le tableau des entrees du Composant
	 * @return Composant[], tableau des Composants en entree
	 */
	public Composant[] getEntrees() {
		return this.entrees;
	}
}
