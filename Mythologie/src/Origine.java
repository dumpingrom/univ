import java.util.*;

/**
 * 
 * @author romain
 *
 */
public class Origine {
	
	private Origine() {
		
	}
	
	/**
	 * Cette methode, qui est la seule a etre appelee dans le programme
	 * principal, contient les etapes suivantes :
	 * - creation d'une liste olympe de type Dieu
	 * - creation des Dieux
	 * - ajout des Dieux a la liste olympe
	 * - recuperation des informations sur chaque lignee et affichage
	 */
	public static void bigbang() {
		// Couleurs (bleu pour masculin, violet pour feminin)
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_RESET = "\u001B[0m";
		
		//creation d'une liste pour contenir tous les Dieux
		Vector<Dieu> olympe = new Vector<Dieu>();
		
		//creation des Dieux
		Dieu cronos = new Dieu("Cronos", null, null);
		Deesse rhea = new Deesse("Rhea", null, null);
		Dieu zeus = Upatos.getInstance();
		zeus.setNom("Zeus");
		zeus.setPere(cronos);
		zeus.setMere(rhea);
		Deesse hera = new Deesse("Hera", cronos, rhea);
		Dieu ares = new Dieu("Ares", zeus, hera);
		
		//ajout des Dieux à la liste
		olympe.addElement(cronos);
		olympe.addElement(rhea);
		olympe.addElement(zeus);
		olympe.addElement(hera);
		olympe.addElement(ares);
		
		//idee pour une amelioration, on demande le Dieu ou la Deesse dont on veut connaitre les ancetres
		//decommenter pour tester
		
		
		System.out.println("De quel divinite desires-tu connaitre les ancetres, mortel ?");
		
		String ch = "";
		Scanner input = new Scanner(System.in);
		ch = input.next();
		
		// on parcourt le tableau olympe
		for(int i = 0; i < olympe.size(); i++) {
			Dieu d = olympe.get(i);
			String pere;
			String mere;
			//si le nom entre existe
			if (ch.equalsIgnoreCase(d.getNom())) {
				// si la divinite n'a pas de pere, on assigne inconnu a la chaine pere
				if(d.getPere() == null) {
					pere = "inconnu";
				}
				else {
					pere = d.getPere().getNom();
				}
				//idem pour la mere
				if(d.getMere() == null) {
					mere = "inconnue";
				}
				else {
					mere = d.getMere().getNom();
				}
				
				System.out.println(d.getNom()+" | pere : "+pere+", mere : "+mere);
				break;
			}
			if(i == olympe.size()-1) {
				System.out.println("Ce Dieu n'existe pas");
			}
		}
		
		// fin idee pour amelioration
		
		System.out.println("______________________________________________\n\n");
		//creation des chaines de caracteres pour l'affichage des lignees
		String ligneeMasculine = ANSI_BLUE+"Lignee masculine : \n"+ANSI_RESET;
		String ligneeFeminine = ANSI_PURPLE+"Lignee feminine : \n"+ANSI_RESET;
		
		//parcours de la liste avec Iterator
		for(Iterator<Dieu> i = olympe.iterator(); i.hasNext();) {
			Dieu d = i.next();
			//si le Dieu a bien un pere et une mere
			if(d.getPere() != null && d.getMere() != null) {
				//creation de la chaine a ajouter a la lignee
				String ligne = d.getNom()+" (pere: "+d.getPere().getNom()+", mere: "+d.getMere().getNom()+")\n";
				
				//si l'instance est un Dieu
				if(!(d instanceof Deesse)) {
					ligneeMasculine += ligne;
				}
				//sinon (=> Deesse)
				else {
					ligneeFeminine += ligne;
				}				
			}
		}
		
		//affichage des informations creees
		System.out.println(ligneeMasculine);
		System.out.println(ligneeFeminine);
	}
}
