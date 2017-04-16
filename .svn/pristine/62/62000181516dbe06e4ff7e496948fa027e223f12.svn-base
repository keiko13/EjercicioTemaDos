package app.cliente;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.modelo.Libro;
import app.negocio.ItfzGestionLibreria;


/**
 * @author Eva Fonseca López
 *
 */
public class TestLibreria {

	public static void main(String[] args) {
		
		ApplicationContext contenedor = new ClassPathXmlApplicationContext("spring.xml");
		
		ItfzGestionLibreria beanNegocio = (ItfzGestionLibreria) contenedor.getBean("negocio");
		
		//test consultar todos los libros 
		List<Libro> libros = beanNegocio.consultarTodos();
		
		for(Libro l:libros){
			System.out.println("************************");
			System.out.print("TITULO:" + l.getTitulo());
			System.out.print("AUTOR: " +l.getAutor());
			System.out.print("EDITORIAL: " +l.getEditorial());
			System.out.print("DESCRIPCIÓN" + l.getDescripcion());
			System.out.print("ISBN" + l.getIsbn());
			System.out.print("PRECIO: "+ l.getPrecio());
			System.out.println("PUBLICACIÓN" + l.getPublicacion());
			System.out.println("************************");
		}
		
		//test consultar por ISBN
		Libro lib = beanNegocio.consultarISBN("9788445000663");
		
		
		//test alta libro
		Libro libro1 = contenedor.getBean("libro", Libro.class);
 	
		libro1.setAutor("Prueba maven");
		libro1.setDescripcion("Prueba alta libro maven");
		libro1.setEditorial("SATORI");
		libro1.setPrecio(25.00);
		libro1.setPublicacion(2016);
		libro1.setTitulo("Prueba alta");
		libro1.setIsbn("4444");
		beanNegocio.altaLibro(libro1);
		
		//test modificar precio
		beanNegocio.modificarPrecio("4444", 80);
		
	}

}
