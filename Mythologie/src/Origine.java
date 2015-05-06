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
		
		//idee pour une amelioration
		/*System.out.println("De quel Dieu desires-tu connaitre les ancetres, mortel ?");
		
		String ch = "";
		Scanner input = new Scanner(System.in);
		ch = input.next();*/
		
		//creation des chaines de caracteres pour l'affichage des lignees
		String ligneeMasculine = "Lignee masculine: \n";
		String ligneeFeminine = "Lignee feminine \n";
		
		//parcours du tableau avec Iterator
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
