import java.util.ArrayList;
import java.util.List;

/**
 * Created by rom on 05/03/15.
 */
public class Triangle {
    private Triangle gauche;
    private Triangle droite;
    private Triangle dessusGauche;
    private Triangle dessusDroite;
    private Triangle dessousGauche;
    private Triangle dessousDroite;

    public static Triangle base;

    void poseSurTable(){
    	//System.out.println("poseSurTable ==> Base = "+Triangle.base);
    	if (Triangle.base == null){
    		Triangle.base = this;
    		System.out.println("gauche du triangle pose sur table = "+this.gauche);
    	}
    	else{
    		Triangle current = Triangle.base;
    		
    		while(current.droite != null){
    			current = current.droite;
    			System.out.println("current = "+current);
    		};
    		this.gauche = current;
    		current.droite = this;
    		System.out.println("gauche du triangle pose sur table = "+this.gauche);
    		System.out.println("droite du triangle de gauche = "+current.droite);
    		System.out.println("devrait etre egal a = "+this);
    	}
    	//System.out.println("this.gauche = "+this.gauche);
    	//System.out.println("this.droite = "+this.droite);
    }

    void poseSur(Triangle t){
    	
    	if(t.droite != null){
    		t.dessusDroite = this;
    		t.droite.dessusGauche = this;
    		this.dessousGauche = t;
    		this.dessousDroite = t.droite;
    		
    		if(t.dessusGauche != null){
    			t.dessusGauche.droite = this;
    			this.gauche = t.dessusGauche;
    		}
    		
    		if(t.droite.dessusDroite != null){
    			t.droite.dessusDroite.gauche = this;
    			this.droite = t.droite.dessusDroite;
    		}
    	}
    	else{
    		System.out.println("Impossible");
    		System.out.println("t.droite = "+t.droite);
    	}
    }

    void retire(){
    	if(this == Triangle.base){
    		Triangle.base = null;
    	}
    	
    	//cas de Triangle sur table
    	if(this.dessousDroite == null){
    		if(this.droite != null){
    			this.dessusDroite.retire();
        		this.dessusGauche.retire();
    			this.droite = this.droite.droite;
        		this.gauche = this.droite.gauche;
        		this.dessusGauche = this.droite.dessusGauche;
        		this.dessusDroite = this.droite.dessusDroite;
    		}
    		else{
    			this.gauche.droite = null;
    		}
    	}
    	//cas de Triangle sur autre Triangle
    	else{
    		if(this.dessusDroite != null){
    			this.dessusDroite.retire();
    		}
    		if(this.dessusGauche != null){
    			this.dessusGauche.retire();
    		}
    		this.dessousDroite.dessusGauche = null;
    		this.dessousGauche.dessusDroite = null;
    		
    		if(this.gauche != null){
    			this.gauche.droite = null;
    		}
    		if(this.droite != null){
    			this.droite.gauche = null;
    		}
    	}
    	
    }

   static public void afficheTout(){
	   ArrayList<String> content = new ArrayList<String>();
	   int line = 0;
	   
	   if (Triangle.base != null){		   
		   Triangle current = Triangle.base;
		   
		   while(current != null){
			   line = 0;
			   System.out.println("CURRENTLOOP, Set line to 0");
			   if(line >= content.size()){
				   content.add("/\\");
				   System.out.println("add /\\ to line "+line);
			   }
			   else{
				   content.set(line, content.get(line)+"/\\");
				   if(current.droite == null){
					   content.set(line, content.get(line)+"  ");
					   System.out.println("append /\\ to line "+line);
				   }
			   }
			   
			   
			   Triangle currentUp = current.dessusDroite;
			   while(currentUp != null){
				   line ++;
				   System.out.println("CURRENTUP LOOP, set line to "+line);
				   if(line >= content.size()){
					   content.add("/\\");
					   System.out.println("add /\\ to line "+line);
				   }
				   else{
					   content.set(line, content.get(line)+"/\\");
					   System.out.println("append /\\ to line "+line);
				   }
				   currentUp = currentUp.dessusDroite;
			   }
			   
			   
			   if(line+1 >= content.size()){
				   content.add("\u00A0\u00A0");
				   System.out.println("add space to line "+line+1);
			   }
			   else{
				   content.set(line+1, content.get(line+1)+"\u00A0\u00A0");
				   System.out.println("append space to line "+line+1);
			   }
			   current = current.droite;
		   }
		   
		   
		   //Affichage des lignes
		   for (int i = content.size()-1; i >= 0; i--){
			   for (int j = i; j>0; j--){
				   //ajout espace pour decalage (1 espace pour ligne 1, 2 espaces pour ligne 2...)
				   content.set(i, "\u00A0"+content.get(i));
			   }
			   System.out.println(content.get(i)+"\r");
		   }
		   
	   }
	   else{
		   System.out.println("Aucun triangle sur la table...");
	   }
   }

    public static void main(String[] args){
    	System.out.println("\n__________________________\n\nPROGRAM INITIALISED\n__________________________\n\n");
    	
    	Triangle t[] = new Triangle[6];
    	
    	for (int i = 0; i<t.length; i++){
    		t[i] = new Triangle();
    	}
    	
    	t[0].poseSurTable();
    	t[1].poseSurTable();
    	t[2].poseSur(t[0]);
    	t[3].poseSurTable();
    	t[4].poseSurTable();
    	t[5].poseSur(t[1]);
    	t[5].retire();
    	
    	/*System.out.println("main ==> t[0] = "+t[0]);
    	System.out.println("main ==> t[1] = "+t[1]);
    	System.out.println("main ==> t[2] = "+t[2]);*/
    	
    	
    	Triangle.afficheTout();
    	
    	System.out.println("\n\n__________________________\n\nEND OF PROGRAM INSTRUCTIONS\n__________________________\n\n");
    }
}
