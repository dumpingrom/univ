import java.util.*;

/**
 * La classe Origine contient uniquement la methode bigbang(), appellee par le
 *  programme principal
 * @author romain
 *
 */
public class Origine {
	/**
	 * Creation d'une instance unique de la classe Origine
	 */
	private static final Origine origine = new Origine();
	/**
	 * Constructeur vide de la classe Origine
	 * Origine ne peut etre instanciee en dehors de la classe (constructeur prive)
	 */
	private Origine() {
		
	}
	
	/**
	 * Cette methode, qui est theoriquement la seule a etre appelee dans le programme
	 * principal, contient les etapes suivantes :
	 * - creation des Dieux
	 * - (optionnel) boucle permettant d'afficher la descendance d'un Dieu entre au clavier
	 * - recuperation du Vector static olympe de la classe Dieu
	 * - recuperation des informations sur chaque lignee et affichage
	 */
	public static void bigbang() {
		// Couleurs (bleu pour masculin, violet pour feminin)
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_RESET = "\u001B[0m";
		
		//creation des Dieux
		Dieu cronos = new Dieu(origine, "Cronos", null, null);
		Deesse rhea = new Deesse(origine, "Rhea", null, null);
		Dieu zeus = Upatos.getInstance();
		zeus.setNom("Zeus");
		zeus.setPere(cronos);
		zeus.setMere(rhea);
		Deesse hera = new Deesse(origine, "Hera", cronos, rhea);
		Deesse demeter = new Deesse(origine, "Demeter", cronos, rhea);
		Dieu hades = new Dieu(origine, "Hades", cronos, rhea);
		Dieu poseidon = new Dieu(origine, "Poseidon", cronos, rhea);
		Deesse hestia = new Deesse(origine, "Hestia", cronos, rhea);
		Dieu ares = new Dieu(origine, "Ares", zeus, hera);
		Deesse persephone = new Deesse(origine, "Persephone", zeus, demeter);
		Deesse aphrodite = new Deesse(origine, "Aphrodite", zeus, hera);
		
		// recuperation du Vector static olympe de la classe Dieu
		Vector<Dieu> olympe = Dieu.getOlympe();
		
		//idee pour une amelioration, on demande le Dieu ou la Deesse dont on veut connaitre les ancetres
		//decommenter pour tester
		
		/* System.out.println("Voici les divinites existantes :");
		String divinites = "";
		for (Iterator<Dieu> i = olympe.iterator(); i.hasNext();) {
			Dieu d = i.next();
			if (!i.hasNext()) {
				divinites += d.getNom()+".";
			}
			else {
				divinites += d.getNom()+", ";				
			}
		}
		System.out.println(divinites);
		
		
		String ch = "";
		Scanner input = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("De quel divinite desires-tu connaitre les ancetres, mortel ? (q pour quitter)");
			ch = input.next();
			if(ch.equalsIgnoreCase("q")) {
				break;
			}
			// on parcourt le tableau olympe
			for(Iterator<Dieu> i = olympe.iterator(); i.hasNext();) {
				Dieu d = i.next();
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
					
					System.out.println("\n"+d.getNom()+" | pere : "+pere+", mere : "+mere);
					// on stoppe la boucle si le Dieu est trouve
					break;
				}
				if(!i.hasNext()) {
					System.out.println("\nCette divinite n'existe pas");
				}
			}
			System.out.println("______________________________________________\n\n");	
		}*/
		// fin idee pour amelioration
		
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
		System.out.println("\n");
		System.out.println(ligneeMasculine);
		System.out.println(ligneeFeminine);
	}
}
