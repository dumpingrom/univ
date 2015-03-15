
public class Molette {
	private int val = 0;
	private int max = 0;
	
	//constructeur
	Molette(int max){
		this.max = max;
	}
	
	//get/set
	protected void tourneDroite(){
		if(this.val == this.max){
			this.val = 0;
		}
		else{
			this.val++;
		}
	}
	
	protected void tourneGauche(){
		if(this.val == 0){
			this.val = this.max;
		}
		else{
			this.val--;
		}
	}
	
	public int getVal(){
		return this.val;
	}
	
	public void setMax(int max){
		this.max = max;
	}
}
