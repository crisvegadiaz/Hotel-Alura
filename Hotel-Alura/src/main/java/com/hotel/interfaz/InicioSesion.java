package com.hotel.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.hotel.logica.ConexionSql;

public class InicioSesion extends Ventana implements ActionListener {
	private static final long serialVersionUID = 6631587754842786627L;
	private JLabel text1, text2, text3, imagen1, imagen2;
	private JSeparator separdor1, separdor2;
	private ImageIcon img1, img2;
	private JPasswordField password;
	private JTextField user;
	private JButton entrar;

	@Override
	public void AgregarElem() {
		this.user = new JTextField("Ingrese su nombre de usuario");
		this.text1 = new JLabel("INICIAR SESIÓN");
		this.text2 = new JLabel("USUARIO");
		this.text3 = new JLabel("CONTRASEÑA");
		this.entrar = new JButton("ENTRAR");
		this.imagen1 = new JLabel();
		this.imagen2 = new JLabel("", SwingConstants.CENTER);
		this.password = new JPasswordField("*******************");
		this.separdor1 = new JSeparator();
		this.separdor2 = new JSeparator();

		this.img1 = new ImageIcon(getClass().getResource("/img/lOGO-50PX.png"));
		this.img2 = new ImageIcon(getClass().getResource("/img/img-hotel-login-.png"));

		this.imagen1.setIcon(img1);
		this.imagen2.setIcon(img2);

		this.user.setBounds(60, 275, 250, 30);
		this.text1.setBounds(60, 150, 450, 30);
		this.text2.setBounds(60, 230, 350, 30);
		this.text3.setBounds(60, 355, 350, 30);
		this.entrar.setBounds(60, 460, 140, 50);
		this.imagen1.setBounds(60, 70, 50, 50);
		this.imagen2.setBounds(700, 0, 500, 595);
		this.password.setBounds(60, 390, 200, 30);
		this.separdor1.setBounds(60, 320, 400, 3);
		this.separdor2.setBounds(60, 425, 400, 3);

		this.user.setFont(new Font("Arial", Font.PLAIN, 15));
		this.text1.setFont(new Font("Arial", Font.BOLD, 25));
		this.text2.setFont(new Font("Arial", Font.BOLD, 20));
		this.text3.setFont(new Font("Arial", Font.BOLD, 20));
		this.entrar.setFont(new Font("Arial", Font.PLAIN, 20));
		this.password.setFont(new Font("Arial", Font.PLAIN, 15));

		this.separdor1.setBorder(BorderFactory.createLineBorder(super.colorBlue, 2));
		this.separdor2.setBorder(BorderFactory.createLineBorder(super.colorBlue, 2));

		this.user.setBorder(null);
		this.imagen2.setOpaque(true);
		this.password.setBorder(null);

		this.user.setForeground(super.colorGray);
		this.text1.setForeground(super.colorBlue);
		this.text2.setForeground(super.colorGray);
		this.text3.setForeground(super.colorGray);
		this.entrar.setForeground(super.colorWithe);
		this.entrar.setBackground(super.colorBlue);
		this.imagen2.setBackground(super.colorBlue);
		this.password.setForeground(super.colorGray);
		this.separdor1.setForeground(super.colorBlue);
		this.separdor2.setForeground(super.colorBlue);

		this.entrar.addActionListener(this);
		this.user.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (user.getText().equals("Ingrese su nombre de usuario")) {
					user.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (user.getText().equals("")) {
					user.setText("Ingrese su nombre de usuario");
				}
			}
		});
		this.password.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (new String(((JPasswordField) password).getPassword()).equals("*******************")) {
					password.setText("");
					((JPasswordField) password).setEchoChar('*');
				}
			}

			public void focusLost(FocusEvent e) {
				if (new String(((JPasswordField) password).getPassword()).equals("")) {
					((JPasswordField) password).setEchoChar((char) 0);
					password.setText("*******************");
				}
			}
		});

		this.add(this.user);
		this.add(this.text1);
		this.add(this.text2);
		this.add(this.text3);
		this.add(this.entrar);
		this.add(this.imagen1);
		this.add(this.imagen2);
		this.add(this.password);
		this.add(this.separdor1);
		this.add(this.separdor2);

		this.setTitle("Iniciar Sesión");
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		ConexionSql sql = new ConexionSql();
		
		if (e.getSource() == this.entrar) {
			if (this.user.getText().equals("Ingrese su nombre de usuario")) {
				this.text2.setText("Ingrese un nombre");
				this.text2.setForeground(colorRed);
				return;
			}else {
				this.text2.setText("USUARIO");
				this.text2.setForeground(colorGray);
			}
			
			if (this.password.getText().equals("*******************")) {
				this.text3.setText("Ingrese una clave");
				this.text3.setForeground(colorRed);
				return;
			}else {
				this.text3.setText("CONTRASEÑA");
				this.text3.setForeground(colorGray);
			}
			
			try {
				if(sql.validarCredencialesUsuario(sql.sqlConnec, this.user.getText(), this.password.getText())) {
					this.text1.setText("INICIAR SESIÓN");
					this.text1.setForeground(colorBlue);
					SistemaReserva reser = new SistemaReserva();
					reser.iniciar();
					this.setVisible(false);
					return;
				}else{
					this.text1.setText("El usuario o contraseña estan mal");
					this.text1.setForeground(colorRed);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
