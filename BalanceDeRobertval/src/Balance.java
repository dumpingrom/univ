/**
 * @author romain
 * La classe Balance possede deux attributs
 * plateauGauche et plateauDroit, tous deux de type Plateau
 *
 */
public class Balance {
	private Plateau plateauGauche;
	private Plateau plateauDroit;
	
	/**
	 * Constructeur de la classe Balance
	 */
	public Balance() {
		this.plateauDroit = new Plateau();
		this.plateauGauche = new Plateau();
	}
	
	/**
	 * Permet de poser un Poids sur le Plateau droit en appelant la methode poser() de la
	 * classe Plateau (passage du meme Poids en parametre) apres avoir verifier si le Poids
	 * n'est encore pose sur aucun Plateau (getPos == -1)
	 * @param p une instance de Poids (ou de sa classe fille Paquet)
	 */
	protected void poseSurPlateauGauche(Poids p) {
		if(p.getPos() == -1) {
			if(p instanceof Paquet && this.plateauGauche.getPoidsPoses().size() > 0) {
				System.out.println("Impossible de poser un Paquet sur un Plateau non vide !");
			}
			else {
				this.plateauGauche.poser(p);
				System.out.println("On pose un "+ (p instanceof Paquet ? "paquet" : "poids") +" sur le Plateau gauche");
			}			
		}
		else {
			System.out.println("Ce Poids est deja pose autre part, veuillez le retirer avant");
		}
	}
	
	/**
	 * Permet de poser un Poids sur le Plateau droit en appelant la methode poser() de la
	 * classe Plateau (passage du meme Poids en parametre) apres avoir verifier si le Poids
	 * n'est encore pose sur aucun Plateau (getPos == -1)
	 * @param p une instance de Poids (ou de sa classe fille Paquet)
	 */
	protected void poseSurPlateauDroit(Poids p) {
		if (p.getPos() == -1) {
			if(p instanceof Paquet && this.plateauDroit.getPoidsPoses().size() > 0) {
				System.out.println("Impossible de poser un Paquet sur un Plateau non vide !");
			}
			else {
				this.plateauDroit.poser(p);
				System.out.println("On pose un "+ (p instanceof Paquet ? "paquet" : "poids") +" sur le Plateau droit");
			}			
		}
		else {
			System.out.println("Ce Poids est deja pose autre part, veuillez le retirer avant");
		}
	}
	
	/**
	 * Permet de retirer un poids du Plateau plateauGauche
	 * @param p le Poids a retirer du Plateau plateauGauche
	 */
	protected void retireDePlateauGauche(Poids p) {
		if(p.getPos() == -1) {
			System.out.println("Ce Poids n'est pose sur aucun Plateau");
		}
		else {
			//on verifie si le Poids est bien pose sur le plateau gauche
			if(p.getPlateau() == this.plateauGauche) {
				this.plateauGauche.retirer(p);
				System.out.println("On retire un poids du plateau gauche");
			}
			else {
				System.out.println("Ce poids est pose sur l autre Plateau");
			}
		}
	}
	
	/**
	 * Permet de retirer un poids du Plateau plateauDroit
	 * @param p le Poids a retirer du Plateau plateauDroit
	 */
	protected void retireDePlateauDroit(Poids p) {
		if(p.getPos() == -1) {
			System.out.println("Ce Poids n'est pose sur aucun Plateau");
		}
		else {
			//on verifie si le Poids est bien pose sur le plateau droit
			if(p.getPlateau() == this.plateauDroit) {
				this.plateauDroit.retirer(p);
				System.out.println("On retire un poids du plateau droit");
			}
			else {
				System.out.println("Ce poids est pose sur l autre Plateau");
			}
		}
	}
	
	/**
	 * Metode permettant d'afficher le contenu du Plateau plateauGauche grace
	 * a la fonction getPoidsTotal() de la classe Plateau
	 */
	protected void afficheContenuPlateauGauche() {
		if (this.plateauGauche.getPoidsPoses().size() == 0) {
			System.out.println("Plateau gauche vide");
		}
		else {
			System.out.println("Plateau gauche: " + this.plateauGauche.getPoidsTotal()+" grammes");
		}
	}
	
	/**
	 * Metode permettant d'afficher le contenu du Plateau plateauDroit grace
	 * a la fonction getPoidsTotal() de la classe Plateau
	 */
	protected void afficheContenuPlateauDroit() {
		if (this.plateauDroit.getPoidsPoses().size() == 0) {
			System.out.println("Plateau droit vide");
		}
		else {
			System.out.println("Plateau droit: " + this.plateauDroit.getPoidsTotal()+" grammes");
		}
	}
	
	/**
	 * afficheAiguille verifie le resultat de la difference entre
	 * les poids totaux des Plateaux gauche et droit et affiche un message en
	 * consequence
	 * @return 0
	 */
	protected int afficheAiguille() {
		int pdsPlatG = this.plateauGauche.getPoidsTotal();
		int pdsPlatD = this.plateauDroit.getPoidsTotal();
		int diff = pdsPlatD - pdsPlatG;
		
		//affichage de la position de l'aiguille (penche fortement si la 
		//difference est sup ou egale a 500 ou si l'autre Plateau est vide, legerement
		//sinon)
		if(diff == 0) {
			System.out.println("La balance est en equilibre");
			return 0;
		}
		
		if(diff > 0) {
			System.out.println("L'aiguille penche "+ (diff >= 500 || pdsPlatG == 0?"fortement":"legerement") +" a droite");
			return 0;
		}
		
		if(diff < 0) {
			System.out.println("L'aiguille penche "+ (diff >= 500 || pdsPlatD == 0?"fortement":"legerement") +" a gauche");
		}
		
		return 0;
	}
}
