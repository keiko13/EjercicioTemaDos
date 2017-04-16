package app.persistencia;

/**
 * @author Eva Fonseca López
 *
 */
public class LibroNoEncontradoException extends Exception {
     
	private static final long serialVersionUID = 6390445085291452253L;

	public LibroNoEncontradoException(String msg) {
        super(msg);
    }

}
