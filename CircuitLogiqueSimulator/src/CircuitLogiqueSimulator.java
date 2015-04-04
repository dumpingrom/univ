
public class CircuitLogiqueSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AND et = new AND();
		OR ou = new OR();
		UN un1 = new UN();
		UN un2 = new UN();
		ZERO zero = new ZERO();
		LED led1 = new LED("LED 1");
		ou.raccorde(un1);
		ou.raccorde(zero);
		led1.raccorde(ou);
	}

}
