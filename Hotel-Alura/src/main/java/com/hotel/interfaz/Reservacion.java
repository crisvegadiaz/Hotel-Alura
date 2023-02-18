package com.hotel.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.hotel.logica.ConexionSql;
import com.toedter.calendar.JDateChooser;

public class Reservacion extends Ventana implements ActionListener {
	private static final long serialVersionUID = 7672840025434809031L;
	private JLabel text1, text2, text3, text4, text5, imagen1, imagen2;
	private JDateChooser calendari1, calendari2;
	private JComboBox<String> formaPago;
	private ImageIcon img1, img2, img3;
	private JButton siguiente;
	private JTextField pago;
	private JPanel panel;

	@Override
	public void AgregarElem() {
		this.pago = new JTextField();
		this.text1 = new JLabel("SISTEMA DE RESERVAS");
		this.text2 = new JLabel("FECHA DE CHECK IN ");
		this.text3 = new JLabel("FECHA DE CHECK OUT");
		this.text4 = new JLabel("VALOR DE LA RESERVA");
		this.text5 = new JLabel("FORMA DE PAGO");
		this.panel = new JPanel();
		this.imagen1 = new JLabel();
		this.imagen2 = new JLabel();
		this.formaPago = new JComboBox<String>();
		this.siguiente = new JButton("SIGUIENTE");
		this.calendari1 = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		this.calendari2 = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		
		this.formaPago.addItem("Tarjeta de Credito");
		this.formaPago.addItem("Tarjeta de Debito");
		this.formaPago.addItem("Efectivo");

		this.img1 = new ImageIcon(getClass().getResource("/img/Ha-100px.png"));
		this.img2 = new ImageIcon(getClass().getResource("/img/reservas-img-3.png"));
		this.img3 = new ImageIcon(getClass().getResource("/img/reservado.png"));

		this.imagen1.setIcon(img1);
		this.imagen2.setIcon(img2);
		this.calendari1.setIcon(img3);
		this.calendari2.setIcon(img3);
		
		this.pago.setForeground(super.colorGray);
		this.text1.setForeground(super.colorBlue);
		this.text2.setForeground(super.colorGray);
		this.text3.setForeground(super.colorGray);
		this.text4.setForeground(super.colorGray);
		this.text5.setForeground(super.colorGray);
		this.siguiente.setForeground(super.colorWithe);

		this.panel.setBackground(super.colorBlue);
		this.formaPago.setBackground(super.colorWithe);
		this.siguiente.setBackground(super.colorBlue);

		this.pago.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
		this.formaPago.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
		this.calendari1.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
		this.calendari2.setBorder(new MatteBorder(0, 0, 2, 0, super.colorBlue));
		
		this.pago.setFont(new Font("Arial", Font.PLAIN, 19));
		this.text1.setFont(new Font("Arial", Font.BOLD, 19));
		this.text2.setFont(new Font("Arial", Font.BOLD, 21));
		this.text3.setFont(new Font("Arial", Font.BOLD, 21));
		this.text4.setFont(new Font("Arial", Font.BOLD, 21));
		this.text5.setFont(new Font("Arial", Font.BOLD, 21));
		this.formaPago.setFont(new Font("Arial", Font.PLAIN, 15));
		this.siguiente.setFont(new Font("Arial", Font.PLAIN, 18));

		this.siguiente.addActionListener(this);

		GroupLayout elementosPanel = new GroupLayout(this.panel);
		this.panel.setLayout(elementosPanel);
		elementosPanel.setHorizontalGroup(elementosPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(elementosPanel.createSequentialGroup()
						.addGroup(elementosPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(elementosPanel.createSequentialGroup()
										.addGap(325, 325, 325)
										.addComponent(this.imagen1))
								.addGroup(elementosPanel.createSequentialGroup()
										.addGap(135, 135, 135)
										.addComponent(this.imagen2)))
						.addContainerGap(391, Short.MAX_VALUE)));

		elementosPanel.setVerticalGroup(elementosPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(elementosPanel.createSequentialGroup()
						.addGroup(elementosPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(elementosPanel.createSequentialGroup()
										.addGap(70, 70, 70)
										.addComponent(this.imagen1))
								.addGroup(elementosPanel.createSequentialGroup()
										.addGap(110, 110, 110)
										.addComponent(this.imagen2)))
						.addContainerGap(40, Short.MAX_VALUE)));

		this.panel.setBounds(450, 0, 750, 600);
		this.pago.setBounds(70, 350, 280, 30);
		this.text1.setBounds(110, 75, 250, 30);
		this.text2.setBounds(70, 140, 250, 30);
		this.text3.setBounds(70, 225, 250, 30);
		this.text4.setBounds(70, 310, 250, 30);
		this.text5.setBounds(70, 395, 250, 30);
		this.formaPago.setBounds(70, 430, 280, 30);
		this.siguiente.setBounds(222, 500, 130, 35);
		this.calendari1.setBounds(70, 175, 280, 30);
		this.calendari2.setBounds(70, 260, 280, 30);

		this.add(this.panel);
		this.add(this.text1);
		this.add(this.text2);
		this.add(this.text3);
		this.add(this.text4);
		this.add(this.text5);
		this.add(this.pago);
		this.add(this.imagen1);
		this.add(this.imagen2);
		this.add(this.siguiente);
		this.add(this.formaPago);
		this.add(this.calendari1);
		this.add(this.calendari2);

		this.setTitle("RESERVACIONES");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.siguiente) {
			
			if (this.calendari1.getDate() == null) {
				this.text2.setText("INGRESE UNA FECHA");
				this.text2.setForeground(super.colorRed);
				return;
			} else {
				this.text2.setText("FECHA DE CHECK IN");
				this.text2.setForeground(super.colorGray);
			}
			if (this.calendari2.getDate() == null) {
				this.text3.setText("INGRESE UNA FECHA");
				this.text3.setForeground(super.colorRed);
				return;
			} else {
				this.text3.setText("FECHA DE CHECK OUT");
				this.text3.setForeground(super.colorGray);
			}
			if (this.pago.getText().equals("")) {
				this.text4.setText("Ingrese el pago");
				this.text4.setForeground(super.colorRed);
				return;
			} else {
				this.text4.setText("VALOR DE LA RESERVA");
				this.text4.setForeground(super.colorGray);
			}

			Pattern regular = Pattern.compile("^[0-9]+$");
			Matcher matcher = regular.matcher(this.pago.getText());
			if (!matcher.matches()) {
			   this.text4.setText("Solo se permiten números");
			   this.text4.setForeground(super.colorRed);
			   return;
			}
			
			int year1 = this.calendari1.getCalendar().get(Calendar.YEAR);
            int month1 = this.calendari1.getCalendar().get(Calendar.MONTH);
            int day1 = this.calendari1.getCalendar().get(Calendar.DAY_OF_MONTH);

			int year2 = this.calendari2.getCalendar().get(Calendar.YEAR);
            int month2 = this.calendari2.getCalendar().get(Calendar.MONTH);
            int day2 = this.calendari2.getCalendar().get(Calendar.DAY_OF_MONTH);
			
            String fecha1 = year1 + "-" + (month1 + 1) + "-" + day1;
            String fecha2 = year2 + "-" + (month2 + 1) + "-" + day2;
			Float pago= Float.parseFloat(this.pago.getText());
			String formarPago= this.formaPago.getSelectedItem().toString();

			System.out.println(fecha1);
			System.out.println(fecha2);
			System.out.println(pago);
			System.out.println(formarPago);
			ConexionSql sql = new ConexionSql();
			sql.reservacionSql(fecha1, fecha2, pago, formarPago);

			RegistroHuesped hues = new RegistroHuesped();
			hues.iniciar();
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		Reservacion n = new Reservacion();
		n.iniciar();
	}
}
