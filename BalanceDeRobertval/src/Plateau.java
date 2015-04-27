import java.util.ArrayList;

/**
 * @author romain
 * La classe Plateau possede un attribut unique, l'ArrayList poidsPoses 
 * contenant les poids poses sur le Plateau
 *
 */
public class Plateau {
	protected ArrayList<Poids> poidsPoses;
	
	/**
	 * Constructeur de la classe Plateau
	 */
	public Plateau() {
		this.poidsPoses = new ArrayList<>();
	}
	
	/**
	 * 
	 * @return l'ArrayList contenant tous les Poids (et Paquets) poses sur le Plateau
	 */
	public ArrayList<Poids> getPoidsPoses() {
		return this.poidsPoses;
	}
	
	/**
	 * 
	 * @param p Poids a ajouter sur le Plateau
	 * Cette methode ajoute le Poids a l'ArrayList poidsPoses du Plateau
	 * puis donne au Poids venant d'etre pose sa nouvelle position sur le Plateau
	 */
	public void poser(Poids p) {
		this.poidsPoses.add(p);
		p.setPos(this.getPoidsPoses().size() - 1);
		p.setPlateau(this);
	}
	
	/**
	 * 
	 * @param p Poids a retirer de l'ArrayList poidsPoses
	 */
	public void retirer(Poids p) {
		this.poidsPoses.remove(p.getPos());
		// on reassigne -1 a la position du Poids car il n'est 
		// plus pose sur aucun Plateau
		p.setPos(-1);
		
		// puis on reassigne une valeur nulle a l'attribut plateau du Poids qui vient d'etre
		// retire
		p.setPlateau(null);
		
		// enfin, on reassigne les bonnes positions a tous les Poids presents
		// sur le plateau (a cause du retaillage automatique du type ArrayList)
		// on obtiendrait une exception de type IndexOutOfBounds sinon
		for (int i = 0; i < this.getPoidsPoses().size(); i++) {
			Poids pds = this.getPoidsPoses().get(i);
			pds.setPos(i);
			//System.out.println(pds+".getPos() = "+pds.getPos());
		}
	}
	
	/**
	 * La fonction getPoidsTotal de Plateau permet de recuperer le poids total
	 * des Poids contenu sur une instance de Plateau en parcourant l'ArrayList poidsPoses
	 * de celle-ci
	 * @return int poidsTotal
	 */
	public int getPoidsTotal() {
		int poidsTotal = 0;
		
		//on parcourt l'ArrayList et on additionne les poids
		for (Poids p: this.getPoidsPoses()) {
			poidsTotal += p.getGrammes();
		}
		
		return poidsTotal;
	}
}
