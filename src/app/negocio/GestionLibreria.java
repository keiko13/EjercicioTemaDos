package app.negocio;

import java.util.List;

import app.modelo.Libro;
import app.persistencia.ItfzLibrosDao;
import app.persistencia.LibroNoEncontradoException;
import app.persistencia.LibrosDAO;


/**
 * Clase fachada que gestiona la librería
 * @author Eva Fonseca López
 *
 */
public class GestionLibreria implements ItfzGestionLibreria{
	
	LibrosDAO librosDao;
	
	
	public GestionLibreria() {
		
	}

	public void setLibrosDao(LibrosDAO librosDao) {
		this.librosDao = librosDao;
	}

	public LibrosDAO getLibrosDao() {
		return librosDao;
	}

	@Override
	public boolean altaLibro(Libro libro) {
		
		boolean altaLib = librosDao.altaLibro(libro);
		return altaLib;
	}

	@Override
	public boolean eliminarLibro(String ISBN) {
		
		boolean eliminarLib =librosDao.eliminarLibro(ISBN);
		return eliminarLib;
	}

	@Override
	public List<Libro> consultarTodos() {
		List<Libro> listLibros = librosDao.consultarTodos();
		return listLibros;
	}

	@Override
	public Libro consultarISBN(String isbn) {
		Libro lib= librosDao.consultarISBN(isbn);
		return lib;
	}

	@Override
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException {
		List<Libro> listTitulos = librosDao.consultarTitulo(titulo);
		return listTitulos;
	}

	@Override
	public boolean modificarPrecio(String isbn, double precio) {
		boolean modPrecios = librosDao.modificarPrecio(isbn, precio);
		return modPrecios;
	}
}
