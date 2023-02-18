package com.hotel.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class SistemaReserva extends Ventana implements ActionListener {
	private static final long serialVersionUID = -6870755539190964385L;
	private JLabel text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, logo;
	private ImageIcon img1, img2, img3, img4;
	private JButton registro, busqueda, flecha;
	private JPanel panel1, panel2;
	private JSeparator separador;
	private LocalDate fechaHoy;

	@Override
	public void AgregarElem() {

		this.fechaHoy = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String nuevoFormato = fechaHoy.format(formatter);

		this.logo = new JLabel();
		this.text1 = new JLabel("Sistema de reservas Hotel Alura");
		this.text2 = new JLabel("Hoy es " + nuevoFormato);
		this.text3 = new JLabel("Bienvenido");
		this.text4 = new JLabel("Sistema de reserva de hotel Controle y administre de forma óptima y fácil ");
		this.text5 = new JLabel("el flujo de reservas y de huespédes del hotel.");
		this.text6 = new JLabel("Este herramienta le permitirá llevar un control completo y detallado de sus");
		this.text7 = new JLabel("reservas y huéspedes, tendrá acceso a heramientas especiales para tareas");
		this.text8 = new JLabel("especificas como lo son:");
		this.text9 = new JLabel("- Registro de Reservas y Huéspedes");
		this.text10 = new JLabel("- Edición de Reservas y Huéspedes existentes");
		this.text11 = new JLabel("- Eliminar todo tipo de regSistema de reserva de hotelistros");
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		this.flecha = new JButton("Retroceder");
		this.registro = new JButton("Registro de reservas");
		this.busqueda = new JButton("Búsqueda");
		this.separador = new JSeparator();

		this.img1 = new ImageIcon(getClass().getResource("/img/aH-150px.png"));
		this.img2 = new ImageIcon(getClass().getResource("/img/reservado.png"));
		this.img3 = new ImageIcon(getClass().getResource("/img/pessoas.png"));
		this.img4 = new ImageIcon(getClass().getResource("/img/Flecha.png"));

		this.logo.setIcon(img1);
		this.flecha.setIcon(img4);
		this.registro.setIcon(img2);
		this.busqueda.setIcon(img3);
		this.flecha.setBorder(null);
		this.registro.setBorder(null);
		this.busqueda.setBorder(null);

		this.text1.setForeground(super.colorWithe);
		this.text2.setForeground(super.colorWithe);
		this.flecha.setForeground(super.colorWithe);
		this.registro.setForeground(super.colorWithe);
		this.busqueda.setForeground(super.colorWithe);

		this.panel1.setBackground(super.colorBlue);
		this.panel2.setBackground(super.colorSkyBlue);
		this.flecha.setBackground(super.colorBlue);
		this.registro.setBackground(super.colorBlue);
		this.busqueda.setBackground(super.colorBlue);

		this.flecha.addActionListener(this);
		this.registro.addActionListener(this);
		this.busqueda.addActionListener(this);

		this.text1.setFont(new Font("Arial", Font.PLAIN, 25));
		this.text2.setFont(new Font("Arial", Font.PLAIN, 32));
		this.text3.setFont(new Font("Arial", Font.BOLD, 28));
		this.text4.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text5.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text6.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text6.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text6.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text7.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text8.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text9.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text10.setFont(new Font("Arial", Font.PLAIN, 16));
		this.text11.setFont(new Font("Arial", Font.PLAIN, 16));
		this.flecha.setFont(new Font("Arial", Font.PLAIN, 18));
		this.registro.setFont(new Font("Arial", Font.PLAIN, 18));
		this.busqueda.setFont(new Font("Arial", Font.PLAIN, 18));

		GroupLayout elementosPanel1 = new GroupLayout(this.panel1);
		this.panel1.setLayout(elementosPanel1);
		elementosPanel1.setHorizontalGroup(elementosPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(elementosPanel1.createSequentialGroup()
						.addGroup(elementosPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(60, 60, 60)
										.addComponent(this.logo))
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(40, 40, 40)
										.addComponent(this.separador))
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(40, 40, 40)
										.addComponent(this.registro))
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(40, 40, 40)
										.addComponent(this.busqueda))
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(40, 40, 40)
										.addComponent(this.flecha)))
						.addContainerGap(100, Short.MAX_VALUE)));

		elementosPanel1.setVerticalGroup(elementosPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(elementosPanel1.createSequentialGroup()
						.addGroup(elementosPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(60, 60, 60)
										.addComponent(this.logo))
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(220, 220, 220)
										.addComponent(this.separador))
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(300, 300, 300)
										.addComponent(this.registro))
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(360, 360, 360)
										.addComponent(this.busqueda))
								.addGroup(elementosPanel1.createSequentialGroup()
										.addGap(420, 420, 420)
										.addComponent(this.flecha)))
						.addContainerGap(400, Short.MAX_VALUE)));

		GroupLayout elementosPanel2 = new GroupLayout(this.panel2);
		this.panel2.setLayout(elementosPanel2);
		elementosPanel2.setHorizontalGroup(elementosPanel2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(elementosPanel2.createSequentialGroup()
						.addGroup(elementosPanel2.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(elementosPanel2.createSequentialGroup()
										.addGap(200, 200, 200)
										.addComponent(this.text1))
								.addGroup(elementosPanel2.createSequentialGroup()
										.addGap(50, 50, 50)
										.addComponent(this.text2)))
						.addContainerGap(391, Short.MAX_VALUE)));

		elementosPanel2.setVerticalGroup(elementosPanel2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(elementosPanel2.createSequentialGroup()
						.addGroup(elementosPanel2.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(elementosPanel2.createSequentialGroup()
										.addGap(10, 10, 10)
										.addComponent(this.text1))
								.addGroup(elementosPanel2.createSequentialGroup()
										.addGap(60, 60, 60)
										.addComponent(this.text2)))
						.addContainerGap(40, Short.MAX_VALUE)));

		this.text3.setBounds(350, 250, 200, 30);
		this.text4.setBounds(360, 300, 700, 40);
		this.text5.setBounds(360, 325, 700, 40);
		this.text6.setBounds(360, 375, 700, 40);
		this.text7.setBounds(360, 400, 700, 40);
		this.text8.setBounds(360, 425, 700, 40);
		this.text9.setBounds(360, 475, 700, 40);
		this.text10.setBounds(360, 525, 700, 40);
		this.text11.setBounds(360, 575, 700, 40);
		this.panel1.setBounds(0, 0, 300, 800);
		this.panel2.setBounds(300, 80, 800, 120);

		this.add(this.logo);
		this.add(this.text1);
		this.add(this.text2);
		this.add(this.text3);
		this.add(this.text4);
		this.add(this.text5);
		this.add(this.text6);
		this.add(this.text7);
		this.add(this.text8);
		this.add(this.text9);
		this.add(this.text10);
		this.add(this.text11);
		this.add(this.panel1);
		this.add(this.panel2);
		this.add(this.flecha);
		this.add(this.registro);
		this.add(this.busqueda);
		this.add(this.separador);

		this.setTitle("SISTEMA DE RESERVAS");
	}

	@Override
	public void iniciar() {
		super.setBounds(500, 200, 1100, 700);
		super.setResizable(false);
		super.setVisible(true);
		super.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.registro) {
			Reservacion reser = new Reservacion();
			reser.iniciar();
			this.setVisible(false);
		}
		if (e.getSource() == this.busqueda) {
			SistemaDeBusqueda buscar = new SistemaDeBusqueda();
			buscar.iniciar();
			this.setVisible(false);
		}
		if (e.getSource() == this.flecha) {
			InicioSesion sesion = new InicioSesion();
			sesion.iniciar();
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		SistemaReserva n = new SistemaReserva();
		n.iniciar();
	}

}
