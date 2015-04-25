
public class BalanceDeRobertval {

	public static void main(String[] args) {
    	System.out.println("\n__________________________\n\nPROGRAM INITIALISED\n__________________________\n\n");
		
		// TODO Auto-generated method stub
		Balance b = new Balance();
		
		Poids p1 = new Poids(100);
		Poids p2 = new Poids(200);
		Poids p3 = new Poids(200);
		
		Paquet pak = new Paquet(500);
		
		b.poseSurPlateauGauche(p1);
		b.poseSurPlateauDroit(pak);
		b.afficheContenuPlateauGauche();
		b.afficheContenuPlateauDroit();
		b.afficheAiguille();
		
    	System.out.println("\n\n__________________________\n\nEND OF PROGRAM INSTRUCTIONS\n__________________________\n\n");
	}

}
