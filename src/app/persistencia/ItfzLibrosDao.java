package app.persistencia;

import java.util.List;

import app.modelo.Libro;

public interface ItfzLibrosDao {
	
	public boolean altaLibro(Libro libro);
	public boolean eliminarLibro(String ISBN);
	public List<Libro> consultarTodos();
	public Libro consultarISBN(String isbn);
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException;
	public boolean modificarPrecio(String isbn, double precio);

}
