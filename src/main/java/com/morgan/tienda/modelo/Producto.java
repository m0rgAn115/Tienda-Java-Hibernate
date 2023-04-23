package com.morgan.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //Le decimos a hibernate que esta es una entidad
@Table(name ="productos") // declaramos el nombre de nuestra tabla, si no se declara lo tomara como el nombre de la clase
public class Producto {
	
	public Producto() {
		
	}
	
	public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}
	
	@Id //Establece el identificador de cada fila
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Se establece que se autogenerara el id por si mismo y no lo asignara el usuario
	private Long id; //Representa la primary key
	
	//@Column(name="nombres") asi podemos establecer el nombre de nuestra columna, de no ser declarado hibernate lo tomara como el nombre
	//que tienen asignados los atributos
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private LocalDate fechaDeRegistro = LocalDate.now();
	
	//@Enumerated(EnumType.STRING) Hacemos que se almacene el nombre de los objetos del enum en lugar de el index porque se presta a errores
	@ManyToOne
	private Categoria categoria;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
