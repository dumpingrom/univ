/**
 * @author romain
 * La classe Poids est une classe generale pour les poids et les paquets (classe fille)
 * les poids possedent trois attributs, l'entier grammes correspondant a leur poids
 * en grammes, l'entier pos correspondant a leur position sur le plateau, et le Plateau
 * sur lequel ils sont poses
 *
 */
public class Poids {
	protected int grammes;
	protected int pos;
	protected Plateau plateau;
	
	/**
	 * Constructeur de la classe Poids
	 * @param g poids en grammes
	 */
	public Poids(int g) {
		this.grammes = g;
		// tout Poids n'etant pas pose sur un Plateau a une position de -1
		this.pos = -1;
	}
	
	/**
	 * Permet de changer le poids en grammes d'une instance de Poids
	 * @param g (int) nouvelle valeur grammes du Poids
	 */
	protected void setGrammes(int g) {
		this.grammes = g;
	}
	
	/**
	 * Retourne le poids en gramme d'une instance de Poids
	 * @return le poids en grammes de l'instance de Poids courante
	 */
	protected int getGrammes() {
		return this.grammes;
	}
	
	/**
	 * Cette methode permettant d'assigner une nouvelle valeur a l'attribut pos
	 * est appellee par la methode poser() de la classe Plateau
	 * @param i entier - position sur le Plateau
	 */
	protected void setPos(int i) {
		this.pos = i;
	}
	
	/**
	 * 
	 * @return int pos - la position de l'instance de Poids courante sur le Plateau
	 */
	protected int getPos() {
		return this.pos;
	}
	
	/**
	 * Permet d'assigner un nouveau Plateau au Poids courant
	 * @param pl le nouveau Plateau a assigner a l'attribut plateau du Poids
	 */
	protected void setPlateau(Plateau pl) {
		this.plateau = pl;
	}
	
	/**
	 * 
	 * @return le Plateau sur lequel est pose le Poids
	 */
	protected Plateau getPlateau() {
		return this.plateau;
	}
}
