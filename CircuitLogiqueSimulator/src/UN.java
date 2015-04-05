/**
 * 
 * @author romain
 *
 * Classe UN
 * 
 */
public class UN extends Composant{
	/**
	 * Constructeur
	 * Initialisation de l'etat fixe a 1
	 */
	public UN() {
		super();
		// TODO Auto-generated constructor stub
		this.setEtat(1);
	}

	/**
	 * miseAJour (methode abstraite héritée de la classe abstraite Composant)
	 * Appelle la methode mise a jour du Composant en sortie s'il existe
	 */
	@Override
	void miseAJour() {
		// TODO Auto-generated method stub
		if(this.getSortie() != null) {
			this.getSortie().miseAJour();			
		}
	}
}