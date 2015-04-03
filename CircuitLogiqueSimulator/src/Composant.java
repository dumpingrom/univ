
public abstract class Composant {
	protected int etat;
	protected Composant sortie;
	protected Composant[] entrees;
	
	public Composant() {
		
	}
	
	public void raccorde(Composant c) throws ArrayIndexOutOfBoundsException {
		for (int i = 0; i < this.entrees.length + 1; i++) {
			try {
				if(this.entrees[i] == null) {
					System.out.println("Checking entree "+i);
					this.entrees[i] = c;
					System.out.println(this.entrees[i]);
					break;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	abstract void miseAJour();
	
	public void setEtat (int e) {
		this.etat = e;
	}
	
	public void setSortie(Composant A) {
		this.sortie = A;
	}
	
	public Composant getSortie() {
		return this.sortie;
	}
}
