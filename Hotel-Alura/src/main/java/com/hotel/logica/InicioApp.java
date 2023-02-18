package com.hotel.logica ;
import java.sql.SQLException;

import javax.swing.*;

import com.hotel.interfaz.*;


public class InicioApp extends JFrame{
	private static final long serialVersionUID = 1209193303039116936L;
	
	public static void main(String[] args) throws SQLException {
		InicioVent app = new InicioVent();
		app.iniciar();
	}
}