package com.hotel.logica;

import java.sql.Date;

public class Reserva {
	private final int id;
	private final Date entrada;
	private final Date salida;
	private final float valor;
	private final String pago;

	public Reserva(int id, Date entrada, Date salida, float valor, String pago) {
		this.id = id;
		this.entrada = entrada;
		this.salida = salida;
		this.valor = valor;
		this.pago = pago;
	}

	public int getId() {
		return id;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSalida() {
		return salida;
	}

	public float getValor() {
		return valor;
	}

	public String getPago() {
		return pago;
	}
}