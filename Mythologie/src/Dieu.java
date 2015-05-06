/**
 * 
 * @author romain
 *
 */
public class Dieu {
	protected String nom;
	protected Dieu pere;
	protected Deesse mere;
	
	public Dieu(String n, Dieu p, Deesse m) {
		this.nom = n;
		this.pere = p;
		this.mere = m;
	}
	
	/*
	 * GETTERS
	 */
	public String getNom() {
		return this.nom;
	}
	
	public Dieu getPere() {
		return this.pere;
	}
	
	public Deesse getMere() {
		return this.mere;
	}
	
	/*
	 * SETTERS
	 */
	
	public void setNom(String n) {
		this.nom = n;
	}
	
	public void setPere(Dieu p) {
		this.pere = p;
	}
	
	public void setMere(Deesse m) {
		this.mere = m;
	}
	
	/*
	 * END GETTERS / SETTERS
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
