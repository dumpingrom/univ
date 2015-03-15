import java.util.Calendar;
import java.util.TimeZone;

public class Coffre {
	private int max;

	private Molette[] molettes;
	private int[] combi;
	
	private Calendar ouverture = Calendar.getInstance(TimeZone.getTimeZone("CET"));
	private Calendar fermeture = Calendar.getInstance(TimeZone.getTimeZone("CET"));
	
	private boolean isLocked;
	
	//constr.
	Coffre(int max){
		this.max = max;
	}

	//meths	
	protected void open(){
		System.out.println("Sesame ouvre-toi!");
	}
	
	//get/set
	protected boolean getIsLocked(){
		return this.isLocked;
	}
	
	protected void setIsLocked(boolean b){
		this.isLocked = b;
	}
	
	protected int[] getCombi(){
		return this.combi;
	}
	
	protected void setCombi(int val1, int val2, int val3){
		this.combi = new int[3];
		this.combi[0] = val1;
		this.combi[1] = val2;
		this.combi[2] = val3;
	}
	
	protected Molette[] getMolettes(){
		return this.molettes;
	}
	
	protected void setMolettes(){
		this.molettes = new Molette[3];
		for(int i = 0; i < this.molettes.length; i++){
			this.molettes[i] = new Molette(this.max);
		}
	}
	
	protected Calendar getOuverture(){
		return this.ouverture;
	}
	
	protected void setOuverture(int h, int m){
		this.ouverture = Calendar.getInstance();
		this.ouverture.set(Calendar.HOUR_OF_DAY, h);
		this.ouverture.set(Calendar.MINUTE, m);
	}
	
	protected Calendar getFermeture(){
		return this.ouverture;
	}
	
	protected void setFermeture(int h, int m){
		this.fermeture = Calendar.getInstance();
		this.fermeture.set(Calendar.HOUR_OF_DAY, h);
		this.fermeture.set(Calendar.MINUTE, m);
	}
	
	/**
	 * @param args
	 * @throws java.text.ParseException 
	 */
	public static void main(String[] args) throws java.text.ParseException {
		// TODO Auto-generated method stub
		System.out.println("\n__________________________\n\nPROGRAM INITIALISED\n__________________________\n\n");
		
		CoffreUse c = new CoffreUse(20);
		c.setCombi(1,2,19);
		
		c.setMolettes();
		
		/*
		 * Mise en place des horaires d'ouverture/fermeture
		 */
		
		Calendar now = Calendar.getInstance();
		
		/*
		 * Envoi du 'signal' au coffre fort
		 */
		if(now.after(c.getOuverture()) && now.before(c.getFermeture()) && now.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && now.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY ){
			c.setIsLocked(false);
		}
		else{
			c.setIsLocked(true);
		}
		

		
		c.getMolettes()[0].tourneDroite();
		c.clic();
		c.getMolettes()[1].tourneDroite();
		c.clic();
		c.getMolettes()[1].tourneDroite();
		c.clic();
		c.getMolettes()[2].tourneGauche();
		c.clic();
		c.getMolettes()[2].tourneGauche();
		c.clic();
		c.getMolettes()[2].tourneDroite();
		c.clic();
		c.getMolettes()[2].tourneGauche();
		c.clic();
		
		
		
		/*
		 * Tentative d'ouverture		
		 */
		if(c.getIsLocked() == false){
			for(int j = 0; j < c.getCombi().length; j++){
				if(c.getCombi()[j] == c.getMolettes()[j].getVal()){
					if(j == c.getCombi().length-1){
						c.open();
					}
					else{
						continue;					
					}
				}
				else{
					System.out.println("J\'appelle les flics...");
					break;
				}
			}	
		}
		else{
			System.out.println("D\351sol\351, nous sommes ferm\351s...");
		}
		
		
		System.out.println("\n\n__________________________\n\nEND OF PROGRAM INSTRUCTIONS\n__________________________\n\n");
	}

}
