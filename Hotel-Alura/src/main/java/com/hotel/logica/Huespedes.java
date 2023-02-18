package com.hotel.logica;

import java.sql.Date;

public class Huespedes {
	private final int id;
	private final String nombre;
	private final String apellido;
	private final Date fecha;
	private final String nacionalidad;
	private final String telefono;
	private final int idReserva;

	public Huespedes(int id, String nombre, String apellido, Date fecha, String nacionalidad,String telefono, int idReserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha = fecha;
		this.nacionalidad = nacionalidad;
		this.telefono= telefono;
		this.idReserva= idReserva;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public int getIdReserva() {
		return this.idReserva;
	}
}