package com.hotel.interfaz;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class Ventana extends JFrame{
	private static final long serialVersionUID = -3030099236595355215L;
	protected Color colorSkyBlue = new Color(118, 187, 223);
	protected Color colorWithe = new Color(255, 255, 255);
	protected Color colorBlue = new Color(12, 138, 199);
	protected Color colorGray = new Color(109, 109, 109);
	protected Color colorRed = new Color(238, 74, 77);
	protected Container fondo = this.getContentPane();

	public Ventana() {
		this.setLayout(null);
		this.AgregarElem();
		this.fondo.setBackground(this.colorWithe);
		this.setIconImage(this.getIconImage());
	}


	//Icono del JFrame
	@Override
	public Image getIconImage(){
		Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/aH-40px.png"));
		return retValue;
	}
	
	public void AgregarElem(){}
	
	public void iniciar() {
        this.setBounds(360,240,1200,600);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
