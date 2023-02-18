package com.hotel.interfaz;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InicioVent extends Ventana implements ActionListener {
	private static final long serialVersionUID = 3685092767703461029L;
	private JLabel imagen1, imagen2, text1, text2;
	private JButton btnLogin,btnCerrar;
	private ImageIcon img1, img2, img3, img4;

	@Override
	public void AgregarElem() {
		this.text1 = new JLabel("LOGIN");
		this.text2 = new JLabel("Desarrollado por Cristian Diaz Vega en 2023", SwingConstants.CENTER);
		this.imagen1 = new JLabel();
		this.imagen2 = new JLabel();
		this.btnLogin = new JButton();
		this.btnCerrar = new JButton();

		this.img1 = new ImageIcon(getClass().getResource("/img/menu-img.png"));
		this.img2 = new ImageIcon(getClass().getResource("/img/aH-150px.png"));
		this.img3 = new ImageIcon(getClass().getResource("/img/login.png"));
		this.img4 = new ImageIcon(getClass().getResource("/img/cerrar-sesion 32-px.png"));

		this.imagen1.setIcon(img1);
		this.imagen2.setIcon(img2);
		this.btnLogin.setIcon(img3);
		this.btnCerrar.setIcon(img4);

		this.text1.setBounds(1010, 300, 70, 30);
		this.text2.setBounds(0, 530, 1200, 40);
		this.imagen1.setBounds(0, 0, 910, 539);
		this.imagen2.setBounds(970, 100, 150, 150);
		this.btnLogin.setBounds(1010, 350, 64, 64);
		this.btnCerrar.setBounds(1150, 490, 32, 32);

		this.text2.setOpaque(true);
		this.btnLogin.setBorder(null);
		this.btnLogin.setOpaque(true);
		this.btnCerrar.setBorder(null);
		this.btnCerrar.setOpaque(true);
		 
		this.text1.setForeground(super.colorBlue);
		this.text2.setForeground(super.colorWithe);
		this.text2.setBackground(super.colorBlue);
		this.btnLogin.setBackground(super.colorWithe);
		this.btnCerrar.setBackground(super.colorWithe);
		
		this.text1.setFont(new Font("Arial", Font.PLAIN, 20));
		this.text2.setFont(new Font("Arial", Font.PLAIN, 18));
		
		this.btnLogin.addActionListener(this);
		this.btnCerrar.addActionListener(this);
		
		this.add(this.text1);
		this.add(this.text2);
		this.add(this.imagen1);
		this.add(this.imagen2);
		this.add(this.btnLogin);
		this.add(this.btnCerrar);
		
		this.setTitle("Bienvenido al Hotel Alura");
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnLogin) {
			InicioSesion secion = new InicioSesion();
			secion.iniciar();
			this.setVisible(false);
		}
		if(e.getSource()==this.btnCerrar) {
			ConfirmarSalida con = new ConfirmarSalida();
			con.iniciar();
		}
	}
}
