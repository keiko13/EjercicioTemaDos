package app.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.modelo.Libro;

/**
 * @author Eva Fonseca López
 *
 */
public class MapeadorLibro implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int i) throws SQLException {
		Libro libro = new Libro();
		libro.setTitulo(rs.getString(1));
		libro.setAutor(rs.getString(2));
		libro.setEditorial(rs.getString(3));
		libro.setIsbn(rs.getString(4));
		libro.setPublicacion(rs.getInt(5));
		libro.setPrecio(rs.getDouble(6));
		libro.setDescripcion(rs.getString(7));
		return libro;
	}

}
