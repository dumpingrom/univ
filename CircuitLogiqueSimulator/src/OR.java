
public class OR extends Composant {
	public OR() {
		this.entrees = new Composant[2];
		this.entrees[0] = null;
		this.entrees[1] = null;
		this.sortie = null;
		this.etat = -1;
	}
	
	/**
	 * miseAJour OR
	 * 
	 * Verification de l'existence de Composant dans les 2 entrees, sinon etat << -1 
	 * Si l'une des deux entrees possede un etat de 1, mise a jour de l'etat pour 1, sinon 0
	 */

	@Override
	void miseAJour() {
		// TODO Auto-generated method stub
		if(this.entrees[0] != null && this.entrees[1] != null) {
			if(this.entrees[0].getEtat() == 1 || this.entrees[1].getEtat() == 1) {
				this.setEtat(1);
			}
			else {
				this.setEtat(0);
			}			
		}
		else {
			this.setEtat(-1);
		}
		if(this.getSortie() != null) {
			this.getSortie().miseAJour();
		}
	}
}
