
public class LED extends Composant{
	protected String nom;
	
	public LED(String nom) {
		this.nom = nom;
		this.entrees = new Composant[1];
		this.entrees[0] = null;
	}

	@Override
	void miseAJour() {
		// TODO Auto-generated method stub
		//System.out.println("MaJ LED");
		if(this.entrees[0].getEtat() == 1) {
			System.out.println("La Led "+this.getNom()+" est allumee !");
		}
	}
	
	String getNom() {
		return this.nom;
	}
}
