
class T1 extends Thread
{
	String nom;
	
	T1(String nom) {
		this.nom = nom;
	}
	void f()
	{
		int i;
		for (i=1;i<11;i++)
		{
			System.out.println(this.nom+": "+i);
			try {
				Thread.sleep((int)(Math.random()*5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == 10) {
				System.out.println(this.nom+" a fini de compter jusqu a 10!");
			}
		}
	}
	
	public void run() {
		f();
	}
}

