
public class CoffreUse extends Coffre{
	
	//constr
	CoffreUse(int max) {
		super(max);
		// TODO Auto-generated constructor stub
	}
	
	//meths
	protected void clic(){
		int isClic = 0;
		for (int i = 0; i < this.getCombi().length; i++ ){
			if(this.getMolettes()[i].getVal() == this.getCombi()[i]){
				isClic++;
			}
		}
		if(isClic == this.getMolettes().length){
			System.out.println("Clic!");			
		}
	}

}
