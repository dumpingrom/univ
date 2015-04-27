public class ChateauDeCartes {
    
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
        	
        	Triangle.afficheTout();
        	
        	System.out.println("\n\n__________________________\n\nEND OF PROGRAM INSTRUCTIONS\n__________________________\n\n");
        }
    }