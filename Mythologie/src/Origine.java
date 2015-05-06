import java.util.*;

/**
 * 
 * @author romain
 *
 */
public class Origine {
	
	public static void bigbang() {
		Vector<Dieu> olympe = new Vector<Dieu>();
		Dieu cronos = new Dieu("Cronos", null, null);
		Deesse rhea = new Deesse("Rhea", null, null);
		Dieu zeus = Upatos.getInstance();
		zeus.setNom("Zeus");
		zeus.setPere(cronos);
		zeus.setMere(rhea);
		Deesse hera = new Deesse("Hera", cronos, rhea);
		Dieu ares = new Dieu("Ares", zeus, hera);
		
		olympe.addElement(cronos);
		olympe.addElement(rhea);
		olympe.addElement(zeus);
		olympe.addElement(hera);
		olympe.addElement(ares);
		
		/*System.out.println("De quel Dieu desires-tu connaitre les ancetres, mortel ?");
		
		String ch = "";
		Scanner input = new Scanner(System.in);
		ch = input.next();*/
		
		String ligneeMasculine = "Lignee masculine: \n";
		String ligneeFeminine = "Lignee feminine \n";
		
		for(Iterator<Dieu> i = olympe.iterator(); i.hasNext();) {
			Dieu d = i.next();
			if(d.getPere() != null && d.getMere() != null) {
				String ligne = d.getNom()+" (pere: "+d.getPere().getNom()+", mere: "+d.getMere().getNom()+")\n";
				if(!(d instanceof Deesse)) {
					ligneeMasculine += ligne;
				}
				else {
					ligneeFeminine += ligne;
				}				
			}
		}
		
		System.out.println(ligneeMasculine);
		System.out.println(ligneeFeminine);
	}
}
