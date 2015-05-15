/**
 * Cette classe herite de la classe RuntimeException
 * Le constructeur contient uniquement la methode super()
 * 
 * J ai utilise RuntimeException plutot que Exception car elle permet 
 * de quitter le programme une fois l'exception jetee, cela evite un appel
 * a System.exit(1)
 * @author romain
 *
 */
public class ExceptionDieu extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'ExceptionDieu, uniquement compose de la methode super()
	 * @param message Le message a afficher lors de l'exception
	 */
	public ExceptionDieu(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
