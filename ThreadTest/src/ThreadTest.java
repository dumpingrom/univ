
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T1 cpt1 = new T1("Compteur #1");
		T1 cpt2 = new T1("Compteur #2");
		cpt1.start();
		cpt2.start();
	}

}
