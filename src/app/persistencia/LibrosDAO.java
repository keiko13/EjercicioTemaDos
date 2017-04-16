package app.persistencia;

import java.util.List;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import app.modelo.Libro;


/**
 * @author Eva Fonseca López
 *
 */
public class LibrosDAO implements ItfzLibrosDao{
	
	private JdbcTemplate plantilla;
	private RowMapper<Libro> mapeadorLibros;
	private TransactionTemplate txTemplate;
		  
	public LibrosDAO() {
		
    }
	
	@Override
	public boolean altaLibro(Libro libro) {
		
		txTemplate.execute(new TransactionCallbackWithoutResult() {

		@Override
		protected void doInTransactionWithoutResult(TransactionStatus ts) {
	       try{
	          String sql = "insert into libros values (?,?,?,?,?,?,?)";
	          plantilla.update(sql, libro.getTitulo(), libro.getAutor(), libro.getEditorial(),
	          libro.getIsbn(),libro.getPublicacion(), libro.getPrecio(),libro.getDescripcion());
	                    
	        }catch(Exception ex){
	           ts.setRollbackOnly();
	           ex.printStackTrace();
	         }
	       }
	     });
		return true;
	}

	@Override
	public boolean eliminarLibro(String isbn) {
		String sql = "delete * from libros where isbn=?";
        plantilla.update(sql, new Object[] {isbn}, mapeadorLibros);
		return true;
	}

	@Override
	public List<Libro> consultarTodos() {
		return plantilla.query("select * from libros", mapeadorLibros);
	}

	@Override
	public Libro consultarISBN(String isbn) {
		String sql = "select * from libros where isbn=?";
        return plantilla.queryForObject(sql, new Object[] {isbn}, mapeadorLibros);
	}

	@Override
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException {
		String sql = "select * from libros where titulo=?";
		List <Libro> listLibro = plantilla.query(sql, new Object[] {titulo}, mapeadorLibros);
		if(listLibro.isEmpty()){
			throw new LibroNoEncontradoException("No se ha encontrado el libro solicitado");
		}
		return listLibro;
	}

	@Override
	public boolean modificarPrecio(String isbn, double precio) {
		String sql = "update libros set precio = ? where isbn = ?";
        plantilla.update(sql, new Object[] {precio,isbn});
		return true;
	}

	public JdbcTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(JdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}

	public RowMapper<Libro> getMapeadorLibros() {
		return mapeadorLibros;
	}

	public void setMapeadorLibros(RowMapper<Libro> mapeadorLibros) {
		this.mapeadorLibros = mapeadorLibros;
	}

	public TransactionTemplate getTxTemplate() {
		return txTemplate;
	}

	public void setTxTemplate(TransactionTemplate txTemplate) {
		this.txTemplate = txTemplate;
	}
}
